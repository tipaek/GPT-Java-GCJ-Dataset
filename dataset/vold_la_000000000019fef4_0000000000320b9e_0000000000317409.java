import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Solution
{ 
    public static void main(String args[])
    {
      Scanner in =new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t=in.nextInt();
      for (int c_num = 1; c_num <= t; c_num ++){
        int x=in.nextInt();
        int y=in.nextInt();
        String m=in.next();
        int len = m.length();
        //int min = 99999999;
        int ch=1,val=0;
        int flag=0;
          for(int i=0;i<len;i++){
           ch = Math.abs(x)+Math.abs(y)-i;
            if(ch<= 0)
            {val=i+1;
                flag=1;
            break;}
           
              if(m.charAt(i)=='N')
                 y++;
            else if(m.charAt(i)=='S')
                 y--;
            else if(m.charAt(i)=='E')
                 x++;
            else x--;
          
            ch = Math.abs(x)+Math.abs(y)-i-1;
            if(ch<= 0)
            {val=i+1;
                flag= 1;
            break;}
        
        }
        if(flag==0)
        System.out.println("IMPOSSIBLE");
        else
        System.out.println("Case #"+c_num+": "+val);
          
        }
    }}
