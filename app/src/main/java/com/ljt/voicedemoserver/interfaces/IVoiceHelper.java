package com.ljt.voicedemoserver.interfaces;

import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.UnderstanderResult;

/**
 * Created by ${JT.L} on 2017/10/10.
 */

public interface IVoiceHelper {
    void onSuccess(String replay);
    void onError(String data);
}
