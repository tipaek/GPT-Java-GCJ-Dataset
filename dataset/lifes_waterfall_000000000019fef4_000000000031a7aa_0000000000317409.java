import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static class Pair {
        final int x;
        final int y;
        int order;

        public Pair(int x, int y, int order) {
            this.x = x;
            this.y = y;
            this.order = order;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String m = in.nextLine().trim();

            List<Pair> catSteps = new ArrayList<>();
            catSteps.add(new Pair(x, y, 0));
            for (int j = 0; j < m.length(); j++) {
                char mChar = m.charAt(j);
                Pair lastAdded = catSteps.get(catSteps.size() - 1);
                switch (mChar) {
                    case ('S') :
                        catSteps.add(new Pair(lastAdded.x, lastAdded.y - 1, j + 1));
                        break;
                    case ('N') :
                        catSteps.add(new Pair(lastAdded.x, lastAdded.y + 1, j + 1));
                        break;
                    case ('W'):
                        catSteps.add(new Pair(lastAdded.x - 1 , lastAdded.y, j + 1));
                        break;
                    case ('E'):
                        catSteps.add(new Pair(lastAdded.x + 1, lastAdded.y , j + 1));
                        break;
                }
            }

            int found = -1;
            for (Pair pair : catSteps) {
                int differenceX = Math.abs(pair.x - 0);
                int differenceY = Math.abs(pair.y - 0);
                int difference = differenceX + differenceY;

                if (pair.order >= difference) {
                    found = pair.order;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + (found > -1 ? found : "IMPOSSIBLE"));
        }
    }
}
