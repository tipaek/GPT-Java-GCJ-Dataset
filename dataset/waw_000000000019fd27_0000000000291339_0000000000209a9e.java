import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);


        int cases = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int[] result = new int[b];
            for(int j=0;j<b;j++) {
                System.out.println(j + 1);
                result[j] = scanner.nextInt();
            }
            printArray(result);
        }

    }

    private static void printArray(int[] arr){
        String result = "";
        for(int i=0;i<arr.length;i++) {
            result += arr[i];
        }
        System.out.println(result);
    }

}
