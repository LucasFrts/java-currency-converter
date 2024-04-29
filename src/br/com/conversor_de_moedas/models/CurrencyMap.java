package br.com.conversor_de_moedas.models;

import br.com.conversor_de_moedas.enums.CurrencyOptions;

import java.util.HashMap;
import java.util.Map;

public class CurrencyMap {
    private Map<String, String> map;
    public CurrencyMap() {
        this.map = new HashMap<>();
        for (CurrencyOptions currency : CurrencyOptions.values()){
            this.map.put(currency.name(), currency.getLabel());
        }
    }
    public Map<String, String> getMap(){
        return this.map;
    }
}
