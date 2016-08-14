package com.zhiyuan3g.studentcontentresolver.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zhiyuan3g.studentcontentresolver.R;

public class InsertActivity extends Activity {

    EditText edtName, edtAge;
    Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        iniView();
    }

    private void iniView() {
        edtName = (EditText) findViewById(R.id.edtName);
        edtAge = (EditText) findViewById(R.id.edtAge);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String age = edtAge.getText().toString();

                ContentResolver resolver = getContentResolver();
                Uri uri = Uri.parse("content://com.zhiyuan3g.contentprovider/student");

                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("age", age);

                resolver.insert(uri, values);
            }
        });
    }


}
