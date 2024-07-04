import java.io.*;
import java.util.*;
class Solution
{
public static void main(String[] args) 
{
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<t;i++)
        {
String s=sc.nextLine();
            char ch[]=s.toCharArray();

            StringBuilder sb=new StringBuilder("");
            int o=0;
            if(s.charAt(0)!='0')
            {sb.append("(");
                o++;
            }
            for(int j=0;j<s.length();j++)
            {
                int next=-1;
                String cur=""+s.charAt(j);
                int c=Character.getNumericValue(s.charAt(j));
                int f=0;
                for(int k=j+1;k<s.length();k++)
                {

                    next=Character.getNumericValue(s.charAt(k));

                    if(s.charAt(j)==s.charAt(k))
                        cur=cur+s.charAt(j);
                    else
                    {

                        j=k-1;

                        f=1;
                        break;
                    }
                }

                if((next==-1)||(next==c)||(f==0))
                {
                    j=s.length();
                    if(o==0&&c!=0)
                        sb.append("("+cur+")");
                    else
                    {sb.append(cur);
                        for(int k=0;k<o;k++)
                            sb.append(")");
                    }
                }
                else if(c==0)
                {
                    for(int k=0;k<o;k++)
                        sb.append(")");

                    sb.append(cur);
                }
                else
                {
                    int x=o;


                    for(int k=0;k<c-x;k++)
                    {
                        sb.append("(");
                        o++;
                    }
                    sb.append(cur);
                    if(next>c){
                    }
                    else
                    {
                        sb.append(")");
                        o--;
                        for(int k=0;k<c-next-1;k++)
                        {
                            sb.append(")");
                            o--;
                        }
                    }

                }

            }
            StringBuilder sb2=new StringBuilder("");
            sb2.append("Case #"+(i+1)+": "+sb);
            System.out.println(sb2);


    }
}
}