import java.util.Scanner;
class Solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
	    
		int t=1;
		while(tc>0){
			String s=sc.next();
			String result=find(s);
			System.out.println("Case #"+t+": "+result);
			t++;
			tc--;
		}
		sc.close();
	}

	static String find(String s){
		String fs="";
		int count=0;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(i>0){
				if(ch>s.charAt(i-1)){
					for(int j=0;j<(ch-48)-(s.charAt(i-1)-48);j++){
						fs=fs+"(";
						count++;
					}
				}else{
					if(ch<s.charAt(i-1)){
						for(int j=0;j<(s.charAt(i-1)-48)-(ch-48);j++){
							fs=fs+")";
							count--;
						}
					}else{
						if(ch==s.charAt(i-1)){
							fs=fs+ch;
							continue;
						}
					}
				}
			}else{
				for(int j=0;j<ch-48;j++){
					fs=fs+"(";
					count++;
				}
			}
			fs=fs+ch;
		}

		for(int i=0;i<count;i++){
			fs=fs+")";
		}
		return fs;
	}
}