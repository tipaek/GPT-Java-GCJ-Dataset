import java.util.Scanner;

class NestingDepth {
	 
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in); 
		
		int nbrTc = in.nextInt();
		
		for(int nbr =1; nbr <= nbrTc ; nbr++) {
		
		 String s = in.next(); 
		
		
		
		 StringBuilder sb = new StringBuilder();
		 
		 char[] arr = s.toCharArray();
		 
		 for(int i =0; i< arr.length;i++) {
			 
			int val = Integer.valueOf(String.valueOf(arr[i]));
			
			for(int k = 0; k<val; k++) {
				 sb.append("(");
			 }
			sb.append(val);
			for(int l = 0; l<val; l++) {
				 sb.append(")");
			 }
		 }
		 
		 System.out.println("Case #"+nbr+": "+ sb.toString());
		}
		 in.close();
	 }

}