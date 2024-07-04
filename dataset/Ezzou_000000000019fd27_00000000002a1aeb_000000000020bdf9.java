import java.io.IOException;
import java.util.*;

class Solution{
    public static void main(String[] args) throws IOException {
        algooo();
    }

    static void algooo() {
        Scanner s = new Scanner("4\n" +
                "3\n" +
                "360 480\n" +
                "420 540\n" +
                "600 660\n" +
                "3\n" +
                "0 1440\n" +
                "1 3\n" +
                "2 4\n" +
                "5\n" +
                "99 150\n" +
                "1 100\n" +
                "100 301\n" +
                "2 5\n" +
                "150 250\n" +
                "2\n" +
                "0 720\n" +
                "720 1440");
        int T = Integer.valueOf(s.nextLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.valueOf(s.nextLine().trim());
            int[] minutes = new int[1441];
            StringBuilder sb = new StringBuilder();
            boolean impo = false;

            for (int j = 0; j < N; j++) {
                String line = s.nextLine();
                String[] split = line.split(" ");
                int S = Integer.valueOf(split[0]);
                int E = Integer.valueOf(split[1]);
                if(!impo && isPossible(minutes, S, E)) {
                    int index = minutes[S];
                    sb.append(index == 1 ? "C" : "J");
                } else {
                    impo = true;
                }
            }

            if(impo) {
                sb.setLength(0);
                sb.append("IMPOSSIBLE");
            }

            System.out.print(String.format("Case #%d: %s\n", i, sb.toString()));
        }
    }

    static boolean isPossible(int[] arr, int start, int end) {
        for (int i = Math.max(0, start); i <= Math.min(arr.length, end) ; i++) {
            if(arr[i] > 1 && i != start && i != end) {
                return false;
            }
            arr[i]++;
        }
        return true;
    }    
}