import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(), b = in.nextInt();
        char[] bits = new char[b];
        int caseNo = 0;
        do {

            for (int i = 1; i <= b; i++) {

                bits[i-1] = (char) (getBit(i, in) + '0');
            }

            StringBuilder result = new StringBuilder().append(bits);

            System.out.println(result);
            caseNo++;
        } while(in.nextLine().equals("Y") && caseNo <= t);

    }

    private static int getBit(int pos, Scanner in) {
        System.out.println(pos);
        return in.nextInt();
    }


}