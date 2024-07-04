import java.util.Scanner;
class Solution{
    
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        int x = 1;
        while(testCases>0){
            
        	String input = sc.nextLine();
        	String ans= "";
        	int open = 0, close = 0; 
        	for(int i = 0; i< input.length();i++) {
        		int num = Integer.parseInt(input.substring(i,i+1));
        		if(open< num) {
        			while(open<num) {
        				ans+="(";
        				open++;
        			}
        		}
        		else if(open>num) {
        			int toClose = open-num;
        			while(toClose>0) {
        				toClose--;
        				ans+=")";
        			}
        			open = num;
        			close += toClose;
        		}
        		ans+=input.substring(i,i+1);
    		}
        	while(close<open) {
        		close++;
        		ans+=")";
        	}
            System.out.println("Case #"+x+": "+ans);
            x++;
            testCases--;
        }
    }
}


