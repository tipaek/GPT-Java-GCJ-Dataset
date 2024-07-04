import java.util.*;

public class Solution {

    public static int getResult(List<Long> slices, int numPeople) {
        Collections.sort(slices, Collections.reverseOrder());
        Map<Long, Integer> freq = new HashMap<>();
        
        for (long slice : slices) {
            freq.put(slice, freq.getOrDefault(slice, 0) + 1);
        }
        
        for (long slice : freq.keySet()) {
            if (freq.get(slice) >= numPeople) {
                return 0;
            }
        }
        
        if (numPeople == 2) {
            return 1;
        }
        
        Set<Long> seen = new HashSet<>();
        for (long slice : slices) {
            if (seen.contains(slice * 2)) {
                return 1;
            }
            seen.add(slice);
        }
        
        return 2;
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
        
        scanner.close();
    }
}