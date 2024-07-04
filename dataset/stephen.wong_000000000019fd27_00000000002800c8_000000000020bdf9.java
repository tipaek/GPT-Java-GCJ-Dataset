
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final Resource C = new Resource("C");
    private static final Resource J = new Resource("J");

    private final int id;
    private final Map<Integer, Point> schedule;
    private final List<Resource> resourcePool;
    private final List<Resource> workingPool;
    private String output;
    private final Map<Integer, String> result;

    public Solution(int id) {
        this.id = id;
        this.schedule = new HashMap<>();
        this.resourcePool = new ArrayList<>();
        this.workingPool = new ArrayList<>();
        this.result = new HashMap<>();
    }

    void addStartingPoint(int slot, int index) {
        schedule.computeIfAbsent(index, idx -> new Point(index))
            .begins.add(slot);
    }

    void addEndingPoint(int slot, int index) {
        schedule.computeIfAbsent(index, idx -> new Point(index))
            .ends.add(slot);
    }

    void solve() {
        initResourcePool();
        List<Point> points = schedule.entrySet().stream()
            .sorted(Comparator.comparingInt(Map.Entry::getKey))
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());

        int n = resourcePool.size();
        for (Point point : points) {
            n += point.ends.size();
            n -= point.begins.size();

            if (n < 0) {
                this.output = IMPOSSIBLE;
                return;
            }

            releaseResource(point);
            allocateResource(point);
        }
        this.output = result.entrySet().stream()
            .sorted(Comparator.comparingInt(Map.Entry::getKey))
            .map(Map.Entry::getValue)
            .collect(Collectors.joining());
    }

    private void releaseResource(Point point) {
        for (Integer end : point.ends) {
            Resource toRelease = workingPool.stream()
                .filter(resource -> end == resource.slotId)
                .findFirst().orElseThrow(IllegalStateException::new);
            workingPool.remove(toRelease);
            toRelease.slotId = -1;
            resourcePool.add(toRelease);
        }
    }

    private void allocateResource(Point point) {
        for (Integer begin : point.begins) {
            Resource resource = resourcePool.remove(0);
            resource.slotId = begin;
            workingPool.add(resource);
            result.put(resource.slotId, resource.name);
        }
    }

    private void initResourcePool() {
        resourcePool.add(C);
        resourcePool.add(J);
    }

    static class Resource {
        private final String name;
        private int slotId = -1;

        Resource(String name) {
            this.name = name;
        }
    }

    static class Point {
        private final int index;
        private final Set<Integer> begins;
        private final Set<Integer> ends;

        Point(int index) {
            this.index = index;
            this.begins = new HashSet<>();
            this.ends = new HashSet<>();
        }
    }

    @Override
    public String toString() {
        return "Case #" + id + ": " + output;
    }

    static void processInput(InputStream inputStream) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));

        int tests = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
            Solution solution = new Solution(testNumber);

            int size = Integer.parseInt(in.nextLine());
            for (int slot = 0; slot < size; slot++) {
                String[] input = in.nextLine().split(" ");
                int begin = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                solution.addStartingPoint(slot, begin);
                solution.addEndingPoint(slot, end);
            }

            solution.solve();

            System.out.println(solution);
        }
    }

    public static void main(String[] args) {
        processInput(System.in);
    }
}
