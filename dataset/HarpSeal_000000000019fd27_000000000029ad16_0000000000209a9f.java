import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String open = "(";
        String close = ")";
        for (int i = 0; i < t; i++) {
            String f = "";
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                int m = Integer.parseInt(s.substring(j, j + 1));
                if (j != 0 && Integer.parseInt(s.substring(j, j + 1)) != 0
                        && Integer.parseInt(s.substring(j - 1, j)) == Integer.parseInt(s.substring(j, j + 1))) {
                    f = f.substring(0, j + m) + s.substring(j, j + 1) + f.substring(j + m, f.length());
                } else {
                    for (int k = 0; k < m; k++) {
                        f += open;
                    }
                    f += s.substring(j, j + 1);
                    for (int k = 0; k < m; k++) {
                        f += close;
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + f + " ");
        }
    }
}