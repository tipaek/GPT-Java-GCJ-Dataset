import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
class A{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int cases=(Integer.parseInt(sc.nextLine()));
        int trace=0;
        for(int k=0;k<cases;k++)
        {
            int n=Integer.parseInt(sc.nextLine());
            int a[][]=new int[n][n];
            int row=0,col=0,flag=0;
            for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
            {a[i][j]=sc.nextInt();}sc.nextLine();}
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(a[i][j]==a[i][j+1])
                    {r++;flag=1;}
                    else if(a[i][j]==a[i+1][j])
                    {c++;flag=1;}
                    else
                    flag=0;
                    if(i==j)
                    trace+=a[i][j];
                }
            }
            System.out.print("Case #"+k+": "+trace+" "+r+" "+c);
            System.out.println();
        }
    }
}