import java.io.IOException;
import java.util.*;

class Solution{
    public static void main(String[] args) throws IOException {
        algooo();
    }

    static void algooo() {
        Scanner s = new Scanner(System.in);
        int T = Integer.valueOf(s.nextLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.valueOf(s.nextLine());
            int[] minutes = new int[1441];
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < N; j++) {
                String line = s.nextLine();
                String[] split = line.split(" ");
                int S = Integer.valueOf(split[0]);
                int E = Integer.valueOf(split[1]);
                if(isPossible(minutes, S, E)) {
                    int index = minutes[S];
                    sb.append(index == 1 ? "C" : "J");
                } else {
                    sb.setLength(0);
                    sb.append("IMPOSSIBLE");
                    break;
                }
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