package com.kottland.elab.recipeapphd;

/**
 * Created by KottLand Lab on 8/27/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KottLand Lab on 6/17/2017.
 */

public class ListViewAdapter extends BaseAdapter {

    private final List<ListViewAdapter.Item> mItems = new ArrayList<ListViewAdapter.Item>();
    private final LayoutInflater mInflater;








    public ListViewAdapter(Context context){
        mInflater = LayoutInflater.from(context);


        mItems.add(new ListViewAdapter.Item("Appetizers", R.drawable.appetizers ) );  mItems.add(new ListViewAdapter.Item("Breakfast", R.drawable.breakfast ) );
        mItems.add(new ListViewAdapter.Item("Lunch", R.drawable.lunch ) );  mItems.add(new ListViewAdapter.Item("Dinner", R.drawable.dinner ) );
        mItems.add(new ListViewAdapter.Item("Dessert", R.drawable.dessert ) );  mItems.add(new ListViewAdapter.Item("Drink", R.drawable.drink ) );




        mItems.add(new Item("Pancakes", R.drawable.appetizers ) );  mItems.add(new Item("MINI HAM 'N' CHEESE ", R.drawable.breakfast ) );
        mItems.add(new Item("Lunch", R.drawable.lunch ) );  mItems.add(new Item("Dinner", R.drawable.dinner ) );
        mItems.add(new Item("Dessert", R.drawable.dessert ) );  mItems.add(new Item("Drink", R.drawable.drink ) );





    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public ListViewAdapter.Item getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return mItems.get(i).drawableId;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;
        ImageView picture;
        TextView name;
        if (v==null){

            v= mInflater.inflate(R.layout.list_itemz, viewGroup, false);
            v.setTag(R.id.picture_list, v.findViewById(R.id.picture_list));
            v.setTag(R.id.text_list,v.findViewById(R.id.text_list));
        }

        picture = (ImageView)v.getTag(R.id.picture_list);
        name = (TextView)v.getTag(R.id.text_list);
        ListViewAdapter.Item item = getItem(i);
        picture.setImageResource(item.drawableId);
        name.setText(item.name);
        return v;

    }

    private static class Item {
        public final String name;
        public final  int  drawableId;
        Item(String name, int drawableId){
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}

