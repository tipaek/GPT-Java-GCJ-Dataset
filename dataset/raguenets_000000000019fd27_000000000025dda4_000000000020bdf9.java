import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t=1; t <= T; t++) {
            int N = scanner.nextInt();
            int[] S = new int[N];
            int[] E = new int[N];
            int[] time = new int[24*60+1];
            int[][] type = new int[24*60+1][2];
            StringBuilder sb = new StringBuilder();
            for (int i=0; i < N; i++) {
                S[i] = scanner.nextInt();
                E[i] = scanner.nextInt();
                for (int j=S[i]; j < E[i];j++) {
                    time[j]++;
                    if (type[j][0]>0) {
                        if (type[j][1] > 0) {
                            // IMPOSSIBLE
                        } else {
                            type[j][1] = i+1;
                        }
                    } else {
                        type[j][0] = i+1;
                    }
                }
            }
            int max = Arrays.stream(time).max().getAsInt();
            Map<Integer,String> map = new HashMap<>();
            if (max >2) {
                System.out.println("Case #"+t+": IMPOSSIBLE");
            } else {
                for (int i=0; i < N; i++) {
                    for (int ti=S[i]; ti < E[i]; ti++) {
                        String current = map.get(type[ti][0]-1);
                        if (current == null) {
                            map.put(type[ti][0]-1,"C");
                            current = "C";
                        }
                        if (time[ti] > 1) {
                            map.putIfAbsent(type[ti][1]-1,current.equals("C")?"J":"C");
                        }
                    }
                }
                for (int i=0; i < N; i++) sb.append(map.get(i));
                System.out.println("Case #"+t+": "+sb.toString());
            }
        }
        
    }
}