import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Solution {
    static BigInteger x, y;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int loops = 1; loops <= t; ++loops) {
            //Input
            x = in.nextBigInteger();
            y = in.nextBigInteger();

            //Solution
//            ArrayList<BigInteger> possibleX = new ArrayList<>();
//            ArrayList<BigInteger> possibleY = new ArrayList<>();
//            for (int i = 0; BigInteger.valueOf(2).pow(i).compareTo(x.abs()) < 0; i++) {
//                possibleX.add(BigInteger.valueOf(2).pow(i));
//            }
//            for (int i = 0; BigInteger.valueOf(2).pow(i).compareTo(y.abs()) < 0; i++) {
//                possibleY.add(BigInteger.valueOf(2).pow(i));
//            }
//            System.out.println(possibleX);
//            String result = findBest2(BigInteger.valueOf(0), BigInteger.valueOf(0), BigInteger.valueOf(1), "");
            String result = findBest2();


            //Result
            System.out.println("Case #" + loops + ": " + result);
        }
    }

//    public static String findBest(BigInteger currX, BigInteger currY,BigInteger size, String previous) {
//        if (currY.equals(y) && currX.equals(x))
//            return previous;
//
//        if (currX.compareTo(x.abs()) > 0 || currY.compareTo(y.abs()) > 0 || size.compareTo(x.abs().add(y.abs()).multiply(BigInteger.valueOf(128))) > 0)
//            return "IMPOSSIBLE";
//
////        System.out.print(currX);
////        System.out.print(" ");
////        System.out.println(currY);
//        BigInteger newSize = BigInteger.valueOf(2).multiply(size);
//        String up = findBest(currX, currY.add(size), newSize, previous + "N");
//        String down = findBest(currX, currY.subtract(size), newSize, previous + "S");
//        String right = findBest(currX.add(size), currY, newSize, previous + "E");
//        String left = findBest(currX.subtract(size), currY, newSize, previous + "W");
//        String[] moves = { up, down, right, left };
//
//        int minSize = Integer.MAX_VALUE, minIndex = -1;
//        for (int i = 0; i < 4; i++) {
//            if (!moves[i].equals("IMPOSSIBLE") && moves[i].length() < minSize) {
//                minSize = moves[i].length();
//                minIndex = i;
//            }
//        }
//
//        if (minIndex != -1)
//            return moves[minIndex];
//
//        return "IMPOSSIBLE";
//    }

    public static String findBest2() {
        Position goal = new Position(x, y, "");

//        if (pos.x.compareTo(x.abs()) > 0 || pos.y.compareTo(y.abs()) > 0 || size.compareTo(x.abs().add(y.abs()).multiply(BigInteger.valueOf(128))) > 0)
//            return "IMPOSSIBLE";
        LinkedList<Position> queue = new LinkedList<>();
        queue.add(new Position(BigInteger.valueOf(0), BigInteger.valueOf(0), ""));

        while (!queue.isEmpty()) {
            Position current = queue.pop();

            if (current.equals(goal))
                return current.seq;

            Position[] children = current.getAllMoves();
            queue.addAll(Arrays.asList(children));
        }


        return "IMPOSSIBLE";
    }

    public static class Position {
        public BigInteger x, y;
        public String seq = "";

        public Position() {
            x = BigInteger.valueOf(0);
            y = BigInteger.valueOf(0);
        }

        public Position(BigInteger x, BigInteger y, String seq) {
            this.x = x;
            this.y = y;
            this.seq = seq;
        }

        public Position[] getAllMoves() {
            BigInteger step = BigInteger.valueOf(2).pow(this.seq.length());

            if (step.compareTo(Solution.x.abs().add(Solution.y.abs()).multiply(BigInteger.valueOf(128))) > 0)
                return new Position[]{};

            return new Position[]{
                    new Position(this.x.add(step), this.y, this.seq + "E"),
                    new Position(this.x.subtract(step), this.y, this.seq + "W"),
                    new Position(this.x, this.y.add(step), this.seq + "N"),
                    new Position(this.x, this.y.subtract(step), this.seq + "S")
            };
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return Objects.equals(x, position.x) &&
                    Objects.equals(y, position.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}

