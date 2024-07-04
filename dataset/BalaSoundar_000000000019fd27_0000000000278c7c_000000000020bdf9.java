
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int len=Integer.parseInt(sc.nextLine());
        for(int i=0;i<len;i++){
            int totalActivity=Integer.parseInt(sc.nextLine());
            int[][] input=new int[totalActivity][totalActivity];
            for(int k=0;k<totalActivity;k++) {
            	String[] inputArr=sc.nextLine().split(" ");
            	input[k][0]=Integer.parseInt(inputArr[0]);
            	input[k][1]=Integer.parseInt(inputArr[1]);
            }
            performCalcuation(input,i);
            
        }
        System.out.flush();
    }

	private static void performCalcuation(int[][] input,int testcase) {
		StringBuilder sb=new StringBuilder();
		Set<Integer> CSet=new HashSet<Integer>();
		Set<Integer> JSet=new HashSet<Integer>();
		boolean isCSelected=true;
		for(int i=0;i<input.length;i++) {
			isCSelected=true;
			for(int j=input[i][0];j<input[i][1];j++) {
				if(CSet.contains(j)) {
					if(JSet.contains(j)) {
						System.out.println("Case #"+(testcase+1)+": "+"IMPOSSIBLE");
						return;
					}
					isCSelected=false;
				}
			}
			for(int j=input[i][0];j<input[i][1];j++) {
				if(isCSelected) {
					CSet.add(j);
				}else {
					JSet.add(j);
				}
			}
			if(isCSelected) {
				sb.append("C");
			}else {
				sb.append("J");
			}
		}
		
		System.out.println("Case #"+(testcase+1)+": "+sb.toString());
	}    
    
    
}