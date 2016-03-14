package com.daweber.brackets.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daweber.brackets.R;
import com.daweber.brackets.vo.Game;

import java.util.List;

/**
 * ViewHolder for RecyclerView
 */
public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.GameViewHolder> {
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
    public void onBindViewHolder(GameViewHolder gC, int i) {
        Game g = gameList.get(i);
        gC.vTOne.setText(g.tOne);
        gC.vTTwo.setText(g.tTwo);

        Log.d(TAG, "g.isFinal = " + g.isFinal);
        if (g.isFinal) {
            gC.vTOne.setTextColor(mContext.getResources().getColor(R.color.darkGray));
            gC.vTTwo.setTextColor(mContext.getResources().getColor(R.color.darkGray));
            gC.vSOne.setTextColor(mContext.getResources().getColor(R.color.darkGray));
            gC.vSTwo.setTextColor(mContext.getResources().getColor(R.color.darkGray));
            gC.vGDetails.setBackgroundDrawable(new ColorDrawable(mContext.getResources()
                    .getColor(R.color.mediumGray)));
        }
        if (!g.isFinal) {
            gC.vTOne.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
            gC.vTTwo.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
            gC.vSOne.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
            gC.vSTwo.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
            gC.vGDetails.setBackgroundDrawable(new ColorDrawable(mContext.getResources()
                    .getColor(R.color.colorPrimaryDark)));
        }

    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View gameCard = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.card_game, parent, false);

        return new GameViewHolder(gameCard);
    }

    public static class GameViewHolder extends RecyclerView.ViewHolder {

        protected ResizeTextView vTOne, vTTwo, vGDetails;
        protected TextView vSOne, vSTwo;
        protected LinearLayout gCard;


        public GameViewHolder(View v) {
            super(v);
            vTOne = (ResizeTextView) v.findViewById(R.id.tOne);
            vTTwo = (ResizeTextView) v.findViewById(R.id.tTwo);
            vGDetails = (ResizeTextView) v.findViewById(R.id.gDetails);
            vSOne = (TextView) v.findViewById(R.id.sOne);
            vSTwo = (TextView) v.findViewById(R.id.sTwo);
        }
    }
}
