package com.example.retrofit_.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit_.activity.DetailActivity;
import com.example.retrofit_.model.Post;
import com.example.retrofit_.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private Context context;
    private List<Post> resultsList;

    public Adapter(Context context, List<Post> resultsList) {
        this.context = context;
        this.resultsList = resultsList;
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item,parent,false);

        Adapter.MyViewHolder viewHolder = new Adapter.MyViewHolder(view);
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(parent.getContext(), DetailActivity.class);
                Post result = new Post();
                result.setUserId(resultsList.get(viewHolder.getAdapterPosition()).getUserId());
                result.setId(resultsList.get(viewHolder.getAdapterPosition()).getId());
                result.setTitle(resultsList.get(viewHolder.getAdapterPosition()).getTitle());
                result.setCompleted(resultsList.get(viewHolder.getAdapterPosition()).getCompleted());

                intent.putExtra(DetailActivity.key,result);
                parent.getContext().startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText("Title: "+resultsList.get(position).getTitle());
        String completed;
        if(resultsList.get(position).getCompleted().equals("true")){
            completed = "Yes";
        }else
            completed = "No";
        holder.tvDesk.setText("Completed: "+completed);
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvTitle, tvDesk;
        RelativeLayout relativeLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //imageView = itemView.findViewById(R.id.img);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDesk = itemView.findViewById(R.id.tvDesc);
            relativeLayout = itemView.findViewById(R.id.layout);
        }
    }
}
