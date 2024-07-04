import java.util.*;

class Solution
{
public static void main(String [] args)
    {
      Scanner kb = new Scanner(System.in);
    int T = kb.nextInt();
    String s;
    int n,obr;
    
    for(int i=0;i<T;i++)
    {
        s = kb.next();
        obr=0;
        System.out.print("Case #"+(i+1)+": ");
        for(int a=0;a<s.length();a++)
        {
            n = Integer.parseInt(s.substring(a,a+1));
            if(n>obr)
            {
                for(int x=0;x<n-obr;x++)
                {
                    System.out.print("(");
                }
                obr=n;
            }
            if(n<obr)
            {
                for(int x=0;x<obr-n;x++)
                {
                    System.out.print(")");
                }
                obr=n;
            }
            System.out.print(n);
            if(a==s.length()-1 && n!=0)
            {
               for(int x=0;x<obr-0;x++)
                {
                    System.out.print(")");
                } 
            }
            
            
        }
        
        System.out.println();
    }
    
    }
}