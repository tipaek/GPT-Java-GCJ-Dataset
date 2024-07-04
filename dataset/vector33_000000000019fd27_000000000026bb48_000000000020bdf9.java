import java.util.*;
public class Solution
{
    static void output(int a[],int b[],ArrayList<Interval> al,int n,int t)
    {
        char op[]=new char[n];
        Collections.sort(al,new mysort());
        Person cameron=new Person(0,0);
        Person jamie=new Person(0,0);
        for(int i=0;i<n;i++)
        {
            if(cameron.e>(al.get(i)).start && jamie.e>(al.get(i)).start)
            {
                System.out.println("Case #"+(t+1)+": "+"IMPOSSIBLE");
                return;
            }
            if(cameron.e<=(al.get(i)).start)
            {
                op[(al.get(i)).pos]='C';
                cameron.s=(al.get(i)).start;
                cameron.e=(al.get(i)).end;
            }
            else
            {
                op[(al.get(i)).pos]='J';
                jamie.s=(al.get(i)).start;
                jamie.e=(al.get(i)).end;
            }
        }
        String mop=new String(op);
        System.out.println("Case #"+(t+1)+": "+mop);
    }
    public static void main(String s[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        int i=0;
        while(i<t)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[n];
            ArrayList<Interval> al=new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                a[j]=sc.nextInt();
                b[j]=sc.nextInt();
                al.add(new Interval(a[j],b[j],j));
            }
            output(a,b,al,n,i);
            i++;
        }
    }
}
class Person
{
    int s;
    int e;
    Person(int start,int end)
    {
        s=start;
        e=end;
    }
}
class Interval
{
    int start,end,pos;
    Interval(int s,int e,int index)
    {
        start=s;
        end=e;
        pos=index;
    }
}
class mysort implements Comparator<Interval>
{
    public int compare(Interval a,Interval b)
    {
        return a.start-b.start;
    }
}