import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.valueOf(sc.nextLine().trim());
        for (int i = 1; i <= testCases; i++) {
            int size = Integer.parseInt(sc.nextLine());
            String[] index = new String[size];
//            Set<int[]> activities = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
            List<int[]> activities = new ArrayList<>();
            for( int j =0; j < size; j++ ) {
                String[] str = sc.nextLine().trim().split(" ");
                int start = Integer.valueOf(str[0].trim());
                int end = Integer.valueOf(str[1].trim());
                activities.add( new int[]{start, end, j} );
            }
            Collections.sort( activities, Comparator.comparingInt(a -> a[0]));
            String result = result1(activities, index);
            if( result.equals("IMPOSSIBLE"))
                System.out.println("Case #" + i + ": "+ result);
            else {
                StringBuilder stringBuilder = new StringBuilder();
                for( String s : index)
                    stringBuilder.append(s);
                System.out.println("Case #" + i + ": "+ stringBuilder.toString());
            }
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
    public static String result1(List<int[]> activities, String[] index) {
        List<int[]> listOfBooking = new ArrayList<>(); // C
        List<int[]> doubleBooking = new ArrayList<>(); // J
        StringBuilder stringBuilder = new StringBuilder();
        for( int [] str : activities) {
            int start = str[0] ;
            int end = str[1];
            int in = str[2];

            if( canAdd( listOfBooking, start ,end)) {
                index[in] = "C";
                stringBuilder.append("C");
            }else if(canAdd( doubleBooking, start ,end)) {
                index[in] = "J";
                stringBuilder.append("J");
            }else {
                return "IMPOSSIBLE";
            }
        }
        return stringBuilder.toString();
    }
}