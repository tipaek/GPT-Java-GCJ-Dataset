import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			int n = Integer.parseInt(br.readLine());
			char[] jam = new char[1441], cam = new char[1441];
			for (int j = 0; j < cam.length; j++) {
				jam[j] = cam[j] = ' ';
			}
			String ans="";
			for (int j = 0; j < n; j++) {
				int s,e;
				String[] in = br.readLine().split(" ");
				s= Integer.parseInt(in[0]);
				e= Integer.parseInt(in[1]);
				boolean jamie = true, cameron=true;
				for (int k = s; k <= e; k++) {
					if(jam[k] != ' '){
	                    if(k != s && k != e) jamie=false;
	                    else {
	                        if(k == s && jam[k] != 'E') jamie = false;
	                        if(k == e && jam[k] != 'S') jamie = false;
	                    }
	                }
	                if(cam[k] != ' '){
	                    if(k != s && k != e) cameron=false;
	                    else {
	                        if(k == s && cam[k] != 'E') cameron= false;
	                        if(k == e && cam[k] != 'S') cameron= false;
	                    }
	                }
				}
				if(jamie){
                    jam[s]='S'; jam[e]='E';
                    for(int k=s+1; k < e; k++){
                        jam[k]='J';
                    }
                    ans+='J';
                } else if(cameron){
                    cam[s]='S'; cam[e]='E';
                    for(int k=s+1; k < e; k++){
                        cam[k]='J';
                    }
                    ans+='C';
                } else {
                    ans = "IMPOSSIBLE";
                    break;
                }
			}
			System.out.println("Case #"+i+": "+ans);
		}
	}

}
