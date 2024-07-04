import java.util.Scanner;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=1;i<=T;i++) {
            int N = sc.nextInt();
            String[] s = new String[N];
            for(int j=0;j<N;j++) {
                s[j]=sc.next();
            }
            int sl = -1;
            int sli=-1;
            for(int j=0;j<N;j++) {
                if(s[j].length()>sl){
                    sl=s[j].length();
                    sli=j;
                }
            }
            String reg ="\\*";
            String ns=s[sli].replaceAll(reg,"");
            boolean ist =true;
            for(int j=0;j<N;j++) {
                String nns=s[j].replaceAll(reg,"[A-Z]*");
                if(!Pattern.matches(nns,ns)){
                    ist = false;
                }
            }
            if(ist){
                System.out.println("Case #"+i+": "+ns);
            } else{
                System.out.println("Case #"+i+": *");
            }

        }
    }
}
