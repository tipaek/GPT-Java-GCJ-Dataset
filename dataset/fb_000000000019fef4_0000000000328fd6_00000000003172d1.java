
import java.util.*;

public class Task33 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        for(int i = 0; i < T; i++) {
            solve(i+1, s);
        }

    }

    private static void solve(int cid, Scanner in) {

        int N = in.nextInt();
        int D = in.nextInt();

        List<Long> slices = new ArrayList<Long>(N);

        for(int i = 0; i < N; i++) {
            long A = in.nextLong();
            slices.add(A);
        }

        if(D == 2) {
            for(int i = 0; i < N; i++) {
                long a = slices.get(i);
                for(int j = i+1; j < N; j++) {
                    long b = slices.get(j);
                    if(a == b) {
                        System.out.println("Case #" + cid + ": 0");
                        return;
                    }
                }
            }
            System.out.println("Case #" + cid + ": 1");
            return;
        } else {
            int best = 2;
            for(int i = 0; i < N; i++) {
                long a = slices.get(i);
                for(int j = i+1; j < N; j++) {
                    long b = slices.get(j);
                    if(2*a == b) {
                        best = 1;
                    } else if(2*b == a) {
                        best = 1;
                    }
                }
            }
            for(int i = 0; i < N; i++) {
                long a = slices.get(i);
                for(int j = i+1; j < N; j++) {
                    long b = slices.get(j);
                    for(int k = j+1; k < N; k++) {
                        long c = slices.get(k);
                        if (a == b && a == c) {
                            System.out.println("Case #" + cid + ": 0");
                            return;
                        } else if(a == b) {
                            if(c > a) {
                                best = 1;
                            }
                        } else if(a == c) {
                            if(b > a) {
                                best = 1;
                            }
                        } else if(b == c) {
                            if(a > b) {
                                best = 1;
                            }
                        }
                    }
                }
            }
            System.out.println("Case #" + cid + ": " + best);
            return;
        }

    }

}
