import java.util.*;
 class Solution{
    public static void main(String arg[])
    {
        Scanner ob=new Scanner(System.in);
        int t=ob.nextInt();
        int k=0;
        while(t-->0)
        {
            k++;
            int n=ob.nextInt();
            int ar[][]=new int[n][n];
            int sum=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    ar[i][j]=ob.nextInt();
                    if(i==j)
                    {
                        sum+=ar[i][j];
                    }
                }
            }
            int r=0,c=0;
            for(int i=0;i<n;i++)
            {
                boolean ch=false;
                boolean visit[]=new boolean[n];
                Arrays.fill(visit,false);
                for(int j=0;j<n;j++)
                {
                    int x=ar[i][j];
                    if(visit[x-1])
                    {
                        ch=true;break;
                    }
                    visit[x-1]=true;
                }
                if(ch)  r++;
            }
               for(int i=0;i<n;i++)
            {
                boolean visit[]=new boolean[n];
                Arrays.fill(visit,false);
                boolean ch=false;
                for(int j=0;j<n;j++)
                {
                    int x=ar[j][i];
                    if(visit[x-1])
                    {
                        ch=true;break;
                    }
                    visit[x-1]=true;
                }
                if(ch)  c++;
            }
            
            
          System.out.println("Case #"+k+": "+sum+" "+r+" "+c);  
            
            
            
            
            
            
        }
    }
}