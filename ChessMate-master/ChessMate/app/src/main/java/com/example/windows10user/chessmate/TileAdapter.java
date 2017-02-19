package com.example.windows10user.chessmate;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Windows 10 User on 2/18/2017.
 */

public class TileAdapter extends BaseAdapter {
    private Context mContext;
    private Button wpawn1;
    private int PAWN_RESOURCE_LINEk= R.drawable.pawn;

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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final ImageView imageView;
        final Button piece;
        if (view == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) view;
        }

        imageView.setImageResource(tiles[position]);

        if(position < 8 ){
                if(position==0){
                    imageView.setTag("a" + (8));
                }
                else if(position==1){
                    imageView.setTag("b" + (8));
                }
                else if(position==2){
                    imageView.setTag("c" + (8));
                }
                else if(position==3){
                    imageView.setTag("d" + (8));
                }
                else if(position==4){
                    imageView.setTag("e" + (8));
                }
                else if(position==5){
                    imageView.setTag("f" + (8));
                }
                else if(position==6){
                    imageView.setTag("g" + (8));
                }
                else if(position==7){
                    imageView.setTag("h" + (8));
                }
            }
            else if(position < 16 && position > 7){
                if(position==8){
                    imageView.setTag("a" + (7));
                }
                else if(position==9){
                    imageView.setTag("b" + (7));
                }
                else if(position==10){
                    imageView.setTag("c" + (7));
                }
                else if(position==11){
                    imageView.setTag("d" + (7));
                }
                else if(position==12){
                    imageView.setTag("e" + (7));
                }
                else if(position==13){
                    imageView.setTag("f" + (7));
                }
                else if(position==14){
                    imageView.setTag("g" + (7));
                }
                else if(position==15){
                    imageView.setTag("h" + (7));
                }
            }
            else if(position < 24 && position > 15){
                if(position==16){
                    imageView.setTag("a" + (6));
                }
                else if(position==17){
                    imageView.setTag("b" + (6));
                }
                else if(position==18){
                    imageView.setTag("c" + (6));
                }
                else if(position==19){
                    imageView.setTag("d" + (6));
                }
                else if(position==20){
                    imageView.setTag("e" + (6));
                }
                else if(position==21){
                    imageView.setTag("f" + (6));
                }
                else if(position==22){
                    imageView.setTag("g" + (6));
                }
                else if(position==23){
                    imageView.setTag("h" + (6));
                }
            }
            else if(position < 32 && position > 23){
                if(position==24){
                    imageView.setTag("a" + (5));
                }
                else if(position==25){
                    imageView.setTag("b" + (5));
                }
                else if(position==26){
                    imageView.setTag("c" + (5));
                }
                else if(position==27){
                    imageView.setTag("d" + (5));
                }
                else if(position==28){
                    imageView.setTag("e" + (5));
                }
                else if(position==29){
                    imageView.setTag("f" + (5));
                }
                else if(position==30){
                    imageView.setTag("g" + (5));
                }
                else if(position==31){
                    imageView.setTag("h" + (5));
                }
            }
            else if(position < 40 && position > 31){
                if(position==32){
                    imageView.setTag("a" + (4));
                }
                else if(position==33){
                    imageView.setTag("b" + (4));
                }
                else if(position==34){
                    imageView.setTag("c" + (4));
                }
                else if(position==35){
                    imageView.setTag("d" + (4));
                }
                else if(position==36){
                    imageView.setTag("e" + (4));
                }
                else if(position==37){
                    imageView.setTag("f" + (4));
                }
                else if(position==38){
                    imageView.setTag("g" + (4));
                }
                else if(position==39){
                    imageView.setTag("h" + (4));
                }
            }
            else if(position < 48 && position > 39){
                if(position==40){
                    imageView.setTag("a" + (3));
                }
                else if(position==41){
                    imageView.setTag("b" + (3));
                }
                else if(position==42){
                    imageView.setTag("c" + (3));
                }
                else if(position==43){
                    imageView.setTag("d" + (3));
                }
                else if(position==44){
                    imageView.setTag("e" + (3));
                }
                else if(position==45){
                    imageView.setTag("f" + (3));
                }
                else if(position==46){
                    imageView.setTag("g" + (3));
                }
                else if(position==47){
                    imageView.setTag("h" + (3));
                }
            }
            else if(position < 56 && position > 45){
                if(position==48){
                    imageView.setTag("a" + (2));
                    imageView.setImageResource(R.drawable.pawn);

                }
                else if(position==49){
                    imageView.setTag("b" + (2));
                    imageView.setImageResource(R.drawable.pawn);

                }
                else if(position==50){
                    imageView.setTag("c" + (2));
                    imageView.setImageResource(R.drawable.pawn);

                }
                else if(position==51){
                    imageView.setTag("d" + (2));
                    imageView.setImageResource(R.drawable.pawn);

                }
                else if(position==52){
                    imageView.setTag("e" + (2));
                    imageView.setImageResource(R.drawable.pawn);

                }
                else if(position==53){
                    imageView.setTag("f" + (2));
                    imageView.setImageResource(R.drawable.pawn);

                }
                else if(position==54){
                    imageView.setTag("g" + (2));
                    imageView.setImageResource(R.drawable.pawn);

                }
                else if(position==55){
                    imageView.setTag("h" + (2));
                    imageView.setImageResource(R.drawable.pawn);

                }
            }
            else if(position < 64 && position > 55){
                if(position==56){
                    imageView.setTag("a" + (1));
                }
                else if(position==57){
                    imageView.setTag("b" + (1));
                }
                else if(position==58){
                    imageView.setTag("c" + (1));
                }
                else if(position==59){
                    imageView.setTag("d" + (1));
                }
                else if(position==60){
                    imageView.setTag("e" + (1));
                }
                else if(position==61){
                    imageView.setTag("f" + (1));
                }
                else if(position==62){
                    imageView.setTag("g" + (1));
                }
                else if(position==63){
                    imageView.setTag("h" + (1));
                }
        }
//Every tile is done

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "" + imageView.getTag(), Toast.LENGTH_SHORT).show();

            }
        });

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
