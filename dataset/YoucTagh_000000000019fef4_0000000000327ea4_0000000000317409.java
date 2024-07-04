import java.util.Scanner;

class Solution {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testCase = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCase; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve();
        }

    }

    private static void solve() {
        int x = sc.nextInt();
        int y = sc.nextInt();
        String s = sc.next();
        int x1 = 0;
        int y1 = 0;
        int moves = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'S') {
                y--;
            } else if (c == 'N') {
                y++;
            } else if (c == 'E') {
                x++;
            } else if (c == 'W') {
                x--;
            }
            moves++;
            if (!gotHim(x, y, x1, y1)) {
                if (Math.abs(x - x1) > Math.abs(y - y1)) {
                    if (x > x1)
                        x1++;
                    else
                        x1--;
                } else if(Math.abs(x - x1) < Math.abs(y - y1)) {
                    if (y > y1)
                        y1++;
                    else
                        y1--;
                }else{
                    int fx = x;
                    int fy = y;
                    for (char c1 : s.substring(i,i+Math.abs(x - x1)).toCharArray()){
                        if (c1 == 'S') {
                            fy--;
                        } else if (c1 == 'N') {
                            fy++;
                        } else if (c1 == 'E') {
                            fx++;
                        } else if (c1 == 'W') {
                            fx--;
                        }
                    }

                    if (Math.abs(fx - x1) > Math.abs(fy - y1)) {
                        if (fx > x1)
                            x1++;
                        else
                            x1--;
                    } else  {
                        if (fy > y1)
                            y1++;
                        else
                            y1--;
                    }
                }
                if (gotHim(x, y, x1, y1)) break;
            } else {
                break;
            }

        }

        if (gotHim(x, y, x1, y1))
            System.out.println(moves);
        else
            System.out.println("IMPOSSIBLE");

    }

    public static boolean gotHim(int x, int y, int x1, int y1) {
        return x == x1 && y == y1;
    }

}