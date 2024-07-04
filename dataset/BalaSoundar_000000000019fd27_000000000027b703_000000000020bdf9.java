
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int len=sc.nextInt();
        for(int i=0;i<len;i++){
            int totalActivity=sc.nextInt();
            sc.nextLine();
            int[][] input=new int[totalActivity][totalActivity];
            for(int k=0;k<totalActivity;k++) {
            	String currLine=sc.nextLine();
            	//System.out.println("Current line read :"+currLine);
            	String[] inputArr=currLine.split(" ");
            	input[k][0]=Integer.parseInt(inputArr[0]);
            	input[k][1]=Integer.parseInt(inputArr[1]);
            }
            performCalcuation(input,i);
            
        }
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