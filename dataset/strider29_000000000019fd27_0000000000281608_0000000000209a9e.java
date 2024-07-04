
import java.util.Scanner;

public class Solution {

    private static int comp = 1;
    private static int rev = 2;
    private static int revAndComp = 3;
    private static int same = 4;

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        while (t-- > 0) {
            short arr[] = new short[b];
            initArr(arr, b);
            checkArr(arr, b);
            int disjointBit = -1;
            int sameBit = -1;
            int queryCount = 0;
            for (int i = 0; i < b/2; i++) {
                System.out.println(i+1);
                short d1 = scanner.nextShort();
                System.out.println(b-i);
                short d2 = scanner.nextShort();
                if (d1 == d2 && sameBit == -1) {
                    sameBit = i;
                }
                if (d1 != d2 && disjointBit == -1) {
                    disjointBit = i;
                }
                queryCount+=2;
                if (disjointBit != -1 && sameBit != -1) {
                    break;
                }
            }
            while (queryCount % 10 != 0) {
                System.out.println(1);
                scanner.nextShort();
                queryCount++;
            }
            queryCount = 0;
            if (disjointBit != -1) {
                System.out.println(disjointBit + 1);
                arr[disjointBit] = scanner.nextShort();
                queryCount++;
            }
            if (sameBit != -1) {
                System.out.println(sameBit + 1);
                arr[sameBit] = scanner.nextShort();
                queryCount++;
            }
            for (int i = 0; i < b; i++) {
                if (queryCount % 10 == 0) {
                    //next query is gonna alter the array
                    short s = -1;
                    short d = -1;
                    if (sameBit != -1) {
                        System.out.println(sameBit + 1);
                        s = scanner.nextShort();
                        queryCount++;
                    }
                    if (disjointBit != -1) {
                        System.out.println(disjointBit + 1);
                        d = scanner.nextShort();
                        queryCount++;
                    }
                    if (d == -1) {
                        if (s == arr[sameBit]) {
                            //noop
                        } else {
                            applyChanges(arr, comp, b);
                        }
                    } else if (s == -1) {
                        if (d == arr[disjointBit]) {
                            //noop
                        } else {
                            applyChanges(arr, comp, b);
                        }
                    }
                    else if (d != arr[disjointBit] && s != arr[sameBit]) {
                        applyChanges(arr, comp, b);
                    } else if (d == arr[disjointBit] && s != arr[sameBit]) {
                        applyChanges(arr, rev, b);
                        applyChanges(arr, comp, b);
                    } else if (d == arr[disjointBit] && s == arr[sameBit]) {
                        applyChanges(arr, same, b);
                    } else if (d != arr[disjointBit] && s == arr[sameBit]) {
                        applyChanges(arr, rev, b);
                    }
                    i = 0;
                }
                if (arr[i] == -1) {
                    //means we dont know the val
                    System.out.println(i+1);
                    arr[i] = scanner.nextShort();
                    queryCount++;
                }
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < b; i++) {
                ans.append(arr[i]);
            }
            System.out.println(ans.toString());
            String judge = scanner.next();
            if (judge.equals("N")) {
                break;
            }
        }
    }

    private static void initArr(short[] arr, int len) {
        for (int i = 0; i < len; i++) {
            arr[i] = -1;
        }
    }

    private static boolean checkArr(short[] arr, int len) {
        for (int i = 0; i < len; i++) {
            if (arr[i] == -1)
                return false;
        }
        return true;
    }

    private static void applyChanges(short[] arr, int op, int len) {
        if (op == same) {
            return;
        }
        if (op == comp) {
            for (int i = 0; i < len; i++) {
                if (arr[i] != -1) {
                    arr[i] = (short)(1 - arr[i]);
                }
            }
        }
        if (op == rev) {
            for (int i = 0; i < len/2; i++) {
                short temp = arr[i];
                arr[i] = arr[len-i-1];
                arr[len-i-1]=temp;
            }
        }
    }
}
