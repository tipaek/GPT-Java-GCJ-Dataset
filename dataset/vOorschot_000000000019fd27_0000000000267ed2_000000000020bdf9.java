import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Solution
{

    public static void main(String[] args)
    {
        new Solution().run();
    }

    private void run()
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++)
        {
            int N = sc.nextInt();
            timeslot[] slots = new timeslot[N];
            for (int n = 0; n < N; n++)
            {
                slots[n] = new timeslot(sc.nextInt(), sc.nextInt(),n);
            }
            Arrays.sort(slots);
            char[] schedule = new char[N];
            int c=0;
            int j =0;
            boolean impossible = false;
            for (int n = 0; n < N; n++)
            {
                if(slots[n].begin>=c){
                    c=slots[n].end;
                    schedule[slots[n].index] = 'C';
                    continue;
                }
                if(slots[n].begin>=j){
                    j=slots[n].end;
                    schedule[slots[n].index] = 'J';
                    continue;
                }
                impossible = true;
                break;
            }
            if(impossible){
                System.out.println("Case #"+t+": IMPOSSIBLE");
            }else{
                System.out.print("Case #"+t+": ");
                for(char s:schedule){
                    System.out.print(s);
                }
                System.out.println("");
            }
            
        }
    }
}

class timeslot implements Comparable<timeslot>
{

    int begin;
    int end;
    int index;

    public timeslot(int begin, int end, int i)
    {
        this.begin = begin;
        this.end = end;
        index = i;
    }

    @Override
    public int compareTo(timeslot o)
    {
        return Integer.compare(begin, o.begin);
    }

}
