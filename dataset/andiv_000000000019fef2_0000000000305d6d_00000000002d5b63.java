import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            if (a == b){

                if (a == 1000000000 - 5) {
                    boolean found = false;
                    for (int x = -5; x <= 5 && !found; x++) {
                        for (int y = -5; y <= 5 && !found; y++) {
                            System.out.println(x + " " + y);
                            String answer = in.nextLine();
                            if ("WRONG".equals(answer)) return;
                            if ("CENTER".equals(answer)) {
                                found = true;
                            }
                            if ("HIT".equals(answer)) {}
                            if ("MISS".equals(answer)) {}
                        }
                    }
                } else if (a == 1000000000 - 50) {

                } else {
                    return;
                }
            }
            else{
                return;
            }
        }
    }
}
