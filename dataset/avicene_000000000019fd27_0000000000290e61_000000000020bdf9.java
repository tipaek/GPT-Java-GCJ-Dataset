import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
    private int start;
    private int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return start == pair.start &&
                end == pair.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.valueOf(in.nextLine());
        StringBuilder result = new StringBuilder();

        for (int z=0;z < cases;++z) {
            Map<String, List<Pair>> m = new HashMap<>();
            m.putIfAbsent("C", new ArrayList<>());
            m.putIfAbsent("J", new ArrayList<>());
            StringBuilder sb = new StringBuilder();

            int t = Integer.valueOf(in.nextLine());
            for (int i=0;i < t;++i) {
                String line  = in.nextLine();
                int[] tokens = Arrays.stream(line.split(" ")).mapToInt(Integer::valueOf).toArray();
                Pair pair = new Pair(tokens[0], tokens[1]);
                if (!isConflict(m.get("C"), pair)) {
                    sb.append("C");
                    m.get("C").add(pair);
                } else if (!isConflict(m.get("J"), pair)) {
                    sb.append("J");
                    m.get("J").add(pair);
                } else {
                    sb = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            result.append("Case #").append(z + 1).append(": ").append(sb.toString()).append("\n");
        }

        System.out.println(result.toString());
        in.close();
    }

    static boolean isConflict(List<Pair> l,  Pair pair) {
        for (Pair p: l) {
            if (pair.getStart() > p.getEnd()) return false;
            if (pair.getEnd() > p.getStart() && pair.getEnd() <= p.getEnd()) return true;
            if (pair.getStart() >= p.getStart() && pair.getStart() < p.getEnd()) return true;
        }

        return false;
    }
}