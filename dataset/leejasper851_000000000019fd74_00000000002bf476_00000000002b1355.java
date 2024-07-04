import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int numCases = Integer.parseInt(reader.readLine());
        for (int caseN = 1; caseN <= numCases; caseN++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int numRows = Integer.parseInt(st.nextToken());
            int numCols = Integer.parseInt(st.nextToken());
            Comp[][] grid = new Comp[numRows][numCols];
            HashSet<Comp> comps = new HashSet<>();
            for (int i = 0; i < numRows; i++) {
                st = new StringTokenizer(reader.readLine());
                for (int j = 0; j < numCols; j++) {
                    long skill = Long.parseLong(st.nextToken());
                    grid[i][j] = new Comp(i, j, skill, numRows, numCols);
                    comps.add(grid[i][j]);
                }
            }
            
            long intLev = 0;
            while (true) {
                HashSet<Comp> elimComps = new HashSet<>();
                for (Comp comp : comps) {
                    intLev += comp.skill;
                    comp.decElim(grid, elimComps);
                }
                
                if (elimComps.isEmpty()) {
                    break;
                }
                for (Comp comp : elimComps) {
                    comp.elim(grid, comps);
                }
            }
            writer.println("Case #" + caseN + ": " + intLev);
        }
        reader.close();
        writer.close();
    }
    
    private static class Comp {
        public int row;
        public int col;
        public long skill;
        public int up;
        public int down;
        public int left;
        public int right;
        
        public Comp(int r, int c, long s, int numRows, int numCols) {
            row = r;
            col = c;
            skill = s;
            
            if (row > 0) {
                up = row - 1;
            } else {
                up = -1;
            }
            if (row < numRows-1) {
                down = row + 1;
            } else {
                down = -1;
            }
            if (col > 0) {
                left = col - 1;
            } else {
                left = -1;
            }
            if (col < numCols-1) {
                right = col + 1;
            } else {
                right = -1;
            }
        }
        
        public void decElim(Comp[][] grid, HashSet<Comp> elimComps) {
            double avgSkill = 0;
            int numNeighs = 0;
            if (up != -1) {
                avgSkill += grid[up][col].skill;
                numNeighs++;
            }
            if (down != -1) {
                avgSkill += grid[down][col].skill;
                numNeighs++;
            }
            if (left != -1) {
                avgSkill += grid[row][left].skill;
                numNeighs++;
            }
            if (right != -1) {
                avgSkill += grid[row][right].skill;
                numNeighs++;
            }
            if (numNeighs == 0) {
                return;
            }
            avgSkill /= numNeighs;
            if (skill < avgSkill) {
                elimComps.add(this);
            }
        }
        
        public void elim(Comp[][] grid, HashSet<Comp> comps) {
            if (up != -1) {
                grid[up][col].down = down;
            }
            if (down != -1) {
                grid[down][col].up = up;
            }
            if (left != -1) {
                grid[row][left].right = right;
            }
            if (right != -1) {
                grid[row][right].left = left;
            }
            comps.remove(this);
        }
        
        public boolean equals(Comp other) {
            return (row == other.row && col == other.col);
        }
    }
}