
import java.util.*;

public class Solution {

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

        List<Long> occuring_sizes = new ArrayList<Long>(N);
        /*
        List<Set<Long>> same_sizes = new ArrayList<Set<Long>>(D+1);

        for(int i = 0; i <= D; i++) {
            same_sizes.add(new HashSet<Long>());
        }
        */

        for(int i = 0; i < N; i++) {
            long A = in.nextLong();
            occuring_sizes.add(A);
            /*
            boolean has_same = false;
            for(int j = D-1; j >= 1; j--) {
                if(same_sizes.get(j).contains(A)) {
                    same_sizes.get(j).remove(A);
                    same_sizes.get(j+1).add(A);
                    has_same = true;
                    break;
                }
            }
            if(!has_same) {
                same_sizes.get(1).add(A);
            }
            */
        }

        /*
        if(!same_sizes.get(D).isEmpty()) {
            System.out.println("Case #" + cid + ": 0");
            return;
        }
        */

        // Collections.sort(occuring_sizes);

        int best = D-1;

        /*int same_count = D-1;
        while(same_count >= 1) {
            while(same_sizes.get(same_count).isEmpty()) {
                same_count--;
            }

            if(same_count <= 1) {
                System.out.println("Case #" + cid + ": " + (D-1));
                return;
            }

            long size = Collections.min(same_sizes.get(same_count));
            int[] req_cuts = new int[D+1];
            req_cuts[0] = 0;
            for(int i = 1; i <= D; i++) {
                req_cuts[i] = 1000;
            }
            for(Long o : occuring_sizes) {
                if(o == size) {
                    for(int i = D; i > 0; i--) {
                        req_cuts[i] = req_cuts[i-1];
                    }
                } else if(o % size == 0) {
                    long step = o / size;
                    if(step <= D) {
                        for(int i = D; i >= step; i--) {
                            int n = req_cuts[i-((int)step)] + (int)(step-1);
                            if(n < req_cuts[i]) {
                                req_cuts[i] = n;
                            }
                        }
                    }
                } else if(o > size){
                    for(int step = 1; step <= D && step <= (o/size); step++) {
                        for(int i = D; i >= step; i--) {
                            int n = req_cuts[i - step] + step;
                            if(n < req_cuts[i]) {
                                req_cuts[i] = n;
                            }
                        }
                    }
                }
            }

            if(req_cuts[D] < best) {
                best = req_cuts[D];
            }

            same_count--;
        }
        */

        for(long size : occuring_sizes) {

            int[] req_cuts = new int[D+1];
            req_cuts[0] = 0;
            for(int i = 1; i <= D; i++) {
                req_cuts[i] = 1000;
            }
            for(Long o : occuring_sizes) {
                if(o == size) {
                    for(int i = D; i > 0; i--) {
                        req_cuts[i] = req_cuts[i-1];
                    }
                } else if(o % size == 0) {
                    long step = o / size;
                    if(step <= D) {
                        for(int i = D; i >= step; i--) {
                            int n = req_cuts[i-((int)step)] + (int)(step-1);
                            if(n < req_cuts[i]) {
                                req_cuts[i] = n;
                            }
                        }
                    }
                } else if(o > size){
                    for(int step = 1; step <= D && step <= (o/size); step++) {
                        for(int i = D; i >= step; i--) {
                            int n = req_cuts[i - step] + step;
                            if(n < req_cuts[i]) {
                                req_cuts[i] = n;
                            }
                        }
                    }
                }
            }

            if(req_cuts[D] < best) {
                best = req_cuts[D];
            }

        }

        System.out.println("Case #" + cid + ": " + best);

    }

}
