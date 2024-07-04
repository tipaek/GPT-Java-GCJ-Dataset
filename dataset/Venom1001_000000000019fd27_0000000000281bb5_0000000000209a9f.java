import java.util.*;
public class Solution
{
    static int pc=0;
    static StringBuilder fs=new StringBuilder("");
    static void inc(int n)
    {  
        for(;n>0;n--)
        {
            fs.append("(");
            pc++;
        }
    }
    static void dec(int n)
    {
        for(;n>0;n--)
        {
            fs.append(")");
            pc--;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String is;
        int t,l,r;
        t=sc.nextInt();
        for(int tt=1;tt<=t;tt++,pc=0)
        {
            is=sc.next();
            l=is.length();
            for(r=0;r<l;r++)
            {
                if(is.charAt(r)=='0')
                {
                    if(pc<0)
                    inc(0-pc);
                    else if(pc>0)
                    dec(pc-0);
                    fs.append(is.charAt(r));
                }   
                else if(is.charAt(r)=='1')
                {
                    if(pc<1)
                    inc(1-pc);
                    else if(pc>1)
                    dec(pc-1);
                    fs.append(is.charAt(r));
                }else if(is.charAt(r)=='2')
                {
                    if(pc<2)
                    inc(2-pc);
                    else if(pc>2)
                    dec(2-pc);
                    fs.append(is.charAt(r));
                }
                else if(is.charAt(r)=='3')
                {
                    if(pc<3)
                    inc(3-pc);
                    else if(pc>3)
                    dec(pc-3);
                    fs.append(is.charAt(r));
                }
                else if(is.charAt(r)=='4')
                {
                    if(pc<4)
                    inc(4-pc);
                    else if(pc>4)
                    dec(pc-4);
                    fs.append(is.charAt(r));
                }
                else if(is.charAt(r)=='5')
                {
                    if(pc<5)
                    inc(5-pc);
                    else if(pc>5)
                    dec(pc-5);
                    fs.append(is.charAt(r));
                }
                else if(is.charAt(r)=='6')
                {
                    if(pc<6)
                    inc(6-pc);
                    else if(pc>6)
                    dec(pc-6);
                    fs.append(is.charAt(r));
                }
                else if(is.charAt(r)=='7')
                {
                    if(pc<7)
                    inc(7-pc);
                    else if(pc>7)
                    dec(pc-7);
                    fs.append(is.charAt(r));
                }
                else if(is.charAt(r)=='8')
                {
                    if(pc<8)
                    inc(8-pc);
                    else if(pc>8)
                    dec(pc-8);
                    fs.append(is.charAt(r));
                }
                else if(is.charAt(r)=='9')
                {
                    if(pc<9)
                    inc(9-pc);
                    else if(pc>9)
                    dec(pc-9);
                    fs.append(is.charAt(r));
                }
                if(r==l-1)
                {
                    dec(pc);
                }
            }
            System.out.println("Case #"+tt+": "+fs);
            fs=fs.delete(0,fs.length());
        }

    }
}