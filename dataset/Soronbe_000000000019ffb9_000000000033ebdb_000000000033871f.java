import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final int MAX_LATENCY = 999_999;

    public static void main(String[] args) {
        // Now 2 stacks are +- even and the orders will alternate between stacks
        // every 2 order the order size increases by 2, but the difference in stacksize increases by 1

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            System.out.print(String.format("Case #%d:", i));
            solve(in);
        }

    }

    static class Computer {
        final int befores;
        int timeReached = -1;
        final Map<Integer, Computer> neighbours = new HashMap<>();

        Computer(int befores) {
            this.befores = befores;
        }

        public int getBefores() {
            return befores;
        }


        public Map<Integer, Computer> getNeighbours() {
            return neighbours;
        }

        public int getTimeReached() {
            return timeReached;
        }

        public void setTimeReached(int timeReached) {
            this.timeReached = timeReached;
        }
    }

    public static void solve(Scanner sc) {
        int C = sc.nextInt();
        int D = sc.nextInt();

        Computer[] computers = new Computer[C];
        computers[0] = new Computer(0);
        computers[0].setTimeReached(0);

        for (int i = 1; i < C; ++i) {
            computers[i] = new Computer(-sc.nextInt());
        }

        int[] latencies = new int[D];

        for (int i = 0; i < D; ++i) {
            latencies[i] = MAX_LATENCY;
            Computer neighbour1 = computers[sc.nextInt() - 1];
            Computer neighbour2 = computers[sc.nextInt() - 1];

            neighbour1.getNeighbours().put(i, neighbour2);
            neighbour2.getNeighbours().put(i, neighbour1);
        }

        Arrays.sort(computers,
                Comparator.comparingInt(Computer::getBefores)
        );

        int time = 0;
        int reached = 1; // root
        for(Computer computer : computers) {
            if(computer.getTimeReached() >= 0) {
                continue; // root element
            }
            if(reached == computer.getBefores()) {
                ++time;
            }

            for(Map.Entry<Integer, Computer> neighbour: computer.getNeighbours().entrySet()) {
                Computer neighbouringComputer = neighbour.getValue();
                if(neighbouringComputer.getTimeReached() < 0) {
                    continue;
                }

                int latency = time - neighbouringComputer.getTimeReached();

                if(latency == 0) {
                    continue;
                }

                computer.setTimeReached(time);

                latencies[neighbour.getKey()]  = latency;
                break;

            }

            ++reached;
        }

        for(int latency: latencies) {
            System.out.print(" " + latency);
        }
        System.out.println();


    }


}
