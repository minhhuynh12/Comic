package Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypc.myapplication.R;

import java.util.ArrayList;

import Data.model.AndroidVersion;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<AndroidVersion> android;

    public DataAdapter(ArrayList<AndroidVersion> android) {
        this.android = android;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main_items, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.txtTitle.setText(android.get(i).getName());
        viewHolder.txtChapNo.setText(android.get(i).getVer());
        viewHolder.txtSlug.setText(android.get(i).getApi());
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTitle,txtChapNo,txtSlug;
        public ViewHolder(View view) {
            super(view);

            txtTitle = (TextView)view.findViewById(R.id.txtTitleRetrofit);
            txtChapNo = (TextView)view.findViewById(R.id.txtChapNo);
            txtSlug = (TextView)view.findViewById(R.id.txtSlug);

        }
    }

}
