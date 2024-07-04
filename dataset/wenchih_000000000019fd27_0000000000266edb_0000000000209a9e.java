import java.util.*;
import java.util.Scanner;
import java.lang.*;

/**
 * Created by wenchihhsieh on 2017/4/15.
 */
public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String token[] = scanner.nextLine().split(" ");
        int num = Integer.parseInt(token[0]);
        int b = Integer.parseInt(token[1]);
        int time = b / 10;

        for (int k = 1; k <= num; k++) {
            char results[] = new char[b];
            int left = 0;
            for (int i = 0; i < b / 2; i++) {
                results[i] = checkIndex(scanner, i);
                results[b - i - 1] = checkIndex(scanner, b-i - 1);
            }
            int remain = b / 10;

            if(remain > 1) {
                int offset = b;
                int size = 5;
                int extra = remain >= 10? 1: 0;
                //System.out.println("extra " + extra + " remain " + remain);
                while(remain > 0 || extra > 1) {
                    if(remain == 0) {
                        offset = b;
                        size *= 5;
                        extra--;
                    }
                    int index[] = findIndex(results, offset, size, b);
                    //System.out.println("find index " + index[0] + " " + index[1]);

                    int use = 0;
                    if (index[0] >= 0) {
                        char c = checkIndex(scanner, index[0]);
                        use++;
                        if (c != results[index[0]]) {
                           // System.out.println("before complement " + new String(results));
                            complement(results, offset, size, b);
                           // System.out.println("complement " + new String(results));

                        }
                    }
                    if (index[1] >= 0) {
                        char c = checkIndex(scanner, index[1]);
                        use++;
                        if (c != results[index[1]]) {
                            if(index[0] < 0) {
                                complement(results, offset, size, b);
                            } else {
                                reverse(results, offset, size, b);
                            }
                        }
                    }
                    if(use < 2) {
                        checkIndex(scanner,0);//dummy
                    }
                    offset -= size;
                    remain--;
                }


            }
            System.out.println(new String(results));
            String answer = scanner.nextLine();
            if(answer.equals("N")) {
                return;
            }
        }
    }

    private static void reverse(char results[], int offset, int size, int n) {
        for(int i = offset-1; i >= offset - size; i-- ) {
            char tmp = results[i];
            results[i] = results[n - i - 1];
            results[n - i - 1] = tmp;
        }
    }

    private static void complement(char results[], int offset, int size, int n) {
        for(int i = offset-1; i >= offset - size; i-- ) {
            results[i] = results[i] == '1' ? '0':'1';
            results[n - i - 1] = results[n - i - 1] == '1' ? '0':'1';
        }
    }

    private static int[] findIndex(char results[], int offset, int size, int n) {
        int index[] = new int[2];
        index[0] = index[1] = -1;
        for(int i = offset-1; i >= offset - size; i-- ) {
            if(results[i] == results[n - i - 1]){
                index[0] = i;
            }
            if(results[i] != results[n - i - 1]){
                index[1] = i;
            }
            if(index[0] >= 0 && index[1] >= 0) {
                break;
            }
        }
        return index;
    }

    private static char checkIndex(Scanner scanner, int i) {
        System.out.println(i + 1);
        return scanner.nextLine().charAt(0);
    }
}
