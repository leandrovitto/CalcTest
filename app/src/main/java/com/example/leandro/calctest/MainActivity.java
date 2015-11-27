package com.example.leandro.calctest;


import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Float;
import android.view.View.OnClickListener;


public class MainActivity extends Activity {

    public TextView textView_memoria,textView_parziale;
    //private Button buttonSum;
    private double risultato=0;

    public double getRisultato(){
        return risultato;
    }
    public void setRisultato(double s){
        risultato = s;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_parziale = (TextView) findViewById(R.id.textView_parziale);
        textView_memoria = (TextView) findViewById(R.id.textView_memoria);
        Button buttonSum=(Button)findViewById(R.id.buttonPiu);
        Button button0=(Button)findViewById(R.id.button0);
        Button button1=(Button)findViewById(R.id.button1);
        Button button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        Button button4=(Button)findViewById(R.id.button4);
        Button button5=(Button)findViewById(R.id.button5);
        Button button6=(Button)findViewById(R.id.button6);
        Button button7=(Button)findViewById(R.id.button7);
        Button button8=(Button)findViewById(R.id.button8);
        Button button9=(Button)findViewById(R.id.button9);
        Button buttonC=(Button)findViewById(R.id.buttonC);

        button1.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
               textView_parziale.setText(textView_parziale.getText().toString() + "1");
            }
        });
        button2.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                textView_parziale.setText(textView_parziale.getText().toString() + "2");
            }
        });
        button3.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                textView_parziale.setText(textView_parziale.getText().toString() + "3");
            }
        });
        button4.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                textView_parziale.setText(textView_parziale.getText().toString() + "4");
            }
        });
        button5.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                textView_parziale.setText(textView_parziale.getText().toString() + "5");
            }
        });
        button6.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                textView_parziale.setText(textView_parziale.getText().toString() + "6");
            }
        });
        button7.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                textView_parziale.setText(textView_parziale.getText().toString() + "7");
            }
        });
        button8.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                textView_parziale.setText(textView_parziale.getText().toString() + "8");
            }
        });
        button9.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                textView_parziale.setText(textView_parziale.getText().toString() + "9");
            }
        });
        button0.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                textView_parziale.setText(textView_parziale.getText().toString() + "0");
            }
        });
        buttonC.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!textView_parziale.getText().toString().matches("")) {
                    String testo = textView_parziale.getText().toString().substring(0,
                                   textView_parziale.getText().toString().length() - 1);
                    textView_parziale.setText(testo);
                }
            }
        });

    //  MODIFICA DAL PC MAC
        //public void addListenerOnButton(){
            //buttonSum.setOnClickListener((OnClickListener) this);
            buttonSum.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v) {
                    double temp=getRisultato();

                    String value=textView_parziale.getText().toString();

                    temp+= Double.valueOf(value).doubleValue();
                    textView_memoria.setText(String.valueOf((int)temp).toString());
                    textView_parziale.setText("");

                    //textView_memoria.setText(temp);
                    setRisultato(temp);
                    //-------------------------<<<>>>>>>>>>>>>>>>>setRisultato(temp);
                    //String value2=textView_parziale.getText().toString();
                    //int a=Integer.parseInt(value1);
                    //int b=Integer.parseInt(value2);
                    //int sum=a+b;
                    Toast.makeText(getApplicationContext(),String.valueOf(value),Toast.LENGTH_LONG).show();
                }
            });
        //}
    }
    //@Override
    /*public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/

}

