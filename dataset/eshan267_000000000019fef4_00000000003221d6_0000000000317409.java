import java.util.*;
class Solution
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb =new StringBuilder("");
        for(int i=0;i<t;i++)
        {
            int x = sc.nextInt();
            int y =sc.nextInt();
            String p = sc.next();
            int m = x;
            int w=0;
        for(int j=0;(j<m && j<p.length());j++)
        {
          if(p.charAt(j)=='N')
          y++;
          else 
          y-- ;
        }
        int ans =0;
        if(y==0){
            w=1;
        ans = m ;
        }
        else
        {
            int ti =0;
           for(int j=m ; j<p.length();j++)
           {
               ti++ ;
              if(p.charAt(j)=='N')
               y++;
               else 
               y-- ;
               
               if(ti>=Math.abs(y))
               {
                   w=1;
                   ans = m + ti ;
                   break ;
               }
           }
           
           
        }
            
            if(w==0)
            sb.append("Case #"+(i+1)+": IMPOSSIBLE\n");
            else
            sb.append("Case #"+(i+1)+": "+ans+"\n");
        }
         sb.setLength(sb.length()-1);
	        System.out.print(sb);
    }
}