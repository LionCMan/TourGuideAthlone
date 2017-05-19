package com.example.android.tourguideathlone;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccommodationFragment extends Fragment {

    Intent browser = new Intent(Intent.ACTION_VIEW);
    String url0 = "https://www.hodsonbayhotel.com/";
    String url1 = "https://www.radissonblu.com/en/hotel-athlone";
    String url2 = "http://shelmalierhouse.com/";
    String url3 = "http://www.galeybaycamping.ie/";

    public AccommodationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of words
        final ArrayList<Places> places = new ArrayList<Places>();
        places.add(new Places(R.drawable.stay_image_hodson,getString(R.string.stay_name_hodson),
                getString(R.string.stay_description_hodson),getString(R.string.stay_price_hodson),
                4));
        places.add(new Places(R.drawable.stay_image_blu,getString(R.string.stay_name_blu),
                getString(R.string.stay_description_blu),getString(R.string.stay_price_blu),4));
        places.add(new Places(R.drawable.stay_image_bandb,getString(R.string.stay_name_bandb),
                getString(R.string.stay_description_bandb),getString(R.string.stay_price_bandb),4.5));
        places.add(new Places(R.drawable.stay_image_bay,getString(R.string.stay_name_bay),
                getString(R.string.stay_description_bay),getString(R.string.stay_price_bay),2.5));

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

        // Set a click listener to open accommodation web page when the list item is clicked on
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

