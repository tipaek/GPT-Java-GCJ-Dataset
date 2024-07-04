import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 1; i <= cases; i++)
        {
            int activ_num = in.nextInt();
            HashMap<Integer, int[]> activities = new HashMap<>();
            int[] start_times = new int[activ_num];
            int[] indices = new int[activ_num];
            for (int j = 0; j < activ_num; j++) {
                int start_time = in.nextInt();
                int end_time = in.nextInt();
                int[] tmp = new int[2];
                indices[j] = j;
                start_times[j] = start_time;
                tmp[0] = start_time;
                tmp[1] = end_time;
                activities.put(j, tmp);
            }
            quicksort(start_times, indices); // Sorted by start time and indices to the activities
            // Idea is this, we have two workers C and J. At the beginning their end time is 0. Afterwards their end time
            // is upgraded/changed by the fact of start time >= endtime and then endtime gets updated
            int end_c = 0;
            int end_j = 0;
            String answer = "";
            int[] assignments = new int[activ_num];
            for (int j = 0; j < activ_num; j++)
            {
                int[] times = activities.get(indices[j]);
//                System.out.println(times[0] + " " + times[1] + " " + end_c + " " + end_j);
                if (end_c <= times[0])
                {
                    end_c = times[1];
                    assignments[indices[j]] = 0; // 0 means C
                }
                else if (end_j <= times[0])
                {
                    end_j = times[1];
                    assignments[indices[j]] = 1; // 1 means J
                }
                else {
                    answer = "IMPOSSIBLE";
                    break;
                }
//                System.out.println(times[0] + " " + times[1] + " " + end_c + " " + end_j);
            }
            if (!answer.equalsIgnoreCase("IMPOSSIBLE"))
            {
                for (int j = 0; j < activ_num; j++)
                {
                    if (assignments[j] == 0)
                        answer += "C";
                    else
                        answer += "J";
                }
            }
            System.out.println("Case #" + i + ": " + answer);

        }
        // Now, we need to sort the activities based on the start times. After that, we can assign them
        // iteratively.


    }


    public static void quicksort(int[] main, int[] index) {
        quicksort(main, index, 0, index.length - 1);
    }

    // quicksort a[left] to a[right]
    public static void quicksort(int[] a, int[] index, int left, int right) {
        if (right <= left) return;
        int i = partition(a, index, left, right);
        quicksort(a, index, left, i-1);
        quicksort(a, index, i+1, right);
    }

    // partition a[left] to a[right], assumes left < right
    private static int partition(int[] a, int[] index,
                                 int left, int right) {
        int i = left - 1;
        int j = right;
        while (true) {
            while (less(a[++i], a[right]))      // find item on left to swap
                ;                               // a[right] acts as sentinel
            while (less(a[right], a[--j]))      // find item on right to swap
                if (j == left) break;           // don't go out-of-bounds
            if (i >= j) break;                  // check if pointers cross
            exch(a, index, i, j);               // swap two elements into place
        }
        exch(a, index, i, right);               // swap with partition element
        return i;
    }

    // is x < y ?
    private static boolean less(float x, float y) {
        return (x < y);
    }

    // exchange a[i] and a[j]
    private static void exch(int[] a, int[] index, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
        int b = index[i];
        index[i] = index[j];
        index[j] = b;
    }
}
