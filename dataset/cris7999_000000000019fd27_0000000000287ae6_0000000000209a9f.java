import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int numTest = sc.nextInt();
		sc.nextLine();
		for(int test=0;test<numTest;++test) {		
			
			String digits = sc.nextLine();
			boolean first = true;
		    String result = new String();
		    LinkedList<Character> resultLinkedList = new LinkedList<Character>();
		    int previous = 0;
	
		    for(int i = 0; i < digits.length(); ++i){
		    	int n = (int) (digits.charAt(i) - '0');
	            if(first){
	            	first = false;
	                for(int j = 0; j < n; ++j){
		                result += '(';
		                resultLinkedList.addLast(')');
		                }
		            }
		            else{
		                
		                if(previous - n > 0){
		                    for(int j = 0; j < previous - n; ++j){
		                        result += resultLinkedList.removeFirst();
		                    }
		                }
		                else{
		                	int diff = Math.abs(previous - n);
	
		                    for (int j = 0; j < diff; ++j){
		                        result += '(';
		                        resultLinkedList.addLast(')');
		                    }
		                }
		            }
	            	previous = n;
		            result += n;
		            
		        }
	
		        while(!resultLinkedList.isEmpty()){
		            result += resultLinkedList.removeFirst();
		        }
	
		        System.out.println("Case #"+(test+1)+": "+result);
		}
	}		
}

