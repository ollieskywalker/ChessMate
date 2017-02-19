package com.example.windows10user.chessmate;

import android.content.Context;
import android.service.quicksettings.Tile;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Windows 10 User on 2/18/2017.
 */

public class TileAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public TileAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return tiles.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) view;
        }

        imageView.setImageResource(tiles[position]);
        return imageView;
    }

    public Integer[]tiles = {
            R.drawable.whitesquare, R.drawable.blacksquare2,
            R.drawable.whitesquare, R.drawable.blacksquare2,
            R.drawable.whitesquare, R.drawable.blacksquare2,
            R.drawable.whitesquare, R.drawable.blacksquare2,
            R.drawable.blacksquare2, R.drawable.whitesquare,
            R.drawable.blacksquare2, R.drawable.whitesquare,
            R.drawable.blacksquare2, R.drawable.whitesquare,
            R.drawable.blacksquare2, R.drawable.whitesquare,
            R.drawable.whitesquare, R.drawable.blacksquare2,
            R.drawable.whitesquare, R.drawable.blacksquare2,
            R.drawable.whitesquare, R.drawable.blacksquare2,
            R.drawable.whitesquare, R.drawable.blacksquare2,
            R.drawable.blacksquare2, R.drawable.whitesquare,
            R.drawable.blacksquare2, R.drawable.whitesquare,
            R.drawable.blacksquare2, R.drawable.whitesquare,
            R.drawable.blacksquare2, R.drawable.whitesquare,
            R.drawable.whitesquare, R.drawable.blacksquare2,
            R.drawable.whitesquare, R.drawable.blacksquare2,
            R.drawable.whitesquare, R.drawable.blacksquare2,
            R.drawable.whitesquare, R.drawable.blacksquare2,
            R.drawable.blacksquare2, R.drawable.whitesquare,
            R.drawable.blacksquare2, R.drawable.whitesquare,
            R.drawable.blacksquare2, R.drawable.whitesquare,
            R.drawable.blacksquare2, R.drawable.whitesquare,
            R.drawable.whitesquare, R.drawable.blacksquare2,
            R.drawable.whitesquare, R.drawable.blacksquare2,
            R.drawable.whitesquare, R.drawable.blacksquare2,
            R.drawable.whitesquare, R.drawable.blacksquare2,
            R.drawable.blacksquare2, R.drawable.whitesquare,
            R.drawable.blacksquare2, R.drawable.whitesquare,
            R.drawable.blacksquare2, R.drawable.whitesquare,
            R.drawable.blacksquare2, R.drawable.whitesquare,
    };
}
