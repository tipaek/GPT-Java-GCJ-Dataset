import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test = 1; test <= T; test++) {
            int N = sc.nextInt();
            sc.nextLine();
            String max = sc.nextLine().substring(1);
            boolean isPossible = true;
            for (int i = 1; i < N; i++) {
                String pattern = sc.nextLine();
                String subString = pattern.substring(1);
                if (subString.length() > max.length()) {
                    if (subString.indexOf(max) != -1) {
                        max = subString;
                    } else {
                        isPossible = false;
                    }      
                } else {
                    if (max.indexOf(subString) == -1) {
                        isPossible = false;
                    }
                }
            }
            if (!isPossible) {
                max = "*";
            }
            System.out.printf("Case #%d: %s\n", test, max);
        }
        sc.close();
    }
    
}