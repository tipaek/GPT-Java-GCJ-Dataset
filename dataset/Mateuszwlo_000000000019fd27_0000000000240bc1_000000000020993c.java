import java.util.HashSet;
import java.util.Scanner;

public class Problem{

    static int[][] matrix;
    static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();

        for(int i = 1; i <= cases; i++){
            size = sc.nextInt();
            sc.nextLine();
            matrix = new int[size][size];

            //Makes the matrix
            for(int j = 0; j < size; j++){
                String values = sc.nextLine();
                values = values.replaceAll(" ", "");

                for(int o = 0; o < size; o++){
                    matrix[j][o] = Integer.parseInt(String.valueOf(values.charAt(o)));
                }
            }

            System.out.println("Case #" + i + ": " + getTrace() + " " + getRepeatingRows() + " " + getRepeatingColumns());
        }
    }

    public static int getTrace(){
        int n = 0;
        int trace = 0;

        while(n != size){
            trace += matrix[n][n];
            n++;
        }

        return trace;
    }

    public static int getRepeatingColumns(){
        HashSet<Integer> s;
        int repeating = 0;

        for(int col = 0; col < size; col++){
            s = new HashSet<Integer>(0);
            for(int row = 0; row < size; row++){
                s.add(matrix[row][col]);
            }
            if(s.size() != size) repeating++;

        }

        return repeating;
    }

    public static int getRepeatingRows(){
        HashSet<Integer> s;
        int repeating = 0;

        for(int row = 0; row < size; row++){
            s = new HashSet<Integer>(0);
            for(int col = 0; col < size; col++){
                s.add(matrix[row][col]);
            }
            if(s.size() != size) repeating++;

        }

        return repeating;
    }
}