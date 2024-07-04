import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
    public static void main(String[] args) {
        String[][] solutions = {
            {},
            {},
            {
                "IMPOSSIBLE\n", 
                "IMPOSSIBLE\n", 
                "POSSIBLE\n1 2\n2 1\n", 
                "IMPOSSIBLE\n", 
                "POSSIBLE\n2 1\n1 2\n"
            },
            {
                "IMPOSSIBLE\n", 
                "IMPOSSIBLE\n", 
                "IMPOSSIBLE\n", 
                "POSSIBLE\n1 3 2\n2 1 3\n3 2 1\n", 
                "IMPOSSIBLE\n", 
                "IMPOSSIBLE\n", 
                "POSSIBLE\n3 2 1\n2 1 3\n1 3 2\n", 
                "IMPOSSIBLE\n", 
                "IMPOSSIBLE\n", 
                "POSSIBLE\n3 2 1\n1 3 2\n2 1 3\n"
            },
            {
                "IMPOSSIBLE\n", 
                "IMPOSSIBLE\n", 
                "IMPOSSIBLE\n", 
                "IMPOSSIBLE\n", 
                "POSSIBLE\n1 4 3 2\n4 1 2 3\n3 2 1 4\n2 3 4 1\n", 
                "IMPOSSIBLE\n", 
                "POSSIBLE\n2 4 3 1\n4 1 2 3\n3 2 1 4\n1 3 4 2\n", 
                "POSSIBLE\n3 4 2 1\n2 1 3 4\n4 2 1 3\n1 3 4 2\n", 
                "POSSIBLE\n4 3 2 1\n2 1 4 3\n3 2 1 4\n1 4 3 2\n", 
                "POSSIBLE\n4 3 2 1\n2 1 3 4\n3 4 1 2\n1 2 4 3\n", 
                "POSSIBLE\n4 3 2 1\n3 1 4 2\n2 4 1 3\n1 2 3 4\n", 
                "POSSIBLE\n4 3 2 1\n3 1 4 2\n1 2 3 4\n2 4 1 3\n", 
                "POSSIBLE\n4 3 2 1\n3 2 1 4\n2 1 4 3\n1 4 3 2\n", 
                "POSSIBLE\n4 3 2 1\n2 4 1 3\n1 2 3 4\n3 1 4 2\n", 
                "POSSIBLE\n4 3 2 1\n3 4 1 2\n2 1 3 4\n1 2 4 3\n", 
                "IMPOSSIBLE\n", 
                "POSSIBLE\n4 3 2 1\n3 4 1 2\n2 1 4 3\n1 2 3 4\n"
            },
            {
                "IMPOSSIBLE\n", 
                "IMPOSSIBLE\n", 
                "IMPOSSIBLE\n", 
                "IMPOSSIBLE\n", 
                "IMPOSSIBLE\n", 
                "POSSIBLE\n1 5 4 3 2\n5 1 3 2 4\n4 2 1 5 3\n3 4 2 1 5\n2 3 5 4 1\n", 
                "IMPOSSIBLE\n", 
                "POSSIBLE\n2 5 4 3 1\n5 1 3 2 4\n4 2 1 5 3\n3 4 2 1 5\n1 3 5 4 2\n", 
                "POSSIBLE\n3 5 4 2 1\n5 1 2 4 3\n4 2 1 3 5\n2 3 5 1 4\n1 4 3 5 2\n", 
                "POSSIBLE\n4 5 3 2 1\n5 1 2 4 3\n3 2 1 5 4\n2 3 4 1 5\n1 4 5 3 2\n", 
                "POSSIBLE\n5 4 3 2 1\n4 1 2 5 3\n3 2 1 4 5\n2 3 5 1 4\n1 5 4 3 2\n", 
                "POSSIBLE\n5 4 3 2 1\n4 1 5 3 2\n3 2 1 5 4\n2 3 4 1 5\n1 5 2 4 3\n", 
                "POSSIBLE\n5 4 3 2 1\n4 2 1 5 3\n3 1 2 4 5\n2 3 5 1 4\n1 5 4 3 2\n", 
                "POSSIBLE\n5 4 3 2 1\n4 2 5 1 3\n2 3 1 4 5\n1 5 2 3 4\n3 1 4 5 2\n", 
                "POSSIBLE\n5 4 3 2 1\n4 3 2 1 5\n2 5 1 4 3\n1 2 5 3 4\n3 1 4 5 2\n", 
                "POSSIBLE\n5 4 3 2 1\n4 3 5 1 2\n3 2 1 5 4\n2 1 4 3 5\n1 5 2 4 3\n", 
                "POSSIBLE\n5 4 3 2 1\n4 5 2 1 3\n3 2 1 5 4\n2 1 4 3 5\n1 3 5 4 2\n", 
                "POSSIBLE\n5 4 3 2 1\n4 3 5 1 2\n1 5 2 4 3\n2 1 4 3 5\n3 2 1 5 4\n", 
                "POSSIBLE\n5 4 3 2 1\n4 3 5 1 2\n3 2 1 5 4\n1 5 2 4 3\n2 1 4 3 5\n", 
                "POSSIBLE\n5 4 3 2 1\n4 3 5 1 2\n3 1 2 5 4\n2 5 1 4 3\n1 2 4 3 5\n", 
                "POSSIBLE\n5 4 3 2 1\n4 5 2 1 3\n3 2 1 5 4\n1 3 5 4 2\n2 1 4 3 5\n", 
                "POSSIBLE\n5 4 3 2 1\n4 5 2 1 3\n2 1 5 3 4\n3 2 1 4 5\n1 3 4 5 2\n", 
                "POSSIBLE\n5 4 3 2 1\n4 5 2 1 3\n3 1 5 4 2\n1 2 4 3 5\n2 3 1 5 4\n", 
                "POSSIBLE\n5 4 3 2 1\n3 5 2 1 4\n2 1 4 5 3\n1 3 5 4 2\n4 2 1 3 5\n", 
                "IMPOSSIBLE\n", 
                "POSSIBLE\n5 4 3 2 1\n4 5 2 1 3\n3 1 5 4 2\n2 3 1 5 4\n1 2 4 3 5\n"
            }
        };

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            System.out.print("Case #" + i + ": " + solutions[N][K]);
        }

        scanner.close();
    }
}