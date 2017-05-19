package com.example.android.tourguideathlone;

/**
 * {@link Places} represents a location that the user wants to learn more about.
 */

public class Places {

    /** Image resource ID for the place */
    private int mImageResourceId;

    /** Name of the place */
    private String mLocationName;

    /** Description of the place */
    private String mLocationDescription;

    /** Cost of service at the place */
    private String mLocationPrice;

    /** Rating of the place */
    private double mLocationRating;

    /**
     * Create a new Places object
     * @param imageResourceId is the accompanying image for the location
     * @param locationName is the name of the location
     * @param locationDescription is the description of the place
     * @param locationPrice is the cost of attending at the place
     * @param locationRating is the rating of the place
     */
    public Places(int imageResourceId, String locationName, String locationDescription,
                  String locationPrice, double locationRating) {
        mImageResourceId = imageResourceId;
        mLocationName = locationName;
        mLocationDescription = locationDescription;
        mLocationPrice = locationPrice;
        mLocationRating = locationRating;
    }

    /**
     * Return the image resource ID of the place.
     */
    public int getImageResourceId() { return mImageResourceId; }

    /**
     * Get the name of the place.
     */
    public String getLocationName() { return mLocationName; }

    /**
     * Get the description of the place.
     */
    public String getLocationDescription() { return mLocationDescription; }

    /**
     * Get the price of attending at the place.
     */
    public String getLocationPrice() { return mLocationPrice; }

    /**
     * Get the price of attending at the place.
     */
    public double getLocationRating() { return mLocationRating; }
}
