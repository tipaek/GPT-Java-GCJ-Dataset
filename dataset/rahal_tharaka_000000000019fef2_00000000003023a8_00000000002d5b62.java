import java.util.*;
import java.lang.*;
import java.io.*;

class Solution 
{
    static class Cell
    {
        int x, y, dist;
        boolean visited;
        String comm = "";
        Cell parent;

        Cell(int x, int y)
        {
            this.x = x;
            this.y = y;
            visited = false;
            dist = Integer.MAX_VALUE;
        }

        public String toString()
        {
            return x+","+y+" : "+dist;
        }
    }

    static int n = 2001;

    static boolean valid(int x, int y)
    {
        return x>=0 & x<n & y>=0 & y<n;
    }

    // Complete the printShortestPath function below.
    static void getPath(int posX, int posY, int destX, int destY) 
    {
        Cell[][] grid = new Cell[n][n];
        for(int i=0; i<n; i++) for(int j=0; j<n; j++) 
            grid[i][j] = new Cell(i,j);
        LinkedList<Cell> queue = new LinkedList<Cell>();
        Cell currCell = grid[posX][posY];
        currCell.visited = true;
        currCell.dist = 0;
        queue.add(currCell);
        int x, y;
        boolean reached = false;
        while(queue.size()>0)
        {
            currCell = queue.pop();
            x = currCell.x;
            y = currCell.y;
            if(x==destX && y==destY)
            {
                reached = true;
                break;
            }
            int d = 1<<currCell.dist;
            if(valid(x,y+d) && !grid[x][y+d].visited) //EAST
            {
                grid[x][y+d].dist = currCell.dist+1;
                grid[x][y+d].visited = true;
                grid[x][y+d].parent = currCell;
                grid[x][y+d].comm = "E";
                queue.add(grid[x][y+d]);
            }
            if(valid(x,y-d) && !grid[x][y-d].visited) //WEST
            {
                grid[x][y-d].dist = currCell.dist+1;
                grid[x][y-d].visited = true;
                grid[x][y-d].parent = currCell;
                grid[x][y-d].comm = "W";
                queue.add(grid[x][y-d]);
            }
            if(valid(x+d,y) && !grid[x+d][y].visited) //NORTH
            {
                grid[x+d][y].dist = currCell.dist+1;
                grid[x+d][y].visited = true;
                grid[x+d][y].parent = currCell;
                grid[x+d][y].comm = "N";
                queue.add(grid[x+d][y]);
            }
            if(valid(x-d,y) && !grid[x-d][y].visited) //SOUTH
            {
                grid[x-d][y].dist = currCell.dist+1;
                grid[x-d][y].visited = true;
                grid[x-d][y].parent = currCell;
                grid[x-d][y].comm = "S";
                queue.add(grid[x-d][y]);
            }
        }

        if (reached)
        {
            String path = "";
            currCell = grid[destX][destY];
            while (true)
            {
                if(currCell.parent==null) break;
                path = currCell.comm + path;
                currCell = currCell.parent;
            }
            System.out.println(path);
        }
        else
        {
            System.out.println("IMPOSSIBLE");
        }
        
    } 

    public static void main (String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine());
        for(int t=1; t<=tc; t++)
        {
            String[] data = in.readLine().split(" ");
            int x = Integer.parseInt(data[0]) + (n-1)/2;
            int y = Integer.parseInt(data[1]) + (n-1)/2;
            System.out.print("Case #"+t+": ");
            getPath((n-1)/2,(n-1)/2,y,x);
        }
    }
}
