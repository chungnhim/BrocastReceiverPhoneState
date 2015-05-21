package com.example.chungnhim.brocastreceiverphonestate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by CHUNGNHIM on 5/20/2015.
 */
public class PhoneStateEvent extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //Tai day lang nghe cac ban tin gui den
        //lay truong extra cua ban tin intent
        Bundle extra = intent.getExtras();
        if (extra != null) {
            //Lay trang thai cua cuoc goi
            String stateCall = extra.getString(TelephonyManager.EXTRA_STATE);
            Log.d("Phone State:", "Trang thai: " + stateCall);
            Log.d("Phone State:", "so sanh: " + TelephonyManager.EXTRA_STATE_RINGING);
            if (stateCall.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                String numberCall = extra.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.d("Phone State:","So DT goi toi:" + numberCall);
            }
        }
    }
}
