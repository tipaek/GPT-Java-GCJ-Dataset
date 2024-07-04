import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {


    static class Interval {
        int index;
        int start;
        int end;
        char person;

        Interval(int s, int e, int i) {
            start = s;
            end = e;
            person = 'k';
            index = i;
        }

        public boolean isAvailable() {
            if (person == 'k')
                return true;
            return false;
        }

        public char getPerson() {

            return person;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public String toString() {
            return this.getStart() + "@" + this.getEnd();
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(bufferedReader.readLine().trim());
        int count = 0;
        for (int j = 0; j < T; j++) {
            count++;
            int N = Integer.parseInt(bufferedReader.readLine().trim());

            PriorityQueue<Interval> oPQ = new PriorityQueue<>(new Comparator<Interval>() {
                @Override
                public int compare(Interval interval, Interval t1) {
                    if (interval.start > t1.start) return 1;
                    else if (interval.start < t1.start) return -1;
                    else return 0;
                }
            });
            for (int i = 0; i < N; i++) {
                String[] s = bufferedReader.readLine().split(" ");
                Interval newitn = new Interval(Integer.parseInt(s[0]), Integer.parseInt(s[1]), i);
                oPQ.add(newitn);

            }
            PriorityQueue<Interval> oFinal = new PriorityQueue<>(new Comparator<Interval>() {
                @Override
                public int compare(Interval interval, Interval t1) {
                    if (interval.index > t1.index) return 1;
                    else if (interval.index < t1.index) return -1;
                    else return 0;
                }
            });
            Interval slotC = null;
            Interval slotJ = null;
            Interval temp = null;
            boolean notImpossible = true;
            while (!oPQ.isEmpty()) {

                temp = oPQ.remove();

                if (slotC == null) {
                    slotC = temp;
                    slotC.person = 'C';

                } else {
                    if (temp.start >= slotC.end) {
                        slotC = temp;
                        slotC.person = 'C';
                    }
                }
                if (temp.isAvailable()) {
                    if (slotJ == null) {
                        slotJ = temp;
                        slotJ.person = 'J';
                    } else {
                        if (temp.start >= slotJ.end) {
                            slotJ = temp;
                            slotJ.person = 'J';
                        }
                    }
                }
                if (temp.isAvailable()) {
                    System.out.print("\nCase #" + count + ": IMPOSSIBLE");
                    notImpossible = false;
                    break;
                }
                oFinal.add(temp);
            }
            if (notImpossible) {
                System.out.print("\nCase #" + count + ": ");
                for (Interval itm : oFinal) {
                    System.out.print(itm.person);
                }
            }
        }

        bufferedReader.close();
    }
}
