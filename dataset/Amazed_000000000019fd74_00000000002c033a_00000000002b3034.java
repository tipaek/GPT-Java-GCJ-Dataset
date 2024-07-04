import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    // static List<List<String>> sorted = new ArrayList<>();

    public static class ListComparator implements Comparator<List<String>> {

        @Override
        public int compare(List<String> l1, List<String> l2) {
            for (int i = 0; i < l1.size(); ++i) {
                if (l1.get(i).compareTo(l2.get(i)) != 0) {
                    return l1.get(i).compareTo(l2.get(i));
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            List<String> words = new ArrayList<>(N);
            for (int index = 0; index < N; index++) {
                String temp = sc.next();
                words.add(temp);
            }

            List<List<String>> split = new ArrayList<>();
            for (int index = 0; index < words.size(); index++) {
                List<String> temp = new ArrayList<>();
                for (int count = 1; count < words.get(index).length(); count++) {
                    String a = "";
                    if (count == words.get(index).length() - 1) {
                        a = words.get(index).substring(count);
                    } else {
                        a = words.get(index).substring(count, count + 1);
                    }
                    temp.add(a);
                }
                temp.add(0, Integer.toString(temp.size()));
                split.add(temp);
            }
            split.sort(new ListComparator());
            // System.out.println(split);

            boolean check = true;
            for (int index = 0; index < split.size() - 1; index++) {
                int c = split.get(split.size() - 1).size() - 1;
                for (int count = split.get(index).size() - 1; count >= 1; count--) {
                    String a = split.get(index).get(count);
                    String b = split.get(split.size() - 1).get(c);
                    if (!a.contentEquals(b)) {
                        check = false;
                        break;
                    }
                    c--;
                }
                if (check == false) {
                    break;
                }
            }
            if (check == false) {
                out.print("Case #" + (i + 1) + ": *");

            } else {
                out.print("Case #" + (i + 1) + ": ");
                for (int index = 1; index < split.get(split.size() - 1).size(); index++) {
                    out.print(split.get(split.size() - 1).get(index));
                }
            }
            out.println();

            // System.out.println(sorted);

        }
        out.close();

    }
}
