import java.util.Scanner;

public class Solution {

    private Long[] arr;
    private int diners;
    private int length;

    public Solution(int length, int diners, Scanner scanner) {
        this.length = length;
        this.diners = diners;
        this.arr = new Long[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextLong();
        }
    }

    public int calculate() {
        if (diners == 2) {
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    if (arr[i].equals(arr[j])) {
                        return 0;
                    }
                }
            }
            return 1;
        } else {
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    for (int k = j + 1; k < length; k++) {
                        if (arr[i].equals(arr[j]) && arr[j].equals(arr[k])) {
                            return 0;
                        }
                    }
                }
            }
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    if (arr[j] == 2 * arr[i] || arr[i] == 2 * arr[j]) {
                        return 1;
                    }
                }
            }
            return 2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int c = 1; c <= cases; c++) {
            int numHouses = scanner.nextInt();
            int money = scanner.nextInt();
            Solution solution = new Solution(numHouses, money, scanner);
            System.out.println("Case #" + c + ": " + solution.calculate());
        }
    }
}