package com.example.mypc.muftymenkmotivationalquotes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends android.support.v4.view.PagerAdapter {
    private List<PagerModel> pagerModels;
    private LayoutInflater layoutInflater;
    private Context context;

    public PagerAdapter(List<PagerModel> pagerModels, Context context) {
        this.pagerModels = pagerModels;
        this.context = context;
    }

    public PagerAdapter(ArrayList<FavoriteModel> favorite, FavoritesOnly context) {
    }

    @Override
    public int getCount() {
        return pagerModels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.pager_items, container, false);

        TextView mtitle, mbody;
        mtitle = view.findViewById(R.id.ititle);
        mbody = view.findViewById(R.id.ibody);
        mtitle.setText(pagerModels.get(position).getTitle());
        mbody.setText(pagerModels.get(position).getBody());

        container.addView(view, 0);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
