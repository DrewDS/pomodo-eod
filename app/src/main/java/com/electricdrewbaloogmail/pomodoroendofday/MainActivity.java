package com.electricdrewbaloogmail.pomodoroendofday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.math.BigDecimal;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.electricdrewbaloogmail.pomodoroendofday.R.id.fab;

public class MainActivity extends AppCompatActivity {

    // Pass this context when creating instance of EODCalculator
    //Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initialize resources like tax_rate and cc_processing_fee
        App.initResources(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void calculate(View view) {

        DataHandler handler = DataHandler.getInstance();

        // set values in DataHandler instance for calculation
        setCalcValues();

        // calculate totals
        handler.calculateTotals();

        // switch to display total view
        Intent intent = new Intent(this, DisplayTotalActivity.class);
        startActivity(intent);

    }

    private void setCalcValues() {
        DataHandler handler = DataHandler.getInstance();
        handler.setCashSales(Tools.parseBD(this, "cash_sales"));
        handler.setCardSales(Tools.parseBD(this, "card_sales"));
        handler.setCheckSales(Tools.parseBD(this, "check_sales"));
        handler.setAutoGratuityCard(Tools.parseBD(this, "auto_grat_card"));
        handler.setAutoGratuityCash(Tools.parseBD(this, "auto_grat_cash"));
        handler.setAutoGratuityCheck(Tools.parseBD(this, "auto_grat_check"));
        handler.setGcSold(Tools.parseBD(this, "gc_sold"));
        handler.setGcRedeemed(Tools.parseBD(this, "gc_redeemed"));
        handler.setDinners(Tools.parseBD(this, "dinners"));
        handler.setTotalCash(Tools.parseBD(this, "total_cash"));
        handler.setCardTips(Tools.parseBD(this, "card_tips"));
    }
    


}
