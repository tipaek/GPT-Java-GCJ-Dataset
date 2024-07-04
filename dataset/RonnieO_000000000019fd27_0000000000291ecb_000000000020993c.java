import java.io.*;
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

    private static void printResult(int[][] arr) {
        int k = 0;
        int r = 0;
        int c = 0;
        for(int i = 0; i < arr.length; i++) {
            boolean[] row = new boolean[arr.length];
            boolean dupRow = false;
            for(int j = 0; j < arr[0].length; j++) {
                if(i == j) {
                    k += arr[i][j];
                }
                if(!dupRow && row[arr[i][j] - 1]) {
                    r++;
                    dupRow = true;
                }
                row[arr[i][j] - 1] = true;
            }
        }
        for(int i = 0; i < arr.length; i++) {
            boolean[] col = new boolean[arr.length];
            for(int j = 0; j < arr[0].length; j++) {
                if(col[arr[j][i] - 1]) {
                    c++;
                    break;
                }
                col[arr[j][i] - 1] = true;
            }
        }
        System.out.println(k + " " + r + " " + c);
    }

    public static void main(String[] args) {
        FileReaderI fr = new FileReaderI(new BufferedReader(new InputStreamReader(System.in)));

        int caseNum = 1;
        try {
            int numberOfCases = fr.iread();
            for(int i = 0; i < numberOfCases; i++) {
                int n = fr.iread();
                int[][] arr = new int[n][0];
                for(int j = 0; j < n; j++) {
                    arr[j] = fr.readLineArray();
                }

                System.out.print("Case #" + caseNum++ + ": ");
                printResult(arr);
            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}