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
            List<String> words = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                scanner.nextInt();
                words.add(scanner.next());
            }

            TreeSet<Character> characters = new TreeSet<>();
            Map<Character, Integer> frequencyMap = new TreeMap<>();

            for (String word : words) {
                char firstChar = word.charAt(0);
                frequencyMap.put(firstChar, frequencyMap.getOrDefault(firstChar, 0) + 1);
                for (char c : word.toCharArray()) {
                    characters.add(c);
                }
            }

            char zeroChar = 0;
            for (char c : characters) {
                if (!frequencyMap.containsKey(c)) {
                    zeroChar = c;
                    break;
                }
            }

            Map<Integer, Character> sortedFrequencyMap = new TreeMap<>(Collections.reverseOrder());
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                sortedFrequencyMap.put(entry.getValue(), entry.getKey());
            }

            StringBuilder result = new StringBuilder();
            result.append(zeroChar);
            for (char c : sortedFrequencyMap.values()) {
                result.append(c);
            }

            System.out.format("Case #%d: %s\n", t, result.toString());
        }
        scanner.close();
    }
}