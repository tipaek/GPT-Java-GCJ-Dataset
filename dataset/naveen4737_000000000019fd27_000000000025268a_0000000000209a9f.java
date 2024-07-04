import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t,i,cou,i1;
        String s1,s2;
        boolean open=false;
        t=sc.nextInt();
        String s[] = new String[t];
        for(i=0;i<t;i++)
            s[i]=sc.next();
        for(i1=0;i1<t;i1++)
        {
            cou=1;
            s1=s[i1];
            s2="";
            while(cou<=9)
            {
                open=false;
                for(i=0;i<s1.length();i++)
                {
                    if(!(Character.isDigit(s1.charAt(i))))
                        s2=s2+s1.charAt(i);
                    else
                    {
                        if(s1.charAt(i)!='0')
                        {
                            if(open == false)
                            {
                                //s2=s2+"("+Integer.toString(Integer.paseInt(s1.charAt(i))-1);
                                s2=s2+"("+(char)((s1.charAt(i))-1);
                                open = true;
                            }
                            else if(open == true)
                            {
                                s2=s2+(char)((s1.charAt(i))-1);
                            }
                        }
                        else if(s1.charAt(i)=='0')
                        {
                            //if(i!=0 && Character.isDigit(s1.charAt(i-1)) && s1.charAt(i-1)!='0')
                            if(open == true)
                            {
                                open = false;
                                s2 = s2 + ")" + 0;
                            }
                            else
                                s2=s2+"0";
                        }
                    }
                    if(open == true && i==s1.length()-1)
                        s2=s2+")";
                }
                cou++;
                s1=s2;
                s2="";
            }
            cou=0;
            for(int i2=0;i2<s1.length();i2++)
            {
                if(Character.isDigit(s1.charAt(i2)))
                {
                    s1=s1.substring(0,i2) + s[i1].charAt(cou) + s1.substring(i2+1,s1.length());
                    cou++;
                }
            }
            System.out.println("Case #"+(i1+1)+": "+s1);
        }
    }
}