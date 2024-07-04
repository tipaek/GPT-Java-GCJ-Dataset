import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder answer = new StringBuilder();
            List<int[]> C_schedule = new ArrayList<>();
            List<int[]> J_schedule = new ArrayList<>();
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
                        if ((C_time[1] > S[i][0] && C_time[0] <= S[i][0]) || 
                            (C_time[0] < S[i][1] && S[i][0] <= C_time[0])) {
                            C_available = false;
                            break;
                        }
                    }
                    
                    for (int[] J_time : J_schedule) {
                        if ((J_time[1] > S[i][0] && J_time[0] <= S[i][0]) || 
                            (J_time[0] < S[i][1] && S[i][0] <= J_time[0])) {
                            J_available = false;
                            break;
                        }
                    }
                    
                    if (C_available && J_available) {
                        int min_diff = Integer.MAX_VALUE;
                        int latest_work = 0;
                        for (int k = 0; k < i; k++) {
                            if (S[k][1] <= S[i][0]) {
                                int diff = S[i][0] - S[k][1];
                                if (min_diff > diff) {
                                    min_diff = diff;
                                    latest_work = k;
                                }
                            }
                        }
                        
                        if (answer.length() == 0) {
                            answer.append("C");
                            C_schedule.add(new int[]{S[i][0], S[i][1]});
                        } else {
                            if (answer.charAt(latest_work) == 'C') {
                                answer.append("J");
                                J_schedule.add(new int[]{S[i][0], S[i][1]});
                            } else {
                                answer.append("C");
                                C_schedule.add(new int[]{S[i][0], S[i][1]});
                            }
                        }
                    } else if (C_available || J_available) {
                        if (C_available) {
                            answer.append("C");
                            C_schedule.add(new int[]{S[i][0], S[i][1]});
                        } else {
                            answer.append("J");
                            J_schedule.add(new int[]{S[i][0], S[i][1]});
                        }
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