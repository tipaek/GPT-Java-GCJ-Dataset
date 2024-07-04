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
            boolean flag[] = new boolean[B/10 + 1];
            flag[1] = true;

            for (int i = 1; i <= B / 2; i++) {
                if (i % 10 == 1 && !flag[(int) Math.floor(i / 10) + 1]) {
                    if (idxDiff != 0 && idxSame != 0) {
                        solve(sc, copiedResult, idxDiff);
                        solve(sc, copiedResult, idxSame);

                        if (copiedResult[idxDiff] != result[idxDiff] && copiedResult[idxSame] != result[idxSame]) {
                            for (int k = 1; k <= i - 1; k++) {
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
                            for (int k = 1; k <= i - 1; k++) {
                                result[k] = copiedResult[B - k + 1];
                                result[B - k + 1] = copiedResult[k];
                            }
                        } else if (copiedResult[idxSame] != result[idxSame]) {
                            for (int k = 1; k <= i - 1; k++) {
                                result[k] = copiedResult[B - k + 1];
                                result[B - k + 1] = copiedResult[k];

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
                        if (copiedResult[idxDiff] != result[idxDiff]) {
                            for (int k = 1; k <= i - 1; k++) {
                                result[k] = copiedResult[B - k + 1];
                                result[B - k + 1] = copiedResult[k];
                            }
                        }
                    } else { //All bits same
                        solve(sc, copiedResult, idxSame);
                        if (copiedResult[idxSame] != result[idxSame]) {
                            for (int k = 1; k <= i - 1; k++) {
                                result[k] = copiedResult[idxSame];
                                result[B - k + 1] = copiedResult[idxSame];
                            }
                        }
                    }

                    copiedResult[idxSame] = result[idxSame];
                    copiedResult[idxDiff] = result[idxDiff];

                    flag[(int) Math.floor(i / 10) + 1] = true;
                    i--;

                    continue;
                }

                solve(sc, copiedResult, i);
                solve(sc, copiedResult, B - i + 1);

                if (copiedResult[i] != copiedResult[B - i + 1]) {
                    idxDiff = i;
                } else {
                    idxSame = i;
                }
            }

            String res = sc.next();
            StringBuilder sb = new StringBuilder();
            if (res.equals("Y")) {
                for (int z = 1; z <= B; z++) {
                    sb.append((char) result[z]);
                }
                System.out.println(res);
            } else {
                break;
            }
        }
    }
}

