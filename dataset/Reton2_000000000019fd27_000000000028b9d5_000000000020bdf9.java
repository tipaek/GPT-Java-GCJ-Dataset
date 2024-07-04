import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int times = scanner.nextInt();

        for (int i = 0; i < times; i++)
        {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            Person cam = new Person("C");
            Person jam = new Person("J");
            List<Interval> intervals = new ArrayList<>();
            for (int j = 0; j < n; j ++)
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
            for (Interval current : intervals)
            {
                if (cam.isFree(current))
                    result.append(cam.addActivity(current));
                else if (jam.isFree(current))
                    result.append(jam.addActivity(current));
                else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + result);
        }

    }

    private static class Person
    {
        List<Interval> intervals;
        private String rep;

        Person(String image)
        {
            intervals = new ArrayList<>();
            rep = image;
        }

        public boolean isFree(Interval interval)
        {
            boolean result = false;
            for (Interval i : intervals)
                result = result || i.within(interval);
            return !result;
        }

        public String addActivity(Interval interval)
        {
            intervals.add(interval);
            return rep;
        }

    }

    private static class Interval
    {
        private int start;
        private int end;

        public Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
        }

        public Interval(String string)
        {
            List<Integer> integers = Arrays.stream(string.split("[\\s]")).map(Integer::parseInt)
                    .collect(Collectors.toList());
            this.start = integers.get(0);
            this.end = integers.get(1);
        }

        boolean within(Interval interval)
        {
            if (start == interval.start || end == interval.end)
                return true;
            if (start < interval.start && end > interval.start)
                return true;
            return start < interval.end && end > interval.end;
        }
    }

}
