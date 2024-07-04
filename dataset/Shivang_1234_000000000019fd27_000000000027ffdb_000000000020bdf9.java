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
            int x=0;
            for(int i=0;i<a.size();i++)
            {
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
                ArrayList<Pair> c1=new ArrayList<>();
                for(int i=0;i<n;i++)
                {
                    Pair x1=new Pair(s[i],e[i]);
                    hm.put(x1,0);
                    b.add(x1);
                    c1.add(x1);
                }
                Collections.sort(b,new PairCompare());
                int c[]=new int[1500];
                int d[]=new int[1500];
                for(int i=0;i<n;i++)
                {
                    if(c[b.get(i).x]==0&&c[b.get(i).y]==0)
                    {
                        for(int j=b.get(i).x;j<=b.get(i).y;j++)
                        ++c[j];
                        hm.replace(b.get(i),1);
                    }
                    else if(c[b.get(i).x]==1&&c[b.get(i).x+1]==0&&c[b.get(i).y]==0)
                    {
                        for(int j=b.get(i).x+1;j<=b.get(i).y;j++)
                        ++c[j];
                        hm.replace(b.get(i),1);
                    }
                    else if(c[b.get(i).x]==1&&c[b.get(i).x+1]==0&&c[b.get(i).y]==1&&c[b.get(i).y-1]==0)
                    {
                        for(int j=b.get(i).x+1;j<=b.get(i).y-1;j++)
                        ++c[j];
                        hm.replace(b.get(i),1);
                    }
                    else if(c[b.get(i).x]==0&&c[b.get(i).y]==1&&c[b.get(i).y-1]==0)
                    {
                        for(int j=b.get(i).x;j<=b.get(i).y-1;j++)
                        ++c[j];
                        hm.replace(b.get(i),1);
                    }
                    /*for(int i1=0;i1<=13;i1++)
                    System.out.print(c[i1]+" ");
                    System.out.println();*/
                }
                for(int i=0;i<n;i++)
                {
                    if(hm.get(c1.get(i))==0)
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
        if(a.x==b.x)
        return a.y-b.y;
        return a.x-b.x;
    }
}
class PairCompare implements Comparator<Pair>
{
    public int compare(Pair a,Pair b)
    {
        return a.x-b.x;
    }
}