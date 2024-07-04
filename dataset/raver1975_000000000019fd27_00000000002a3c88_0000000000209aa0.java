import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //Scanner in = null;
        //try {
        //    in = new Scanner(new File("in.txt"));
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt();
            int trace = in.nextInt();

//            HashSet<Integer> traces = new HashSet<>();

            List<Integer>[] lists = new List[4];
            lists[0] = Arrays.asList(2, 4);
            lists[1] = Arrays.asList(3, 6,9);
            lists[2] = Arrays.asList(4,6, 7, 8, 9, 10, 11, 12, 13, 14, 16);
            lists[3] = Arrays.asList(5,7,8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,23, 25);
//            lists[3] = Arrays.asList(5,7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 25);

            //cerate latin square
            int[][] square = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    square[i][j] = ((n-(i - 1) + (j)) % n) + 1;
                }
            }

            int b = 0;
            if (!lists[n - 2].contains(trace)) {
                System.out.println("Case #" + tt + ": " + "IMPOSSIBLE");
            } else {
                while ((b = calcTrace(square)) != trace) {
                    if (!lists[n-2].contains(b)){
                        System.out.println("new Trace!"+n+"\t"+b);
                        System.exit(0);
                    }
                    if (Math.random()<.05d){
                        List<LatinSquare> list = getReducedLatinSquares(n);
                        LatinSquare l=list.get((int) (Math.random()*list.size()));
                        square=l.square;
                    }
                    int orientation = (int) (Math.random() * 4);
                    switch (orientation) {
                        case 0:
                            swapRows(square);
                            break;
                        case 1:
                            swapCols(square);
                            break;
                        case 2:
                            relabel1(square);
                            break;
                        case 3:
                            reorder(square);
                    }
                }
                System.out.println("Case #" + tt + ": " + "POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(square[i][j]);
                        if (j < n - 1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();

                }
            }
//            Integer[] out=traces.toArray(new Integer[0]);
//            Arrays.sort(out);
//            System.out.println(n + "\t" + Arrays.toString(out));
        }
    }

    private static void reorder(int[][] square) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                list1.add(j+1);
                list2.add(i+1);
                list3.add(square[i][j]);
            }
        }
        int choice = (int) (Math.random() * 5);
        switch (choice) {
            //123

            //213
            //321
            //132
            //231

            //312
            case 0:
                swapList(list1, list2);
                break;
            case 1:
                swapList(list1, list3);
                break;
            case 2:
                swapList(list2, list3);
                break;
            case 3:
                swapList(list1, list2);
                swapList(list1, list3);
                break;
            case 4:
                swapList(list1, list3);
                swapList(list2, list3);
                break;
        }
        for (int i=0;i<square.length*square.length;i++){
            square[list1.get(i)-1][list2.get(i)-1]=list3.get(i);
        }
    }

    static int[] colTemp;

    public static void swapList(List<Integer> list1, List<Integer> list2) {
        List<Integer> tmpList = new ArrayList<Integer>(list1);
        list1.clear();
        list1.addAll(list2);
        list2.clear();
        list2.addAll(tmpList);
    }

    private static void swapCols(int[][] square) {
        int n = square.length;
        int a = 0;
        int b = 0;
        while (a == b) {
            a = (int) (Math.random() * n);
            b = (int) (Math.random() * n);
        }
        colTemp = new int[n];
        for (int i = 0; i < n; i++) {
            colTemp[i] = square[a][i];
            square[a][i] = square[b][i];
            square[b][i] = colTemp[i];
        }

    }

    private static void swapRows(int[][] square) {
        int n = square.length;
        int a = 0;
        int b = 0;
        while (a == b) {
            a = (int) (Math.random() * n);
            b = (int) (Math.random() * n);
        }
        colTemp = new int[n];
        for (int i = 0; i < n; i++) {
            colTemp[i] = square[i][a];
            square[i][a] = square[i][b];
            square[i][b] = colTemp[i];
        }
    }

    public static int calcTrace(int[][] square) {
        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += square[i][i];
        }
        return sum;
    }

    public static void relabel1(int[][] square) {
        ArrayList<Integer> set = new ArrayList<>();
        for (int i = 0; i < square.length; i++) {
            set.add(i + 1);
        }
        Collections.shuffle(set);

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                square[j][i] = set.get(square[j][i] - 1);
            }
        }
    }

    private static List<LatinSquare> getReducedLatinSquares(int n) {
        List<LatinSquare> squares = new ArrayList<>();

        squares.add(new LatinSquare(n));
        PermutationGenerator permGen = new PermutationGenerator(n);
        for ( int fillRow = 1 ; fillRow < n ; fillRow++ ) {
            List<LatinSquare> squaresNext = new ArrayList<>();
            for ( LatinSquare square : squares ) {
                while ( permGen.hasMore() ) {
                    int[] perm = permGen.getNext();

                    //  If not the correct row - next permutation.
                    if ( (perm[0]+1) != (fillRow+1) ) {
                        continue;
                    }

                    //  Check permutation against current square.
                    boolean permOk = true;
                    done:
                    for ( int row = 0 ; row < fillRow ; row++ ) {
                        for ( int col = 0 ; col < n ; col++ ) {
                            if ( square.get(row, col) == (perm[col]+1) ) {
                                permOk = false;
                                break done;
                            }
                        }
                    }
                    if ( permOk ) {
                        LatinSquare newSquare = new LatinSquare(square);
                        for ( int col = 0 ; col < n ; col++ ) {
                            newSquare.set(fillRow, col, perm[col]+1);
                        }
                        squaresNext.add(newSquare);
                    }
                }
                permGen.reset();
            }
            squares = squaresNext;
        }

        return squares;
    }

    @SuppressWarnings("unused")
    private static int[] display(int[] in) {
        int [] out = new int[in.length];
        for ( int i = 0 ; i < in.length ; i++ ) {
            out[i] = in[i] + 1;
        }
        return out;
    }

    private static class LatinSquare {

        int[][] square;
        int size;

        public LatinSquare(int n) {
            square = new int[n][n];
            size = n;
            for ( int col = 0 ; col < n ; col++ ) {
                set(0, col, col + 1);
            }
        }

        public LatinSquare(LatinSquare ls) {
            int n = ls.size;
            square = new int[n][n];
            size = n;
            for ( int row = 0 ; row < n ; row++ ) {
                for ( int col = 0 ; col < n ; col++ ) {
                    set(row, col, ls.get(row, col));
                }
            }
        }

        public void set(int row, int col, int value) {
            square[row][col] = value;
        }

        public int get(int row, int col) {
            return square[row][col];
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for ( int row = 0 ; row < size ; row++ ) {
                sb.append(Arrays.toString(square[row]));
                sb.append("\n");
            }
            sb.append("trace: "+calcTrace());
            return sb.toString();
        }

        public  int calcTrace() {
            int sum = 0;
            for (int i = 0; i < square.length; i++) {
                sum += square[i][i];
            }
            return sum;
        }
    }

    private static class PermutationGenerator {

        private int[] a;
        private BigInteger numLeft;
        private BigInteger total;

        public PermutationGenerator (int n) {
            if (n < 1) {
                throw new IllegalArgumentException ("Min 1");
            }
            a = new int[n];
            total = getFactorial(n);
            reset();
        }

        private void reset () {
            for ( int i = 0 ; i < a.length ; i++ ) {
                a[i] = i;
            }
            numLeft = new BigInteger(total.toString());
        }

        public boolean hasMore() {
            return numLeft.compareTo(BigInteger.ZERO) == 1;
        }

        private static BigInteger getFactorial (int n) {
            BigInteger fact = BigInteger.ONE;
            for ( int i = n ; i > 1 ; i-- ) {
                fact = fact.multiply(new BigInteger(Integer.toString(i)));
            }
            return fact;
        }

        /*--------------------------------------------------------
         * Generate next permutation (algorithm from Rosen p. 284)
         *--------------------------------------------------------
         */
        public int[] getNext() {
            if ( numLeft.equals(total) ) {
                numLeft = numLeft.subtract (BigInteger.ONE);
                return a;
            }

            // Find largest index j with a[j] < a[j+1]
            int j = a.length - 2;
            while ( a[j] > a[j+1] ) {
                j--;
            }

            // Find index k such that a[k] is smallest integer greater than a[j] to the right of a[j]
            int k = a.length - 1;
            while ( a[j] > a[k] ) {
                k--;
            }

            // Interchange a[j] and a[k]
            int temp = a[k];
            a[k] = a[j];
            a[j] = temp;

            // Put tail end of permutation after jth position in increasing order
            int r = a.length - 1;
            int s = j + 1;
            while (r > s) {
                int temp2 = a[s];
                a[s] = a[r];
                a[r] = temp2;
                r--;
                s++;
            }

            numLeft = numLeft.subtract(BigInteger.ONE);
            return a;
        }
    }

}
