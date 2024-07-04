import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        //File f = new File("C:\\GoogleCodeJam\\Test.txt");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //Scanner in = new Scanner(f);
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int K = in.nextInt();
            String str="";
            int value=0;
            if(N==2){
                if(K==2 || K==4)
                    str="POSSIBLE";
                else
                    str="IMPOSSIBLE";
            }
            else {
                value=N*(N+1)/2;
                if(K==value || ((K+1)/N)==1 || K>=N)
                    str="POSSIBLE";
                else
                    str="IMPOSSIBLE";
            }
            System.out.println("Case #" + i+": "+str);
        }
        in.close();
    }
}
