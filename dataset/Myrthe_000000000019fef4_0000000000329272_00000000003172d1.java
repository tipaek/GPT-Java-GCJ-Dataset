import java.util.*;

public class Solution {
    Scanner sc = new Scanner(System.in);
    HashMap<Long, Integer> sizes;
    int D;

    void run(){
        int tests = sc.nextInt();

        for( int t = 0; t < tests; t++){
            solve(t);
        }
    }

    void solve(int t) {
        System.out.print("Case #" + (t + 1) + ": ");
        int cuts = 0;
        int N = sc.nextInt();
        D = sc.nextInt();

        //long minDeg = Long.MAX_VALUE;
        //long totalDeg = 0;
        long maxDeg = 0;

        ArrayList<Slice> slices = new ArrayList<>();
        sizes = new HashMap<Long, Integer>();

        for (int i = 0; i < N; i++) {
            long deg = sc.nextLong();
            slices.add(new Slice(i, deg));

            if (sizes.containsKey(deg)) {
                sizes.replace(deg, sizes.get(deg) + 1);
            } else {
                sizes.put(deg, 1);
            }

            if (maxDeg < deg) {
                maxDeg = deg;
            }
        }

        long m = mostKey();
        while (sizes.get(m) < D) {
            //start cutting
            if (sizes.get(m) == 1 && sizes.keySet().size() == 1) {
                cuts += D - 1;
                break;
            }

            boolean larger = false;
            for (Long i : sizes.keySet()) {
                if (i == m) {
                    continue;
                }
                if (i > m) {
                    larger = true;
                }

            }

            if (larger) {
                cuts += 1;
                break;
            } else {
                cuts += 2;
                break;
            }

        }
        System.out.println(cuts);
    }

    long mostKey() {
        int most = Integer.MIN_VALUE;
        long key = -1;
        for (Long i : sizes.keySet()) {
            if (sizes.get(i) > most) {
                most = sizes.get(i);
                key = i;
            }
        }
        return key;
    }

    private class Slice {
        long deg;
        int i;

        Slice(int ip, long degp) {
            deg = degp;
            i = ip;
        }
    }

    public static void main(String[] args){
        (new Solution()).run();
    }
}
