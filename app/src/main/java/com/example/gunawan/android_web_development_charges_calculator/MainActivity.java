package com.example.gunawan.android_web_development_charges_calculator;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends Activity {

    static final String LOGO_DESIGN = "logo_design";
    static final String WEB_HOSTING = "web_hosting";
    static final String DOMAIN_REGISTRATION = "domain_registration";
    static final String SSL = "ssl";
    static final String DEVELOPMENT = "development";
    static final String SEO = "seo";
    static final String SUBTOTAL = "subtotal";
    static final String GST = "gst";
    static final String TOTAL = "total";
    static final Double GST_RATE = 0.1;

    private EditText etxLogoDesign;
    private EditText etxWebHosting;
    private EditText etxDomainRegistration;
    private EditText etxSSLCertificate;
    private EditText etxWebDevelopment;
    private EditText etxSEO;
    private EditText etxSubTotal;
    private EditText etxGST;
    private EditText etxTotal;


    private Button btnCalculate;
    View.OnClickListener btnCalculate_Click;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate_Click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.calculating_start,
                        Toast.LENGTH_LONG).show();


                Toast.makeText(getApplicationContext(), R.string.calculating_stop,
                        Toast.LENGTH_SHORT).show();
            }
        };
        etxLogoDesign = (EditText) findViewById(R.id.etxLogoDesign);

        etxLogoDesign.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Recalculate();
            }
        });

        etxWebHosting = (EditText) findViewById(R.id.etxWebHosting);
        etxLogoDesign.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Recalculate();
            }
        });

        etxDomainRegistration = (EditText) findViewById(R.id.etxDomainRegistration);
        etxDomainRegistration.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Recalculate();
            }
        });

        etxSSLCertificate = (EditText) findViewById(R.id.etxSSLCertificate);
        etxSSLCertificate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Recalculate();
            }
        });

        etxWebDevelopment = (EditText) findViewById(R.id.etxWebDevelopment);
        etxWebDevelopment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Recalculate();
            }
        });

        etxSEO = (EditText) findViewById(R.id.etxSEO);
        etxSEO.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Recalculate();
            }
        });

        etxSubTotal = (EditText) findViewById(R.id.etxSubTotal);
        etxGST = (EditText) findViewById(R.id.etxGST);
        etxTotal = (EditText) findViewById(R.id.etxTotal);

        btnCalculate = (Button)findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(btnCalculate_Click);

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("TEXT","onSaveInstanceState Start");
        outState.putString(LOGO_DESIGN,etxLogoDesign.getText().toString());
        outState.putString(WEB_HOSTING,etxWebHosting.getText().toString());
        outState.putString(DOMAIN_REGISTRATION,etxDomainRegistration.getText().toString());
        outState.putString(SSL,etxSSLCertificate.getText().toString());
        outState.putString(DEVELOPMENT,etxWebDevelopment.getText().toString());
        outState.putString(SEO,etxSEO.getText().toString());
        outState.putString(SUBTOTAL,etxSubTotal.getText().toString());
        outState.putString(GST,etxGST.getText().toString());
        outState.putString(TOTAL,etxTotal.getText().toString());
        Log.d("TEXT","onSaveInstanceState Stop");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("TEXT","onRestoreInstanceState Start");
        etxLogoDesign.setText(savedInstanceState.getString(LOGO_DESIGN));
        etxWebHosting.setText(savedInstanceState.getString(WEB_HOSTING));
        etxDomainRegistration.setText(savedInstanceState.getString(DOMAIN_REGISTRATION));
        etxSSLCertificate.setText(savedInstanceState.getString(SSL));
        etxSubTotal.setText(savedInstanceState.getString(SUBTOTAL));
        etxGST.setText(savedInstanceState.getString(GST));
        etxTotal.setText(savedInstanceState.getString(TOTAL));
        Log.d("TEXT","onRestoreInstanceState Stop");
    }

    protected void Recalculate()
    {
        Log.d("TEXT","Recalculate");
        Double subtotal = 0.0d;
        Double total = 0.0d;

        Log.d("TEXT","Twilight zone");
        if(etxLogoDesign.getText().length() > 0) {
            subtotal += Double.parseDouble(etxLogoDesign.getText().toString());
            Log.d("TEXT","0");
        }

        if(etxWebHosting.getText().length() > 0) {
            subtotal += Double.parseDouble(etxWebHosting.getText().toString());
            Log.d("TEXT","1");
        }

        if(etxDomainRegistration.getText().length() > 0) {
            subtotal += Double.parseDouble(etxDomainRegistration.getText().toString());
            Log.d("TEXT","2");
        }

        if(etxSSLCertificate.getText().length() > 0) {
            subtotal += Double.parseDouble(etxSSLCertificate.getText().toString());
            Log.d("TEXT","3");
        }

        etxSubTotal.setText(String.format("%.2f",subtotal));

        total = subtotal + (subtotal * GST_RATE);

        etxGST.setText(String.format("%.2f",subtotal * GST_RATE));

        etxTotal.setText(String.format("%.2f",total));
    }
}
