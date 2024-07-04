import java.io.*;
import java.util.*;
class matrix
{
    public static void main(String args[])throws Exception
    {
        DataInputStream in = new DataInputStream(System.in);
        int test = Integer.parseInt(in.readLine());
        for(int ti=1;ti<=test;ti++)
        {
            int n = Integer.parseInt(in.readLine());
            int A[][] = new int[n][n];
            for(int i=0;i<n;i++)
            {
                String line = in.readLine();
                String strs[] = line.trim().split("\\s+");
                for(int j=0;j<n;j++)
                 A[i][j] = Integer.parseInt(strs[j]);
            }
            //ArrayList<Integer> al = new ArrayList<Integer>();
            int cr=0; int rr=0;
            for(int i=0;i<n;i++)
            {
                ArrayList<Integer> al = new ArrayList<Integer>();
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
            for(int i=0;i<n;i++)
            {
                ArrayList<Integer> al = new ArrayList<Integer>();
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
             sum+=A[i][i];
             
            System.out.println("Case #"+ti+": "+sum+" "+cr+" "+rr);
        }
    }
}