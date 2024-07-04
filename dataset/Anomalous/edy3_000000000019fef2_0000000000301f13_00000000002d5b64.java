import java.util.*;

class Solution {

    // Helper method to generate a string consisting of 'rank' repeated 'suitCount' times
    static String generateRepeatedRank(int rank, int suitCount) {
        StringBuilder repeatedRank = new StringBuilder();
        for (int i = 0; i < suitCount; ++i) {
            repeatedRank.append(rank);
        }
        return repeatedRank.toString();
    }

    // Helper method to find the last index in 'str' where the character is less than 'c'
    static int findLastIndexLessThanChar(String str, char c) {
        for (int i = str.length() - 1; i >= 0; --i) {
            if (str.charAt(i) < c) {
                return i;
            }
        }
        throw new IllegalStateException("No character found less than " + c);
    }

    // Method to solve the card sorting problem
    static List<String> solve(int ranks, int suits) {
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= suits; ++i) {
            for (int j = 1; j <= ranks; ++j) {
                str.append(j);
            }
        }

        List<String> moves = new ArrayList<>();
        StringBuilder endsWith = new StringBuilder();

        for (int rank = ranks; rank >= 1; --rank) {
            endsWith.insert(0, generateRepeatedRank(rank, suits));
            while (!str.toString().endsWith(endsWith.toString())) {
                char rankChar = (char) ('0' + rank);
                int firstIndex = str.indexOf(String.valueOf(rankChar));
                int lastIndex = findLastIndexLessThanChar(str.toString(), rankChar);

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

        int testCaseCount = in.nextInt();
        for (int i = 1; i <= testCaseCount; ++i) {
            int ranks = in.nextInt();
            int suits = in.nextInt();
            System.out.print(String.format("Case #%d: ", i));
            List<String> moves = solve(ranks, suits);
            System.out.println(moves.size());
            for (String move : moves) {
                System.out.println(move);
            }
        }
    }
}