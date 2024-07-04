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
      
        for (int i = 1; i <= t; i++) {ArrayList<Integer> ar=new ArrayList();
        ArrayList<Integer> arj=new ArrayList();
            int n=x.nextInt();
             int tab[][]=new int[n][2];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    tab[j][k]=x.nextInt();
                        }
            }
            /*for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.print(" "+tab[j][k]);
                }
                System.out.println("");
            }*/String s="";
           
                
                    s="C";ar.add(tab[0][0]);
                    ar.add(tab[0][1]);
                boolean test=true;
                for (int k = 1; k < n; k++) {
                    if(verefication(tab[k][0], tab[k][1], ar)){
                        s=s+"C"; ar.add(tab[k][0]);ar.add(tab[k][1]);
                    }else{if (test){
                         s=s+"J";
                         arj.add(tab[k][0]);arj.add(tab[k][1]);
                         test=false;//for the first time
                    }else if(verefication(tab[k][0], tab[k][1], arj)){
                         s=s+"J"; arj.add(tab[k][0]);arj.add(tab[k][1]);
                    }
                       
                    }
                }
                String text="";
                if(s.length()==n)text=s;
                else text="IMPOSSIBLE";
            
            
            
          /*360 480
420 540
600 660*/
            
            
            
            System.out.println("Case #"+i+": "+text);
        }
   
    }
static boolean verefication(int st,int et,ArrayList<Integer> ar){
    boolean test=false;
    for (int i = 0; i < ar.size()/2; i=i+2) {
        if((st<ar.get(i)&& et<=ar.get(i))||(ar.get(i+1)<=st && ar.get(i+1)<et)){
            test=true;break;
        }
    }
return test;}
 
    
}
