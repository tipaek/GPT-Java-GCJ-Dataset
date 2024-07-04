import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = readInt(in);
        for (int c = 1; c <= cases; ++c) {
            String[] split = in.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            List<Node> nodes = new ArrayList<>();
            nodes.add(new Node(x, y));
            int p = 1;
            Node correct = null;
            while (correct == null && !nodes.isEmpty()) {
                List<Node> newNodes = new ArrayList<>();
                for (Node node : nodes) {
                    Collection<Node> moves = node.move(p);
                    for (Node move : moves) {
                        if (move.mx == 0 && move.my == 0) {
                            correct = move;
                            break;
                        }
                    }
                    if (correct != null) {
                        break;
                    }
                    newNodes.addAll(moves);
                }
                nodes = newNodes;
                p *= 2;
            }
            if (correct == null) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", c));
            } else {
                System.out.println(String.format("Case #%d: %s", c, correct.path));
            }
        }
    }

    private static int readInt(BufferedReader in) throws IOException {
        String line = in.readLine();
        return Integer.parseInt(line);
    }

    private static class Node {
        private final String path;
        private final int mx, my;
        private final boolean sx, sy;

        public Node(int x, int y) {
            path = "";
            this.mx = Math.abs(x);
            this.my = Math.abs(y);
            this.sx = x >= 0;
            this.sy = y >= 0;
        }

        public Node(String path, int mx, int my, boolean sx, boolean sy) {
            this.path = path;
            this.mx = mx;
            this.my = my;
            this.sx = sx;
            this.sy = sy;
        }

        public Collection<Node> move(int s) {
            if ((mx&s) > 0 && (my&s) > 0) {
                return Collections.emptyList();
            }
            if ((mx&s) > 0) {
                return Arrays.asList(
                        new Node(path + "W", sx ? mx+s : mx-s, my, sx, sy),
                        new Node(path + "E", sx ? mx-s : mx+s, my, sx, sy)
                );
            }
            if ((my&s) > 0) {
                return Arrays.asList(
                        new Node(path + "S", mx, sy ? my+s : my-s, sx, sy),
                        new Node(path + "N", mx, sy ? my-s : my+s, sx, sy)
                );
            }
            return Collections.emptyList();
        }
    }
}
