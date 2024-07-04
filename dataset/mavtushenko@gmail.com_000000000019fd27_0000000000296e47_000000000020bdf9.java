import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int test = 1; test <= tests; ++test) {
            int n = in.nextInt();
            in.nextLine();
            int len = 24 * 60 + 1;
            int[] start = new int[len];
            int[] finish = new int[len];
            boolean imp = false;
            for (int i = 1; i <= n; ++i) {
                int st = in.nextInt();
                int fi = in.nextInt();
                if (start[st] == 0)
                    start[st] = i;
                else if (start[st] / 1000 == 0)
                    start[st] += i * 1000;
                else {
                    imp = true;
                    break;
                }

                if (finish[fi] == 0)
                    finish[fi] = i;
                else if (finish[fi] / 1000 == 0)
                    finish[fi] += i * 1000;
                else {
                    imp = true;
                    break;
                }
            }
            char[] res = new char[n];
            if (!imp) {
                int C = 0;
                int J = 0;
                for (int i = 0; i < len; ++i) {
                    if (C != 0 && ((finish[i] % 1000) == C || (finish[i] / 1000) == C))
                        C = 0;
                    if (J != 0 && ((finish[i] % 1000) == J || (finish[i] / 1000) == J))
                        J = 0;
                    if (start[i] != 0) {
                        int val = start[i] % 1000;
                        if (C == 0) {
                            C = val;
                            res[val - 1] = 'C';
                        } else if (J == 0) {
                            J = val;
                            res[val - 1] = 'J';
                        } else {
                            imp = true;
                            break;
                        }
                        start[i] -= val;
                        val = start[i] / 1000;
                        if (val > 0) {
                            if (C == 0) {
                                C = val;
                                res[val - 1] = 'C';
                            } else if (J == 0) {
                                J = val;
                                res[val - 1] = 'J';
                            } else {
                                imp = true;
                                break;
                            }

                        }
                    }
                }

            }

            String r = new String(res);
            System.out.println("Case #" + test + ": " + (imp ? "IMPOSSIBLE" : r));
        }
    }
}