//package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int k=0;k<t;k++){
           int n=s.nextInt();
            Map<Integer,Integer> map1=new LinkedHashMap<>();
            for(int i=0;i<n;i++){
                int a=s.nextInt();
                int b=s.nextInt();
                map1.put(a,b);
            }
            Map<Integer,Integer> map=new TreeMap<>();
            for(Map.Entry<Integer,Integer> hm: map1.entrySet()) {
                   map.put(hm.getKey(),hm.getValue());
            }

            int c=0;
            int j=0;
            String res="";
            int flag=0;
            Map<Integer,String> map3=new LinkedHashMap<>();
            for(Map.Entry<Integer,Integer> hm: map.entrySet()){
                int a=hm.getKey();
                int b=hm.getValue();

                if(c<=a){
                    c=b;
                   // res +="C";
                    map3.put(a,"C");
                }
                else if(j<=a){
                    j=b;
                    map3.put(a,"J");
                }
                else{
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                System.out.println("Case #"+(k+1)+": "+"IMPOSSIBLE");
            }
            else{
                for(Map.Entry<Integer,Integer> hm: map1.entrySet()){
                     int a=hm.getKey();
                     res +=map3.get(a);
                }
              //  System.out.println(map3);
                System.out.println("Case #"+(k+1)+": "+res);
            }

        }
    }
}
