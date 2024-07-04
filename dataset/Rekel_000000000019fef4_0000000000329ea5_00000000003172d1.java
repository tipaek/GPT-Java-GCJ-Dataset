import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Solution {
    static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);

        int T = in.nextInt();

        for (int test = 1; test <= T; test++) {
            System.out.println("Case #" + test + ": " + losOp());
        }
    }

    public static String losOp() {
        int N = in.nextInt();
        int D = in.nextInt();
        long[] A = new long[N];

        // vind grootste N die hetzelfde zijn
        HashMap<Long, Integer> veelvoud = new HashMap<>();
        for (int i = 0; i < N; i++) {
            A[i] = in.nextLong();
            if (veelvoud.containsKey(A[i])) veelvoud.put(A[i], veelvoud.get(A[i]) + 1);
            else veelvoud.put(A[i], 1);
        }

        int max = 0;
        Long maxLong = Long.MAX_VALUE;
        for (Entry<Long, Integer> e : veelvoud.entrySet()) {
            if (e.getValue() > max) {
                maxLong = e.getKey();
                max = e.getValue();
            } else if (e.getValue() == max) {
                maxLong = e.getKey() < maxLong ? e.getKey() : maxLong;
            }
        }

        int min = 0;
        return "1";

        // kijk of er groteren zijn die veelvoud zijn van n & logica
        // deel dezen in gelijke stukken tot genoeg.
    }

    public static int tryCut(Long source, Long goal, int number, int slices) {
        if(source%goal==0) {
            long N = source/goal;
            if(number*N<slices) return -1;
            return (int) (slices/(number*(N-1)));
        }
        return 0;
    }
}