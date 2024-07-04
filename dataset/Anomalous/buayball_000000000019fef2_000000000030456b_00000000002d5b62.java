import java.util.*;
import java.io.*;

public class Solution {

    private static Queue<String> discovered = new LinkedList<>();
    private static Map<String, Node> nodes = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int x = in.nextInt();
            int y = in.nextInt();

            discovered.clear();
            nodes.clear();

            initializeNodes();

            if ((Math.abs(x % 2) == 1 && Math.abs(y % 2) == 1) || (Math.abs(x % 2) == 0 && Math.abs(y % 2) == 0)) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                String result = bfs(x, y);
                System.out.println("Case #" + caseNum + ": " + result);
            }
        }
    }

    private static void initializeNodes() {
        discovered.add("");
        nodes.put("", new Node("", 0, 0, 0));
        nodes.put("N", new Node("N", 0, 1, 0));
        nodes.put("E", new Node("E", 1, 0, 0));
        nodes.put("S", new Node("S", 0, -1, 0));
        nodes.put("W", new Node("W", -1, 0, 0));
    }

    private static String bfs(int x, int y) {
        while (!discovered.isEmpty()) {
            String u = discovered.poll();
            Node currentNode = nodes.get(u);

            for (String v : currentNode.adjNodes) {
                Node nextNode = nodes.get(v);
                if (nextNode.status == 0) {
                    nextNode.status = 1;
                    int currentX = nextNode.x;
                    int currentY = nextNode.y;
                    int currentDistance = nextNode.distance;
                    String currentPath = nextNode.name;
                    int step = (int) Math.pow(2, currentDistance + 1);

                    if (currentX == x && currentY == y) {
                        return currentPath;
                    }

                    addNewNodes(currentPath, currentX, currentY, step, currentDistance);
                    discovered.add(v);
                }
            }
            currentNode.status = 2;
        }
        return "";
    }

    private static void addNewNodes(String currentPath, int currentX, int currentY, int step, int currentDistance) {
        nodes.put(currentPath + "N", new Node(currentPath + "N", currentX, currentY + step, currentDistance + 1));
        nodes.put(currentPath + "E", new Node(currentPath + "E", currentX + step, currentY, currentDistance + 1));
        nodes.put(currentPath + "S", new Node(currentPath + "S", currentX, currentY - step, currentDistance + 1));
        nodes.put(currentPath + "W", new Node(currentPath + "W", currentX - step, currentY, currentDistance + 1));
    }
}

class Node {
    public String name;
    public int status; // 0 = undiscovered, 1 = discovered, 2 = explored
    public int x;
    public int y;
    public int distance;
    public List<String> adjNodes; // represent edges to other vertices

    public Node(String name, int x, int y, int distance) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.status = 0;
        this.distance = distance;
        this.adjNodes = new ArrayList<>(Arrays.asList(name + "N", name + "E", name + "S", name + "W"));
    }
}