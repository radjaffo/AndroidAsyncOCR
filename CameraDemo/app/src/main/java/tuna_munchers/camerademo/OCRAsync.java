package tuna_munchers.camerademo;

import com.googlecode.leptonica.android.ReadFile;
import com.googlecode.tesseract.android.TessBaseAPI;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Message;
import android.util.Log;
import android.graphics.Bitmap;
import android.os.Handler;
import android.content.Context;



/**
 * Created by radjaffo on 4/21/15.
 */
public class OCRAsync extends AsyncTask<Void, Integer, String> {

    private static final String TAG = OCRAsync.class.getSimpleName();

    public static final String PATH1 = Environment
            .getExternalStorageDirectory().toString() + "/CameraDemo/";
    protected String PATH2;
    public static final String Language = "eng";

    private TessBaseAPI tessApi;
    private Bitmap bitmap;
    private Context context;
    private OCRCallback callback;

    public OCRAsync(Context context, Bitmap bitmap){
        this.context = context;
        this.bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);

    }

    protected void onPreExecute() {
        Log.d(TAG,"Setting up OCR" );
        PATH2 = PATH1 + "/ocr.jpg";
        tessApi = new TessBaseAPI();
        tessApi.setDebug(true);
        tessApi.init(PATH1, Language);
        tessApi.setImage(bitmap);
    }

    protected String doInBackground(Void... params) {
            //this is the resource intensive part
            String recognizedText = tessApi.getUTF8Text();
        if (Language.equalsIgnoreCase("eng")) {
            recognizedText = recognizedText.replaceAll("[^a-zA-Z0-9]+", " ");
        }

        //takes out the leading and ending white spaces from the string
        recognizedText = recognizedText.trim();

        Log.v(TAG, "FINAL TEXT: " + recognizedText);

        return recognizedText;
    }

    @Override
    protected void onPostExecute(String finish) {
        //always close the api, bad things happen if you leave it open and recall it.
        tessApi.end();
    }

}