import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int d = 1; d <=t;++d) {
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            int trace = 0;
            for(int i = 0; i<n;++i) {
                for(int j = 0; j<n;++j) {
                    a[i][j] = sc.nextInt();
                    if(i == j)
                        trace += a[i][j];
                }
            }
            int row = 0, col = 0;
            HashMap<Integer, Integer> map_r = new HashMap<>();
            HashMap<Integer, Integer> map_c = new HashMap<>();
            boolean flag_r, flag_c;
            for(int i = 0; i<n;++i) {
                flag_r = false; flag_c = false;
                for(int j = 0; j<n;++j) {
                    if(map_r.containsKey(a[i][j]) && flag_r == false) {
                        ++row;
                        flag_r = true;
                    } else {
                        map_r.put(a[i][j], 1);
                    }
                    if(map_c.containsKey(a[j][i]) && flag_c == false) {
                        ++col; // 1
                        flag_c = true;
                    } else {
                        map_c.put(a[j][i], 1); // 2,1 1,1 
                    }
                }
                map_r.clear();
                map_c.clear();
            }
            System.out.println("Case #"+d+": "+trace+" "+row+" "+col);
            
            
        }
    }
}