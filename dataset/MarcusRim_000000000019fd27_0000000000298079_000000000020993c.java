import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int nn = 1; nn <= n; nn++){
            int test = Integer.parseInt(br.readLine());
            int[][] grid = new int[test][test];

            int token = 0;
            int r = 0;
            int c = 0;

            for(int i = 0; i < test; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < test; j++){
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    if(i == j){
                        token+= grid[i][j];
                    }
                }
            }

            for(int i = 0; i < test; i++){
                Set<Integer> s = new HashSet<>();
                for(int y : grid[i]) s.add(y);
                if(test != s.size()) r++;
            }

            for(int j = 0; j < test; j++){
                Set<Integer> s = new HashSet<>();
                for(int i = 0; i < test; i++){
                    s.add(grid[i][j]);
                }
                if(test != s.size()) c++;
            }

            out.println("Case #" + nn + ": " + token + " " + r + " " + c);
        }
        out.close();
    }
}
