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
            int complements[] = new int[15];
            int swaps[] = new int[15];
            int idxDiff = 0;
            int diffValue = 0;
            int idxSame = 0;
            int sameValue = 0;
            int curr = 1;
            int prevSameValue = 0;
            int prevDiffValue = 0;
            int initDiff = 0;
            int initSame = 0;

            for (int counter = 1; counter <= 150; counter++) {
                if (curr > B / 2) {
                    break;
                }

                if (counter % 10 == 1 && counter > 1) {
                    diffValue = prevDiffValue;
                    sameValue = prevSameValue;

                    int currTemp = (int) Math.floor(curr / 4);

                    if (idxDiff != 0 && idxSame != 0) {
                        solve(sc, result, idxDiff);
                        solve(sc, result, idxSame);
                        counter ++;

                        if (diffValue != result[idxDiff] && sameValue != result[idxSame]) {
                            for (int p = 1; p <= currTemp; p++) {
                                if (complements[p] == 0) {
                                    complements[p]++;
                                } else {
                                    complements[p] = 0;
                                }
                            }
                        } else if (diffValue != result[idxDiff]) {
                            for (int p = 1; p <= currTemp; p++) {
                                if (swaps[p] == 0) {
                                    swaps[p]++;
                                } else {
                                    swaps[p] = 0;
                                }
                            }
                        } else if (sameValue != result[idxSame]) {
                            for (int p = 1; p <= currTemp; p++) {
                                if (swaps[p] == 0) {
                                    swaps[p]++;
                                } else {
                                    swaps[p] = 0;
                                }

                                if (complements[p] == 0) {
                                    complements[p]++;
                                } else {
                                    complements[p] = 0;
                                }
                            }

                        }
                    } else if (idxDiff != 0) { //All bits diff
                        solve(sc, result, idxDiff);
                        solve(sc, result, idxDiff);
                        counter ++;
                        if (diffValue != result[idxDiff]) {
                            for (int p = 1; p <= currTemp; p++) {
                                if (swaps[p] == 0) {
                                    swaps[p]++;
                                } else {
                                    swaps[p] = 0;
                                }
                            }
                        }
                    } else { //All bits same
                        solve(sc, result, idxSame);
                        solve(sc, result, idxSame);
                        counter ++;
                        if (sameValue != result[idxSame]) {
                            for (int p = 1; p <= currTemp; p++) {
                                if (complements[p] == 0) {
                                    complements[p]++;
                                } else {
                                    complements[p] = 0;
                                }
                            }
                        }
                    }

                    prevSameValue = result[idxSame];
                    prevDiffValue = result[idxDiff];

                    result[idxSame] = initSame;
                    result[idxDiff] = initDiff;
                    continue;
                }

                solve(sc, result, curr);
                solve(sc, result, B - curr + 1);

                counter ++;

                if (result[curr] != result[B - curr + 1] && idxDiff == 0) {
                    idxDiff = curr;
                    prevDiffValue = result[curr];
                    initDiff = result[curr];
                } else if (result[curr] == result[B - curr + 1] && idxSame == 0){
                    idxSame = curr;
                    prevSameValue = result[curr];
                    initSame = result[curr];
                }

                curr++;

                if (curr == 5) {
                    solve(sc, result, curr);
                    solve(sc, result, B - curr + 1);
                    counter += 2;
                }
            }

            int results[] = new int[B + 1];
            for (int a = 1; a <= B / 2; a++) {
                int swap = swaps[(int) Math.floor((a - 1) / 4) + 1];
                int complement = complements[(int) Math.floor((a - 1) / 4) + 1];
                if (swap == 1 && complement == 1) {
                    if (result[B - a + 1] == 0) {
                        results[a] = 1;
                    } else {
                        results[a] = 0;
                    }

                    if (result[a] == 0) {
                        results[B - a + 1] = 1;
                    } else {
                        results[B - a + 1] = 0;
                    }
                } else if (swap == 1) {
                    results[a] = result[B - a + 1];
                    results[B - a + 1] = result[a];
                } else if (complement == 1) {
                    if (result[a] == 0) {
                        results[a] = 1;
                    } else {
                        results[a] = 0;
                    }

                    if (result[B - a + 1] == 0) {
                        results[B - a + 1] = 1;
                    } else {
                        results[B - a + 1] = 0;
                    }
                } else {
                    results[a] = result[a];
                    results[B - a + 1] = result[B - a + 1];
                }
            }


            StringBuilder sb = new StringBuilder();
            for (int z = 1; z <= B; z++) {
                sb.append(results[z]);
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



