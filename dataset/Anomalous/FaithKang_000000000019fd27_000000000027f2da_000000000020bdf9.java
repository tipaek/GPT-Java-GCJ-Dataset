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
                int[] curr_work = S[i];
                int worker_num = 1;
                List<Integer> overlap_work = new LinkedList<>();
                
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        int[] cmp_work = S[j];
                        if ((cmp_work[0] >= curr_work[0] && cmp_work[0] < curr_work[1]) || 
                            (cmp_work[1] > curr_work[0] && cmp_work[1] <= curr_work[1])) {
                            worker_num++;
                            overlap_work.add(j);
                        }
                    }
                }
                
                if (worker_num > 3) {
                    answer = "IMPOSSIBLE";
                    impossible = true;
                    break;
                } else if (worker_num == 3) {
                    int[] work1 = S[overlap_work.get(0)];
                    int[] work2 = S[overlap_work.get(1)];
                    if (work1[1] <= work2[0] || work1[0] >= work2[1]) {
                        three.add(new int[]{i, overlap_work.get(0), overlap_work.get(1)});
                    } else {
                        answer = "IMPOSSIBLE";
                        impossible = true;
                        break;
                    }
                } else if (worker_num == 2) {
                    two.add(new int[]{i, overlap_work.get(0)});
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
            }
            
            if (!impossible) {
                for (char c : ans) {
                    if (c == 0) {
                        answer += 'C';
                    } else if (c == 'C' || c == 'J') {
                        answer += c;
                    } else {
                        if (c == 'S') {
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
            }
            System.out.println("Case #" + test_case + ": " + answer);
        }
        sc.close();
    }
}