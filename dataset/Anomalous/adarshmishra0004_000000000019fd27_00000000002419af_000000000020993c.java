import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int tcases = scnr.nextInt(); // Number of test cases

        while (tcases > 0) {
            tcases--;
            int sum = 0, countRow = 0, countCol = 0;
            int size = scnr.nextInt();
            int[][] arr = new int[size][size]; // Matrix size

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int ele = scnr.nextInt();
                    if (ele > 0 && ele <= size) {
                        arr[i][j] = ele;
                    }
                    if (i == j) {
                        sum += arr[i][j];
                    }
                    if (j > 0) {
                        for (int l = j - 1; l >= 0; l--) {
                            if (arr[i][j] == arr[i][l]) {
                                countRow++;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println("case 0 " + sum + " " + countRow);
        }
        scnr.close();
    }
}