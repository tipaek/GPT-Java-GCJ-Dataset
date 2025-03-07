import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            StringBuilder ans = new StringBuilder();
            int X = sc.nextInt();
            int Y = sc.nextInt();

            if ((X + Y) % 2 == 0) {
                ans.append("IMPOSSIBLE");
            } else {
                outerLoop:
                for (int i = 1; i < (int) Math.pow(4, 9); i++) {
                    int tmp_x = 0;
                    int tmp_y = 0;
                    String base = Integer.toString(i, 4);
                    char[] path = base.toCharArray();
                    StringBuilder tmp = new StringBuilder();

                    for (int j = path.length - 1; j >= 0; j--) {
                        char d = path[j];
                        int po = path.length - 1 - j;
                        int diff = (int) Math.pow(2, po);

                        switch (d) {
                            case '0':
                                tmp_x += diff;
                                tmp.append('E');
                                break;
                            case '1':
                                tmp_x -= diff;
                                tmp.append('W');
                                break;
                            case '2':
                                tmp_y += diff;
                                tmp.append('N');
                                break;
                            case '3':
                                tmp_y -= diff;
                                tmp.append('S');
                                break;
                        }

                        if (tmp_x == X && tmp_y == Y) {
                            ans = tmp;
                            break outerLoop;
                        }
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + ans);
        }

        sc.close();
    }
}