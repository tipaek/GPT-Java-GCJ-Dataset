import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());

        for (int caso = 0; caso < T; caso++) {
            String S = in.nextLine();
            String S2 = "";
            String status = "down";
            int count = Integer.parseInt(Character.toString(S.charAt(0)));
            for (int i = 0; i < count; i++) {
                S2 = S2 + "(";
            }
            S2 = S2 + count;
            int r = count;
            for (int i = 1; i < S.length(); i++) {
                int num = Integer.parseInt(Character.toString(S.charAt(i)));

                if (num >= count && status.equals("down")) {
                    status = "down";
                    r = num-count;
                    if (num != count) {
                        for (int j = 0; j < r; j++) {
                            S2 = S2 + "(";
                        }
                    }
                    r=num;
                    S2 = S2 + num;
                    count = num;
                } else if (num < count) {
                    status = "up";
                    count = num;
                    r = r - num;
                    for (int j = 0; j < r; j++) {
                        S2 = S2 + ")";
                    }
                    S2 = S2 + num;
                    r = num;

                } else if (num > count && status.equals("up")) {
                    for (int j = 0; j < r; j++) {
                        S2 = S2 + ")";
                    }
                    status = "down";
                    r = num;
                    for (int j = 0; j < r; j++) {
                        S2 = S2 + "(";
                    }
                    S2 = S2 + num;
                    count=num;
                }
            }
            for (int i=0;i<count;i++) {
                S2 = S2 + ")";
            }

            int t = caso + 1;
            System.out.println("Case #" + t + ": " + S2);
        }

    }
}
