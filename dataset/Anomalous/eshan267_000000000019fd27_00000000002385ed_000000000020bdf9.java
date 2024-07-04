import java.util.*;
import java.io.*;

class Solution {
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

    public static void swap(int i, int[] ar, int[] br) {
        int temp = ar[i];
        ar[i] = ar[i + 1];
        ar[i + 1] = temp;

        temp = br[i];
        br[i] = br[i + 1];
        br[i + 1] = temp;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        StringBuilder ans = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[] ar = new int[n];
            int[] br = new int[n];

            Map<String, ArrayList<Integer>> hm = new HashMap<>();
            boolean hasTriple = false;
            for (int j = 0; j < n; j++) {
                ar[j] = sc.nextInt();
                br[j] = sc.nextInt();
                String key = ar[j] + " " + br[j];
                ArrayList<Integer> al = hm.getOrDefault(key, new ArrayList<>());
                al.add(j);
                hm.put(key, al);
                if (al.size() >= 3) {
                    hasTriple = true;
                }
            }

            if (!hasTriple) {
                for (int k = 0; k < n; k++) {
                    for (int j = 0; j < n - 1; j++) {
                        if (ar[j] > ar[j + 1]) {
                            swap(j, ar, br);
                        }
                    }
                }

                String[] assignments = new String[n];
                StringBuilder schedule = new StringBuilder();
                int cameronEnd = br[0];
                int jamieEnd = -1;
                int index = 1;

                ArrayList<Integer> al = hm.get(ar[0] + " " + br[0]);
                if (al.size() == 1) {
                    assignments[al.get(0)] = "C";
                } else {
                    assignments[al.get(0)] = "C";
                    assignments[al.get(1)] = "J";
                    jamieEnd = cameronEnd;
                    index++;
                }

                boolean possible = true;
                for (int j = index; j < n; j++) {
                    if (ar[j] >= cameronEnd) {
                        cameronEnd = br[j];
                        al = hm.get(ar[j] + " " + br[j]);
                        if (al.size() == 1) {
                            assignments[al.get(0)] = "C";
                        } else {
                            assignments[al.get(0)] = "C";
                            if (ar[j] >= jamieEnd) {
                                assignments[al.get(1)] = "J";
                                jamieEnd = cameronEnd;
                                j++;
                            } else {
                                possible = false;
                                break;
                            }
                        }
                    } else if (ar[j] >= jamieEnd) {
                        jamieEnd = br[j];
                        al = hm.get(ar[j] + " " + br[j]);
                        if (al.size() == 1) {
                            assignments[al.get(0)] = "J";
                        } else {
                            possible = false;
                            break;
                        }
                    } else {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    for (String assignment : assignments) {
                        schedule.append(assignment);
                    }
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                }

                ans.append("Case #").append(i).append(": ").append(schedule).append("\n");
            } else {
                ans.append("Case #").append(i).append(": IMPOSSIBLE\n");
            }
        }
        System.out.print(ans);
    }
}