package ehb.be.helloasynctask.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import ehb.be.helloasynctask.R;
import ehb.be.helloasynctask.util.ProgressTask;
//2.
public class MainActivity extends AppCompatActivity {

    private ProgressBar pbBar;
    private TextView tvText;//3.b.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbBar = findViewById(R.id.pb_Bar);
        tvText = findViewById(R.id.tv_text);


        ProgressTask pt = new ProgressTask(tvText);//3.c.
        pt.execute(pbBar);

    }
}
