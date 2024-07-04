import java.util.*;
class Activity
{
    int number;
    int start;
    int end;
    Activity(int a,int b,int num)
    {
        start = a;
        end = b;
        number = num;
    }
}
class Solution
{
    public static String cj(ArrayList<Activity> A,int n)
    {
        char c[] = new char[n];
        int cend = 0;
        int jend = 0;
        for(int i = 0;i<n;i++)
        {
            if(A.get(i).start>=cend)
            {
                c[A.get(i).number] = 'C';
                cend = A.get(i).end;
            }
            else if(A.get(i).start>=jend)
            {
                c[A.get(i).number] = 'J';
                jend = A.get(i).end;
            }
            else
            {
                String s = "IMPOSSIBLE";
                return s;
            }
        }
        String s = new String(c);
        return s;
    }
    public static void main(String args[])
    {
        int n,start,end,t,test_case = 1;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while(t>0)
        {
            n = sc.nextInt();
            ArrayList<Activity> A = new ArrayList<Activity>();
            for(int i =0;i<n;i++)
            {
                start = sc.nextInt();
                end  = sc.nextInt();
                A.add(new Activity(start,end,i));
            }
            Collections.sort(A, new Comparator<Activity>() {
            @Override
            public int compare(Activity a1, Activity a2) {
                if(a1.start!=a2.start)return a1.start-a2.start;
                return a1.end-a2.end;
            }
             });
            String s = cj(A,n);
            System.out.println("Case #"+(test_case++)+": "+s);
            t--;
        }
    }
}