package com.example.retrofit_.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.retrofit_.R;
import com.example.retrofit_.model.Post;

public class DetailActivity extends AppCompatActivity {
    public static final String key = "key";
    Integer IdUser, Id;
    String Title, Completed;
    ImageView img;
    TextView tvIdUser, tvId, tvTitle, tvCompleted;
    Post result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvIdUser = findViewById(R.id.tvUserId);
        tvId = findViewById(R.id.tvId);
        tvTitle = findViewById(R.id.tvTitle);
        tvCompleted = findViewById(R.id.tvCompleted);

        img = findViewById(R.id.imgDetail);

        result = getIntent().getParcelableExtra(key);

        IdUser = result.getUserId();
        Id = result.getId();
        Title = result.getTitle();
        Completed = result.getCompleted();

        tvIdUser.setText("User ID : "+IdUser);
        tvId.setText("ID : "+Id);
        tvTitle.setText("Title : "+Title);
        if (Completed.equals("true")) {
            Completed = "Yes";
        }else
            Completed = "No";
        tvCompleted.setText("Completed : "+Completed);

        String imgUrl ="https://via.placeholder.com/150/24f355";

        Glide.with(this)
                .load(imgUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(img);

    }
}