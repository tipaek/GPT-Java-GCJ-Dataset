import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter w = new PrintWriter(System.out);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++){
            char arr[]=sc.nextLine().toCharArray();
            ArrayList<Character> ans=new ArrayList<>();
            boolean o=false;
            for(int j=0;j<arr.length;j++){
                if(arr[j]=='1'){
                    if(!o){
                        ans.add('(');
                        o=true;
                    }
                    ans.add(arr[j]);
                }
                else{
                    if(o){
                        o=false;
                        ans.add(')');
                        ans.add(arr[j]);
                    }
                }
                if(o){
                    ans.add(')');
                }
                w.print("Case #"+i+": ");
                for(char c:ans)w.print(c);
                w.println();
            }
            
        }
		
	

		w.close();
	}
}