import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static void test() throws IOException {
        StringBuilder total = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader("data/testIn"))) {
            String s;
            while ((s = read.readLine()) != null) {
                total.append(s).append("\n");
            }
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes(StandardCharsets.UTF_8));
        System.setIn(testInput);
    }

    public static void main(String[] args) throws IOException {
        // Uncomment the line below to enable test mode
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
        }

        for (int i = 1; i < sliceSizes.length; i++) {
            if (sliceSizes[i] == sliceSizes[i - 1]) {
                duplicates++;
            }
        }

        if (duplicates + 1 >= diners) {
            return "0";
        }

        if (diners == 2) {
            return "1";
        }

        for (long sliceSize : sliceSizes) {
            if (set.contains(sliceSize * 2)) {
                return "1";
            }
        }

        return "2";
    }

    private static long[] getSlices(String line) {
        String[] snum = line.split(" ");
        long[] l = new long[snum.length];
        for (int i = 0; i < snum.length; i++) {
            l[i] = Long.parseLong(snum[i]);
        }
        return l;
    }
}