import java.util.*;
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int c = 1; c <= t; c++){
            int N = sc.nextInt();
            int K = sc.nextInt();
            String res = "";
            if (N <= 5){
                res = subtask1(N, K);
            }
            else{
                res =  subtask2(N, K);
            }
            System.out.println("Case #" + c + ": " + res);
        }
    }

    private static String subtask2(int n, int k) {
        return "";
    }

    private static String subtask1(int n, int k) {
        if (n == 2){
            return (k % 2 == 0) ? "POSSIBLE" : "IMPOSSIBLE";
        }
        else if (n == 3){
            if (k % 3 == 0){
                return "POSSIBLE";
            }
            else{
                return "IMPOSSIBLE";
            }
        }
        else if (n == 4){
            if (k != 5 && k != 15){
                return "POSSIBLE";
            }
            else{
                return "IMPOSSIBLE";
            }
        }
        else{
            if (k >= 6 && k <= 8){
                return "IMPOSSIBLE";    
            }
            else if (k >= 23 && k <= 24){
                return "IMPOSSIBLE";
            }
            else{
                return "POSSIBLE";
            }
        }
    }

}