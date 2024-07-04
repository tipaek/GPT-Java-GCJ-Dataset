import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int r = in.nextInt();
            int c = in.nextInt();
            int[][] dancers = new int[r][c];
            long round = 0;
            HashMap<Pair, Dancer> map = new HashMap<>();
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    dancers[j][k] = in.nextInt();
                    round += dancers[j][k];
                    Dancer dancer = new Dancer(dancers[j][k]);
                    map.put(new Pair(j, k), dancer);

                }
            }
            List<Dancer> list = new ArrayList<>();
            List<Dancer> newList = new ArrayList<>();
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    map.get(new Pair(j,k)).setLeft(map.getOrDefault(new Pair(j, k - 1), null));
                    map.get(new Pair(j,k)).setRight(map.getOrDefault(new Pair(j, k  + 1), null));

                    map.get(new Pair(j,k)).setUp(map.getOrDefault(new Pair(j - 1, k), null));
                    map.get(new Pair(j,k)).setDown(map.getOrDefault(new Pair(j + 1, k), null));

                    list.add(map.get(new Pair(j, k)));
                    newList.add(map.get(new Pair(j, k)));
                }
            }

            long answer = 0;
            round = 0;
            while ((answer == 0) || list.size() != newList.size()) {
                round = 0;
                list = newList;
                newList = new ArrayList<>();

                for (Dancer dancer : list)  {
                    int sum = 0;
                    int count = 0;
                    round += dancer.skill;

                    if (dancer.left != null)
                    {
                        sum += dancer.left.getSkill();
                        count++;
                        if (dancer.left.willDeleted) dancer.left = dancer.left.left;
                    }
                    if (dancer.right != null)
                    {
                        sum += dancer.right.getSkill();
                        count++;
                    }
                    if (dancer.up != null)
                    {
                        sum += dancer.up.getSkill();
                        count++;
                        if (dancer.up.willDeleted) dancer.up = dancer.up.up;
                    }
                    if (dancer.down != null)
                    {
                        sum += dancer.down.getSkill();
                        count++;
                    }
                    if (count == 0 || sum <= count*dancer.skill) {
                        newList.add(dancer);
                    } else {
                        dancer.willDeleted = true;
                        if (dancer.left != null) dancer.left.right = dancer.right;
                        if (dancer.up != null) dancer.up.down = dancer.down;
                    }
                }
                answer += round;
            }
            if (answer == 0) answer += round;

            System.out.println(String.format("Case #%d: %d", i + 1, answer));

        }
    }

    private static class Dancer {
        private int skill = 0;
        private Dancer up, down, left, right;
        private boolean willDeleted = false;

        public Dancer(int skill) {
            this.skill = skill;
        }

        public int getSkill() {
            return skill;
        }

        public void setSkill(int skill) {
            this.skill = skill;
        }

        public Dancer getUp() {
            return up;
        }

        public void setUp(Dancer up) {
            this.up = up;
        }

        public Dancer getDown() {
            return down;
        }

        public void setDown(Dancer down) {
            this.down = down;
        }

        public Dancer getLeft() {
            return left;
        }

        public void setLeft(Dancer left) {
            this.left = left;
        }

        public Dancer getRight() {
            return right;
        }

        public void setRight(Dancer right) {
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dancer dancer = (Dancer) o;
            return skill == dancer.skill &&
                    Objects.equals(up, dancer.up) &&
                    Objects.equals(down, dancer.down) &&
                    Objects.equals(left, dancer.left) &&
                    Objects.equals(right, dancer.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(skill, up, down, left, right);
        }

        public boolean isWillDeleted() {
            return willDeleted;
        }

        public void setWillDeleted(boolean willDeleted) {
            this.willDeleted = willDeleted;
        }
    }

    private static class Pair {
        private int x;
        private int y;

        public Pair(int x,int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
