import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][2];
            int[] sing = new int[N];

            for (int j = 0; j < N; j++) {
                arr[j][0] = sc.nextInt();
                arr[j][1] = sc.nextInt();
                sing[j] = arr[j][0];
            }

            Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

            int check = 0;
            for (int j = 0; j + 1 < N; j++) {
                if (arr[j][1] > arr[j + 1][0]) {
                    check++;
                }
            }

            if (check == N - 1) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                StringBuilder s = new StringBuilder();
                s.append("C");
                char curr = s.charAt(0);
                int k;

                for (int j = 0; j < N; j++) {
                    for (k = j + 1; k < N; k++) {
                        if (arr[j][1] > arr[k][0]) {
                            if (curr == 'C') {
                                s.append("J");
                            } else {
                                s.append("C");
                            }
                        } else {
                            s.append(curr);
                        }
                    }
                    j = k - 1;
                    curr = s.charAt(s.length() - 1);
                }

                LinkedList<Character> lc = new LinkedList<>();
                LinkedList<Integer> li = new LinkedList<>();
                for (int j = 0; j < N; j++) {
                    lc.add(s.charAt(j));
                    li.add(arr[j][1]);
                }

                int cc = 0, cj = 0;
                for (char ch : lc) {
                    if (ch == 'C') {
                        cc++;
                    } else {
                        cj++;
                    }
                }

                List<Integer> ty = new LinkedList<>();
                List<Integer> ty1 = new LinkedList<>();
                for (int j = 0; j < lc.size(); j++) {
                    if (lc.get(j) == 'C') {
                        ty1.add(li.get(j));
                    } else if (lc.get(j) == 'J') {
                        ty.add(li.get(j));
                    }
                }

                for (int j = 0; j < ty1.size(); j++) {
                    if (j + 1 < ty1.size() && ty1.get(j) >= ty1.get(j + 1)) {
                        int ind = -1;
                        if (j + 1 < ty1.size()) {
                            int var = ty1.get(j + 1);
                            for (int yu = 0; yu < li.size(); yu++) {
                                if (var == li.get(yu)) {
                                    ind = yu;
                                }
                            }
                            if (ind >= 0) {
                                char op = s.charAt(ind);
                                if (op == 'C') {
                                    s.setCharAt(ind, 'J');
                                }
                            }
                        }
                    }
                }

                for (int j = 0; j < ty.size(); j++) {
                    if (j + 1 < ty.size() && ty.get(j) >= ty.get(j + 1)) {
                        int ind = -1;
                        if (j + 1 < ty.size()) {
                            int var = ty.get(j + 1);
                            for (int yu = 0; yu < li.size(); yu++) {
                                if (var == li.get(yu)) {
                                    ind = yu;
                                }
                            }
                            if (ind >= 0) {
                                char op = s.charAt(ind);
                                if (op == 'J') {
                                    s.setCharAt(ind, 'C');
                                }
                            }
                        }
                    }
                }

                StringBuilder v = new StringBuilder();
                int[] oo = new int[N];
                for (int kk = 0; kk < N; kk++) {
                    oo[kk] = arr[kk][0];
                }

                for (int p = 0; p < N; p++) {
                    int y = Arrays.binarySearch(oo, sing[p]);
                    v.append(s.charAt(y));
                }

                System.out.println("Case #" + (i + 1) + ": " + v);
            }
        }
    }
}