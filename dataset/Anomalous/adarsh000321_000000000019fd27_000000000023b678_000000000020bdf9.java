import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    static Point[] points;

    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int testCases = sc.nextInt();
        StringBuilder result = new StringBuilder();
        
        for (int t = 1; t <= testCases; t++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(t).append(": ");
            int n = sc.nextInt();
            points = new Point[n];
            int[] schedule = new int[2000];
            
            for (int i = 0; i < n; i++) {
                points[i] = new Point(sc.nextInt(), sc.nextInt() - 1);
                schedule[points[i].x]++;
                schedule[points[i].y + 1]--;
            }
            
            boolean isPossible = true;
            for (int i = 1; i < schedule.length; i++) {
                schedule[i] += schedule[i - 1];
                if (schedule[i] > 2) {
                    isPossible = false;
                    break;
                }
            }
            
            if (!isPossible) {
                sb.append("IMPOSSIBLE\n");
                result.append(sb);
                continue;
            }
            
            char[] assignments = new char[n];
            Arrays.fill(assignments, '0');
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (intersects(points[i], points[j])) {
                        if (assignments[i] == '0' && assignments[j] == '0') {
                            assignments[i] = 'C';
                            assignments[j] = 'J';
                        } else if (assignments[i] == '0') {
                            assignments[i] = (assignments[j] == 'C') ? 'J' : 'C';
                        } else if (assignments[j] == '0') {
                            assignments[j] = (assignments[i] == 'C') ? 'J' : 'C';
                        }
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                if (assignments[i] == '0') {
                    assignments[i] = 'C';
                }
            }
            
            sb.append(assignments).append('\n');
            result.append(sb);
        }
        
        System.out.print(result);
    }

    static boolean intersects(Point p1, Point p2) {
        return (p1.x >= p2.x && p1.x <= p2.y) || (p1.y >= p2.x && p1.y <= p2.y);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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