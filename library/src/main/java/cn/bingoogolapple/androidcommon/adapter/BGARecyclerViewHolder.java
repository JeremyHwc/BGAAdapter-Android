/**
 * Copyright 2015 bingoogolapple
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.bingoogolapple.androidcommon.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author JeremyHwc;
 * @date 2017/10/18/018 14:43;
 * @email jeremy_hwc@163.com ;
 * @desc 适用于RecyclerView的item的ViewHolder,具有防止快速点击的点击监听以及长按监听
 */
public class BGARecyclerViewHolder extends RecyclerView.ViewHolder
                                       implements View.OnLongClickListener {
    protected Context mContext;
    protected BGAViewHolderHelper mViewHolderHelper;//ViewHolder  Helper
    protected BGARecyclerViewAdapter mRecyclerViewAdapter;//RecyclerView Adapter
    protected RecyclerView mRecyclerView;//RecyclerView
    protected BGAOnRVItemClickListener mOnRVItemClickListener;//点击事件
    protected BGAOnRVItemLongClickListener mOnRVItemLongClickListener;//长按事件

    public BGARecyclerViewHolder(BGARecyclerViewAdapter recyclerViewAdapter,
                                 RecyclerView recyclerView,
                                 View itemView,
                                 BGAOnRVItemClickListener onRVItemClickListener,
                                 BGAOnRVItemLongClickListener onRVItemLongClickListener) {

        super(itemView);
        mContext = mRecyclerView.getContext();
        mRecyclerViewAdapter = recyclerViewAdapter;
        mRecyclerView = recyclerView;
        mOnRVItemClickListener = onRVItemClickListener;
        mOnRVItemLongClickListener = onRVItemLongClickListener;

        /**
         * 防止快速点击的点击监听
         */
        itemView.setOnClickListener(new BGAOnNoDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                if (v.getId() == BGARecyclerViewHolder.this.itemView.getId()
                        && null != mOnRVItemClickListener) {

                    mOnRVItemClickListener.onRVItemClick(mRecyclerView, v, getAdapterPositionWrapper());
                }
            }
        });

        itemView.setOnLongClickListener(this);

        mViewHolderHelper = new BGAViewHolderHelper(mRecyclerView, this);
    }

    /**
     * 获取BGAViewHolderHelper实例
     * @return
     */
    public BGAViewHolderHelper getViewHolderHelper() {
        return mViewHolderHelper;
    }

    /**
     * 条目长按事件
     * @param v
     * @return
     */
    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == this.itemView.getId()
                && null != mOnRVItemLongClickListener) {

            return mOnRVItemLongClickListener.onRVItemLongClick(mRecyclerView, v, getAdapterPositionWrapper());
        }
        return false;
    }

    /**
     * 获取条目所在位置
     * @return
     */
    public int getAdapterPositionWrapper() {
        if (mRecyclerViewAdapter.getHeadersCount() > 0) {
            return getAdapterPosition() - mRecyclerViewAdapter.getHeadersCount();
        } else {
            return getAdapterPosition();
        }
    }
}