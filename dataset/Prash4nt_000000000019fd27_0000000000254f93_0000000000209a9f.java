import java.util.*;

class Solution
{
public static void main(String [] args)
    {
    Scanner kb = new Scanner(System.in);
    int T = kb.nextInt();
    String s;
    int n,obr,cbr;
    
    for(int i=0;i<T;i++)
    {
        s = kb.next();
        obr=0;
        cbr=0;
        for(int a=0;a<s.length();a++)
        {
            n = Integer.parseInt(s.substring(a,a+1));
            if(n>obr)
            {
                for(int x=0;x<n-obr;x++)
                {
                    System.out.print("(");
                    if(x==n-obr-1)
                    {
                    System.out.print(n);
                    }
                }
                obr=n;
            }
            if(n<obr)
            {
                for(int x=0;x<obr-n;x++)
                {
                    System.out.print(")");
                    if(x==obr-n-1)
                    {
                    System.out.print(n);
                    }
                }
                obr -=n;
            }
            if(a==s.length()-1 && n!=0)
            {
               for(int x=0;x<obr-0;x++)
                {
                    System.out.print(")");
                } 
            }
            
            
        }
        
        
    }
    }
}