import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Solution{
	
	public static String combine(Word w1, Word w2, int type){
		String ret = "";
		if(type == 0){
			//left
			String a = w1.left.peekFirst();
			String b = w2.left.peekFirst();
			int aLen = a.length();
			int bLen = b.length();
			if((aLen == 0) && (bLen == 0)){
				ret = "";
			}
			else if(aLen == 0){
				ret = b;
			}
			else if(bLen == 0){
				ret = a;
			}
			else{
				if(aLen < bLen){
					if(b.substring(0, aLen).equals(a)){
						ret = b;
					}
					else{
						ret = "!";
					}
				}
				else{
					if(a.substring(0, bLen).equals(b)){
						ret = a;
					}
					else{
						ret = "!";
					}
				}
			}
		}
		else if(type == 2){
			//right
			String a = w1.right.peekFirst();
			String b = w2.right.peekFirst();
			int aLen = a.length();
			int bLen = b.length();
			if((aLen == 0) && (bLen == 0)){
				ret = "";
			}
			else if(aLen == 0){
				ret = b;
			}
			else if(bLen == 0){
				ret = a;
			}
			else{
				if(aLen < bLen){
					if(b.substring(bLen - aLen, bLen).equals(a)){
						ret = b;
					}
					else{
						ret = "!";
					}
				}
				else{
					if(a.substring(aLen - bLen, aLen).equals(b)){
						ret = a;
					}
					else{
						ret = "!";
					}
				}
			}
		}
		else{
			//mid
			for(String x : w1.mid){
				if(x.length() == 0) continue;
				ret += x;
			}
			for(String x : w2.mid){
				if(x.length() == 0) continue;
				ret += x;
			}
		}
		
		return ret;
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		int keis = Integer.valueOf(br.readLine().trim());
		for(int kei = 0; kei < keis; kei++){
			int N = Integer.valueOf(br.readLine().trim());
			Word[] words = new Word[N];
			
			for(int q = 0; q < N; q++){
				String str = br.readLine().trim();
				Word w = new Word(str);
				// out.println(w);
				words[q] = w;
			}
			// out.println("----");
			Word ans = words[0];
			boolean imp = false;
			for(int i = 1; i < N; i++){
				// out.println(ans);
				// out.println(words[i]);
				
				String left = (combine(ans, words[i], 0));
				String mid = (combine(ans, words[i], 1));
				String right = (combine(ans, words[i], 2));
				
			// out.println("----");
			// out.println(left);
			// out.println(mid);
			// out.println(right);
				if(left.equals("!") || mid.equals("!") || right.equals("!")){
					imp = true;
					break;
				}
				ans.left.clear();
				ans.mid.clear();
				ans.right.clear();
				ans.left.add(left);
				ans.mid.add(mid);
				ans.right.add(right);
				
			}
			out.print("Case #"+(kei+1)+": ");
			if(imp) out.println("*");
			else{
				out.println(ans.left.peekFirst()+""+ans.mid.peekFirst()+""+ans.right.peekFirst());
			}
		}
	}
	public static class Word{
		String str;
		int len;
		LinkedList<String> left;
		LinkedList<String> mid;
		LinkedList<String> right;
		public Word(String a){
			str = a;
			len = str.length();
			left = new LinkedList<String>();
			mid = new LinkedList<String>();
			right = new LinkedList<String>();
			
			int leftIdx = 0;
			int rightIdx = 0;
			String tmp = "";
			for(int i = 0; i< len; i++){
				char c = str.charAt(i);
				if(c == '*'){
					leftIdx = i;
					break;
				}
				tmp += ""+c;
			}
			
			left.add(tmp);
			
			tmp = "";
			for(int i = len-1; i >= 0; i--){
				char c = str.charAt(i);
				if(c == '*'){
					rightIdx = i;
					break;
				}
				tmp = ""+c+""+tmp;
			}
			right.add(tmp);
			
			tmp = "";
			for(int i = leftIdx + 1; i < rightIdx; i++){
				char c = str.charAt(i);
				if(c == '*'){
					if(tmp.length() != 0) mid.add(tmp);
					//mid.add("*");
					tmp = "";
				}
				else{
					tmp += ""+c;
				}
			}
			mid.add(tmp);
			
		}
		public String toString(){
			return str+"\n"+left+"\n"+mid+"\n"+right+"\n";
		}
		
		
	}
}