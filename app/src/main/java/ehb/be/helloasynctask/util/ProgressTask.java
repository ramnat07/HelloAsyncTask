package ehb.be.helloasynctask.util;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Created by mobapp07 on 2/03/2018.
 */
//1.
public class ProgressTask extends AsyncTask<ProgressBar, Integer, Void> {
    //3.
    private WeakReference<TextView> resultTV;

    public ProgressTask(TextView resultTV){
        this.resultTV = new WeakReference<TextView>(resultTV);//3.a.
    }

    @Override
    protected Void doInBackground(ProgressBar... progressBars) {

        for(ProgressBar pb: progressBars){
            for(int i=0; i <=100; i++){

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                pb.setProgress(i);
                publishProgress(i);//4.a.
            }
        }
        return null;
    }


    //4.

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        resultTV.get().setText(values[0]+"%");
    }

    @Override//3.d. een methode aanroepen
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        resultTV.get().setText("Done"); //3.e. als onze prBar klaar is dan komt op de scherm de word "Done"
    }
}
