import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        Scanner sc = new Scanner(in);
//        sc.useDelimiter(Pattern.compile("[\n /]"));

        String[][] grid= new String[512][512];
        grid[256][256] = "";
        for (int i = 0; i < 10; i++) {
            String[][] grid2= new String[512][512];
            int d = 1<<(i);
            for (int yy = 0 ;yy < grid.length; yy++) {
                for (int xx = 0 ;xx < grid.length; xx++) {
                    if (grid[yy][xx]!= null) {
                        grid2[yy][xx] = grid[yy][xx];
                        if (yy-d>=0 && grid[yy-d][xx]==null)  grid2[yy-d][xx] = grid[yy][xx] + "S";
                        if (yy+d<grid.length && grid[yy+d][xx]==null)  grid2[yy+d][xx] = grid[yy][xx] + "N";
                        if (xx-d>=0 && grid[yy][xx-d]==null)  grid2[yy][xx-d] = grid[yy][xx] + "W";
                        if (xx+d<grid.length && grid[yy][xx+d]==null)  grid2[yy][xx+d] = grid[yy][xx] + "E";
                    }
                }
            }
            grid = grid2;
        }

x:        for (int cs = 1, cases = sc.nextInt(); cs <= cases; cs++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x+256>=0 && x+256 < grid.length && y+256 >=0 && y+256 <grid.length && grid[y+256][x+256] != null) {
                System.out.printf("Case #%d: %s%n", cs, grid[y+256][x+256]);
            } else System.out.printf("Case #%d: %s%n", cs, "IMPOSSIBLE");
        }
    }
}
