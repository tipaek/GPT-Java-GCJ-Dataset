import java.util.Set;
import java.util.*;
public class Test{
    private static Scanner sc;
    static int tn = 1;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            solve();
        }
    }
    private static void solve(){
        int n = sc.nextInt();
        int [][] mat = new int [n][2];
        int [][] matSort = mat.clone();
        char person = 'J';
        char[] chars = new char[n];
        Stack<int[]> JStack = new Stack<>();
        Stack<int[]> CStack = new Stack<>();
        boolean impossible = false;
        Map<int[], Integer> map = new HashMap<>();
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                mat[i][j] = sc.nextInt();
            }
            map.put(mat[i],i);
        }
        
        Arrays.sort(matSort , new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        
        for(int i = 0; i < matSort.length; i++){
            chars[map.get(matSort[i])] = person;
            if(i < matSort.length - 1 && Overlap(matSort[i],matSort[i+1])){
                if(person == 'J'){
                    JStack.push(matSort[i]);
                    person = getPerson(person);
                    if(!CStack.isEmpty() && Overlap(CStack.peek(),matSort[i+1])){
                        impossible = true;
                        break;
                    }
                }
                
                else{
                    CStack.push(matSort[i]);
                    person = getPerson(person);
                    if(!JStack.isEmpty() && Overlap(JStack.peek(),matSort[i+1])){
                        impossible = true;
                        break;
                    }
                }
            }
            else{
                
                if(person == 'J'){
                    JStack.push(matSort[i]);
                }
                else{
                    CStack.push(matSort[i]);
                }
            }
         }
         System.out.println("Case #" + (tn++) + ": " + (impossible ? "IMPOSSIBLE" : new String(chars)));
         
    }
    
    private static char getPerson(char p){
        return p == 'J' ? 'C' : 'J';
    }
    
    private static boolean Overlap(int[] a, int[] b){
        return a[1] > b[0];
    }
}
