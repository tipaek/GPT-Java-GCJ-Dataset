import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= t; i++) {
            int u = Integer.parseInt(br.readLine().trim());
            int num = 10000;
            HashSet<Character>[] chars = new HashSet[10];
            HashSet<Character> nonZero = new HashSet<>();

            for (int j = 0; j < 10; j++) {
                chars[j] = new HashSet<>();
            }

            while (num-- > 0) {
                String[] input = br.readLine().trim().split("\\s+");
                long q = Long.parseLong(input[0]);
                String r = input[1];
                int qLen = input[0].length();

                char firstChar = r.charAt(0);
                int rLen = r.length();

                if (q != -1 && rLen == 1) {
                    if (chars[0].contains(firstChar)) {
                        chars[0].remove(firstChar);
                        nonZero.add(firstChar);
                    }
                } else if (q != -1 && rLen == qLen) {
                    int maxVal = input[0].charAt(0) - '0';

                    if (chars[0].contains(firstChar) || (nonZero.contains(firstChar) && chars[1].contains(firstChar))) {
                        for (int j = 1; j <= maxVal; j++) {
                            if (!chars[j].contains(firstChar)) {
                                maxVal = j - 1;
                                break;
                            }
                        }
                    }

                    int start = nonZero.contains(firstChar) ? 1 : 0;
                    for (int j = start; j <= maxVal; j++) {
                        chars[j].add(firstChar);
                    }

                    for (int j = maxVal + 1; j <= 9; j++) {
                        if (chars[j].contains(firstChar)) {
                            chars[j].remove(firstChar);
                        } else {
                            break;
                        }
                    }
                } else {
                    if (!chars[0].contains(firstChar) && !nonZero.contains(firstChar)) {
                        for (int j = 0; j <= 9; j++) {
                            chars[j].add(firstChar);
                        }
                    } else if (nonZero.contains(firstChar)) {
                        for (int j = 1; j <= 9; j++) {
                            chars[j].add(firstChar);
                        }
                    }
                }

                for (int j = 1; j < rLen; j++) {
                    char c = r.charAt(j);
                    int start = nonZero.contains(c) ? 1 : 0;
                    for (int k = start; k <= 9; k++) {
                        if (!chars[k].contains(c)) {
                            chars[k].add(c);
                        } else {
                            break;
                        }
                    }
                }
            }

            char[] ans = new char[10];
            HashSet<Character> used = new HashSet<>();

            for (int k = 0; k <= 9; k++) {
                for (int j = 0; j <= 9; j++) {
                    if (chars[j].size() == 1) {
                        Iterator<Character> itr = chars[j].iterator();
                        while (itr.hasNext()) {
                            char ch = itr.next();
                            ans[j] = ch;
                            used.add(ch);
                        }
                        chars[j].clear();
                    } else {
                        chars[j].removeAll(used);
                    }
                }
            }

            for (int j = 9; j >= 0; j--) {
                if (ans[j] != '\u0000') {
                    continue;
                }
                char ch = '?';
                Iterator<Character> itr = chars[j].iterator();
                while (itr.hasNext()) {
                    ch = itr.next();
                    if (!used.contains(ch)) {
                        break;
                    }
                }
                ans[j] = ch;
                used.add(ch);
            }

            bw.write("Case #" + i + ": " + String.valueOf(ans) + "\n");
        }

        br.close();
        bw.close();
    }
}