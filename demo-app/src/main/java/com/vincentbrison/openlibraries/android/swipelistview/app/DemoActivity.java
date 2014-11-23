package com.vincentbrison.openlibraries.android.swipelistview.app;

import android.app.Activity;
import android.os.Bundle;

import com.vincentbrison.openlibraries.android.swipelistview.BaseSwipeListViewListener;
import com.vincentbrison.openlibraries.android.swipelistview.SwipeListView;
import com.vincentbrison.openlibraries.android.swipelistview.id.R;

import java.util.ArrayList;
import java.util.List;

public class DemoActivity extends Activity implements DemoAdapter.MyAdapterCallbacks{

    private SwipeListView mListView;
    private DemoAdapter mAdapter;
    private List<String> mStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        mListView = (SwipeListView) findViewById(R.id.my_activity_my_listview);
        mListView.setSwipeOpenOnLongPress(true);
        mListView.setSwipeCloseAllItemsWhenMoveList(true);
        mListView.setOffsetRight(300);

        mStrings = new ArrayList<String>();

        for (int i = 0; i < 50; i++) {
            mStrings.add("Entry number " + i);
        }

        mAdapter = new DemoAdapter(mStrings, this, this, mListView);
        mListView.setAdapter(mAdapter);

        mListView.setSwipeListViewListener(new BaseSwipeListViewListener() {
            @Override
            public void onDismiss(int[] reverseSortedPositions) {
                super.onDismiss(reverseSortedPositions);
                for (int i = 0; i < reverseSortedPositions.length; i++) {
                    mStrings.remove(reverseSortedPositions[0]);
                }

                mAdapter.notifyDataSetChanged();
            }
        });



    }

    @Override
    public void onClickDelete(int i) {
        mListView.dismiss(i);
    }
}
