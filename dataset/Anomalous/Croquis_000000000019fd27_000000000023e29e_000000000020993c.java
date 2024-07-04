import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    static ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    
    private static void populateMatrix(int N) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            ArrayList<Integer> row = Arrays.stream(input)
                                           .map(Integer::parseInt)
                                           .collect(Collectors.toCollection(ArrayList::new));
            matrix.add(row);
        }
    }

    public static int countDuplicateRows() {
        int count = 0;
        for (ArrayList<Integer> row : matrix) {
            if (row.stream().distinct().count() != row.size()) {
                count++;
            }
        }
        return count;
    }

    public static int countDuplicateColumns() {
        int count = 0;
        int N = matrix.size();
        for (int col = 0; col < N; col++) {
            ArrayList<Integer> columnValues = new ArrayList<>();
            for (ArrayList<Integer> row : matrix) {
                columnValues.add(row.get(col));
            }
            if (columnValues.stream().distinct().count() != columnValues.size()) {
                count++;
            }
        }
        return count;
    }

    public static int calculateDiagonalSum() {
        int sum = 0;
        for (int i = 0; i < matrix.size(); i++) {
            sum += matrix.get(i).get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();  // Consume newline

        for (int i = 0; i < T; i++) {
            matrix.clear();
            int N = scan.nextInt();
            scan.nextLine();  // Consume newline
            populateMatrix(N);
            System.out.println("Case #" + (i + 1) + ": " + calculateDiagonalSum() + " " + countDuplicateRows() + " " + countDuplicateColumns());
        }
    }
}