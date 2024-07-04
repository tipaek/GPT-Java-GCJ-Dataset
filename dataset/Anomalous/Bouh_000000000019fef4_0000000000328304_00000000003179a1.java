import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String result = solveProblem(scanner);
        System.out.println(result);
    }

    public static String solveProblem(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int U = scanner.nextInt();
            List<String> words = new ArrayList<>();
            for (int j = 0; j < 10000; j++) {
                scanner.nextInt();
                words.add(scanner.next());
            }
            result.append("Case #").append(i).append(": ").append(solveCase(words)).append("\n");
        }
        return result.toString().trim();
    }

    public static String solveCase(List<String> words) {
        final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        for (char c : ALPHABET.toCharArray()) {
            frequencyMap.put(String.valueOf(c), 0);
        }
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                String letter = String.valueOf(c);
                frequencyMap.put(letter, frequencyMap.get(letter) + 1);
            }
        }
        
        List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
        frequencies.removeIf(frequency -> frequency == 0);
        
        if (frequencies.size() != 10) {
            throw new RuntimeException("There must be exactly 10 distinct characters.");
        }
        
        Collections.sort(frequencies);
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < 10; i++) {
            result.append(findCharacterByFrequency(frequencies.get(i), frequencyMap));
        }
        
        return result.toString();
    }

    public static String findCharacterByFrequency(int frequency, Map<String, Integer> frequencyMap) {
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue().equals(frequency)) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("Character with the specified frequency not found.");
    }
}