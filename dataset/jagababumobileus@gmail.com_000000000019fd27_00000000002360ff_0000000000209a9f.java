import java.util.*;
import java.io.*;
public class Solution {

	private class RetVal {
		public int endPos=-1;
		public int minVal;
	}
	
	
	public RetVal getMinValAndEndPos(int startPos, int[] splitNbrs) {
		int minval = Integer.MAX_VALUE;
		RetVal retval = new RetVal();
		for(int j=startPos;j<splitNbrs.length;j++) {
			int nextVal = splitNbrs[j];
			if(nextVal==0) {
				retval.endPos=j-1;
				break;
			}
			if(nextVal<=minval ) {
				minval=nextVal;
			}
		}
		retval.minVal=minval;
		if(retval.endPos<0)
			retval.endPos=splitNbrs.length-1;
		return retval;
	}
	
	public String process2(String s) {
		int len = s.length();
		int[] open = new int[len];
		int[] close = new int[len];
		int[] splitNbrs = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray(); 
		int[] origNbrs = splitNbrs.clone();
		
		for(int i=0;i<len;i++) {
			if(splitNbrs[i]==0)
				continue;
			RetVal retval = getMinValAndEndPos(i,splitNbrs);
			open[i]=open[i]+splitNbrs[i];
			int diffForClose = splitNbrs[i]-retval.minVal;
			if(diffForClose<0) diffForClose=0;
			close[i]=close[i]+diffForClose;
			
			if(retval.endPos>=0 && retval.endPos<len) {
				close[retval.endPos]=close[retval.endPos]+retval.minVal;
			
				for (int k = i+1; k<=retval.endPos;k++) {
						int diff = splitNbrs[k]-retval.minVal;
						splitNbrs[k]=diff;
				}
			}
		}
		
		StringBuilder builder = new StringBuilder();
		for(int x=0;x<len;x++) {
			if(open[x]<0) open[x]=0;
			builder.append(new String(new char[open[x]]).replace("\0", "("));  
			builder.append(origNbrs[x]);
			if(close[x]<0) close[x]=0;
			builder.append(new String(new char[close[x]]).replace("\0", ")"));  

		}
		return builder.toString();
	}
	public String process(String s) {
		int len = s.length();
		int[] open = new int[len];
		int[] close = new int[len];
		int[] pending= new int[len];
		int[] splitNbrs = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray(); 
		int[] origNbrs = splitNbrs.clone();
		int i=0;
		while (i<len-1) {
			pending= new int[len];
			int currVal = splitNbrs[i];
			int pendValSize=0;
			int minval = currVal;
			for(int j=i+1;j<len;j++) {
				//System.out.println(j);
				int nextVal = splitNbrs[j];
				if(nextVal<=currVal && nextVal!=0) {
				//if(nextVal!=0) {
					pending[pendValSize]=nextVal;
					pendValSize++;
					if(nextVal < minval)
						minval = nextVal;
				}
				else {
					//take care of first and last items
					if (pendValSize==0) minval=0;
					break;
				}
			}
			
			//Process the data
			open[i]=open[i]+splitNbrs[i];
			
			int diffForClose = splitNbrs[i]-minval;
			if(diffForClose<0) diffForClose=0;
			

			//diff2 = splitNbrs[i+pendValSize]-minval-1;
			//if(diff2<0) diff2=0;
			close[i+pendValSize]=close[i+pendValSize]+minval;
			int iIncr = 0;
			for (int k = 0; k< pendValSize;k++) {
				if(splitNbrs[i+k+1]==currVal) {
					//splitNbrs[i+k+1]=0;
					iIncr++;
				}
				else
					break;
			}
			for (int k = 0; k< pendValSize;k++) {
				
				if(pending[k]>=minval) {
					int diff = splitNbrs[i+k+1]-minval;
					splitNbrs[i+k+1]=diff;
					//open[i+k+1]=diff;
					//close[i+k+1]=diff;

				}

			}
			
			i=i+iIncr;
			close[i]=close[i]+diffForClose;
			
			i++;

		}
		//Take care of the last item
		if(i<len) {
			open[i]=open[i]+splitNbrs[i];
			close[i]=close[i]+splitNbrs[i];
		}
		
		StringBuilder builder = new StringBuilder();
		for(int x=0;x<len;x++) {
			if(open[x]<0) open[x]=0;
			builder.append(new String(new char[open[x]]).replace("\0", "("));  
			builder.append(origNbrs[x]);
			if(close[x]<0) close[x]=0;
			builder.append(new String(new char[close[x]]).replace("\0", ")"));  

		}
		return builder.toString();
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			String s = in.nextLine();

			System.out.println("Case #" + i + ": " + sol.process2(s));
		}
	}
}