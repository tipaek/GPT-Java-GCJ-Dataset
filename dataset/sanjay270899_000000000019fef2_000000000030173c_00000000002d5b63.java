import java.util.*;
import java.lang.*;
import java.io.*;

class Two
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scan sc = new Scan();
        int t = sc.scanInt();
        int a = sc.scanInt();
        int b = sc.scanInt();
        for(int k=1; k<=t; k=k+1)
        {

            loop: for(int i=-5; i<=5; i=i+1)
            {
                for(int j=-5; j<=5; j=j+1)
                {
                    System.out.println(i + " " + j);
                    String temp = sc.scanString();
                    if(temp.equals("CENTER"))
                    {
                        break loop;
                    }
                    if(temp.equals("WRONG"))
                    {
                        return;
                    }
                }
            }
        }
    }
}

class Scan
{
    private byte[] buf=new byte[1024];
    private int index;
    private InputStream in;
    private int total;

    public Scan()
    {
        in=System.in;
    }

    public int scan()throws IOException
    {
        if(total<0)
            throw new InputMismatchException();

        if(index>=total)
        {
            index=0;
            total=in.read(buf);
            if(total<=0)
                return -1;
        }
        return buf[index++];
    }

    public int scanInt()throws IOException
    {
        int integer=0;
        int n=scan();

        while(isWhiteSpace(n))
            n=scan();
        int neg=1;

        if(n=='-')
        {
            neg=-1;
            n=scan();
        }

        while(!isWhiteSpace(n))
        {
            if(n>='0'&&n<='9')
            {
                integer*=10;
                integer+=n-'0';
                n=scan();
            }
            else throw new InputMismatchException();
        }
        return neg*integer;
    }

    public String scanString()throws IOException
    {
        StringBuilder sb=new StringBuilder();
        int n=scan();

        while(isWhiteSpace(n))
            n=scan();

        while(!isWhiteSpace(n))
        {
            sb.append((char)n);
            n=scan();
        }
        return sb.toString();
    }

    private boolean isWhiteSpace(int n)
    {
        if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
            return true;
        return false;
    }
}