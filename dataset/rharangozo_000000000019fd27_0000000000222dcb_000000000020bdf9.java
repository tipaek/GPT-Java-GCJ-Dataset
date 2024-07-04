import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws RuntimeException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        in.nextLine();
        for (int c = 0; c < t; ++c) {

            int n = in.nextInt();
            in.nextLine();
            List<Pair> tasks2 = new ArrayList<Pair>(n);

            for (int i = 0; i < n; ++i) {
                String[] vals = in.nextLine().trim().split(" ");
                tasks2.add(new Pair(Integer.parseInt(vals[0]), Integer.parseInt(vals[1])));
            }

            List<Pair> org = new ArrayList<>(tasks2);

            Collections.sort(tasks2);

            Pair clast = null;
            Pair jlast = null;
            boolean impos = false;

            for (Pair curr : tasks2) {
                if (clast == null) {
                    curr.mark = 'C';
                    clast = curr;
                } else {
                    if (clast.isOverlap(curr)) {
                        if (jlast == null) {
                            curr.mark = 'J';
                            jlast = curr;
                        } else {

                            if (jlast.isOverlap(curr)) {
                                //IMPOSSIBLE
                                impos = true;
                                break;
                            } else {
                                curr.mark = 'J';
                                jlast = curr;
                            }
                        }
                    } else {
                        curr.mark = 'C';
                        clast = curr;
                    }
                }
            }


            if (impos) {
                System.out.println("Case #" + (c+1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (c+1) + ": ");
                for (Pair p : org) {
                    System.out.print(p.mark);
                }
                System.out.println();
            }
        }
    }

    private static class Pair implements Comparable<Pair>{
        int a;
        int b;
        char mark;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }


        public int compareTo(Pair o) {
            return Integer.compare(this.a, o.a);
        }

        public boolean isOverlap(Pair o) {
            return (this.a < o.a && o.a < this.b) || (this.a < o.b && o.b < this.b);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
}
