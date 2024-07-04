

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
        Summary summary1 = schedule(list);
        if (summary1.todo.isEmpty()) {
            return IntStream.range(0, list.size())
                    .map(i -> 'J')
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }
        Summary summary2 = schedule(summary1.todo);
        if (!summary2.todo.isEmpty()) {
            return "IMPOSSIBLE";
        }
        Set<Integer> set1 = summary1.done.stream().map(activity -> activity.id).collect(Collectors.toSet());
        return IntStream.range(0, list.size())
                .map(i -> set1.contains(i) ? 'J' : 'C')
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }


    static Summary schedule(List<Activity> list) {
        Summary summary = new Summary();
        int currentIndex = 0;
        summary.done.add(list.get(currentIndex));
        for (int i = 1; i< list.size(); i++) {
            if (list.get(i).start >= list.get(currentIndex).end){
                summary.done.add(list.get(i));
                currentIndex = i;
            } else {
                summary.todo.add(list.get(i));
            }
        }
        return summary;
    }

    static class Summary{
        List<Activity> done = new ArrayList<>();
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