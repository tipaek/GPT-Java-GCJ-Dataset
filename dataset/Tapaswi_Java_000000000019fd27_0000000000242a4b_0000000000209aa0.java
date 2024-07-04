import java.util.Scanner;

public class Solution {
    static void solution(int t, Scanner sc){
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = sc.nextInt(), k = sc.nextInt();
            String ans;
            if(n >= k) ans = "IMPOSSIBLE";
            else{
                if(k <= (n * n)){
                    if(k % n == 0) ans = "POSSIBLE";
                    else ans = "IMPOSSIBLE";
                }else{
                    ans = "IMPOSSIBLE";
                }
            }
            System.out.println("Case #"+testCase+": "+ans);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        solution(t,sc);
    }
}