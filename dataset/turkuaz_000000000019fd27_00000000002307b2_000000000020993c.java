import java.util.Arrays;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);

        int test_cases = k.nextInt();

        for(int i = 0; i < test_cases; i++) {
            int n = k.nextInt();
            int[][] matrix = new int[n][n];
            for(int j = 0; j < n; j++) {
                for(int l = 0; l < n; l++) {
                    matrix[j][l] = k.nextInt();
                }
            }
            check(matrix);
        }
    }


    public static void check(int matrix[][]) {
        int x = 0, y = 0, z = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(i == j) x += matrix[i][j];
            }
        }


        for(int i = 0; i < matrix.length; i++) {
            int max = mostFrequent(matrix[i], matrix.length);
            if(max > z)
                z = max;
        }

        for(int i = 0; i < matrix.length; i++) {
            int column[] = new int[matrix.length];
            for(int j = 0; j < matrix.length; j++) {
                column[j] = matrix[i][j];
            }
            int max = mostFrequent(column, matrix.length);
            if (max > y)
                y = max;
        }

        if(z == 1) z = 0;
        if(y == 1) y = 0;
        System.out.println(x + " " + z + " " + y);
    }

    static int mostFrequent(int arr[], int n)
    {

        // Sort the array
        Arrays.sort(arr);

        // find the max frequency using linear
        // traversal
        int max_count = 1, res = arr[0];
        int curr_count = 1;

        for (int i = 1; i < n; i++)
        {
            if (arr[i] == arr[i - 1])
                curr_count++;
            else
            {
                if (curr_count > max_count)
                {
                    max_count = curr_count;
                }
                curr_count = 1;
            }
        }

        // If last element is most frequent
        if (curr_count > max_count)
        {
            max_count = curr_count;
        }

        return max_count;
    }
}
