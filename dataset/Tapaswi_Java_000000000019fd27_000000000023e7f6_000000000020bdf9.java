import java.util.Scanner;

public class Solution {
    static void solution(Scanner scanner, int t){
        for (int testCases = 1; testCases <= t; testCases++) {
            int n = scanner.nextInt();
            int arr[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            
            String ans = "J";
            int overlap = 0;
            for (int row = 1; row < n; row++) {
                if(arr[row][0] >= arr[row-1][1]){
                    ans += ans.charAt(ans.length()-1);
                }else{
                    overlap++;
                    if(ans.charAt(ans.length()-1) == 'J') ans+="C";
                    else ans+="J";                    
                }
            }
            if(overlap+1 == n) ans = "IMPOSSIBLE";
            System.out.println("Case #"+testCases+": "+ans);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        solution(sc, t);
    }
}