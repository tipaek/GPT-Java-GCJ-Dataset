import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] params = reader.readLine().split(" ");
        int testCases = Integer.parseInt(params[0]);
        int a = Integer.parseInt(params[1]);
        int b = Integer.parseInt(params[2]);
        for (int i = 1; i <= testCases; i++) {
//            int[] guess = new int[2];
//            guess[0] = 0;
//            guess[1] = 0;
            boolean center = false;
            for (int x = -5; x <= 5; x++) {
                for (int y = -5; y <= 5; y++) {
                    System.out.println(x + " " + y);
                    String response = reader.readLine();
                    if ("CENTER".equals(response)) {
                        center = true;
                        break;
                    } else if ("HIT".equals(response)) {
                        continue;
                    } else if ("MISS".equals(response)) {
                        continue;
                    } else {
                        System.exit(0);
                    }
                }
                if (center) {
                    break;
                }
            }
        }
    }
}