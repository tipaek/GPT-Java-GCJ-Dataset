import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution
{
    static boolean checkPrefix(String x, String y)
    {
        //System.out.println()
        if(x.length()<=y.length())
        {
            for(int i=0;i<x.length();i++)
            {
                if(x.charAt(i)!=y.charAt(i))
                {
                    return false;
                }
            }
        }
        else
        {
            for(int i=0;i<y.length();i++)
            {
                if(x.charAt(i)!=y.charAt(i))
                {
                    return false;
                }
            }
        }
        return true;

    }
    static boolean checkSuffix(String x, String y)
    {
        //System.out.println(x+" , "+y);
        if(x.length()<=y.length())
        {
            for(int i=x.length()-1;i>=0;i--)
            {
                if(x.charAt(i)!=y.charAt(i+y.length()-x.length()))
                {
                    return false;
                }
            }
        }
        else
        {
            for(int i=y.length()-1;i>=0;i--)
            {
                if(x.charAt(i+x.length()-y.length())!=y.charAt(i))
                {
                    //System.out.println("fuck");
                    return false;
                }
            }
        }
        return true;

    }
    public static void main(String[] args)
    {
        Scanner in =new Scanner(System.in);
        int t=in.nextInt();
        int test=1;
        while(t>0)
        {
            t--;
            System.out.print("Case #"+test+": ");
            test++;
            int n=in.nextInt();
            String[] p=new String[n];
            for(int i=0;i<n;i++)
                p[i]=in.next();
            //Stringbuffer first=new Stringbuffer("");
            //Stringbuffer last=new Stringbuffer("");
            StringBuffer prefix=new StringBuffer("");
            StringBuffer suffix=new StringBuffer("");
            boolean flag=true;
            for(int i=0;i<n;i++)
            {
                //System.out.println(i);
                String s=p[i];
                int pos=0;
                for(int j=0;j<s.length();j++)
                {
                    if(s.charAt(j)=='*')
                    {
                        pos=j;
                        break;
                    }
                }
                if(pos==0)
                {
                    String tmp=s.substring(1);
                    //System.out.println(suffix.toString());
                    if(checkSuffix(suffix.toString(),tmp)==false)
                    {
                        flag=false;
                        break;
                    }
                    else
                    {
                        if(suffix.length()<tmp.length())
                        {
                            suffix=new StringBuffer("");
                            suffix.append(tmp);
                        }
                    }
                }

                else if(pos==s.length()-1)
                {
                    String tmp=s.substring(0,s.length()-1);
                    //System.out.println(prefix.toString());
                    if(checkPrefix(prefix.toString(),tmp)==false)
                    {
                        flag=false;
                        break;
                    } 
                    else
                    {
                        if(prefix.length()<tmp.length())
                        {
                            
                            prefix=new StringBuffer();
                            prefix.append(tmp);
                        }
                    }
                }
                    
                else
                {
                    String tmp1=s.substring(0,pos);
                    String tmp2=s.substring(pos+1,s.length());
                    if(checkPrefix(tmp1,prefix.toString())==false || checkSuffix(tmp2,suffix.toString())==false)
                    {
                        flag=false;
                        break;
                    }
                    else
                    {
                        if(prefix.length()<tmp1.length())
                        {
                            //int l=prefix.length();
                            prefix=new StringBuffer();
                            prefix.append(tmp1);
                        }
                        if(suffix.length()<tmp2.length())
                        {
                            suffix=new StringBuffer("");
                            suffix.append(tmp2);
                        }
                    }
                }
            }
            //System.out.println(suffix.toString()+" "+flag);
            if(flag==false || prefix.length()+suffix.length()>10000)
                System.out.println("*");
            else
            {
                prefix.append(suffix);
                System.out.println(prefix.toString());
            }
            
        }
    }

}
