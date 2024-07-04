/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package javaapplication60;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author amine gasa
 */
public class Solution {

    public static void main(String[] args) {
      Scanner x=new Scanner(System.in);
      int t=x.nextInt();
      
        for (int i = 1; i <= t; i++) {
            int n=x.nextInt();
            int [][]tab=new int[n][n];
            int diag=0;int y=0;
            for (int j = 0; j < n; j++) {ArrayList<Integer>ar=new ArrayList();
                    for (int k = 0; k < n; k++) {
                    tab[j][k]=x.nextInt();
                    if(j==k)diag=diag+tab[j][k];
                    ar.add(tab[j][k]);
                }
                     y=y+verefication(ar);
            }
            //-----------------------
            int ee=0;
            for (int j = 0; j < n; j++) {ArrayList<Integer>ar=new ArrayList();
                for (int k = 0; k < n; k++) {
                    ar.add(tab[k][j]);
                }
                 ee=ee+verefication(ar);
            }
            
            
            System.out.println("Case #"+i+": "+diag+" "+y+" "+ee);
        }
    
    }

     static int verefication(ArrayList<Integer> a) {
         int c=0;
         for (int i = 0; i < a.size()-1; i++) {
             for (int j = i+1; j < a.size(); j++) {
                 if(a.get(i)==a.get(j)) return 1;
             }
         }
       
    return 0;}
    
}
