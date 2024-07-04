import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    private static class Pair implements Comparable<Pair>{
        int start, end, id;

        public Pair(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        static public Pair readPair(Scanner scanner, int id){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            return new Pair(start, end, id);
        }

        @Override
        public int compareTo(Pair o) {
            if(o.start<this.start) return 1;
            if(o.start>this.start) return -1;
            if(o.end<this.end) return 1;
            if(o.end>this.end) return -1;
            return 0;
        }
    }


    public static void main(String[] args){
        final int MAX_INTERVALS = 1000;
        Scanner scanner = new Scanner(System.in);
        int noTests = Integer.parseInt(scanner.nextLine());

        int noIntervals, jOccupUntil=0, cOccupUntil=0;
        Pair[] intervals = new Pair[MAX_INTERVALS+1];
        char[] assignedTo = new char[MAX_INTERVALS+1];
        boolean possible;
        for(int t=1; t<=noTests; t++){
            noIntervals = scanner.nextInt();

            for(int i=1; i<=noIntervals; i++) {
                intervals[i] = Pair.readPair(scanner, i);
            }

            Arrays.sort(intervals, 1, noIntervals+1);

            jOccupUntil=0;
            cOccupUntil=0;
            possible = true;
            for(int i=1; i<=noIntervals && possible; i++) {
                if(jOccupUntil<=intervals[i].start){
                    jOccupUntil=intervals[i].end;
                    assignedTo[intervals[i].id]='J';
                }
                else if(cOccupUntil<=intervals[i].start){
                    cOccupUntil=intervals[i].end;
                    assignedTo[intervals[i].id]='C';
                }
                else{
                    possible=false;
                }
            }

            if(possible) {
                System.out.println("Case #" + t + ": " + String.valueOf(assignedTo, 1, noIntervals));
            }
            else{
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            }
        }
    }
}
