package com.codejam;

import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte totalTestCases = scanner.nextByte();

        for (byte i = 0; i < totalTestCases; i++) {
            byte number = scanner.nextByte();

            int rowSum = 0;
            int columnSum = 0;
            int trace = 0;
            byte rowDuplicate = 0;
            byte columnDuplicate = 0;
            byte matrix[][] = new byte[number][number];
            for (byte j = 0; j < number ; j++) {
                boolean duplicate[] = new boolean[number+1];
                boolean flag = false;
                for (byte k = 0; k < number; k++) {
                    byte currentNumber = scanner.nextByte();
                     if(duplicate[currentNumber] && !flag) {
                         rowDuplicate += 1;
                         flag = true;
                     }
                     else
                         duplicate[currentNumber] = true;
                     if(k == j)
                         trace += currentNumber;
                     matrix[j][k] = currentNumber;
                }

            }

            for (byte j = 0; j < number ; j++) {
                boolean duplicate[] = new boolean[number +1];
                boolean flag = false;
                for (byte k = 0; k < number; k++) {
                   byte currentNumber =  matrix[k][j];
                    if(duplicate[currentNumber] && !flag) {
                        columnDuplicate += 1;
                        flag = true;
                    }
                    else
                        duplicate[currentNumber] = true;
                }

            }

            System.out.printf("Case #%d: %d %d %d %n",i,trace,rowDuplicate,columnDuplicate);


        }
        
    }
}
