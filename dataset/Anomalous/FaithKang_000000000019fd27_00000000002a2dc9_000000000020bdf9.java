import java.util.*;

public class Solution {

    public boolean overlap(int[][] S, LinkedList<Integer>[] overlapWork, int i, int j) {
        int[] work1 = S[i];
        int[] work2 = S[j];
        return !(work1[1] <= work2[0] || work1[0] >= work2[1]);
    }

    public boolean possible(int[][] S, LinkedList<Integer>[] overlapWork, int idx) {
        if (overlapWork[idx].size() >= 3) {
            for (int i = 0; i < overlapWork[idx].size(); i++) {
                for (int j = i + 1; j < overlapWork[idx].size(); j++) {
                    if (overlap(S, overlapWork, overlapWork[idx].get(i), overlapWork[idx].get(j))) {
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
                LinkedList<Integer> overlap = new LinkedList<>();
                for (int j = 0; j < N; j++) {
                    if (j != i && overlap(S, overlapWork, i, j)) {
                        overlap.add(j);
                    }
                }
                overlapWork[i] = overlap;
            }

            for (int i = 0; i < N; i++) {
                if (overlapWork[i].size() > 2) {
                    if (!sol.possible(S, overlapWork, i)) {
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
                        three.add(new int[]{i, overlapWork[i].get(0), overlapWork[i].get(1)});
                    } else {
                        impossible = true;
                        break;
                    }
                } else if (overlapWork[i].size() == 1) {
                    two.add(new int[]{i, overlapWork[i].get(0)});
                }
            }

            if (!impossible) {
                for (int[] arr : three) {
                    HashSet<Integer> h1 = new HashSet<>(Arrays.asList(arr[1], arr[2]));
                    HashSet<Integer> h2 = new HashSet<>(Arrays.asList(arr[0], arr[1]));
                    HashSet<Integer> h3 = new HashSet<>(Arrays.asList(arr[0], arr[2]));
                    same.add(h1);
                    diff.add(h2);
                    diff.add(h3);
                }
                for (LinkedList<Integer> l : more) {
                    HashSet<Integer> h1 = new HashSet<>(l.subList(0, 2));
                    same.add(h1);
                    for (int k = 1; k < l.size(); k++) {
                        HashSet<Integer> h = new HashSet<>(Arrays.asList(l.get(0), l.get(k)));
                        diff.add(h);
                    }
                }
                for (int[] arr : two) {
                    HashSet<Integer> h1 = new HashSet<>(Arrays.asList(arr[0], arr[1]));
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
            }

            StringBuilder answer = new StringBuilder();
            if (!impossible) {
                for (char c : ans) {
                    if (c == 0) {
                        answer.append('C');
                    } else if (c == 'C' || c == 'J') {
                        answer.append(c);
                    } else {
                        if (c == 'S' || c == '0') {
                            answer.append('C');
                        } else {
                            answer.append('J');
                        }
                    }
                }
            } else {
                answer.append("IMPOSSIBLE");
            }
            System.out.println("Case #" + test_case + ": " + answer);
        }
        sc.close();
    }
}