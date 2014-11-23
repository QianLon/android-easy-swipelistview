package com.vincentbrison.openlibraries.android.swipelistview.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.vincentbrison.openlibraries.android.swipelistview.BaseSwipeListViewListener;
import com.vincentbrison.openlibraries.android.swipelistview.SwipeListView;
import com.vincentbrison.openlibraries.android.swipelistview.id.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityDemo extends Activity implements AdapterDemo.MyAdapterCallbacks{

    private SwipeListView mListView;
    private AdapterDemo mAdapter;
    private List<String> mEntries;
    private int mLastIdEntry = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        mListView = (SwipeListView) findViewById(R.id.my_activity_my_listview);
        mListView.setSwipeOpenOnLongPress(true);
        mListView.setSwipeCloseAllItemsWhenMoveList(true);
        mListView.setOffsetRight(300);

        mEntries = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            mEntries.add("Entry number " + i);
            mLastIdEntry = i;
        }

        mAdapter = new AdapterDemo(mEntries, this, this, mListView);
        mListView.setAdapter(mAdapter);

        mListView.setSwipeListViewListener(new BaseSwipeListViewListener() {
            @Override
            public void onDismiss(int[] reverseSortedPositions) {
                super.onDismiss(reverseSortedPositions);
                for (int i = 0; i < reverseSortedPositions.length; i++) {
                    mEntries.remove(reverseSortedPositions[0]);
                }

                mAdapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.activity_demo_button_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entry = new String("Entry number " + ++mLastIdEntry);
                mEntries.add(entry);
                mAdapter.notifyDataSetChanged();
            }
        });



    }

    @Override
    public void onClickDelete(int i) {
        mListView.dismiss(i);
    }
}
