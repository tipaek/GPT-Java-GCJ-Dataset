import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{
    private static Scanner input = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));
    private static Queue<Cell> queue;

    private static String solve(int x, int y){
        queue.offer(new Cell(0, 0, "", 0));
        long max = 0L + Math.abs(y) + Math.abs(x);

        while(!queue.isEmpty()){
            Cell cell = queue.poll();
            long movement = (long) Math.pow(2, cell.exp);

            if(cell.x == x && cell.y == y)
                return cell.path;
            if(movement > 2 * max)
                break;

            if(!canBeReached(Math.abs(cell.x - x), movement))
                continue;
            if(!canBeReached(Math.abs(cell.y - y), movement))
                continue;

            queue.offer(new Cell(cell.x+movement, cell.y, cell.path + "E", cell.exp+1));
            queue.offer(new Cell(cell.x, cell.y+movement, cell.path + "N", cell.exp+1));
            queue.offer(new Cell(cell.x-movement, cell.y, cell.path + "W", cell.exp+1));
            queue.offer(new Cell(cell.x, cell.y-movement, cell.path + "S", cell.exp+1));
        }
        return "IMPOSSIBLE";
    }

    private static boolean canBeReached(long num, long movement) {
        if(num==0)
            return true;
        int sum = 0;
        for(int i = (int) (Math.log(num) / Math.log(2)); i>=0; i--){
            long res = (long) Math.pow(2, i);
            if(sum + res <= num)
                sum += res;
            if(res < movement)
                return false;
            if(sum == num)
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        int t = input.nextInt();
        for(int i = 0; i < t; i++){
            int x = input.nextInt();
            int y = input.nextInt();
            queue = new LinkedList<>();
            System.out.println("Case #" + (i + 1) + ": " + solve(x, y));
        }
    }

    private static class Cell{
        long x;
        long y;
        int exp;
        String path;

        public Cell(long x, long y, String path, int exp) {
            this.x = x;
            this.y = y;
            this.path = path;
            this.exp = exp;
        }
    }
}