package com.example.lizheng.greendaotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Shop mShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void delete(View view) {
        DaoHelper.deleteLove(2);
    }

    public void add(View view) {
        for (int i = 10; i > 0; i--) {
            Shop shop = new Shop();
            shop.setAddress("test" + 1);
            DaoHelper.insertLove(shop);
        }


        mShop = new Shop();
        mShop.setAddress("special");
        DaoHelper.insertLove(mShop);
    }

    public void update(View view) {
        mShop.setAddress("update");
        DaoHelper.updateLove(mShop);
    }

    public void query(View view) {
        List<Shop> shops = DaoHelper.queryLove(0);
        Toast.makeText(this, shops.size() + "", Toast.LENGTH_SHORT).show();
    }
}
