import java.util.*;

public class Solution {

    static Scanner src = new Scanner(System.in);

    public static class Pair{
        int start;
        int end;
        int index;
        char c;
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
                pp.index = i;
                p[i] = pp;
            }


            Arrays.sort(p, new Comparator<Pair>() {
                public int compare(Pair a, Pair b) {
                    return a.start - b.start;
                }
            });

            String ans = solve(p);

            if(ans.equals("IMPOSSIBLE")) {
                print(caseNum, ans);
            }else{
                Arrays.sort(p, new Comparator<Pair>() {
                    public int compare(Pair a, Pair b) {
                        return a.index - b.index;
                    }
                });
                StringBuilder str = new StringBuilder("");

                for(Pair pp: p){
                    str.append(pp.c);
                }
                print(caseNum,str.toString());
            }
            caseNum++;

        }
    }

    private static String solve(Pair[] p) {

        StringBuilder ans = new StringBuilder("");

        int c = -1;
        int j = -1;

        for (Pair pair : p) {
            if (c == -1 || pair.start >= c) {
                ans.append("C");
                c = pair.end;
                pair.c = 'C';
            } else if (j == -1 || pair.start >= j) {
                ans.append("J");
                j = pair.end;
                pair.c = 'J';
            } else {
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
