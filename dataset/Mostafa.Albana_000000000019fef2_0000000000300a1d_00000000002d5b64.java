

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

                int max = s-r;
                if(r > s) {
                    max = r-s;
                }

                max++;

            //System.out.println(max);
                boolean solved = false;
                int count = 0;
                int a = r, b = r >= s ? r-1 : s;
                List<String> ops = new ArrayList<>();

                while (count < max) {

                    count ++;

                    ops.add(a+" "+b);
                    if(b<= a) a--;
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
