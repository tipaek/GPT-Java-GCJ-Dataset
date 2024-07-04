import java.util.*;
import java.io.*;

public class Solution
{
    public static String cdep(int n)
    {
        String s="";
        if (n<0)
        {
            while(n!=0)
            {
                s=s+")";
                n++;
            }
        }
        if(n>0)
        {
            while(n!=0)
            {
                s=s+"(";
                --n;
            }
        }
        return s;
    }

    public static void main (String[] args) 
    {
        
            Scanner ob=new Scanner(System.in);
            int cs=1;
            int t = ob.nextInt();
            while(t!=0)
            {
                String s=ob.next();
                String s1="";
                int d=0;
                int o=0;
                int c=0;
				int dif=0;
                int i=0;

                while(i<s.length())
                {
                    char x = s.charAt(i);
                    if(Character.isDigit(x))
                    {
                       dif = x - d;
                        if(dif>0)
                        {
                            s1 = s.substring(0,i)+cdep(dif)+s.substring(i);
                            i=i+dif;
                            d=(int)x;
                            o=o+dif;
                            s=s1;
                            s1="";
                        }
                        if(dif<0)
                        {
                            s1 = s.substring(0,i)+cdep(dif)+s.substring(i);
                            i=i+Math.abs(dif);
                            d=(int)x;
                            c=c+Math.abs(dif);
                            s=s1;;
                            s1="";
                        } 
                        if(dif == 0)
                        {
                            
                        }
                    }
                    i++;
                }
                if(o!=c)
                {
                    int cl = o-c;
                    while(cl!=0)
                    {
                        s=s+")";
                        --cl;
                    }
                }
				s=s.substring(48,s.length()-48);
                System.out.println("Case #"+cs+": "+s);
                cs++;
                --t;
            }
        
    }
}