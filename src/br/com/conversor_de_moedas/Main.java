package br.com.conversor_de_moedas;

import br.com.conversor_de_moedas.enums.CurrencyOptions;
import br.com.conversor_de_moedas.models.CurrencyMap;
import br.com.conversor_de_moedas.models.CurrencyPairConversion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try{
            System.out.println("Seja bem vindo ao conversor de moedas");

            Scanner scanner = new Scanner(System.in);
            Stack<CurrencyPairConversion> history = new Stack<>();
            Boolean running = true;
            var gson = new GsonBuilder().setPrettyPrinting().create();
            while(running){
                var optionsMap = new CurrencyMap().getMap();
                var entryList = new ArrayList<>(optionsMap.entrySet());
                System.out.println("Escolha a moeda base");
                for (int i = 0; i < entryList.size(); i++){
                    var entry = entryList.get(i);
                    System.out.println(i + 1 +") " + entry.getValue());
                }
                System.out.println("9) Histórico");
                System.out.println("0) Sair");

                var scannerFrom = scanner.nextInt();
                if(scannerFrom == 0){
                    running = false;
                    continue;
                }

                if(scannerFrom == 9){
                    System.out.println("\n************** ínicio histórico **************");
                    System.out.println(gson.toJson(history));
                    System.out.println("************** fim histórico **************\n");
                    continue;
                }

                System.out.println("Escolha a moeda de conversão");
                for (int i = 0; i < entryList.size(); i++){
                    var entry = entryList.get(i);
                    System.out.println(i + 1 +") " + entry.getValue());
                }
                System.out.println("9) Histórico");
                System.out.println("0) Sair");

                var scannerTo = scanner.nextInt();

                if(scannerTo == 0){
                    running = false;
                    continue;
                }

                if(scannerTo == 9){
                    System.out.println("\n************** ínicio histórico **************");
                    System.out.println(gson.toJson(history));
                    System.out.println("************** fim histórico **************\n");
                    continue;
                }

                System.out.println("Digite o valor que deseja converter");

                var toConvertValue = scanner.nextDouble();
                var from = entryList.get(scannerFrom - 1).getKey();
                var to = entryList.get(scannerTo - 1).getKey();
                var conversion = new CurrencyPairConversion(from, to, toConvertValue);
                history.add(conversion);
                System.out.println("O valor convertido é " + conversion.getConvertedValue());
            }


        }
        catch (Exception exception){
            System.out.println(exception);
        }


    }
}