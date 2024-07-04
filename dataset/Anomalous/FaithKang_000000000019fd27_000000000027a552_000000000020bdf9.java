import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] S = new int[N][2];
            String answer = "";
            char[] ans = new char[N];
            List<Set<Integer>> same = new LinkedList<>();
            List<Set<Integer>> diff = new LinkedList<>();
            boolean impossible = false;
            List<int[]> three = new LinkedList<>();
            List<int[]> two = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                S[i][0] = sc.nextInt();
                S[i][1] = sc.nextInt();
            }

            for (int i = 0; i < N; i++) {
                int worker_num = 1;
                List<Integer> overlap_work = new LinkedList<>();
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        if ((S[j][0] >= S[i][0] && S[j][0] < S[i][1]) || (S[j][1] > S[i][0] && S[j][1] <= S[i][1])) {
                            worker_num++;
                            overlap_work.add(j);
                        }
                    }
                }

                if (worker_num > 3) {
                    answer = "IMPOSSIBLE";
                    impossible = true;
                } else if (worker_num == 3) {
                    int[] work1 = S[overlap_work.get(0)];
                    int[] work2 = S[overlap_work.get(1)];
                    if (work1[1] <= work2[0] || work1[0] >= work2[1]) {
                        three.add(new int[]{i, overlap_work.get(0), overlap_work.get(1)});
                    } else {
                        answer = "IMPOSSIBLE";
                        impossible = true;
                    }
                } else if (worker_num == 2) {
                    two.add(new int[]{i, overlap_work.get(0)});
                }

                if (!three.isEmpty()) {
                    for (int[] arr : three) {
                        same.add(new HashSet<>(Arrays.asList(arr[1], arr[2])));
                        diff.add(new HashSet<>(Arrays.asList(arr[0], arr[1])));
                        diff.add(new HashSet<>(Arrays.asList(arr[0], arr[2])));
                    }
                }

                if (!two.isEmpty()) {
                    for (int[] arr : two) {
                        diff.add(new HashSet<>(Arrays.asList(arr[0], arr[1])));
                    }
                }

                if (!impossible) {
                    ans[0] = 'C';
                    for (int j = 0; j < N; j++) {
                        for (Set<Integer> set : same) {
                            if (set.contains(j)) {
                                for (int next : set) {
                                    if (next != j) {
                                        ans[next] = ans[j] == 'C' || ans[j] == 'J' ? ans[j] : ans[next];
                                    }
                                }
                            }
                        }

                        for (Set<Integer> set : diff) {
                            if (set.contains(j)) {
                                for (int next : set) {
                                    if (next != j) {
                                        ans[next] = ans[j] == 'C' ? 'J' : ans[j] == 'J' ? 'C' : ans[next];
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (!impossible) {
                for (char c : ans) {
                    answer += c == 0 ? 'C' : c;
                }
            }

            System.out.println("Case #" + test_case + ": " + answer);
        }
        sc.close();
    }
}