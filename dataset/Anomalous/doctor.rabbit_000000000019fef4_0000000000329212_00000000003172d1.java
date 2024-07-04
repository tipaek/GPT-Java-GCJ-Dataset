import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String numOfCases = in.nextLine();
        int currentCase = 1;

        while (in.hasNextLine()) {
            String inputNandD = in.nextLine();
            String sliceDetail = in.nextLine();

            String[] NandDArray = inputNandD.split(" ");
            String[] sliceInfoArray = sliceDetail.split(" ");

            int slicesN = Integer.parseInt(NandDArray[0]);
            int dinersD = Integer.parseInt(NandDArray[1]);

            Map<Long, Integer> sliceMap = new HashMap<>();
            for (String slice : sliceInfoArray) {
                long sliceSize = Long.parseLong(slice);
                sliceMap.put(sliceSize, sliceMap.getOrDefault(sliceSize, 0) + 1);
            }

            List<Long> sufficientSlices = sliceMap.entrySet().stream()
                    .filter(entry -> entry.getValue() >= dinersD)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            if (!sufficientSlices.isEmpty()) {
                System.out.println("Case #" + currentCase + ": " + 0);
            } else {
                System.out.println("Case #" + currentCase + ": " + (dinersD - 1));
            }

            currentCase++;
        }
    }
}