package com.daweber.brackets.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daweber.brackets.R;
import com.daweber.brackets.view.activity.BracketActivity;
import com.daweber.brackets.vo.Game;

import java.util.List;

/**
 * Game List Adapter class
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
        int gameId = g.getGameId();
        String teamOne = g.teamOne;
        String teamTwo = g.teamTwo;

        //TODO:use a flag, isPicked
        if (teamOne.length() <= 2)
            gameCard.viewTeamOne
                    .setText(String.format("%s\u00A0%s", mContext
                            .getString(R.string.unpicked_team_prefix), teamOne));
        else
            gameCard.viewTeamOne.setText(teamOne);

        if (teamOne.length() <= 2)
            gameCard.viewTeamTwo
                    .setText(String.format("%s\u00A0%s", mContext
                            .getString(R.string.unpicked_team_prefix), teamTwo));
        else
            gameCard.viewTeamTwo.setText(teamTwo);

        gameCard.viewGameDetails.setText(g.gameDetails);
        gameCard.viewBracketRegion.setText(Game.REGION[g.bracketRegion].toUpperCase());
        gameCard.gID = gameId;
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View gameCard = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.card_game, parent, false);

        return new GameViewHolder(gameCard, new GameViewHolder.GameCardClickListener() {
            @Override
            public void setPicked(ResizeTextView picked, int game) {
                if (picked.getId() == R.id.team_one)
                    BracketActivity.setPicked(game, 1);
                else
                    BracketActivity.setPicked(game, 2);
            }

            @Override
            public void moreInfo(View touched, int game) {
                Log.d(TAG, "Touched Game " + game + " view: " + touched.toString());
            }
        });
    }
}
