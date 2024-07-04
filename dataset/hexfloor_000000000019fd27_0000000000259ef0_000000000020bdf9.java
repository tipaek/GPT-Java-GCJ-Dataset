

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < t; ++i) {
            int n = in.nextInt();
            in.nextLine();

            List<Activity> list = IntStream.range(0, n)
                    .mapToObj(v -> toActivity(v, in.nextLine()))
                    .sorted()
                    .collect(Collectors.toList());

            String result = solve(list);
            String answer = "Case #" + (i + 1) + ": " + result;
            out.write(answer);
            out.newLine();
        }
        in.close();
        out.close();

    }

    static String solve(List<Activity> list) {
        Summary summary = schedule(list);
        if (!summary.todo.isEmpty()) {
            return "IMPOSSIBLE";
        }
        Set<Integer> set1 = summary.done1.stream().map(activity -> activity.id).collect(Collectors.toSet());
        return IntStream.range(0, list.size())
                .map(i -> set1.contains(i) ? 'J' : 'C')
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }


    static Summary schedule(List<Activity> list) {
        Summary summary = new Summary();
        int index1 = 0;
        int index2 = -1;
        summary.done1.add(list.get(index1));
        for (int i = 1; i< list.size(); i++) {
            if (list.get(i).start >= list.get(index1).end){
                summary.done1.add(list.get(i));
                index1 = i;
            } else if (index2 < 0 || list.get(i).start >= list.get(index2).end){
                summary.done2.add(list.get(i));
                index2 = i;
            } else {
                summary.todo.add(list.get(i));
            }
        }
        return summary;
    }

    static class Summary{
        List<Activity> done1 = new ArrayList<>();
        List<Activity> done2 = new ArrayList<>();
        List<Activity> todo = new ArrayList<>();
    }

    private static Activity toActivity(int id, String s) {
        int[] a = Arrays.stream(s.split(" ", 2)).mapToInt(Integer::parseInt).toArray();
        return new Activity(id, a[0], a[1]);
    }

    static class Activity implements Comparable<Activity> {
        int id;
        int start;
        int end;

        public Activity(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity that) {
            return Integer.compare(this.end, that.end);
        }
    }

}