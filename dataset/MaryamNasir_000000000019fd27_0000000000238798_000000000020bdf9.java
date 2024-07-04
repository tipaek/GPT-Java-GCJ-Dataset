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
            int[][] jam = new int[n][2];
            int[][] cameron = new int[n][2];
            int jamCount = 0, camCount = 0;
            for(int j=0; j<n; j++) {
                String[] timeString = scanner.nextLine().split(" ");
                times[j][0] = Integer.parseInt(timeString[0]);
                times[j][1] = Integer.parseInt(timeString[1]);
            }
            for(int j=0; j<n; j++ ) {
                boolean first = true;
                boolean second =true;
                //boolean impossible = false;
                for(int k=0; k<jamCount; k++) {

                    if(overlap(times[j][0], times[j][1], jam[k][0], jam[k][1])) {
                        first = false;
                        break;
                    }
                }
                if(!first) {
                    for(int k=0; k<camCount; k++) {
                        if(overlap(times[j][0], times[j][1], cameron[k][0],cameron[k][1])) {
                            second = false;
                            break;
                        }
                    }
                    if(!second) {
                        //System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
                        persons = "IMPOSSIBLE";
                    //    impossible = true;
                        break;
                    } else {
                        cameron[camCount][0] = times[j][0];
                        cameron[camCount][1] = times[j][1];
                        camCount++;
                        persons += "C";
                    }

                } else {
                    jam[jamCount][0] = times[j][0];
                    jam[jamCount][1] = times[j][1];
                    jamCount++;
                    persons += "J";
                }


            }

           // String result = new String(persons);
            System.out.println("Case #" + (i+1) + ": " + persons);
        }

    }
}
