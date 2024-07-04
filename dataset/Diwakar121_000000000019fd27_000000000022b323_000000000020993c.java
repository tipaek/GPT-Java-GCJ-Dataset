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
            int reqxor=computeXOR(n);
            int row=0,col=0;
            int trace=0;
            for(int i=0; i<n ; i++)
            {int xor=0;
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=obj.nextInt();
                    xor=xor ^ arr[i][j];
                    if(i==j)
                    {trace+=arr[i][j];}
                }
                
                if(reqxor!=xor)
                {row++;}
                
            }
            
            
            for(int i=0; i<n ; i++)
            {int xor=0;
                for(int j=0;j<n;j++)
                {
                    
                    xor=xor ^ arr[j][i];
                   
                }
                
                if(reqxor!=xor)
                {col++;}
                
            }
            System.out.println("Case #"+(z+1)+": "+ trace+" "+ row+" "+col);
            
            
            
            z++;
        }
        
    }
    public  static int computeXOR(int n) 
    { 
       
        if (n % 4 == 0) 
            return n; 
       
        
        if (n % 4 == 1) 
            return 1; 
       
        
        if (n % 4 == 2) 
            return n + 1; 
       
       
        return 0; 
    } 
}