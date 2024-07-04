import java.util.*;
public class Solution {
    public String brackets(int a)
    {
        String b=Integer.toString(a);
        for(int i=0;i<a;i++)
        {
            b="("+b+")";
        }
        return b;
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int i=1;i<=test;i++)
        {
            String x=sc.next();
            StringBuffer sb=new StringBuffer();
            if(x.charAt(0)=='0')
                sb.append("0");
            else
            {
                sb.append(s.brackets(Integer.parseInt(String.valueOf(x.charAt(0)))));
            }
            for(int j=1;j<x.length();j++)
            {
                 int p=Integer.parseInt(String.valueOf(x.charAt(j-1)));
                 int q=Integer.parseInt(String.valueOf(x.charAt(j)));
                 if(q>p)
                     sb.append(s.brackets(q));
                 else if(p>=q && q==0)
                     sb.append("0");
                 else if(p>=q && q!=0)
                 {
                     int l=sb.length()-q;
                     String z=Integer.toString(q);
                     sb.insert(l, z);
                 }
                 
                 
            }
            System.out.println("Case #"+i+""+": "+sb);
            
        }
    }
    
}
