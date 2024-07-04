import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k=0;
        StringBuilder s = new StringBuilder();

        for(k=1;k<=t;k++)
        {
            s.append("Case #" +k + ": " );
            int n = sc.nextInt();
            Pair p[] = new Pair[n];
            for (int i = 0; i < n; i++)
                p[i] = new Pair(sc.nextInt(), sc.nextInt(), i);
            Arrays.sort(p);
            long J = 0, C = 0;
            boolean bool = false;
            for (int i = 0; i < n; i++) {
                if (p[i].x >= C) {
                    C = p[i].y;
                    p[i].ch = 'C';
                } else if (p[i].x >= J) {
                    J = p[i].y;
                    p[i].ch = 'J';
                } else {
                    bool = true;
                    break;
                }
            }
            if (bool)
                s.append("IMPOSSIBLE\n");
            else {
                char arr[] = new char[n];
                for (Pair pr : p)
                    arr[pr.idx] = pr.ch;
                for (char ch : arr)
                    s.append(ch);
                s.append("\n");
            }
        }
        System.out.println(s);

        }

        static class Pair implements Comparable<Pair> {
        long x,y;
        int idx;
        char ch;
        Pair(long x, long y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Pair other) {
            if (this.x > other.x) {
                return 1;
            } else if (this.x < other.x) {
                return -1;
            } else if (this.y > other.y) {
                return 1;
            } else if (this.y < other.y) {
                return -1;
            }
            return 0;
        }
    }
}


