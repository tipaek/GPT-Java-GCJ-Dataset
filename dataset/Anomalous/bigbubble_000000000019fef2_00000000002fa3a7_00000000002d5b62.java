import java.io.*;
import java.util.*;

public class Solution {
    static Scanner sc;

    public static void main(String[] args) throws IOException{
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = sc.nextInt(); 
        for (int i = 1; i <= t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            boolean isXPositive = x >= 0;
            boolean isYPositive = y >= 0;

            x = Math.abs(x);
            y = Math.abs(y);

            ArrayList<String> moves = new ArrayList<>();
            boolean possible = true;

            while (x > 0 || y > 0) {
                if (x > 0 && y == 0) {
                    if (x % 2 == 0) {
                        possible = false;
                        break;
                    } else if (x == 1) {
                        moves.add("W");
                        x = 0;
                    } else if (x % 4 == 1) {
                        moves.add("E");
                        x = (x + 1) / 2;
                    } else if (x % 4 == 3) {
                        moves.add("W");
                        x = (x - 1) / 2;
                    }
                } else if (y > 0 && x == 0) {
                    if (y % 2 == 0) {
                        possible = false;
                        break;
                    } else if (y == 1) {
                        moves.add("N");
                        y = 0;
                    } else if (y % 4 == 1) {
                        moves.add("S");
                        y = (y + 1) / 2;
                    } else if (y % 4 == 3) {
                        moves.add("N");
                        y = (y - 1) / 2;
                    }
                } else {
                    if (x % 2 == 1 && y % 2 == 0) {
                        if (y % 4 == 0) {
                            if (x % 4 == 1) {
                                moves.add("E");
                                x = (x + 1) / 2;
                            } else if (x % 4 == 3) {
                                moves.add("W");
                                x = (x - 1) / 2;
                            }
                        } else if (y % 4 == 2) {
                            if (x % 4 == 1) {
                                moves.add("W");
                                x = (x - 1) / 2;
                            } else {
                                moves.add("E");
                                x = (x + 1) / 2;
                            }
                        }
                    } else if (y % 2 == 1 && x % 2 == 0) {
                        if (x % 4 == 0) {
                            if (y % 4 == 1) {
                                moves.add("S");
                                y = (y + 1) / 2;
                            } else if (y % 4 == 3) {
                                moves.add("N");
                                y = (y - 1) / 2;
                            }
                        } else if (x % 4 == 2) {
                            if (y % 4 == 1) {
                                moves.add("N");
                                y = (y - 1) / 2;
                            } else {
                                moves.add("S");
                                y = (y + 1) / 2;
                            }
                        }
                    } else {
                        possible = false;
                        break;
                    }
                    x /= 2;
                    y /= 2;
                }
            }

            StringBuilder result = new StringBuilder();
            if (!possible) {
                result.append("IMPOSSIBLE");
            } else {
                for (String move : moves) {
                    if (isXPositive) {
                        if (move.equals("W")) move = "E";
                        else if (move.equals("E")) move = "W";
                    }
                    if (!isYPositive) {
                        if (move.equals("N")) move = "S";
                        else if (move.equals("S")) move = "N";
                    }
                    result.append(move);
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}