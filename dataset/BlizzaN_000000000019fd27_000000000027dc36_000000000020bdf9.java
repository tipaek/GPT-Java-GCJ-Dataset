import java.io.*;
import java.util.*;

public class Solution {

    private static class SortPair implements Comparator<Pair> {
        @Override
        public int compare(Pair obj1, Pair obj2) {
            return obj1.getStartTime() - obj2.getStartTime();
        }
    }

    private static class Pair {
        private int startTime;
        private int endTime;

        Pair(int start, int end) {
            this.startTime = start;
            this.endTime = end;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }

    private static String solve2(List<Integer> time, int length) {
        StringBuilder sb = new StringBuilder();

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < time.size(); i += 2) {
            pairs.add(new Pair(time.get(i), time.get(i + 1)));
        }

        Collections.sort(pairs, new SortPair());


        int cameronStart = 0;
        int cameronEnd = 0;
        int jamieStart = 0;
        int jamieEnd = 0;
        for (int i = 0; i < length; i++) {
            if(i == 0){
                jamieStart = pairs.get(i).getStartTime();
                jamieEnd = pairs.get(i).getEndTime();
                sb.append("J");
                continue;
            }
            if (cameronEnd <= pairs.get(i).getStartTime()) {
                cameronStart = pairs.get(i).getStartTime();
                cameronEnd = pairs.get(i).getEndTime();
                sb.append("C");

            } else if (jamieEnd <= pairs.get(i).getStartTime()) {
                jamieStart = pairs.get(i).getStartTime();
                jamieEnd = pairs.get(i).getEndTime();
                sb.append("J");
            } else {
                return "IMPOSSIBLE";
            }


        }
        //JCCJJ


        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        //InputStream is = new FileInputStream("src/main/resources/qualification/ParentingReturn");
        InputStream is = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                StringBuilder sb = new StringBuilder();
                int input = scanner.nextInt();

                List<Integer> time = new ArrayList<>();

                for (int i = 0; i < input; i++) {
                    time.add(scanner.nextInt());
                    time.add(scanner.nextInt());
                }


                System.out.println("Case #" + testNumber + ": " + solve2(time, input));

            }
        }
    }

}
