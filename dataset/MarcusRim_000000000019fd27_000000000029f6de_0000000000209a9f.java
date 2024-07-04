import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int times = Integer.parseInt(br.readLine());
        String str;
        for(int j = 1; j<= times; j++)
        {
            String ans = "";
            ArrayList<Integer> arr = new ArrayList<Integer>();
            int counter = 0;
            str = br.readLine();
            for(int i=0;i<str.length();i++)
            {
                arr.add(Integer.parseInt(str.substring(i,i+1)));
            }
            counter = 0;
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)>counter)
                {
                    for(int p=0;p<(arr.get(i)-counter);p++){
                        ans+= "(";
                        counter++;
                    }
                }
                else if(arr.get(i)<counter)
                {
                    for(int p=0;p< counter-arr.get(i);p++){
                        ans+= ")";
                        counter--;
                    }
                }
                ans += arr.get(i);
            }
            for(int i=0;i<counter;i++)
            {
                ans+= ")";
            }
            arr.clear();
            out.println("Case #" + j +": " + ans);
        }
        out.close();
    }
}