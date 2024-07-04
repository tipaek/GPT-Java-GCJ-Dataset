import java.util.*;
import java.io.*;

public class Solution
{
    public static void prarray(char ar[])
    {
        for(int i=0;i<ar.length;i++)
            if((int)ar[i]!=0)
                System.out.print(ar[i]);
        System.out.println();
    }
	public static void main(String[] args)throws IOException
	{
		Scanner sc=new Scanner(System.in);
// 		Scanner sc=new Scanner(new File("inp.txt"));
		
		int p,t,i,n,off,k,j;
        char ch[],c;
        boolean flag;
        String patterns[],st;

		p=t=sc.nextInt();

		while(t-->0)
		{
            n=sc.nextInt();
            patterns=new String[n];
            ch=new char[10000];
			
            for(i=0;i<n;i++)
                patterns[i]=sc.next();

            flag=true;
            for(i=0;i<n;i++)
            {
                st=patterns[i];
                for(j=0;j<st.length();j++)
                    if(st.charAt(j)=='*')
                        break;
                for(k=0;k<j;k++)
                {
                    c=st.charAt(k);
                    // System.out.println(c+" "+(int)ch[k]);
                    if((int)ch[k]==0)
                        ch[k]=c;
                    else
                    {
                        if(ch[k]==c)
                            continue;
                        flag=false;
                        break;
                    }
                }
                if(!flag)
                    break;
                for(k=j+1;k<st.length();k++)
                {
                    c=st.charAt(k);
                    off=k+10000-st.length();
                    // System.out.println(c+" "+(int)ch[off]);
                    if((int)ch[off]==0)
                        ch[off]=c;
                    else
                    {
                        if(ch[off]==c)
                            continue;
                        flag=false;
                        break;
                    }
                }                
                if(!flag)
                    break;
            }

            if(!flag)
                System.out.println("Case #"+(p-t)+": *");
            else
            {
                System.out.print("Case #"+(p-t)+": ");
                prarray(ch);
            }
		}
	}
}