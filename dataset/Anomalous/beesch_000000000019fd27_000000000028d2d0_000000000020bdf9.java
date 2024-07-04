import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();
            
            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();
                boolean isImpossible = false;
                int[][] schedule = new int[1441][2];
                
                for (int j = 1; j <= n; ++j) {
                    int start = in.nextInt();
                    int end = in.nextInt();
                    
                    for (int k = start; k < end; k++) {
                        if (schedule[k][0] == 0) {
                            schedule[k][0] = j;
                        } else if (schedule[k][1] == 0) {
                            schedule[k][1] = j;
                        } else {
                            isImpossible = true;
                            break;
                        }
                    }
                    
                    if (isImpossible) break;
                }
                
                if (isImpossible) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    char[] result = new char[n];
                    int temp;
                    
                    for (int x = 1; x < 1441; x++) {
                        if (schedule[x - 1][1] == schedule[x][0]) {
                            temp = schedule[x][0];
                            schedule[x][0] = schedule[x][1];
                            schedule[x][1] = temp;
                        } else if (schedule[x - 1][0] == schedule[x][1]) {
                            temp = schedule[x][1];
                            schedule[x][1] = schedule[x][0];
                            schedule[x][0] = temp;
                        }
                        
                        if (schedule[x - 1][0] != schedule[x][0] && schedule[x - 1][0] != 0) {
                            result[schedule[x - 1][0] - 1] = 'C';
                        }
                        if (schedule[x - 1][1] != schedule[x][1] && schedule[x - 1][1] != 0) {
                            result[schedule[x - 1][1] - 1] = 'J';
                        }
                    }
                    
                    System.out.println("Case #" + i + ": " + new String(result));
                }
            }
        }
    }
}