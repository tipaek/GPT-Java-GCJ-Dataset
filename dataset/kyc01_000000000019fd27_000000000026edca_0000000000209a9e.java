import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(f.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            final int B = Integer.parseInt(f.readLine());
            boolean[] array = new boolean[B];

            // initial setup
            int diff = -1;
            int same = -1;
            int i = 0;
            for (i = 0; i < 5; i++) {
                System.out.println(i + 1);
                array[i] = (Integer.parseInt(f.readLine()) == 1);
                System.out.println(B - i);
                array[B - i - 1] = (Integer.parseInt(f.readLine()) == 1);
                if (array[i] == array[B - i - 1]) {
                    same = i;
                } else {
                    diff = i;
                }
            }

            // subsequent queries
            while (i < B / 2) {
                boolean sameRes, diffRes;
                if (same == -1) {
                    System.out.println(0);
                    f.readLine();
                    sameRes = true;
                } else {
                    System.out.println(same + 1);
                    boolean res = Integer.parseInt(f.readLine()) == 1;
                    sameRes = (res != array[same]);
                }
                if (diff == -1) {
                    System.out.println(0);
                    f.readLine();
                    diffRes = false;
                } else {
                    System.out.println(diff + 1);
                    boolean res = Integer.parseInt(f.readLine()) == 1;
                    diffRes = (res != array[diff]);
                }

                array = getNewArray(sameRes, diffRes, array);

                for (int j = 0; j < 4; j++) {
                    System.out.println(i + 1);
                    array[i] = (Integer.parseInt(f.readLine()) == 1);
                    System.out.println(B - i);
                    array[B - i - 1] = (Integer.parseInt(f.readLine()) == 1);
                    if (array[i] == array[B - i - 1]) {
                        same = i;
                    } else {
                        diff = i;
                    }
                    i += 1;
                }

            }

            System.out.println(toString(array));
            if (f.readLine().equals("Y"))
                continue;
            else
                System.exit(0);

        }

    }

    /**
     * 
     * @param same whether the same bit has flipped
     * @param diff whether the differnt bit has flipped
     * @param arr  the array to be changed
     * @return the new array
     */
    public static boolean[] getNewArray(boolean same, boolean diff, boolean[] arr) {
        if (same && diff)
            return complement(arr);
        if (!same && !diff)
            return arr;
        if (!same && diff)
            return reverse(arr);
        return complement(reverse(arr));
    }

    public static String toString(boolean[] array) {
        char[] s = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i])
                s[i] = '1';
            else
                s[i] = '0';
        }
        return new String(s);
    }

    public static boolean[] reverse(boolean[] array) {
        boolean[] res = new boolean[array.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = array[array.length - i - 1];
        }
        return res;
    }

    public static boolean[] complement(boolean[] array) {
        boolean[] res = new boolean[array.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = !array[i];
        }
        return res;
    }
}
