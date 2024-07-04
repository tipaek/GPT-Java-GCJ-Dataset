import java.util.*;
class Solution{
    public static void main(String[] args)
    {
        Scanner sin= new Scanner(System.in);
        int t = sin.nextInt();
        int cnt = 1;
        
		//Do it here
		
		while(t-->0)
        {
            String s = sin.next();
            int point = 0;
            System.out.print("Case #"+cnt+": ");
            
			cnt=cnt+1;
			
            for(int i=0;i<s.length();i++)
            {
               int n = s.charAt(i)-48;
               
			   if(n==point)
            	   System.out.print(n);
               else if(n>point)
               {
            	   while(n>point)
            	   {
            		   System.out.print("(");
            		   point=point+1;
            	   }
            	   System.out.print(n);
               }
               else
               {
            	   while(n<point)
            	   {
            		   System.out.print(")");
            		   point=point-1;
            	   }
            	   System.out.print(n);
               }
            }
            while(point!=0)
            {
            	System.out.print(")");
            	point=point-1;;
            }
            System.out.println();
        }
    }
}