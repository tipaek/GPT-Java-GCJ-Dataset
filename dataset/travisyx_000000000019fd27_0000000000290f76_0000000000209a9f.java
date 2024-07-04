import java.util.*;
import java.io.*;
import java.math.*;


public class Solution {
	
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for(int i = 0; i < num; ++i){
			String val = scan.next();
			char[] chars = val.toCharArray();
			int[] vals = new int[chars.length];
			for(int j = 0; j < chars.length; ++j)
				vals[j] = Integer.parseInt(String.valueOf(chars[j]));
				
			int depth = 0;
			StringBuilder t = new StringBuilder();
			for(int j = 0; j < vals.length; ++j){
				if(depth == 0){
					depth = vals[j];
					for(int l = 0; l < depth; ++ l)
						t.append("(");
					t.append(vals[j]);
				} else{
					//depth is nonzero
					if(vals[j] > depth){
						for(int l = 0; l < vals[j]-depth; ++ l)
							t.append("(");
						t.append(vals[j]);
						depth = vals[j];
					}
					else if (vals[j] < depth){
						for(int l = 0; l < depth-vals[j]; ++ l)
							t.append(")");
						t.append(vals[j]);
						depth = vals[j];
					}
					else{
						t.append(vals[j]);
					}
				}
			}
			if(depth != 0)
				for(int l = 0; l < depth; ++ l)
							t.append(")");
			System.out.println("Case #" + (i+1) + ": " + t.toString());
		}
		
		scan.close();
	}
}

