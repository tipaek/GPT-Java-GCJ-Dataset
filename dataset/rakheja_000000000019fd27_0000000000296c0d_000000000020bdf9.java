
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
        int[][] kobe = new int[N][2];
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
        kobe = m.clone();
        Arrays.sort(kobe,new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        char p = 'C';
        boolean imp22= false;

        for (int i = 0; i < kobe.length; i++) {
            chars[map.get(kobe[i])] = p;
            if(i!=kobe.length-1 && method2(kobe[i],kobe[i+1])){
                if(p=='J'){
                    js.push(kobe[i]);
                    p = invert(p);

                    if(!cs.isEmpty() && method2(cs.peek(),kobe[i+1])){
                        imp22= true;
                        break;
                    }
                }else{
                    cs.push(kobe[i]);
                    p = invert(p);

                    if(!js.isEmpty() && method2(js.peek(),kobe[i+1])){
                        imp22= true;
                        break;
                    }
                }
            }else{
                if(p=='J')
                    js.push(kobe[i]);
                else
                    cs.push(kobe[i]);
            }
        }
        System.out.println("Case #"+currentCase+": "+ (imp22? "IMPOSSIBLE" : new String(chars)));
        currentCase++;
    }

    public static char invert(char c){
        if(c=='C') return 'J';
        if(c=='J') return 'C';
        return '0';
    }

    public static boolean method2(int[] x,int[] y){
        return x[1]- y[0]>0;
    }
}
