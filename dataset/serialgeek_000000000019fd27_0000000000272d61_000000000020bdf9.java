import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static class Operation {
        public class Pair implements Comparable<Pair> {
            int start, end;
            char assignee;

            public Pair(int i, int j) {
                start = i;
                end = j;
            }

            @Override
            public int compareTo(Pair o) {
                return this.end - o.end;
            }
        }

        public String getSchedule(Pair[] arr) {
            int N = arr.length;
            Pair[] pairList = arr.clone();
            Arrays.sort(pairList);
            int count = 0;
            int r1 = pairList[0].end;
            pairList[0].assignee = 'C';

            for (int i = 1; i < pairList.length; i++) {
                int l1 = pairList[i].start;
                int r2 = pairList[i].end;

                if (l1 >= r1) {
                    count++;
                    r1 = r2;
                    pairList[i].assignee = 'C';
                }
            }
            if (count == 0)
                return "IMPOSSIBLE";
            else if (count + 1 == N) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    sb.append('C');
                }
                return sb.toString();
            } else {
                for (int i = 1; i < N; i++) {
                    if (pairList[i].assignee == 'C' || pairList[i].assignee == 'J')
                        continue;
                    else {
                        if (pairList[i - 1].assignee == 'C')
                            pairList[i].assignee = 'J';
                        else if (pairList[i - 1].assignee == 'J')
                            pairList[i].assignee = 'C';
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    sb.append(getAssignee(arr[i].start, arr[i].end, pairList));
                }
                return sb.toString();
            }
        }

        public char getAssignee(int start, int end, Pair[] list) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].start == start && list[i].end == end)
                    return list[i].assignee;
            }
            return 'C';
        }

        public void solve(Scanner scan) throws IOException {
            int T = scan.nextInt(), t = 0;
            while (T-- > 0) {
                t++;
                int N = scan.nextInt();
                Pair[] intervals = new Pair[N];
                for (int i = 0; i < N; i++) {
                    intervals[i] = new Pair(scan.nextInt(), scan.nextInt());
                }
                System.out.println("Case #" + t + ": " + getSchedule(intervals));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Operation obj = new Operation();
        obj.solve(scan);
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader s) throws FileNotFoundException {
            br = new BufferedReader(s);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}