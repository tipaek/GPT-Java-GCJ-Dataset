import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();

        for (int testcase = 0; testcase < t; testcase++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x % 2 != 0 && y % 2 != 0) {
                System.out.println("Case #" + (testcase + 1) + ": IMPOSSIBLE");
                continue;
            }

            boolean possible = true;
            int curx = 0, cury = 0;
            int xdist = Math.abs(x - curx);
            int ydist = Math.abs(y - cury);
            StringBuilder direction = new StringBuilder();

            if (x % 2 != 0) {
                if (ydist == 0 || xdist < ydist) {
                    if (x < 0) {
                        direction.append("W");
                        curx -= 1;
                    } else {
                        curx += 1;
                        direction.append("E");
                    }
                } else if (ydist < xdist) {
                    if (x < 0) {
                        direction.append("E");
                        curx += 1;
                    } else {
                        curx -= 1;
                        direction.append("W");
                    }
                } else {
                    possible = false;
                }
            } else if (y % 2 != 0) {
                if (xdist == 0 || ydist < xdist) {
                    if (y < 0) {
                        direction.append("S");
                        cury -= 1;
                    } else {
                        cury += 1;
                        direction.append("N");
                    }
                } else if (xdist < ydist) {
                    if (y < 0) {
                        direction.append("N");
                        cury += 1;
                    } else {
                        cury -= 1;
                        direction.append("S");
                    }
                } else {
                    possible = false;
                }
            }

            xdist = Math.abs(x - curx);
            ydist = Math.abs(y - cury);
            int tempdistx = xdist, tempdisty = ydist;

            if (tempdistx < tempdisty) {
                possible = updateDirection(x, y, direction, possible, tempdistx, tempdisty, "W", "E", "S", "N");
            } else if (tempdisty < tempdistx) {
                possible = updateDirection(x, y, direction, possible, tempdisty, tempdistx, "S", "N", "W", "E");
            } else {
                possible = false;
            }

            System.out.println("Case #" + (testcase + 1) + ": " + (possible ? direction.toString() : "IMPOSSIBLE"));
        }
    }

    private static boolean updateDirection(int x, int y, StringBuilder direction, boolean possible, int primaryDist, int secondaryDist, String primaryNegDir, String primaryPosDir, String secondaryNegDir, String secondaryPosDir) {
        while (primaryDist > 1) {
            if (primaryDist % 2 == 0) {
                direction.append(x < 0 ? primaryNegDir : primaryPosDir);
                primaryDist /= 2;
            } else {
                possible = false;
                break;
            }
            if (secondaryDist % 2 == 0) {
                secondaryDist /= 2;
            } else {
                possible = false;
                break;
            }
        }

        while (secondaryDist > 1) {
            if (secondaryDist % 2 == 0) {
                direction.append(y < 0 ? secondaryNegDir : secondaryPosDir);
                secondaryDist /= 2;
            } else {
                possible = false;
                break;
            }
        }
        return possible;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}