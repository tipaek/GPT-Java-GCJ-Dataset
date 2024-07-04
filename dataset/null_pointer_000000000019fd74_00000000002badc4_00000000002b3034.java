import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int m = 1;
        int num;
        ArrayList<String> str;

        while(t > 0) {
            num = sc.nextInt();
            str = new ArrayList<String>();

            sc.nextLine();

            for(int i = 0; i < num; i++) {
                str.add(sc.nextLine());
            }

            System.out.println(str);

            String largestString = str.get(0);
            //int index = 0;
            int compare;

            for(int i = 0; i < str.size(); i++) {
                compare = largestString.compareTo(str.get(i));
                if(compare > 0) {
                    largestString = str.get(i);
                    //index = i;
                }

                System.out.println(largestString);
            }


            System.out.println("Case #"+ m + ": " + largestString.replaceAll("\\*", ""));

            t--;
            m++;
        }
    }
}
