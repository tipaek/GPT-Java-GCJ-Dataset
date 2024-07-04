import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    int N;
    int[][] work;
    int lastAssign = 1;
    String resultString = "";

    void addWork(int startTime, int endTime, int assign, int index) {
        int[][] tempArray;
        int tempIndex;

        if (work.length == 0) {
            work = new int[1][4];
            work[0][0] = startTime;
            work[0][1] = endTime;
            work[0][2] = assign;
            work[0][3] = index;
        } else {
            tempArray = work;
            tempIndex = 0;
            work = new int[tempArray.length + 1][4];
            boolean newAdded = false;

            for (int i = 0; i < work.length; i++) {
                if (i == work.length - 1 && !newAdded) {
                    work[i][0] = startTime;
                    work[i][1] = endTime;
                    work[i][2] = assign;
                    work[i][3] = index;
                    break;
                }

                if (startTime < tempArray[tempIndex][0] && !newAdded) {
                    work[i][0] = startTime;
                    work[i][1] = endTime;
                    work[i][2] = assign;
                    work[i][3] = index;
                    newAdded = true;
                } else {
                    work[i][0] = tempArray[tempIndex][0];
                    work[i][1] = tempArray[tempIndex][1];
                    work[i][2] = tempArray[tempIndex][2];
                    work[i][3] = tempArray[tempIndex][3];
                    tempIndex++;
                }
            }
        }
    }

    void getResult() {
        for (int i = 0; i < work.length; i++) {
            boolean overlap = false;
            boolean CConflict = false;
            boolean JConflict = false;

            if (i == 0) {
                work[0][2] = 0;
                lastAssign = 0;
                updateResultString(work[0][3], 'C');
                continue;
            }

            for (int j = 0; j < i; j++) {
                if ((work[j][0] >= work[i][0] && work[j][0] < work[i][1]) || (work[i][0] >= work[j][0] && work[i][0] < work[j][1])) {
                    overlap = true;
                    if (work[j][2] == 0) CConflict = true;
                    if (work[j][2] == 1) JConflict = true;
                }
            }

            if (overlap) {
                if (CConflict && JConflict) {
                    resultString = "IMPOSSIBLE";
                    work[i][2] = 4;
                } else if (CConflict) {
                    work[i][2] = 1;
                    lastAssign = 1;
                    updateResultString(work[i][3], 'J');
                } else if (JConflict) {
                    work[i][2] = 0;
                    lastAssign = 0;
                    updateResultString(work[i][3], 'C');
                }
            } else {
                char assignChar = (lastAssign == 1) ? 'C' : 'J';
                lastAssign = (lastAssign == 1) ? 0 : 1;
                work[i][2] = lastAssign;
                updateResultString(work[i][3], assignChar);
            }
        }
    }

    void updateResultString(int index, char assignChar) {
        if (!resultString.equals("IMPOSSIBLE")) {
            StringBuilder sb = new StringBuilder(resultString);
            sb.setCharAt(index, assignChar);
            resultString = sb.toString();
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            Solution obj = new Solution();
            obj.work = new int[0][4];
            obj.N = sc.nextInt();
            obj.resultString = "B".repeat(obj.N);

            for (int i = 0; i < obj.N; i++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();
                obj.addWork(startTime, endTime, 2, i);
            }

            obj.getResult();
            System.out.println("Case #" + t + ": " + obj.resultString);
        }
    }
}