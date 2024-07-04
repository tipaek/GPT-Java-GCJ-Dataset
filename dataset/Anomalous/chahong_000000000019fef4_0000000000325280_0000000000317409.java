import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int mx = 0;
            int my = 0;
            int result = 0;

            System.out.print("Case #" + (i + 1) + ": ");
            String root = sc.next();

            if (x == 0 && y == 0) {
                result = 0;
            } else {
                for (int j = 0; j < root.length(); j++) {
                    char direction = root.charAt(j);

                    switch (direction) {
                        case 'S':
                            y -= 1;
                            break;
                        case 'N':
                            y += 1;
                            break;
                        case 'E':
                            x += 1;
                            break;
                        case 'W':
                            x -= 1;
                            break;
                    }

                    result++;
                    int xgap = Math.abs(x - mx);
                    int ygap = Math.abs(y - my);

                    if (xgap > ygap) {
                        if (x > mx) mx++;
                        else if (x < mx) mx--;
                    } else if (xgap < ygap) {
                        if (y > my) my++;
                        else if (y < my) my--;
                    } else {
                        if (x == mx && y == my) {
                            break;
                        } else {
                            if (j == root.length() - 1) {
                                result = -1;
                            } else {
                                if (x > mx) mx++;
                                else if (x < mx) mx--;
                            }
                        }
                    }

                    if (x == mx && y == my) {
                        break;
                    }

                    if (j == root.length() - 1) {
                        result = -1;
                    }
                }
            }

            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }
}