import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the test cases: ");
        int testCase = scan.nextInt();
        System.out.println("Enter the size of matrix: ");
        int size = scan.nextInt();
        // array declaration
        int[][] array = new int[size][size];

        while(testCase >=1){
            System.out.print("Enter values: ");
            for(int i = 0 ; i < array.length ; i++ ){
                System.out.println("[");
                for(int j = 0 ; j< array.length ; j++)
                    array[i][j] = scan.nextInt();
                System.out.println("]");
            }
            System.out.print("Case # " + testCase);
            System.out.print("\ttrace of matrix: " + traceOfMatrix(array));
            System.out.print("\trow repeat: " + findDuplicateInRow(array));
            System.out.println("\tcolumn repeat: " + findDuplicateInColumn(array));
            testCase-- ;

        }

    }

    private static int traceOfMatrix(int[][] arrays) {
        int value = 0  ;
        for(int i = 0 ; i < arrays.length ; i++){
            value = value + arrays[i][i];

        }
        return value ;
    }
    private static  int findDuplicateInRow(int[][] arrays ){
        int repeat = 0   ;
        int[] temparray = new int[arrays.length];
        for(int i = 0 ; i < arrays.length ; i++){

            for (int j = 0 ; j < arrays.length; j++){

                if(temparray[arrays[i][j]- 1 ] == 0){
                    temparray[arrays[i][j]- 1 ] = 1 ;
                    if(j+1 == arrays.length){
                        for(int k = 0 ; k < temparray.length ; k++){
                            temparray[k] = 0 ;
                        }
                        break;
                    }
                }else {

                    ++repeat;
                    for(int k = 0 ; k < temparray.length ; k++){
                        temparray[k] = 0 ;
                    }
                    break;
                }

            }
        }
        return repeat ;

    }
    private static  int findDuplicateInColumn(int[][] arrays ){
        int repeat = 0   ;
        int[] temparray = new int[arrays.length];
        for(int i = 0 ; i < arrays.length ; i++){

            for (int j = 0 ; j < arrays.length; j++){

                    if(temparray[arrays[j][i]- 1 ] == 0){
                        temparray[arrays[j][i]- 1 ] = 1 ;
                        if(j+1 == arrays.length){
                            for(int k = 0 ; k < temparray.length ; k++){
                                temparray[k] = 0 ;
                            }
                            break;
                        }
                    }else{

                        ++repeat;
                        for(int k = 0 ; k < temparray.length ; k++){
                            temparray[k] = 0 ;
                        }
                        break;
                    }

            }
        }
        return repeat ;

    }
}
