import java.util.*;

public class Solution {
    private static Scanner scanner;
    
    static int test = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        scanner.nextLine();
        
        while (T-- > 0) {
            solve();
        }
    }

    private static void solve()
    {
        int N = scanner.nextInt();
        
        int[][] M = new int[N][2];
        int[][] MSorted = new int[N][2];
        
        char person = 'J';
        
        char[] chars = new char[N];
        
        Stack<int[]> JStack = new Stack<>();
        Stack<int[]> CStack = new Stack<>();
        
        boolean impossible = false;
        
        Map<int[], Integer> map = new HashMap<>();
        
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                M[i][j] = scanner.nextInt();
            }
            
            map.put(M[i], i);
        }
        
        Arrays.sort(MSorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        for (int i = 0; i < MSorted.length; i++) {
            chars[map.get(MSorted[i])] = person;
            
            if (i < MSorted.length - 1 && doesOverlap(MSorted[i], MSorted[i+1])){
                if (person == 'J') {
                    JStack.push(MSorted[i]);
                    
                    person = getPerson(person);
                    
                    if (!CStack.isEmpty() && doesOverlap(CStack.peek(), MSorted[i+1])) {
                        impossible = true;
                        
                        break;
                    }
                }
                else {
                    CStack.push(MSorted[i]);
                    
                    person = getPerson(person);
                    
                    if (!JStack.isEmpty() && doesOverlap(JStack.peek(), MSorted[i+1])) {
                        impossible = true;
                        
                        break;
                    } 
                }
            }
            else {
                if (person == 'J') {
                    JStack.push(MSorted[i]);
                }
                else {
                    CStack.push(MSorted[i]);
                }
            }
        }
        
        System.out.println("Case #" + (test++) + ": " + (impossible ? "IMPOSSIBLE" : new String(chars)));
    }
    
    private static char getPerson(char p) {
        return p == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}