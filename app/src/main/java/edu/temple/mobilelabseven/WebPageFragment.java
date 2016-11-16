package edu.temple.mobilelabseven;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebPageFragment extends Fragment {

    WebView webView;
    EditText url;

    String urlToLoad;

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

        webView = (WebView) v.findViewById(R.id.webView);

        if (urlToLoad != null) {
            webView.loadUrl(urlToLoad);
        }
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        url = (EditText)  v.findViewById(R.id.urlText);
        Button goButton = (Button) v.findViewById(R.id.goButton);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlToLoad = url.getText().toString();

                if( ! urlToLoad.startsWith("http://")  ){
                    urlToLoad = "http://" + urlToLoad;
                }

                webView.loadUrl(  urlToLoad );
            }
        });

        return v;
    }

    public String getUrlToLoad() {
        return urlToLoad;
    }

    public void setUrlToLoad(String urlToLoad) {
        this.urlToLoad = urlToLoad;
    }
}
