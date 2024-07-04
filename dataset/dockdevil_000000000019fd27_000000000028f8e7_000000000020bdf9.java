import javax.swing.text.html.CSS;
import java.util.*;

public class Solution{
    private static Scanner sc;
    static int tn = 1;
    public static void main(String args[]){
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            create();
        }
    }
    
    private static void create(){
        int n = sc.nextInt();
        int[][] grid = new int[n][2];
        int[][] gridSo = grid.clone();
        char per = 'J';
        char[] chars = new char[n];
        Stack<int[]> Js = new Stack<>();
        Stack<int[]> Cs = new Stack<>();
        boolean na = false;
        Map<int[], Integer> map = new HashMap<>();
        for(int i=0;i<grid.length; i++){
            for(int j=0;j<grid[i].length; j++){
                grid[i][j] = sc.nextInt();
            }
            map.put(grid[i], i);
        }
        Arrays.sort(gridSo, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        for(int i=0;i<gridSo.length;i++){
            chars[map.get(gridSo[i])] = per;
            if(i < gridSo.length-1 && Overlap(gridSo[i], gridSo[i+1])) {
                if(per == 'J'){
                    Js.push(gridSo[i]);
                    per = getPerson(per);
                    if(!Cs.isEmpty() && Overlap(Cs.peek(), gridSo[i+1])){
                        na = true;
                        break;
                    }
                } else {
                    Cs.push(gridSo[i]);
                    per = getPerson(per);
                    if(!Js.isEmpty() && Overlap(Js.peek(), gridSo[i+1])) {
                        na = true;
                        break;
                    }
                }
            } else {
                if(per == 'J'){
                    Js.push(gridSo[i]);
                } else {
                    Cs.push(gridSo[i]);
                }
            }
        }
        System.out.println("Case #" + (tn++) + ": " + (na ? "IMPOSSIBLE" : new String(chars)));
    }
    private static char getPerson(char p){
        return p == 'J' ? 'C': 'J';
    }
    
    private static boolean Overlap(int[] x, int[] y){
        return x[1] > y[0];
    }
}