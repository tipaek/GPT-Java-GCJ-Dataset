import java.util.*;

public class Solution {

    static Scanner src = new Scanner(System.in);

    public static class Pair{
        int start;
        int end;
    }
    public static void main(String args[]) {


        int t = src.nextInt();
        src.nextLine();
        int caseNum = 1;
        while (t-- > 0) {

            int n = src.nextInt();

            Pair p[] = new Pair[n];

            for(int i=0;i<n;i++){
                Pair pp = new Pair();
                pp.start = src.nextInt();
                pp.end = src.nextInt();
                p[i] = pp;
            }


            Arrays.sort(p, new Comparator<Pair>() {
                public int compare(Pair a, Pair b) {
                    return a.start - b.start;
                }
            });

            String ans = solve(p);

            print(caseNum,ans);

        }
    }

    private static String solve(Pair[] p) {

        StringBuilder ans = new StringBuilder("");

        int c = -1;
        int j = -1;

        for(int i=0;i<p.length;i++){
            if(c==-1 || p[i].start>=c){
                ans.append("C");
                c = p[i].end;
            }else if(j==-1 || p[i].start>=j){
                ans.append("J");
                j = p[i].end;
            }else {
                ans = new StringBuilder("IMPOSSIBLE");
                return ans.toString();
            }
        }
        return ans.toString();
    }


    public static void print(int caseNum, String output){

        System.out.println("Case #"+caseNum+": "+output);
    }

}
