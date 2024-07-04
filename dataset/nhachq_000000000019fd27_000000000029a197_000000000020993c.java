class Vestigium {

        public static void main(String[] args){

            java.util.Scanner input = new java.util.Scanner(System.in);

            int T = input.nextInt();
            int [][] output = new int[T][3];

            for (int i = 0; i< T; i++){
                int N = input.nextInt();
                int[][] matrix = new int[N][N];

                for (int row = 0; row < N; row++) {
                    for (int column = 0; column < N; column++) {
                        matrix[row][column] = input.nextInt();
                    }
                }

                output[i][0] = adder(matrix);
                output[i][1] = rowParser(matrix);
                output[i][2] = columParser(matrix);
            }

            for (int i = 0; i< T; i++) {
                System.out.print("Case #" + i+ ":");
                for (int j = 0; j<3; j++) {
                    System.out.print(" "+ output[i][j]);
                }
                System.out.println();
            }
        }


        static int rowParser(int square[][]) {
            int row = 0;

            for (int i = 0; i < square[0].length; i++) {
                int[]r = new int[square[0].length];
                for (int j = 0; j<square[i].length; j++){
                    r[j] = square[i][j];
                }

//                for (int j = 0; j < r.length; j++) {
//                    System.out.print(r[j]);
//                }
                if (!numberChecker(r))
                    row++;
            }
            return row;
        }

        static int columParser(int square[][]){
            int columns = 0;
            for (int i = 0; i < square[0].length; i++) {
                int c[] = new int[square[0].length];
                for (int j = 0; j< square[0].length; j++){
                    c[j] = square[j][i];
                }
                if (!numberChecker(c))
                    columns ++;
            }

            return columns;
        }

        static boolean numberChecker(int a[]) {
            for (int i = 1; i < a.length+1; i++) {
                boolean checker = false;
                for (int j = 0; j<a.length; j++){
                    if( i == a[j])
                        checker = true;
                }
                if (!checker)
                    return false;
            }

            return true;
        }

        static int adder(int[][] square){
            int sum = 0;
            for (int i = 0; i< square[0].length; i++){
                sum = sum+ square[i][i];
            }
            return sum;
        }

}