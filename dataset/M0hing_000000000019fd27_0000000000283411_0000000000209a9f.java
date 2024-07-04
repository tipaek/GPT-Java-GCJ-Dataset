package com.tgt.igniteplus;

import java.lang.reflect.Array;
import java.util.Scanner;
class sol2 {
    public static void main(String[] args) {
        int t,test=0;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        while (test++ <t) {
            String s;
            int len=0;
            s=in.next();
            char[]c=s.toCharArray();
           // System.out.println(c.length);

            char[]resStr=new char[1000];
            for (int i = 0; i <c.length ; i++) {
                for (int j = 0; j <c[i]-'0' ; j++) {
                    resStr[len++]='(';
                }

                resStr[len++]=c[i];

                for (int j = 0; j <c[i]-'0' ; j++) {
                    resStr[len++]=')';
                }

            }
           // System.out.println(resStr);
            //deleting
            for (int i = 0; i < len; i++) {
                if (resStr[i]==')' && resStr[i+1]=='('){

                    int x=i;
                    i++;
                    while (resStr[x]==')' && resStr[i]=='(') {resStr[x--]='.';resStr[i++]='.';}
                }

                   // System.out.println(resStr);
            }
            for (int i = 0; i <len ; i++) {
                if (resStr[i]!='.')
                    System.out.print(resStr[i]);
            }

        }
    }
}