import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int a = 1; a <= T; a++){
            int N = sc.nextInt();
            System.out.println("Case #" + a + ": ");
            if (N == 501){
                System.out.println(1 + " " + 1);
                System.out.println(2 + " " + 2);
                System.out.println(3 + " " + 2);

                for (int i = 3; i <= 499; i++){
                    System.out.println(i + " " + i);
                }
            }
            else {
                for (int i = 1; i <= N; i++) {
                    System.out.println(i + " " + i);
                }
            }
        }
    }
}
