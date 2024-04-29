package br.com.conversor_de_moedas.enums;

public enum CurrencyOptions {
    USD("DOLAR"),
    EUR("EURO"),
    BRL("REAL"),
    ARS("PESO ARGENTINO"),
    COP("PESO COLOMBIANO");

    public final String label;
    private CurrencyOptions(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    public static boolean contains(String test) {

        for (CurrencyOptions c : CurrencyOptions.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }

        return false;
    }
}
