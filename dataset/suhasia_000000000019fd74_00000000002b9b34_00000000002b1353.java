import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            int n = in.nextInt();
            int half = (n+1)/2;
            System.out.println("Case #" + (x + 1) + ":");
            for(int i = 1; i <= half; i++){
                System.out.println(i+" "+1);
            }
            if(n!=1){
                if(n%2==0) System.out.println((half+1)+" "+2);
                if(n%2==1) System.out.println(half+" "+2);
            }


        }
    }
}

