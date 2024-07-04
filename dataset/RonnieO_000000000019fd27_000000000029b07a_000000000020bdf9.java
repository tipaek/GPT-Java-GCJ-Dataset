import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    static class FileReaderI {

        private String inputFile;
        BufferedReader in;

        FileReaderI(String inputFile) {
            try {
                this.inputFile = inputFile;
                in = new BufferedReader(new FileReader(inputFile));
            }
            catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        FileReaderI(BufferedReader in) {
            this.in = in;
        }

        public int iread() throws Exception {
            return Integer.parseInt(readword());
        }

        public int[] readLineArray() {
            int[]  intArray = new int[1];
            try {
                String stringLine = in.readLine();
                String[] strArray = stringLine.split("\\s");
                intArray = new int[strArray.length];
                int idx = 0;
                for(String elem : strArray) {
                    intArray[idx++] = Integer.parseInt(elem);
                }
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            return intArray;
        }

        public String readword() throws IOException {
            StringBuilder b = new StringBuilder();
            int c;
            c = in.read();
            while (c >= 0 && c <= ' ')
                c = in.read();
            if (c < 0)
                return "";
            while (c > ' ') {
                b.append((char) c);
                c = in.read();
            }
            return b.toString();
        }
    }

    private static void printResult(int[][] intervals) {
        int[] cameron = new int[2];
        int[] jamie = new int[2];
        StringBuilder res = new StringBuilder();
        boolean isPossible = true;
        for(int i = 0; i < intervals.length && isPossible; i++) {
            isPossible = false;
            if(cameron[1] <= intervals[i][0]) {
                cameron = intervals[i];
                isPossible = true;
                res.append("C");
            }
            else if(jamie[1] <= intervals[i][0]) {
                jamie = intervals[i];
                isPossible = true;
                res.append("J");
            }
        }

        System.out.println(isPossible ? res.toString() : "IMPOSSIBLE");
    }

    private static Comparator<int[]> comp = new Comparator<int[]>() {
        @Override
        public int compare(int[] i1, int[] i2) {
            return i1[0] - i2[0];
        }
    };

    public static void main(String[] args) {
        FileReaderI fr = new FileReaderI(new BufferedReader(new InputStreamReader(System.in)));

        int caseNum = 1;
        try {
            int numberOfCases = fr.iread();
            for(int i = 0; i < numberOfCases; i++) {
                int n = fr.iread();
                int[][] intervals = new int[n][2];
                for(int j = 0; j < n; j++) {
                    intervals[j] = fr.readLineArray();
                }
                Arrays.sort(intervals, comp);
                System.out.print("Case #" + caseNum++ + ": ");
                printResult(intervals);
            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}