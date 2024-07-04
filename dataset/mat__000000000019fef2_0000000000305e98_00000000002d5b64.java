import java.util.*;

public class Solution {

    public static class Pair {
        int r;
        int s;

        Pair(int r, int s) {
            this.r = r;
            this.s = s;
        }

    }

    static class SuitSorter implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.s - o2.s;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {

            int r = in.nextInt();
            int s = in.nextInt();

            List<Pair> output = ranks(r, s);

            System.out.println("Case #" + i + ": " + output.size());
            for (Pair p : output) {
                System.out.println(p.r + " " + p.s);
            }

        }
    }

    static List<Pair> ranks(int r, int s) {

        List<Pair> input = new ArrayList<>();
        List<Pair> result = new ArrayList<>();

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= s; j++) {
                input.add(new Pair(i, j));
            }
        }

        int size = input.size();

        input.sort(new SuitSorter());


        int rank = r;

        while (rank > 0) {

            int count = 0;
            for (int i = size - 1; i >= 0; i--) {
                if (input.get(i).r == rank) count++;
                else if(input.get(i).r < rank) break;
            }

            if (count == s) {
                rank--;
            } else {
                List<Pair> a = new ArrayList<>();
                List<Pair> b = new ArrayList<>();
                List<Pair> c = new ArrayList<>();

                for (int i = input.size() - 1; i > -1; i--) {
                    if (input.get(i).r < rank) {
                        b.add(input.get(i));
                    } else if (input.get(i).r == rank) {
                        if (b.size() > 0) {
                            Collections.reverse(b);
                            for (int j = 0; j <= i; j++) {
                                a.add(input.get(j));
                            }
                            result.add(new Pair(a.size(), b.size()));
                            input = new ArrayList<>(b);
                            input.addAll(a);
                            input.addAll(c);
                            break;
                        } else {
                            c.add(input.get(i));
                        }
                    } else {
                        c.add(input.get(i));
                    }
                }
            }

        }


        return result;

    }

}
