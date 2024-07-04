import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int len=Integer.parseInt(sc.nextLine());
        for(int i=0;i<len;i++){
            String currInput=sc.nextLine();
            performCalcuation(currInput,i);
            
        }
        System.out.flush();
    }

	private static void performCalcuation(String input,int testcase) {
		int open=0;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<input.length();i++) {
			int currNum=Integer.parseInt(input.substring(i,i+1));
			if(currNum!=open) {
				int temp=currNum;
				if(temp<open) {
					temp=open-temp;
					while(temp>0) {
						sb.append(")");
						temp=temp-1;
						open--;
					}
				}else {
					temp=temp-open;
					while(temp>0) {
						sb.append("(");
						temp=temp-1;
						open++;
					}
				}
			}
			sb.append(currNum);
			
		}
		while(open>0) {
			sb.append(")");
			open--;
		}
		
		System.out.println("Case #"+(testcase+1)+": "+sb.toString());
	}    
    
    
}