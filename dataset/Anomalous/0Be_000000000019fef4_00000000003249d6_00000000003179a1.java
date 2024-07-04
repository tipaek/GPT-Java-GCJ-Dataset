import java.util.*;
import java.io.*;

class Solution {
    static final int QUERIES = 10000;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int testCases = Integer.parseInt(in.readLine());
        StringBuilder output = new StringBuilder();

        for (int currTestCase = 1; currTestCase <= testCases; currTestCase++) {
            output.append("Case #").append(currTestCase).append(": ");

            int U = Integer.parseInt(in.readLine());
            int[][] boundaries = new int[26][2];
            for (int i = 0; i < 26; i++) {
                boundaries[i][1] = 10;
            }

            PriorityQueue<Query> queriesQueue = new PriorityQueue<>();
            for (int i = 0; i < QUERIES; i++) {
                String[] input = in.readLine().split("\\s+");
                queriesQueue.add(new Query(input[0].toCharArray(), input[1].toCharArray(), Long.parseLong(input[0])));
            }

            Set<Character> uniqueChars = new HashSet<>();
            char[] answer = new char[10];
            Arrays.fill(answer, '-');

            while (!queriesQueue.isEmpty()) {
                Query query = queriesQueue.poll();
                processQuery(query, U, boundaries, answer, uniqueChars);
            }

            completeAnswer(boundaries, answer, uniqueChars);
            output.append(answer).append('\n');
        }

        out.print(output);
        in.close();
        out.close();
    }

    private static void processQuery(Query query, int U, int[][] boundaries, char[] answer, Set<Character> uniqueChars) {
        if (query.lQ < 10) {
            boundaries[query.A[0] - 'A'][1] = query.Q[0] - '0';
            boundaries[query.A[0] - 'A'][0] = 1;
        } else {
            if (answer[0] == '-') {
                for (int i = 0; i < 26; i++) {
                    if (boundaries[i][0] == 0) {
                        answer[0] = (char) ('A' + i);
                        break;
                    }
                }
            }

            if (query.A.length == U) {
                for (int i = 0; i < U; i++) {
                    int charIndex = query.A[i] - 'A';
                    if (boundaries[charIndex][0] == boundaries[charIndex][1]) continue;

                    int temp = query.Q[i] - '0';
                    if (temp < boundaries[charIndex][1]) {
                        boundaries[charIndex][1] = temp;
                    }

                    if (boundaries[charIndex][0] != boundaries[charIndex][1]) break;
                    else {
                        for (int j = 0; j < 26; j++) {
                            if (boundaries[j][0] != boundaries[j][1]) {
                                boundaries[j][0]++;
                            }
                        }
                    }
                }
            }
        }

        if (uniqueChars.size() < 10) {
            for (char c : query.A) {
                uniqueChars.add(c);
            }
        }
    }

    private static void completeAnswer(int[][] boundaries, char[] answer, Set<Character> uniqueChars) {
        for (char c : uniqueChars) {
            char tempChar = '-';
            if (boundaries[c - 'A'][0] == boundaries[c - 'A'][1]) {
                if (answer[boundaries[c - 'A'][0]] != '-') {
                    tempChar = answer[boundaries[c - 'A'][0]];
                }
                answer[boundaries[c - 'A'][0]] = c;
            } else {
                tempChar = c;
            }

            if (tempChar != '-') {
                for (int i = 0; i < 10; i++) {
                    if (answer[i] == '-') {
                        answer[i] = tempChar;
                        break;
                    }
                }
            }
        }
    }
}

class Query implements Comparable<Query> {
    char[] Q;
    char[] A;
    long lQ;

    public Query(char[] Q, char[] A, long lQ) {
        this.Q = Q;
        this.A = A;
        this.lQ = lQ;
    }

    @Override
    public int compareTo(Query other) {
        return Long.compare(this.lQ, other.lQ);
    }
}