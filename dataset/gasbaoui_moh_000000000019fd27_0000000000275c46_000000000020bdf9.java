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

     static int [][]reorder(int [][]a){
     for (int i = 0; i < a[0].length; i++) {
    // Track number of elements swapped during a single array traversal
   int numberOfSwaps = 0;
    
    for (int j = 0; j < a[0].length - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[0][j] > a[0][j + 1]) {
           // swap(a[j], a[j + 1]);
            int o=a[1][j];
            int o1=a[0][j];
            a[1][j]=a[1][j+1];
            a[0][j]=a[0][j+1];
            
            a[1][j+1]=o;a[0][j+1]=o1;
          numberOfSwaps++;
        }
    }
    
    // If no elements were swapped during a traversal, array is sorted
    if (numberOfSwaps == 0) {
        break;
    }
}
return a;}
    public static void main(String[] args) {
      Scanner x=new Scanner(System.in);
      int t=x.nextInt();
      
        for (int i = 1; i <= t; i++) {ArrayList<Integer> ar=new ArrayList();
            int n=x.nextInt();
            int tab[][]=new int[2][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    tab[k][j]=x.nextInt();
                    if(k==0)ar.add(tab[k][j]);
                }/*99 150
1 100
100 301
2 5
150 250*/
                /*0 1440
1 3
2 4*/
            }reorder(tab);
            //-------------
           /* for (int j = 0; j < 2; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(" "+tab[j][k]);
                }
                System.out.println("");
            }*///------------------
            for (int j = 0; j < ar.size(); j++) {
             //    System.out.print("  "+ar.get(j));
            }ArrayList<Integer> f=new ArrayList<>();
            f=get_pos(tab, ar);
            for (int j = 0; j < f.size(); j++) {
               // System.out.println("__"+f.get(j));
            }
           
            String s="";
            int tmp=tab[1][0];
                   s="C";
                int tt=0;int ttt=0;
                for (int j = 1; j < n; j++) {
                    if(tmp<=tab[0][j]&& ttt<=tab[0][j]){
                        s=s+"C";ttt=tab[1][j];
                    }else{if(tt<=tab[0][j]){
                        s=s+"J";
                    tt=tab[1][j];}
                    }
                }String text="";
                if(s.length()==n){text=s;String new_s="";
                for (int j = 0; j < f.size(); j++) {
                new_s=new_s+text.charAt(f.get(j));
            }
                    text=new_s;/*System.out.println("new_s"+new_s);*/}
                else text="IMPOSSIBLE";
          /*360 480
420 540
600 660*/
            
            
            
            System.out.println("Case #"+i+": "+text);
        }
   
    }

  static ArrayList<Integer> get_pos(int [][] tab, ArrayList<Integer> ar){
       ArrayList<Integer> temp=new ArrayList<>();
       for (int i = 0; i < ar.size(); i++) {
           for (int j = 0; j < ar.size(); j++) {
               if(ar.get(i)==tab[0][j]){temp.add(j);break;}
           }
 
       }
 
    return temp;}  
    
}
