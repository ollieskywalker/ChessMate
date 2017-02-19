package com.example.windows10user.chessmate;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Windows 10 User on 2/18/2017.
 */

public class Tile extends ImageView {
    public Tile(Context context) {
        super(context);
    }
    public Tile(final Context context, final AttributeSet attrs)
    {
        super(context, attrs);
    }

    public Tile(final Context context, final AttributeSet attrs, final int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec)
    {
        final int width = getDefaultSize(getSuggestedMinimumWidth(),widthMeasureSpec);
        setMeasuredDimension(width, width);
    }

    @Override
    protected void onSizeChanged(final int w, final int h, final int oldw, final int oldh)
    {
        super.onSizeChanged(w, w, oldw, oldh);
    }
}
