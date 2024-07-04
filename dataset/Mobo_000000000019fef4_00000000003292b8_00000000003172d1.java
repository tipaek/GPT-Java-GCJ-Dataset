import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int problemNumber = 0; problemNumber < T; problemNumber++) {
            //read input for each problem
            int nSlices = in.nextInt();
            int diners = in.nextInt();
            List<Long> sizes = new ArrayList<>();
            for (int i = 0; i < nSlices; i++) {
                sizes.add(in.nextLong());
            }

            solveProblem(problemNumber + 1, nSlices, diners, sizes);
        }
    }

    private static void solveProblem(int T, int nSlices, int diners, List<Long> sliceSizes) {
        Collections.sort(sliceSizes);

        List<Slice> slices = new ArrayList<>();
        for (int i = 0; i < sliceSizes.size(); i++) {
            if (slices.stream().map(s -> s.size).collect(Collectors.toList()).contains(sliceSizes.get(i))) {
                Slice slice = slices.get(slices.size() - 1);
                slice.amount++;
            } else {
                Slice toAdd = new Slice();
                toAdd.size = sliceSizes.get(i);
                toAdd.amount = 1;
                slices.add(toAdd);
            }
        }

        List<Integer> amounts = slices.stream().map(s -> s.amount).collect(Collectors.toList());
        List<Long> sizes = slices.stream().map(s -> s.size).sorted().collect(Collectors.toList());


        if (diners == 2) {
            if (amounts.contains(diners)) {
                System.out.println("Case #" + T + ": 0");
                return;
            } else {
                System.out.println("Case #" + T + ": 1");
                return;
            }
        }


        if (amounts.contains(diners)) {
            System.out.println("Case #" + T + ": 0");
            return;
        }
        if (amounts.contains(diners - 1)) {
            List<Slice> slicesWithCertainAmount = slices.stream().filter(s -> s.amount == (diners - 1))
                .sorted(Comparator.comparing(s -> s.size)).collect(Collectors.toList());
           // long minSize = slicesWithCertainAmount.get(0).size;
           // if (minSize < sizes.get(sizes.size()-1)) { //minsize < maxSize
                System.out.println("Case #" + T + ": 1");
                return;
           // }
        }

        for (long size : sizes) {
            if (sizes.contains(2*size)) {
                System.out.println("Case #" + T + ": 1");
                return;
            }
        }

        System.out.println("Case #" + T + ": 2");
    }

    public static class Slice {
        long size;
        int amount;
    }
}