package edu.temple.mobilelabseven;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

public class WebPageFragment extends Fragment {

    public static WebPageFragment newInstance() {
        return new WebPageFragment();
    }

    public WebPageFragment() {} // Required empty public constructor

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_web_page_fragment, container, false);

        WebView webView = (WebView) v.findViewById(R.id.webView);
        //webView.loadUrl("http://www.google.com");

        return v;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int position);
    }
}
