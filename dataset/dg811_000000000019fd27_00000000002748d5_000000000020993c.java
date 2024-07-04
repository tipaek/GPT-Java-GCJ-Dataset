
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

    int t,n,sum,r,c,rmax,cmax;
    Scanner sc=new Scanner(System.in);
    t=sc.nextInt();
    for(int z=0;z<t;z++)
    {
        n=sc.nextInt();
        sum=0;
        r=0;
        c=0;
        rmax=0;
        cmax=0;
        int[][] arr=new int[n][n];
        Map<Integer,Integer> m=new HashMap<Integer,Integer>();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
                if(m.containsKey(arr[i][j]) && r==0)
                {
                    r=1;
                    rmax++;
                }
                
                else if(!m.containsKey(arr[i][j]))
                {
                    m.put(arr[i][j],1);
                }
            }
            m.clear();
            r=0;
        }
        
        for(int j=0;j<n;j++)
        {
            for(int i=0;i<n;i++)
            {
                
                if(m.containsKey(arr[i][j]) && c==0)
                {
                    c=1;
                    cmax++;
                }
                else if(!m.containsKey(arr[i][j]))
                {
                    m.put(arr[i][j],1);
                }
                
            }
            m.clear();
            c=0;
        }
        
        
        for(int i=0;i<n;i++)
        sum+=arr[i][i];
        
        System.out.println(sum+" "+rmax+" "+cmax);
    
    }
}
}