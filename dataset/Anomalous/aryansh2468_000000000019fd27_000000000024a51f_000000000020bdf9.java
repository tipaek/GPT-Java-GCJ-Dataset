import java.util.*;

public class Solution {
    private static Scanner sc;
    static int tn = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        StringBuilder sb = new StringBuilder();
        char person = 'J';
        Stack<int[]> JStack = new Stack<>();
        Stack<int[]> CStack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1 && doesOverlap(arr[i], arr[i + 1])) {
                if (person == 'J') {
                    JStack.push(arr[i]);
                    person = 'C';
                } else {
                    CStack.push(arr[i]);
                    person = 'J';
                }
            }
        }
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}