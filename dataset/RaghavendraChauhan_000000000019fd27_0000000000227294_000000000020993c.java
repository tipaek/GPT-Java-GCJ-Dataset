import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        int p=t;
        int a[][]=new int[t][3];
        while(p-->0)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            arr[i][j]=sc.nextInt();
            
            int tr=0;
            for(int i=0;i<n;i++)
            tr=tr+arr[i][i];
            int r=0;int c=0;
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> hr=new HashSet<>();
                HashSet<Integer> hc=new HashSet<>();
            for(int j=0;j<n;j++)
            {if(hr.contains(arr[i][j]))
            {r++;break;}
            else
            hr.add(arr[i][j]);}
            for(int j=0;j<n;j++){
            if(hc.contains(arr[j][i]))
            {c++;break;}
            else
            hc.add(arr[j][i]);
            }
            a[t-p-1][0]=tr;a[t-p-1][1]=r;a[t-p-1][2]=c;
        }
        
        
    }
    for(int i=1;i<=t;i++)
        System.out.println("Case #"+i+": "+a[i-1][0]+" "+a[i-1][1]+" "+a[i-1][2]);
}}