import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = input.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int r = input.nextInt();
            int s = input.nextInt();
            int ans = (r - 1) * (s - 1);
            System.out.println("Case #" + i + ": " + ans);
            
            int left = r * (s - 1);
            int right = r - 1;
            
            while (ans > 0) {
                for (int j = 0; j < s - 1; j++) {
                    System.out.println(left + " " + right);
                    left--;
                    ans--;
                }
                right--;
            }
        }
    }
}

/*
1 2 3 4 1 2 3 4 * (4, 2) 4 3
1 2 3 1 2 3 4 4 * (3, 2) 3 2
1 2 1 2 3 3 4 4 * (2, 2) 2 1
1 1 2 2 3 3 4 4 * (1, 2)

1 2 1 2 1 2 * (2, 3) 4 1
1 1 2 1 2 2          3 1
1 1 1 2 2 2

1 2 3 4 1 2 3 4 1 2 3 4 * (4, 3) 8 3
1 2 3 1 2 3 4 1 2 3 4 4          7 3
1 2 3 1 2 3 1 2 3 4 4 4 * (3, 3) 6 2
1 2 1 2 3 1 2 3 3 4 4 4          5 2
1 2 1 2 1 2 3 3 3 4 4 4 * (2, 3) 4 1
                                 3 1


1 2 1 2
2 1 1 2
1 1 2 2
*/