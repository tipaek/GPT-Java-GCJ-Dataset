import java.util.*;

class NestingDepth
{
    static String rem(String s)
    {
        char[] ch = s.toCharArray();
        
        for(int i=0;i<ch.length-1;i++)
        {
            if( ch[i]==')' && ch[i+1]=='(' )
            {
               ch[i] = '$';
               ch[i+1] = '$';
            }
        }
        
        String temp = "";
        
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i] != '$')
            {
                temp = temp + ch[i];
            }
        }
        
        return temp;
        
    }
    
    
    static void nesting(String s)
    {
        char[] ch = s.toCharArray();
        int[] a = new int[ch.length];
        
        for(int i=0;i<a.length;i++)
        {
            a[i] = Math.abs(48 - (int)(ch[i]));
        }
        
        String temp = "";
        
        
        for(int y=0;y<a.length;y++)
        {
            int val = a[y];
            
            for(int i=0;i<val;i++)
            {
                temp = temp + '(';
            }
            
            temp = temp + String.valueOf(val);
            
            for(int i=0;i<val;i++)
            {
                temp = temp + ')';
            }
            
        }
        
        for(int i=0;i<s.length()*1000;i++)
        {
            temp = rem(temp);
        }
        
        System.out.println(temp);
        
    }
    
    
    public static void main(String args[])
    {
        Scanner x = new Scanner(System.in);
        int t = x.nextInt();
        
        for(int z=1;z<=t;z++)
        {
            String s = x.next();
            
            System.out.print("Case #"+z+": ");
            
            nesting(s);
            
        }
        
    }
}