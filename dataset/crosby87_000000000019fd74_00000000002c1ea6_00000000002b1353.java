import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int a = 1; a <= T; a++){
            int N = sc.nextInt();
            System.out.println("Case #" + a + ": ");
            for (int i = 1; i <= N; i++){
                System.out.println(i + " " + i);
            }
        }
    }
}
