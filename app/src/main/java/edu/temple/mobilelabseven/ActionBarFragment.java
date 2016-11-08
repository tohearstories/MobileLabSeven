package edu.temple.mobilelabseven;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class ActionBarFragment extends Fragment {

    public static ActionBarFragment newInstance() {
        return new ActionBarFragment();
    }

    public ActionBarFragment() {} // Required empty public constructor

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_action_bar_fragment, container, false);

        Button backButton = (Button) v.findViewById(R.id.backButton);
        Button forwardButton = (Button) v.findViewById(R.id.forwardButton);
        Button newButton = (Button) v.findViewById(R.id.newButton);

        return v;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int position);
    }
}
