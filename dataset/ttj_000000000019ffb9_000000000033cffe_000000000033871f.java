import java.util.*;

public class Solution {
    private static class Link {
        public int first;
        public int second;
        public int latency;
        public int index;

        public Link(int index, int first, int second) {
            this.first = first;
            this.second = second;
            this.index = index;
            this.latency = 1000000;
        }
    }

    private static class Node implements Comparable<Node> {
        public int position;
        public int otherComputers;

        public Node(int position, int otherComputers) {
            this.position = position;
            this.otherComputers = otherComputers;
        }

        public int compareTo(Node other) {
            return this.otherComputers - other.otherComputers;
        }
    }

    
    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }
    

    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int nodeCount = scanner.nextInt();
            int linkCount = scanner.nextInt();
            List<Node> nodeList = new ArrayList<>();
            for (int j = 2; j <= nodeCount; j++) {
                nodeList.add(new Node(j, -scanner.nextInt()));
            }
            HashMap<Integer, Set<Link>> linkMap = new HashMap<>();
            Link[] links = new Link[linkCount];
            for (int k = 0; k < linkCount; k++) {
                Link link = new Link(k, scanner.nextInt(), scanner.nextInt());
                if (!linkMap.containsKey(link.first)) {
                    linkMap.put(link.first, new HashSet<>());
                }
                if (!linkMap.containsKey(link.second)) {
                    linkMap.put(link.second, new HashSet<>());
                }
                linkMap.get(link.first).add(link);
                linkMap.get(link.second).add(link);
                links[k] = link;
            }
            process(nodeList, linkMap);

            System.out.print("Case #" + (i + 1) + ":");
            for (int l = 0; l < linkCount; l++) {
                System.out.print(" " + links[l].latency);
            }
            if (i != n - 1)
                System.out.println();
        }
    }

    private static void process(List<Node> nodeList, HashMap<Integer, Set<Link>> linkMap) {
        Collections.sort(nodeList);
        Set<Integer> currentSet;
        Set<Integer> doneSet = new HashSet<>();

        int latency = 1;
        for (int i = 0; i < nodeList.size(); i++) {
            List<Node> group = new ArrayList<>();
            group.add(nodeList.get(i));
            currentSet = new HashSet<>();
            currentSet.add(nodeList.get(i).position);
            while (i + 1 < nodeList.size() && nodeList.get(i).otherComputers == nodeList.get(i + 1).otherComputers) {
                i++;
                group.add(nodeList.get(i));
                currentSet.add(nodeList.get(i).position);
            }

            for (Node node : group) {
                Set<Link> linkSet = linkMap.get(node.position);
                if (linkSet != null) {
                    boolean isDone = false;
                    for (Link link : linkSet) {
                        if (link.first == 1 || link.second == 1) {
                            link.latency = latency;
                            isDone = true;
                            break;
                        }
                    }
                    if (!isDone) {
                        for (Link link : linkSet) {
                            if ((link.first != node.position && doneSet.contains(link.first))
                                    || (link.second != node.position && doneSet.contains(link.second))) {
                                link.latency = latency;
                                isDone = true;
                                break;
                            }
                        }
                    }
                    if (!isDone) {
                        for (Link link : linkSet) {
                            if ((link.first != node.position && currentSet.contains(link.first))
                                    || (link.second != node.position && currentSet.contains(link.second))) {
                                link.latency = 0;
                                break;
                            }
                        }
                    }
                }
            }

            doneSet.addAll(currentSet);

            latency += (i + 1);
        }
    }
}
