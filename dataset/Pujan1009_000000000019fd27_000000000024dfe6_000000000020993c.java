package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.StringTokenizer;


public class Solution
{
    public static void main(String[] stp) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t=Integer.parseInt(st.nextToken()),i,j;
        int ncase=1;
        while(t-- > 0)
        {
           int n;
            
           n=scan.nextInt();
         //  int i,j;
           Integer a[][] = new Integer[n][n];
           for(i=0;i<n;i++)
           {
               for(j=0;j<n;j++)
               {
                   a[i][j]=scan.nextInt();
               }
           }
            long sum=0,row=0,col=0;
            for(i=0;i<n;i++)
            {
                
                TreeSet<Integer> ts1=new TreeSet<>();
                TreeSet<Integer> ts2=new TreeSet<>();
                sum+=a[i][i];
                for(j=0;j<n;j++)
                {
                    ts1.add(a[i][j]);
                    ts2.add(a[j][i]);
                }
                if(ts1.size()!=n) row++;
                if(ts2.size()!=n) col++;
            }
            pw.println("Case #"+ncase+": "+sum+" "+row+" "+col);
            ncase++;
        }
        pw.flush();
    }
}