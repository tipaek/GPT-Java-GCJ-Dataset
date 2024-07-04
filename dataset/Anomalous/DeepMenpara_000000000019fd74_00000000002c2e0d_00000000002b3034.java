import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();

        for (int titer = 0; titer < t; titer++) {
            int n = sc.nextInt();
            String[] strarr = new String[n];
            List<String> strlist = new ArrayList<>();
            String[] startstrarr = new String[n];
            String[] endstrarr = new String[n];
            int maxstartstrlenind = -1;
            int maxendstrlenind = -1;
            int maxindex = 0;
            int maxstar = 0;
            int start = 0, end = 0;

            for (int i = 0; i < n; i++) {
                strarr[i] = sc.nextLine().replaceAll("\\s+", "");
                int firstStarIndex = strarr[i].indexOf('*');
                int lastStarIndex = strarr[i].lastIndexOf('*');
                int starCount = strarr[i].length() - strarr[i].replace("*", "").length();

                if (firstStarIndex > 0) {
                    String startstring = strarr[i].substring(0, firstStarIndex);
                    startstrarr[start] = startstring;
                    if (maxstartstrlenind == -1 || startstring.length() > startstrarr[maxstartstrlenind].length()) {
                        maxstartstrlenind = start;
                    }
                    start++;
                }

                if (lastStarIndex < strarr[i].length() - 1) {
                    String endstring = strarr[i].substring(lastStarIndex + 1);
                    endstrarr[end] = endstring;
                    if (maxendstrlenind == -1 || endstring.length() > endstrarr[maxendstrlenind].length()) {
                        maxendstrlenind = end;
                    }
                    end++;
                }

                String[] temparr = strarr[i].split("\\*");
                for (String s : temparr) {
                    if (!s.isEmpty() && !strlist.contains(s)) {
                        strlist.add(s);
                    }
                }

                if (starCount > maxstar) {
                    maxstar = starCount;
                    maxindex = i;
                }
            }

            boolean startbool = true;
            for (int k = 0; k < start; k++) {
                if (k != maxstartstrlenind && !startstrarr[maxstartstrlenind].contains(startstrarr[k])) {
                    startbool = false;
                    break;
                }
            }

            boolean endbool = true;
            for (int k = 0; k < end; k++) {
                if (k != maxendstrlenind && !endstrarr[maxendstrlenind].contains(endstrarr[k])) {
                    endbool = false;
                    break;
                }
            }

            if (startbool && endbool) {
                StringBuilder finalstr = new StringBuilder();
                if (maxstartstrlenind != -1) {
                    finalstr.append(startstrarr[maxstartstrlenind]);
                }

                String[] loopstrs = strarr[maxindex].split("\\*");
                int liindexer = 0;
                for (String loopstr : loopstrs) {
                    if (liindexer < strlist.size() && strlist.get(liindexer).isEmpty()) {
                        while (liindexer < strlist.size() && strlist.get(liindexer).isEmpty()) {
                            liindexer++;
                        }
                    }
                    if (liindexer < strlist.size() && !strlist.get(liindexer).isEmpty()) {
                        finalstr.append(strlist.get(liindexer));
                        liindexer++;
                    }
                }

                if (maxendstrlenind != -1) {
                    finalstr.append(endstrarr[maxendstrlenind]);
                }

                System.out.println("Case #" + (titer + 1) + ": " + finalstr);
            } else {
                System.out.println("Case #" + (titer + 1) + ": *");
            }
        }
    }

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