
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        int total=t;
        while (t-->0) {
            int x = in.nextInt();
            int y = in.nextInt();
            String tour = in.next();

            //Make an array
            int arr[] = new int[tour.length()+1];
            int tempX=x;
            int tempY = y;
            boolean flag=false;
            int ans=-1;
            arr[0] = Math.abs(tempX)+Math.abs(tempY);
            for (int i=1;i<arr.length;i++) {
                switch (tour.charAt(i-1)) {
                    case 'N':
                        tempY++;
                        break;
                    case 'S':
                        tempY--;
                        break;
                    case 'E':
                        tempX++;
                        break;
                    case 'W':
                        tempX--;
                        break;
                }
                arr[i] = Math.abs(tempX)+Math.abs(tempY);
                if (arr[i]<=i) {
                    ans=i;
                    flag=true;
                    break;
                }
            }
            if (flag) {
                System.out.println("Case #"+(total-t)+": "+ ans);
                //System.out.println(ans);
            } else {
                System.out.println("Case #"+(total-t)+": "+ "IMPOSSIBLE");
            }
        }
    }
}
