import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {

        FastReader ss = new FastReader();
        int testCases = ss.nextInt();
        for (int test = 1; test <= testCases; test++) {
            int N = ss.nextInt();
            int K = ss.nextInt();
            if (K % N == 0) {
                System.out.println("Case #" + test + ": POSSIBLE");
                int arr[][] = new int[N][N];
                int num[] = new int[N - 1];
                int c = 1;
                for (int j = 0; j < N - 1; j++) {
                    if (c == K / N) c++;
                    num[j] = c++;
                }
                for (int j = 0; j < N; j++) {
                    for (int k = j; k < j + N; k++) {
                        if (j == k) arr[j][k] = K / N;
                        else arr[j][k % N] = num[k - j - 1];
                    }
                }
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) System.out.print(arr[j][k] + " ");
                    System.out.println();
                }
            } else
                System.out.println("Case #" + test + ": IMPOSSIBLE");
        }
    }

    private static boolean assignTracker(List<Activity> activities, List<Integer> tracker, int i) {
        return tracker.stream().allMatch(index -> activities.get(index).getFinish() <= activities.get(i).getStart());
    }

    static class Activity {
        int start;
        int finish;
        int index;
        char person;


        public Activity(int start, int finish, int index, char person) {
            this.start = start;
            this.finish = finish;
            this.index = index;
            this.person = person;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setPerson(char person) {
            this.person = person;
        }

        public char getPerson() {
            return person;
        }

        public int getIndex() {
            return index;
        }

        public int getStart() {
            return start;
        }

        public int getFinish() {
            return finish;
        }
    }

    public static void printMaxActivities(int s[], int f[], int n, char[] activitySchedular, char cj) {
        int i, j;

        i = 0;
        activitySchedular[i] = cj;
        for (j = 1; j < n; j++) {
            if (s[j] >= f[i]) {
                activitySchedular[j] = cj;
                i = j;
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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
}
