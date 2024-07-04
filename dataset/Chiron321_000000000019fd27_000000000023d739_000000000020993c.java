import java.util.Scanner;

public class Vesitgium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int caseNo =1;
        while (test--> 0) {
            int size = sc.nextInt();
            int[][] ar = new int[size][size];
            int trace = 0;
            int row = 0;
            int input;
            for (int i = 0; i < size; i++) {
                boolean flag = true;
                for (int j = 0; j < size; j++) {
                    input = sc.nextInt();
                    if (check(ar[i], input) == true && flag == true) {
                        row++;
                        flag = false;
                    }
                    ar[i][j] = input;
                    if (i == j)
                        trace += ar[i][j];
                }
            }
            int column = 0;
            int[] columnar = new int[size];
            for (int j = 0; j < size; j++) {
                boolean flag = true;
                for (int i = 0; i < size; i++) {
                    columnar[i] = ar[i][j];
                }
                outer: for (int i = 0; i < size - 1; i++) {
                    for (int k = i + 1; k < size; k++) {
                        if (columnar[i] == columnar[k]) {
                            column++;
                            break outer;
                        }
                    }

                }
            }
            System.out.println("Case #"+caseNo+": "+trace + " " + row + " " + column);
            caseNo++;
        }
    }

    public static boolean check(int[] arr, int toCheckValue) {
        boolean test = false;
        for (int element: arr) {
            if (element == toCheckValue) {
                test = true;
                break;
            }
        }
        return test;
    }
}