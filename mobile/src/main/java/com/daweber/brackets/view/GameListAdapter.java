package com.daweber.brackets.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daweber.brackets.R;
import com.daweber.brackets.vo.Game;

import java.util.List;

/**
 * ViewHolder for RecyclerView
 */
public class GameListAdapter extends RecyclerView.Adapter<GameViewHolder> {
    private static final String TAG = "b64.GameListAdapter";

    private List<Game> gameList;
    private Context mContext;

    public GameListAdapter(Context context, List<Game> gameList) {
        this.mContext = context;
        this.gameList = gameList;
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    @Override
    public void onBindViewHolder(GameViewHolder gameCard, int i) {

        Game g = gameList.get(i);

        gameCard.viewTeamOne.setText(g.teamOne);
        gameCard.viewTeamTwo.setText(g.teamTwo);
        gameCard.viewGameDetails.setText(g.gameDetails);
        gameCard.viewBracketRegion.setText(Game.REGION[g.bracketRegion].toUpperCase());
        gameCard.gID = g.getGameId();
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View gameCard = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.card_game, parent, false);
        return new GameViewHolder(gameCard);
    }

}
