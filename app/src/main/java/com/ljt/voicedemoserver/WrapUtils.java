package com.ljt.voicedemoserver;

import android.content.Context;

import com.ljt.voicedemoserver.interfaces.IVoiceHelper;

/**
 * Created by ${JT.L} on 2017/10/10.
 */

public class WrapUtils {

    Context mContext;
//    IVoiceHelper voiceHelper;

    public WrapUtils(Context context,String data,IVoiceHelper voiceHelper) {
        this.mContext=context;
        VoiceUtils voiceUtils = new VoiceUtils(mContext);
        voiceUtils.dealTransaction(data,voiceHelper);
    }

}
