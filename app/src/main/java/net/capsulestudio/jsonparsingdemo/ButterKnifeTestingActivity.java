package net.capsulestudio.jsonparsingdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButterKnifeTestingActivity extends AppCompatActivity {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_university)
    EditText etUniversity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife_testing);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_Save, R.id.btn_Send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_Save:

                break;
            case R.id.btn_Send:
                break;
        }
    }
}
