package com.example.bayes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class BayesActivity extends Activity {

    private LinearLayout layout;
    private TextView tvPA, tvPXA, tvPXnA, tvResult;
    private SeekBar sbPA, sbPXA, sbPXnA;
    private  ProgressBar pb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.drawable.main);
        layout = (LinearLayout) findViewById(R.drawable.main);

        tvPA = (TextView) findViewById(R.id.textView_pA);
        tvPXA = (TextView) findViewById(R.id.textView_pXA);
        tvPXnA = (TextView) findViewById(R.id.textView_pXnA);
        tvResult = (TextView) findViewById(R.id.textView_Result);
        sbPA = (SeekBar) findViewById(R.id.seekBar_pA);
        sbPXA = (SeekBar) findViewById(R.id.seekBar_pXA);
        sbPXnA = (SeekBar) findViewById(R.id.seekBar_pXnA);
        pb = (ProgressBar) findViewById(R.id.progressBar);

        sbPA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                 tvPA.setText(String.valueOf((double)progress/(double)2));
                 reCalc();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        sbPXA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvPXA.setText(String.valueOf((double)progress/(double)2));
                reCalc();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        sbPXnA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvPXnA.setText(String.valueOf((double)progress/(double)2));
                reCalc();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    public void reCalc() {
     double Res,pA,pXA,pXnA;
        pA = ((double)sbPA.getProgress()/(double)2) / (double)100;
        pXA = ((double)sbPXA.getProgress()/(double)2) / (double)100;
        pXnA = ((double)sbPXnA.getProgress()/(double)2) / (double)100;
        Res =  (pA * pXA) / (pA * pXA + (1-pA) * pXnA);
        int dRes = (int)(Res*100*100);
        Res = (double)dRes / 100.0;
        tvResult.setText(String.valueOf(Res));
        pb.setProgress(2*dRes/100);
    }


}
