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
int ar[][]=new int[n][n];
int sum=0;
int r=0;
int c=0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ar[j][k] = s.nextInt();
                    if (k == j)
                        sum = sum + ar[j][k];

                }

            }
            for(int j=0;j<n;j++){
                int ar2[]=new int[100];
                for(int k=0;k<n;k++){
                    if(ar2[ar[j][k]]!=1)
                        ar2[ar[j][k]]=1;
                    else
                    {
                        ++r;
                        break;
                    }

                }
            }
            for(int j=0;j<n;j++){
                int ar2[]=new int[100];
                for(int k=0;k<n;k++){
                    if(ar2[ar[k][j]]!=1)
                        ar2[ar[k][j]]=1;
                    else
                    {
                        ++c;
                        break;
                    }

                }
            }

            System.out.println("Case #" + i + ": " +sum+" "+r+" "+c);


        }
            }
    }






               


