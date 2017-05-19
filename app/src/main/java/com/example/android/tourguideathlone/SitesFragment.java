package com.example.android.tourguideathlone;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SitesFragment extends Fragment {

    Intent browser = new Intent(Intent.ACTION_VIEW);
    String url0 = "http://www.sspeterandpaulsparishathlone.com/";
    String url1 = "http://www.athlone.ie/visit/castle-athlone/";
    String url2 = "http://www.athloneartsandtourism.ie/luan-gallery";
    String url3 = "http://www.dunnasi.ie/amenity-park/amenity-park";

    public SitesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of places
        final ArrayList<Places> places = new ArrayList<Places>();
        places.add(new Places(R.drawable.sites_image_church,getString(R.string.sites_name_church),
                getString(R.string.sites_description_church),getString(R.string.price_free),4.5));
        places.add(new Places(R.drawable.sites_image_castle,getString((R.string.sites_name_castle))
                ,getString(R.string.sites_description_castle),getString(R.string.sites_price_castle)
                ,5));
        places.add(new Places(R.drawable.sites_image_gallery,getString(R.string.sites_name_gallery),
                getString(R.string.sites_description_gallery),getString(R.string.price_free), 4.5));
        places.add(new Places(R.drawable.sites_image_park, getString(R.string.sites_name_park)
                ,getString(R.string.sites_description_park),getString(R.string.price_free),4));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.
        PlacesAdapter adapter = new PlacesAdapter(getActivity(), places, R.color.category_card);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch(position){
                    case 0:
                        browser.setData(Uri.parse(url0));
                        break;
                    case 1:
                        browser.setData(Uri.parse(url1));
                        break;
                    case 2:
                        browser.setData(Uri.parse(url2));
                        break;
                    case 3:
                        browser.setData(Uri.parse(url3));
                        break;
                }
                startActivity(browser);
            }
        });
        return rootView;
    }
}
