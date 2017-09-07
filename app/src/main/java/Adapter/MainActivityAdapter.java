package Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypc.myapplication.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;

import Data.MainActivityItems;
import Data.MainActivityItemsResponse;

/**
 * Created by MyPC on 29/08/2017.
 */

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {
    Context context;
    ArrayList<MainActivityItems> mainActivityItemsesList;
    ImageLoader imageLoader = ImageLoader.getInstance();
    public MainActivityAdapter(MainActivityItemsResponse mainActivityItemsResponse){
        this.mainActivityItemsesList = mainActivityItemsResponse.data;

    }

    @Override
    public MainActivityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_items , parent ,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainActivityAdapter.ViewHolder holder, int position) {
        holder.txtTitle.setText(mainActivityItemsesList.get(position).name);
        holder.txtChapNo.setText(mainActivityItemsesList.get(position).id);
        holder.txtSlug.setText(mainActivityItemsesList.get(position).slug);

//        imageLoader.displayImage(imageUri, imageView);
//
//        URL url = new URL(mainActivityItemsesList.get(position).imageUrls);
//        Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//        holder.imageApi.setImageBitmap(bmp);

        Picasso.with(context).load(String.valueOf(mainActivityItemsesList.get(position).imageUrls.get(0))).resize(120, 60).into(holder.imageApi);

    }

    @Override
    public int getItemCount() {
        return mainActivityItemsesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtChapNo;
        TextView txtSlug;
        ImageView imageApi;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitleRetrofit);
            txtChapNo = itemView.findViewById(R.id.txtChapNo);
            txtSlug = itemView.findViewById(R.id.txtSlug);
            imageApi = itemView.findViewById(R.id.imgApi);

        }
    }
}
