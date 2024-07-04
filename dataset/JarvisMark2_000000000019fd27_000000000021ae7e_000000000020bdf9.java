import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    class InputDataObj {
        ArrayList<Interval> intervals;
        public InputDataObj(ArrayList<Interval> intervals) {
            this.intervals = intervals;
        }

        @Override
        public String toString() {
            String res = "";
            for (int i = 0; i < intervals.size(); i++) {
                res += intervals.toString() + " ";
            }
            return res;
        }
    }

    class Interval implements Comparable<Interval> {
        int start, end;
        public Interval(int st, int ed) {
            this.start = st;
            this.end = ed;
        }

        @Override
        public int compareTo(Interval interval) {
            return this.start - interval.start;
        }

        @Override
        public String toString() {
            return "(" + this.start + ", " + this.end + ")";
        }
    }

    public static ArrayList<InputDataObj> getDataFromStdIn() {
        ArrayList<InputDataObj> input = new ArrayList<>();
        Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = 0;
        if (myReader.hasNextLine()) {
            T = Integer.valueOf(myReader.nextLine());
        }
        for (int i = 0; i < T; i++) {
            int N = 0;
            if (myReader.hasNextLine()) {
                N = Integer.valueOf(myReader.nextLine());
            }
            ArrayList<Interval> intervals = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (myReader.hasNextLine()) {
                    String[] inp = myReader.nextLine().replace("\n", "").trim().split(" ");
                    intervals.add(new Solution(). new Interval(Integer.valueOf(inp[0]), Integer.valueOf(inp[1])));
                }
            }
            input.add(new Solution(). new InputDataObj(intervals));
        }
        return input;
    }

    public static String findAllocation(InputDataObj input) {
        Collections.sort(input.intervals);
        StringBuffer resBuff = new StringBuffer();
        int cEnd = 0, jEnd = 0;
        for (Interval interval: input.intervals) {
            if (cEnd <= interval.start) {
                resBuff.append("C");
                cEnd = interval.end;
            }
            else if (jEnd <= interval.start) {
                resBuff.append("J");
                jEnd = interval.end;
            } else {
                resBuff.delete(0, resBuff.length());
                resBuff.append("IMPOSSIBLE");
                break;
            }
        }
        return resBuff.toString();
    }

    public static void main(String[] args) {
        ArrayList<InputDataObj> inputData = getDataFromStdIn();
        int i = 1;
        for (InputDataObj input: inputData) {
            System.out.printf("Case #%d: %s\n", i, findAllocation(input));
            i++;
        }
    }
}
