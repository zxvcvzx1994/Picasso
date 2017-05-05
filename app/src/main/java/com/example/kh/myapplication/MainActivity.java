package com.example.kh.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

import com.example.kh.myapplication.Module.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private ArrayList<Person>  arrayList = new ArrayList<Person>();

    private     Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);





    }
    public void load(){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                init();
                Person.Myadapter adapter = new Person.Myadapter(this, R.layout.spinner_layout, arrayList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        arrayList.add(new Person("vinh","http://www.hoasaigon.com.vn/kcfinder/upload/images/nhung-loai-hoa-y-nghia-danh-tang-me-nhan-ngay-20-10-15.jpg"));
        arrayList.add(new Person("vinh1","http://vnsupermark.com/resources/2014/12/tLJ3dnmm.jpg"));
        arrayList.add(new Person("vinh2","http://cayvahoa.net/wp-content/uploads/2016/08/hoa-hong-do-3.jpg"));
        arrayList.add(new Person("vinh3","http://hoahongmagic.com/wp-content/uploads/2015/05/hoa-hong-tinh-yeu.jpg"));
    }
}
