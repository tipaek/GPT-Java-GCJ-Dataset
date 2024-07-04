import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder answer = new StringBuilder();
            ArrayList<int[]> C_schedule = new ArrayList<>();
            ArrayList<int[]> J_schedule = new ArrayList<>();
            boolean impossible = false;
            int N = sc.nextInt();
            int[][] S = new int[N][2];
            
            for (int i = 0; i < N; i++) {
                S[i][0] = sc.nextInt();
                S[i][1] = sc.nextInt();
            }
            
            for (int i = 0; i < N; i++) {
                boolean C_available = true;
                boolean J_available = true;
                
                if (!impossible) {
                    for (int[] C_time : C_schedule) {
                        if ((C_time[1] > S[i][0] && C_time[0] <= S[i][0]) || (C_time[0] < S[i][1] && S[i][0] <= C_time[0])) {
                            C_available = false;
                            break;
                        }
                    }
                    
                    for (int[] J_time : J_schedule) {
                        if ((J_time[1] > S[i][0] && J_time[0] <= S[i][0]) || (J_time[0] < S[i][1] && S[i][0] <= J_time[0])) {
                            J_available = false;
                            break;
                        }
                    }
                    
                    if (C_available && J_available) {
                        answer.append("C");
                        C_schedule.add(new int[]{S[i][0], S[i][1]});
                    } else if (C_available) {
                        answer.append("C");
                        C_schedule.add(new int[]{S[i][0], S[i][1]});
                    } else if (J_available) {
                        answer.append("J");
                        J_schedule.add(new int[]{S[i][0], S[i][1]});
                    } else {
                        answer = new StringBuilder("IMPOSSIBLE");
                        impossible = true;
                    }
                }
            }
            System.out.println("Case #" + test_case + ": " + answer);
        }
        sc.close();
    }
}