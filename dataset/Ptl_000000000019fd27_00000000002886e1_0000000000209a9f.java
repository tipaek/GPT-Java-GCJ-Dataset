import java.util.Set;
import java.util.Scanner;
import java.util.HashSet;

public class Main
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
            
            int n=0;
            int pa=0;
            
            int first=Character.getNumericValue(ar[0]);
            n=first;
            pa=first;
            
            for(int i=0;i<first;i++)
            {
                str.append('(');
            }
            str.append(first);
            
            for(int i=1;i<ar.length;i++)
            {
                int a=Character.getNumericValue(ar[i]);
                
                if(a==n)
                {
                    str.append(a);
                }
                else if(a>n)
                {
                    int d=a-n;
                    for(int j=0;j<d;j++)
                    {
                        str.append('(');
                        pa++;
                    }
                    str.append(a);
                }
                else
                {
                    int d=n-a;
                    
                    for(int j=0;j<d;j++)
                    {
                        str.append(')');
                        pa--;
                    }
                    str.append(a);
                }
                n=Character.getNumericValue(ar[i]);
            }
            while(pa-->0)
            {
                str.append(')');
            }
            System.out.println("Case #"+(tn++)+": "+str.toString());
        }
}
