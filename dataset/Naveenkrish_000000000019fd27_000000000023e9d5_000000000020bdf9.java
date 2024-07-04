import java.util.*;

public class Solution {
    private static Scanner pc;
    
    static int tn = 1;
    
    
    public static void main(String[] args) {
        pc = new Scanner(System.in);
        
        int t = pc.nextInt();
        pc.nextLine();
        
        
        while(t-- > 0) {
            solve();
        }
    }
    
    private static void solve() {
        int m = pc.nextInt();
        int[][] tat = new int[m][2];
        int[][] tatsorted = tat.clone();
        char persons = 'J';
        char[] chairs = new char[m];
        Stack<int[]> JStack = new Stack<>();
        Stack<int[]> CStack = new Stack<>();
        boolean impossible = false;
        
        Map<int[], Integer> map = new HashMap<>();
        
        for(int i = 0; i < tat.length; i++) {
            for(int j = 0; j < tat[i].length; j++) {
                tat[i][j] = pc.nextInt();
            }
            map.put(tat[i], i);
        }
        
        Arrays.sort(tatsorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        
        for(int i = 0; i < tatsorted.length; i++) {
            chairs[map.get(tatsorted[i])] = persons;
            
            if(i < tatsorted.length - 1 && doesOverlap(tatsorted[i], tatsorted[i+1])) {
                if (persons == 'J') {
                    JStack.push(tatsorted[i]);
                    persons = getPerson(persons);
                    
                    if(!CStack.isEmpty() && doesOverlap(CStack.peek(), tatsorted[i+1])) {
                        impossible = true;
                        break;
                    }
                }else {
                    CStack.push(tatsorted[i]);
                    persons = getPerson(persons);
                    
                    if (!JStack.isEmpty() && doesOverlap(CStack.peek(), tatsorted[i+1])) {
                        impossible = true;
                        break;
                    }
                }
            }else {
                if (persons == 'J') {
                    JStack.push(tatsorted[i]);
                } else {
                    CStack.push(tatsorted[i]);
                }
            }
        }
        System.out.println("Case #" + (tn++) + ": " + (impossible ? "IMPOSSIBLE" : new String(chairs)));
    }
    private static char getPerson(char p) {
        return p == 'J' ? 'C' : 'J';
    }
    
    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}