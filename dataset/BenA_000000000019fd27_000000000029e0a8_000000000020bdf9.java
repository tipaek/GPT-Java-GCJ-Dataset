import java.io.*;
import java.util.*;

public class Solution {
    public static boolean impossible(int[] acts) {
        for (int x = 0; x < acts.length; x++) {
            if (acts[x] > 2) {
                return true;
            }
        }
        return false;
    }
    public static int[] times(int[][] arr) {
        int high = 0;
        for (int x = 0; x < arr.length; x++) {
            if (arr[x][1] > high) {
                high = arr[x][1];
            }
        }
        int[] ans = new int[high+1];
        for (int x = 0; x < ans.length; x++) {
            ans[x] = 0;
        }
        for (int x = 0; x < arr.length; x++) {
            for (int i = arr[x][0]; i < arr[x][1]; i++) {
                ans[i] = ans[i]+1;
            }
        }
        return ans;
    }
    public static String schedule(int[] arr, int[][] times) {
        char[] people = new char[arr.length];
        char[] done = new char[times.length];
        for (int x = 0; x < done.length; x++) {
            done[x] = 'N';
        }
        boolean left = true;
        boolean changed = false;
        while (left) {
            if (!changed) {
                for (int x = 0; x < done.length; x++) {
                    if (done[x] == 'N') {
                        for (int i = times[x][0]; i < times[x][1]; i++) {
                            people[i] = 'C';
                        }
                        done[x] = 'C';
                        break;
                    }
                }
            }
            changed = false;
            for (int x = 0; x < times.length; x++) {
                if (done[x] == 'N') {
                    for (int i = times[x][0];  i < times[x][1]; i++) {
                        if (people[i] == 'C') {
                            for (int j = times[x][0]; j < times[x][1]; j++) {
                                people[j] = 'J';
                            }
                            done[x] = 'J';
                            changed = true;
                            break;
                        }
                        else if (people[i] == 'J') {
                            for (int j = times[x][0]; j < times[x][1]; j++) {
                                people[j] = 'C';
                            }
                            done[x] = 'C';
                            changed = true;
                            break;
                        }
                    }
                }
            }
            left = false;
            for (int x = 0; x < done.length; x++) {
                if (done[x] == 'N') {
                    left = true;
                }
            }
        }
        String ans = "";
        for (int x = 0; x < done.length; x++) {
            ans += Character.toString(done[x]);
        }
        return ans;
    }
    public static void main (String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = Integer.parseInt(s.nextLine());
        for (int q = 1; q <= tests; q++) {
            int rows = Integer.parseInt(s.nextLine());
            int[][] arr = new int[rows][2];
            String[] sp;
            for (int x = 0; x < rows; x++) {
                sp = s.nextLine().split(" ");
                arr[x][0] = Integer.parseInt(sp[0]);
                arr[x][1] = Integer.parseInt(sp[1]);
            }
            int[] one = times(arr);
            if (impossible(one)) {
                System.out.println("Case #" + q + ": IMPOSSIBLE");
            }
            else {
                System.out.println("Case #" + q + ": " + schedule(one,arr));
            }
        }
    }
}