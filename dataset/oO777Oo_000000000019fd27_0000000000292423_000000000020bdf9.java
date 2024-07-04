import java.util.*;
import java.io.*;
public class Solution {
    private static Scanner c;
    static int tn = 1;

    public static void main(String[] args) throws IOException {
        c = new Scanner(System.in);

        int t = c.nextInt();
        c.nextLine();

        while (t-- > 0){
            planMaker();
        }

    }
    private static void planMaker(){
        int n = c.nextInt();
        int[][] ar = new int[n][2];
        int[][] arSorted = ar.clone();
        char person = 'J';
        char[] chars = new char[n];
        Stack<int[]> stC = new Stack<>();
        Stack<int[]> stJ = new Stack<>();
        boolean imp = false;

        Map<int[], Integer> mp = new HashMap<>();

        for(int i = 0; i< ar.length; i++){
            for(int j = 0; j < ar[i].length; j++){
                ar[i][j] = c.nextInt();
            }
            mp.put(ar[i], i);
        }

        Arrays.sort(arSorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < arSorted.length; i++){
            chars[mp.get(arSorted[i])] = person;

            if (i < arSorted.length - 1 && over(arSorted[i], arSorted[i + 1])){
                if (person == 'J'){
                    stJ.push(arSorted[i]);
                    person = getPerson(person);

                    if (!stC.isEmpty() && over(stC.peek(), arSorted[i+1])){
                        imp = true;
                        break;
                    }

                } else {
                    stC.push(arSorted[i]);
                    person = getPerson(person);

                    if (!stJ.isEmpty() && over(stJ.peek(), arSorted[i+1])){
                        imp = true;
                        break;
                    }
                }

            } else {
                if (person == 'J'){
                    stJ.push(arSorted[i]);
                } else {
                    stC.push(arSorted[i]);
                }
            }
        }

        System.out.println("Case #" + (tn ++) + ": " + (imp ? "IMPOSSIBLE" : new String(chars)));
    }
    private static boolean over(int[] a, int[] b) {
        return a[1] > b[0];
    }

    private static char getPerson(char p){
        return p == 'J' ? 'C' :'J';
    }
}
