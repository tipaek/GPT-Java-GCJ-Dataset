import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void complementArray(int[] inputArray){
        for (int i = 0; i < inputArray.length; i++) {
            if ( inputArray[i] == 0){
                inputArray[i] = 1;
            }
            else if (inputArray[i] == 1){
                inputArray[i] = 0;
            }
        }
    }

    public static int[] reverseArray(int[] inputArray){
        int[] outputArray = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            outputArray[i] = inputArray[inputArray.length-1-i];
        }
        return outputArray;
    }

    public static int[] complementAndReverseArray(int[] inputArray){
        int[] outputArray = reverseArray(inputArray);
        complementArray(outputArray);
        return outputArray;
    }

    public static void handleGuessingFor10Bits(Scanner in){
        int[] answerArray = new int[10];
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            System.out.flush();
            answerArray[i-1] = in.nextInt();
        }
        String output = "";
        for (int value: answerArray) {
            output += value;
        }
        System.out.println(output);
        in.nextLine();
        String answer = in.nextLine();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = in.nextInt();
        int numberOfBits = in.nextInt();
        if (numberOfBits == 10){
            for (int i = 0; i < numberOfTestCases; i++) {
                handleGuessingFor10Bits(in);
            }

        }


    }
}
