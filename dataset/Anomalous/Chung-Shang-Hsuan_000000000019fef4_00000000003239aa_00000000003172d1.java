import java.util.Scanner;

public class Solution {

    private Long[] arr;
    private int diners;
    private int length;

    public Solution(int length, int diners, Scanner sc) {
        this.length = length;
        this.diners = diners;
        this.arr = new Long[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextLong();
        }
    }

    public int calculate() {
        if (diners == 2) {
            return calculateForTwoDiners();
        } else if (diners == 3) {
            return calculateForThreeDiners();
        } else {
            return 0;
        }
    }

    private int calculateForTwoDiners() {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i].equals(arr[j])) {
                    return 0;
                }
            }
        }
        return 1;
    }

    private int calculateForThreeDiners() {
        if (checkForThreeEqualElements()) {
            return 0;
        }
        if (checkForDoubleElements()) {
            return 1;
        }
        if (checkForTwoEqualAndOneGreaterElement()) {
            return 1;
        }
        return 2;
    }

    private boolean checkForThreeEqualElements() {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (arr[i].equals(arr[j]) && arr[i].equals(arr[k])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkForDoubleElements() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (arr[j].equals(2 * arr[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkForTwoEqualAndOneGreaterElement() {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    if (arr[i].equals(arr[j]) && arr[i] < arr[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
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