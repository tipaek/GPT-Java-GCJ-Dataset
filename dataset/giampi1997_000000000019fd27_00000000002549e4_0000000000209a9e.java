import java.util.*;
import java.io.*;
public class Solution {
    static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) {

        int T = scanner.nextInt();
        int B = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            boolean[] arr = new boolean[B];
            int count = 0;

            Integer posBitEqual = null;
            Integer posBitNotEqual = null;
            for (int i = 0; i < arr.length/2; i++) {
                arr[i] = getN(i);
                arr[arr.length-i-1] = getN(arr.length-i-1);
                count+= 2;
                if (arr[i] == arr[arr.length-i-1])
                    posBitEqual = i;
                else
                    posBitNotEqual = i;

                if (count%10 == 0){
                    if (posBitEqual != null){

                        if (arr[posBitEqual] != getN(posBitEqual))
                            complementArray(arr);
                    }
                    else getN(0);
                    if (posBitNotEqual != null){

                        if (arr[posBitNotEqual] != getN(posBitNotEqual))
                            reverseArray(arr);
                    }
                    else getN(0);
                    count += 2;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] ? '1' : '0');
            }
            System.out.println();
            scanner.nextLine();
            String answer = scanner.nextLine();
            if (answer.equals("Y")) {
            }
            else if ((!answer.equals("N"))){
                while (true);
            }
            else
                System.exit(0);
        }

    }

    static boolean getN(int n){
        System.out.println(n+1);
        return scanner.nextInt() == 1;
    }

    static void complementArray(boolean[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = !arr[i];
        }
    }

    static void reverseArray(boolean[] arr){

        for (int i = 0; i < arr.length/2; i++) {
            arr[i] ^= arr[arr.length - i - 1];
            arr[arr.length - i - 1] ^= arr[i];
            arr[i] ^= arr[arr.length - i - 1];
        }
    }
}
