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
            int n=s.nextInt();

           int ar[]=new int[n];
            int ar2[]=new int[1441];





            for (int j = 0; j < n; j++) {

                ar[j]=s.nextInt();
                ar2[ar[j]]=s.nextInt();

        }
           int ar3[]= Arrays.copyOf(ar,n);
            Arrays.sort(ar);

            int a=0;
            int b=0;
            int c=0;
            int j1=0;
            int f=0;
            char ans[]=new char[1441];
            for(int j=0;j<n;j++){

                if(ar[j]>=a) {
                    ans[ar[j]] = 'C';
                    a=ar2[ar[j]];
                    

                }

                else if(ar[j]>=b) {
                       ans[ar[j]] = 'J';
                        b=ar2[ar[j]];
                  

                   }
                   else if((ar[j]<a)&&(ar[j]<b))
                   {
                       f=1;
                       break;
                   }
                }
            String ans2="";
            for(int j=0;j<n;j++)
                ans2=ans2+ans[ar3[j]];
            if(f!=1)
                System.out.println("Case #"+i+": "+ans2);
            else
                System.out.println("Case #"+i+": IMPOSSIBLE");



                }
            }
    }






               


