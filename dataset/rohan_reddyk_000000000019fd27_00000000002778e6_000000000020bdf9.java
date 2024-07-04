import java.util.*;
class Time implements Comparable<Time>
{
    int s,e;
    Time(int s,int e)
    {
        this.s=s;
        this.e=e;
    }
    public int compareTo(Time t)
    {
        return this.s-t.s;
    }
}
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
		sc.nextLine();
        int pr=1;
        while(t-->0)
        {
            ArrayList<Time>a=new ArrayList<>();
            int n=sc.nextInt();
            for(int i=0;i<n;i++)
            {
                int st=sc.nextInt();
                int et=sc.nextInt();
                a.add(new Time(st,et));
            }
            Collections.sort(a);
            String s="C";
            int min=a.get(0).e;
            int max=a.get(0).e;
            int p1=1,p2=0;
            String p="p1";
            for(int i=1;i<a.size();i++)
            {
                if(p1==1 && p2==0 && a.get(i).s<min)
                {
                    p2=1;
                    s=s+"J";
                    if(min>a.get(i).e)
                    {
                        p="p2";
                        min=a.get(i).e;
                    }
                }
                else if(p1==1 && p2==0 && a.get(i).s>=min)
                {
                    s=s+"C";
                    min=a.get(i).e;
                }
                else if(p1==0 && p2==1 && a.get(i).s<min)
                {
                    p1=1;
                    s=s+"C";
                    if(min>a.get(i).e)
                    {
                        p="p1";
                        min=a.get(i).e;
                    }
                }
                else if(p1==0 && p2==1 && a.get(i).s>=min)
                {
                    s=s+"J";
                    min=a.get(i).e;
                }
                else if(p1==1 && p2==1 && a.get(i).s>=min)
                {
                    if(p.equals("p1"))
                    {
                        s=s+"C";
                        if(a.get(i).e>max)
                        {
                            min=max;
                            max=a.get(i).e;
                            p="p2";
                        }
                        else
                        {
                            min=a.get(i).e;
                        }
                    }
                    else if(p.equals("p2"))
                    {
                        s=s+"J";
                        if(a.get(i).e>max)
                        {
                            min=max;
                            max=a.get(i).e;
                            p="p1";
                        }
                        else
                        {
                            min=a.get(i).e;
                        }
                    }
                }
                else if(p1==1 && p2==1 && a.get(i).s<min)
                {
                    s="IMPOSSIBLE";
                    break;
                }
                max=Math.max(max,a.get(i).e);
            }
            System.out.println("Case #"+pr+": "+s);
            pr++;
        }
    }
}