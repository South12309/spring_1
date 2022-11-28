package com.gb;

import com.gb.market.Cart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)  {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.gb.market");
        Cart cart = context.getBean(Cart.class);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isExit=false;
        while (!isExit) {
            String readLine = null;
            try {
                readLine = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] splitReadLine = readLine.split(" ");
            String command = splitReadLine[0];
            int id=0;
            try {
                id = Integer.parseInt(splitReadLine[1]);
            } catch (ArrayIndexOutOfBoundsException e) {
               // id=0;
            }
            switch (command) {
                case "add" -> cart.addProduct(id);
                case "delete" -> cart.deleteProduct(id);
                case "show" -> cart.printProducts();
                case "exit" -> isExit=true;
            }

        }
    }
}