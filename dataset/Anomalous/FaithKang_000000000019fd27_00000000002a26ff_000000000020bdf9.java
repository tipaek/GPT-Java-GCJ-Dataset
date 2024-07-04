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

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            int[][] S = new int[N][2];
            String answer = "";
            char[] ans = new char[N];
            List<Set<Integer>> same = new ArrayList<>();
            List<Set<Integer>> diff = new ArrayList<>();
            boolean impossible = false;
            List<List<Integer>> more = new ArrayList<>();
            List<int[]> three = new ArrayList<>();
            List<int[]> two = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                S[i][0] = sc.nextInt();
                S[i][1] = sc.nextInt();
            }

            LinkedList<Integer>[] overlapWork = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                overlapWork[i] = new LinkedList<>();
                for (int j = 0; j < N; j++) {
                    if (j != i && overlap(S, overlapWork, i, j)) {
                        overlapWork[i].add(j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                if (overlapWork[i].size() > 2) {
                    if (!sol.possible(S, overlapWork, i)) {
                        answer = "IMPOSSIBLE";
                        impossible = true;
                        break;
                    } else {
                        List<Integer> l = new ArrayList<>();
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
                        answer = "IMPOSSIBLE";
                        impossible = true;
                        break;
                    }
                } else if (overlapWork[i].size() == 1) {
                    two.add(new int[]{i, overlapWork[i].get(0)});
                }
            }

            if (!three.isEmpty()) {
                for (int[] arr : three) {
                    Set<Integer> h1 = new HashSet<>(Arrays.asList(arr[1], arr[2]));
                    Set<Integer> h2 = new HashSet<>(Arrays.asList(arr[0], arr[1]));
                    Set<Integer> h3 = new HashSet<>(Arrays.asList(arr[0], arr[2]));
                    same.add(h1);
                    diff.add(h2);
                    diff.add(h3);
                }
            }

            if (!more.isEmpty()) {
                for (List<Integer> l : more) {
                    Set<Integer> h1 = new HashSet<>(Arrays.asList(l.get(0), l.get(1)));
                    same.add(h1);
                    for (int k = 1; k < l.size(); k++) {
                        Set<Integer> h = new HashSet<>(Arrays.asList(l.get(0), l.get(k)));
                        diff.add(h);
                    }
                }
            }

            if (!two.isEmpty()) {
                for (int[] arr : two) {
                    Set<Integer> h1 = new HashSet<>(Arrays.asList(arr[0], arr[1]));
                    diff.add(h1);
                }
            }

            if (!impossible) {
                ans[0] = 'C';
                for (int j = 0; j < N; j++) {
                    for (Set<Integer> set : same) {
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

                    for (Set<Integer> set : diff) {
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

            if (!impossible) {
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
            System.out.println("Case #" + testCase + ": " + answer);
        }
        sc.close();
    }
}