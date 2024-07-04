import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {



    public static boolean isIntersect(Interval a , Interval b)
    {
        boolean x = a.start<b.end && a.end > b.end;
        boolean y = b.start<a.end && b.end > a.end;

        return x || y;
    }

    public static boolean fits(ArrayList<Interval> arr, Interval b)
    {
        for (int i = 0;i<arr.size();i++)
        {
         if (isIntersect(b, arr.get(i)))
             return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i<=T;i++)
        {
            boolean impossible = false;
            int N = sc.nextInt();
            Interval[] intervalArr = new Interval[N];
            for(int j = 0; j<N;j++)
            {
                intervalArr[j]= new Interval(sc.nextInt(),sc.nextInt(),j);
            }
            boolean[] choices = new boolean[N];
            ArrayList<Interval> C = new ArrayList<>();
            ArrayList<Interval> J = new ArrayList<>();

            Arrays.sort(intervalArr);
            for(int j = 0; j<N;j++)
            {
                Interval x = intervalArr[j];
                if (fits(C,x)) {
                    C.add(x);
                    choices[x.getIndex()] = true;
                }
                else if (fits(J,x)) {
                    J.add(x);
                    choices[x.getIndex()] = false;
                }
                else
                {
                    impossible = true;
                    break;
                }
            }

            System.out.printf("Case#%d: ",i);
            if (impossible)
                System.out.println("IMPOSSIBLE");
            else
            {
                for(int k = 0; k<N;k++)
                {
                    if (choices[k])
                        System.out.print("C");
                    else
                        System.out.print("J");
                }
                System.out.println();
            }
        }
    }


    static class Interval implements Comparable<Interval>
    {
        int start;
        int end;
        int index;

        public Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public int compareTo(Interval o) {
            return start - o.start;
        }
    }

}
