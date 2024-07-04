package test;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class Parenting {
	
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int inputSize = sc.nextInt();
		for(int k = 1 ; k <= inputSize ; k++) {
		int noOfCases = sc.nextInt();
		TreeMap<Integer,Integer> entries = new TreeMap<>();
		for(int i= 1 ; i <=noOfCases  ; i++) {
			int key = sc.nextInt();
			int value = sc.nextInt();
			entries.put(key, value);
		}	
		
		generateOutput(entries, k);
	
	
		}
		}
	
	private static void generateOutput(TreeMap<Integer, Integer> input, int no) {
		boolean flag = true;
		String worker1 = "C";
		String worker2 = "J";
		Stack<String> s = new Stack<>();
		Entry<Integer,Integer> Fitem = input.pollFirstEntry();
		s.push(worker1);
		Entry<Integer,Integer> Sitem = input.pollFirstEntry();
		s.push(worker2);
		int firstEndTime = Fitem.getValue();
		int SecondEndTime = Sitem.getValue();
		while(!input.isEmpty() && flag) {
			Entry<Integer,Integer> Titem = input.firstEntry();
			int ThirdStartTime=Titem.getKey();
			int ThirdEndTime = Titem.getValue();
			if(ThirdStartTime >= firstEndTime) {
				input.pollFirstEntry();
				firstEndTime = ThirdEndTime;
				s.push(worker1);
			}
			else if(ThirdStartTime  >= SecondEndTime) {

					input.pollFirstEntry();
					SecondEndTime = ThirdEndTime;
					s.push(worker2);
				}
             else {
				flag = false;
			}
			}
		if(input.isEmpty()) {
			System.out.print("Case #"+no+": "+s);
		}
		else {
			System.out.print("Case #"+no+":"+"Impossible");
		}
		
			
	}
			
	}
	
