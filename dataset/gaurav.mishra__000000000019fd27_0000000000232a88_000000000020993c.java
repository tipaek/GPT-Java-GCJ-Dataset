import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
class gaurav
{
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int T=ob.nextInt();
        for(int t=0; t<T; t++)
        {
            int n=ob.nextInt();
            int[] [] arr=new int[n][n];
            Map<Integer,HashSet<Integer>> map=new Map<Integer,HashSet<Integer>>();
            for(int i=0;i<n;i++)
            {   HashSet<Integer> m=new HashSet<Integer>();
                for(int j=0; j<n;j++)
                {   arr[i][j]=ob.nextInt() ;
                  m.add(arr[i][j]);
                }
                map.put(i,m);
            }
            Map<Integer,HashSet<Integer>> ma=new Map<Integer,HashSet<Integer>>();
            for(int i=0;i<n;i++)
            {   HashSet<Integer> m=new HashSet<Integer>();
                for(int j=0; j<n;j++)
                { 
                  m.add(arr[j][i]);
                }
                ma.put(i,m);
            }
            int r=0;
            for(int i=0; i<n;i++)
            {
              int size=map.get(i).size();
              if(size<n)
              {r++;}
            }
            int c=0;
            for(int i=0; i<n;i++)
            {
              int size=ma.get(i).size();
              if(size<n)
              {c++;}
            }
            int sum=0;
            for(int i=0; i<n; i++)
            {
               sum=sum+arr[i][i];
            }
            
            System.out.println("Case #"+t+": " + sum + " " +r+ " "+c);
            
        }
    }
}