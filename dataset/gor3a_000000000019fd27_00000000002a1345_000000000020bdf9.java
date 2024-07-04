import java.util.*;

/**
 *
 * @author unknown
 */
public class Solution {
    private static Scanner sc;
    static int tq = 1;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0){
            solve();
        }
    }
    
    private static void solve(){
        int n = sc.nextInt();
        int[][] mat = new int[n][2];
        int[][] ms = mat.clone();
        char p = 'J';
        char[] c = new char[n];
        Stack<int[]> J= new Stack<>();
        Stack<int[]> C= new Stack<>();
        boolean cant = false;
        
        Map<int[], Integer> map = new HashMap<>();
        
        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j < mat[i].length;j++){
                mat[i][j] = sc.nextInt();
            }
            
            map.put(mat[i], i);
        }
        
        Arrays.sort(ms, new Comparator<int[]>(){
            @Override 
            public int compare(int[] a, int[]b){
                return a[0] - b[0];
            }
        });
        
        for(int i = 0;i<ms.length;i++){
            c[map.get(ms[i])] = p;
            
            if(i < ms.length - 1 && vaild(ms[i] , ms[i+1])){
                if(p == 'J'){
                    J.push(ms[i]);
                    p = change(p);
                    
                    if(!C.isEmpty() && vaild(C.peek() , ms[i+1])){
                        cant = true;
                        break;
                    }
                }else {
                    C.push(ms[i]);
                    p = change(p);
                    if(!J.isEmpty() && vaild(J.peek() , ms[i+1])){
                        cant = true;
                        break;
                    }
                }
            }else{
                if(p == 'J') {
                    J.push(ms[i]);
                }else{
                    C.push(ms[i]);
                }
            }
        }
        System.out.println("Case #" + (tq++) + ": " + (cant ? "IMPOSSIBLE" : new String(c)) );
    }   
    
    private static boolean vaild(int[] a , int[] b){
        return a[1] > b[0];
    }
    
    private static char change(char p){
        return p == 'J' ? 'C' : 'J';
    }
    
}
