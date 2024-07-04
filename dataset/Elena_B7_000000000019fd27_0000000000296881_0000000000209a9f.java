import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.*;

public class Solution {

    public static Scanner scanner;

    public static void main(String[] args) {
        InputStream fromStream = System.in;
        readInput(fromStream);
      /*
        try (InputStream fromStream = getFromFile()) {
            readInput(fromStream);
        } catch (IOException e){
            e.printStackTrace();
        }*/
    }

    public static void readInput(InputStream fromStream) {
        scanner = new Scanner(fromStream);
        int testCasesNum = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCasesNum; i++) {
            handleTestCase(i);
        }

        scanner.close();
    }


//    public static int trace(int matrix[][]) {
//        int trace = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            trace += matrix[i][i];
//        }
//        return trace;
//    }
//    public static void printMatrix(int matrix[][]) {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
    public static void handleTestCase(int testId){
        char[] digits = scanner.nextLine().toCharArray();
        String result="";

        int prevDigit =0;
        int curDigit=0;
        int distance ;
        for (int i = 0; i < digits.length; i++) {
            curDigit = (int)digits[i] - (int)'0';
            distance = prevDigit-curDigit;
           // System.out.println(distance);
            if(distance<0){
                for(int sk = 0; sk <-distance; sk++)
                result+="(";
            }else if(distance>0){
                for(int sk = 0; sk <distance; sk++)
                    result+=")";
            }
           // System.out.print(digits[i]);
            result+=digits[i];
            prevDigit=curDigit;
        }
        if(curDigit>0){
            for(int sk = 0; sk <curDigit; sk++)
                result+=")";
        }



        // output test case
        System.out.printf("Case #%d: %s \n", testId, result);
    }

    public static InputStream getFromFile() throws IOException{
        File initialFile = new File("src/input2.txt");
        InputStream targetStream = new FileInputStream(initialFile);
        return targetStream;
    }
}
