package com.example.mypc.myapplication;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.example.mypc.myapplication.databinding.ActivityMainBinding;

import com.google.gson.Gson;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Adapter.MainActivityAdapter;
import Data.MainActivityItemsResponse;


/**
 * Created by MyPC on 23/08/2017.
 */

public class MainActivity extends Activity {

    ActivityMainBinding mBinding;


    MainActivityItemsResponse mainActivityItemsResponse = new MainActivityItemsResponse();




    private void showList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBinding.recyclerMain.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new HttpAsyncTask().execute("http://thichcomic.com:1221/api/Categories");

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        showList();
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            Log.d("333333333333333" , "doInBackground" + GET(urls[0]));
            return GET(urls[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d("result" , "onPostExecute" + result);
            Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_SHORT).show();
            mainActivityItemsResponse = new Gson().fromJson(result, MainActivityItemsResponse.class);
            MainActivityAdapter activityAdapter = new MainActivityAdapter(mainActivityItemsResponse );
            mBinding.recyclerMain.setAdapter(activityAdapter);


        }

        private   String GET(String url) {
            InputStream inputStream = null;
            String result = "";
            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpResponse httpResponse = httpClient.execute(new HttpGet(url));
                inputStream = httpResponse.getEntity().getContent();

                if(inputStream != null)
                    result = convertInputSteamToString(inputStream);
                else result ="did not work!";

            } catch (Exception e) {
                Log.d("InputStream", e.getLocalizedMessage());

            }
            Log.d("3333332222333333333" , result);
            return result;
        }
    }



    private static String convertInputSteamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while ((line = bufferedReader.readLine()) != null)
            result += line;
        inputStream.close();
        return result;

    }

}