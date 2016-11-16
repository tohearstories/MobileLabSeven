package edu.temple.mobilelabseven;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    int i=0;            //i is the total number of open "tabs"
    int currentIndex=0; //currentIndex is the "tab" currently displayed
    ArrayList<Fragment> openTabs = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openTabs.add(new WebPageFragment());//loads the webview initially

        fragmentManager = getFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.webPageLayout, openTabs.get(i));//loads the webview initially

        Uri data = getIntent().getData();
        if(data != null) {
            String url = data.toString();
            (  (WebPageFragment) openTabs.get(i)).setUrlToLoad(data.toString());
        }

        fragmentTransaction.commit();

    }



    public void newButtonClicked() {
        openTabs.add(new WebPageFragment());
        i++;
        currentIndex = i;
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.webPageLayout, openTabs.get(i));
        fragmentTransaction.commit();
    }

    public void backButtonClicked() {

        if (currentIndex-1 < 0) {
            Toast.makeText(getApplicationContext(), "can not go back any further", Toast.LENGTH_SHORT).show();
        }

        if ( currentIndex-1  >  0 || currentIndex-1 == 0) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.webPageLayout, openTabs.get(currentIndex - 1));
            fragmentTransaction.commit();
            currentIndex--;
        }
    }

    public void forwardButtonClicked() {

        if (currentIndex +1 > i){
            Toast.makeText(getApplicationContext(), "can not go forward any further", Toast.LENGTH_SHORT).show();
        }

        if ( currentIndex+1  <  i || currentIndex+1 == i) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.webPageLayout, openTabs.get(currentIndex + 1));
            fragmentTransaction.commit();
            currentIndex++;
        }

    }

//what follows is necessary overhead to create the back, next, and new buttons/links on the appbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //this basically sets the onClick behavior for the back, next, and new buttons/links on the appbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.backButton){
            backButtonClicked();
        }

        if (item.getItemId() == R.id.forwardButton){
            forwardButtonClicked();
        }

        if (item.getItemId() == R.id.newButton){
            newButtonClicked();
        }

        return super.onOptionsItemSelected(item);
    }
}
