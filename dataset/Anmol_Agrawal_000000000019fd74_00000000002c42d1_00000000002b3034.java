import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
	public static void main (String[] args) throws IOException {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for(int tt = 1; tt <= t; tt++){
	        int n = sc.nextInt();
	        ArrayList<String> asteriskString = new ArrayList<String>();
	        ArrayList<String> stringAsterisk = new ArrayList<String>();
	        ArrayList<String> asteriskStringAsterisk = new ArrayList<String>();
	        String ans = "";
	        for(int i = 0; i < n; i++){
	            String s = sc.next();
	            if(i == 0){
	                ans = s;
	                continue;
	            }
	            int l = s.length();
	            if(s.charAt(0) == '*' && s.charAt(l - 1) == '*'){
	                asteriskStringAsterisk.add(s);
	            }
	            else if(s.charAt(0) == '*' && s.charAt(l - 1) != '*'){
	                asteriskString.add(s);
	            }
	            else if(s.charAt(0) != '*' && s.charAt(l - 1) == '*'){
	                stringAsterisk.add(s);
	            }
	        }
	        boolean aaaa = true;
	        while(aaaa){
	            aaaa = false;
	            if(ans.charAt(0) == '*'  && stringAsterisk.size() > 0){
	                aaaa = true;
	                ans = stringAsterisk.get(0) + ans.substring(1);
	                stringAsterisk.remove(0);
	            }
	            if(ans.charAt(ans.length() - 1) == '*' && asteriskString.size() > 0){
	                aaaa = true;
	                ans = ans.substring(0, ans.length() - 1) + asteriskString.get(0);
	                asteriskString.remove(0);
	            }
	            else{
	                for(int i = 0; i < ans.length(); i++){
	                    if(ans.charAt(i) == '*' && asteriskStringAsterisk.size() > 0){
        	                aaaa = true;
	                        ans = ans.substring(0, i) + asteriskStringAsterisk.get(0) + ans.substring(i + 1);
	                        asteriskStringAsterisk.remove(0);
	                    }
	                }
	            }
	        }
	        boolean compare  = true;
            if(asteriskStringAsterisk.size() == 0){
                if(stringAsterisk.size() != 0 && ans.charAt(ans.length() - 1) == '*'){
                    ans = ans.replace("*", "");
                    zzz:
                    for(String x : stringAsterisk){
                        x = x.replace("*", "");
                        for(int iii = 0, jjj = 0; iii < x.length(); iii++, jjj++){
                        	if(jjj >= ans.length()){
                        		ans = x;
                        		break;
                        	}
                            else if(ans.charAt(jjj) != x.charAt(iii)){
                                compare = false;
                                break zzz;
                            }
                        }
                    }
                }
                else if(asteriskString.size() != 0 && ans.charAt(0) == '*'){
                    ans = ans.replace("*", "");
                    zzz:
                    for(String x : asteriskString){
                        x = x.replace("*", "");
                        for(int iii = x.length() - 1, jjj = ans.length() - 1; iii >= 0; iii--, jjj--){
                        	if(jjj < 0){
                        		ans = x;
                        		break;
                        	}
                            else if(ans.charAt(jjj) != x.charAt(iii)){
                                compare = false;
                                break zzz;
                            }
                        }
                    }
                }
            }
            else{
                compare = false;
            }
            if(compare == false){
                ans = "*";
            }
	        System.out.println("Case #" + tt + ": " + ans);
	    }
	}
}