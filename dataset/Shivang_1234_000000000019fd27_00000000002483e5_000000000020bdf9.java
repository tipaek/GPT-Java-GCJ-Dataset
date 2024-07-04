import java.util.*;
import java.io.*;
public class Solution
{
	public static void main (String[] args)throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int l=1;l<=t;l++)
        {
            int n=Integer.parseInt(br.readLine());
            int s[]=new int[n];
            int e[]=new int[n];
            ArrayList<Pair> a=new ArrayList<>();
            StringBuffer ans=new StringBuffer();
            for(int i=0;i<n;i++)
            {
                String s1[]=br.readLine().split(" ");
                s[i]=Integer.parseInt(s1[0]);
                a.add(new Pair(s[i],1));
                e[i]=Integer.parseInt(s1[1]);
                a.add(new Pair(e[i],-1));
            }
            Collections.sort(a,new PairComparator());
            int x=0,t1=-1;
            for(int i=0;i<a.size();i++)
            {
                t1=x;
                x+=a.get(i).y;
                if(x>2)
                {
                    ans=new StringBuffer("IMPOSSIBLE");
                    break;
                }
                if(t1==0&&x==1)
                ans.append("C");
                else if(t1==1&&x==2)
                {
                    if(ans.charAt(ans.length()-1)=='C')
                    ans.append("J");
                    else
                    ans.append("C");
                }
            }
            System.out.println("Case #"+l+": "+ans);
        }
	}
}
class Pair
{
    int x,y;
    Pair(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
class PairComparator implements Comparator<Pair>
{
    public int compare(Pair a,Pair b)
    {
        return a.x-b.x;
    }
}