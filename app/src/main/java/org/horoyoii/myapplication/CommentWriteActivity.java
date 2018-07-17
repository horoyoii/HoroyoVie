package org.horoyoii.myapplication;


import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class CommentWriteActivity extends AppCompatActivity {
    TextView cw_movieTitle;
    ImageView cw_movieGrade;
    Button cw_btnSave, cw_btnCancel;
    EditText cw_commentInput;
    RatingBar cw_ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_write);
        setTitle("@strings/cw_app_name");

        //=============================================================
        // 넘겨온 정보 처리
        cw_movieTitle = (TextView)findViewById(R.id.cw_MovieTitle);
        cw_movieGrade = (ImageView)findViewById(R.id.cw_MovieGrade);


        Intent intent = getIntent();
        processIntent(intent);




        //================================================================

        cw_btnSave = (Button)findViewById(R.id.cw_btnSave);
        cw_btnCancel =(Button)findViewById(R.id.cw_btnCancel);
        cw_commentInput = (EditText)findViewById(R.id.cw_commentInput);
        cw_ratingBar = (RatingBar)findViewById(R.id.cw_ratingBar);

        cw_btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                return_to_Info_for_Save();
            }
        });

        cw_btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                return_to_Info_for_nothing();
            }
        });


    }

    public void return_to_Info_for_Save(){
        String comment = cw_commentInput.getText().toString();
        float rating = cw_ratingBar.getRating();
        Intent intent = new Intent();

        intent.putExtra("comment", comment);
        intent.putExtra("rating", rating);

        setResult(RESULT_OK, intent);

        finish();

    }

    public void return_to_Info_for_nothing(){
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }








    public void processIntent(Intent intent){
        if(intent !=null){
            String movieTitle = intent.getStringExtra("movieTitle");
            int movieGrade = intent.getIntExtra("movieGrade", 0);
            cw_movieTitle.setText(movieTitle);
            switch (movieGrade) {
                case 12:
                    cw_movieGrade.setImageResource(R.drawable.ic_12);
                    break;
                case 15:
                    cw_movieGrade.setImageResource(R.drawable.ic_15);
                    break;
                case 19:
                    cw_movieGrade.setImageResource(R.drawable.ic_19);
                    break;
                case 0:
                    cw_movieGrade.setImageResource(R.drawable.ic_all);
                    break;
                default:
                    cw_movieGrade.setImageResource(R.drawable.ic_all);
                    break;
            }
        }

    }
}
