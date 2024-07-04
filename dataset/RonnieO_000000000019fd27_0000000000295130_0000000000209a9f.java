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

    private static void printResult(char[] arr) {
        int level = 0;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            int curLevel = arr[i] - '0';
            if(curLevel > level) {
                int diff = curLevel - level;
                while(diff-- > 0) {
                    res.append("(");
                }
            }
            else if(curLevel < level) {
                int diff = level - curLevel;
                while(diff-- > 0) {
                    res.append(")");
                }
            }
            level = curLevel;
            res.append(arr[i]);
        }

        while(level-- > 0) {
            res.append(")");
        }

        System.out.println(res.toString());
    }

    public static void main(String[] args) {
        FileReaderI fr = new FileReaderI(new BufferedReader(new InputStreamReader(System.in)));

        int caseNum = 1;
        try {
            int numberOfCases = fr.iread();
            for(int i = 0; i < numberOfCases; i++) {
                char[] arr = fr.readword().toCharArray();
                System.out.print("Case #" + caseNum++ + ": ");
                printResult(arr);
            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}