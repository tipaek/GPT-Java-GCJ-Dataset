import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static final int MIN_COORD = -2000000000;
    private static final int MAX_COORD = 2000000000;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= T; i++) {
                int x = MIN_COORD + A;
                int y = MIN_COORD + A;

                while (true) {
                    bw.write(String.format("%d %d\n", x, y));
                    bw.flush();
                    String response = br.readLine();

                    if ("HIT".equals(response) || "CENTER".equals(response) || "WRONG".equals(response)) {
                        if ("CENTER".equals(response) || "WRONG".equals(response)) break;
                        int xL = binarySearch(br, bw, MIN_COORD, x, y, true, true);
                        int xR = binarySearch(br, bw, x, MAX_COORD, y, true, false);
                        int yL = binarySearch(br, bw, MIN_COORD, y, x, false, true);
                        int yU = binarySearch(br, bw, y, MAX_COORD, x, false, false);

                        bw.write(String.format("%d %d\n", (xL + xR) / 2, (yL + yU) / 2));
                        bw.flush();
                        response = br.readLine();
                        if ("CENTER".equals(response) || "WRONG".equals(response)) break;
                    } else {
                        x += A;
                        if (x > MAX_COORD) {
                            x = MIN_COORD + A;
                            y += A;
                        }
                        if (y > MAX_COORD) break;
                    }
                }
            }
        }
    }

    private static int binarySearch(BufferedReader br, BufferedWriter bw, int low, int high, int fixed, boolean isXFixed, boolean searchLower) throws IOException {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isXFixed) {
                bw.write(String.format("%d %d\n", mid, fixed));
            } else {
                bw.write(String.format("%d %d\n", fixed, mid));
            }
            bw.flush();
            String response = br.readLine();
            if ("CENTER".equals(response) || "WRONG".equals(response)) break;
            if ("HIT".equals(response)) {
                if (searchLower) high = mid - 1;
                else low = mid + 1;
            } else {
                if (searchLower) low = mid + 1;
                else high = mid - 1;
            }
        }
        return searchLower ? low : high;
    }
}