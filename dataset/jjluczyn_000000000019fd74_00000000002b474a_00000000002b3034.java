import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int tests = sc.nextInt();
        for (int test = 0; test < tests; test++) {
            int patternsN = sc.nextInt(); sc.nextLine();
            int leftTop = 0;
            int rightTop = 199;
            char[] sol = new char[200];
            boolean can = true;
            for (int i = 0; i < patternsN; i++) {
                String[] name = sc.nextLine().split("\\*");
                for (int j = 0; j < name[0].length(); j++) {
                    if (sol[j]==0){
                        sol[j] = name[0].charAt(j);
                    } else {
                        if (sol[j]!=name[0].charAt(j)){
                            can = false;
                            break;
                        }
                    }
                }
                int n1l = name[1].length();
                for (int j = 0; j < n1l; j++) {
                    if (sol[199-j]==0){
                        sol[199-j]=name[1].charAt(n1l-1-j);
                    }
                    else {
                        if (sol[199-j]!=name[1].charAt(n1l-1-j)){
                            can = false;
                            break;
                        }
                    }
                }
            }
            pw.printf("Case #%d: ",test+1);
            if (!can)pw.println("*");
            else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 200; i++) {
                    if (sol[i]!=0)sb.append(sol[i]);
                }
                pw.println(sb.toString());
            }
        }
        pw.flush();
        pw.close();

    }
}
