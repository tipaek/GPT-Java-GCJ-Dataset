import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        int t = obj.nextInt();
        int z=0;
        while(z<t)
        {
            
            int n = obj.nextInt();
            int [][]arr = new int[n][n];
            int br[] = new int[n+1];
            int row=0,col=0;
            int trace=0;
            for(int i=0; i<n ; i++)
            {int val=0;
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=obj.nextInt();
                    if(br[arr[i][j]]==0)
                    {
                        br[arr[i][j]]=1;
                        val++;
                    }
                    if(i==j)
                    {trace+=arr[i][j];}
                }
                
                if(val!=n)
                {row++;}
                for(int j=0;j<n+1;j++)
                {
                    br[j]=0;
                }
            }
            
            for(int i=0; i<n ; i++)
            {int val=0;
                for(int j=0;j<n;j++)
                {
                    
                    if(br[arr[j][i]]==0)
                    {
                        br[arr[j][i]]=1;
                        val++;
                    }
                   
                }
                
                if(val!=n)
                {col++;}
                for(int j=0;j<n+1;j++)
                {
                    br[j]=0;
                }
            }
            System.out.println("Case #"+(z+1)+": "+ trace+" "+ row+" "+col);
            
            
            
            z++;
        }
        
    }
    
}