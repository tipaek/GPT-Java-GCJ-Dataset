import java.io.*;
import java.util.*;
public class Solution{
  public static void main(String[] args) throws IOException{
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("solution.out")));
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int tot = t;
    String k = sc.nextLine();
    while(t-->0) {
    	k = sc.nextLine();
    	int open[] = new int[k.length()];
    	int close[] = new int[k.length()];
    	int arr[] = new int[k.length()];
    	for(int i=0; i<k.length(); i++) {
    		arr[i] = Integer.parseInt(Character.toString(k.charAt(i)));
    	}
    	int Arr[] = Arrays.copyOf(arr, arr.length);
    	for(int i=0; i<k.length(); i++) {
    		if(arr[i]!=0) {
    			recurse(i, arr, open, close);
    			i--;
    			continue;
    		}
    	}
    	
    	out.print("Case #"+(tot-t)+": " );
    	for(int i=0; i<k.length(); i++) {
    		while(open[i]-->0) {
    			out.print("(");
    		}
    		out.print(Arr[i]);
    		while(close[i]-->0) {
    			out.print(")");
    		}
    	}
    	out.print("\n");
    }
	sc.close();
	out.close();
  }
  public static void recurse(int start, int[] arr, int[] open, int[] close) {
	  open[start]++;
	  arr[start]--;
	  if(start<arr.length-1) {
		  while(arr[start+1]!=0) {
			  start++;
			  if (start == arr.length-1) break;
			  arr[start]--;
		  }
	  }
	  close[start]++;
  }
}