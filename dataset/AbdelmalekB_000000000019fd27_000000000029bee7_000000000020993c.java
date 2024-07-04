package com.company;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int  n= sc.nextInt();
        int k=0 , r=0 , c=0 ;
        int[][] tab = new int[n][n];

        for(int i=0 ; i<n ; i++) {
            for (int j = 0; j < n; j++) {
                tab[i][j] = sc.nextInt();
            }
            k = k + tab[i][i];

            boolean b = false;
            int j=0 , x , z;

            while (b == false && j< n) {
                x=tab[i][j];
                z=0;
                while(b==false && z<n ){
                    if (tab[i][z]==x && z!=j){
                        b=true;
                    }
                    z++;
                }
                j++;
            }
            if(b==true){
                r++;
            }
        }

        for(int i=0 ; i<n ;i++ ){
            boolean b = false;
            int j=0 , x , z;
            while (b == false && j< n) {
                x=tab[j][i];
                z=0;
                while(b==false && z<n ){
                    if (tab[z][i]==x && z!=j){
                        b=true;
                    }
                    z++;
                }
                j++;
            }
            if(b==true){
                c++;
            }
        }

        System.out.println(c);



       
    }
}
