import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JAM {
    private static int matrixDimension;
    private static int[][] matrix;
    private static int trace;
    public static void main(String[] args) {
        /** To pass to another line I consider that 
         *  The user users the key "\n"
         *  This is the input rewritten with '\n'
         *  3 \n 4 \n 1 2 3 4 \n 2 1 4 3 \n 3 4 1 2 \n 4 3 2 1 \n 4 \n 2 2 2 2 \n 2 3 2 3 \n 2 2 2 4 \n 2 2 2 2 \n 3 \n 2 1 3 \n 1 3 2 \n 1 2 3 \n
        **/
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        int testCount = Integer.parseInt(in.next());
        //Loops over the tests
        for(int i = 0 ; i < testCount ; i ++) {
            if(i == 0) {
                in.next();
            }
            matrixDimension = Integer.parseInt(in.next());
            in.next();
            //Loops over the matrix input
            matrix = new int[matrixDimension][matrixDimension];
            for(int j = 0; j < matrixDimension; j++){
                for(int k = 0; k < matrixDimension; k++) {
                        matrix[j][k] = Integer.parseInt(in.next());
                }
                in.next();
            }
            int trace = getTrace(matrix);
            int r = getR(matrix);
            int c = getC(matrix);
            System.out.println("Case #"+ i + ": " + trace + " " + r + " " + c);
        }


    }

    public static int getTrace(int[][] matrix) {
        int res = 0;
        for(int i = 0; i < matrix.length ; i++){
            res += matrix[i][i];
        }
        return res;
    }

    public static int getR(int[][] matrix) {
        int counter = 0;
        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i + 1; j < matrix.length; j++) {
                    if (matrix[k][i] == matrix[k][j]) {
                        counter++;
                        j = matrix.length;
                        i = matrix.length;
                    }
                }
            }
        }
        return counter;
    }
    //3 \n 4 \n 1 2 3 4 \n 2 1 4 3 \n 3 4 1 2 \n 4 3 2 1 \n 4 \n 2 2 2 2 \n 2 3 2 3 \n 2 2 2 4 \n 2 2 2 2 \n 3 \n 2 1 3 \n 1 3 2 \n 1 2 3 \n


    public static int getC(int[][] matrix){
        int counter = 0;
        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i + 1; j < matrix.length; j++) {
                    if (matrix[i][k] == matrix[j][k]) {
                        counter++;
                        j = matrix.length;
                        i = matrix.length;
                    }
                }
            }
        }
        return counter;
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

}
