import java.util.*;
class Solution
{
public static void main(String[]args)
{
    Scanner in = new Scanner(System.in);
    int t= in.nextInt();
    String h = in.nextLine();
    int k=1;
    while(t-->0)
    {
        String s = in.nextLine();
        int l = s.length();
        int f = s.indexOf('1');
        
        if(f==-1)
        {System.out.println("Case #"+k+": "+s);
        k++;
        continue;}
        
        String s1="";
        
        if(s.equals("1"))
        {
        System.out.println("Case #"+k+": (1)");
        k++;
        continue;}
        
        
        for(int i=0;i<l;i++)
        {
            char ch = s.charAt(i);
            if(ch=='1' && i!=0 && i!=l-1)
            {
                if(s.charAt(i-1)=='0')
                s1 = s1+"(1";
                else
                s1 = s1+"1";
                if(s.charAt(i+1)=='0')
                s1 = s1+")";
                
            }
            if(ch=='0')
            s1 = s1+"0";
            
            if(ch=='1' && i==0)
            {
                if(s.charAt(i+1)=='0')
                s1="(1)";
                else
                s1="(1";
            }
            
            
            if(ch=='1' && i==l-1)
            {
                if(s.charAt(i-1)=='0')
                s1 = s1+"(1)";
                else
                s1 = s1 + "1)";
            }
        
           
        }
        
        System.out.println("Case #"+k+": "+s1);
        k++;
    }
    
}
}