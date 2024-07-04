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
            int start = 0, end = 0;
            int maxstartstrlenind = -1, maxendstrlenind = -1;
            int maxindex = 0, maxstar = 0;

            for (int i = 0; i < n; i++) {
                strarr[i] = sc.nextLine().replaceAll("\\s+", "");
                int indexcount = 0, lastind = 0;
                boolean incstart = true, incend = true;
                int index = strarr[i].indexOf("*");

                if (index > 0) {
                    if (maxstartstrlenind == -1) {
                        maxstartstrlenind = 0;
                    }
                    String startstring = strarr[i].substring(0, index);
                    startstrarr[start] = startstring;
                    if (startstring.length() > startstrarr[maxstartstrlenind].length()) {
                        maxstartstrlenind = start;
                    }
                    start++;
                    incstart = false;
                }

                while (index >= 0) {
                    lastind = index;
                    index = strarr[i].indexOf("*", index + 1);
                    indexcount++;
                }

                if (lastind != strarr[i].length() - 1) {
                    if (maxendstrlenind == -1) {
                        maxendstrlenind = 0;
                    }
                    String endstring = strarr[i].substring(lastind + 1);
                    endstrarr[end] = endstring;
                    if (endstring.length() > endstrarr[maxendstrlenind].length()) {
                        maxendstrlenind = end;
                    }
                    end++;
                    incend = false;
                }

                String[] temparr = strarr[i].split("\\*");
                for (int j = 0; j < temparr.length; j++) {
                    if ((j == 0 && !incstart) || (j == temparr.length - 1 && !incend)) {
                        continue;
                    }
                    if (!strlist.contains(temparr[j])) {
                        strlist.add(temparr[j]);
                    }
                }

                if (indexcount > maxstar) {
                    maxstar = indexcount;
                    maxindex = i;
                }
            }

            boolean startbool = true, endbool = true;
            for (int k = 0; k < start; k++) {
                if (k != maxstartstrlenind && !startstrarr[maxstartstrlenind].contains(startstrarr[k])) {
                    startbool = false;
                }
            }

            for (int k = 0; k < end; k++) {
                if (k != maxendstrlenind && (endstrarr[maxendstrlenind] == null || !endstrarr[maxendstrlenind].contains(endstrarr[k]))) {
                    endbool = false;
                }
            }

            if (startbool && endbool) {
                StringBuilder finalstr = new StringBuilder();
                if (maxstartstrlenind != -1 && startstrarr[maxstartstrlenind] != null) {
                    finalstr.append(startstrarr[maxstartstrlenind]).append("X");
                }

                String[] loopstrs = strarr[maxindex].split("\\*");
                int liindexer = 0;
                for (int k = 0; k < loopstrs.length; k++) {
                    if (liindexer < strlist.size() && strlist.get(liindexer).isEmpty()) {
                        while (liindexer < strlist.size() && !strlist.get(liindexer).isEmpty()) {
                            liindexer++;
                        }
                    }
                    if (liindexer < strlist.size() && !strlist.get(liindexer).isEmpty()) {
                        if (k == loopstrs.length - 1) {
                            while (liindexer < strlist.size()) {
                                finalstr.append(strlist.get(liindexer)).append("X");
                                liindexer++;
                            }
                        } else {
                            finalstr.append(strlist.get(liindexer));
                            liindexer++;
                        }
                    } else {
                        finalstr.append("X");
                    }
                }

                if (maxendstrlenind != -1 && endstrarr[maxendstrlenind] != null) {
                    finalstr.append("X").append(endstrarr[maxendstrlenind]);
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