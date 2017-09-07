package com.example.mypc.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapter.AnswersAdapter;
import Data.model.Item;
import Data.model.Owner;
import Data.model.SOAnswersResponse;
import Data.remote.ApiUtils;
import Data.remote.SOService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MyPC on 05/09/2017.
 */

public class LoadAnswersRetrofitActivity extends Activity {
    private AnswersAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private SOService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_load_api_main);
//        mService = ApiUtils.getSOService();
        mRecyclerView = findViewById(R.id.recyclerRetrofit);
        mAdapter = new AnswersAdapter(this, new ArrayList<Item>(0), new AnswersAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {
                Toast.makeText(LoadAnswersRetrofitActivity.this, "Post id is" + id, Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);

        loadAnswers();
    }

    public void loadAnswers() {

        mService.getAnswersObjects().enqueue(new Callback<SOAnswersResponse>() {

            @Override
            public void onResponse(Call<SOAnswersResponse> call, Response<SOAnswersResponse> response) {
                Log.d("response3", "result" + response.body().getItems());

                Log.d("aaaaaaa", response.body().getItems().get(1).getOwner().getLink().toString());
                List<Item> list = response.body().getItems();
                Owner owner = new Owner();
                Item item = new Item();
//                for (int i = 0; i < list.size(); i++) {
//                    owner.setReputation(response.body().getItems().get(i).getOwner().getReputation());
//                    owner.setUserId(response.body().getItems().get(i).getOwner().getUserId());
//                    owner.setUserType(response.body().getItems().get(i).getOwner().getUserType());
//                    owner.setProfileImage(response.body().getItems().get(i).getOwner().getProfileImage());
//                    owner.setDisplayName(response.body().getItems().get(i).getOwner().getDisplayName());
//                    owner.setLink(response.body().getItems().get(i).getOwner().getLink());
//                    owner.setAcceptRate(response.body().getItems().get(i).getOwner().getAcceptRate());
//                    list.get(i).setOwner(owner);
//                    list.get(i).setIsAccepted(response.body().getItems().get(i).getIsAccepted());
//                    list.get(i).setScore(response.body().getItems().get(i).getScore());
//                    list.get(i).setLastActivityDate(response.body().getItems().get(i).getLastActivityDate());
//                    list.get(i).setCreationDate(response.body().getItems().get(i).getCreationDate());
//                    list.get(i).setAnswerId(response.body().getItems().get(i).getAnswerId());
//                    list.get(i).setQuestionId(response.body().getItems().get(i).getQuestionId());
//
//
//                }
                Log.d("sssssssssssss",list.get(2).getScore().toString());
                mAdapter.updateAnswers(list);

//                if(response.isSuccessful()) {
//                    Log.d("response4" , "result" + response);
//                    Log.d("MainActivity2", "posts loaded from API");
////                    ArrayList<> list  = response.body();
//                    if(response.isSuccessful()) {
//                       mAdapter.updateAnswers(response.body().getItems());
//                        Log.d("MainActivity", "posts loaded from API");
//                    }
//
//                } else {
//                    Log.d("MainActivity", "posts loaded from API");
//                }
            }

            @Override
            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {
                Log.d("MainActivity1", t.toString());
            }
        });

    }
}
