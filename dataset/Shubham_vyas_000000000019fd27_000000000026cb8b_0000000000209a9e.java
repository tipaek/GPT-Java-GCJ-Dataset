import java.util.*;
import java.lang.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int B=sc.nextInt();
        while(t!=0)
        {
            StringBuilder br=new StringBuilder();
            
            for(int i=1;i<=10;i++)
            {
              System.out.println(i);
            
              String a=sc.next();
               
               br.append(a);  
            
            }
            
            System.out.println(br);
            
            String verdict=sc.next();
            
            if(verdict.equals("N"))
              break;
              
            t--;
        }
    }
}