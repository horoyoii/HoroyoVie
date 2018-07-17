package org.horoyoii.myapplication;


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class comment_item_view extends LinearLayout {
    TextView Id, Content, Time, RecCount;
    RatingBar rating;






    public comment_item_view(Context context) {
        super(context);
        init(context);
    }

    public comment_item_view(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_item_view, this, true);

        Id = (TextView)findViewById(R.id.ListView_ItemId);
        Content =(TextView)findViewById(R.id.ListView_Content);
        Time = (TextView)findViewById(R.id.ListView_Time);
        RecCount = (TextView)findViewById(R.id.ListView_RecCount);
        rating = (RatingBar)findViewById(R.id.ListView_ratingBar);

    }

    public void setId(String id){ Id.setText(id);}
    public void setContent(String content){Content.setText(content);}
    public void setTime(String time){Time.setText(time);}
    public void setRecCount(int count){RecCount.setText(String.valueOf(count));}
    public void setRating(double rate){ rating.setRating((float)rate); }

}
