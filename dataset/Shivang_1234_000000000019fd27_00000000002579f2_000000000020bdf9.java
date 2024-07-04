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
            }
            if(x<=2)
            {
                HashMap<Pair,Integer> hm=new HashMap<>();
                ArrayList<Pair> b=new ArrayList<>();
                ArrayList<Pair> c=new ArrayList<>();
                for(int i=0;i<n;i++)
                {
                    Pair x1=new Pair(s[i],e[i]);
                    hm.put(x1,0);
                    b.add(x1);
                    c.add(x1);
                }
                Collections.sort(b,new PairCompare());
                int endc=b.get(0).y;
                hm.replace(b.get(0),1);
                for(int i=1;i<n;i++)
                {
                    if(endc<=b.get(i).x)
                    {
                        endc=b.get(i).y;
                        hm.replace(b.get(i),1);
                    }
                }
                for(int i=0;i<n;i++)
                {
                    if(hm.get(c.get(i))==0)
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
class PairCompare implements Comparator<Pair>
{
    public int compare(Pair a,Pair b)
    {
        return a.y-b.y;
    }
}