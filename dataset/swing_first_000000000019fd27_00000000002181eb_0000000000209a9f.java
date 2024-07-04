import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

        Boolean hasNext(){
            try{
                return br.ready();
            } catch(Exception e){
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Integer lastNum;
        Integer curNum;
        Integer cases;
        Integer length;
        String outString;
        String input;


        FastReader reader = new FastReader();

        cases = reader.nextInt();

        for (Integer i = 1; i <= cases; i++) {
            lastNum = 0;
            curNum = 0;
            input = reader.nextLine();
            length = input.length();
            outString = "Case #" + i.toString() + ": ";
            for (int j = 0; j < length; j++) {
                lastNum = curNum;
                curNum = Character.getNumericValue(input.charAt(j));

                if (curNum > lastNum) {
                    outString += new String(new char[curNum - lastNum]).replace("\0", "(");
                    outString += curNum.toString();
                } else if (curNum < lastNum) {
                    outString += new String(new char[lastNum - curNum]).replace("\0", ")");
                    outString += curNum.toString();

                } else {
                    outString += curNum.toString();
                }
            }
            outString += new String(new char[curNum]).replace("\0", ")");
            System.out.println(outString);
        }
    }
}



