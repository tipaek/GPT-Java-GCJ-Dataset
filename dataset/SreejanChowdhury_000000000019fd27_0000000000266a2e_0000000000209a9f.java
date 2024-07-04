import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
    	int testCount = in.nextInt();
    	in.nextLine();
        for (int t = 1; t <= testCount; t++) {
    		
    		char [] c = in.nextLine().toCharArray();
    		
    		formString(c,t);
    		System.out.println();
        }

	}
	
	private static void formString(char [] c,int t ) {
		
		Deque<Character> deque = new LinkedList<Character>();
		int lastIn = -1,element = -1;
		for(int i =0; i < c.length ; i++) {
			element = c[i] - '0';
			//if first element
			if(i ==0) {
				
				lastIn = element;
				/*deque.addFirst(c[i]);
				for(int j = 0 ; j < element ; j++) {
					deque.addFirst('(');
					deque.addLast(')');
				}*/
				deque.addAll(getString(element, c[i]));
			}
			//if next element is bigger or equal
			//remove the end ) equal to last added element
			else if(element >= lastIn) {
				//remove )
				for(int j = 0; j < lastIn ; j++) {
					deque.pollLast();
				}
				//add the string with valid min ( and )
				deque.addAll(getString(element - lastIn, c[i]));
				//add )
				for(int j = 0; j < lastIn ; j++) {
					deque.addLast(')');
				}
				
				lastIn = element;
			}
			//if next element is less than last entry
			//remove the end ) equal to element 
			else if(element < lastIn) {
				//remove )
				for(int j = 0; j < element ; j++) {
					deque.pollLast();
				}
				//add the element
				deque.addLast(c[i]);
				for(int j = 0; j < element ; j++) {
					deque.addLast(')');
				}
				
				lastIn = element;
			}
			
		}
		
		System.out.print("Case #"+t+": ");
		deque.forEach(x -> System.out.print(x));
	}
	
	private static Deque<Character> getString(int count,char element){
		
		Deque<Character> deque = new LinkedList<Character>();
		deque.addFirst(element);
		for(int j = 0 ; j < count ; j++) {
			deque.addFirst('(');
			deque.addLast(')');
		}
		return deque;
	}
	
	
}
