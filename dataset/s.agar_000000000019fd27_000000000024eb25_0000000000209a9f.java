import java.io.*;
import java.util.*;
class Solution
{
public static void main(String args[]) throws Exception
{
    try{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int T = Integer.parseInt(br.readLine());
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        int z =0;
        while(T-- != 0)
        {   
            z++;
            //int N = Integer.parseInt(br.readLine());
            String str = scan.next();
            int len = str.length();
            char ch[] = str.toCharArray();
            String ans = "";
               int p = Character.getNumericValue(ch[0]);
               String open = opening(p);
               ans = open.concat(ans);
               ans = ans+(ch[0]);
            for(int i=1; i<len; i++)
            {  
               int x = Character.getNumericValue(ch[i-1]);
               int y = Character.getNumericValue(ch[i]);
               if(x>y)
               {
                   String close = closing(x-y);
                   ans = ans.concat(close);
                   ans = ans+(ch[i]);
               }
               else if(x<y)
               {
                  open = opening(y-x);
                  ans = ans+(open);
                  ans = ans+(ch[i]);
                  //i++;
               }
               else
               {
                   ans = ans+(ch[i]);
                  // i++;
               }
            }
            int u = Character.getNumericValue(ch[len-1]);
               String close = closing(u);
               ans = ans.concat(close);
               
               System.out.println("Case #"+z+": "+ ans);
            
    }
}    
    catch(Throwable e)
    {
        return;
    }
}

  static String opening(int ele)
  {
    String temp = "";
    for(int j=1; j<=ele; j++)
       {
        temp = temp+('('); 
        }
    return (temp);    
   }
   
   static String closing(int ele)
   {
    String temp = "";
    for(int j=1; j<=ele; j++)
       {
        temp = temp+(')'); 
        }
    return (temp);    
   }
}