import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();

        for(int tt = 0; tt < T; tt++) {
            String s = in.nextLine();
            String output = "";
            int glebokosc = 0;
            int idx = 0;
            while(idx != s.length()) {
                int liczba = s.charAt(idx) - '0';
                if (liczba == glebokosc) {
                    output += s.charAt(idx);
                    idx++;
                }
                else if (liczba > glebokosc) {
                    output += "(";
                    glebokosc++;
                }
                else if (liczba < glebokosc) {
                    output += ")";
                    glebokosc--;
                }
            }
            while(glebokosc > 0) {
                output += ")";
                glebokosc--;
            }
            System.out.println("Case #" + (tt+1) + ": " + output);
        }
      }
    }