package com.daweber.brackets;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by moweber on 2/8/2016.
 */
public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.GameViewHolder> {
    private static final String TAG = "b64.GameListAdapter";

    private List<Game> gameList;

    public GameListAdapter(List<Game> gameList) {
        this.gameList = gameList;
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    @Override
    public void onBindViewHolder(GameViewHolder gameViewHolder, int i) {
        Game g = gameList.get(i);
        gameViewHolder.vTOne.setText(g.tOne);
        gameViewHolder.vTTwo.setText(g.tTwo);
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View gameCard = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.card_game, parent, false);

        return new GameViewHolder(gameCard);
    }

    public static class GameViewHolder extends RecyclerView.ViewHolder {

        protected TextView vTOne;
        protected TextView vTTwo;

        public GameViewHolder(View v) {
            super(v);
            vTOne = (TextView) v.findViewById(R.id.tOne);
            vTTwo = (TextView) v.findViewById(R.id.tTwo);
        }
    }
}
