import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t1 = sc.nextInt();
        
        for (int z = 1; z <= t1; z++) {
            StringBuilder result = new StringBuilder();
            int n = sc.nextInt();
            int[][] ca = new int[n][2];
            int[][] ja = new int[n][2];
            int cl = 0, jl = 0;
            boolean isPossible = true;
            
            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                boolean cConflict = false, jConflict = false;
                
                if (!isPossible) continue;
                
                for (int h = 0; h < cl; h++) {
                    if ((ca[h][1] > s && ca[h][0] <= s) || (ca[h][1] >= e && ca[h][0] < e) || (s <= ca[h][0] && e >= ca[h][1])) {
                        cConflict = true;
                        break;
                    }
                }
                
                if (cConflict) {
                    for (int h = 0; h < jl; h++) {
                        if ((ja[h][1] > s && ja[h][0] <= s) || (ja[h][1] >= e && ja[h][0] < e) || (s <= ja[h][0] && e >= ja[h][1])) {
                            jConflict = true;
                            break;
                        }
                    }
                }
                
                if (!cConflict) {
                    result.append('C');
                    ca[cl][0] = s;
                    ca[cl][1] = e;
                    cl++;
                } else if (!jConflict) {
                    result.append('J');
                    ja[jl][0] = s;
                    ja[jl][1] = e;
                    jl++;
                } else {
                    isPossible = false;
                }
            }
            
            System.out.println("Case #" + z + ": " + (isPossible ? result.toString() : "IMPOSSIBLE"));
        }
    }
}