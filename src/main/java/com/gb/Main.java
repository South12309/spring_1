package com.gb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isExit=false;
        while (!isExit) {
            String readLine = reader.readLine();
            String[] splitReadLine = readLine.split(" ");
            String command = splitReadLine[0];
            int id = Integer.parseInt(splitReadLine[1]);
            switch (command) {
                
            }

        }
    }
}