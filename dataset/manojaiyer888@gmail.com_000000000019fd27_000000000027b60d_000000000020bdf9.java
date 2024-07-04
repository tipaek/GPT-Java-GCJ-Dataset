import javax.swing.text.html.CSS;
import java.util.*;

public class Solution {
    private static Scanner inn;
    static int tann = 1;
   
   
    public static void main(String[] args) {
        inn = new Scanner(System.in);
       
        int t = inn.nextInt();
        inn.nextLine();
       
       
        while(t-- > 0) {
            solve();
        }
    }
   
    private static void solve() {
        int n = inn.nextInt();
        int[][] mat = new int[n][2];
        int[][] matrixsorted = mat.clone();
        char humann = 'J';
        char[] chars = new char[n];
        Stack<int[]> JStack = new Stack<>();
        Stack<int[]> CStack = new Stack<>();
        boolean impossible = false;
       
        Map<int[], Integer> map = new HashMap<>();
       
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                mat[i][j] = inn.nextInt();
            }
            map.put(mat[i], i);
        }
       
        Arrays.sort(matrixsorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
       
       
        for(int i = 0; i < matrixsorted.length; i++) {
            chars[map.get(matrixsorted[i])] = humann;
           
            if(i < matrixsorted.length - 1 && doesOverlap(matrixsorted[i], matrixsorted[i+1])) {
                if (humann == 'J') {
                    JStack.push(matrixsorted[i]);
                    humann = getPerson(humann);
                   
                    if(!CStack.isEmpty() && doesOverlap(CStack.peek(), matrixsorted[i+1])) {
                        impossible = true;
                        break;
                    }
                }else {
                    CStack.push(matrixsorted[i]);
                    humann = getPerson(humann);
                   
                    if (!JStack.isEmpty() && doesOverlap(JStack.peek(), matrixsorted[i+1])) {
                        impossible = true;
                        break;
                    }
                }
            }else {
                if (humann == 'J') {
                    JStack.push(matrixsorted[i]);
                } else {
                    CStack.push(matrixsorted[i]);
                }
            }
        }
        System.out.println("Case #" + (tann++) + ": " + (impossible ? "IMPOSSIBLE" : new String(chars)));
    }
    private static char getPerson(char p) {
        return p == 'J' ? 'C' : 'J';
    }
   
    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}
