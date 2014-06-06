package com.example.lifesum;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lifesum.adapters.FoodListAdapter;
import com.example.lifesum.model.Food;
import com.orm.query.Select;

public class MyFoodListFragment extends ListFragment {
	/**
	 * The fragment's current callback object, which is notified of list item
	 * clicks.
	 */
	private FoodListCallbacks mCallbacks = sDummyCallbacks;

	/**
	 * A dummy implementation of the {@link FoodListCallbacks} interface that
	 * does nothing. Used only when this fragment is not attached to an
	 * activity.
	 */
	private static FoodListCallbacks sDummyCallbacks = new FoodListCallbacks() {
		@Override
		public void onFoodSelected(Food food) {
		}
	};

	private FoodListAdapter mFoodListAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/** Creating an array adapter to store the list of countries **/
		List<Food> list = Select.from(Food.class).orderBy("title").list();

		/** Setting the list adapter for the ListFragment */
		mFoodListAdapter = new FoodListAdapter(getActivity(),
				R.layout.food_item);
		mFoodListAdapter.supporAddAll(list);
		setListAdapter(mFoodListAdapter);

		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// Activities containing this fragment must implement its callbacks.
		if (!(activity instanceof FoodListCallbacks)) {
			throw new IllegalStateException(
					"Activity must implement fragment's callbacks.");
		}
		mCallbacks = (FoodListCallbacks) activity;
		((MainActivity) activity).onSectionAttached(2);
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

}
