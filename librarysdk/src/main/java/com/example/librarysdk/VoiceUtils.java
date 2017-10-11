package com.example.librarysdk;

import android.content.Context;
import android.util.Log;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.TextUnderstander;
import com.iflytek.cloud.TextUnderstanderListener;
import com.iflytek.cloud.UnderstanderResult;

/**
 * Created by ${JT.L} on 2017/10/10.
 */

public class VoiceUtils {
    private Context mContext;
    private IVoiceHelper mVoiceHelper;

    public static String TAG= VoiceUtils.class.getSimpleName();
    //讯飞语义理解;
    private TextUnderstander mTextUnderstander;


    public VoiceUtils(Context context) {
        this.mContext=context;
        mTextUnderstander = TextUnderstander.createTextUnderstander(mContext, mTextUdrInitListener);
    }
    public VoiceUtils(Context context, String data) {
        this.mContext=context;
        mTextUnderstander = TextUnderstander.createTextUnderstander(mContext, mTextUdrInitListener);
    }
    public VoiceUtils(Context context, String data, IVoiceHelper voiceHelper) {
        this.mContext=context;
        mTextUnderstander = TextUnderstander.createTextUnderstander(mContext, mTextUdrInitListener);
        mVoiceHelper=voiceHelper;

        dealTransaction(data,mVoiceHelper);
    }

    public void dealTransaction(String data,IVoiceHelper vh){
        mVoiceHelper=vh;
        mTextUnderstander.understandText(data,mTextUnderstanderListener);
    }


    private TextUnderstanderListener mTextUnderstanderListener = new TextUnderstanderListener() {
        @Override
        public void onResult(UnderstanderResult understanderResult) {
                String data=understanderResult.getResultString();
                mVoiceHelper.onSuccess(data);
        }
        @Override
        public void onError(SpeechError speechError) {
            String s = speechError.toString();
            mVoiceHelper.onError(s);
        }
    };

    private InitListener mTextUdrInitListener = new InitListener() {

        @Override
        public void onInit(int code) {
            Log.d(TAG, "textUnderstanderListener init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
                Log.d(TAG, "初始化失败,错误码：" + code);
            }
        }
    };




}
