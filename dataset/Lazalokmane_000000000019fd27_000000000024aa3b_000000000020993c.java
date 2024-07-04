package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static Scanner sr = new Scanner(System.in);
    public static void solve4(){
        int n=sr.nextInt();
        ArrayList<ArrayList> mat=new ArrayList<>();
        int  sum=0;
        for(int i=0;i<n;i++){
            ArrayList<Integer> ligne=new ArrayList<>();
            for(int j=0;j<n;j++){
                ligne.add(sr.nextInt());
                if(i==j)sum=sum+ligne.get(j);
            }mat.add(ligne);
        }
        int h=0,v=0,h1=0,v1=0;
        for(int k=0;k<n;k++){
            h1=0;v1=0;
            for(int i=0;i<n;i++){
                for(int j=i+1,l=k;j<n;j++){
                    if(mat.get(k).get(i)==mat.get(k).get(j))h1++;
                    if(mat.get(i).get(k)==mat.get(j).get(k))v1++;
                }

            }
            if(h1>0)h++;
            if(v1>0)v++;
        }

        System.out.println(sum+" "+h+" "+v);
    }

    public static void main(String[] args) {
        int test=sr.nextInt();
        System.out.println();
        int i=0;
        while(i<test){
            System.out.print("Case #"+(i+1)+": ");
            solve4();
            i++;
        }

    }
}



