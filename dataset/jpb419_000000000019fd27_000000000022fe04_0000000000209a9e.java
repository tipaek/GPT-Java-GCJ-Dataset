import java.util.*;

public class Solution {
    static int[] array;
    static Scanner in;
    static int queries, low, high, B;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int T = in.nextInt();
        B = in.nextInt();
        while (T --> 0) {
            array = new int[B];
            Arrays.fill(array, -1);
            low = queries = 0;
            high = B;
            for (int k = 0; k < 5; k++) {
                array[low] = query(++low);
                array[high - 1] = query(high--);
            }
            while (low <= high) {
                if (queries % 10 == 0) updateArray();
                array[low] = query(++low);

                if (queries % 10 == 0) updateArray();
                array[high - 1] = query(high--);
            }
            Arrays.stream(array).forEach(System.out::print);
            System.out.println();
            in.nextLine();
            if (in.nextLine().equals("N")) break;
        }
    }
    
    public static void updateArray() {
        int same = -1, diff = -1;
        for (int i = 0; i < low; i++) {
            if (array[i] == array[B - i - 1]) {
                if (same < 0) same = i;
            } else if (diff < 0) {
                diff = i;
            }
            if (same >= 0 && diff >= 0) break;
        }
        boolean rev = false, comp = false;
        if (same < 0) {
            if (query(diff + 1) != array[diff]) rev = true;
        } else if (diff < 0) {
            if (query(same + 1) != array[same]) comp = true;
        } else {
            int newsame = query(same + 1);
            int newdiff = query(diff + 1);
            if (newsame == array[same]) {
                if (newdiff != array[diff]) rev = true;
            } else {
                if (newdiff == array[diff]) {
                    rev = comp = true;
                } else {
                    comp = true;
                }
            }
        }
        if (rev) {
            for (int i = 0; i < B / 2; i++) {
                int tmp = array[i];
                array[i] = array[B - i - 1];
                array[B - i - 1] = tmp;
            }
            while (array[low-1] < 0) low--;
            while (array[high+1] < 0) high++;
        }
        if (comp) for (int i = 0; i < B; i++) array[i] ^= 1;
    }
    
    public static int query(int index) {
        queries++;
        System.out.println(index);
        int res = in.nextInt();
        return res;
    }
}
