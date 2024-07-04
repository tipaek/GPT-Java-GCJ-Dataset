import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int ti=1;ti<=test;ti++)
        {
            int n = sc.nextInt();
            int A[][] = new int[n][n];
            for(int i=0;i<n;i++)
            {
               for(int j=0;j<n;j++)
                A[i][j] = sc.nextInt();
            }
            ArrayList<Integer> al = new ArrayList<Integer>();
            int cr=0; int rr=0;
            for(int i=0;i<n;i++)
            {
                //ArrayList al = new ArrayList();
                al.clear();
                for(int j=0;j<n;j++)
                {
                    if(al.contains(A[i][j])){
                        cr++;
                        break;
                    }
                    else
                     al.add(A[i][j]);
                }
            }
            al.clear();
            for(int i=0;i<n;i++)
            {
                //ArrayList al = new ArrayList();
                al.clear();
                for(int j=0;j<n;j++)
                {
                    if(al.contains(A[j][i])){
                        rr++;
                        break;
                    }
                    else
                     al.add(A[j][i]);
                }
            }
            int sum=0;
            for(int i=0;i<n;i++)
             sum=sum+A[i][i];
            al.clear();
            System.out.println("Case #"+ti+": "+sum+" "+cr+" "+rr);
        }
        sc.close();
    }
}