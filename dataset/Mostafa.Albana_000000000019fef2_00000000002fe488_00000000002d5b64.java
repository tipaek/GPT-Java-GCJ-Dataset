
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {


                int r = in.nextInt();
                int s = in.nextInt();

                boolean solved = false;
                int count = 0;
                int a = r, b =  r==s ? s-1 : s;
                List<String> ops = new ArrayList<>();

                while (a > 0 && b >0) {

                    count ++;

                    ops.add(a+" "+b);
                    a--;
                    b--;
                }

                System.out.println(String.format("Case #%d: %d", i, count));
                ops.forEach(str -> {
                    System.out.println(str);
                });

        }
        in.close();

    }


    static class Card {
        public int r;
        public int s;
    }

}
