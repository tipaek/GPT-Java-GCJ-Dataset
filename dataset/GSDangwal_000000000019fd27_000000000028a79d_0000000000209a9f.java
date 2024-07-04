import java.util.Set;
import java.util.Scanner;
import java.util.HashSet;

public class Solution
{
    private static Scanner kb;
    static int tn=1;
    
    public static void main(String [] args)
    {
        kb=new Scanner(System.in);
        
        int t=kb.nextInt();
        kb.nextLine();
        
        while(t-->0){
            solve();
        }
    }
       private static void solve()
        {
            String s=kb.nextLine();
            StringBuilder str=new StringBuilder();
            char[] ar=s.toCharArray();
            
            int no=0;
            int p=0;
            
            int first=Character.getNumericValue(ar[0]);
            no=first;
            p=first;
            
            for(int i=0;i<first;i++)
            {
                str.append('(');
            }
            str.append(first);
            
            for(int i=1;i<ar.length;i++)
            {
                int a=Character.getNumericValue(ar[i]);
                
                if(a==no)
                {
                    str.append(a);
                }
                else if(a>no)
                {
                    int d=a-no;
                    for(int j=0;j<d;j++)
                    {
                        str.append('(');
                        p++;
                    }
                    str.append(a);
                }
                else
                {
                    int d=no-a;
                    
                    for(int j=0;j<d;j++)
                    {
                        str.append(')');
                        p--;
                    }
                    str.append(a);
                }
                no=Character.getNumericValue(ar[i]);
            }
            while(p-->0)
            {
                str.append(')');
            }
            System.out.println("Case #"+(tn++)+": "+str.toString());
        }
}