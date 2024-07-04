import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        int testCases = GetInput.getInt();
        for (int m = 0; m < testCases; m++){
            int n = GetInput.getInt();
            int trace = 0;
            int rows = 0;
            int array[][] = new int[n][n];

            for (int i = 0; i < n; i++){
                array[i] = GetInput.getArrayInt();
                trace += array[i][i];

                int[] hash = new int[n];

                for (int j = 0; j < n; j++){
                    hash[array[i][j]-1]++;
                    if (hash[array[i][j]-1]>1){
                        rows++;
                        break;
                    }
                }
            }
            int cols = 0;
            for (int j = 0; j < n; j++) {
                int[] hash = new int[n];
                for (int i = 0; i < n; i++) {
                    hash[array[i][j] - 1]++;
                    if (hash[array[i][j] - 1] > 1) {
                        cols++;
                        break;
                    }
                }
            }
//            for (int i = 0 ;i < n; i++){
//                System.out.print(hash[i]+" ");
//            }
            System.out.println("Case #"+(m+1)+": "+trace+" "+rows+" "+cols);
        }
    }
}


class GetInput {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static char[] getCharArray() {
        char[] charArray;
        try {
            StringBuilder string = getInputString();
            charArray = new char[string.length()];
            for (int i = 0; i < string.length(); i++) {
                charArray[i] = string.charAt(i);
            }
            return charArray;
        } catch (Exception e) {
            e.printStackTrace();
        }
        charArray = new char[0];
        return charArray;
    }

    static int[] getArrayInt() {
        String[] string;
        int[] array;
        try {
            string = bufferedReader.readLine().split("\\s+");
            array = new int[string.length];
            for (int i = 0; i < string.length; i++) {
                array[i] = Integer.parseInt(string[i]);
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] arra = new int[2];
        return arra;
    }

    static int getInt() {
        try {
            String string = bufferedReader.readLine();
            return Integer.parseInt(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    static StringBuilder getInputString() {
        try {
            StringBuilder string = new StringBuilder();
            string.append(bufferedReader.readLine());
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new StringBuilder();
    }

    static long getLongInput() {
        try {
            String string = bufferedReader.readLine();
            return Long.parseLong(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    static long[] getLongArrayInput() {
        String[] string;
        long[] array;
        try {
            string = bufferedReader.readLine().split("\\s+");
            array = new long[string.length];
            for (int i = 0; i < string.length; i++) {
                array[i] = Long.parseLong(string[i]);
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
        }

        long[] arra = new long[2];
        return arra;
    }
}
