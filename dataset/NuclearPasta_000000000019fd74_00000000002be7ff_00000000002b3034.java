import java.util.*;
import java.io.*;
public class sbctfroundtwo {
  public static void main(String[] args) throws FileNotFoundException{
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      String output = "";
      ArrayList<String> patterns = new ArrayList<>();
      for(int j = 0; j < N+1; j++){
          patterns.add(in.nextLine().replaceAll("\\*", ""));
      }
      patterns.remove(0);
      /*
      String regex = "(.*)CONUTS";
      System.out.println(regex);
      for(int j = 0; j < patterns.size(); j++){
	  	System.out.println(patterns.get(i).matches(regex));
	  }
	  */
      int min_size = 9999999;
      int max_size = -1;
      int mindex = 0;
      int maxdex = 0;
      for(int k = 0; k < patterns.size(); k++){
          if(patterns.get(k).length() < min_size){
              min_size = patterns.get(k).length();
              mindex = k;
          }
           if(patterns.get(k).length() > max_size){
		      max_size = patterns.get(k).length();
		      maxdex = k;
          }
      }
      String regex = "(.*)"+patterns.get(mindex);
      for(int l = 0; l < patterns.size(); l++){
          if(patterns.get(l).matches(regex) == false){
            output = "*";
			break;
			}
          else
            output = "FUCK" + patterns.get(maxdex);
      }
      System.out.println("Case #" + i + ": " + output);
    }
  }
}