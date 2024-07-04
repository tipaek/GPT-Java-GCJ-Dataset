import java.util.*;
import java.io.*;

public class Solution {	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int nbTest;
		
		nbTest = Integer.valueOf(in.nextLine());
		
		for(int i = 0; i < nbTest; i++){
			String[] line;
			int x;
			int y;
			String s;
			Point perso;
			Point peppur;
			Point saveperso;
			boolean finish = false;
			
			line = in.nextLine().split(" ");
			x = Integer.valueOf(line[0]);
			y = Integer.valueOf(line[1]);
			s = line[2];
			
			perso = new Point(0, 0);
			peppur = new Point(x, y);
			saveperso = perso;
			int nbTour = 0;
			while(s.length() > 0 && !finish){
				Point previousPeppur;
				Point previousPerso;
				double dist;
				char c;
				char min;
				
				nbTour++;
				previousPeppur = peppur;
				previousPerso = saveperso;
				c = s.charAt(0);
				s = s.substring(1);
				
				if(c == 'E'){
					peppur = new Point(previousPeppur.getX() + 1, previousPeppur.getY());
				} else if(c == 'W'){
					peppur = new Point(previousPeppur.getX() - 1, previousPeppur.getY());
				} else if(c == 'N'){
					peppur = new Point(previousPeppur.getX(), previousPeppur.getY() + 1);
				} else {
					peppur = new Point(previousPeppur.getX(), previousPeppur.getY() - 1);
				}
				
				perso = new Point(previousPerso.getX() + 1, previousPerso.getY());
				dist = perso.getDistance(peppur);
				min = 'E';
				saveperso = perso;
				perso = new Point(previousPerso.getX() - 1, previousPerso.getY());
				if(perso.getDistance(peppur) < dist){
					dist = perso.getDistance(peppur);
					min = 'W';
					saveperso = perso;
				}
				perso = new Point(previousPerso.getX(), previousPerso.getY() + 1);
				if(perso.getDistance(peppur) < dist){
					dist = perso.getDistance(peppur);
					min = 'N';
					saveperso = perso;
				}
				perso = new Point(previousPerso.getX(), previousPerso.getY() - 1);
				if(perso.getDistance(peppur) < dist){
					dist = perso.getDistance(peppur);
					min = 'S';
					saveperso = perso;
				}
				perso = new Point(previousPerso.getX(), previousPerso.getY());
				if(perso.getDistance(peppur) < dist){
					dist = perso.getDistance(peppur);
					min = 'X';
					saveperso = perso;
				}
				
				//System.out.println(saveperso + " " + peppur);
				
				if(dist == 0){
					finish = true;
				}
			}
			
			if(finish){
				System.out.println("Case #" + (i + 1) + ": " + nbTour);
			} else {
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
			}
		}
	}
}

class Point {
	private int x;
	private int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public double getDistance(Point p){
		return Math.sqrt(Math.pow(p.getX() - this.x, 2) + Math.pow(p.getY() - this.y, 2));
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString(){
		return "(" + this.x + ", " + this.y + ")";
	}
}