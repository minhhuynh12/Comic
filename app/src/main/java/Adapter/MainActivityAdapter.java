package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypc.myapplication.R;

import java.util.ArrayList;

import Data.MainActivityItems;
import Data.MainActivityItemsResponse;

/**
 * Created by MyPC on 29/08/2017.
 */

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {
    Context context;
    ArrayList<MainActivityItems> mainActivityItemsesList;

    public MainActivityAdapter(MainActivityItemsResponse mainActivityItemsResponse){
        this.mainActivityItemsesList = mainActivityItemsResponse.articleList;
    }

    @Override
    public MainActivityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_items , parent ,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainActivityAdapter.ViewHolder holder, int position) {
        holder.txtTitle.setText(mainActivityItemsesList.get(position).title);
        holder.txtChapNo.setText(mainActivityItemsesList.get(position).url);
        holder.txtSlug.setText(mainActivityItemsesList.get(position).url);
    }

    @Override
    public int getItemCount() {
        return mainActivityItemsesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtChapNo;
        TextView txtSlug;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtChapNo = itemView.findViewById(R.id.txtChapNo);
            txtSlug = itemView.findViewById(R.id.txtSlug);

        }
    }
}
