
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        call(T, in);
    }

    static void call(int T, Scanner in){
        String s = "";
        for (int i = 1; i <= T; ++i) {
                int N = in.nextInt();
                s += "Case #" + i + ": " + task(N, in) + "\n";
        }
        System.out.println(s);
    }

    static String task (int N, Scanner in) {
        int track = 0, row = 0, column = 0;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                list.add(in.nextInt());
                if (i == j)
                    track += list.get(list.size() - 1);
            }
            arrayLists.add(list);
            list = new ArrayList<>();
        }


        for (int i = 0; i < N; ++i) {
            ArrayList<Integer> tmp = arrayLists.get(i);
            row += info(tmp, N);
        }

        for (int i = 0; i < N; ++i) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < N; ++j) {
                tmp.add(arrayLists.get(j).get(i));
            }
            column += info(tmp, N);
        }

        String s = track + " " + row + " " + column;
        return s;
    }

    static int info(ArrayList<Integer> tmp, int N) {
        for (int j = 0; j < N - 1; ++j) {
            for (int k = j + 1; k < N; ++k) {
                if (tmp.get(j) == tmp.get(k)) {
                    return 1;
                }
            }
        }
        return 0;
    }

}
