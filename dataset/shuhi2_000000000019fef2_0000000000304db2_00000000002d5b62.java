import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static int caseNum = 0;
    static int x,y;

    public static void main(String[] arg) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for(int i=0; i < t; i++) {
            x = in.nextInt();
            y = in.nextInt();
            solve();
        }
    }

    static LinkedList<Cell> linkedList;

    private static void solve() {
        caseNum++;
//        if(Math.abs(x % 2) == Math.abs(y % 2)) {
//            System.out.println("Case #"+caseNum+": IMPOSSIBLE");
//            return;
//        }
        Cell cell = new Cell(0,0,0,null,'X');
        linkedList = new LinkedList<>();
        linkedList.add(cell);
        bfs();
    }

    private static void bfs() {
        Cell cell = linkedList.poll();
        if(cell == null || (cell.x == x && cell.y == y)) {
            printResult(cell);
            return;
        }

        long jump = cell.jump == 0 ? 1 : 2 * cell.jump;

        if(!isStillPossible(cell, jump)) {
            bfs();
            return;
        }

        linkedList.addLast(new Cell(cell.x + jump,cell.y, jump, cell, 'E'));
        linkedList.addLast(new Cell(cell.x - jump,cell.y, jump, cell,'W'));
        linkedList.addLast(new Cell(cell.x,cell.y + jump, jump, cell, 'N'));
        linkedList.addLast(new Cell(cell.x,cell.y - jump, jump, cell,'S'));
        bfs();
    }

    static boolean isStillPossible(Cell cell, long nextJump) {
        long xDis = Math.abs(cell.x - x);
        long yDis = Math.abs(cell.y - y);
        if((xDis < nextJump && xDis != 0) || (yDis < nextJump && yDis != 0))
            return false;
        return true;
    }

    static void printResult(Cell cell) {
        if(cell == null) {
            System.out.println("Case #" + caseNum +": IMPOSSIBLE");
            return;
        }

        String s = "";
        while(cell.parent != null) {
            s += cell.dir;
            cell = cell.parent;
        }

        StringBuilder input1 = new StringBuilder();

        // append a string into StringBuilder input1
        input1.append(s);

        // reverse StringBuilder input1
        input1 = input1.reverse();

        System.out.println("Case #" + caseNum +": " + input1);
    }


    static class Cell{
        long x, y;
        long jump;
        char dir;

        Cell parent;
        public Cell(long i, long j, long jump, Cell parent, char dir) {
            this.x = i;
            this.y = j;
            this.jump = jump;
            this.parent = parent;
            this.dir = dir;
        }
    }
}