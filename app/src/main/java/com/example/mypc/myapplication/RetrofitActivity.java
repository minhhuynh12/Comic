package com.example.mypc.myapplication;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import Retrofit.StackOverflowQuestions;


/**
 * Created by MyPC on 04/09/2017.
 */

public class RetrofitActivity extends ListActivity  {

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // Hiển thị title loading
//        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
//        requestWindowFeature(Window.FEATURE_PROGRESS);
//
//        // Set Adapter mặc định cho Activity
//        ArrayAdapter<Retrofit.Question> arrayAdapter =
//                new ArrayAdapter<Retrofit.Question>(this,
//                        android.R.layout.simple_list_item_1,
//                        android.R.id.text1,
//                        new ArrayList<Retrofit.Question>());
//        setListAdapter(arrayAdapter);
//
//        // Visible loading
//        setProgressBarIndeterminateVisibility(true);
//        setProgressBarVisibility(true);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        setProgressBarIndeterminateVisibility(true);
//
//        // Khởi tạo Retrofit để gán API ENDPOINT (Domain URL) cho Retrofit 2.0
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.stackexchange.com")
//                // Sử dụng GSON cho việc parse và maps JSON data tới Object
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        // Khởi tạo các cuộc gọi cho Retrofit 2.0
//        Retrofit.StackOverflowAPI stackOverflowAPI = retrofit.create(Retrofit.StackOverflowAPI.class);
//
//        Call<StackOverflowQuestions> call = stackOverflowAPI.loadQuestions("android");
//        // Cuộc gọi bất đồng bọ (chạy dưới background)
//        call.enqueue(this);
//
//        // Nếu bạn muốn chạy đồng bồ trên main thread sử dụng phương thức execute
//        // call.execute()
//
//        // Để Cancel request:
//        // call.cancel();
//
//        // Có thể clone một cuộc gọi trước đó
//        //Call<StackOverflowQuestions> c = call.clone();
//        //c.enqueue(this);
//
//        return true;
//    }
//
//    @Override
//    public void onResponse(Response<StackOverflowQuestions> response, Retrofit retrofit) {
//        setProgressBarIndeterminateVisibility(false);
//
//        // Gán giá trị cho Adapter để fill tới List
//        ArrayAdapter<Retrofit.Question> adapter = (ArrayAdapter<Retrofit.Question>) getListAdapter();
//        adapter.clear();
//        // Lấy dữ liệu trả về từ Response qua Body()
//        adapter.addAll(response.body().items);
//    }
//
//    @Override
//    public void onFailure(Throwable t) {
//        Toast.makeText(RetrofitActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//    }
}
