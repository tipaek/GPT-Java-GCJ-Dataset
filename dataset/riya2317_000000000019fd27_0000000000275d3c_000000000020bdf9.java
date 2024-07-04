import java.util.*;
public class Solution
{
    static void output(int arr[],int brr[],ArrayList<Interval> c,int m,int r)
    {
        char d[] = new char[m];
        Collections.sort(c,new mysort());
        People cam=new People(0,0);
        People jam=new People(0,0);
        for(int k=0;k<m;k++)
        {
            if(cam.q>(c.get(k)).st && jam.q>(c.get(k)).st)
            {
                System.out.println("Case #"+(r+1)+": "+"IMPOSSIBLE");
                return;
            }
            if(cam.q<=(c.get(k)).st)
            {
                d[(c.get(k)).position]='C';
                cam.p=(c.get(k)).st;
                cam.q=(c.get(k)).ed;
            }
            else
            {
                d[(c.get(k)).position]='J';
                jam.p=(c.get(k)).st;
                jam.q=(c.get(k)).ed;
            }
        }
        String mp=new String(d);
        System.out.println("Case #"+(r+1)+": "+mp);
    }
    public static void main(String s[])
    {
        Scanner sc = new Scanner(System.in);
        int r=sc.nextInt();
        int k=0;
        while(k<r)
        {
            int m=sc.nextInt();
            int arr[]=new int[m];
            int brr[]=new int[m];
            ArrayList<Interval> c=new ArrayList<>();
            for(int j=0;j<m;j++)
            {
                arr[j]=sc.nextInt();
                brr[j]=sc.nextInt();
                c.add(new Interval(arr[j],brr[j],j));
            }
            output(arr,brr,c,m,k);
            k++;
        }
    }
}
class People
{
    int p;
    int q;
    People(int st,int ed)
    {
        p=st;
        q=ed;
    }
}
class Interval
{
    int st,ed,position;
    Interval(int p,int q,int idx)
    {
        st=p;
        ed=q;
        position=idx;
    }
}
class mysort implements Comparator<Interval>
{
    public int compare(Interval arr,Interval brr)
    {
        return arr.st-brr.st;
    }
}
