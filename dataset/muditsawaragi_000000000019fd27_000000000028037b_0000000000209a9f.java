import java.io.*;
import java .util.*;
public class Solution {
    int t;
    String s;
    void input()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());

        for(int c=1;c<=t;c++ )
        {
            s=br.readLine();
            display(c);
        }

    }
    void display(int c)
    {
       int len =s.length();
       int ct=0;
       String sa="";

       for(int i=0;i<len;i++)
       {

           int k=(int)(s.charAt(i)-'0');
           if(ct<k) {
               while (ct < k) {
                   sa = sa + "(";

                   ct++;
               }
               sa = sa + s.charAt(i);
           }
           else if(ct==k)
               sa = sa + s.charAt(i);
           else
           {

               while(ct > k)
               {
                   sa = sa +")";

                   ct--;
               }
               sa = sa + s.charAt(i);
           }

       }
       while(ct>0)
       {
           sa=sa+")";
           ct--;
       }
        System.out.println("Case #"+c+": "+sa);
    }
    public static void main(String args[])throws IOException
    {
        Solution ob =new Solution();
        ob.input();

    }
}
