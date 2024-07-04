import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Job {
        int val, b;
        Id jid;

        Job(Id i, int y) {
            jid = i;
            b = y;
        }

        public String toString() {
            return (this.b == 0) ? "Starting job at " + this.val : "Ending job at " + this.val;
        }
    }

    static class Id {
        int val, id;

        Id(int a, int b) {
            val = a;
            id = b;
        }
    }

    static class Comp implements Comparator<Job> {
        public int compare(Job o1, Job o2) {
            if (o1.jid.val != o2.jid.val) {
                return Integer.compare(o1.jid.val, o2.jid.val);
            }
            return Integer.compare(o2.b, o1.b);
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for (int kt = 1; kt <= t; kt++) {
            HashMap<Id, Id> se = new HashMap<>();
            PriorityQueue<Job> pq = new PriorityQueue<>(new Comp());
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                Id o1 = new Id(a, i);
                Id o2 = new Id(b, i);
                pq.add(new Job(o1, 0));
                pq.add(new Job(o2, 1));
                se.put(o1, o2);
            }

            HashMap<Id, Integer> hm = new HashMap<>();
            int[] work = new int[2];
            StringBuilder ans = new StringBuilder();
            char[] ch = {'C', 'J'};
            int flag = 0;
            char[] ans2 = new char[n];

            while (!pq.isEmpty()) {
                Job job = pq.poll();
                int l = -1;
                if (job.b == 1) {
                    if (hm.containsKey(job.jid)) {
                        l = hm.get(job.jid);
                        work[l] = 0;
                    }
                } else {
                    if (work[0] == 0) {
                        ans.append(ch[0]);
                        ans2[job.jid.id] = ch[0];
                        hm.put(se.get(job.jid), 0);
                        work[0] = 1;
                    } else if (work[1] == 0) {
                        ans.append(ch[1]);
                        ans2[job.jid.id] = ch[1];
                        hm.put(se.get(job.jid), 1);
                        work[1] = 1;
                    } else {
                        flag = -1;
                        break;
                    }
                }
            }

            if (flag == -1) {
                System.out.println("Case #" + kt + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + kt + ": " + new String(ans2));
            }
        }
    }
}