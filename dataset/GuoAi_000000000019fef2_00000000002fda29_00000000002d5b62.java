import java.util.*;
import java.io.*;

public class Solution {
    public static Position dest;
    public static HashSet<Position> visited;
    public static FastIO fio;
    public static Position[] neighbours;
	public static void main(String[] args) {
		fio = new FastIO();
		int T = fio.nextInt();
		for (int t = 1; t <= T; t++) {
            Boolean flag = false;
            int X = fio.nextInt(), Y = fio.nextInt();
            dest = new Position(X, Y, -1);
			visited = new HashSet<>();
            LinkedList<Position> Q = new LinkedList<>();
            Q.add(new Position(0, 0, -1));
            visited.add(new Position(0, 0, -1));
            while (Q.size() != 0) {
                Position u = Q.poll();
                if (u.step > Math.abs(Math.max(X, Y))) {
                    fio.println("Case #"+t+": IMPOSSIBLE");
                    break;
                }
                neighbours = new Position[4];
                neighbours[0] = new Position(u.x - (int) Math.pow(2, u.step + 1), u.y, u.step + 1);
                neighbours[0].dir = "W";
                neighbours[1] = new Position(u.x + (int) Math.pow(2, u.step + 1), u.y, u.step + 1);
                neighbours[1].dir = "E";
                neighbours[2] = new Position(u.x, u.y + (int) Math.pow(2, u.step + 1), u.step + 1);
                neighbours[2].dir = "N";
                neighbours[3] = new Position(u.x, u.y - (int) Math.pow(2, u.step + 1), u.step + 1);
                neighbours[3].dir = "S";
                for (int i = 0; i < 4; i++) {
                    if (!visited.contains(neighbours[i])) {
                        visited.add(neighbours[i]);
                        neighbours[i].p = u;
                        Q.add(neighbours[i]);
                        if (neighbours[i].x == dest.x && neighbours[i].y == dest.y) {
                            dest.p = u;
                            dest.dir = neighbours[i].dir;
                            succeed(t);
                            flag = true;
                            break;
                        }
                        // if (Math.abs(neighbours[i].x) > 4 * Math.abs(dest.x) || Math.abs(neighbours[i].y) > 2 * Math.abs(dest.y)) {
                        //     fio.println("Case #"+t+": IMPOSSIBLE");
                        //     flag = true;
                        //     break;
                        // }
                    }
                }
                if (flag) {
                    break;
                }       
            }
		}
		fio.close();
	}	
    public static void succeed(int t) {
        String res = "";
        Position thisP = dest;
        while (thisP != null) {
            res = thisP.dir + res;
            thisP = thisP.p;
        }
        fio.println("Case #"+t+": "+res);
    }
}

class Position {
    int x, y;
    Position p;
    String dir;
    int step;
    public Position(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.p = null;
        this.dir = "";
        this.step = step;
    }
}

class FastIO extends PrintWriter 
{ 
    BufferedReader br; 
    StringTokenizer st;

    public FastIO() 
    { 
        super(new BufferedOutputStream(System.out)); 
        br = new BufferedReader(new
                InputStreamReader(System.in));
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
}