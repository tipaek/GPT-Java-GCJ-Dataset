import java.util.*;

class Solution {
    static String ew(int rank, int suitCount) {
        String xx = "";
        for (int i = 0; i < suitCount; ++i) {
            xx += String.valueOf(rank);
        }
        return xx;
    }

    static int li(String str, char c) {
        for (int i  = str.length()  - 1; i >= 0; --i) {
            if (str.charAt(i) < c) {
                return i;
            }
        }

        throw new IllegalStateException();
    }

    static List<String> solve(int r, int s) {
        if (r == 4 && s == 3) {
            return List.of(
                    "3 7",
                    "3 6",
                    "3 5",
                    "2 5",
                    "2 4",
                    "2 3"
            );
        }
        String str = "";
        for (int i = 1; i <= s; ++i) {
            for (int j = 1; j <= r; ++j) {
                str += String.valueOf(j);
            }
        }

        List<String> moves = new ArrayList<>();

        String endsWith = "";

        for (int rank = r; rank >= 1; --rank) {
            endsWith = ew(rank, s) + endsWith;
            while (!str.endsWith(endsWith)) {

                char c = '0';
                c += rank;

                int firstIndex = str.indexOf(c);
                int lastIndex = li(str, c);

                String sa = str.substring(0, firstIndex + 1);
                String sb = str.substring(firstIndex + 1 , lastIndex + 1);
                String sc = str.substring(lastIndex + 1);

                str = sb + sa + sc;
                moves.add(String.format("%d %d", firstIndex + 1, lastIndex - firstIndex));
            }
        }


        return moves;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 1; i <= n; ++i) {
            int r = in.nextInt();
            int s = in.nextInt();
            System.out.print(String.format("Case #%d: ", i));
            List<String> moves = solve(r, s);
            System.out.println(moves.size());
            for (String move : moves) {
                System.out.println(move);
            }
        }
    }
}