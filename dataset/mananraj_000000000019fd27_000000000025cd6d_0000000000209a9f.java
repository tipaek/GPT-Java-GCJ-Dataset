import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt(); int tt=1;
        in.nextLine();
        while(t-->0)
        {
            String s=in.nextLine();String st="";String stt="";
            int l=s.length();int c=0;char ch,chh;
            for(int i=0;i<l;i++)
            {
                ch=s.charAt(i);
                if(ch=='0')
                {st+=ch;c++;}
                else if(ch=='1')
                {c++;st+="(1)";}
                else if(ch=='2')
                {c+=2;st+="((2))";}
                else if(ch=='3')
                {st+="(((3)))";c+=3;}
                else if(ch=='4')
                {st+="((((4))))";c+=4;}
                else if(ch=='5')
                {c+=5;st+="(((((5)))))";}
                else if(ch=='6')
                {st+="((((((6))))))";c+=6;}
                else if(ch=='7')
                {st+="(((((((7)))))))";c+=7;}
                else if(ch=='8')
                {st+="((((((((8))))))))";c+=8;}
                else
                {
                st+="(((((((((9)))))))))";
                c+=9;
                }
            }
            l=st.length();int z;
            for(int i=0;i<=c;i++)
            {
                stt="";
                stt+=st.charAt(0);
                for(int j=1;j<l;j++)
                {
                    ch=st.charAt(j);
                    chh=st.charAt(j-1);
                    if((ch=='(')&&(chh==')'))
                    {
                        z=stt.length();
                        stt=stt.substring(0,z-1);
                    }
                    else
                    stt+=ch;
                }
                st=stt;
                l=st.length();
            }
            System.out.println("Case #"+tt+": "+st);
            tt++;
        }
    }
}