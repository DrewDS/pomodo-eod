package com.electricdrewbaloogmail.pomodoroendofday;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;
import java.math.BigDecimal;
import java.text.NumberFormat;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.electricdrewbaloogmail.pomodoroendofday.R.id.auto;
import static com.electricdrewbaloogmail.pomodoroendofday.R.id.fab;

public class DisplayTotalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_total);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setDisplayValuesFromHandler();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void setDisplayValuesFromHandler() {

        DataHandler handler = DataHandler.getInstance();
        NumberFormat dollars = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat number = NumberFormat.getNumberInstance(Locale.US);

        TextView cashSales = (TextView) findViewById(R.id.cash_sales);
        cashSales.append(dollars.format(handler.getCashSales()));

        TextView cardSales = (TextView) findViewById(R.id.card_sales);
        cardSales.append(dollars.format(handler.getCardSales()));

        TextView checkSales = (TextView) findViewById(R.id.check_sales);
        checkSales.append(dollars.format(handler.getCheckSales()));

        TextView autoGratTotal = (TextView) findViewById(R.id.auto_grat_total);
        autoGratTotal.append(dollars.format(handler.getAutoGratTotal()));

        TextView autoGratCard = (TextView) findViewById(R.id.auto_grat_card);
        autoGratCard.append(dollars.format(handler.getAutoGratuityCard()));

        TextView autoGratCash = (TextView) findViewById(R.id.auto_grat_cash);
        autoGratCash.append(dollars.format(handler.getAutoGratuityCash()));

        TextView autoGratCheck = (TextView) findViewById(R.id.auto_grat_check);
        autoGratCheck.append(dollars.format(handler.getAutoGratuityCheck()));

        TextView ccProcessing = (TextView) findViewById(R.id.cc_processing);
        ccProcessing.append(dollars.format(handler.getCcProcessing()));

        TextView totalDay = (TextView) findViewById(R.id.total_day);
        totalDay.append(dollars.format(handler.getTotalDay()));

        TextView dinners = (TextView) findViewById(R.id.dinners);
        dinners.append(number.format(handler.getDinners()));

        TextView totalTips = (TextView) findViewById(R.id.total_tips);
        totalTips.append(dollars.format(handler.getTotalTips()));

        TextView cashTips = (TextView) findViewById(R.id.cash_tips);
        cashTips.append(dollars.format(handler.getCashTips()));

        TextView cardTips = (TextView) findViewById(R.id.card_tips);
        cardTips.append(dollars.format(handler.getCardTips()));

        TextView autoGratTotal2 = (TextView) findViewById(R.id.auto_grat_total_2);
        autoGratTotal2.append(dollars.format(handler.getAutoGratTotal()));

        TextView autoGratTax = (TextView) findViewById(R.id.auto_grat_tax);
        autoGratTax.append(dollars.format(handler.getAutoGratTax()));


    }


}
