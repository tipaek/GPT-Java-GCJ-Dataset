import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out, false);

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            char[] x = br.readLine().toCharArray();
            StringBuilder sb = new StringBuilder();
            int lastInsertedIndex = 0;

            if (x[0] != '0') {
                int digit = x[0] - '0';
                sb.append("(".repeat(digit)).append(x[0]).append(")".repeat(digit));
                lastInsertedIndex += digit;
            } else {
                sb.append('0');
                lastInsertedIndex = 1;
            }

            char last = x[0];
            for (int j = 1; j < x.length; j++) {
                if (x[j] == last) {
                    sb.insert(lastInsertedIndex, x[j]);
                    lastInsertedIndex += 1;
                    continue;
                }

                if (x[j] < last) {
                    if (x[j] == '0') {
                        sb.append('0');
                        last = x[j];
                        lastInsertedIndex = sb.length();
                    } else {
                        int count = 0;
                        for (int e = sb.length() - 1; e >= 0; e--) {
                            if (sb.charAt(e) == ')') {
                                count++;
                            } else {
                                break;
                            }
                        }

                        if (count == (x[j] - '0')) {
                            sb.insert(sb.length() - count, x[j]);
                            lastInsertedIndex = sb.length() - count;
                            last = x[j];
                        }
                    }
                    continue;
                }

                if (x[j] > last) {
                    int diff = (x[j] - '0') - (last - '0');
                    StringBuilder s1 = new StringBuilder();
                    s1.append("(".repeat(diff)).append(x[j]).append(")".repeat(diff));

                    if (last != '0') {
                        sb.insert(lastInsertedIndex + 1, s1.toString());
                        lastInsertedIndex += s1.length() / 2 + 1;
                    } else {
                        sb.insert(lastInsertedIndex, s1.toString());
                        lastInsertedIndex += s1.length() / 2;
                    }
                    last = x[j];
                    continue;
                }
            }

            pw.println("Case #" + i + ": " + sb.toString());
        }
        pw.flush();
    }
}