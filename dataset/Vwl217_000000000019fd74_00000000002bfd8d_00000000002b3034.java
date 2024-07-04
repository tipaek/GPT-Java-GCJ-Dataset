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
                if(line.length() > endString.length()){
                    if(line.substring(line.length() - endString.length(), line.length()) .equals(endString)){
                        endString = line;
                    }else{
                        fail = true;
                    }
                }else{
                    if(!(endString.substring(endString.length() - line.length(), endString.length()).equals(line))){
                        fail = true;
                    }
                }
            } else if(line.charAt(line.length() - 1) == '*'){
                line = line.substring(0, line.length() - 1);
                if(line.length() > startString.length()){
                    if(line.substring(0, startString.length()).equals(startString)){
                        startString = line;
                    }else{
                        fail = true;
                    }
                }else{
                    if(!(startString.substring(0, line.length()).equals(line))){
                        fail = true;
                    }
                }
            } else{
                String[] lines = line.split("\\*");
                if(lines[0].length() > startString.length()){
                    if(lines[0].substring(0, startString.length()).equals(startString)){
                        startString = lines[0];
                    }else{
                        fail = true;
                    }
                }else{
                    if(!(startString.substring(0, lines[0].length()).equals(lines[0]))){
                        fail = true;
                    }
                }
                if(lines[1].length() > endString.length()){
                    if(lines[1].substring(lines[1].length() - endString.length(), lines[1].length()).equals(endString)){
                        endString = lines[1];
                    }else{
                        fail = true;
                    }
                }else{
                    if(!(endString.substring(endString.length() - lines[1].length(), endString.length()).equals(lines[1]))){
                        fail = true;
                    }
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