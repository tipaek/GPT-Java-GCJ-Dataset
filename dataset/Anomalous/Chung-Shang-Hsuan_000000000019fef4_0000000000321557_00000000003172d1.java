import java.util.*;

public class Solution {

    private Long[] arr;
    private int diners;
    private int length;

    public Solution(int length, int num, Scanner sc) {
        this.length = length;
        this.diners = num;
        this.arr = new Long[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextLong();
        }
    }

    public int calculate() {
        if (diners == 2) {
            return checkPairs();
        } else {
            return checkTriples();
        }
    }

    private int checkPairs() {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i].equals(arr[j])) {
                    return 0;
                }
            }
        }
        return 1;
    }

    private int checkTriples() {
        if (containsTripleEqualElements()) {
            return 0;
        }
        if (containsDoubleElement()) {
            return 1;
        }
        if (containsTripleWithSmallerElement()) {
            return 1;
        }
        return 2;
    }

    private boolean containsTripleEqualElements() {
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

    private boolean containsDoubleElement() {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[j] == 2 * arr[i] || arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean containsTripleWithSmallerElement() {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (arr[i].equals(arr[j]) && arr[i] < arr[k]) {
                        return true;
                    }
                    if (arr[j].equals(arr[k]) && arr[j] < arr[i]) {
                        return true;
                    }
                    if (arr[k].equals(arr[i]) && arr[k] < arr[j]) {
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