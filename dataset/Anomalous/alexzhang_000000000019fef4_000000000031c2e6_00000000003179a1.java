import java.io.*;
import java.util.*;

public class Solution {
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            processTestCase(testCase);
        }
    }

    private static void processTestCase(int testCaseNumber) throws IOException {
        System.out.print("Case #" + testCaseNumber + ": ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken());
        String[][] data = new String[10000][2];

        for (int i = 0; i < 10000; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = st.nextToken();
            data[i][1] = st.nextToken();
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();
        Set<Character> uniqueChars = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            String response = data[i][1];
            uniqueChars.add(response.charAt(response.length() - 1));
            if (response.length() == U) {
                char firstChar = response.charAt(0);
                frequencyMap.put(firstChar, frequencyMap.getOrDefault(firstChar, 0) + 1);
            }
        }

        List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
        Collections.sort(frequencies);

        char[] charOrder = new char[10];
        charOrder[0] = ',';

        for (int i = 0; i < 9; i++) {
            int currentFrequency = frequencies.get(i);
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                if (entry.getValue() == currentFrequency) {
                    charOrder[9 - i] = entry.getKey();
                }
            }
        }

        for (char c : uniqueChars) {
            boolean isUnique = true;
            for (char orderedChar : charOrder) {
                if (c == orderedChar) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                charOrder[0] = c;
            }
        }

        for (char c : charOrder) {
            System.out.print(c);
        }
        System.out.println();
    }
}