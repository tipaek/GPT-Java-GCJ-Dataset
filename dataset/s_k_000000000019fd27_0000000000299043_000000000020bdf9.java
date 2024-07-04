import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Activity
{
    int number;
    int start;
    int end;
    Activity(int x,int y,int numb)
    {
        start = x;
        end = y;
        number = numb;
    }
}
class Solution
{
    public static String Imp(ArrayList<Activity> Ar,int n)
    {
        char c[] = new char[n];
        int cend = 0;
        int jend = 0;
        for(int ind = 0;ind<n;ind++)
        {
            if(Ar.get(ind).start>=cend)
            {
                c[Ar.get(ind).number] = 'C';
                cend = Ar.get(ind).end;
            }
            else if(Ar.get(ind).start>=jend)
            {
                c[Ar.get(ind).number] = 'J';
                jend = Ar.get(ind).end;
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
        int n,start,end,t,ase = 1;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while(t-->0)
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
                if(a1.start!=a2.start)
                	return a1.start-a2.start;
                return a1.end-a2.end;
            }
             });
            String str = Imp(A,n);
            System.out.println("Case #"+(ase++)+": "+str);
            
        }
    }
}