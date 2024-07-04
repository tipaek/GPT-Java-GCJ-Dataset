import java.io.*;
import java.util.*;

public class Solution {

    public static String getCoconuts(String[] str, int maxLengthIndex){
        String bigBoi = str[maxLengthIndex].substring(1);
        boolean flag = true;

        for(int i = 0;i<str.length;i++){
            String smallBoi = str[i].substring(1);

            if(!bigBoi.contains(smallBoi)){
                flag = false;
                break;
            }
        }

        if(flag){
            return bigBoi;
        }
        else
        return "*";
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int inputs = s.nextInt();
        for (int i = 0; i <inputs;i++){
            int noOfStrings = s.nextInt();
            String[] str = new String[noOfStrings];

            int maxLen = 0;
            int maxLenIndex = 0;
            String waste = s.nextLine();

            for (int j = 0;j<noOfStrings;j++){
                String strin = s.nextLine();

                int strinLen = strin.length();
                if(strinLen>maxLen){
                    maxLen = strinLen;
                    maxLenIndex = j;
                }

                str[j]= strin;

            }

                String ans = getCoconuts(str, maxLenIndex);
                System.out.println("Case #"+(i+1)+": "+ans);
        }
        }
}