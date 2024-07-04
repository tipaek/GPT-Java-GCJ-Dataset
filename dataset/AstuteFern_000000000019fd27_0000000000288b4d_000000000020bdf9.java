
import java.util.*;

public class Solution {
    static Scanner sc;
    static int currentCase = 1;

    public static void main(String[] args){
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            solveCase();
        }
    }

    public static void solveCase() {
        int N = sc.nextInt();

        int[][] m = new int[N][2];
        int[][] msort = new int[N][2];
        char[] chars = new char[N];
        Stack<int[]> cs = new Stack<>();
        Stack<int[]> js = new Stack<>();

        HashMap<int[],Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <2; j++) {
                m[i][j] = sc.nextInt();
            }
            map.put(m[i],i);
        }
        msort = m.clone();
        Arrays.sort(msort,new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        char p = 'C';
        boolean imp = false;

        for (int i = 0; i < msort.length; i++) {
            chars[map.get(msort[i])] = p;
            if(i!=msort.length-1 && overlaps(msort[i],msort[i+1])){
                if(p=='J'){
                    js.push(msort[i]);
                    p = invert(p);

                    if(!cs.isEmpty() && overlaps(cs.peek(),msort[i+1])){
                        imp = true;
                        break;
                    }
                }else{
                    cs.push(msort[i]);
                    p = invert(p);

                    if(!js.isEmpty() && overlaps(js.peek(),msort[i+1])){
                        imp = true;
                        break;
                    }
                }
            }else{
                if(p=='J')
                    js.push(msort[i]);
                else
                    cs.push(msort[i]);
            }
        }
        System.out.println("Case #"+currentCase+": "+ (imp ? "IMPOSSIBLE" : new String(chars)));
        currentCase++;
    }

    public static char invert(char c){
        if(c=='C') return 'J';
        if(c=='J') return 'C';
        return '0';
    }

    public static boolean overlaps(int[] x,int[] y){
        return x[1]- y[0]>0;
    }
}
