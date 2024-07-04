import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < cases; i++) {
            int size = Integer.parseInt(scan.nextLine());
            int[][] mat = getMatrix(scan, size);
            int[] res = getTrace(mat);
            System.out.println("Case #" + (i + 1) + ": "+ res[0] + " " + res[1] + " " + res[2]);
        }
    }

    public static int[][] getMatrix(Scanner scan, int size)
    {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] table = scan.nextLine().split(" ");
            for (int j = 0; j < size; j++)
                matrix[i][j] = Integer.parseInt(table[j]);
        }
        return  (matrix);
    }

    public static boolean checkRow(int index, int arr[][])
    {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.add(arr[index][i]))
                return (false);
        }
        return (true);
    }

    public static boolean checkColumn(int index, int arr[][])
    {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.add(arr[i][index]))
                return (false);
        }
        return (true);
    }

    public static int[] getTrace(int[][] arr)
    {
        int[] res = new int[3];
        res[0] = 0;
        res[1] = 0;
        res[2] = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!checkColumn(i, arr))
                res[2]++;
            if (!checkRow(i, arr))
                res[1]++;
            res[0] += arr[i][i];
        }
        return (res);
    }

}
