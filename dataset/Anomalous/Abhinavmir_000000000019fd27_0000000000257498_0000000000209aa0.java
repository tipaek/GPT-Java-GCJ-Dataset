import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    static void generateLatinSquare(int size) {
        int start = size + 1;
        for (int row = 1; row <= size; row++) {
            int current = start;
            while (current <= size) {
                System.out.print(current + " ");
                current++;
            }
            for (int col = 1; col < start; col++) {
                System.out.print(col + " ");
            }
            start--;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int size = 5;
        generateLatinSquare(size);
    }
}