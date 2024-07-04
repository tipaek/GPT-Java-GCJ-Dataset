import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        //log.write() //log.flush()
        int t = scan.nextInt();
        int count = 1;
        while(t-- >0){
            long l = scan.nextLong();
            long r = scan.nextLong();

//            long count = 0;
//            if(r>l) {
//                while (r > l) {
//                    count++;
//                    r -= count;
//                }
//            }
//            else{
//                while(l>r){
//                    count++;
//                    l -=count;
//                }
//            }
            int c = 1;
            while((l-c)>=0 || (r-c)>=0){
                if(l>=r){
                    l-=c;
                }
                else{
                    r-=c;
                }
                c++;
            }



            log.write("Case #" + (count) + ": " + (c-1) +" " + l + " " + r + "\n");
            //System.out.println(colRep);
            count++;
        }
        log.flush();





    }
}