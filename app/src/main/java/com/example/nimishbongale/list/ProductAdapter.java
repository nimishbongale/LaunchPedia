package com.example.nimishbongale.list;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.String.valueOf;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private Context mCtx;
   private List<Product> productList;
    public LinearLayout linearLayout;


    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater= LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.list_layout,null);
        ProductViewHolder holder= new ProductViewHolder(view);
        holder.setIsRecyclable(true);
        return holder;
    }
    public void onBindViewHolder(@NonNull final ProductViewHolder productViewHolder, int i) {

        final Product product= productList.get(i);
        productViewHolder.textViewTitle.setText(product.getTitle());
        productViewHolder.textViewDesc.setText(product.getShortdesc());
        productViewHolder.textViewRating.setText(product.getRating());
        productViewHolder.textViewPrice.setText(product.gett());
        productViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

        //linearLayout.removeAllViews();

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(mCtx,SecondActivity.class);
                intent1.putExtra("payload",product.getTitle());
                intent1.putExtra("longdesc",product.getLongdesc());
                intent1.putExtra("secimg",product.getSecimage());
                intent1.putExtra("locat",product.getLocat());
                intent1.putExtra("url",product.getUrl());
                v.getContext().startActivity(intent1);
            }
        });
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewTitle,textViewDesc,textViewRating,textViewPrice;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle=itemView.findViewById(R.id.textViewTitle);
            textViewDesc=itemView.findViewById(R.id.textViewShortDesc);
            textViewRating=itemView.findViewById(R.id.textViewRating);
            textViewPrice=itemView.findViewById(R.id.textViewPrice);
            imageView=itemView.findViewById(R.id.imageView);
            linearLayout= itemView.findViewById(R.id.linearLayout);
            }
    }
    public void filterList(ArrayList<Product> filteredList)
    {
        productList=filteredList;
        notifyDataSetChanged();
    }
}
