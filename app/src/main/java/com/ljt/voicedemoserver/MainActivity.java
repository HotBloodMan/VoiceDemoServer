package com.ljt.voicedemoserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.UnderstanderResult;
import com.ljt.voicedemoserver.interfaces.IVoiceHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et;
    private TextView tvShow;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn_ok);
        et = (EditText) findViewById(R.id.et);
        tvShow = (TextView) findViewById(R.id.tvShow);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String s = et.getText().toString();
        VoiceUtils utils = new VoiceUtils(this);
        utils.dealTransaction(s, new IVoiceHelper() {
            @Override
            public void onSuccess(String replay) {
                tvShow.setText(replay);
                Toast.makeText(MainActivity.this, "onSuccess= " + replay, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(String data) {
                tvShow.setText(data);
                Toast.makeText(MainActivity.this,"onError= "+data,Toast.LENGTH_LONG).show();
            }

//            @Override
//            public void onSuccess(UnderstanderResult replay) {
//                String text = replay.getResultString();
//                tvShow.setText(text);
//                Toast.makeText(MainActivity.this,"onSuccess= "+text,Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onError(SpeechError data) {
//                int errorCode = data.getErrorCode();
//                tvShow.setText(errorCode);
//                Toast.makeText(MainActivity.this,"onError= "+data,Toast.LENGTH_LONG).show();
//            }
//        });
        });

    }
}
