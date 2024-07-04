import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int numCase = 1; numCase <= t; numCase++) {
        int numLines = in.nextInt();
        in.nextLine();
        String startString = "";
        String endString = "";
        boolean fail = false;
        for(int a = 0; a < numLines; a++){ //a is the sample #
            String line = in.nextLine();
            if(line.charAt(0) == '*'){//EndString
                line = line.substring(1, line.length());
                if(endString.contains(line)){
                    continue;
                } else if (line.contains(endString)){
                    endString = line;
                } else{
                    fail = true;
                }
            } else if(line.charAt(line.length() - 1) == '*'){
                line = line.substring(0, line.length() - 1);
                if(startString.contains(line)){
                    continue;
                } else if (line.contains(startString)){
                    startString = line;
                } else{
                    fail = true;
                }
            } else{
                String[] lines = line.split("*");
                lines[0] = lines[0].substring(0, lines[1].length() - 1);
                if(startString.contains(lines[0])){
                    continue;
                } else if (lines[0].contains(startString)){
                    startString = lines[0];
                } else{
                    fail = true;
                }
                lines[1] = lines[1].substring(1, lines[1].length());
                if(endString.contains(lines[1])){
                    continue;
                } else if (lines[1].contains(endString)){
                    endString = lines[1];
                } else{
                    fail = true;
                }
            }
        }
        if(fail){
            System.out.println("Case #" + numCase + ": " + "*");
        } else{
            StringBuilder sb = new StringBuilder(startString);
            sb.append(endString);
            System.out.println("Case #" + numCase + ": " + sb.toString());
        }
    }
  }
}