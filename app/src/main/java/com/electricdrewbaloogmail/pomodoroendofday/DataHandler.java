package com.electricdrewbaloogmail.pomodoroendofday;

import android.app.Application;
import android.content.Context;
import android.text.style.TtsSpan;

import java.math.BigDecimal;


import java.lang.reflect.Field;



/**
 * Created by drewdyer-symonds on 6/15/17.
 */

public class DataHandler {

    private BigDecimal CC_PROCESSING_CONST = BigDecimal.ZERO;
    private BigDecimal TAX_CONST = BigDecimal.ZERO;
    private BigDecimal REGISTER_AMOUNT = BigDecimal.ZERO;

    // These fields can be set by the user from the MainActivity textViews
    private BigDecimal cashSales = BigDecimal.ZERO;
    private BigDecimal cardSales = BigDecimal.ZERO;
    private BigDecimal checkSales = BigDecimal.ZERO;
    private BigDecimal autoGratuityCard = BigDecimal.ZERO;
    private BigDecimal autoGratuityCash = BigDecimal.ZERO;
    private BigDecimal autoGratuityCheck = BigDecimal.ZERO;
    private BigDecimal gcSold = BigDecimal.ZERO;
    private BigDecimal gcRedeemed = BigDecimal.ZERO;
    private BigDecimal dinners = BigDecimal.ZERO;
    private BigDecimal totalCash = BigDecimal.ZERO;
    private BigDecimal cardTips = BigDecimal.ZERO;


    // These Fields need to be calculated
    private BigDecimal ccProcessing = BigDecimal.ZERO;
    private BigDecimal autoGratTax = BigDecimal.ZERO;
    private BigDecimal totalDay = BigDecimal.ZERO;
    private BigDecimal totalTips = BigDecimal.ZERO;
    private BigDecimal autoGratTotal = BigDecimal.ZERO;
    private BigDecimal cashTips = BigDecimal.ZERO;


    private static DataHandler handler = new DataHandler();

    private DataHandler() {
        // Singleton Constructor
    }

    public static DataHandler getInstance() {
        return handler;
    }

    public void calculateTotals() {
        CC_PROCESSING_CONST = App.getCcProcessingConst();
        TAX_CONST = App.getTaxConst();
        REGISTER_AMOUNT = App.getRegisterAmount();
        cashTips = totalCash.subtract(cashSales).subtract(new BigDecimal(200));
        ccProcessing = autoGratuityCard.add(cardTips).multiply(CC_PROCESSING_CONST);
        autoGratTotal = autoGratuityCard.add(autoGratuityCash).add(autoGratuityCheck);

        totalDay = cashSales.add(cardSales).add(checkSales).add(gcRedeemed).add(ccProcessing).
                subtract(gcSold).subtract(autoGratTotal);

        cashTips = totalCash.subtract(cashSales);
        autoGratTax = autoGratuityCard.multiply(TAX_CONST);
        totalTips = cashTips.add(cardTips).add(autoGratTotal).
                subtract(ccProcessing).subtract(autoGratTax);
    }


    // GETTERS WITH NO SETTERS

    public BigDecimal getCcProcessing() {
        return ccProcessing;
    }

    public BigDecimal getAutoGratTax() {
        return autoGratTax;
    }

    public BigDecimal getTotalDay() {
        return totalDay;
    }

    public BigDecimal getTotalTips() {
        return totalTips;
    }

    public BigDecimal getAutoGratTotal() {
        return autoGratTotal;
    }

    public BigDecimal getCashTips() {
        return cashTips;
    }


    // GETTERS AND SETTERS
    public  BigDecimal getCashSales() {
        return cashSales;
    }public void           setCashSales(BigDecimal cashSales) {
        this.cashSales = cashSales;
    }public BigDecimal getCardSales() {
        return cardSales;
    }public void           setCardSales(BigDecimal cardSales) {
        this.cardSales = cardSales;
    }public BigDecimal getCheckSales() {
        return checkSales;
    }public void           setCheckSales(BigDecimal checkSales) {
        this.checkSales = checkSales;
    }public BigDecimal getAutoGratuityCard() {
        return autoGratuityCard;
    }public void           setAutoGratuityCard(BigDecimal autoGratuityCard) {
        this.autoGratuityCard = autoGratuityCard;
    }public BigDecimal getAutoGratuityCash() {
        return autoGratuityCash;
    }public void           setAutoGratuityCash(BigDecimal autoGratuityCash) {
        this.autoGratuityCash = autoGratuityCash;
    }public BigDecimal getAutoGratuityCheck() {
        return autoGratuityCheck;
    }public void           setAutoGratuityCheck(BigDecimal autoGratuityCheck) {
        this.autoGratuityCheck = autoGratuityCheck;
    }public BigDecimal getGcSold() {
        return gcSold;
    }public void           setGcSold(BigDecimal gcSold) {
        this.gcSold = gcSold;
    }public BigDecimal getGcRedeemed() {
        return gcRedeemed;
    }public void           setGcRedeemed(BigDecimal gcRedeemed) {
        this.gcRedeemed = gcRedeemed;
    }public BigDecimal getDinners() {
        return dinners;
    }public void           setDinners(BigDecimal dinners) {
        this.dinners = dinners;
    }public BigDecimal getTotalCash() {
        return totalCash;
    }public void           setTotalCash(BigDecimal totalCash) {
        this.totalCash = totalCash;
    }public BigDecimal getCardTips() {
        return cardTips;
    }public void           setCardTips(BigDecimal cardTips) {
        this.cardTips = cardTips;
    }
}
