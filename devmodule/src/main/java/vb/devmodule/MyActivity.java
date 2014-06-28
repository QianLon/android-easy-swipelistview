package vb.devmodule;

import android.app.Activity;
import android.os.Bundle;

import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;
import com.fortysevendeg.swipelistview.SwipeListViewListener;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity implements MyAdapter.MyAdapterCallbacks{

    private SwipeListView mListView;
    private MyAdapter mAdapter;
    private List<String> mStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mListView = (SwipeListView) findViewById(R.id.activity_my_listview);
        mListView.setSwipeOpenOnLongPress(false);
        mStrings = new ArrayList<String>();

        for (int i = 0; i < 50; i++) {
            mStrings.add("Entry number " + i);
        }

        mAdapter = new MyAdapter(mStrings, this, this, mListView);
        mListView.setAdapter(mAdapter);

        mListView.setSwipeListViewListener(new BaseSwipeListViewListener() {
            @Override
            public void onDismiss(int[] reverseSortedPositions) {
                super.onDismiss(reverseSortedPositions);
                mStrings.remove(reverseSortedPositions[0]);
                mAdapter.notifyDataSetChanged();
            }
        });



    }

    @Override
    public void onClickDelete(int i) {
        i = i;
        mListView.dismiss(i);
        //mListView.closeAnimate(i);

    }
}
