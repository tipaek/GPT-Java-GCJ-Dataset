import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Arrays;

 class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {

           String a=s.next();
           int o=0;
           int c=0;
           int prev=0;
           String ans="";


            for (int j = 0; j < a.length(); j++) {
                int a1=Integer.parseInt(String.valueOf(a.charAt(j)));

                if(a1>prev){
                    for(int q=1;q<=a1-prev;q++){

                        ans=ans+"(";
                        o++;
                    }

                    ans=ans+a.charAt(j);
                    prev=a1;
                }
               else if(a1<=prev){
                    for(int q=1;q<=prev-a1;q++){
                        ans=ans+")";
                        --o;
                    }
                    ans=ans+a.charAt(j);
                    prev=a1;

                }

            }
            if(o>0)
                for(int q=1;q<=o;q++)
                ans=ans+")";
            System.out.println("Case #"+i+": "+ans);



            }
        }
    }






               


