import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class Solution {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int noOfTestCases = input.nextInt();
		List<String> list = new ArrayList<>();

		input.nextLine();
		for(int i=0;i<noOfTestCases;i++) {
				String str = input.nextLine();
				list.add(str);
		}
		
		int counter=1;
		for(String str:list) {
			
			System.out.flush();
			System.out.println("Case #"+counter+": "+createPattern(str));
			System.out.flush();
			counter++;
		}
		
		
	}

	private static String createPattern(String str) {
		
		StringBuilder sb = new StringBuilder();
		int prev=Integer.MAX_VALUE;
		int current=Integer.MAX_VALUE;
		
		for(int i=str.length()-1;i>=0;i-- ) {
			char ch = str.charAt(i);
			int value= Integer.valueOf(ch+"");
			current=value;
	   
			if(prev==Integer.MAX_VALUE) {
			
   // this is the first case when no element is in sb. 
			populateValue(current,current,sb,")");
		} else {
			if(current > prev) {
				int difference = current-prev;
				populateValue(difference,current,sb,")");
			}
			if(current==prev) {
				populateValue(0, current, sb,"");
			}
			if(current<prev) {
				int difference=prev-current;
				populateValue(difference,current,sb,"(");
			}
		}
			prev=current;
		}
		populateValue(current, Integer.MAX_VALUE, sb, "(");
		
		return sb.toString();
	}

	private static void populateValue(int current,int value, StringBuilder sb,String paran) {
		
		StringBuilder innerBuilder = new StringBuilder();
		
		for(int i=0;i<current;i++) {
			innerBuilder.append(paran);
		}
		String pattern=null;
		if(value==Integer.MAX_VALUE) {
			 pattern = innerBuilder.toString()+sb.toString();
		}else {
			 pattern = value+innerBuilder.toString()+sb.toString();		
		}
	
		sb.setLength(0);
		sb.append(pattern);
	}
}
