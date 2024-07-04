import java.io.*;
import java.util.*;

public class Solution {

    private static void test() throws IOException {
        StringBuilder total = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader("data/testIn"))) {
            String line;
            while ((line = read.readLine()) != null) {
                total.append(line).append("\n");
            }
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes("UTF-8"));
        System.setIn(testInput);
    }

    public static void main(String[] args) throws IOException {
        // Uncomment the next line to run the test method
        // test();
        
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(in.nextLine());
            for (int x = 1; x <= t; ++x) {
                System.out.println("Case #" + x + ": " + getResult(in.nextLine(), in.nextLine()));
            }
        }
    }

    private static String getResult(String targetString, String sliceString) {
        String[] settings = targetString.split(" ");
        int diners = Integer.parseInt(settings[1]);
        long[] sliceSizes = getSlices(sliceString);
        Arrays.sort(sliceSizes);

        Map<Long, Integer> map = new HashMap<>();
        Set<Long> set = new HashSet<>();
        int duplicates = 0;

        for (long size : sliceSizes) {
            map.put(size, map.getOrDefault(size, 0) + 1);
            set.add(size);
            if (map.get(size) > 1) {
                duplicates++;
            }
        }

        if (duplicates + 1 >= diners) return "0";
        if (diners == 2 || duplicates + 1 >= diners) return "1";

        for (long size : sliceSizes) {
            if (set.contains(size * 2)) return "1";
        }

        return "2";
    }

    private static long[] getSlices(String line) {
        return Arrays.stream(line.split(" "))
                     .mapToLong(Long::parseLong)
                     .toArray();
    }
}