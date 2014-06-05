package com.example.lifesum;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.callback.Transformer;
import com.example.lifesum.adapters.FoodListAdapter;
import com.example.lifesum.model.Food;
import com.example.lifesum.model.ResponseTO;
import com.google.gson.Gson;

public class SearchFragment extends ListFragment {

	/**
	 * The AQuery instance, which is used for search
	 */
	private AQuery aq;

	/**
	 * EditText instance, which has user's query.
	 */
	private EditText etSearch;

	/**
	 * FoodListAdapter instance, which receives response from web
	 */
	private FoodListAdapter mFoodListAdapter;
	/**
	 * The fragment's current callback object, which is notified of list item
	 * clicks.
	 */

	private Callbacks mCallbacks = sDummyCallbacks;

	/**
	 * A callback interface that all activities containing this fragment must
	 * implement. This mechanism allows activities to be notified of item
	 * selections.
	 */
	public interface Callbacks {
		void onFoodSelected(Food food);
	}

	/**
	 * A dummy implementation of the {@link Callbacks} interface that does
	 * nothing. Used only when this fragment is not attached to an activity.
	 */
	private static Callbacks sDummyCallbacks = new Callbacks() {
		@Override
		public void onFoodSelected(Food food) {
		}
	};

	public SearchFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_search, container,
				false);
		// creating the AQuery instance
		aq = new AQuery(getActivity(), rootView);

		// adding a click listener, which will launch a connection to URL
		Button btnSearch = (Button) rootView.findViewById(R.id.btn_search);
		btnSearch.setOnClickListener(onClickListenerSearch);

		// Setting EditText reference
		etSearch = (EditText) rootView.findViewById(R.id.et_search);

		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		// Activities containing this fragment must implement its callbacks.
		if (!(activity instanceof Callbacks)) {
			throw new IllegalStateException(
					"Activity must implement fragment's callbacks.");
		}
		((MainActivity) activity).onSectionAttached(1);

		mCallbacks = (Callbacks) activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();

		// Reset the active callbacks interface to the dummy implementation.
		mCallbacks = sDummyCallbacks;
	}

	@Override
	public void onListItemClick(ListView listView, View view, int position,
			long id) {
		super.onListItemClick(listView, view, position, id);

		// Notify the active callbacks interface (the activity, if the
		// fragment is attached to one) that an item has been selected.
		mCallbacks.onFoodSelected(mFoodListAdapter.getItem(position));
	}

	/**
	 * Makes a search to URL
	 */
	private void doRequest() {
		if (mFoodListAdapter == null) {
			mFoodListAdapter = new FoodListAdapter(getActivity(),
					R.layout.food_item);
			setListAdapter(mFoodListAdapter);
		}
		// Clear previous result
		mFoodListAdapter.clear();
		
		// Adding a busy dialog
		ProgressDialog dialog = new ProgressDialog(getActivity());
		dialog.setIndeterminate(true);
		dialog.setCancelable(true);
		dialog.setInverseBackgroundForced(false);
		dialog.setCanceledOnTouchOutside(true);
		dialog.setTitle(R.string.searching);

		// appending text from EditText to the url for query
		String url = "https://api.lifesum.com/v1/search/query?type=food&search="
				+ Uri.parse(etSearch.getText().toString());

		mAjaxCallback
				.header("Authorization",
						"a794ecd348a3f71894426c65c37fea35da89a295bcbad687ca68a96fbfc7d371");

		GsonTransformer t = new GsonTransformer();

		// return a cached copy if the data is recently fetched within 15
		// minutes
		long expire = 15 * 60 * 1000;

		aq.transformer(t).progress(dialog)
				.ajax(url, ResponseTO.class, expire, mAjaxCallback);
	}

	/**
	 * Callback Object, which receives server response
	 */
	private AjaxCallback<ResponseTO> mAjaxCallback = new AjaxCallback<ResponseTO>() {

		@Override
		public void callback(String url, ResponseTO response, AjaxStatus status) {
			if (response != null) {
				mFoodListAdapter.supporAddAll(response.getResponse().getList());
			} else {
				// we believe the request is a failure, don't cache it
				status.invalidate();
			}

		}

	};

	/**
	 * Click listener which makes requests to server
	 */
	private OnClickListener onClickListenerSearch = new OnClickListener() {

		@Override
		public void onClick(View v) {

			doRequest();

		}
	};

	/**
	 * 
	 * A transformer which returns an object from Json response
	 * 
	 */
	private static class GsonTransformer implements Transformer {

		public <T> T transform(String url, Class<T> type, String encoding,
				byte[] data, AjaxStatus status) {
			Gson g = new Gson();
			return g.fromJson(new String(data), type);
		}
	}

}
