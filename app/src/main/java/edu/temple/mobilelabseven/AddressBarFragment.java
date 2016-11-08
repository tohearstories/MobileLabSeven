package edu.temple.mobilelabseven;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AddressBarFragment extends Fragment {

    public static AddressBarFragment newInstance() {
        return new AddressBarFragment();
    }

    public AddressBarFragment() {} // Required empty public constructor

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_address_bar_fragment, container, false);

      //  EditText url = (EditText)  v.findViewById(R.id.urlText);
        Button goButton = (Button) v.findViewById(R.id.goButton);


        return v;

    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int position);
    }
}
