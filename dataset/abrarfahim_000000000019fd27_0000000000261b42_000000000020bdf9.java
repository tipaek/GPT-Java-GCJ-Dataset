import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();


            ArrayList<Pair<Integer, Integer>> times = new ArrayList<>();

            for(int j = 0; j < n; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                times.add(new Pair<>(s, e));
            }


            //logic

            StringBuilder y = new StringBuilder();


            ArrayList<Pair<Integer, Integer>> j = new ArrayList<Pair<Integer, Integer>>();

            ArrayList<Pair<Integer, Integer>> c = new ArrayList<Pair<Integer, Integer>>();

            j.add(times.get(0));
            y.append("J");
//            c.add(times.get(1));
//            y.append("C");

            times.remove(0);
            //times.remove(0);
            boolean overlapJ = false;
            boolean overlapC = false;
            boolean impossible = false;


            for(Pair<Integer, Integer> p: times) {

                for(Pair<Integer, Integer> q: j) {

                    if((q.getKey() > p.getKey() && q.getKey() < p.getValue()) ||
                            q.getValue() > p.getKey() && q.getValue() < p.getValue() ||
                            q.getKey() < p.getKey() && q.getValue() > p.getValue()) {
                        //overlap
                        overlapJ = true;
                        break;
                    }

                }

                if(!overlapJ) {
                    //insert here
                    j.add(p);
                    y.append("J");
                    continue;
                }

                if(c.isEmpty()) {
                    c.add(p);
                    y.append("C");
                    continue;
                }
                for(Pair<Integer, Integer> r: c) {

                    if((r.getKey() > p.getKey() && r.getKey() < p.getValue()) ||
                            r.getValue() > p.getKey() && r.getValue() < p.getValue() ||
                            r.getKey() < p.getKey() && r.getValue() > p.getValue()) {
                        //overlap
                        overlapC = true;
                        break;
                    }
                }

                if(!overlapC) {
                    //insert here
                    c.add(p);
                    y.append("C");
                }
                else {
                    impossible = true;
                    break;
                }
                overlapC = false;
                overlapJ = false;

            }
            String out;
            if(impossible) {
                out = "IMPOSSIBLE";
            }
            else {
                out = y.toString();
            }

            //output
            System.out.println("Case #" + (i + 1) + ": " + out);
        }

    }
}

class Pair<u, v> {

    u a;
    v b;

    public Pair(u a, v b) {
        this.a = a;
        this.b = b;
    }

    u getKey() {
        return a;
    }

    v getValue() {
        return b;
    }
}
