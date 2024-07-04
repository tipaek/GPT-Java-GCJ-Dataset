import java.util.*;
import java.awt.Rectangle;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberTest = in.nextInt();
		for (int i = 0; i < numberTest; i++) {
			boolean failed = false;
			String finalString = "";
			ArrayList<Rectangle> rectsC = new ArrayList<Rectangle>();
			ArrayList<Rectangle> rectsL = new ArrayList<Rectangle>();
			//in.nextLine();
			int crazy = in.nextInt();
			for (int j = 0; j < crazy; j++) {
				//in.nextLine();
				int nextValue = in.nextInt();
				int endValue = in.nextInt();
				boolean failing = false;
				Rectangle rect = new Rectangle(nextValue,0, endValue - nextValue, 2);
				
				for (Rectangle r : rectsC) {
					if (rect.intersects(r)) {
						failing = true;
						for (Rectangle rl : rectsL) {
							if (rect.intersects(rl)) {
								failed = true;
								break;
							}
						}
						break;
					}
				}
				
				if (failing) {
					rectsL.add(rect);
					finalString = finalString + "J";
				} else {
					rectsC.add(rect);
					finalString = finalString + "C";
				}
			}
			
			if (failed) {
				System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + (i+1) + ": " + finalString);
			}
		}
	}
}