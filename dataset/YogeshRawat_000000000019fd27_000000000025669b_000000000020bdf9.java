import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.valueOf(sc.nextLine().trim());
        for (int i = 1; i <= testCases; i++) {
            int size = Integer.parseInt(sc.nextLine());
            List<int[]> activities = new ArrayList<>();
            for( int j =0; j < size; j++ ) {
                String[] str = sc.nextLine().trim().split(" ");
                int start = Integer.valueOf(str[0].trim());
                int end = Integer.valueOf(str[1].trim());
                activities.add( new int[]{start, end} );
            }
            System.out.println("Case #" + i + ": "+ result1(activities));
        }
    }
    public  static boolean canAdd(List<int[]> booking, int start, int end ) {
         if( booking.size() == 0 ){
             booking.add( new int[]{ start, end });
             return true;
         }else{
             for( int[] b : booking ){
                if (Math.max(b[0], start) < Math.min(b[1], end))
                    return false;
             }
             booking.add( new int[]{ start, end });
             return true;
         }
    }
    public static String result1(List<int[]> activities) {
        List<int[]> listOfBooking = new ArrayList<>(); // C
        List<int[]> doubleBooking = new ArrayList<>(); // J
        StringBuilder stringBuilder = new StringBuilder();
        for( int [] str : activities) {
            int start = str[0];
            int end = str[1];

            if( canAdd( listOfBooking, start ,end)) {
                stringBuilder.append("C");
            }else if(canAdd( doubleBooking, start ,end)) {
                stringBuilder.append("J");
            }else {
                return "IMPOSSIBLE";
            }
        }
        return stringBuilder.toString();
    }
}