import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        int counter = 1;

        while(testCases -- > 0) {
            String input = sc.nextLine();
            String[] inputs = input.split(" ");
            int X = Integer.parseInt(inputs[0]);
            int Y = Integer.parseInt(inputs[1]);
            String D = inputs[2];

            boolean b = false;
            int count = 0;

            for(int i = 0; i < D.length(); i++) {
                char c = D.charAt(i);
                if(c == 'S'){
                    Y--;
                }
                if(c == 'N') {
                    Y++;
                }
                int distance = getDistance(new int[]{X,Y}, new int[]{0, 0});
                if(distance <= D.length() && distance <= i+1) {
                    count = i + 1;
                    b = true;
                    break;
                }
            }
            if(b == false)
                System.out.println("Case #"+counter+": IMPOSSIBLE");
            else{
                System.out.println("Case #"+counter+": "+count);
            }
            counter++;
        }
    }

    private static int getDistance(int[] arr, int[] goal) {
        int x = Math.abs(goal[0] - arr[0]);
        int y = Math.abs((goal[1] - arr[1]));
        return x + y;
    }
}