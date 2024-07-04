import java.util.Scanner;

public class Solution {

    private Long[] arr;
    private int diners;
    private int length;

    public Solution(int length, int diners, Scanner sc) {
        this.length = length;
        this.diners = diners;
        arr = new Long[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextLong();
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
        } else if (diners == 3) {
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    for (int k = j + 1; k < length; k++) {
                        if (arr[i].equals(arr[j]) && arr[i].equals(arr[k])) {
                            return 0;
                        }
                    }
                }
            }
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (arr[j] == 2 * arr[i]) {
                        return 1;
                    }
                }
            }
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    for (int k = 0; k < length; k++) {
                        if (arr[i].equals(arr[j]) && arr[i] < arr[k]) {
                            return 1;
                        }
                    }
                }
            }
            return 2;
        }
        return -1; // Default return value for cases other than diners == 2 or 3
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 1; c <= cases; c++) {
            int numHouses = sc.nextInt();
            int money = sc.nextInt();
            Solution solution = new Solution(numHouses, money, sc);
            System.out.println("Case #" + c + ": " + solution.calculate());
        }
    }
}