
import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < testCases; i++) {
            char[] input = sc.nextLine().toCharArray();
            int[] array = new int[input.length];
            for(int j = 0; j < input.length; j++){
                array[j] = Integer.parseInt(String.valueOf(input[j]));
            }

            String output = "";

            for(int j = 0; j < array[0]; j++){
                output = "(" + output;
            }
            output += array[0];

            for(int j = 1; j < array.length; j++){
                int difference = array[j] - array[j-1];
                while (difference != 0 ){
                    if (difference > 0){
                        output += "(";
                        difference--;
                    }
                    if (difference < 0){
                        output += ")";
                        difference ++;
                    }
                }
                output += array[j];
            }

            for(int j = 0; j < array[array.length - 1]; j++){
                output += ")";
            }
            System.out.println("Case #" + (i+1) + ": " + output);
        }

    }
}