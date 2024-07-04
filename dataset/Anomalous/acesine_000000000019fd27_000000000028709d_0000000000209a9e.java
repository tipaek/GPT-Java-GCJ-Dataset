import java.util.*;

public class Solution {
    private final Scanner scanner = new Scanner(System.in);

    private void flipBits(StringBuilder builder) {
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) != 'x') {
                builder.setCharAt(i, builder.charAt(i) == '0' ? '1' : '0');
            }
        }
    }

    private void reverseString(StringBuilder builder) {
        int left = 0, right = builder.length() - 1;
        while (left < right) {
            char temp = builder.charAt(left);
            builder.setCharAt(left, builder.charAt(right));
            builder.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    private void applyTransformations(Map<String, String> map) {
        Map<String, String> originalMap = new HashMap<>(map);
        map.clear();
        for (String key : originalMap.keySet()) {
            StringBuilder valueBuilder = new StringBuilder(originalMap.get(key)).append('0');
            map.put(key, valueBuilder.toString());

            StringBuilder transformedKey = new StringBuilder(key);
            flipBits(transformedKey);
            valueBuilder.setCharAt(valueBuilder.length() - 1, '1');
            map.put(transformedKey.toString(), valueBuilder.toString());

            transformedKey = new StringBuilder(key);
            reverseString(transformedKey);
            valueBuilder.setCharAt(valueBuilder.length() - 1, '2');
            map.put(transformedKey.toString(), valueBuilder.toString());

            transformedKey = new StringBuilder(key);
            flipBits(transformedKey);
            reverseString(transformedKey);
            valueBuilder.setCharAt(valueBuilder.length() - 1, '3');
            map.put(transformedKey.toString(), valueBuilder.toString());
        }
    }

    private boolean isValid(Map<String, String> map) {
        if (map.size() != 1) return false;
        String key = map.keySet().iterator().next();
        for (char c : key.toCharArray()) {
            if (c == 'x') return false;
        }
        return true;
    }

    private int selectPosition(Set<String> keys) {
        List<String> keyList = new ArrayList<>(keys);
        int length = keyList.get(0).length();
        int minDiffIndex = -1, minDiff = Integer.MAX_VALUE;
        int maxUnknownIndex = -1, maxUnknownCount = 0;

        for (int i = 0; i < length; i++) {
            int ones = 0, zeros = 0, unknowns = 0;
            for (String key : keyList) {
                char c = key.charAt(i);
                if (c == '1') ones++;
                else if (c == '0') zeros++;
                else unknowns++;
            }
            if (ones != 0 && zeros != 0 && Math.abs(ones - zeros) < minDiff) {
                minDiff = Math.abs(ones - zeros);
                minDiffIndex = i;
            }
            if (unknowns > maxUnknownCount) {
                maxUnknownCount = unknowns;
                maxUnknownIndex = i;
            }
        }
        return minDiffIndex != -1 ? minDiffIndex : maxUnknownIndex;
    }

    private void solve() {
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        while (testCases-- > 0) {
            Map<String, String> map = new TreeMap<>();
            StringBuilder initialKey = new StringBuilder(bitLength);
            for (int i = 0; i < bitLength; i++) {
                initialKey.append('x');
            }
            map.put(initialKey.toString(), "0");

            int iteration = 0;
            while (iteration < 150) {
                if (isValid(map)) break;
                if (iteration > 0 && iteration % 10 == 0) {
                    applyTransformations(map);
                }
                int selectedPosition = iteration < bitLength ? iteration % bitLength : selectPosition(map.keySet());
                System.out.println(selectedPosition + 1);
                char value = (char) ('0' + scanner.nextInt());

                Map<String, String> newMap = new HashMap<>();
                for (String key : map.keySet()) {
                    if (key.charAt(selectedPosition) != 'x' && key.charAt(selectedPosition) != value) continue;
                    StringBuilder newKey = new StringBuilder(key);
                    newKey.setCharAt(selectedPosition, value);
                    newMap.put(newKey.toString(), map.get(key));
                }
                map = newMap;
                iteration++;
            }
            System.out.println(map.keySet().iterator().next());
            if (!scanner.next().equals("Y")) throw new RuntimeException("Unexpected input");
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}