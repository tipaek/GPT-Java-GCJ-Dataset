import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String[] args)throws IOException
	{
		Scanner sc=new Scanner(System.in);
// 		Scanner sc=new Scanner(new File("sample.in.txt"));
		
		int p,t,n=10000,u,i,j;
        long m;
        Query q[];
        String k,st;
        HashMap<Character,Integer> charset;
        HashSet<Character> lastset;
        char starr[];

		p=t=sc.nextInt();

		while(t-->0)
		{
            u=sc.nextInt();
            q=new Query[n];
            charset=new HashMap<Character,Integer>();

            for(i=0;i<n;i++)
            {
                m=sc.nextLong();
                st=sc.next();
                q[i]=new Query(m,st);
                for(j=0;j<st.length();j++)
                    charset.put(st.charAt(j),0);
            }
            
            for(char ch:charset.keySet())
                charset.put(ch,9);

            lastset=new HashSet<>(charset.keySet());

            Arrays.sort(q,(Query aa,Query ab)->(((aa.qq-ab.qq)>0)?1:(((aa.qq-ab.qq)<0)?-1:0)));

            for(i=0;i<n;i++)
            {
                k=String.valueOf(q[i].qq);
                if(k.length()>q[i].rec.length())
                    continue;
                char ch=q[i].rec.charAt(0);
                if(lastset.contains(ch))
                    lastset.remove(ch);
                charset.put(ch,Math.min(charset.get(ch),(int)k.charAt(0)-48));
            }

            for(char ch:lastset)
                charset.put(ch,0);

            // System.out.println(charset);
            starr=new char[10];
            for(char ch:charset.keySet())
                starr[charset.get(ch)]=ch;
            
            System.out.println("Case #"+(p-t)+": "+new String(starr));
		}
	}
}
class Query
{
    long qq;
    String rec;
    public Query(long a,String r)
    {
        qq=a;
        rec=r;
    }
}