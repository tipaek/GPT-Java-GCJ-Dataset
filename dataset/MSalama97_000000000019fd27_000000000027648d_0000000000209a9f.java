import java.util.Scanner;

 class p2 {

	 static String OpenBrackets(int num) {
		String res = "" ;
		for(int i =0 ; i< num ; i++) {
			res+="(";
			
		}
		return res;
	}
	 static String CloseBrackets(int num) {
		String res = "" ;
		for(int i =0 ; i< num ; i++) {
			res+=")";
			
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String res = "";
		String output = "";
		int casesCount = Integer.parseInt(sc.next());
		for(int i = 0 ; i<casesCount;i++) {
			String current = sc.next();
			int countO = 0 ;
			int countC = 0 ;
			for(int j = 0 ; j<current.length();j++) {
				int currentNum = Integer.parseInt(current.charAt(j)+"");
				if(countO<currentNum) {
					res+= OpenBrackets(currentNum-countO);
					countO+= currentNum-countO ;
					res+= currentNum+"";
					
				}
				else if(countO>currentNum) {
					res+=CloseBrackets(countO-currentNum);
					countC+= countO-currentNum ;
					countO-=countO-currentNum;
					res+=currentNum+"";
				}
				else {
					res+=currentNum+"";
				}
				
				
				
			}
			res+=CloseBrackets(countO);
			if(i==casesCount-1) {
				output+= "Case #"+(i+1)+": " +res ;
			}
			else
			output+= "Case #"+(i+1)+": " +res +"\n";
			res = "" ;
		}
		System.out.println(output);
	}

}
