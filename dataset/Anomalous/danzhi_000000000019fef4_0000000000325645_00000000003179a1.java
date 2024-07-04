import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.*;

// 2020 CodeJam Round 1C Problem 2
public class Solution {
    // The complete absolute path from where the application was initialized.
    // For example: C:\Users\danzhi\workspace\CodeJam
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String CNAME = MethodHandles.lookup().lookupClass().getName();

    private static String join(Collection<?> objs) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = objs.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) sb.append(',');
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(USER_DIR + "/io/" + CNAME + ".in");
        Scanner scanner = inputFile.exists() ? new Scanner(inputFile) : new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
            int U = scanner.nextInt();
            List<String> responses = new ArrayList<>();

            for (int i = 0; i < 10000; i++) {
                scanner.nextInt(); // Read and discard Qi
                responses.add(scanner.next().trim());
            }

            TreeSet<Character> characters = new TreeSet<>();
            Map<Character, Integer> firstCharFrequency = new TreeMap<>();
            Map<Character, Integer> totalCharFrequency = new TreeMap<>();

            for (String response : responses) {
                char firstChar = response.charAt(0);
                firstCharFrequency.put(firstChar, firstCharFrequency.getOrDefault(firstChar, 0) + 1);

                for (char ch : response.toCharArray()) {
                    characters.add(ch);
                    totalCharFrequency.put(ch, totalCharFrequency.getOrDefault(ch, 0) + 1);
                }
            }

            char zeroChar = findZeroChar(characters, firstCharFrequency);

            totalCharFrequency.remove(zeroChar);
            String result = buildResultString(zeroChar, totalCharFrequency);

            System.out.format("Case #%d: %s\n", t, result);
        }
        scanner.close();
    }

    private static char findZeroChar(Set<Character> characters, Map<Character, Integer> firstCharFrequency) {
        for (char ch : characters) {
            if (!firstCharFrequency.containsKey(ch)) {
                return ch;
            }
        }
        throw new IllegalStateException("No zero character found");
    }

    private static String buildResultString(char zeroChar, Map<Character, Integer> totalCharFrequency) {
        TreeMap<Integer, Character> sortedCharFrequency = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Character, Integer> entry : totalCharFrequency.entrySet()) {
            sortedCharFrequency.put(entry.getValue(), entry.getKey());
        }

        StringBuilder result = new StringBuilder();
        result.append(zeroChar);
        for (char ch : sortedCharFrequency.values()) {
            result.append(ch);
        }
        return result.toString();
    }
}