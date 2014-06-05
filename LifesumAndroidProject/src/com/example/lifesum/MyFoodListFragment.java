package com.example.lifesum;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lifesum.adapters.FoodListAdapter;
import com.example.lifesum.model.Food;
import com.orm.query.Select;

public class MyFoodListFragment extends ListFragment {
	
	private FoodListAdapter mFoodListAdapter;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        /** Creating an array adapter to store the list of countries **/
		List<Food> list = Select.from(Food.class).orderBy("title").list();
 
        /** Setting the list adapter for the ListFragment */
		mFoodListAdapter = new FoodListAdapter(getActivity(), R.layout.food_item);
		mFoodListAdapter.supporAddAll(list);
        setListAdapter(mFoodListAdapter);        
 
        return super.onCreateView(inflater, container, savedInstanceState);
    }
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(2);
	}

}
