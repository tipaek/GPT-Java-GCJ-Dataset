import java.util.*;

public class Solution {


    public static void main(String [] args ) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for(int tt=0;tt<t;tt++) {

            int n = scanner.nextInt();
            String [] p = new String[n];
            for(int i=0;i<n;i++) {
                p[i] = scanner.next();
                String newP = p[i];
                if(newP.charAt(0) == '*') {
                    p[i] = p[i].substring(1);
                }
            }

            Arrays.sort(p, new Comparator<String>(){
                @Override 
                public int compare(String p1, String p2) {
                    if(p1.length() > p2.length()) return -1;
                    else if(p1.length() < p2.length()) return 1;
                    else return 0;
                }
            });

            String current = p[0];
            boolean found = true;
            for(int i=1;i<n;i++) {
                if(current.contains(p[1])) {
                    continue;
                }
                else {
                    found = false;
                    break;
                }
            }

            if(found){
                System.out.println("Case #" + (tt+1) + ": " + current);
            }
            else {
                System.out.println("Case #" + (tt+1) + ": " + "*");
            }
        }

    }
}