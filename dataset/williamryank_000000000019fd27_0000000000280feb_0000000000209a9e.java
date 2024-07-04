import java.util.*;
import java.lang.Math;

public class Solution {
    public static void solve(Scanner sc, int[] result, int p) {
        System.out.println(p);

        int s = sc.nextInt();

        result[p] = s;
    }

    public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int B = sc.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int result[] = new int[B + 1];
            int copiedResult[] = result.clone();

            int idxDiff = 0;
            int idxSame = 0;
            int curr = 1;

            for (int counter = 1; counter <= 150; counter++) {
                if (curr > B / 2) {
                    break;
                }

                if (counter % 10 == 1 && counter > 1) {
                    if (idxDiff != 0 && idxSame != 0) {
                        solve(sc, copiedResult, idxDiff);
                        solve(sc, copiedResult, idxSame);
                        counter ++;

                        if (copiedResult[idxDiff] != result[idxDiff] && copiedResult[idxSame] != result[idxSame]) {
                            for (int k = 1; k <= curr - 1; k++) {

                                if (result[k] == 0) {
                                    result[k] = 1;
                                } else {
                                    result[k] = 0;
                                }

                                if (result[B - k + 1] == 0) {
                                    result[B - k + 1] = 1;
                                } else {
                                    result[B - k + 1] = 0;
                                }

                            }
                        } else if (copiedResult[idxDiff] != result[idxDiff]) {
                            for (int k = 1; k <= curr - 1; k++) {
                                int temp = result[k];
                                result[k] = result[B - k + 1];
                                result[B - k + 1] = temp;
                            }
                        } else if (copiedResult[idxSame] != result[idxSame]) {
                            for (int k = 1; k <= curr - 1; k++) {
                                int temp = result[k];
                                result[k] = result[B - k + 1];
                                result[B - k + 1] = temp;

                                if (result[k] == 0) {
                                    result[k] = 1;
                                } else {
                                    result[k] = 0;
                                }

                                if (result[B - k + 1] == 0) {
                                    result[B - k + 1] = 1;
                                } else {
                                    result[B - k + 1] = 0;
                                }
                            }
                        }
                    } else if (idxDiff != 0) { //All bits diff
                        solve(sc, copiedResult, idxDiff);
                        solve(sc, copiedResult, idxDiff);
                        counter ++;
                        if (copiedResult[idxDiff] != result[idxDiff]) {
                            for (int k = 1; k <= curr - 1; k++) {
                                int temp = result[k];
                                result[k] = result[B - k + 1];
                                result[B - k + 1] = temp;
                            }
                        }
                    } else { //All bits same
                        solve(sc, copiedResult, idxSame);
                        solve(sc, copiedResult, idxSame);
                        counter ++;
                        if (copiedResult[idxSame] != result[idxSame]) {
                            for (int k = 1; k <= curr - 1; k++) {
                                result[k] = copiedResult[idxSame];
                                result[B - k + 1] = copiedResult[idxSame];
                            }
                        }
                    }
                    continue;
                }

                solve(sc, copiedResult, curr);
                solve(sc, copiedResult, B - curr + 1);
                result[curr] = copiedResult[curr];
                result[B - curr + 1] = copiedResult[B - curr + 1];
                counter ++;

                if (copiedResult[curr] != copiedResult[B - curr + 1]) {
                    idxDiff = curr;
                } else {
                    idxSame = curr;
                }

                curr += 1;
            }

            StringBuilder sb = new StringBuilder();
            for (int a = 1; a <= B; a++) {
                sb.append(result[a]);
            }

            System.out.println(sb.toString());

            String res = sc.next();
            if (res.equals("Y")) {
                continue;
            } else {
                break;
            }
        }
    }
}

