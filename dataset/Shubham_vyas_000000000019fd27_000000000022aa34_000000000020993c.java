import java.util.*;
import java.lang.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int m=1;
        int t=sc.nextInt();
        while(t!=0)
        {
            
            int n=sc.nextInt();
            int[][] mat=new int[n][n];
            
            HashMap<Integer,Integer> rmap=new HashMap<>(); 
            HashMap<Integer,Integer> cmap=new HashMap<>();
            
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                 mat[i][j]=sc.nextInt();    
            }
            
            int trace=0,rcnt=0,ccnt=0,ronetime=0,conetime=0;
            
            for(int i=0;i<n;i++)
            {
                trace+=mat[i][i];
                ronetime=0;
                conetime=0;
                
                for(int j=0;j<n;j++)
                 {
                     int num=mat[j][i];
                     
                     if(rmap.get(num)==null)
                        rmap.put(num,1);
                     else if(ronetime==0 && rmap.get(num)!=null)
                     {
                         ronetime=-1;
                         ccnt++;
                     }
                       
                       num=mat[i][j];
                     if(cmap.get(num)==null)
                        cmap.put(num,1);
                     else if(conetime==0 && cmap.get(num)!=null)
                     {
                         conetime=-1;
                         rcnt++;
                     }
                       
                     
                 }    
                 rmap.clear();
                 cmap.clear();
            }
            
            System.out.println("Case #"+m+": "+trace+" "+rcnt+" "+ccnt);
            t--;
            m++;
        }
    }
}