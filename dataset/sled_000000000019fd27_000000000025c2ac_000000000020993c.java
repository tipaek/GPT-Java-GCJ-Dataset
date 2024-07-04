
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();
        call(T);

    }

    static void call(int T) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String s = "";
        for (int i = 1; i <= T; ++i) {
            int N = in.nextInt();
            in.nextLine();
            s += "Case #" + i + ": " +  task(N) + "\n";
        }
        System.out.println(s);
    }

    static String task (int N) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int track = 0, row = 0, column = 0;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            int j = 0;
            String s = in.nextLine();
            for (String str : s.split(" ")) {
                list.add(Integer.parseInt(str));
                if (i == j)
                    track += list.get(list.size() - 1);
                ++j;
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
