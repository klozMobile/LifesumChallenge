package com.example.lifesum;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lifesum.model.Food;

/**
 * Displays nutritional information for a given food
 * @author cramos
 *
 */
public class DetailsFragment extends Fragment {
	
	private Food mFood;
	private Long id = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_details, container, false);
		TextView tvTitle = (TextView) rootView.findViewById(R.id.tv_title);
		tvTitle.setText(mFood.getTitle());
		TextView tvBrand = (TextView) rootView.findViewById(R.id.tv_brand);
		tvBrand.setText(mFood.getBrand());
		
		TextView tvCalories = (TextView) rootView.findViewById(R.id.tv_calories);
		tvCalories.setText(String.valueOf(mFood.getCalories()));
		
		TextView tvCarbohydrates = (TextView) rootView.findViewById(R.id.tv_carbohydrates);
		tvCarbohydrates.setText(String.valueOf(mFood.getCarbohydrates()));
		
		TextView tvCholesterol = (TextView) rootView.findViewById(R.id.tv_cholesterol);
		tvCholesterol.setText(String.valueOf(mFood.getCholesterol()));
		
		TextView tvFiber = (TextView) rootView.findViewById(R.id.tv_fiber);
		tvFiber.setText(String.valueOf(mFood.getFiber()));
		
		TextView tvFat = (TextView) rootView.findViewById(R.id.tv_fat);
		tvFat.setText(String.valueOf(mFood.getFat()));
		
		TextView tvPotassium = (TextView) rootView.findViewById(R.id.tv_potassium);
		tvPotassium.setText(String.valueOf(mFood.getPotassium()));
		
		TextView tvProtein = (TextView) rootView.findViewById(R.id.tv_protein);
		tvProtein.setText(String.valueOf(mFood.getProtein()));
		
		TextView tvSodium = (TextView) rootView.findViewById(R.id.tv_sodium);
		tvSodium.setText(String.valueOf(mFood.getSodium()));
		
		TextView tvSugar = (TextView) rootView.findViewById(R.id.tv_sugar);
		tvSugar.setText(String.valueOf(mFood.getSugar()));
		
		// adding a click listener, which will save this food in user's list
		Button btnSave = (Button) rootView.findViewById(R.id.btn_save);
		btnSave.setOnClickListener(onClickListenerSave);
		return rootView;
	}

	/**
	 * Creates a new instance of DetailsFragment
	 * @param food Object with data to be shown in frgament
	 * @return the new instance
	 */
	public static DetailsFragment newInstance(Food food) {
		DetailsFragment f = new DetailsFragment();
		f.mFood = food.withFoodId(food.getId());
		return f;
	}

	/**
	 * Click listener which saves data 
	 */
	private OnClickListener onClickListenerSave = new OnClickListener() {

		@Override
		public void onClick(View v) {
			SaveTask saveTask = new SaveTask();
			saveTask.execute(mFood);
		}
	};

	/**
	 * Async Task which shows a progress dialog while saves data into database 
	 * @author cramos
	 *
	 */
	class SaveTask extends AsyncTask<Food, Void, Void> {

		private ProgressDialog dialog;

		@Override
		protected Void doInBackground(Food... params) {
			// Saving data into database
			params[0].withId(id).save();
			id = params[0].getId();
			return null;
		}
		
		@Override
		protected void onPreExecute() {
			// Adding a busy dialog
			dialog = new ProgressDialog(getActivity());
			dialog.setIndeterminate(true);
			dialog.setCancelable(false);
			dialog.setInverseBackgroundForced(false);
			dialog.setCanceledOnTouchOutside(true);
			dialog.setTitle(R.string.saving);
			// we show the dialog
			dialog.show();
	    }

		@Override
		protected void onProgressUpdate(Void... param) {
		}

		@Override
		protected void onPostExecute(Void param) {
			dialog.dismiss();
		}
	}

}
