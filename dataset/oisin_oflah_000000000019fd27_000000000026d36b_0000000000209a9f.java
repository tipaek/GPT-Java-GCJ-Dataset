import java.util.*;
import java.io.*;


public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t ; ++i) {
      int size = in.nextInt();
      Nest N = new Nest(size);
      System.out.println("Case #" + i + ": " + N.depthNest());
    }
  }
}
class Nest{
	int[] input;
	public Nest(int in) {
	    String temp = Integer.toString(in);
	    input = new int[temp.length()];
	    for(int j = 0; j<temp.length();j++){
	        input[j]=temp.charAt(j)-48;
	    }
	}
	public String depthNest() {
		String output = "";
		if(input[0]==0) {
			output+=""+input[0];
		}else {
			output+="(" + input[0];
		}
		for(int i = 1; i<input.length;i++) {
			if(input[i]==1) {
				if(input[i-1]==1) {
					output+=""+1;
				}else {
					output+="("+1;
				}
			}else {
				if(input[i-1]==0) {
					output+=""+0;
				}else {
					output+=")"+0;
				}
			}
		}
		if(input[input.length-1]!=0) {
			output+=")";
		}
		return output;
	}
	public void printInput() {
		for(int a:input) {
			System.out.println(a);
		}
	}
}