import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt();
            in.nextLine();
            for (int i = 1; i <= t; ++i) {
                String  n = in.nextLine();
                int numOpenPar=0;
                String result="";
                for(char c : n.toCharArray()){
                    int num = c-48;
                    int difParent = num-numOpenPar;
                    if(difParent >=0){
                        result=result+repeat("(", difParent)+num;
                    }else{
                        int abs= -difParent;
                        result=result+repeat(")",abs)+num;
                    }
                    numOpenPar=numOpenPar+difParent;
                }
                result=result+repeat(")",numOpenPar);
                System.out.println("Case #" + i + ": " +result);
            }
        }

        private static String repeat(String s, int number){
            String result="";
            for(int j=0; j<number; j++){
                result=result+s;
            }
            return result;
        }

}