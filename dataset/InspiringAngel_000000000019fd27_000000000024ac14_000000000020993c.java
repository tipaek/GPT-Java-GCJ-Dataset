import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.*;
public class Solution
{
    public static int[] trace(int arr[][],int size)
    {
        int sum=0,row=0,column=0;
        int a[]=new int[3];
        Set<Integer> h=new HashSet<Integer>();
        Set<Integer> k=new HashSet<Integer>();
        for(int i=0;i<size;i++)
        {
            int flag=0,temp=0;
            for(int j=0;j<size;j++)
            {
                if(i==j)
                sum+=arr[i][j];
    
                if(h.add(arr[i][j])==false)
                {
                  flag++; 
                }   
                if(k.add(arr[j][i])==false)
                {
                  temp++;
                }
            }
            if(flag>0)
            {
                column++;
                  
            }
            if(temp>0)
            {
                row++;
                 
            }
            h.clear();
            k.clear();
        }
        a[0]=sum;
        a[1]=column;
        a[2]=row;
        return a;
    }
    public static void main(String args[])
    {
        int ts=0,size=0;
        Scanner s=new Scanner(System.in);
        if(s.hasNext()){
        ts=s.nextInt();}
        for(int i=1;i<=ts;i++)
        {
            size=s.nextInt();
            int arr[][]=new int[size+1][size+1];
            for(int k=0;k<size;k++)
            {
                for(int j=0;j<size;j++)
                {if(s.hasNext())
                    {arr[k][j]=s.nextInt();}
                }
            }
            int a[]=trace(arr,size);
            System.out.println("Case #"+i+": "+a[0]+" "+a[1]+" "+a[2]);
        }
    }
}