import java.util.*;

public class Solution {
    private static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int tc = sc.nextInt();
        sc.nextLine();
        for (int t = 1; t <= tc; t++){
            solve(t);
        }
    }

    private static void solve(int t) {
        int n = sc.nextInt();
            int[][] turns = new int[n][2];
            int[][] turnsSorted = turns.clone();
            char person = 'J';
            char[] res = new char[n];
            Stack<int[]> jamie = new Stack<>();
            Stack<int[]> cameron = new Stack<>();
            boolean impossible = false;
            Map<int[], Integer> map = new HashMap<>();
            
            for (int i = 0; i < turns.length; i++) {
                for (int j = 0; j < turns[i].length; j++) {
                    turns[i][j] = sc.nextInt();
                }
                map.put(turns[i], i);
            }

            Arrays.sort(turnsSorted, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b){
                    return a[0] - b[0];
                }
            });

            for (int i = 0; i < turnsSorted.length; i++) {
                res[map.get(turnsSorted[i])] = person;
                if (i < turnsSorted.length - 1 && overlap(turnsSorted[i], turnsSorted[i + 1])){
                    if (person == 'J'){
                        jamie.push(turnsSorted[i]);
                        person = getPerson(person);
                        
                        if (!cameron.isEmpty() && overlap(cameron.peek(), turnsSorted[i + 1])) {
                            impossible = true;
                            break;
                        }
                    }else {
                        cameron.push(turnsSorted[i]);
                        person = getPerson(person);
    
                        if (!jamie.isEmpty() && overlap(jamie.peek(), turnsSorted[i + 1])) {
                            impossible = true;
                            break;
                        }
                    }
                }else {
                    if (person == 'J') {
                        jamie.push(turnsSorted[i]);
                    }else{
                        cameron.push(turnsSorted[i]);
                    }
                }
            }

            System.out.println("Case #" + t + ": " + (impossible ? "IMPOSSIBLE" : new String(res)));
    }

    private static char getPerson(char p) {
        return p == 'J' ? 'C' : 'J';
    }

    private static boolean overlap (int[] a, int[] b){
        return a[1] > b[0];
    }
}
