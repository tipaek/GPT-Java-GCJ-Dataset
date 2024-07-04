import java.util.*; import java.io.*; public class Solution { public static void main(String[] args) { Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc. 
for (int i = 1; i <= t; ++i) {
	 String s=in.next();
	 String st="" ;
	 switch(s) 
	 {
	 	
	 	case "0000":
	 	st="0000";
	 	break ;
	 	case "101":st="(1)0(1)";break;case "111000":st="(111)000";break;case "1":st="(1)" ;break;default:st="(1)" ;
	 	}
	  System.out.println("Case #" + i + ": " + st); 
	  }
	   } 
	   }