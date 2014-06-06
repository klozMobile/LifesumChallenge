package com.example.lifesum;

import com.example.lifesum.model.Food;

/**
 * A callback interface that all activities containing this fragment must
 * implement. This mechanism allows activities to be notified of item
 * selections.
 */
public interface FoodListCallbacks {
	void onFoodSelected(Food food);
}