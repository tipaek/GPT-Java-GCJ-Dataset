import java.util.*;

public class Soluton {
    private static Scanner sc;
    static int tn = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            slove();
        }

    }

    private static void slove() {
        int n = sc.nextInt();
        int[][] mat = new int[n][2];
        int[][] matSorted = mat.clone();
        char person = 'J';
        char[] cahrs = new char[n];
        Stack<int[]> JStack = new Stack<>();
        Stack<int[]> CStack = new Stack<>();
        boolean imossible = false;

        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.nextInt();

            }
            map.put(mat[i], i);

        }

        Arrays.sort(matSorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for(int i =0 ;i<matSorted.length;i++){
            if(i < matSorted.length-1 && doesOverlap(matSorted[i], matSorted[i+1])){
                if(person == 'J'){
                    JStack.push(matSorted[i]);
                    person = getPerson(person);
                    
                    if(!CStack.isEmpty()&& doesOverlap(CStack.peek(),matSorted[i+1])) {
                        imossible = true;

                        break;
                    }

                
                }
                else{
                    CStack.push(matSorted[i]);
                    person = getPerson(person);
                    if(!JStack.isEmpty()&& doesOverlap(JStack.peek(),matSorted[i+1])) {
                    imossible = true;

                    break;
                    }
                    }
                }
            
            else{
                
                if(person == 'J'){
                    JStack.push(matSorted[i]);
                }
                else{
                    CStack.push(matSorted[i]);
                }
            }
        
        }System.out.println("Case #"+(tn++)+":"+(imossible?"IMPOSSIBLE":new String(chars)));

    }
    private static char getPerson(char p) {
        return p == 'J' ? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
}


