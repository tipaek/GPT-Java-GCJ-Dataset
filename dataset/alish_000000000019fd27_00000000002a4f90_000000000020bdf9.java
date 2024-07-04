import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(System.in);
			int cases = input.nextInt(), activities;
			
			for (int i = 1; i <= cases; i++) {
				activities = input.nextInt();
				
				String result = "";
				LinkedList<Integer> cameron = new LinkedList<>();
				LinkedList<Integer> jamie = new LinkedList<>();
				int start, finish;
				
				cameron.add(input.nextInt());
				cameron.add(input.nextInt());
				jamie.add(input.nextInt());
				jamie.add(input.nextInt());
				result += "CJ";
				
				boolean stopCameron, stopJamie;
				for (int j = 3; j <= activities; j++) {
					stopCameron = stopJamie = false;
					start = input.nextInt();
					finish = input.nextInt();
					for (int k = 0; k < cameron.size(); k+=2) {
						if ((start > cameron.get(k) && start < cameron.get(k+1)) || (finish > cameron.get(k) && finish < cameron.get(k+1))) {
								stopCameron = true;
								break;
						}
						else
							if (finish == cameron.get(k)) {
								cameron.set(k, start);
								result += "C";
								break;
							}
							else
								if (finish < cameron.get(k)) {
									cameron.addFirst(finish);
									cameron.addFirst(start);
									result += "C";
									break;
								}
								else 
									if (k+2 == cameron.size() && start > cameron.get(k+1)) {
										cameron.addLast(start);
										cameron.addLast(finish);
										result += "C";
										break;
									}
									else
										if (start == cameron.get(k+1)) {
											cameron.set(k+1, finish);
											result += "C";
											break;
										}
					}
					
					if (stopCameron) {
						for (int k = 0; k < jamie.size(); k+=2) {
							if ((start > jamie.get(k) && start < jamie.get(k+1)) || (finish > jamie.get(k) && finish < jamie.get(k+1))) {
									stopJamie = true;
									break;
							}
							else
								if (finish == jamie.get(k)) {
									jamie.set(k, start);
									result += "J";
									break;
								}
								else
									if (finish < jamie.get(k)) {
										jamie.addFirst(finish);
										jamie.addFirst(start);
										result += "J";
										break;
									}
									else 
										if (start == jamie.get(k+1)) {
											jamie.set(k+1, finish);
											result += "J";
											break;
										}
										else
											if (k+2 == jamie.size() && start > jamie.get(k+1)) {
												jamie.addLast(start);
												jamie.addLast(finish);
												result += "J";
												break;
											}
						}
					}
					
					if (stopCameron && stopJamie) {
						for (; j < activities; j++) {
							start = input.nextInt();
							finish = input.nextInt();
						}
						result = "IMPOSSIBLE";
						break;
					}
								
				}
				
				result = "Case #" + i + ": " + result;
				System.out.println(result);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
