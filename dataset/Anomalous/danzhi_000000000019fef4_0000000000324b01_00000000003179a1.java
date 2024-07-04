import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.*;

public class Solution {
    final static String USER_DIR = System.getProperty("user.dir");
    final static String CNAME = MethodHandles.lookup().lookupClass().getName();
    final static Random RAND = new Random();

    static String join(Collection<?> objs) {
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
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int U = scanner.nextInt();
            List<String> inputs = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                scanner.nextInt();
                inputs.add(scanner.next());
            }

            TreeSet<Character> uniqueChars = new TreeSet<>();
            Map<Character, Integer> firstCharCount = new TreeMap<>();
            Map<Character, Integer> charCount = new TreeMap<>();

            for (String value : inputs) {
                char firstChar = value.charAt(0);
                firstCharCount.put(firstChar, firstCharCount.getOrDefault(firstChar, 0) + 1);
                for (char c : value.toCharArray()) {
                    uniqueChars.add(c);
                    charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                }
            }

            char zeroChar = 0;
            for (char c : uniqueChars) {
                if (!firstCharCount.containsKey(c)) {
                    zeroChar = c;
                    break;
                }
            }

            charCount.remove(zeroChar);
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                System.out.format("%c %d\n", entry.getKey(), entry.getValue());
            }

            TreeMap<Integer, Character> reversedFirstCharCount = new TreeMap<>(Collections.reverseOrder());
            for (Map.Entry<Character, Integer> entry : firstCharCount.entrySet()) {
                reversedFirstCharCount.put(entry.getValue(), entry.getKey());
            }

            TreeMap<Integer, Character> reversedCharCount = new TreeMap<>(Collections.reverseOrder());
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                reversedCharCount.put(entry.getValue(), entry.getKey());
            }

            StringBuilder result = new StringBuilder();
            result.append(zeroChar);
            for (char c : reversedCharCount.values()) {
                result.append(c);
            }

            System.out.format("Case #%d: %s\n", t, result.toString());
        }
        scanner.close();
    }
}