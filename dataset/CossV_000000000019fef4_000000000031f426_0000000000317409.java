import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int k = 1; k <= t; k++) {
            String[] xy = sc.nextLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            int px = 0;
            int py = 0;
            String path = xy[2];
            int mins = -1;
            aa: for (int i = 0; i < path.length(); i++) {
                char c = path.charAt(i);
                switch (c) {
                    case 'N':
                        py--;
                        if (x > px) {
                            x--;
                        } else if (x < px) {
                            x++;
                        } else {
                            // We are on same X
                            if (y == py) {
                                mins = i;
                                break aa;
                            } else if (y < py) {
                                y++;
                            } else {
                                y--;
                            }
                        }
                        if (x == px && y == py) {
                            mins = i;
                            break aa;
                        }
                        break;
                    case 'S':
                        py++;
                        if (x > px) {
                            x--;
                        } else if (x < px) {
                            x++;
                        } else {
                            // We are on same X
                            if (y == py) {
                                mins = i;
                                break aa;
                            } else if (y < py) {
                                y++;
                            } else {
                                y--;
                            }
                        }
                        if (x == px && y == py) {
                            mins = i;
                            break aa;
                        }
                        break;
                    case 'E':
                        px++;
                        if (y > py) {
                            y--;
                        } else if (y < py) {
                            y++;
                        } else {
                            // We are on same X
                            if (x == px) {
                                mins = i;
                                break aa;
                            } else if (x < px) {
                                x++;
                            } else {
                                x--;
                            }
                        }
                        if (x == px && y == py) {
                            mins = i;
                            break aa;
                        }
                        break;
                    case 'W':
                        px--;
                        if (y > py) {
                            y--;
                        } else if (y < py) {
                            y++;
                        } else {
                            // We are on same X
                            if (x == px) {
                                mins = i;
                                break aa;
                            } else if (x < px) {
                                x++;
                            } else {
                                x--;
                            }
                        }
                        if (x == px && y == py) {
                            mins = i;
                            break aa;
                        }
                        break;
                }
            }

            String minsString = mins == -1 ? "IMPOSSIBLE" : (mins + 1) + "";
            System.out.println("Case #" + k + ": " + minsString);
        }
    }
}
