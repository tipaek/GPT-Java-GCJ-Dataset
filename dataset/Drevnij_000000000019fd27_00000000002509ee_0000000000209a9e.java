
import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); 
    int b = in.nextInt();  
    for (int x = 1; x <= t; x++) {
    	int cur = 1;
    	int known = 0;
    	boolean[] result = new boolean[b];
    	while (known<b) {
    		if (known>0 && cur % 10 == 1) {
    			boolean[] orig = new boolean[known];
    			boolean[] comp = new boolean[known];
    			boolean[] rev = new boolean[known];
    			boolean[] compRev = new boolean[known];
    			for (int i =0; i<known/2; i++) {
    				orig[i] = result[i];
    				orig[known-i-1]=result[b-i-1];
    			}
				if (known%2 ==1) orig[known/2] = result[known/2];

    			for (int i =0; i<known; i++) {
    				comp[i] = !orig[i];
    				rev[i] = orig[known-i-1];
    				compRev[i] = !orig[known-i-1];
    			}
				boolean isCompSame = true;
				for (int i =0; i<known; i++) 
					if (comp[i]!=orig[i]) isCompSame=false;
				
				boolean isRevSame = true;
				for (int i =0; i<known; i++) 
					if (rev[i]!=orig[i]) isRevSame=false;
				if (!isRevSame && !isCompSame) {
					isRevSame = true;
					for (int i =0; i<known; i++) 
						if (rev[i]!=comp[i]) isRevSame=false;

				}
				
				boolean isCRSame = true;
				for (int i =0; i<known; i++) 
					if (compRev[i]!=orig[i]) isCRSame=false;
				if (!isCRSame && !isCompSame) {
					isCRSame = true;
					for (int i =0; i<known; i++) 
						if (compRev[i]!=comp[i]) isCRSame=false;
				}
				if (!isCRSame && !isRevSame) {
					isCRSame = true;
					for (int i =0; i<known; i++) 
						if (compRev[i]!=rev[i]) isCRSame=false;
				}
				
				if (isCompSame && isCRSame && isRevSame) {
	    			int index= known % 2 == 0 ? known/2 + 1 : b-(known/2);
	    			System.out.println(""+index);
	    			int bit = in.nextInt();
	    			result[index-1]=(bit==1);
	    			known++;
	    			cur++;
				} else if (isCompSame && isCRSame) {
					int bit = findOneBit(orig, rev);
					int index = bit < known/2 || (bit == known/2 && known%2==1)  ? bit+1 : bit+b-known+1;
					System.out.println(""+index);
					boolean res = in.nextInt() == 1;
					cur++;
					if (res != orig[bit]) {
						for (int i=0; i<known/2; i++) {
							result[i] = rev[i];
							result[b-i-1]=rev[known-i-1];
						}
						if (known%2 ==1) result[known/2] = rev[known/2];
					}
				} else if (isCompSame && isRevSame) {
					int bit = findOneBit(orig, compRev);
					int index = bit < known/2 || (bit == known/2 && known%2==1)  ? bit+1 : bit+b-known+1;
					System.out.println(""+index);
					boolean res = in.nextInt() == 1;
					cur++;
					if (res != orig[bit]) {
						for (int i=0; i<known/2; i++) {
							result[i] = compRev[i];
							result[b-i-1]=compRev[known-i-1];
						}
						if (known%2 ==1) result[known/2] = compRev[known/2];
					}
				} else if (isCRSame && isRevSame) {
					int bit = findOneBit(orig, comp);
					int index = bit < known/2 || (bit == known/2 && known%2==1)  ? bit+1 : bit+b-known+1;
					System.out.println(""+index);
					boolean res = in.nextInt() == 1;
					cur++;
					if (res != orig[bit]) {
						for (int i=0; i<known/2; i++) {
							result[i] = comp[i];
							result[b-i-1]=comp[known-i-1];
						}
						if (known%2 ==1) result[known/2] = comp[known/2];
					}
				} else if (isCRSame) {
					int bit[] = findTwoBit(orig, comp, rev);
					int index1 = bit[0] < known/2 || (bit[0] == known/2 && known%2==1)  ? bit[0]+1 : bit[0]+b-known+1;
					System.out.println(""+index1);
					boolean res1 = in.nextInt() == 1;
					cur++;
					int index2 = bit[1] < known/2 || (bit[0] == known/2 && known%2==1)  ? bit[1]+1 : bit[1]+b-known+1;
					System.out.println(""+index2);
					boolean res2 = in.nextInt() == 1;
					cur++;
					if (res1 != orig[bit[0]] || res2 != orig[bit[1]]) {
						if (res1 == comp[bit[0]] && res2 == comp[bit[1]]) {
							for (int i=0; i<known/2; i++) {
								result[i] = comp[i];
								result[b-i-1]=comp[known-i-1];
							}
							if (known%2 ==1) result[known/2] = comp[known/2];
						} else {
							for (int i=0; i<known/2; i++) {
								result[i] = rev[i];
								result[b-i-1]=rev[known-i-1];
							}
							if (known%2 ==1) result[known/2] = rev[known/2];
						}
								
					}
				} else if (isCompSame) {
					int bit[] = findTwoBit(orig, compRev, rev);
					int index1 = bit[0] < known/2 || (bit[0] == known/2 && known%2==1)  ? bit[0]+1 : bit[0]+b-known+1;
					System.out.println(""+index1);
					boolean res1 = in.nextInt() == 1;
					cur++;
					int index2 = bit[1] < known/2 || (bit[0] == known/2 && known%2==1)  ? bit[1]+1 : bit[1]+b-known+1;
					System.out.println(""+index2);
					boolean res2 = in.nextInt() == 1;
					cur++;
					if (res1 != orig[bit[0]] || res2 != orig[bit[1]]) {
						if (res1 == compRev[bit[0]] && res2 == compRev[bit[1]]) {
							for (int i=0; i<known/2; i++) {
								result[i] = compRev[i];
								result[b-i-1]=compRev[known-i-1];
							}
							if (known%2 ==1) result[known/2] = compRev[known/2];
						} else {
							for (int i=0; i<known/2; i++) {
								result[i] = rev[i];
								result[b-i-1]=rev[known-i-1];
							}
							if (known%2 ==1) result[known/2] = rev[known/2];
						}
								
					}
				} else if (isRevSame) {
					int bit[] = findTwoBit(orig, compRev, comp);
					int index1 = bit[0] < known/2 || (bit[0] == known/2 && known%2==1)  ? bit[0]+1 : bit[0]+b-known+1;
					System.out.println(""+index1);
					boolean res1 = in.nextInt() == 1;
					cur++;
					int index2 = bit[1] < known/2 || (bit[0] == known/2 && known%2==1)  ? bit[1]+1 : bit[1]+b-known+1;
					System.out.println(""+index2);
					boolean res2 = in.nextInt() == 1;
					cur++;
					if (res1 != orig[bit[0]] || res2 != orig[bit[1]]) {
						if (res1 == compRev[bit[0]] && res2 == compRev[bit[1]])  {
							for (int i=0; i<known/2; i++) {
								result[i] = compRev[i];
								result[b-i-1]=compRev[known-i-1];
							}
							if (known%2 ==1) result[known/2] = compRev[known/2];
						} else {
							for (int i=0; i<known/2; i++) {
								result[i] = comp[i];
								result[b-i-1]=comp[known-i-1];
							}
							if (known%2 ==1) result[known/2] = comp[known/2];
						}
								
					}
				} else {
					int bit[] = findTwoBit(orig, compRev, comp, rev);
					int index1 = bit[0] < known/2 || (bit[0] == known/2 && known%2==1)  ? bit[0]+1 : bit[0]+b-known+1;
					System.out.println(""+index1);
					boolean res1 = in.nextInt() == 1;
					cur++;
					int index2 = bit[1] < known/2 || (bit[0] == known/2 && known%2==1)  ? bit[1]+1 : bit[1]+b-known+1;
					System.out.println(""+index2);
					boolean res2 = in.nextInt() == 1;
					cur++;
					if (res1 != orig[bit[0]] || res2 != orig[bit[1]]) {
						if (res1 == compRev[bit[0]] && res2 == compRev[bit[1]]) { 
							for (int i=0; i<known/2; i++) {
								result[i] = compRev[i];
								result[b-i-1]=compRev[known-i-1];
							}
							if (known%2 ==1) result[known/2] = compRev[known/2];
						} else if (res1 == comp[bit[0]] && res2 == comp[bit[1]]) {
							for (int i=0; i<known/2; i++) {
								result[i] = comp[i];
								result[b-i-1]=comp[known-i-1];
							}
							if (known%2 ==1) result[known/2] = comp[known/2];
						} else {
							for (int i=0; i<known/2; i++) {
								result[i] = rev[i];
								result[b-i-1]=rev[known-i-1];
							}
							if (known%2 ==1) result[known/2] = rev[known/2];
						}
								
					}
				}
				
    		} else {
    			int index= known % 2 == 0 ? known/2 + 1 : b-(known/2);
    			System.out.println(""+index);
    			int bit = in.nextInt();
    			result[index-1]=(bit==1);
    			known++;
    			cur++;
    		}
    		
    	}
    	
    	String output = "";
    	for (int i=0; i<known; i++)
    		output= result[i] ? output+"1" : output+"0";
   
    	System.out.println(output);
    	
    	String answer = in.next();
    	if (!"Y".equals(answer)) break;
      
    }
  }
  
  private static int findOneBit(boolean[] a1, boolean[] a2) {
	  int result =0;
	  for (int i=0; i< a1.length; i++)
		  if (a1[i] != a2[i]) {
			  result =i;
			  return result;
		  }
			  
	  return result;
			  
  }

  private static int[] findTwoBit(boolean[] a1, boolean[] a2, boolean[] a3) {
	  int[] result = new int[2];
	  for (int i=0; i< a1.length; i++)
		  for (int j=i+1; j< a1.length; j++) {
			  String s1 = ""+a1[i]+a1[j];
			  String s2 = ""+a2[i]+a2[j];
			  String s3 = ""+a3[i]+a3[j];
			  if (!s1.equals(s2) && !s1.equals(s3) && !s2.equals(s3)) {
				  result[0] = i;
				  result[1] = j;
				  return result;
			  }
		  }
			  
	  return result;
			  
  }

  private static int[] findTwoBit(boolean[] a1, boolean[] a2, boolean[] a3, boolean[] a4) {
	  int[] result = new int[2];
	  for (int i=0; i< a1.length; i++)
		  for (int j=i+1; j< a1.length; j++) {
			  String s1 = ""+a1[i]+a1[j];
			  String s2 = ""+a2[i]+a2[j];
			  String s3 = ""+a3[i]+a3[j];
			  String s4 = ""+a4[i]+a4[j];
			  if (!s1.equals(s2) && !s1.equals(s3) && !s2.equals(s3) && !s2.equals(s4) && !s1.equals(s4) && !s3.equals(s4)) {
				  result[0] = i;
				  result[1] = j;
				  return result;
			  }
		  }
			  
	  return result;
			  
  }

}