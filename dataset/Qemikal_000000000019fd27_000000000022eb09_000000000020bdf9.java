import java.util.Scanner;

public class Solution
{
    private static String solve(int[] start, int[] end, int[] index) {
        char[] r = new char[start.length];
        int busyC = 0;
        int busyJ = 0;
        for (int i = 0; i < start.length; i++) {
            //System.out.println(i + " " + start[i] + " " + end[i] + " " + index[i]);
            if (start[i] >= busyC) {
                busyC = end[i];
                r[index[i]] = 'C';
            } else {
                if (start[i] >= busyJ) {
                    busyJ = end[i];
                    r[index[i]] = 'J';
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        String r2 = "";
        for (char t : r) {
            r2 += t;
        }
        return r2;
    }
    public static void main(String args[])
    {
        Scanner read = new Scanner(System.in);
        int cases = read.nextInt();
        for (int ca = 1; ca <= cases; ca++) {
            int n = read.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            int[] index = new int[n];
            for (int i = 0; i < n; i++) {
                start[i] = read.nextInt();
                end[i] = read.nextInt();
                index[i] = i;
            }
            
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (start[j] > start[j + 1]) {
                        int aux = start[j]; start[j] = start[j + 1]; start[j + 1] = aux;
                        aux = end[j]; end[j] = end[j + 1]; end[j + 1] = aux;
                        aux = index[j]; index[j] = index[j + 1]; index[j + 1] = aux;
                    }
                }
            }
            
            System.out.println("Case #"+ca+": "+solve(start,end,index));
            
        }
    }
}