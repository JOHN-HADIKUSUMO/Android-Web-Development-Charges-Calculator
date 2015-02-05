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

            }
        });

        etxWebHosting = (EditText) findViewById(R.id.etxWebHosting);
        etxDomainRegistration = (EditText) findViewById(R.id.etxDomainRegistration);
        etxSSLCertificate = (EditText) findViewById(R.id.etxSSLCertificate);
        etxWebDevelopment = (EditText) findViewById(R.id.etxWebDevelopment);
        etxSEO = (EditText) findViewById(R.id.etxSEO);
        etxSubTotal = (EditText) findViewById(R.id.etxSubTotal);
        etxGST = (EditText) findViewById(R.id.etxGST);
        etxTotal = (EditText) findViewById(R.id.etxTotal);

        btnCalculate = (Button)findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.calculating_start,
                        Toast.LENGTH_LONG).show();


                Toast.makeText(getApplicationContext(), R.string.calculating_stop,
                        Toast.LENGTH_SHORT).show();
            }
        });

        if(savedInstanceState != null)
        {
            etxLogoDesign.setText(String.format("%.2f",savedInstanceState.getDouble(LOGO_DESIGN)));
            etxWebHosting.setText(String.format("%.2f",savedInstanceState.getDouble(WEB_HOSTING)));
            etxDomainRegistration.setText(String.format("%.2f",savedInstanceState.getDouble(DOMAIN_REGISTRATION)));
            etxSSLCertificate.setText(String.format("%.2f",savedInstanceState.getDouble(SSL)));
            etxWebDevelopment.setText(String.format("%.2f",savedInstanceState.getDouble(DEVELOPMENT)));
            etxSEO.setText(String.format("%.2f",savedInstanceState.getDouble(SEO)));
            etxSubTotal.setText(String.format("%.2f",savedInstanceState.getDouble(SUBTOTAL)));
            etxGST.setText(String.format("%.2f",savedInstanceState.getDouble(GST)));
            etxTotal.setText(String.format("%.2f",savedInstanceState.getDouble(TOTAL)));
        }
        else
        {

        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(LOGO_DESIGN,Double.parseDouble(etxLogoDesign.getText().toString()));
        outState.putDouble(WEB_HOSTING,Double.parseDouble(etxWebHosting.getText().toString()));
        outState.putDouble(DOMAIN_REGISTRATION,Double.parseDouble(etxDomainRegistration.getText().toString()));
        outState.putDouble(SSL,Double.parseDouble(etxSSLCertificate.getText().toString()));
        outState.putDouble(DEVELOPMENT,Double.parseDouble(etxWebDevelopment.getText().toString()));
        outState.putDouble(SEO,Double.parseDouble(etxSEO.getText().toString()));
        outState.putDouble(SUBTOTAL,Double.parseDouble(etxSubTotal.getText().toString()));
        outState.putDouble(GST,Double.parseDouble(etxGST.getText().toString()));
        outState.putDouble(TOTAL,Double.parseDouble(etxTotal.getText().toString()));
    }

}
