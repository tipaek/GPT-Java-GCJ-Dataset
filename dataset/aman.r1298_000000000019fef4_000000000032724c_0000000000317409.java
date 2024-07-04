import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) 
    {
        
        int t=0;
        
        Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        t=in.nextInt();
        
        StringBuilder build=new StringBuilder();
        
        for (int i = 1; i <=t ; i++) 
        {
            
            int a=in.nextInt();
            
            int b=in.nextInt();
            
            String str=in.next();
            
            int flag=0;
            
            for (int j = 0; j <str.length() ; j++) 
            {
            
                if(str.charAt(j)=='N')
                    b++;
            
            
                if(str.charAt(j)=='E')
                    a++;
            
            
                if(str.charAt(j)=='S')
                    b--;
            
            
                if(str.charAt(j)=='W')
                    a--;
            
            
                if(poss(a,b,j+1))
                {
                
                    flag=1;
                    int c=j+1;
                    build.append("Case #"+i+": "+c).append("\n");
                    break;
                
                    
                }
            }
            
            if (flag==0)
            {   
                
                
                
                build.append("Case #"+i+": IMPOSSIBLE").append("\n");
        
    
            }
        }
        
        System.out.println(build);
    
        
        
    }
    
    
    
    private static boolean poss(int x,int y,int z)
    {
    
        if(Math.abs(x)+Math.abs(y)>z)
            return false;
    
        return true;
    
        
    }
}