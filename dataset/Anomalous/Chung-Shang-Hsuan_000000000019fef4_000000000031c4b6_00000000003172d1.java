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
        } else {
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
                for (int j = i + 1; j < length; j++) {
                    if (arr[j] == 2 * arr[i] || arr[i] == 2 * arr[j]) {
                        return 1;
                    }
                }
            }
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    for (int k = j + 1; k < length; k++) {
                        if (arr[i].equals(arr[j]) && arr[i] < arr[k]) {
                            return 1;
                        }
                    }
                }
            }
            return 2;
        }
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