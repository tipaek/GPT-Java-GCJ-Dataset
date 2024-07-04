import java.util.Scanner;

public class Solution {

    static void solution(int t, Scanner sc) {
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = sc.nextInt(), k = sc.nextInt();
            String ans;
            if (n >= k) {
                ans = "IMPOSSIBLE";
            } else {
                if (k <= (n * n)) {
                    if (k % n == 0) {
                        ans = "POSSIBLE";
                    } else {
                        ans = "IMPOSSIBLE";
                    }
                } else {
                    ans = "IMPOSSIBLE";
                }
            }
            System.out.println("Case #" + testCase + ": " + ans);
            if (ans == "POSSIBLE") {
                printLatinSquare(n, k/n);
            }
        }
    }
    
    static int[][] printLatinSquare(int n, int t) {
        int k = n + 1;
        for (int i = 0; i < n; i++) {
            int temp = k;
            String str = "";
            while (temp <= n) {
                if(temp == 1)
                    str += t + " ";
                else if(temp == t)
                    str += 1 + " ";
                else
                    str += temp + " ";
                temp++;
            }

            for (int j = 1; j < k; j++) {
                if(j == 1)
                    str += t + " ";
                else if(j == t)
                    str += 1 + " ";
                else
                    str += j + " ";
            }

            k--;
            System.out.println(str);
        }
        
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        solution(t, sc);
    }
}