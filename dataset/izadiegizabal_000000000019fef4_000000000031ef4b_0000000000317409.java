import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
         try {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

            int c = in.nextInt();
            for (int i = 0; i < c; ++i) {
                int minMin = -1;
                int[] pos = new int[2];
                pos[0] = in.nextInt();
                pos[1] =  in.nextInt();
                String M = in.nextLine().substring(1);

                for(int j = 0; j < M.length() + 1; j++) {
                    int dis = manDis(pos);
                    if(dis <= M.length()+1 && j >= dis) {
                        minMin = j;
                        break;
                    }
                    if(M.length() > j) {
                        pos = moveDis(pos, M.charAt(j));
                    }
                }

                String res = minMin == -1 ? "IMPOSSIBLE" : minMin + "";
                System.out.println("Case #" + (i + 1) + ": " + res);
            }
            in.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }    
    }

    private static int manDis(int[] xy) {
        // d is always compared to 0,0
        return Math.abs(xy[0]) + Math.abs(xy[1]);
    }

    private static int[] moveDis(int[] xy, char movement) {
        switch (movement) {
            case 'N':
                xy[1] += 1;
                break;
            case 'S': 
                xy[1] -= 1;
                break;
            case 'E':
                xy[0] += 1;
                break;
            case 'W': 
                xy[0] -= 1;
                break;
            default:
                break;
        }
        return xy;
    }
}