import java.util.Scanner;

public class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            System.out.print("Case #"+t+": ");
            solve(sc);
        }
    }
    private static void solve(Scanner sc){
        String S = sc.next();
        System.out.println(seikei(S.toCharArray()));
    }

    private static char[] seikei(char[] sc){
        StringBuilder bld = new StringBuilder();
        //char[] sc = S.toCharArray();
        int l=0;
        int beg = 0;
        while(l < sc.length) {
            while (l < sc.length && sc[l] == '0') {
                l++;
            }
            for(int i=beg;i<l;i++){
                bld.append(sc[i]);
            }
//            bld.append(S.substring(beg, l));
            if (l == sc.length) {
                return bld.toString().toCharArray();
            }

            bld.append('(');
            beg = l;
            while(l<sc.length && sc[l] != '0'){
                l++;
            }
            char[] minus1=new char[l-beg];
            for(int i=beg;i<l;i++){
                minus1[i-beg] = (char) (sc[i]-1);
            }
            char[] res1 = seikei(minus1);
            for(int i=0;i<res1.length;i++) {
                if(res1[i] >= '0' && res1[i] <= '9'){
                    res1[i]++;
                }
                bld.append(res1[i]);
            }
            bld.append(')');
            if(l==sc.length) {
                return bld.toString().toCharArray();
            }
            beg = l;
        }
        return bld.toString().toCharArray();
    }

}
