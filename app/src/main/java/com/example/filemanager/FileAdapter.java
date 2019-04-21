package com.example.filemanager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;


public class FileAdapter extends RecyclerView.Adapter<FileAdapter.MyViewHolder> {

    private File[] listData;
    private Context listNewData;
    public static final String EXTRA_MESSAGE = "com.example.filemanager.FileAdapter";

    public  FileAdapter(File[] allData , Context newData){
        this.listData = allData;
        this.listNewData = newData;

    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public RelativeLayout mTextView;
        public ConstraintLayout nTextView;
        public Context context;
        public MyViewHolder(RelativeLayout v,Context mContext, ConstraintLayout v1) {
            super(v);
            mTextView = v;
            nTextView = v1;
            context = mContext;
            v.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();

            TextView fileNameTextView = this.mTextView.findViewById(R.id.textView1);
            String fileName = fileNameTextView.getText().toString();

            Intent intent = new Intent(context , Main2Activity.class);
            intent.putExtra(EXTRA_MESSAGE, fileName);
            context.startActivity(intent);

        }

    }

    @NonNull
    @Override
    public FileAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater =  LayoutInflater.from(viewGroup.getContext());

        RelativeLayout v = (RelativeLayout) inflater.inflate(R.layout.list_item, viewGroup, false);

        ConstraintLayout v1 = (ConstraintLayout) inflater.inflate(R.layout.activity_main2, viewGroup, false);

        MyViewHolder vh = new MyViewHolder(v ,listNewData , v1);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        final TextView dayText = myViewHolder.mTextView.findViewById(R.id.textView1);
        dayText.setText(listData[i].getName());
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }
}

