import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        int actual = 0;
        while (actual++ < T) {
            int tasks = scan.nextInt();
            List<Integer> CStart = new ArrayList<>();
            List<Integer> CEnd = new ArrayList<>();
            List<Integer> JStart = new ArrayList<>();
            List<Integer> JEnd = new ArrayList<>();
            List<Integer> intervalStart = new ArrayList<>();
            List<Integer> intervalEnd = new ArrayList<>();
            CStart.add(scan.nextInt());
            CEnd.add(scan.nextInt());
            JStart.add(scan.nextInt());
            JEnd.add(scan.nextInt());
            StringBuilder out = new StringBuilder("CJ");
            for (int i = 2; i < tasks; i++) {
                intervalStart.add(scan.nextInt());
                intervalEnd.add(scan.nextInt());
            }
            boolean notC = false;
            boolean notJ = false;
            for (int i = 0; i < tasks-2; i++) {
                notC = false;
                notJ = false;
                for (int j = 0; j <CStart.size(); j++) {
                    if(overlaps(intervalStart.get(i),intervalEnd.get(i),CStart.get(j),CEnd.get(j)))
                    {
                        notC=true;
                        break;
                    }
                }
                for (int j = 0; j <JStart.size(); j++) {
                    if(overlaps(intervalStart.get(i),intervalEnd.get(i),JStart.get(j),JEnd.get(j)))
                    {
                        notJ=true;
                        break;
                    }
                }


                if (!notC) {
                    CStart.add(intervalStart.get(i));
                    CEnd.add(intervalEnd.get(i));
                    out.append("C");
                } else if (!notJ) {
                    JStart.add(intervalStart.get(i));
                    JEnd.add(intervalEnd.get(i));
                    out.append("J");
                } else {
                    System.out.printf("Case #%d: IMPOSSIBLE\n", actual);
                    break;
                }
            }
            if (!notC || !notJ) {
                System.out.printf("Case #%d: " + out + "\n", actual);
            }

        }
    }
        public static boolean overlaps(int start1, int end1,int start2, int end2) {

            return start2> start1 && start2<end1 || end2<end1 && end2>start1 || start1>start2 && start1<end2 || end1<end2 && end1>start2;
        }

}