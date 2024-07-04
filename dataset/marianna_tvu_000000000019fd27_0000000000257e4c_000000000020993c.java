import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static int nextInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }

    private static StreamTokenizer streamTokenizer;

    public static void main(String[] args) throws IOException {
        streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int numTests = nextInt();
        for (int i = 0; i < numTests; i++) {
            int size = nextInt();
            int[][]matrix = new int[size][size];
            for(int m = 0; m < size; m++) {
                int[] a = new int[size];
                for (int k = 0; k < size; ++k) {
                    a[k] = nextInt();
                }
                matrix[m] = a;
            }
            check(i + 1, size, matrix);
        }
    }

    private static void check(int caseNum, int n, int[][]a){
        int sum = 0;
        int rows = 0;
        int cols = 0;

        int i = 0;
        int j = 0;
        while(i < a.length){
           sum += a[i][j];
           i++;
           j++;
        }

        for (int k = 0; k < n; k++) {
            int f = 0;
            Set<Integer> set = new HashSet<>();
            while (f < n){
                if(!set.add(a[k][f])){
                    rows++;
                    break;
                }
                f++;
            }
        }

        for (int k = 0; k < n; k++) {
            int f = 0;
            Set<Integer> set = new HashSet<>();
            while (f < n){
                if(!set.add(a[f][k])){
                    cols++;
                    break;
                }
                f++;
            }
        }

        System.out.println("Case #" + caseNum + ": " + sum + " " + rows + " " + cols);
    }
}
