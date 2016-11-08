package edu.temple.mobilelabseven;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.actionBarLayout, new ActionBarFragment());
        fragmentTransaction.commit();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.addressBarLayout, new AddressBarFragment());
        fragmentTransaction.commit();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.webPageLayout, new WebPageFragment());
        fragmentTransaction.commit();






    }
}
