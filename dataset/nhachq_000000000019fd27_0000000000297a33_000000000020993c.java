public class Vestigium {

        public static void main(String[] args){

            java.util.Scanner input = new java.util.Scanner(System.in);
            
            int T = input.nextInt();
            int [][] output = new int[T][3];
                    
            for (int i = 0; i< T; i++){
                int N = input.nextInt();
                int[][] matrix = new int[N][N];
                
                for (int row = 0; row < matrix.length; row++) {
                    for (int column = 0; column < matrix[row].length; column++) {
                        matrix[row][column] = input.nextInt();
                    }
                }
                
                output[i][0] = adder(matrix);
                output[i][1] = rowParser(matrix);
                output[i][2] = columParser(matrix);
            }

            for (int i = 0; i< T; i++) {
                System.out.println("Case #" + i+ ": " + output[i]);
            }
        }


        static int rowParser(int square[][]) {
            int row = 0;

            for (int i = 0; i < square[0].length; i++) {
                int r[] = square[i].clone();
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
            for (int i = 0; i < a.length; i++) {
                if( i == a[i])
                    return true;
            }

            return false;
        }

        static int adder(int[][] square){
            int sum = 0;
            for (int i = 0; i< square[0].length; i++){
                sum = sum+ square[i][i];
            }
            return 0;
        }

}