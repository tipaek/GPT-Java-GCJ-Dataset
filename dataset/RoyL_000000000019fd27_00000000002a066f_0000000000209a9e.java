import java.util.*;
import jav.io.*;

public class Solution {
    public static int b;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        b = in.nextInt();
        int[] arr = new int[b];
        for (int i = 0; i < 10; i++){
            System.out.println(i);
            arr[i] = in.nextInt();
        }
        printArray(arr);
        char result = in.nextChar();
    }
    
    public static void printArrau(int[] arr) {
        String out = "";
        for (int i = 0; i < arr.length; i++) {
            out += arr[i];
        }
        System.out.println(out);
    }
}