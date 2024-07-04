import java.util.Scanner;
public class Solution 
{     
    public static void main(String[] args) 
    {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       for(int i=0;i<t;i++)
       {
           String s = sc.next();
           int d = 0;
           StringBuilder sb = new StringBuilder("");
           for(int j=0;j<s.length();j++)
           {
               int nd = Integer. parseInt(String. valueOf(s.charAt(j)));
               while(nd>d)
               {
                   d++;
                   sb.append('(');
               }
               while(nd<d)
               {
                   d--;
                   sb.append(')');
               }
               sb.append(s.charAt(j));
           }
           while(d>0)
           {
               d--;
               sb.append(')');
           }
           System.out.println("Case #"+(i+1)+": "+sb.toString());
       }
    }
}