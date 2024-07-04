import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        switch (B) {
            case 10:
                handleB10(T);
                break;
            case 20:
                handleB20(T);
                break;
            default:
                handleB100(T);
                break;
        }
    }

    private static void handleB10(int T) throws IOException {
        for (int t = 1; t <= T; ++t) {
            char[] arr = new char[10];
            for (int b = 0; b < 10; ++b) {
                System.out.println(b + 1);
                arr[b] = (char) ('0' + Integer.parseInt(br.readLine()));
            }
            System.out.println(new String(arr));
            if (br.readLine().charAt(0) == 'N') {
                System.exit(0);
            }
        }
    }

    private static void handleB20(int T) {
        // Placeholder for B20 implementation
    }

    private static void handleB100(int T) {
        // Placeholder for B100 implementation
    }
}