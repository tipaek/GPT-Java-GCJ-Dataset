//package qround.d;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static char DIGIT_1 = '1';
	static char DIGIT_0 = '0';

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter writer = new PrintWriter(System.out);
		String[] lineSplit = in.nextLine().trim().split("\\s");

		int T = Integer.parseInt(lineSplit[0]);
		int B = Integer.parseInt(lineSplit[1]);
	
		for (int i = 0; i < T; ++i) {
//			System.err.println(T + 
//					"######################################################################################################");

			int segments = (B / 10);
//			System.err.println("segments - " + segments);
			int attempts = 0;
			List<String> segmentsList = new ArrayList();
			StringBuffer binSeq = new StringBuffer();

			for (int segmentIndex = 0; segmentIndex < segments; segmentIndex++) {
				int startIndex = (segmentIndex * 10) + 1;
				int endIndex = startIndex + 9;
				endIndex = (endIndex >= B) ? B : endIndex;
//				System.err.println("Segment #" + segmentIndex + ", ############# " + startIndex + " - " + endIndex);
				String[] possibilities = new String[4];
				StringBuffer aPossibility = new StringBuffer();
				
				String prev = "";
				int trialLimit = (segmentIndex > 0) ? 14 : 1;

//				for (int trialIndex = 0; trialIndex < trialLimit ; trialIndex++) {
					aPossibility = new StringBuffer();
					for (int x = startIndex; x <= endIndex; x++) {
						++attempts;
						writeFlush(writer, String.valueOf(x));
						aPossibility.append(in.nextLine());
					}
//					possibilities[trialIndex] = aPossibility.toString();
					
//					System.err.println(attempts + " - " + aPossibility.toString() +"   ,"+ compareSeq(prev, aPossibility.toString()));
					prev = aPossibility.toString();
//					break;
//				}
				binSeq.append(prev);
				if(segments ==1)
					break;
			}
//			break;
			writeFlush(writer, String.valueOf(binSeq.toString()));
			
			String op = in.nextLine() ;
			System.err.println("JUDGE ==> " + op);
			if(op == "N") {
				break;
			}
		}

	}
	
	private static String compareSeq(String previous,String current) {
		if(!previous.isEmpty()) {
			if(current.equals(previous)) {
				return "NO-OP";
			}else if (current.equals(new StringBuffer(previous).reverse().toString())) {
				return "REVERSE";
			}else if(current.equals(complement(new StringBuffer(previous)))) {
				return "FLIP";
			}else if(current.equals(new StringBuffer(complement(new StringBuffer(previous))).reverse().toString())) {
				return "FLIP+REVERSE";
			}else return null;
			
		}else return "BASE";
	}

	private static String complement(StringBuffer sb) {
		StringBuffer sbCopy = new StringBuffer(sb.toString());
		for (int charIndex = 0; charIndex < sbCopy.length(); charIndex++) {
			if (sbCopy.charAt(charIndex) == DIGIT_0) {
				sbCopy.setCharAt(charIndex, DIGIT_1);
			} else if (sbCopy.charAt(charIndex) == DIGIT_1) {
				sbCopy.setCharAt(charIndex, DIGIT_0);
			}
		}
		return sbCopy.toString();
	}

	private static void writeFlush(PrintWriter output, String s) throws IOException {
		output.println(s);
		output.flush();
	}

}
