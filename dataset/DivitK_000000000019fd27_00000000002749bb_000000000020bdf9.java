import java.util.Scanner;
import java.io.*;

public class Solution
{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        int n;
        n=in.nextInt();
        for(int i=0;i<n;i++)
        {
            String str="";
            int t=in.nextInt();
            int [][]arr=new int[t+1][2];
            for(int itr=0;itr<t;itr++)
            {
                arr[itr][0]=in.nextInt();
                arr[itr][1]=in.nextInt();
            }
            int num=t;
            int d=0;
            //Initialisation
            str="C";
            for(int k=1;k<t;k++)
            {
                
            if((arr[k][0]>=arr[k-1][0])&&(arr[k][0]<=arr[k-1][1]))
            {
                str=str+'J';
                d++;
                
            }
            else
            str=str+'C';
                
            
            }
            if(d==2)
            {
                System.out.println("IMPOSSIBLE");
            }
            else
            System.out.println(str);
        }
    }}