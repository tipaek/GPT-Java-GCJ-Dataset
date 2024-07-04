import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
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
        // Uncomment the line below to run the test method
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

        Set<Long> set = new HashSet<>();
        int currentDuplicates = 1;
        int maxDuplicates = 1;
        long maxNum = -1;

        for (int i = 0; i < sliceSizes.length; i++) {
            long size = sliceSizes[i];
            set.add(size);
            if (i > 0 && size == sliceSizes[i - 1]) {
                currentDuplicates++;
                if (currentDuplicates > maxDuplicates) {
                    maxDuplicates = currentDuplicates;
                    maxNum = size;
                }
            } else {
                currentDuplicates = 1;
            }
        }

        if (maxDuplicates >= diners) return "0";
        if (diners == 2 || (maxDuplicates > 1 && maxNum != sliceSizes[sliceSizes.length - 1])) return "1";
        for (long sliceSize : sliceSizes) {
            if (set.contains(sliceSize * 2)) return "1";
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