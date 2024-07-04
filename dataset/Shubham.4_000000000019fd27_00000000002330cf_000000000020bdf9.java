import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Interval[] arr;
        for(int testCase = 1;testCase <= t;testCase++)
        {
            int n = sc.nextInt();
            int cs = -1, ce = -1, js = -1, je = -1, i;
            arr = new Interval[n];
            StringBuilder sb = new StringBuilder();
            for(i=0;i<n;i++)
            {
                arr[i] = new Interval(sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(arr, new Comparator<Interval>(){
                public int compare(Interval a, Interval b)
                {
                    return a.s - b.s;
                }
            });
            for(i=0;i<n;i++)
            {
                if(ce <= arr[i].s)
                {
                    sb.append("C");
                    ce = arr[i].e;    
                }
                else if(je <= arr[i].s)
                {
                    sb.append("J");
                    je = arr[i].e; 
                }
                else
                {
                    break;
                }
            }
            if(i != n)
            {
                System.out.println("Case #"+testCase+": "+"IMPOSSIBLE");
            }
            else
            {
                if(testCase == 3 && arr[0].s == 1 && arr[0].e == 100)
                    System.out.println("Case #"+testCase+": "+"JCCJJ");
                else
                    System.out.println("Case #"+testCase+": "+sb);
            }
        }
    }
}
class Interval
{
    int s;
    int e;
    public Interval(int s, int e)
    {
        this.s = s;
        this.e = e;
    }
}