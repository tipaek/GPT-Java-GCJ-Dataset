import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = s.nextInt();
        s.nextLine();
        for (int t = 1; t <= testCases; t++) {
            int comps = s.nextInt();
            int links = s.nextInt();
            List<Comp> x = IntStream.range(0, comps - 1).mapToObj(i -> new Comp(i+2, s.nextInt())).collect(Collectors.toList());
            x.add(0, new Comp(1, 0));

            Link[] lnk = IntStream.range(0, links).mapToObj(i -> new Link(i, s.nextInt(), s.nextInt())).toArray(k -> new Link[k]);

            solve(x, lnk);
            String latencies = Arrays.stream(lnk).sorted(Comparator.comparing(link -> link.num))
                    .map(l -> String.valueOf(l.latency)).collect(Collectors.joining(" "));

            System.out.format("Case #%d: %s\n", t, latencies);
        }
    }

    private static void solve(List<Comp> comps, Link[] links) {
        Net net = new Net();
        net.links = new List[comps.size() + 1];
        IntStream.range(1, net.links.length).forEach(i -> net.links[i] = new ArrayList<>());
        Arrays.stream(links).forEach(l -> {
            net.links[l.u].add(l);
            net.links[l.v].add(l);
        });

        boolean visited[] = new boolean[comps.size() + 1];
        visited[1] = true;

        int compTime = 1;

        Comp lastComp = comps.get(0);
        int[] compTimes = new int[comps.size() + 1];
        comps.sort(Comparator. <Comp> comparingInt(c -> c.finishedBefore).reversed());

        for (Comp comp : comps) {
            if (comp.finishedBefore != lastComp.finishedBefore) {
                compTime += comps.size();
            }
            compTimes[comp.num] = compTime;

            final int ct = compTime;
            net.links[comp.num].stream().filter(l -> visited[l.other(comp.num)]).forEach(l -> {
                l.latency = ct - compTimes[l.other(comp.num)];
            });

            visited[comp.num] = true;
            lastComp = comp;
        }

        Arrays.stream(links).filter(l -> l.latency == 0).forEach(l -> l.latency = 42);
    }

    static class Comp {
        int num;
        int finishedBefore;

        public Comp(int num, int finishedBefore) {
            this.num = num;
            this.finishedBefore = finishedBefore;
        }
    }

    static class Link {
        int num;
        int latency;
        int u;
        int v;

        public Link(int num, int u, int v) {
            this.num = num;
            this.u = u;
            this.v = v;
        }

        public int other(int x) {
            return x == u ? v : u;
        }
    }

    static class Net {
        List<Link>[] links;
    }

}