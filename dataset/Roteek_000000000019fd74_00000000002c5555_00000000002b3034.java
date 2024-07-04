import java.util.*;
import java.util.regex.*;
import java.io.*;
public class Solution
{
  public static void main (String[]args)
  {
    Scanner in =
      new Scanner (new BufferedReader (new InputStreamReader (System.in)));
    int T = Integer.valueOf(in.nextLine());	// Scanner has functions to read ints, longs, strings, chars, etc.
    for (int t = 1; t <= T; ++t)
      {
	int N = Integer.valueOf (in.nextLine ());
	String patterns[][] = new String[N][2];
	int maxCharLen = 0;
	String maxLenString = "";
	String maxLenPattern = "";
	int impc = 0;
	for (int n = 0; n < N; n++)
	  {
	    String pat = in.nextLine ();
	    String subPat = pat;
	    String regPat = "";
	    String charString = "";
	    int count = 0;
	    do
	      {
		int i = subPat.indexOf ("*");
		int j = subPat.lastIndexOf ("*");
		if (i > 0)
		  {
		    regPat = "(" + subPat.substring (0, i) + ")";
		    charString = subPat.substring (0, i);
		  }
		if (i != -1)
		  {
		    count++;
		    regPat += "\\w*";
		    if (i < subPat.length () - 1)
		      subPat = subPat.substring (i);
		    else
		      subPat = "";
		    if (i == j)
		      {
			if (i < subPat.length () - 1)
			  {
			    regPat += "(" + subPat.substring (i+1 ) + ")";
			    charString += subPat.substring (i+1);
			  }
			break;
		      }
		  }
		else
		  break;

	      }
	    while (true);
	    int charLen = pat.length () - count;
	    if (charLen > maxCharLen)
	      {
		maxCharLen = charLen;
		maxLenString = charString;
		maxLenPattern = pat;
	      }
	    patterns[n][0] = regPat;
	    patterns[n][1] = pat;
	  }
	String word = maxLenString;
	int retryCount=0;
	System.out.println(Arrays.deepToString(patterns));
	for (int i = 0; i < N; i++)
	  {
	    String pattern = patterns[i][0];
	    Pattern p = Pattern.compile (pattern);
	    Matcher m = p.matcher (word);
	    if (m.matches ())
	      continue;
	    else
	      {
	          retryCount++;
	    if(retryCount>=N){
	        impc=1;
	        break;
	    }
		String curPat = patterns[i][1];
		String subPart = curPat;
		String wordToBe = maxLenPattern;
		String subWordToBe = wordToBe;
		int subIndex = 0;
		do
		  {

		    int iindex = subPart.indexOf ("*");
		    int jindex = subWordToBe.indexOf ("*");
		    int len = subPart.length ();
		    if(iindex==-1 || jindex==-1)
		        break;
		    String subSubPart = subPart.substring (0, iindex);
		    String partToSearch = subWordToBe.substring (0, jindex);
		    subIndex += jindex;
		    if (subSubPart.equals (partToSearch))
		      {
			if (iindex != len - 1 && jindex != subWordToBe.length () - 1)
			  {
			    subPart = subPart.substring (iindex+1 );
			    subWordToBe = subWordToBe.substring (jindex+1 );
			  }
			else
			  break;
		      }
		    else if (subSubPart.contains (partToSearch))
		      {
			int lenToReplace = partToSearch.length();
			wordToBe =
			  wordToBe.substring (0,
					      subIndex) + subSubPart +
			  wordToBe.substring (subIndex + lenToReplace);

			if (iindex != len - 1 && jindex != subWordToBe.length () - 1)
			  {
			    subPart = subPart.substring (iindex+1);
			    subWordToBe = subWordToBe.substring (jindex+1 );
			  }
			else
			  break;
		      }
		    else
		      {
			impc = 1;
			break;
		      }
		  }
		while (true);
		if (impc == 1)
		  break;
		maxLenPattern = wordToBe;
		String pat = wordToBe;
		String subPat = pat;
		String regPat = "";
		String charString = "";
		do
		  {
		    int iindex = subPat.indexOf ("*");
		    int jindex = subPat.lastIndexOf ("*");
		    if (iindex > 0)
		      {
			charString = subPat.substring (0, iindex);
		      }
		    if (iindex != -1)
		      {
			if (iindex < subPat.length () - 1)
			  subPat = subPat.substring (iindex+1 );
			else
			  subPat = "";
			if (iindex == jindex)
			  {
			    if (iindex < subPat.length () - 1)
			      {
				charString += subPat.substring (iindex + 1);
			      }
			    break;
			  }
		      }
		    else
		      break;

		  }
		while (true);
		word = charString;
		i = -1;
		continue;
	      }
	      
	  }
	  String ans;
      if(impc==1)
      ans="*";
      else ans=word;
    System.out.println ("Case #" + t + ": " +ans);
  }
}
}
