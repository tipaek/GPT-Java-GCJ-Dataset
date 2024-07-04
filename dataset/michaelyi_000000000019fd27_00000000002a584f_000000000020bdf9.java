import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int testCase = 0; testCase < t; testCase++) {
            int n = sc.nextInt();
            HashMap<String, String> map = new HashMap<>();
            map.put("C", "0");
            map.put("J", "0");
            HashMap<String, String> records = new HashMap<>();
            int[][] ar = new int[n][2];
            int[][] og = new int[n][2];
            boolean possible = true;

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < 2; c++) {
                    ar[r][c] = sc.nextInt();
                    og[r][c] = ar[r][c];
                }
            }

            Arrays.sort(ar, (a, b) -> a[0] - b[0]);

            for (int i = 0; i < n; i++) {
                int s = ar[i][0];
                int e = ar[i][1];
                if (map.get("C") == "0" && map.get("J") == "0") {
                    map.put("C", s + " " + e);
                    records.put(s + " " + e, "C");
                } else if (map.get("C") != "0" && map.get("J") != "0") {
                    // check if still not done with activities. if yes, break and deem impossible
                    StringTokenizer st = new StringTokenizer(map.get("C"));
                    int cStart = Integer.parseInt(st.nextToken());
                    int cEnd = Integer.parseInt(st.nextToken());
                    st = new StringTokenizer(map.get("J"));
                    int jStart = Integer.parseInt(st.nextToken());
                    int jEnd = Integer.parseInt(st.nextToken());

                    if (s < cEnd && s < jEnd) {
                        possible = false;
                        break;
                    } else if (s >= cEnd) {
                        map.put("C", s + " " + e);
                        records.put(s + " " + e, "C");
                    } else if (s >= jEnd) {
                        map.put("J", s + " " + e);
                        records.put(s + " " + e, "J");
                    }

                } else if (map.get("C") != "0") {
                    // check for overlap. if yes, give to j
                    StringTokenizer st = new StringTokenizer(map.get("C"));
                    int cStart = Integer.parseInt(st.nextToken());
                    int cEnd = Integer.parseInt(st.nextToken());
                    if (s < cEnd) {
                        map.put("J", s + " " + e);
                        records.put(s + " " + e, "J");
                    } else {
                        map.put("C", s + " " + e);
                        records.put(s + " " + e, "C");
                    }
                } else if (map.get("J") != "0") {
                    // check for overlap. if yes, give to c
                    StringTokenizer st = new StringTokenizer(map.get("J"));
                    int jStart = Integer.parseInt(st.nextToken());
                    int jEnd = Integer.parseInt(st.nextToken());
                    if (s < jEnd) {
                        map.put("C", s + " " + e);
                        records.put(s + " " + e, "C");
                    } else {
                        map.put("J", s + " " + e);
                        records.put(s + " " + e, "J");
                    }
                }
            }

            if (!possible)
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            else {
                System.out.print("Case #" + (testCase + 1) + ": ");

                for (int r = 0; r < n; r++) {
                    System.out.print(records.get(og[r][0] + " " + og[r][1]));
                }

                System.out.println();
            }

            map.clear();
            records.clear();

        }
    }
}