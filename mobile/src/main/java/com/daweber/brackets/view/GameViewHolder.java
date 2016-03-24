package com.daweber.brackets.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.daweber.brackets.R;

/**
 * Game View Holder class
 */
public class GameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final String TAG = "b64.GameViewHolder";

    protected ResizeTextView viewTeamOne, viewTeamTwo, viewGameDetails;
    protected TextView viewBracketRegion;

    public GameCardClickListener mListener;

    protected int gID;

    public GameViewHolder(View v, GameCardClickListener listener) {
        super(v);

        mListener = listener;

        viewTeamOne = (ResizeTextView) v.findViewById(R.id.team_one);
        viewTeamOne.setOnClickListener(this);

        viewTeamTwo = (ResizeTextView) v.findViewById(R.id.team_two);
        viewTeamTwo.setOnClickListener(this);

        viewGameDetails = (ResizeTextView) v.findViewById(R.id.game_details);
        viewGameDetails.setOnClickListener(this);

        viewBracketRegion = (TextView) v.findViewById(R.id.bracket_region);
        viewBracketRegion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.team_one || id == R.id.team_two)
            mListener.setPicked((ResizeTextView) v, gID);
        else
            mListener.moreInfo(v, gID);
    }

    public interface GameCardClickListener {

        void setPicked(ResizeTextView picked, int game);

        void moreInfo(View touched, int game);
    }
}
