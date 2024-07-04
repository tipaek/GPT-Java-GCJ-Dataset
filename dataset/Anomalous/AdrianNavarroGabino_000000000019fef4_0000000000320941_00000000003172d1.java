import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();

        for (int index = 1; index <= cases; index++) {
            int slices = sc.nextInt();
            int diners = sc.nextInt();
            Map<Long, Integer> sliceSizes = new HashMap<>();
            int cuts = diners - 1;
            boolean found = false;

            for (int i = 0; i < slices; i++) {
                Long size = sc.nextLong();
                sliceSizes.put(size, sliceSizes.getOrDefault(size, 0) + 1);
            }

            int maxValue = Collections.max(sliceSizes.values());

            if (diners <= maxValue) {
                cuts = 0;
            } else {
                for (int i = 1; i < diners - 1; i++) {
                    for (Map.Entry<Long, Integer> entry : sliceSizes.entrySet()) {
                        Long quotient = entry.getKey() / i;

                        if (quotient * i == entry.getKey() && sliceSizes.containsKey(quotient)) {
                            if (i + 1 + sliceSizes.get(quotient) >= diners) {
                                cuts = i;
                                found = true;
                                break;
                            }
                        } else {
                            if (i + 1 >= diners) {
                                cuts = i;
                                found = true;
                                break;
                            }
                        }
                    }
                    if (found) {
                        break;
                    }
                }
            }

            System.out.println("Case #" + index + ": " + cuts);
        }

        sc.close();
    }
}