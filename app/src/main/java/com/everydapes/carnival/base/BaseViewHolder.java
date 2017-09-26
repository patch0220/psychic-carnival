package com.everydapes.carnival.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by malabbao on 8/17/17
 *
 * Base ViewHolder class where you can latch your dependency injections in the future!
 *
 * Bound ButterKnife to eliminate need for binding in subclasses.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
