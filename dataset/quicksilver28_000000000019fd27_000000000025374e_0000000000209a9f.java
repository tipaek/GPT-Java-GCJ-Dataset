package com.pluralsight.loops;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int t, x;
        String str;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        sc.nextLine();
        x = t;
        while(t!=0) {
            str = sc.nextLine();
            t--;
            System.out.println("Case #"+ (x-t) +": "+ nestingDepth(str).toString()); //nestingDepth(str));
        }
    }

    static StringBuilder nestingDepth(String s) {
        int i, d, p = 0, j;
        char[]  sr = new char[s.length()];
        StringBuilder nest = new StringBuilder(s.length());
        for(j=0;j<s.length();j++)
            sr[j]=s.charAt(j);
        for(j=0;j<s.length();)
        {
            d = sr[j]-48;
            for(i = 0; i < d - p; i++) {
                nest.append('(');
                p++;
            }
            while(d==p) {
                nest.append(sr[j]-48);
                j++;
                if(j==s.length())
                    break;
                d = sr[j]-48;
            }
            if(j==s.length())
                break;
            while (j!=0 && d<sr[j-1]-48)
            {
                nest.append(')');
                d++;
                p--;
            }
        }
        while (p != 0) {
            nest.append(')');
            p--;
        }
        return nest;
    }
}

