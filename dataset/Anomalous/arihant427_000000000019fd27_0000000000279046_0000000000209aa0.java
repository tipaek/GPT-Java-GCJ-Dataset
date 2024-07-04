import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int[][] input = new int[t][2];
        
        for (int i = 0; i < t; i++) {
            input[i][0] = scn.nextInt();
            input[i][1] = scn.nextInt();
        }
        
        for (int i = 0; i < t; i++) {
            int n = input[i][0];
            int m = input[i][1];
            if (m < n || n * n < m) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                int[][] finalArr = new int[n][n];
                int num = m / n;
                int h = m - (num * n);
                
                for (int j = 0; j < n; j++) {
                    finalArr[j][j] = num;
                }
                
                if (h <= (n - num)) {
                    finalArr[0][0] += h;
                } else {
                    for (int j = 0; j < n && h > 0; j++) {
                        finalArr[j][j]++;
                        h--;
                    }
                }
                
                Set<Integer> uniqueValues = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    uniqueValues.add(finalArr[j][j]);
                }
                
                if (uniqueValues.size() != 1 && (n - uniqueValues.size() + 1) >= (n % 2 == 0 ? n / 2 : n / 2 + 1)) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                } else {
                    boolean possible = true;
                    for (int j = 0; j < n; j++) {
                        for (int j2 = 0; j2 < n; j2++) {
                            if (j == j2) continue;
                            List<Integer> list = new ArrayList<>();
                            for (int k = 1; k <= n; k++) {
                                list.add(k);
                            }
                            for (int k = 0; k < n; k++) {
                                list.remove(Integer.valueOf(finalArr[j][k]));
                                list.remove(Integer.valueOf(finalArr[k][j2]));
                            }
                            if (list.isEmpty()) {
                                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                                possible = false;
                                break;
                            } else {
                                finalArr[j][j2] = list.get(0);
                            }
                        }
                        if (!possible) break;
                    }
                    
                    if (possible) {
                        System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                        for (int[] row : finalArr) {
                            for (int val : row) {
                                System.out.print(val + " ");
                            }
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
}