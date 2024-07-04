import java.io.*;
import java.util.*;

public class Solution {

    private static void test() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("data/testIn"));
        StringBuilder total = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            total.append(line).append("\n");
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes("UTF-8"));
        System.setIn(testInput);
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        // Uncomment the following line to use test input from a file
        // test();
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            String targetString = scanner.nextLine();
            String sliceString = scanner.nextLine();
            System.out.println("Case #" + i + ": " + getResult(targetString, sliceString));
        }
        scanner.close();
    }

    private static String getResult(String targetString, String sliceString) {
        String[] settings = targetString.split(" ");
        int diners = Integer.parseInt(settings[1]);
        long[] sliceSizes = getSlices(sliceString);
        Arrays.sort(sliceSizes);
        Map<Long, Integer> sliceCountMap = new HashMap<>();
        Set<Long> uniqueSlices = new HashSet<>();
        int duplicates = 0;

        for (long size : sliceSizes) {
            sliceCountMap.put(size, sliceCountMap.getOrDefault(size, 0) + 1);
            uniqueSlices.add(size);
            if (sliceCountMap.get(size) > 1) {
                duplicates++;
            }
        }

        if (duplicates + 1 >= diners) {
            return "0";
        }

        if (diners == 2 || duplicates + 2 >= diners) {
            return "1";
        }

        for (long size : sliceSizes) {
            if (uniqueSlices.contains(size * 2)) {
                return "1";
            }
        }

        return "2";
    }

    private static long[] getSlices(String line) {
        String[] sliceStrings = line.split(" ");
        long[] slices = new long[sliceStrings.length];
        for (int i = 0; i < sliceStrings.length; i++) {
            slices[i] = Long.parseLong(sliceStrings[i]);
        }
        return slices;
    }
}