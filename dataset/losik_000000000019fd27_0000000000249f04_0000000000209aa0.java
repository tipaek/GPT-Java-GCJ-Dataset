
import java.util.*;
import java.io.*;

public class Solution {

    private static final int[][] data = new int[100][100];
    static int N;
    static int K;
    private static Set<Integer> uniq = new HashSet<>(200);

    public static void main(String[] args) {
        main(System.in);
    }

    public static void main(InputStream is) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int t = in.nextInt();
        for (int run = 1; run <= t; ++run) {
            N = in.nextInt();
            K = in.nextInt();
            int sum = N*(N+1)/2;
            boolean done = false;
            for(int i=1;i<=N;i++) {
                if (K % i == 0 && K / i == N) {
                    System.out.println("Case #" + run + ": POSSIBLE");
                    int offset=i;
                    //System.err.println("Offset: "+i);
                    for (int row = 0; row < N; row++) {
                        List<String> vals = new ArrayList<>();
                        for (int col = 0; col < N; col++) {
                            int val = N - col + row + (offset - 1);
                            vals.add("" + (1 + (val % N)));
                        }
                        System.out.println(String.join(" ", vals));
                    }
                    done = true;
                    break;
                }
            }
            if (done) {
                continue;
            }
//            if (sum == K) {
//                System.out.println("Case #" + run + ": POSSIBLE");
//                for (int row = 0; row < N; row++) {
//                    List<String> vals = new ArrayList<>();
//                    for (int col = 0; col < N; col++) {
//                        vals.add("" + (1 + ((col + row) % N)));
//                    }
//                    System.out.println(String.join(" ", vals));
//                }
//                continue;
//            }
            System.out.println("Case #" + run + ": IMPOSSIBLE");
        }
    }

}
