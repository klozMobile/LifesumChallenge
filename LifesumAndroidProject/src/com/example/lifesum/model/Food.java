
package com.example.lifesum.model;

import com.google.gson.annotations.Expose;
import com.orm.SugarRecord;

public class Food extends SugarRecord<Food>{
	
	private Long foodId;

	public Long getFoodId() {
		return foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}
	
	public Food withFoodId(Long foodId) {
        this.foodId = foodId;
        return this;
    }

	@Expose
    private int categoryid;
    @Expose
    private float fiber;
    @Expose
    private String headimage;
    @Expose
    private float pcsingram;
    @Expose
    private String brand;
    @Expose
    private float unsaturatedfat;
    @Expose
    private float fat;
    @Expose
    private int servingcategory;
    @Expose
    private int typeofmeasurement;
    @Expose
    private float protein;
    @Expose
    private int defaultserving;
    @Expose
    private float mlingram;
    @Expose
    private float saturatedfat;
    @Expose
    private String category;
    @Expose
    private boolean verified;
    @Expose
    private String title;
    @Expose
    private String pcstext;
    @Expose
    private float sodium;
    @Expose
    private float carbohydrates;
    @Expose
    private int showonlysametype;
    @Expose
    private int calories;
    @Expose
    private int serving_version;
    @Expose
    private float sugar;
    @Expose
    private int measurementid;
    @Expose
    private float cholesterol;
    @Expose
    private float gramsperserving;
    @Expose
    private int showmeasurement;
    @Expose
    private float potassium;

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public Food withCategoryid(int categoryid) {
        this.categoryid = categoryid;
        return this;
    }

    public float getFiber() {
        return fiber;
    }

    public void setFiber(float fiber) {
        this.fiber = fiber;
    }

    public Food withFiber(float fiber) {
        this.fiber = fiber;
        return this;
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }

    public Food withHeadimage(String headimage) {
        this.headimage = headimage;
        return this;
    }

    public float getPcsingram() {
        return pcsingram;
    }

    public void setPcsingram(float pcsingram) {
        this.pcsingram = pcsingram;
    }

    public Food withPcsingram(float pcsingram) {
        this.pcsingram = pcsingram;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Food withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public float getUnsaturatedfat() {
        return unsaturatedfat;
    }

    public void setUnsaturatedfat(float unsaturatedfat) {
        this.unsaturatedfat = unsaturatedfat;
    }

    public Food withUnsaturatedfat(float unsaturatedfat) {
        this.unsaturatedfat = unsaturatedfat;
        return this;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public Food withFat(float fat) {
        this.fat = fat;
        return this;
    }

    public int getServingcategory() {
        return servingcategory;
    }

    public void setServingcategory(int servingcategory) {
        this.servingcategory = servingcategory;
    }

    public Food withServingcategory(int servingcategory) {
        this.servingcategory = servingcategory;
        return this;
    }

    public int getTypeofmeasurement() {
        return typeofmeasurement;
    }

    public void setTypeofmeasurement(int typeofmeasurement) {
        this.typeofmeasurement = typeofmeasurement;
    }

    public Food withTypeofmeasurement(int typeofmeasurement) {
        this.typeofmeasurement = typeofmeasurement;
        return this;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public Food withProtein(float protein) {
        this.protein = protein;
        return this;
    }

    public int getDefaultserving() {
        return defaultserving;
    }

    public void setDefaultserving(int defaultserving) {
        this.defaultserving = defaultserving;
    }

    public Food withDefaultserving(int defaultserving) {
        this.defaultserving = defaultserving;
        return this;
    }

    public float getMlingram() {
        return mlingram;
    }

    public void setMlingram(float mlingram) {
        this.mlingram = mlingram;
    }

    public Food withMlingram(float mlingram) {
        this.mlingram = mlingram;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Food withId(Long id) {
        this.id = id;
        return this;
    }

    public float getSaturatedfat() {
        return saturatedfat;
    }

    public void setSaturatedfat(float saturatedfat) {
        this.saturatedfat = saturatedfat;
    }

    public Food withSaturatedfat(float saturatedfat) {
        this.saturatedfat = saturatedfat;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Food withCategory(String category) {
        this.category = category;
        return this;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Food withVerified(boolean verified) {
        this.verified = verified;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Food withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPcstext() {
        return pcstext;
    }

    public void setPcstext(String pcstext) {
        this.pcstext = pcstext;
    }

    public Food withPcstext(String pcstext) {
        this.pcstext = pcstext;
        return this;
    }

    public float getSodium() {
        return sodium;
    }

    public void setSodium(float sodium) {
        this.sodium = sodium;
    }

    public Food withSodium(float sodium) {
        this.sodium = sodium;
        return this;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Food withCarbohydrates(float carbohydrates) {
        this.carbohydrates = carbohydrates;
        return this;
    }

    public int getShowonlysametype() {
        return showonlysametype;
    }

    public void setShowonlysametype(int showonlysametype) {
        this.showonlysametype = showonlysametype;
    }

    public Food withShowonlysametype(int showonlysametype) {
        this.showonlysametype = showonlysametype;
        return this;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Food withCalories(int calories) {
        this.calories = calories;
        return this;
    }

    public int getServing_version() {
        return serving_version;
    }

    public void setServing_version(int serving_version) {
        this.serving_version = serving_version;
    }

    public Food withServing_version(int serving_version) {
        this.serving_version = serving_version;
        return this;
    }

    public float getSugar() {
        return sugar;
    }

    public void setSugar(float sugar) {
        this.sugar = sugar;
    }

    public Food withSugar(float sugar) {
        this.sugar = sugar;
        return this;
    }

    public int getMeasurementid() {
        return measurementid;
    }

    public void setMeasurementid(int measurementid) {
        this.measurementid = measurementid;
    }

    public Food withMeasurementid(int measurementid) {
        this.measurementid = measurementid;
        return this;
    }

    public float getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(float cholesterol) {
        this.cholesterol = cholesterol;
    }

    public Food withCholesterol(float cholesterol) {
        this.cholesterol = cholesterol;
        return this;
    }

    public float getGramsperserving() {
        return gramsperserving;
    }

    public void setGramsperserving(float gramsperserving) {
        this.gramsperserving = gramsperserving;
    }

    public Food withGramsperserving(float gramsperserving) {
        this.gramsperserving = gramsperserving;
        return this;
    }

    public int getShowmeasurement() {
        return showmeasurement;
    }

    public void setShowmeasurement(int showmeasurement) {
        this.showmeasurement = showmeasurement;
    }

    public Food withShowmeasurement(int showmeasurement) {
        this.showmeasurement = showmeasurement;
        return this;
    }

    public float getPotassium() {
        return potassium;
    }

    public void setPotassium(float potassium) {
        this.potassium = potassium;
    }

    public Food withPotassium(float potassium) {
        this.potassium = potassium;
        return this;
    }

}
