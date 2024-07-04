import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); 
        
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            char[] resultArr = new char[N];
            int[] start = new int[N];
            int[] end = new int[N];
            
            for (int i = 0; i < N; i++) {
                start[i] = in.nextInt();
                end[i] = in.nextInt();
            }
            
            int count = 0;
            int currentC = -1;
            int currentJ = -1;
            String result = "";
            
            outerLoop:
            for (int i = 0; i <= 1440; i++) {
                for (int j = 0; j < N; j++) {
                    if (end[j] == i) {
                        if (currentC == j) {
                            currentC = -1;
                            count--;
                        } else if (currentJ == j) {
                            currentJ = -1;
                            count--;
                        }
                    }
                }
                
                for (int j = 0; j < N; j++) {
                    if (start[j] == i) {
                        if (count < 2) {
                            if (currentJ == -1) {
                                currentJ = j;
                                count++;
                                resultArr[j] = 'J';
                            } else if (currentC == -1) {
                                currentC = j;
                                count++;
                                resultArr[j] = 'C';
                            }
                        } else {
                            result = "IMPOSSIBLE";
                            break outerLoop;
                        }
                    }
                }
            }
            
            if (!result.equals("IMPOSSIBLE")) {
                result = new String(resultArr);
            }
            
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}