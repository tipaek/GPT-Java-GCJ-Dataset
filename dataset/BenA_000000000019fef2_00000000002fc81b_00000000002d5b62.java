import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(s.nextLine());
        String[] dirs;
        String ans;
        for (int q = 1; q <= cases; q++) {
            dirs = s.nextLine().split(" ");
            ans = direction(Integer.parseInt(dirs[0]),Integer.parseInt(dirs[1]));
            System.out.println("Case #"+q+": "+ans);
        }    
    }
    public static String direction(int a, int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);
        String ans = "";
        int mod = 2;
        int rem = 1;
        while (x != 0 || y != 0) {
            if (x == 0) {
                if (y == rem) {
                    if (b > 0) {
                        ans += "N";
                    }
                    else {
                        ans += "S";
                    }
                    return ans;
                }
            }
            if (y == 0) {
                if (x == rem) {
                    if (a > 0) {
                        ans += "E";
                    }
                    else {
                        ans += "W";
                    }
                    return ans;
                }
            }
            if (x % mod == rem) {
                if (y % mod == rem) {
                    return "IMPOSSIBLE";
                }
                if (y % (mod*2) == 0) {
                    if ((x+rem) % (mod*2) == 0) {
                        x -= rem;
                        if (a > 0) {
                            ans += "E";
                        }
                        else {
                            ans += "W";
                        }
                    }
                    else {
                        x += rem;
                        if (a > 0) {
                            ans += "W";
                        }
                        else {
                            ans += "E";
                        }
                    }
                }
                else {
                    if ((x+rem) % (mod*2) == 0) {
                        x += rem;
                        if (a > 0) {
                            ans += "W";
                        }
                        else {
                            ans += "E";
                        }
                    }
                    else {
                        x -= rem;
                        if (a > 0) {
                            ans += "E";
                        }
                        else {
                            ans += "W";
                        }
                    }
                }
            }
            else if (y % mod == rem) {
                if (x % (mod*2) == 0) {
                    if ((y+rem) % (mod*2) == 0) {
                        y -= rem;
                        if (b > 0) {
                            ans += "N";
                        }
                        else {
                            ans += "S";
                        }
                    }
                    else {
                        y += rem;
                        if (b > 0) {
                            ans += "S";
                        }
                        else {
                            ans += "N";
                        }
                    }
                }
                else {
                    if ((y+rem) % (mod*2) == 0) {
                        y += rem;
                        if (b > 0) {
                            ans += "S";
                        }
                        else {
                            ans += "N";
                        }
                    }
                    else {
                        y -= rem;
                        if (b > 0) {
                            ans += "N";
                        }
                        else {
                            ans += "S";
                        }
                    }
                }
            }
            else {
                return "IMPOSSIBLE";
            }
            mod *= 2;
            rem *= 2;
        }
        return ans;
    }
}