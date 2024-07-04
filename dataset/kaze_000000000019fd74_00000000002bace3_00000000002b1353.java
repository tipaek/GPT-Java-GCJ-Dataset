import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int turn = 0; turn < T; turn++) {
            int n = input.nextInt();
            if (n < 500) {
                System.out.println("Case #" + (turn+1) + ": ");
                for (int i = 1; i <= n; i++) {
                    System.out.println(i + " " + 1);
                }
            }else {
                System.out.println("Case #" + (turn+1) + ": ");
                int jiansanshi  = n - 30;
                int[] erjin = new int[30];
                for (int i = 0; i < 30; i++) {
                    erjin[i] = -1;
                }
                int curr = jiansanshi;
                int index = 0;
                while (curr!=1) {
                    if (curr % 2 == 1) {
                        erjin[index] = 1;
                        curr--;
                    } else {
                        erjin[index] = 0;
                    }
                    index++;
                    curr = curr / 2;
                }
                erjin[index] = 1;
                int level = 0;
                int num0 = 0;
                for (int i = 0; i < 30; i++) {
                    if (erjin[i] == 0) {
                        num0++;
                    }
                }
                int stopr = 0;
                for (int i = 1; i <= 30; i++) {
                    if (erjin[i-1] == 1) {
                        if (level % 2 == 0) {
                            for (int j = 1; j <= i; j++) {
                                System.out.println(i + " " + j);
                            }
                        }else if (level%2 == 1) {
                            for (int j = i; j >= 1; j--) {
                                System.out.println(i + " " + j);
                            }
                        }
                        level++;
                    }else if (erjin[i-1] == 0) {
                        if (level%2 == 0) {
                            System.out.println(i + " " + 1);
                        } else {
                            System.out.println(i + " " + i);
                        }
                    }else {
                        stopr = i;
                        break;
                    }
                }
                for (int i = 0; i < 30-num0; i++) {
                    if (level % 2 == 0) {
                        System.out.println(stopr + " " + 1);
                    } else {
                        System.out.println(stopr + " " + stopr);
                    }
                    stopr++;
                }
            }
        }
    }
}
