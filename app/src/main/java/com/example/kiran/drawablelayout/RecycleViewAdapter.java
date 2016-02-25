package com.example.kiran.drawablelayout;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nispok.snackbar.Snackbar;

/**
 * Created by Kiran on 11-02-2016.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    Context context;
    View layout;
    final String[] iconNames;
    final int[] icons;
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;

    public RecycleViewAdapter(Context context, String[] iconNames, int[] icons, DrawerLayout drawerLayout, RecyclerView recyclerView) {
        this.context=context;
        this.iconNames=iconNames;
        this.icons=icons;
        this.drawerLayout=drawerLayout;
        this.recyclerView=recyclerView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=(LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(viewType==0)
        {

            layout = layoutInflater.inflate(R.layout.recycle_header,null);
            return new ViewHolder(layout, viewType);
        }
        else if(viewType==1)
        {
            layout=layoutInflater.inflate(R.layout.recycleview,parent,false);
            return new ViewHolder(layout,viewType);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("log",""+holder);
        if(position!=0)
        {
            holder.textView.setText(iconNames[position-1]);
            holder.imageView.setImageResource(icons[position-1]);
        }

    }

    @Override
    public int getItemCount() {
        return iconNames.length+1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0)
            return (0);
        else return (1);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            if(viewType==0)
            {
                imageView=(ImageView)itemView.findViewById(R.id.iv_draw_header);
            }
            else if(viewType==1)
            {
                imageView=(ImageView)itemView.findViewById(R.id.iv_icons);
                textView=(TextView)itemView.findViewById(R.id.tv_texts);
            }
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            TextView textView=(TextView)v.findViewById(R.id.tv_texts);
            android.support.design.widget.Snackbar.make(v,"hello"+textView.getText().toString(), android.support.design.widget.Snackbar.LENGTH_SHORT).show();
            if(textView.getText().equals("Ace"))
            {
                drawerLayout.closeDrawer(recyclerView);
                textView.getContext().startActivity(new Intent(context,activity_one.class));
            }
            else if(textView.getText().equals("Add"))
            {

            }
            else if(textView.getText().equals("Audio"))
            {

            }
            else if(textView.getText().equals("Play"))
            {

            }
        }
    }
}
