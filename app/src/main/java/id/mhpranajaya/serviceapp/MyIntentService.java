package id.mhpranajaya.serviceapp;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {

    public static String EXTRA_DURATION = "ExtraDurayion";
    public static final String TAG = MyIntentService.class.getSimpleName();

    public MyIntentService(){
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent !=null){
            int duration = intent.getIntExtra(EXTRA_DURATION, 0);
            try{
                Thread.sleep(duration);
                Log.d(TAG, "onHandleIntent: Selesai...");
            }catch (InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
