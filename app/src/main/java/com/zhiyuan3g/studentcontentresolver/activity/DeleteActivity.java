package com.zhiyuan3g.studentcontentresolver.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zhiyuan3g.studentcontentresolver.R;

public class DeleteActivity extends Activity {

    EditText edtId;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        initView();
    }

    private void initView() {
        edtId = (EditText) findViewById(R.id.edtId);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = edtId.getText().toString();

                ContentResolver resolver = getContentResolver();
                Uri uri = Uri.parse("content://com.zhiyuan3g." +
                        "contentprovider/student");

                Uri deleteUri = ContentUris.withAppendedId
                        (uri, Integer.valueOf(id));

                resolver.delete(deleteUri, null, null);

            }
        });
    }
}
