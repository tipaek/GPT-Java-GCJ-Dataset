//package com.company;

import java.util.*;

public class Solution {
    static class pair {
        int a;
        int b;
        int index;

        pair(int a, int b,int i) {
            this.a = a;
            this.b = b;
            this.index=i;
        }


    }
    static class pairComp implements Comparator<pair> {
        public int compare(pair chair1, pair chair2) {
            return chair1.a - chair2.a;
        }

    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int k=0;k<t;k++) {
            int n = s.nextInt();
            ArrayList<pair>list=new ArrayList<>();
             for(int i=0;i<n;i++){
               int a=s.nextInt();
               int b=s.nextInt();
               pair p=new pair(a,b,i);
               list.add(p);
            }
             Collections.sort(list,new pairComp());
            /*for(int i=0;i<n;i++){
                System.out.print(list.get(i).a+" "+list.get(i).b);
                System.out.println();
            }  */
            ArrayList<pair>list2=new ArrayList<>();
            String res="";
            int c=0;
            int j=0;
            int flag=0;
            for(pair q:list){
                int a=q.a;
                int b=q.b;

                if(c<=a){
                    c=b;
                    pair p=new pair(q.index,-1,0);
                    list2.add(p);
                   // map3.put(a,"C");
                }
                else if(j<=a){
                    j=b;
                    pair p=new pair(q.index,-2,0);
                    list2.add(p);
                  //  res +="J";
                  //  map3.put(a,"J");
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

                Collections.sort(list2,new pairComp());
                for(int i=0;i<list2.size();i++){
                    if(list2.get(i).b==-1){
                        res +="C";
                    }
                    else{
                        res +="J";
                    }
                }
                System.out.println("Case #"+(k+1)+": "+res);
            }


        }
    }
}
