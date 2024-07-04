import java.io.*;
import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int i,t,len,j,p;
        String s,str;
        t=sc.nextInt();
        sc.nextLine();
        for(i=0;i<t;i++)
        {
            s=sc.nextLine();
            str=s;
            len=s.length();
            p=0;
            System.out.print("Case #"+(i+1)+": ");
            for(j=0;j<len;j++)
            {
                if(s.charAt(j)=='1'&&p==1)
                {
                    System.out.print(s.charAt(j));
                }
                else if(s.charAt(j)=='1'&&p==0)
                {
                    p=1;
                    System.out.print("("+s.charAt(j));
                }
                else if(s.charAt(j)=='0'&& p==1)
                {
                    System.out.print(")"+s.charAt(j));
                    p=0;
                }
                else
                {
                    System.out.print(s.charAt(j));
                }
                
            }
            if(p==1)
            {
                System.out.println(")");
            }
            System.out.println();
            
        }
        
    }
}