import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Solution { 
      
    // Driver Program to test above function 
    public static void main(String[] args)  { 
      BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

      OutputStream out = new BufferedOutputStream(System.out);
        try {
            int T = Integer.parseInt(bi.readLine());
            for (int i = 0; i < T; i++) {
                int N = Integer.parseInt(bi.readLine());
                String[] inputs = new String[N]; 
                Pattern[] patterns = new Pattern[N];
                int max = 0;
                for (int n = 0; n < N; n++) {
                  inputs[n] = bi.readLine();
                  patterns[n] = Pattern.compile(inputs[n].replace("*", "[A-Z]*"));
                  if (inputs[n].length() > inputs[max].length()) {
                    max = n;
                  }
                }

                // System.out.println("input:" + inputs[max]);
                String result = "";
                for (int n = 0; n < N; n++) {
                  // System.out.println(patterns[n].toString() + " " + inputs[max].replace("*", ""));
                  if (!patterns[n].matcher(inputs[max].replace("*", "")).matches()) {
                    result = "*";
                    break;
                  }
                }
                if (result.length() == 0) result = inputs[max].replace("*", "");


              out.write(("Case #" + (i + 1) + ": " + result + "\n").getBytes());
            }



                
                // System.out.println(Arrays.toString(inputs));
                
                
            
        out.flush();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
       
  
        // System.out.println("Length of Longest Common Substring is "
        //         + LCSubStr(X.toCharArray(), Y.toCharArray(), m, n)); 
    } 


} 
  