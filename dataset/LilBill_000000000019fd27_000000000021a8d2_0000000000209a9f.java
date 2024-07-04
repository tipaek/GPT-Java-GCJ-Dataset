
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner fileScanner = new Scanner(System.in);
        int cases = fileScanner.nextInt();
        fileScanner.nextLine();
        for (int i = 0; i < cases; i++) {
            System.out.print("Case #" + (i+1) + ": ");
            String values = fileScanner.nextLine();
            int[] ints = new int[values.length()];
            for (int j = 0; j < values.length(); j++) {
                ints[j] = Character.getNumericValue(values.charAt(j));
            }

            printFirst(ints[0]);
            for (int k = 0; k < ints.length-1; k++) {
                printNext(ints[k], ints[k+1]);
            }
            printLast(ints[ints.length-1]);
        }

        fileScanner.close();
    }

    private static void printLast(int last) {
        int index = last;
        while(index > 0 ){
            System.out.print(")");
            index--;
        }
        System.out.println();
    }

    private static void printNext(int first, int second) {
        int result = second - first;
        if (result > 0 ){
            while(result > 0){
                System.out.print("(");
                result--;
            }
        } else{
            while(result < 0){
                System.out.print(")");
                result++;
            }
        }
        System.out.print(second);
    }

    private static void printFirst(int first) {

        int index = first;
        while(index > 0 ){
            System.out.print("(");
            index--;
        }
        System.out.print(first);
    }
}