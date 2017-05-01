package com.kris.myouseum.fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kris.myouseum.R;
import com.kris.myouseum.dto.Exhibit;
import com.kris.myouseum.utils.Constants;
import com.kris.myouseum.utils.ExhibitInterface;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class ExhibitFragment extends Fragment {

    private Exhibit exhibit;
    private ExhibitInterface mCallback;

    public ExhibitFragment() {}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mCallback = (ExhibitInterface) context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_exhibit, container, false);

        ButterKnife.bind(this, v);

        Bundle bundle = this.getArguments();

        if(bundle.get(Constants.EXHIBIT_OBJECT) != null){
            exhibit = (Exhibit) bundle.get(Constants.EXHIBIT_OBJECT);
            populateDetails(exhibit, v);
        }

        return v;
    }

    public void populateDetails(Exhibit e, View v){

        TextView textView = (TextView) v.findViewById(R.id.main_title);
        textView.setText(e.getArtifactName() + "(" + e.getTitle() + ")");

        TextView textView1 = (TextView) v.findViewById(R.id.main_description);
        textView1.setText( e.getDetails());

        ImageView imageView = (ImageView) v.findViewById(R.id.main_image);

        switch (e.getTitle()){

            case "Bed": imageView.setImageResource(R.drawable.montezuma);
                break;

            case "Fridge": imageView.setImageResource(R.drawable.devinci);
                break;

            case "Bag": imageView.setImageResource(R.drawable.turing);
                break;

            case "Bike": imageView.setImageResource(R.drawable.martian_rover);
                break;

            case "Chair": imageView.setImageResource(R.drawable.shaka_zulu);
                break;

            case "Dog": imageView.setImageResource(R.drawable.darwin);
                break;

            case "Door": imageView.setImageResource(R.drawable.macintosh_128k);
                break;

            case "Generic": imageView.setImageResource(R.drawable.ada_lovelace_portrait);
                break;

            case "Shoe": imageView.setImageResource(R.drawable.nikola_tesla);
                break;

            case "Car": imageView.setImageResource(R.drawable.wright_bothers);
                break;

            default: imageView.setImageResource(R.drawable.dog);

        }

    }

    @OnClick(R.id.back_button)
    public void returnHome(){

        mCallback.handleDisplay(null);

    }

}
