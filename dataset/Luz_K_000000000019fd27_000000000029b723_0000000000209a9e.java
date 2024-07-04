import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    /*Integer[] bits = {1,0,0,0,1,1,1,0,1,1,0,0,0,1,1,1,0,0,1,0};
    boolean[] diffList = new boolean[20];
    changeBits(1,bits,diffList,false);
    System.out.println(Arrays.toString(bits));*/
    int t = in.nextInt();
    int numberOfBits = in.nextInt();
    if(numberOfBits == 10) {
	    for (int i = 1; i <= t; ++i) {
	    	StringBuilder output = new StringBuilder();
	    	for(int x = 1; x <= numberOfBits; x++) {
	    		System.out.println(x);
	    		output.append(in.next() + "");
	    	}
	      System.out.println(output);
	      if (!in.next().equals("Y")) {
	    	  break;
	      }
	    }
    }else if(numberOfBits == 20) {
    	for (int i = 1; i <= t; ++i) {
	    	Integer[] bits = new Integer[numberOfBits];
	    	Integer[] same = {-1,-1};
	    	Integer[] diff = {-1,-1};
	    	boolean[] diffList = new boolean[numberOfBits];
	    	int pairCut = 0;
	    	int leftPair;
	    	int rightPair;
	    	for(int x = 0; x < numberOfBits/2; x++) {
	    		System.out.println(x+1);
	    		leftPair = Integer.parseInt(in.next());
	    		System.out.println(numberOfBits-x);
	    		rightPair = Integer.parseInt(in.next());
	    		if(leftPair == rightPair) {
	    			same[pairCut / 5] = x;
	    			diffList[x] = false;
	    		}else {
	    			diff[pairCut / 5] = x;
	    			diffList[x] = true;
	    		}
	    		pairCut ++;
	    		bits[x] = leftPair;
	    		bits[numberOfBits-x-1] = rightPair;
	    	}
	    	for(int z = 0; z < same.length; z++) {
	    		int testSame = 0;
	    		int testDiff = 0;
	    		if(same[z] != -1) {
		    		System.out.println(same[z] + 1);
		    		testSame = Integer.parseInt(in.next());
		    		if(testSame != bits[same[z]]) {
		    			bits = changeBits(z,bits,diffList,false);
		    			//System.out.println("changing the same bits from " + z*5 + " to " + z*5 + 4);
		    		}
		    		//System.out.println(same[z]);
		    		//System.out.println(bits[same[z]]);
		    		//System.out.println(Arrays.toString(bits));
		    	}
	    		if(diff[z] != -1) {
		    		System.out.println(diff[z] + 1);
		    		testDiff = Integer.parseInt(in.next());
		    		if(testDiff != bits[diff[z]]) {
		    			bits = changeBits(z,bits,diffList,true);
		    			//System.out.println("changing the diff bits from " + z*5 + " to " + z*5 + 4);
		    		}
		    		//System.out.println(Arrays.toString(bits));
		    	}
	    	}
	    	
	    	//System.out.println(Arrays.toString(bits));
	    	//System.out.println(Arrays.toString(same));
	    	//System.out.println(Arrays.toString(diff));
	    	StringBuilder output = new StringBuilder();
	    	for(int z = 0; z < bits.length; z++) {
	    		output.append(bits[z]);
	    	}
	    	System.out.println(output);
	      if (!in.next().equals("Y")) {
	    	  break;
	      }
	    }
    }
  }
  public static Integer[] changeBits(int start, Integer[] bits,boolean diffList[], boolean changeDiff) {
	  start *= 5;
	  if(changeDiff == false) {
		  for(int i = 0; i < 5;i++) {
			  if(bits[start+i] == 0 && !diffList[i]) {
				  bits[start+i] = 1;
			  }else if(!diffList[i]) {
				  bits[start+i] = 0;
			  }
			  if(bits[bits.length - 1 -start - i] == 0 && !diffList[i]) {
				  bits[bits.length - 1 -start - i] = 1;
			  }else if(!diffList[i]){
				  bits[bits.length - 1 -start - i] = 0;
			  }
		  }
		  return bits;
	  }else {
		  for(int i = 0; i < 5;i++) {
			  if(bits[start+i] == 0 && diffList[i]) {
				  bits[start+i] = 1;
			  }else if(diffList[i]) {
				  bits[start+i] = 0;
			  }
			  if(bits[bits.length - 1 -start - i] == 0 && diffList[i]) {
				  bits[bits.length - 1 -start - i] = 1;
			  }else if(diffList[i]){
				  bits[bits.length - 1 -start - i] = 0;
			  }
		  }
		  return bits;
	  }
  }
}