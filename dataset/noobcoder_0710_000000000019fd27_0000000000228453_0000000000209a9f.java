import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String args[])throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        for(int x=0;x<t;x++)
        {
            String s=br.readLine();
            StringBuffer temp=new StringBuffer();
            if(s.length()==1)
            {
                for(int i=0;i<s.charAt(0)-'0';i++)
                temp.append('(');
                temp.append(s.charAt(0));
                for(int i=0;i<s.charAt(0)-'0';i++)
                temp.append(')');
            }
            else
            {
                for(int i=0;i<s.length();i++)
                {
                    
                    int ind;
                    if(temp.length()==0)
                    {
                        ind=0;
                    }
                    else
                    {
                        ind=temp.length();
                    }
                    temp.append(s.charAt(i));
                        if(s.charAt(i)=='0')
                        {
                            if(temp.length()>1&&temp.charAt(temp.length()-2)!='0')
                            {
                                int tind=-1;
                                for(int k=temp.length()-2;k>=0;k--)
                                {
                                    if(temp.charAt(k)=='0')
                                    {
                                        //pw.println(temp);
                                        //pw.println("HO"+" "+x);
                                        tind=k;
                                        break;
                                    }
                                }
                                if(tind==-1)
                                {
                                    temp.insert(0,'(');
                                    temp.insert(temp.length()-1,')');
                                    //pw.println(temp);
                                }
                                else
                                {
                                    temp.insert(tind+1,'(');
                                    temp.insert(temp.length()-1,')');
                                }
                            }
                            continue;
                        }
                        int j=0,cntr=1;
                        for(j=i+1;j<s.length();j++)
                            {
                                if(s.charAt(j)!=s.charAt(i))
                                {
                                    break;
                                }
                                cntr++;
                            }
                        for(int k=i+1;k<j;k++)
                        {
                            temp=temp.append(s.charAt(k));
                        }
                        i=j-1;
                        for(int k=0;k<s.charAt(i)-'0'-1;k++)
                        temp=temp.insert(ind,'(');
                        for(int k=0;k<s.charAt(i)-'0'-1;k++)
                        temp.append(')');
                        if(i==s.length()-1)
                        {
                            int tind=-1;
                            for(int k=temp.length()-2;k>=0;k--)
                            {
                                if(temp.charAt(k)=='0')
                                {
                                    tind=k;
                                    break;
                                }
                            }
                            if(tind==-1)
                            {
                                temp.insert(0,'(');
                                temp.append(')');
                            }
                            else
                            {
                                temp.insert(tind+1,'(');
                                temp.append(')');
                            }
                        }
                   // }
                }
            }
            pw.println("Case #"+(x+1)+": "+temp);
        }
        pw.flush();
        pw.close();
    }
}