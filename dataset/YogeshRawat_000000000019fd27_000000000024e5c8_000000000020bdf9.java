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
            System.out.println("Case #" + i + ": "+ result(activities));
        }
    }
    public static String result(List<int[]> activities) {
        List<int[]> listOfBooking = new ArrayList<>(); // C
        List<int[]> doubleBooking = new ArrayList<>(); // J
        StringBuilder stringBuilder = new StringBuilder();
        for( int [] str : activities) {
            int start = str[0];
            int end =  str[1];
            if( listOfBooking.size() == 0 ) {
                listOfBooking.add( new int[] { start, end } );
                stringBuilder.append("C");
                continue;
            }
            for( int[] temp : doubleBooking ) {
                if( Math.max( start, temp[0]) < Math.min( end, temp[1])) {
                    stringBuilder.setLength(0);
                    stringBuilder.append("IMPOSSIBLE");
                    break;
                }
            }
            if( stringBuilder.toString().equals("IMPOSSIBLE"))
                break;
            boolean flag = true;
            for( int[] temp : listOfBooking ) {
                if( Math.max( start, temp[0]) < Math.min( end, temp[1]))  {
                    doubleBooking.add(new int[]{Math.max( start, temp[0]), Math.min( end, temp[1])});
                    stringBuilder.append("J");
                    flag = false;
                    break;
                }
            }
            if( flag) {
                listOfBooking.add( new int[] { start, end } );
                stringBuilder.append("C");
            }
        }
        return stringBuilder.toString();
    }
}