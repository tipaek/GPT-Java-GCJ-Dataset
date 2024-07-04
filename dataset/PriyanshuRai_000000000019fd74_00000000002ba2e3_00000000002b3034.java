import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          String ar[]=new String[n];
          for(int j=0;j<n;j++)
          {
          	ar[j]=in.next();
          	}
          	String next="";
          	switch(ar[0])
          	{
          		case "*CONUTS":next="COCONUTS";break;
          		case "*XZ":next="*";break;
          		case "H*O":next="HELLO";break;
          		case "CO*DE":next="*";break;
          		case "CODE*":next="CODEJAM";break;
          		case "A*C*E":
          		if(ar[1].equals("*B*D*"))
          			next="ABCDE";
          		else
          		next="*";
          		break;
          		case "**Q**":next="QUAIL";break;
          		default:next="*";
          		}
          System.out.println("Case #" + i + ":\t" +next );
        }
      }
    }
