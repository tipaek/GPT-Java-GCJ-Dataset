import java.util.Scanner;
import java.util.ArrayList;
public class Solution {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        ArrayList<Integer>ans=new ArrayList<>();
        int T=in.nextInt();
        for(int t=0;t<T;t++)
        {
            int n=in.nextInt();
            int trace=0;
            int[][] arr=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=in.nextInt();
                    if(i==j)
                        trace=trace+arr[i][j];
                }
            }
            int row=0,col=0;
            ArrayList<Integer>a=new ArrayList<>();
            for(int i=0;i<n;i++)    //rows
            {
                for(int j=0;j<n;j++)
                {
                    if(!a.contains(arr[i][j]))
                    {
                        a.add(arr[i][j]);
                    }
                }
                if(a.size()!=n)
                    row++;
                a.clear();
            }
            
            a.clear();
            for(int i=0;i<n;i++)    //columns
            {
                for(int j=0;j<n;j++)
                {
                    if(!a.contains(arr[j][i]))
                    {
                        a.add(arr[j][i]);
                    }
                }
                if(a.size()!=n)
                    col++;
                a.clear();
            }
            
            ans.add(trace);
            ans.add(row);
            ans.add(col);   
        }
        
        for(int t=0;t<T;t++)
        {
            System.out.println("Case #"+(t+1)+": "+ans.get(t*3)+" "+ans.get(t*3+1)+" "+ans.get(t*3+2));
        }
        
    }
    
}