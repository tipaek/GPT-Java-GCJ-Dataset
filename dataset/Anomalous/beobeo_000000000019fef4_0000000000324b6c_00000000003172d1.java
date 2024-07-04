import java.util.*;

public class Solution {

    public static int getResult(List<Long> slices, int numPeople) {
        Collections.sort(slices, Collections.reverseOrder());
        Map<Long, Integer> freq = new HashMap<>();
        for (long slice : slices) {
            freq.put(slice, freq.getOrDefault(slice, 0) + 1);
        }
        
        int maxFreq = freq.values().stream().max(Integer::compare).orElse(Integer.MIN_VALUE);
        
        if (maxFreq >= numPeople) return 0;
        if (numPeople == 2) return 1;
        
        if (maxFreq == 2) {
            int index = -1;
            for (int i = 0; i < slices.size() - 1; i++) {
                if (slices.get(i).equals(slices.get(i + 1))) index = i;
            }
            return (index != 0) ? 1 : 2;
        } else {
            Set<Long> seen = new HashSet<>();
            for (long slice : slices) {
                if (seen.contains(slice * 2)) return 1;
                seen.add(slice);
            }
            return 2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int numSlices = scanner.nextInt();
            int numPeople = scanner.nextInt();
            List<Long> slices = new ArrayList<>();
            
            for (int j = 0; j < numSlices; j++) {
                slices.add(scanner.nextLong());
            }
            
            System.out.println("Case #" + (i + 1) + ": " + getResult(slices, numPeople));
        }
    }
}