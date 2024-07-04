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
            boolean flag = false;
            arr = new Interval[n];
            StringBuilder sb = new StringBuilder();
            for(i=0;i<n;i++)
            {
                arr[i] = new Interval(i, sc.nextInt(), sc.nextInt());
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
                    arr[i].ch = 'C';
                    ce = arr[i].e;    
                }
                else if(je <= arr[i].s)
                {
                    arr[i].ch = 'J';
                    je = arr[i].e; 
                }
                else
                {
                    flag = true;
                    break;
                }
            }
            Arrays.sort(arr, new Comparator<Interval>(){
                public int compare(Interval a, Interval b)
                {
                    return a.i - b.i;
                }
            });
            for(i=0;i<n;i++)
            {
                sb.append(arr[i].ch);
            }
            if(flag)
            {
                System.out.println("Case #"+testCase+": "+"IMPOSSIBLE");
            }
            else
            {
                System.out.println("Case #"+testCase+": "+sb);
            }
        }
    }
}
class Interval
{
    int i;
    int s;
    int e;
    char ch;
    public Interval(int i, int s, int e)
    {
        this.i = i;
        this.s = s;
        this.e = e;
    }
}