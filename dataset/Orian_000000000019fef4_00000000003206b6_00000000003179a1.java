
import java.util.*;
import java.io.*;

public class Solution {

    static int getFirstDigit (int q){

        int digit = q % 10, possible = 0;
        while (q > 0){
            possible = digit;
            q /= 10;
            digit = q % 10;
        }

        return possible;

    }

    static int getNumDigit(int q){
        int i = 0;
        while(q > 0){
            i++;
            q /= 10;
        }
        return i;
    }

    static void printArray(int num[]){
        for (int i = 0; i < num.length; i ++){
            System.out.print(num[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args){

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {

            int u = in.nextInt();

            System.out.print("Case #" + i + ": ");

            int[] min = new int[26];
            int[] max = new int[26];
            int[] appeared = new int[26];
            for (int a = 0; a < 26; a++){
                max[a] = 10;
            }

            for (int num = 0; num < 10000; num++){

                int q = in.nextInt();
                String s = in.next();

                if (q == -1 || getNumDigit(q) > s.length()){
                    continue;
                }

                for (int j = 0; j < s.length(); j++){
                    appeared[s.charAt(j) - 'A'] = 1;
                }

                int firstDigit = getFirstDigit(q);
                max[s.charAt(0) - 'A'] = (max[s.charAt(0) - 'A'] > firstDigit) ? firstDigit : max[s.charAt(0) - 'A'];

            }

            for (int k = 0; k < 26; k++){
                if (max[k] == 10 && appeared[k] == 1){
                    System.out.print((char)(k + 'A'));
                }

            }

            for (int n = 1; n < 10; n++){

                for (int a = 0; a < 26; a++){
                    if (max[a] == n){
                        System.out.print((char)(a + 'A'));
                    }
                }

            }

            System.out.println();

        }

        in.close();

    }

}