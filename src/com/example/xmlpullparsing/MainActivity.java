package com.example.xmlpullparsing;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* StrictMode.ThreadPolicy pol=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(pol);*/
       ListView listView = (ListView) findViewById(R.id.listView1);
        
        List<Employee> employees = null;
        try {
            XmlPullParserHandler parser = new XmlPullParserHandler();
           // InputStream is=getAssets().open("employees.xml");
            InputStream is=new URL("YOUR XML URL").openStream();
            employees = parser.parse(is);
            
            ArrayAdapter<Employee> adapter =new ArrayAdapter<Employee>(this,android.R.layout.simple_list_item_1, employees);
            listView.setAdapter(adapter);
            
        } catch (IOException e) {e.printStackTrace();}
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
