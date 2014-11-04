package com.vincentbrison.openlibraries.android.swipelistview.app;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vincentbrison.openlibraries.android.swipelistview.SwipeListView;
import com.vincentbrison.openlibraries.android.swipelistview.id.R;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Brize on 28/06/2014.
 */
public class DemoAdapter extends BaseAdapter {

    public interface MyAdapterCallbacks {
        public void onClickDelete(int i);
    }

    private List<String> mStrings;
    private WeakReference<Activity> mContext;
    private MyAdapterCallbacks mCallbacks;
    private SwipeListView mListView;

    public DemoAdapter(List<String> strings, Activity context, MyAdapterCallbacks callbacks, SwipeListView listview) {
        mStrings = strings;
        mContext = new WeakReference<Activity>(context);
        mCallbacks = callbacks;
        mListView = listview;

    }

    @Override
    public int getCount() {
        return mStrings.size();
    }

    @Override
    public Object getItem(int i) {
        return mStrings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = mContext.get().getLayoutInflater().inflate(R.layout.entry_my_listview, null);
            ViewHolder holder = new ViewHolder();
            holder.textViewBack = (TextView) view.findViewById(R.id.entry_listview_textview_delete);
            holder.textViewFront = (TextView) view.findViewById(R.id.entry_listview_textview_entry);
            holder.viewDelete = (View) view.findViewById(R.id.entry_listview_view_delete);
            view.setTag(holder);
        }

        mListView.recycle(view, i);

        ViewHolder holder = (ViewHolder) view.getTag();

        holder.textViewFront.setText(mStrings.get(i));

        holder.viewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DemoAdapter.this.mCallbacks.onClickDelete(i);
            }
        });


        return view;
    }

    private static class ViewHolder {
        protected TextView textViewFront;
        protected TextView textViewBack;
        protected View viewDelete;
    }
}
