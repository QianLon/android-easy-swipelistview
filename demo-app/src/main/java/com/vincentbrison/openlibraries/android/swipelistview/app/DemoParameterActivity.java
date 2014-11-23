package com.vincentbrison.openlibraries.android.swipelistview.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.vincentbrison.openlibraries.android.swipelistview.id.R;

public class DemoParameterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter);

        findViewById(R.id.activity_demo_button_launch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoParameterActivity.this, DemoActivity.class);
                startActivity(intent);
            }
        });
    }
}
