import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        in.nextLine();
        for (int id = 1; id <= t; id++) {
            solution(in, id);
        }
    }

    private static void solution(Scanner in, int id) {
        int computer_count = in.nextInt();
        int connection_count = in.nextInt();

        ArrayList<Graph> computers = new ArrayList<>();
        computers.add(new Graph(1, 0));
        for(int i = 2; i <= computer_count; i++) {
            int info = in.nextInt();
            computers.add(new Graph(i, info));
        }
        computers.get(0).time_got = 0;

        ArrayList<Connection> connections = new ArrayList<>();
        for(int i = 0; i < connection_count; i++) {
            Graph a = computers.get(in.nextInt()-1);
            Graph b = computers.get(in.nextInt()-1);

            Connection c = new Connection();
            connections.add(c);
            a.connections.put(b, c);
            b.connections.put(a, c);
        }

        //Track computers that got update
        HashSet<Graph> got_update = new HashSet<>();
        got_update.add(computers.get(0));
        computers.remove(0);
        //Sort got update first to last
        computers.sort(Comparator.comparingInt(c -> ((Graph) c).info).reversed());

        //Where did they get it from?
        int time = 0;
        int info_prev = -100;
        next_comp: for(Graph computer : computers) {
            for(Map.Entry<Graph, Connection> neighbour : computer.connections.entrySet()) {
                if(neighbour.getKey().time_got == -1) continue;
                if(computer.info != info_prev) {
                    info_prev = computer.info;
                    time++;
                }
                computer.time_got = time;
                neighbour.getValue().assigned_to = time - neighbour.getKey().time_got;
                continue next_comp;
            }
            throw new IllegalStateException();
        }

        System.out.print("Case #" + id + ": ");
        System.out.println(connections.stream().map(c -> {
            if(c.assigned_to == -1) return "10000";
            return Integer.toString(c.assigned_to);
        }).collect(Collectors.joining(" ")));
    }
}

class Graph {
    HashMap<Graph, Connection> connections = new HashMap<>();
    int id = 0;
    int info = 0;
    int time_got = -1;

    public Graph(int id, int info) {
        this.id = id;
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        return id == graph.id &&
                info == graph.info &&
                Objects.equals(connections, graph.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class Connection {
    int assigned_to = -1;
}