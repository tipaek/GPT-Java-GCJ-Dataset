import javax.swing.text.html.CSS;
import java.util.*;

public class solution{
    private static Scanner sc;
    static int tn = 1;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        sc.nextLine();
        
        while(t-- > 0){
            solve();
        }
    }
    
    private static void solve(){
        int n = sc.nextInt();
        int[][] mat = new int[n][2];
        int[][] matSorted = mat.clone();
        char person = 'J';
        char[] chars = new char[n];
        Stack<int[]> jstack = new Stack<>();
        Stack<int[]> cstack = new Stack<>();
        boolean impossible = false;
        
        Map<int[], Integer> map = new HashMap<>();
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat.length; j++){
                mat[i][j] = sc.nextInt();
            }
            map.put(mat[i], i);
        }
        
        Arrays.sort(matSorted, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        
        for(int i = 0; i < matSorted.length; i++)
        {
            chars[map.get(matSorted[i])] = person;
            if(i < matSorted.length - 1 && doesoverlap(matSorted[i], matSorted[i+1]))
            {
                if(person == 'J')
                {
                    person = getperson(person);
                    if(!cstack.isEmpty() && doesoverlap(cstack.peek(),matSorted[i+1]))
                    {
                        impossible = true;
                        break;
                    }
                }
                else
                {
                    cstack.push(matSorted[i]);
                    if(!cstack.isEmpty() && doesoverlap(jstack.peek(),matSorted[i+1]))
                    {
                        impossile = true;
                        break;
                    }
                }
            }
            else
            {
                if(person == 'J')
                {
                    jstack.push(matSorted[i]);
                }
                else
                {
                    cstack.push(matSorted[i]);
                }
            }
        }
        
        System.out.println("Case #" + (tn++) + ":" + (impossible?"IMPOSSIBLE":new String(chars)));
    }
    
    private static char getperson(char p)
    {
        return p == 'J'?'C':'J';
    }

    private static boolean doesoverlap(int a[], int b[])
    {
        return a[1] > b[0];
    }
}
