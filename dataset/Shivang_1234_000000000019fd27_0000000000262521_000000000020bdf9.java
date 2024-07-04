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
            StringBuffer ans=new StringBuffer();
            for(int i=0;i<n;i++)
            {
                String s1[]=br.readLine().split(" ");
                s[i]=Integer.parseInt(s1[0]);
                e[i]=Integer.parseInt(s1[1]);
            }
            
            
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
            
            int k=0;
            for(int j=0;j<n;j++)
            {
                if(hm.get(b.get(j))==0)
                {
                    ++k;
                    int endc=b.get(j).y;
                    hm.replace(b.get(j),k);
                    for(int i=j+1;i<n;i++)
                    {
                        if(endc<=b.get(i).x&&hm.get(b.get(i))==0)
                        {
                            endc=b.get(i).y;
                            hm.replace(b.get(i),k);
                        }
                    }
                }
            }
            if(k<=2){
            for(int i=0;i<n;i++)
            {
                if(hm.get(c.get(i))==1)
                ans.append("J");
                else if(hm.get(c.get(i))==2)
                ans.append("C");
            }}
            else
            ans.append("IMPOSSIBLE");
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
        if(a.x==b.x)
        return a.y-b.y;
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