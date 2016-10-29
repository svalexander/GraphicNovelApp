package nyc.c4q.shannonalexander_navarro.graphicnovelapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shannonalexander-navarro on 10/28/16.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PostViewHolder> {
    List<Novel> novels;

    RVAdapter(List<Novel> novels) {
        this.novels = novels;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.novel_chooser, viewGroup, false);
        PostViewHolder pvh = new PostViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final PostViewHolder postViewHolder, int i) {
        final Context context = postViewHolder.cardView.getContext();
        String title = (novels.get(i).title);
        postViewHolder.textView.setText(title);
        postViewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //    Toast.makeText(postViewHolder.textView.getContext(), postViewHolder.textView.getText().toString(), Toast.LENGTH_SHORT).show();
                if (postViewHolder.textView.getText().toString().equals("Love and Rockets: Music for Mechanics")) {
                    Intent intent = new Intent(context, LoveAndRockets.class);
                    context.startActivity(intent);
                } else if (postViewHolder.textView.getText().toString().equals("Summer of Love")) {
                    Intent intent = new Intent(context, SummerOfLove.class);
                    context.startActivity(intent);
                } else if (postViewHolder.textView.getText().toString().equals("99 Ways to Tell to a Story")) {
                    Intent intent = new Intent(context, TellAStory.class);
                    context.startActivity(intent);
                } else if (postViewHolder.textView.getText().toString().equals("A Child's Life")) {
                    Intent intent = new Intent(context, ChildsLife.class);
                    context.startActivity(intent);
                } else {
                    Intent intent = new Intent(context, Oulipo.class);
                    context.startActivity(intent);
                }
            }

        });

    }

    @Override
    public int getItemCount() {
        return novels.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textView;
        PostViewHolder (View itemView){
            super(itemView);
           cardView = (CardView) itemView.findViewById(R.id.cardView);
            textView = (TextView) itemView.findViewById(R.id.novel_name);
        }
    }
}