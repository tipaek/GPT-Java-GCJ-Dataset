import java.util.*;
import java.io.*;
public class main
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int p=1;
        while(p<=n)
        {
            int m=scan.nextInt();
            int k=0,r=0,c=0,flag=0;
            HashSet<Integer> s=new HashSet<Integer>();
            int arr[][]=new int[m][m];
            for(int i=0;i<m;i++)
            {
                flag=0;
                for(int j=0;j<m;j++)
                {
                    arr[i][j]=scan.nextInt();
                    if(s.contains(arr[i][j])&&flag==0)
                    {
                        r++;
                        flag=1;
                    }
                    else
                    {
                        s.add(arr[i][j]);
                    }
                    if(i==j)
                    k+=arr[i][j];
                    
                }
                s.clear();
            }
            for(int i=0;i<m;i++)
            {
                flag=0;
                for(int j=0;j<m;j++)
                {
                    if(s.contains(arr[j][i])&&flag==0)
                    {
                        c++;
                        flag=1;
                        break;
                    }
                    else
                    {
                        s.add(arr[j][i]);
                    }
                    
                }
                s.clear();
            }
            System.out.println("Case #"+p+": "+k+" "+r+" "+c);
            p++;
        }
    }
}