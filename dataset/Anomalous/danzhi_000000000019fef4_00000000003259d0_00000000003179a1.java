import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.*;

public class Solution {
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String CNAME = MethodHandles.lookup().lookupClass().getName();
    private static final Random RAND = new Random();

    private static String join(Collection<?> objs) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = objs.iterator();
        boolean first = true;
        while (it.hasNext()) {
            if (!first) sb.append(',');
            sb.append(it.next().toString());
            first = false;
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(USER_DIR + "/io/" + CNAME + ".in");
        Scanner scanner = inputFile.exists() ? new Scanner(inputFile) : new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int U = scanner.nextInt();
            TreeSet<Character> uniqueChars = new TreeSet<>();
            TreeMap<Character, Integer> firstCharFrequency = new TreeMap<>();
            TreeMap<Character, Integer> totalCharFrequency = new TreeMap<>();

            for (int i = 0; i < 10000; i++) {
                scanner.nextInt();
                String response = scanner.next().trim();
                char firstChar = response.charAt(0);
                firstCharFrequency.put(firstChar, firstCharFrequency.getOrDefault(firstChar, 0) + 1);

                for (char ch : response.toCharArray()) {
                    uniqueChars.add(ch);
                    totalCharFrequency.put(ch, totalCharFrequency.getOrDefault(ch, 0) + 1);
                }
            }

            char zeroChar = 0;
            for (char ch : uniqueChars) {
                if (!firstCharFrequency.containsKey(ch)) {
                    zeroChar = ch;
                    break;
                }
            }

            totalCharFrequency.remove(zeroChar);

            TreeMap<Integer, Character> sortedFirstCharFrequency = new TreeMap<>(Collections.reverseOrder());
            for (Map.Entry<Character, Integer> entry : firstCharFrequency.entrySet()) {
                sortedFirstCharFrequency.put(entry.getValue(), entry.getKey());
            }

            TreeMap<Integer, Character> sortedTotalCharFrequency = new TreeMap<>(Collections.reverseOrder());
            for (Map.Entry<Character, Integer> entry : totalCharFrequency.entrySet()) {
                sortedTotalCharFrequency.put(entry.getValue(), entry.getKey());
            }

            StringBuilder result = new StringBuilder();
            result.append(zeroChar);
            for (char ch : sortedTotalCharFrequency.values()) {
                result.append(ch);
            }

            System.out.format("Case #%d: %s\n", t, result.toString());
        }
        scanner.close();
    }
}