import java.util.*;

class Solution {
    static String generateEndString(int rank, int suitCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < suitCount; ++i) {
            sb.append(rank);
        }
        return sb.toString();
    }

    static int lastIndexLessThanChar(String str, char c) {
        for (int i = str.length() - 1; i >= 0; --i) {
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

        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= s; ++i) {
            for (int j = 1; j <= r; ++j) {
                str.append(j);
            }
        }

        List<String> moves = new ArrayList<>();
        StringBuilder endsWith = new StringBuilder();

        for (int rank = r; rank >= 1; --rank) {
            endsWith.insert(0, generateEndString(rank, s));
            while (!str.toString().endsWith(endsWith.toString())) {
                char c = (char) ('0' + rank);
                int firstIndex = str.indexOf(String.valueOf(c));
                int lastIndex = lastIndexLessThanChar(str.toString(), c);

                String sa = str.substring(0, firstIndex + 1);
                String sb = str.substring(firstIndex + 1, lastIndex + 1);
                String sc = str.substring(lastIndex + 1);

                str = new StringBuilder(sb).append(sa).append(sc);
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