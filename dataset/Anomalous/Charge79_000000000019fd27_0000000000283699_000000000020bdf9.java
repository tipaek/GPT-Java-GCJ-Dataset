import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(reader.readLine().trim());
        for (int i = 1; i <= t; i++) {
            int N = Integer.parseInt(reader.readLine());
            int[] C = new int[1440];
            int[] J = new int[1440];
            char[] output = new char[N];
            boolean possible = true;
            
            for (int j = 0; j < N; j++) {
                String[] times = reader.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                boolean canAssignToC = true;
                boolean canAssignToJ = true;
                
                for (int k = start; k < end; k++) {
                    if (C[k] == 1) {
                        canAssignToC = false;
                    }
                    if (J[k] == 1) {
                        canAssignToJ = false;
                    }
                }
                
                if (canAssignToC) {
                    for (int k = start; k < end; k++) {
                        C[k] = 1;
                    }
                    output[j] = 'C';
                } else if (canAssignToJ) {
                    for (int k = start; k < end; k++) {
                        J[k] = 1;
                    }
                    output[j] = 'J';
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.print("Case #" + i + ": ");
                System.out.println(new String(output));
            }
        }
    }
}