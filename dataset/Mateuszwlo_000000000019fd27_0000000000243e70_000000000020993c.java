import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution{

    static ArrayList<String> matrix;
    static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();

        for(int i = 1; i <= cases; i++){
            size = sc.nextInt();
            sc.nextLine();
            matrix = new ArrayList<>(0);

            //Makes the matrix
            for(int j = 0; j < size; j++){
                String values = sc.nextLine();
                values = values.replaceAll(" ", "");
                matrix.add(values);
            }

            System.out.print("Case #" + i + ": " + getTrace() + " " + getRepeatingRows() + " " + getRepeatingColumns());
            if(i != cases) System.out.println();
        }
    }

    public static int getTrace(){
        int n = 0;
        int trace = 0;

        while(n != size){
            trace += Integer.parseInt(String.valueOf(matrix.get(n).charAt(n)));
            n++;
        }

        return trace;
    }

    public static int getRepeatingColumns(){
        HashSet<Character> s;
        int repeating = 0;

        for(int col = 0; col < size; col++){
            s = new HashSet<Character>(0);
            for(int row = 0; row < size; row++){
                if(!s.add(matrix.get(row).charAt(col))){
                    repeating++;
                    break;
                }
            }
        }
        return repeating;
    }

    public static int getRepeatingRows(){
        HashSet<Character> s;
        int repeating = 0;

        for(int row = 0; row < size; row++){
            s = new HashSet<Character>(0);
            for(int col = 0; col < size; col++){
                if(!s.add(matrix.get(row).charAt(col))){
                    repeating++;
                    break;
                }
            }
        }
        return repeating;
    }
}