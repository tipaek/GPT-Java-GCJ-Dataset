import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public boolean overlap(int[][] S, LinkedList<Integer>[] overlapWork, int i, int j) {
        int[] work1 = S[i];
        int[] work2 = S[j];
        return !(work1[1] <= work2[0] || work1[0] >= work2[1]);
    }

    public boolean possible(int[][] S, LinkedList<Integer>[] overlapWork, int idx) {
        if (overlapWork[idx].size() >= 3) {
            for (int i = 0; i < overlapWork[idx].size(); i++) {
                for (int j = i; j < overlapWork[idx].size(); j++) {
                    if (overlap(S, overlapWork, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] S = new int[N][2];
            String answer = "";
            char[] ans = new char[N];
            LinkedList<HashSet<Integer>> same = new LinkedList<>();
            LinkedList<HashSet<Integer>> diff = new LinkedList<>();
            boolean impossible = false;
            LinkedList<LinkedList<Integer>> more = new LinkedList<>();
            LinkedList<int[]> three = new LinkedList<>();
            LinkedList<int[]> two = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                S[i][0] = sc.nextInt();
                S[i][1] = sc.nextInt();
            }

            LinkedList<Integer>[] overlapWork = new LinkedList[N];

            for (int i = 0; i < N; i++) {
                int[] currWork = S[i];
                LinkedList<Integer> overlap = new LinkedList<>();
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        int[] cmpWork = S[j];
                        if ((cmpWork[0] >= currWork[0] && cmpWork[0] < currWork[1]) ||
                            (cmpWork[1] > currWork[0] && cmpWork[1] <= currWork[1])) {
                            overlap.add(j);
                        }
                    }
                }
                overlapWork[i] = overlap;
            }

            for (int i = 0; i < N; i++) {
                if (overlapWork[i].size() > 2) {
                    if (!sol.possible(S, overlapWork, i)) {
                        answer = "IMPOSSIBLE";
                        impossible = true;
                        break;
                    } else {
                        LinkedList<Integer> l = new LinkedList<>();
                        l.add(i);
                        l.addAll(overlapWork[i]);
                        more.add(l);
                    }
                } else if (overlapWork[i].size() == 2) {
                    int[] work1 = S[overlapWork[i].get(0)];
                    int[] work2 = S[overlapWork[i].get(1)];
                    if (work1[1] <= work2[0] || work1[0] >= work2[1]) {
                        int[] arr = {i, overlapWork[i].get(0), overlapWork[i].get(1)};
                        three.add(arr);
                    } else {
                        answer = "IMPOSSIBLE";
                        impossible = true;
                        break;
                    }
                } else if (overlapWork[i].size() == 1) {
                    int[] arr = {i, overlapWork[i].get(0)};
                    two.add(arr);
                }
            }

            if (!impossible) {
                for (int[] arr : three) {
                    HashSet<Integer> h1 = new HashSet<>();
                    h1.add(arr[1]);
                    h1.add(arr[2]);
                    HashSet<Integer> h2 = new HashSet<>();
                    h2.add(arr[0]);
                    h2.add(arr[1]);
                    HashSet<Integer> h3 = new HashSet<>();
                    h3.add(arr[0]);
                    h3.add(arr[2]);
                    same.add(h1);
                    diff.add(h2);
                    diff.add(h3);
                }

                for (LinkedList<Integer> l : more) {
                    HashSet<Integer> h1 = new HashSet<>();
                    h1.add(l.get(0));
                    h1.add(l.get(1));
                    same.add(h1);
                    for (int k = 1; k < l.size(); k++) {
                        HashSet<Integer> h = new HashSet<>();
                        h.add(l.get(0));
                        h.add(l.get(k));
                        diff.add(h);
                    }
                }

                for (int[] arr : two) {
                    HashSet<Integer> h1 = new HashSet<>();
                    h1.add(arr[0]);
                    h1.add(arr[1]);
                    diff.add(h1);
                }

                ans[0] = 'C';
                for (int j = 0; j < N; j++) {
                    for (HashSet<Integer> set : same) {
                        if (set.contains(j)) {
                            for (int next : set) {
                                if (next != j) {
                                    if (ans[j] == 0) {
                                        ans[j] = 'S';
                                        ans[next] = 'S';
                                    } else {
                                        ans[next] = ans[j];
                                    }
                                }
                            }
                        }
                    }

                    for (HashSet<Integer> set : diff) {
                        if (set.contains(j)) {
                            for (int next : set) {
                                if (next != j) {
                                    if (ans[j] == 0) {
                                        ans[j] = '0';
                                        ans[next] = '1';
                                    } else if (ans[j] == 'C') {
                                        ans[next] = 'J';
                                    } else if (ans[j] == 'J') {
                                        ans[next] = 'C';
                                    } else if (ans[j] == 'S') {
                                        ans[next] = 'D';
                                    } else if (ans[j] == 'D') {
                                        ans[next] = 'S';
                                    } else if (ans[j] == '0') {
                                        ans[next] = '1';
                                    } else if (ans[j] == '1') {
                                        ans[next] = '0';
                                    }
                                }
                            }
                        }
                    }
                }

                for (char c : ans) {
                    if (c == 0) {
                        answer += 'C';
                    } else if (c == 'C' || c == 'J') {
                        answer += c;
                    } else if (c == 'S') {
                        answer += 'C';
                    } else if (c == 'D') {
                        answer += 'J';
                    } else if (c == '0') {
                        answer += 'C';
                    } else if (c == '1') {
                        answer += 'J';
                    }
                }
            }

            System.out.println("Case #" + test_case + ": " + answer);
        }
        sc.close();
    }
}