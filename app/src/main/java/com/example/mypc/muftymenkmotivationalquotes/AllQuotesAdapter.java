package com.example.mypc.muftymenkmotivationalquotes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AllQuotesAdapter extends RecyclerView.Adapter<AllQuotesAdapter.ViewHolder> {
    ArrayList<AllQuotesModel> allquotes = new ArrayList<>();
    private Context context;

    public AllQuotesAdapter(Context context, ArrayList<AllQuotesModel> allquotes) {
        this.allquotes = allquotes;
        this.context = context;
    }

    @Override
    public AllQuotesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favorite_view,parent, false);
        ViewHolder holder = new ViewHolder(itemView, context, allquotes);
        return holder;
    }

    @Override
    public void onBindViewHolder(AllQuotesAdapter.ViewHolder holder, int position) {
        AllQuotesModel allQuotesModel = allquotes.get(position);

        holder.title.setText(allQuotesModel.getTitle());
        holder.body.setText(allQuotesModel.getBody());

    }

    @Override
    public int getItemCount() {
        return allquotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title, body;
        LinearLayout parentLayout;

        ArrayList<AllQuotesModel> Quoteid = new ArrayList<>();
        Context ctx;
        public ViewHolder(View itemView, Context ctx, ArrayList<AllQuotesModel> Quoteid) {
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
            AllQuotesModel Quoteid = this.Quoteid.get(position);

            String title = Quoteid.getTitle();
            String body = Quoteid.getBody();

            ArrayList<FavoriteModel> favorite = new ArrayList<>();

            Intent intent = new Intent(this.ctx, Quotes.class);
            /*favorite.add(new FavoriteModel(title, body));
            Bundle bundle=new Bundle();
            bundle.putSerializable("favoritequote",favorite);
            intent.putExtras(bundle);*/

            this.ctx.startActivity(intent);

        }
    }
}
