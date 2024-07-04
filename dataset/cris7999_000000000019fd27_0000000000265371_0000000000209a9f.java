import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
	
		int numTest = sc.nextInt();
		sc.nextLine();
		for(int test=0;test<numTest;++test) {
			
			String digits= sc.nextLine();
			List<Character> myList=digits.chars().mapToObj(m ->(char) m).collect(Collectors.toList());
			
			int index=0;
			boolean parOpen=false;
			
			while(index<myList.size()) {
				if(parOpen) {
					if(!myList.get(index).equals('1')) {
						myList.add(index, ')');
						index+=2;
						parOpen=false;
					}else {
						index++;
					}
				}else {
					if(myList.get(index).equals('1')) {
						myList.add(index, '(');
						index+=2;
						parOpen=true;
					}else {
						index++;
					}
				}
				
				
			}
			if(myList.get(myList.size()-1).equals('1')) {
				myList.add(myList.size(), ')');
			}
				
			System.out.print("Case #"+(test+1)+": ");
			for(Character c:myList) {
				System.out.print(c);
			}
			System.out.println();
		}
	
	}		
}

