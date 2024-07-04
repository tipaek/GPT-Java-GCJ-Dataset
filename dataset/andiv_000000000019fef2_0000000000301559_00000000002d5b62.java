import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = scanner.nextInt();

        boolean wasPrevNextLine = false;

        for (int i = 1; i <= totalTests; i++) {
            if(!wasPrevNextLine) scanner.nextLine();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.nextLine();
            wasPrevNextLine = true;
            String result = solve(x, y);
            System.out.println("Case #"+i+": " + result);
        }

    }


    public static String solve(int x, int y){
        final String IMPOSSIBLE = "IMPOSSIBLE";

        long sum = Math.abs(x) + Math.abs(y);
        if(sum %2 == 0l) return IMPOSSIBLE;
        StringBuilder result = new StringBuilder();
        Queue<Position> queue = new LinkedList<>();
        Position first = new Position(0,0,1, "");
        queue.offer(first);
        Set<Position> visited = new HashSet<>();
        visited.add(first);

        while(!queue.isEmpty()){
            Position pos = queue.poll();
            if(pos.x == x && pos.y == y) return pos.path.toString();
            if(pos.jump > sum*2) continue;
            long nextJump = (pos.jump == 1)?2:pos.jump*2;
            Position wPoth = new Position(pos.x - pos.jump, pos.y, nextJump, pos.path.toString() + "W");
            Position ePoth = new Position(pos.x + pos.jump, pos.y, nextJump, pos.path.toString() + "E");
            Position nPoth = new Position(pos.x, pos.y + pos.jump, nextJump, pos.path.toString() + "N");
            Position sPoth = new Position(pos.x, pos.y - pos.jump, nextJump, pos.path.toString() + "S");

            if(!visited.contains(wPoth)) queue.offer(wPoth);
            if(!visited.contains(ePoth)) queue.offer(ePoth);
            if(!visited.contains(nPoth)) queue.offer(nPoth);
            if(!visited.contains(sPoth)) queue.offer(sPoth);

        }

        return IMPOSSIBLE;

/*
        long tmpSum = 0;
        long next = 1;
        List<Long> nums = new ArrayList<>();
        while(tmpSum <= sum){
            nums.add(next);
            tmpSum += next;
            if(next == 1) next = 2;
            else next *= 2;
            if()
        }
        //add needed sights
        if(tmpSum != sum){

        }

        //select correct

        return result.toString();
*/
    }
}

class Position{
    long x, y, jump;
    StringBuilder path;
    Position(long x, long y, long jump, String prevPath){
        this.x = x;
        this.y = y;
        this.jump = jump;
        path = new StringBuilder(prevPath);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
