package com.asma.assignment_12;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RV1_RecyclerViewAdapter extends RecyclerView.Adapter<RV1_RecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> mImageNames;
    private ArrayList<String> mImages;
    private Context mcontext;

    public RV1_RecyclerViewAdapter(ArrayList<String> mImageNames, ArrayList<String> mImages, Context mcontext) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv1_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageName.setText(mImageNames.get(position));
        Glide.with(mcontext)
                .asBitmap()
                .load(mImages.get(position))
                .placeholder(R.drawable.img)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView imageName;
        CircleImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
        }
    }


}