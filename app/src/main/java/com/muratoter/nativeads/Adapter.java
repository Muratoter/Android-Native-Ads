package com.muratoter.nativeads;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Murat on 21.02.2017.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Movie> movies = Collections.emptyList();
    private Activity activity;
    private ImageLoader imageLoader;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_AD = 2;

    public Adapter(Activity activity, List<Movie> movies) {
        this.activity = activity;
        this.movies = movies;

    }

    //İçeriklerin gerekli tanımlamaları - Movies init
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public NetworkImageView content_image;
        public TextView tv_header, tv_content;

        public MyViewHolder(View itemView) {
            super(itemView);
            content_image = (NetworkImageView) itemView.findViewById(R.id.content_image);
            tv_header = (TextView) itemView.findViewById(R.id.tv_header);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }

    //Reklam yüklemek için gerekli tanımlamalar -  ad init
    public static class AdViewHolder extends RecyclerView.ViewHolder {
        public NativeExpressAdView adView;

        public AdViewHolder(View itemView) {
            super(itemView);
            adView = (NativeExpressAdView) itemView.findViewById(R.id.nat_ad);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_AD:
                View adView= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_native_ad,parent,false);
                return new AdViewHolder(adView);
            case TYPE_ITEM:
                default:
                    View itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,parent,false);
                    return new MyViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        int viewType=getItemViewType(position);
        switch (viewType){
            case TYPE_AD:
                AdViewHolder adViewHolder=(AdViewHolder)holder;
                AdRequest adRequest = new AdRequest.Builder()
                        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                        .build();
                adViewHolder.adView.loadAd(adRequest);
                break;
            case TYPE_ITEM:
                default:
                    MyViewHolder myViewHolder=(MyViewHolder)holder;
                    myViewHolder.tv_header.setText(movies.get(position).getName());
                    myViewHolder.tv_content.setText(movies.get(position).getDescription());

                    imageLoader = CustomVolleyRequest.getInstance(activity.getApplicationContext()).getImageLoader();
                    imageLoader.get(movies.get(position).getPoster().toString(),ImageLoader.getImageListener(myViewHolder.content_image,
                            R.drawable.cached,
                            R.drawable.cached));
                    myViewHolder.content_image.setImageUrl(movies.get(position).getPoster(),imageLoader);
                    break;
        }

    }

    //Her 3 içerikte bir reklam gösterimi yapılacaktır. Bu yüzden içeriklerin pozisyonlarına göre geri döndürülen değerler verilmiştir.
    // Bu değerler ile reklam ve içerik yükleme işlemleri yapılacaktır.
    @Override
    public int getItemViewType(int position) {
        return (position > 0 && position % 3 == 0) ? TYPE_AD : TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
