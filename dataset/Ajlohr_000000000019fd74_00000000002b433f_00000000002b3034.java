import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    LOOP:
    for (int cc = 1; cc <= t; ++cc) {
      int N = in.nextInt();
      Set<String> prefixes = new HashSet<String>();
      Set<String> suffixes = new HashSet<String>();
      List<String> middles = new ArrayList<String>();
      for(int i=0;i<N;i++)
      {
    	  String input = in.next();
    	  String[] components = input.split("\\*",-1);
    	  prefixes.add(components[0]);
    	  suffixes.add(components[components.length-1]);
    	  for(int j=1;j<components.length-1;j++)
    	  {
    		  middles.add(components[j]);
    	  }
      }
      String candidatePrefix = longestString(prefixes);
      for(String s : prefixes)
      {
    	  if(!s.equals(candidatePrefix.substring(0, s.length())))
    		  {
    		  System.out.println("Case #" + cc + ": *" );
    		  continue LOOP;
    		  }
      }
      String candidateSuffix = longestString(suffixes);
      for(String s : suffixes)
      {
    	  if(!s.equals(candidateSuffix.substring(candidateSuffix.length() - s.length())))
    		  {
    		  System.out.println("Case #" + cc + ": *" );
    		  continue LOOP;
    		  }
      }
      String outputWord = candidatePrefix;
      outputWord = outputWord + String.join("", middles);
      outputWord = outputWord + candidateSuffix;
      System.out.println("Case #" + cc + ": " + outputWord);
    }
  }
  public static String longestString(Set<String> set)
  {
	  int bestlength = 0;
	  String bestString ="";
	  for(String s : set)
	  {
		  if(s.length()>bestlength)
		  {
			  bestString = s;
			  bestlength = s.length();
		  }
	  }
	  return bestString;
  }
}