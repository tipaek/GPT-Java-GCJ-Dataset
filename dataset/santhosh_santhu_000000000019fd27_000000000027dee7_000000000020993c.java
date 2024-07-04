/*import java.util.*;
class  Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int[][] res=new int[t][t];
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt(); 
            int[][] arr=new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                arr[j][k]=sc.nextInt();
            }
            int trace=0,flag,count=0,flag2,count2=0;
            for(int j=0;j<n;j++)
            {
                flag=0;
                flag2=0;
                for(int k=0;k<n;k++)
                {
                    if(k==j)
                    trace+=arr[j][k];
                    if(flag!=1){
                    for(int l=k+1;l<n;l++)
                    if(arr[j][k]==arr[j][l])
                    {
                        flag=1;
                        count++;
                        break;
                    }}}
                     for(int k=0;k<n;k++)
                {
                    if(flag2!=1){
                    for(int l=k+1;l<n;l++)
                    if(arr[k][j]==arr[l][j])
                    {
                        flag2=1;
                        count2++;
                        break;}
                    }
                }
            }
            res[i][0]=trace;
            res[i][1]=count;
            res[i][2]=count2;
        }
        for(int i=0;i<t;i++)
        {
            System.out.print("Case #"+(i+1)+":");
            for(int j=0;j<t;j++)
        System.out.print(" "+res[i][j]);
        System.out.println();
        }
    }
}*/
import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int test=sc.nextInt();
        for(int i=1;i<=test;i++)
        {

            int size=sc.nextInt();
            int mat[][]=new int[size][size];

            for(int z=0;z<size;z++)
            {
                for(int j=0;j<size;j++)
                {
                    mat[z][j]=sc.nextInt();
                }
            }
            int k=trace(mat,size);

            int r=row_duplicate(mat,size);

            int c=col_duplicate(mat,size);

            System.out.println("Case #" +z+ ":"+" " +k+ " " +r+ " " +c); //Case #1: 4 0 0


        }
    }

    public static int trace(int arr[][],int size)
    {
        int sum=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(i==j)
                    sum=sum+arr[i][j];
            }
        }
        return sum;
    }
    public static int row_duplicate(int arr[][],int size)
    {
        Hashtable<Integer,Integer> h=new Hashtable<>();
        int count=0;
        for(int i=0;i<size;i++)
        {
            int row[]=arr[i];
            for(int j=0;j<row.length;j++)
            {
                if(h.containsKey(row[j]))
                {
                    count++;
                    break;
                }
                else
                {
                    h.put(row[j],1);
                }
            }
            h.clear();
        }
        return count;
    }

    public static int col_duplicate(int arr[][],int size)
    {
        Hashtable<Integer,Integer> h=new Hashtable<>();
        int count=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                int ele=arr[j][i];
                if(h.containsKey(ele))
                {
                    count++;
                    break;
                }
                else
                {
                    h.put(ele,1);
                }
            }
            h.clear();
        }
        return count;

    }
}