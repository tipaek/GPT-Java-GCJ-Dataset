import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String args[])
    {
        String s = new String();
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        int kmn=0;
        for(kmn=1;kmn<=testcases;kmn++)
        {
            s=sc.next();

            char arr[] = s.toCharArray();
            int n = arr.length;
            int max=Integer.MIN_VALUE;
            int[] irr = new int[n];
            for(int j=0;j<n;j++)
            {
                irr[j] = Character.getNumericValue(arr[j]);
            }
            for(int gh=0;gh<n;gh++)
            {
                if(max<irr[gh])
                {
                    max=irr[gh];
                }
            }
            char[] res = new char[(max*n)+n*n+max*max+2];
            int ll=0;
            for(int j=0;j<irr[0];j++)
            {
                res[ll]='(';
                ll++;
            }
            res[ll]=arr[0];
            ll++;
            for(int i=1;i<n;i++)
            {
                int diff = (irr[i-1]-irr[i]);
                if(diff==0)
                {
                    res[ll]=arr[i];
                    ll++;
                }
                else if(diff>0)
                {
                    for(int j=0;j<diff;j++)
                    {
                        res[ll]=')';
                        ll++;
                    }
                    res[ll]=arr[i];
                    ll++;
                }  
                else
                {
                    for(int j=0;j<(-1*diff);j++)
                    {
                        res[ll]='(';
                        ll++;
                    }
                    res[ll]=arr[i];
                    ll++;
                }
            }
            for(int j=0;j<irr[n-1];j++)
            {
               
                res[ll]=')';
                ll++;
            }
             
            
            int i=0;
            System.out.print("Case #"+kmn+": ");
            while(res[i]!='\0')
            {
                System.out.print(res[i]);
                i++;
            }
            System.out.println();
           
        }

    }

}