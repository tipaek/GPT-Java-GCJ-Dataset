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
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(USER_DIR + "/io/" + CNAME + ".in");
        Scanner scanner = inputFile.exists() ? new Scanner(inputFile) : new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int U = scanner.nextInt();
            TreeSet<Character> characters = new TreeSet<>();
            TreeMap<Character, Integer> firstCharCount = new TreeMap<>();
            TreeMap<Character, Integer> totalCharCount = new TreeMap<>();

            for (int i = 0; i < 10000; i++) {
                scanner.nextInt();
                String response = scanner.next().trim();
                if (response.isEmpty()) continue;

                char firstChar = response.charAt(0);
                firstCharCount.put(firstChar, firstCharCount.getOrDefault(firstChar, 0) + 1);
                for (char ch : response.toCharArray()) {
                    characters.add(ch);
                    totalCharCount.put(ch, totalCharCount.getOrDefault(ch, 0) + 1);
                }
            }

            char zeroChar = 0;
            for (char ch : characters) {
                if (!firstCharCount.containsKey(ch)) {
                    zeroChar = ch;
                    break;
                }
            }

            totalCharCount.remove(zeroChar);

            TreeMap<Integer, Character> reversedFirstCharCount = new TreeMap<>(Collections.reverseOrder());
            for (Map.Entry<Character, Integer> entry : firstCharCount.entrySet()) {
                reversedFirstCharCount.put(entry.getValue(), entry.getKey());
            }

            TreeMap<Integer, Character> reversedTotalCharCount = new TreeMap<>(Collections.reverseOrder());
            for (Map.Entry<Character, Integer> entry : totalCharCount.entrySet()) {
                reversedTotalCharCount.put(entry.getValue(), entry.getKey());
            }

            StringBuilder result = new StringBuilder();
            result.append(zeroChar);
            for (char ch : reversedTotalCharCount.values()) {
                result.append(ch);
            }

            System.out.format("Case #%d: %s\n", t, result.toString());
        }
        scanner.close();
    }
}