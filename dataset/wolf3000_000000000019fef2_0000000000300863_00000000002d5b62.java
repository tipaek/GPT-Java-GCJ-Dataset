import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Solution {

    public static class Jump{
        int distance;
        Position src;
        Position dst;
        int direction;

        public Jump(int distance, Position src, Position dst, int direction) {
            this.distance = distance;
            this.src = src;
            this.dst = dst;
            this.direction = direction;
        }
    }

    public static class Position{

        long i;
        long j;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (i != position.i) return false;
            return j == position.j;

        }

        @Override
        public int hashCode() {
            long result = i;
            result = 31 * result + j;
            return (int)result;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }

        public Position(long i, long j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        Map<Position, Jump> smallMap = new HashMap<>();
        smallMap.put(new Position(0, 0), null);
        Queue<Long> pos = new ArrayDeque<>();
        pos.add(0L);
        pos.add(0L);
        for(int j=0;j<11;++j){
            //System.out.println("J = "+j + " "+ map.size());
            Queue<Long> newPosQ = new ArrayDeque<>();
            while(!pos.isEmpty()) {
                long currI = pos.poll();
                long currJ = pos.poll();
                for (int d = 0; d < direction.length; ++d) {
                    //  System.out.println(srcI+" " + srcJ+ "->" +direction[d][0]+" "+direction[d][1]);
                    long nI = currI + (1L * direction[d][0] * (1L << j));
                    long nJ = currJ + (1L * direction[d][1] * (1L << j));
                    // System.out.println(srcI+" " + srcJ+ "->" +nI+" "+nJ);

                    Position newPos = new Position(nI, nJ);
                    if (!smallMap.containsKey(newPos)) {
                        //System.out.println("Adding " + newPos);
                        smallMap.put(newPos, new Jump(j, new Position(currI, currJ), newPos, d));
                        newPosQ.add(nI);
                        newPosQ.add(nJ);
                    }
                }
            }
            pos = newPosQ;
        }
//        //System.out.println(smallMap.size());
//
//        Map<Position, Jump> bigMap = new HashMap<>();
//        bigMap.put(new Position(0, 0), null);
//        pos = new ArrayDeque<>();
//        pos.add(0L);
//        pos.add(0L);
//        for(int j=13;j<25;++j){
//            //System.out.println("J = "+j + " "+ map.size());
//            Queue<Long> newPosQ = new ArrayDeque<>();
//            while(!pos.isEmpty()) {
//                long currI = pos.poll();
//                long currJ = pos.poll();
//                for (int d = 0; d < direction.length; ++d) {
//                    //  System.out.println(srcI+" " + srcJ+ "->" +direction[d][0]+" "+direction[d][1]);
//                    long nI = currI + (1L * direction[d][0] * (1L << j));
//                    long nJ = currJ + (1L * direction[d][1] * (1L << j));
//                    // System.out.println(srcI+" " + srcJ+ "->" +nI+" "+nJ);
//
//                    Position newPos = new Position(nI, nJ);
//                    if (!bigMap.containsKey(newPos)) {
//                        //System.out.println("Adding " + newPos);
//                        bigMap.put(newPos, new Jump(j, new Position(currI, currJ), newPos, d));
//                        newPosQ.add(nI);
//                        newPosQ.add(nJ);
//                    }
//                }
//            }
//            pos = newPosQ;
//        }
        //System.out.println(bigMap.size());

        //dfs(0,0,0,map);
        //System.out.println(smallMap.size());

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int tX = in.nextInt();
            int tY = in.nextInt();

            System.out.println("Case #" + i + ": " + solve(smallMap, tX, tY));
        }

    }

    public static String find(Map<Position, Jump> map, Position dstPosition){
        Position pos = dstPosition;
        StringBuilder result = new StringBuilder();
        while(pos!=null){
            Jump jump = map.get(pos);
            if(jump==null){
                break;
            }
            Position nextPos = jump.src;
            pos = nextPos;
            result.append(toStr(jump.direction));
        }
        return result.reverse().toString();
    }

    private static String solve(Map<Position, Jump> map, int tX, int tY) {
        Position dstPosition = new Position(tX, tY);

            StringBuilder result = new StringBuilder();
            if(map.containsKey(new Position(tX, tY))){
                return find(map, new Position(tX, tY));
            }

            return "IMPOSSIBLE";

    }

    static String toStr(int direction){
        switch (direction){
            case 0: return "W";
            case 1: return "E";
            case 2: return "N";
            case 3: return "S";
        }
        throw new IllegalArgumentException("Wrong Direction");
    }

    static int[][] direction = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

    private static void dfs(long srcI, long srcJ, int jump, Map<Position, Jump> map) {

        if(jump == 20){
            return;
        }
        for(int d=0;d<direction.length;++d){
          //  System.out.println(srcI+" " + srcJ+ "->" +direction[d][0]+" "+direction[d][1]);
            long nI = srcI + (1L*direction[d][0] * (1L<<jump));
            long nJ = srcJ + (1L*direction[d][1] * (1L<<jump));
           // System.out.println(srcI+" " + srcJ+ "->" +nI+" "+nJ);

            Position newPos = new Position(nI, nJ);
            if(!map.containsKey(newPos)){
            //    System.out.println("Adding "+newPos);
                map.put(newPos, new Jump(jump, new Position(srcI, srcJ), newPos, d));
                dfs(nI, nJ, jump + 1, map);
            }
        }
    }

}