package br.com.conversor_de_moedas.models;

import br.com.conversor_de_moedas.enums.CurrencyOptions;
import br.com.conversor_de_moedas.helpers.CurrencyRequest;

import java.io.IOException;
import java.text.DecimalFormat;

public class CurrencyPairConversion {
    private String baseCode;
    private String targetCode;
    private double conversionRate;
    private double originalValue;
    private double finalValue;

    public CurrencyPairConversion(String baseCode, String targetCode, double originalValue) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.originalValue = originalValue;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public double getConvertedValue() throws IOException, InterruptedException {
        var currency = CurrencyRequest.getCurrencyConversion(CurrencyOptions.valueOf(this.baseCode), CurrencyOptions.valueOf(this.targetCode));
        this.conversionRate = Double.valueOf(currency.conversionRate());
        var decimalFormat = new DecimalFormat("0.00");
        this.finalValue = Double.valueOf(
                decimalFormat
                        .format(this.originalValue * this.conversionRate)
                        .replace(",", ".")
        );
        return this.finalValue;
    }

    @Override
    public String toString() {
        return "\nMoeda base: " + this.baseCode + " conversao: " + this.targetCode + " "+ this.originalValue + " X " + this.conversionRate + " = " + this.finalValue;
    }
}
