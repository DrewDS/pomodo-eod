package com.electricdrewbaloogmail.pomodoroendofday;

import android.app.Application;
import android.content.Context;

import java.math.BigDecimal;

/**
 * Created by drewdyer-symonds on 6/15/17.
 */

public class App extends Application {

    // static resources
    private static BigDecimal ccProcessingConst;
    private static BigDecimal taxConst;
    private static BigDecimal registerAmount;

    public static void initResources(Context context) {
        ccProcessingConst = new BigDecimal(Double.parseDouble(context.getResources().getString(R.string.cc_processing_fee))/100);
        taxConst = new BigDecimal(Double.parseDouble(context.getResources().getString(R.string.tax_rate))/100);
        registerAmount = new BigDecimal(Double.parseDouble(context.getResources().getString(R.string.register_amount)));
    }

    // getters
    public static BigDecimal getCcProcessingConst() { return ccProcessingConst; }

    public static BigDecimal getTaxConst() {
        return taxConst;
    }

    public static BigDecimal getRegisterAmount() { return registerAmount; }

}
