import java.util.*;
public class Main{
    public static void main(String [] args)
    {
        Scanner kb=new Scanner(System.in);
        int t=kb.nextInt();
       for(int k=1;k<=t;k++)
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
            System.out.println("Case #"+t+": "+str.toString());
        }
    }
}