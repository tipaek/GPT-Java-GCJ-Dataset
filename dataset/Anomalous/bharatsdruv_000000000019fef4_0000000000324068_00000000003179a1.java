import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int tc = 1; tc <= testCases; tc++) {
            int U = scanner.nextInt();
            HashMap<Character, Integer> charMap = new HashMap<>();
            ArrayList<String> stringList = new ArrayList<>();
            ArrayList<Integer> intList = new ArrayList<>();
            
            for (int i = 0; i < 10000; i++) {
                int Mi = scanner.nextInt();
                String s = scanner.next();
                
                if (s.length() == 1) {
                    char c = s.charAt(0);
                    charMap.put(c, Math.min(charMap.getOrDefault(c, Mi), Mi));
                } else {
                    stringList.add(s);
                    intList.add(Mi);
                }
            }
            
            int uniqueChars = charMap.size();
            int remaining = 10 - uniqueChars;
            int index = 0;
            
            while (remaining > 0 && index < stringList.size()) {
                char firstChar = stringList.get(index).charAt(0);
                int firstCharValue = intList.get(index) / 10;
                char secondChar = stringList.get(index).charAt(1);
                int secondCharValue = intList.get(index) % 10;
                index++;
                
                if (charMap.containsKey(firstChar) && charMap.get(firstChar) == firstCharValue) {
                    charMap.put(secondChar, Math.min(charMap.getOrDefault(secondChar, secondCharValue), secondCharValue));
                } else if (charMap.containsKey(secondChar) && charMap.get(secondChar) == secondCharValue) {
                    charMap.put(firstChar, Math.min(charMap.getOrDefault(firstChar, firstCharValue), firstCharValue));
                }
            }
            
            char[] characters = new char[10];
            int[] values = new int[10];
            int count = 0;
            
            for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                characters[count] = entry.getKey();
                values[count] = entry.getValue();
                count++;
            }
            
            for (int i = 0; i < 10; i++) {
                for (int j = 1; j < (10 - i); j++) {
                    if (values[j - 1] > values[j]) {
                        int tempValue = values[j - 1];
                        values[j - 1] = values[j];
                        values[j] = tempValue;
                        
                        char tempChar = characters[j - 1];
                        characters[j - 1] = characters[j];
                        characters[j] = tempChar;
                    }
                }
            }
            
            StringBuilder result = new StringBuilder();
            for (char c : characters) {
                result.append(c);
            }
            
            System.out.println("Case #" + tc + ": " + result);
        }
        
        scanner.close();
    }
}