import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            solve(scanner, i + 1);
        }
    }

    public static void solve(Scanner in, int id) {
        int matrix_size = in.nextInt();
        int required_trace = in.nextInt();

        //Generate combinations of digits 0-9 of size n
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        for (int i = 1; i <= matrix_size; i++) {
            ArrayList<Integer> this_row = new ArrayList<>();
            for (int j = i; j < i + matrix_size; j++) {
                int val = j;
                if (val > matrix_size) val -= matrix_size;
                this_row.add(val);
            }
            grid.add(this_row);
        }

        if(permute(grid, matrix_size, required_trace)) {
            System.out.println("Case #" + id + ": POSSIBLE");
            for(int i = 0; i < matrix_size; i++) {
                for(int j = 0; j < matrix_size; j++) {
                    System.out.print(grid.get(i).get(j));
                }
                System.out.println();
            }
        }else{
            System.out.println("Case #" + id + ": IMPOSSIBLE");
        }
    }

    private static void swap(ArrayList<ArrayList<Integer>> v, int i, int j) {
        ArrayList<Integer> t = v.get(i);
        v.set(i, v.get(j));
        v.set(j, t);
    }

    public static boolean permute(ArrayList<ArrayList<Integer>> v, int n, int k) {
        if (n == 1) {
            if (check_k(v, k)) return true;
        } else {
            for (int i = 0; i < n; i++) {
                if (permute(v, n - 1, k)) return true;
                if (n % 2 == 1) {
                    swap(v, 0, n - 1);
                } else {
                    swap(v, i, n - 1);
                }
            }
        }
        return false;
    }

    private static boolean check_k(ArrayList<ArrayList<Integer>> grid, int k) {
        int sum = 0;
        for(int i = 0; i < grid.size(); i++) {
            sum += grid.get(i).get(i);
        }
        return sum == k;
    }
}