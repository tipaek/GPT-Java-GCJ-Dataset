import java.util.*;

public class Solution {

    public static int getResult(List<Long> slices, int numPeople) {
        Collections.sort(slices, Collections.reverseOrder());
        Map<Long, Integer> frequencyMap = new HashMap<>();
        
        for (long slice : slices) {
            frequencyMap.put(slice, frequencyMap.getOrDefault(slice, 0) + 1);
        }
        
        int maxFrequency = Collections.max(frequencyMap.values());
        
        if (maxFrequency >= numPeople) return 0;
        if (numPeople == 2) return 1;
        
        if (maxFrequency == 2) {
            for (int i = 0; i < slices.size() - 1; i++) {
                if (slices.get(i).equals(slices.get(i + 1))) {
                    if (i != 0) return 1;
                }
            }
        }
        
        Set<Long> seenSlices = new HashSet<>();
        for (long slice : slices) {
            if (seenSlices.contains(slice * 2)) return 1;
            seenSlices.add(slice);
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