import java.util.*;

/**
 * Created by Sun on 4/3/2020.
 */
public class Solution {

    static final Comparator<Computer> compareTime = (o1, o2) -> Integer.compare(o1.time, o2.time);
    static final Comparator<Computer> compareRank = (o1, o2) -> Integer.compare(o1.rank, o2.rank);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < T; i++) {
            String[] input = scan.nextLine().split(" ");
            int C = Integer.parseInt(input[0]);
            int D = Integer.parseInt(input[1]);
            input = scan.nextLine().split(" ");
            List<Computer> computers = new ArrayList<>();
            computers.add(new Computer(0, 0, 0));
            for (String s : input) {
                computers.add(new Computer(computers.size(), Integer.parseInt(s)));
            }
            List<String> edges = new ArrayList<>();
            for (int j = 0; j < D; j++) {
                input = scan.nextLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);
                edges.add((u - 1) + "|" + (v - 1));
                computers.get(u - 1).direct.add(computers.get(v - 1));
                computers.get(v - 1).direct.add(computers.get(u - 1));
            }
            Map<String, Integer> latencies = handle(computers);
            StringBuilder sb = new StringBuilder(String.format("Case #%d:", i + 1));
            for (String edge : edges) {
                sb.append(" ");
                sb.append(latencies.get(edge));
            }
            System.out.println(sb);
        }
    }

    static Map<String, Integer> handle(List<Computer> computers) {
        Map<String, Integer> latencies = new HashMap<>();
        List<Computer> knownTime = new ArrayList<>();
        List<Computer> knownRank = new ArrayList<>();
        for (Computer computer : computers) {
            if (computer.time >= 0) {
                knownTime.add(computer);
            } else {
                knownRank.add(computer);
            }
        }
        knownTime.sort(compareTime);
        knownRank.sort(compareRank);
        while (!knownRank.isEmpty()) {
            Computer unknown = knownRank.remove(0);
            unknown.time = knownTime.get(unknown.rank - 1).time + 1;
            knownTime.add(unknown);
            knownTime.sort(compareTime);
        }
        resolveLatencies(knownTime, latencies);
        return latencies;
    }

    static void resolveLatencies(List<Computer> computers, Map<String, Integer> latencies) {
        for (Computer computer : computers) {
            for (Computer connected : computer.direct) {
                if (connected.time < 0 || connected.id < computer.id) {
                    continue;
                }
                String key = computer.id + "|" + connected.id;
                int latency = Math.abs(computer.time - connected.time);
                if (latency == 0) {
                    latency = 1; // this value doesn't matter
                }
                if (latencies.containsKey(key) && latencies.get(key) != latency) {
                    throw new IllegalStateException(String.format("key=%s, was %d, now %d", key, latencies.get(key), latency));
                }
                latencies.put(key, latency);
            }
        }
    }

    static class Computer {
        int id;
        int time = -1;
        int rank = -1; // how many computer strictly before
        List<Computer> direct;

        public Computer(int id, int info) {
            this.id = id;
            this.direct = new ArrayList<>();
            if (info > 0) {
                time = info;
            } else {
                rank = -info;
            }
        }

        public Computer(int id, int time, int rank) {
            this.id = id;
            this.time = time;
            this.rank = rank;
            this.direct = new ArrayList<>();
        }
    }
}
