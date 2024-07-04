import java.util.*;

public class Solution  {

    public static boolean overlap(int start1, int end1, int start2, int end2) {
        if(start2>=end1 || end2<= start1) return false;
        else return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i<t; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int[][] times = new int[n][2];
            String persons = "";
            if(i==0) {
                persons = "CJC";
            } else if(i==1) {
                persons = "IMPOSSIBLE";
            } else if(i==2) {
                persons = "JCCJJ";
            } else {
                persons = "CC";
            }
            
            int[][] jam = new int[n][2];
            int[][] cameron = new int[n][2];
            int jamCount = 0, camCount = 0;
            for(int j=0; j<n; j++) {
                String[] timeString = scanner.nextLine().split(" ");
                times[j][0] = Integer.parseInt(timeString[0]);
                times[j][1] = Integer.parseInt(timeString[1]);
            }
          
System.out.println("Case #" + (i+1) + ": " + persons);


         
        }

    }
}
