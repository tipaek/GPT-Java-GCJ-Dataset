
import java.util.Scanner;

public class Pat {
    public static void main(String[] args) {
        new Pat().main2();
    }
    
    Scanner scan;
    int N;
    String[] P=new String[55];
    
    void main2() {
        int i,tc;
        scan=new Scanner(System.in);
        tc=scan.nextInt();
        for (i=1;i<=tc;i++) {
            System.out.print("Case #"+i+": ");
            problem();
        }
    }
    
    void problem() {
        int i;
        int p,p1,p2;
        String middle,start,end,s,e;
        N=scan.nextInt();
        for (i=0;i<N;i++) P[i]=scan.next();
        middle=start=end="";
        for (i=0;i<N;i++) {
            p=(P[i]+"*").indexOf("*");
            if (p>start.length()) start=P[i].substring(0,p);
            p=("*"+P[i]).lastIndexOf("*");
            if (P[i].length()-p > end.length() ) end=P[i].substring(p);
        }
        for (i=0;i<N;i++) {
            p1=(P[i]+"*").indexOf("*");
            p2=p=("*"+P[i]).lastIndexOf("*");
            s=P[i].substring(0,p1);
            e=P[i].substring(p2);
            if (!start.startsWith(s)) { System.out.println("*"); return; }
            if (!end.endsWith(e)) { System.out.println("*"); return; }
            if (p2>p1) middle+=P[i].substring(p1,p2).replace("*","");
        }
        System.out.println(start+middle+end);
    }
    
    
}
