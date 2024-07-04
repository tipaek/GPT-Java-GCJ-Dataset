import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n,i,j,ctr;
        String s,ans;
        sc.nextLine();
        for(int z = 1; z<=t;z++){
            s = sc.nextLine();
            ans="";
            ctr=0;
            // System.out.println(s);
            for(char ch : s.toCharArray()){
                n = ch-'0';
                if(ctr==n){
                    ans+=ch;
                } else if(ctr<n){
                    while(n>ctr){
                        ans+='(';
                        ctr++;
                    }
                    ans+=ch;
                } else{
                    while(n<ctr){
                        ans+=')';
                        ctr--;
                    }
                    ans+=ch;
                }
            }
            while(ctr>0){
                ans+=')';
                ctr--;
            }
            System.out.println("Case #"+z+": "+ans);
        }
    }
}
