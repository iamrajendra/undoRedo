package com.gambler.undoredoedittextexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditText;
    private PerformEdit mPerformEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = ((EditText) findViewById(R.id.edit_text));
        mPerformEdit = new PerformEdit(mEditText) {
            @Override
            protected void onTextChanged(Editable s) {
                super.onTextChanged(s);
            }
        };

        mPerformEdit.setDefaultText("I love writing code");
        findViewById(R.id.undo_btn).setOnClickListener(this);
        findViewById(R.id.redo_btn).setOnClickListener(this);
        findViewById(R.id.clear_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.undo_btn:
                mPerformEdit.undo();
                break;
            case R.id.redo_btn:
                mPerformEdit.redo();
                break;
            case R.id.clear_btn:
                mEditText.setText("");
                mPerformEdit.clearHistory();
                break;
        }
    }
}
