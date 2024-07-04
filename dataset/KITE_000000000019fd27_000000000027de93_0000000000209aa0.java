
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int len= scanner.nextInt();
        scanner.nextLine();

        StringBuilder report = new StringBuilder();
        for(int i = 0; i < len ; i++)
        {
            String[] piece = scanner.nextLine().split(" ");
            int size = Integer.parseInt(piece[0]);
            int target = Integer.parseInt(piece[1]);

            if(target % size == 0 )
            {
                int start = target / size;
                report.append("Case #").append(i + 1).append(": POSSIBLE\n");

                for(int k = 0; k< size ; k++)
                {
                    for(int l = 0; l < size ; l++)
                    {
                        report.append(start).append(" ");
                        if(l < size - 1)
                        {
                            if(start + 1 > size) start = 1;
                            else  start++;
                        }
                    }
                    report.append("\n");
                }

            }
            else
            {
                boolean find = false;
                for ( LatinSquare square : getReducedLatinSquares(size) ) {

                    if(square.getTrace() == target)
                    {
                        report.append("Case #").append(i + 1).append(": POSSIBLE\n");
                        report.append(square.toString());
                        find = true;
                    }
                }
                if(!find)  report.append("Case #").append(i + 1).append(": IMPOSSIBLE\n");
            }

        }
        System.out.println(report.toString());

    }


    //generate reduced latin square

    private static long fact(int n) {
        if ( n == 0 ) {
            return 1;
        }
        int prod = 1;
        for ( int i = 1 ; i <= n ; i++ ) {
            prod *= i;
        }
        return prod;
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
                for(int column  = 0; column < size ; column++ )
                {
                    sb.append(square[row][column] ).append(" ");

                }
                sb.append("\n");
            }
            return sb.toString();
        }

        public  int getTrace()
        {
            int trace = 0;
            for(int i = 0; i <size ; i++ )
                trace += square[i][i];
            return trace;

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


            int k = a.length - 1;
            while ( a[j] > a[k] ) {
                k--;
            }


            int temp = a[k];
            a[k] = a[j];
            a[j] = temp;

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