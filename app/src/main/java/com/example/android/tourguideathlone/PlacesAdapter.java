package com.example.android.tourguideathlone;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.ArrayList;

public class PlacesAdapter extends ArrayAdapter<Places> {

    private static final String LOG_TAG = PlacesAdapter.class.getSimpleName();

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link PlacesAdapter} object.
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Places}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public PlacesAdapter(Context context, ArrayList<Places> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Place} object located at this position in the list
        Places currentPlace = getItem(position);

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Set the correct image to the relevant list item position.
        imageView.setImageResource(currentPlace.getImageResourceId());

        // Find the TextView in the list_item.xml layout
        TextView placeNameTextView = (TextView) listItemView.findViewById(R.id.place_name);
        // Get the version name from the current Places object and
        // set this text on the name TextView
        placeNameTextView.setText(currentPlace.getLocationName());

        TextView placeDescriptionTextView = (TextView) listItemView.findViewById(R.id.place_description);
        placeDescriptionTextView.setText(currentPlace.getLocationDescription());

        TextView placePriceTextView = (TextView) listItemView.findViewById(R.id.place_price);
        placePriceTextView.setText(currentPlace.getLocationPrice());

        // Find the rating bar in the list_item.xml layout
        RatingBar placeRatingBar = (RatingBar) listItemView.findViewById(R.id.place_ratingBar);
        // Set the number of stars on the rating bar based on the list items position.
        placeRatingBar.setNumStars((int) currentPlace.getLocationRating());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
