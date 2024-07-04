import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {


    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tr = Integer.parseInt(br.readLine());
        for(int t=1;t<=tr;t++){
            int n = Integer.parseInt(br.readLine());
            System.out.println("Case #"+t+":");
            int sum = 1;
            System.out.println("1 1");
            if(n>1){
                System.out.println("2 2");
                sum++;
            }
            int row = 2;
            for(; sum<n;sum++, row++){
                System.out.println(row+" "+1);
            }


        }
    }

}
