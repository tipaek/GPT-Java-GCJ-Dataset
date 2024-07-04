package main.java;

import java.util.HashSet;
import java.util.Scanner;

public class Playground {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();


        for (int index = 0; index < cases ; index++) {
            int columns = sc.nextInt();
            int rows = columns;
            int k = 0, r = 0, c =0;
            int twoD[][] = new int[rows][columns];
            HashSet<Integer> Rowset = new HashSet<Integer>();
            HashSet<Integer> Colset = new HashSet<Integer>();
            


            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    twoD[i][j] = sc.nextInt();
                    if( i == j){
                        k += twoD[i][i];
                    }
                }
            }

            System.out.println("Case #" + cases + ": " + k + " " + " " + r + " " + c);

        }
    }
}