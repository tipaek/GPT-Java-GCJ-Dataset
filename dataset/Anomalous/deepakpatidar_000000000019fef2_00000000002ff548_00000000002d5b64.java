import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int a0 = 0; a0 < t; a0++) {
            int r = sc.nextInt();
            int s = sc.nextInt();
            ArrayList<Integer> moves = new ArrayList<>();
            int a = r * (s - 1);
            int b = r - 1;
            int count = 0;

            while (b > 0) {
                for (int i = 0; i < (s - 1); i++) {
                    moves.add(a);
                    moves.add(b);
                    count++;
                    a--;
                }
                b--;
            }

            System.out.println("Case #" + (a0 + 1) + ": " + count);
            for (int i = 0; i < count * 2; i += 2) {
                System.out.println(moves.get(i) + " " + moves.get(i + 1));
            }
        }

        sc.close();
    }
}