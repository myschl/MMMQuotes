package com.example.mypc.muftymenkmotivationalquotes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
    ArrayList<FavoriteModel> favorite = new ArrayList<>();
    private Context context;

    public FavoriteAdapter(Context context, ArrayList<FavoriteModel> favorite) {
        this.favorite = favorite;
        this.context = context;
    }

    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favorite_view,parent, false);
        ViewHolder holder = new ViewHolder(itemView, context, favorite);
        return holder;
    }

    @Override
    public void onBindViewHolder(FavoriteAdapter.ViewHolder holder, int position) {
        FavoriteModel favoriteModel = favorite.get(position);

        holder.title.setText(favoriteModel.getTitle());
        holder.body.setText(favoriteModel.getBody());

    }

    @Override
    public int getItemCount() {
        return favorite.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title, body;
        LinearLayout parentLayout;

        ArrayList<FavoriteModel> Quoteid = new ArrayList<>();
        Context ctx;
        public ViewHolder(View itemView, Context ctx, ArrayList<FavoriteModel> Quoteid) {
            super(itemView);

            this.Quoteid = Quoteid;
            this.ctx = ctx;
            itemView.setOnClickListener(this);

            title = itemView.findViewById(R.id.ititle);
            body = itemView.findViewById(R.id.ibody);

            parentLayout = itemView.findViewById(R.id.parentlayout);
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            FavoriteModel Quoteid = this.Quoteid.get(position);

            String title = Quoteid.getTitle();
            String body = Quoteid.getBody();

            ArrayList<FavoriteModel> favorite = new ArrayList<>();

            Intent intent = new Intent(this.ctx, FavoritesOnly.class);
            /*favorite.add(new FavoriteModel(title, body));
            Bundle bundle=new Bundle();
            bundle.putSerializable("favoritequote",favorite);
            intent.putExtras(bundle);*/

            this.ctx.startActivity(intent);

        }
    }
}

   