import java.util.*;

public class Solution {
    public String insBra(String s)
    {   String add="";
        for(int i=0 ; i<s.length()-1 ; i++)
        {
            if(s.charAt(i)==',')
            {
                int d=s.charAt(i+1)-s.charAt(i-1);
                if(d>0)
                {
                for(int j=0 ; j<d ; j++)
                {
                    add+="(";
                }
                s=s.replaceFirst(",",add);
                }
                else if(d<0)
                {   d=Math.abs(d);
                   for(int j=0 ; j<d ; j++)
                {
                    add+=")";
                }
                s=s.replaceFirst(",",add); 
                }
                add="";
            }
        }
        return s;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int b=0;
        while(b!=n)
        {   Solution obj=new Solution();
            String s=in.next();
            s="0"+s+"0";
            String s1="";
            for(int i=0 ; i<s.length()-1 ; i++)
            {
                if(s.charAt(i)!=s.charAt(i+1))
                {
                s1+=s.charAt(i)+",";
                }
                else
                s1+=s.charAt(i);
            }
            s1+=s.charAt(s.length()-1);
            s1=obj.insBra(s1);
            s1=s1.substring(1,s1.length()-1);
            System.out.println("Case #"+(++b)+": "+s1);
        }
    }
}