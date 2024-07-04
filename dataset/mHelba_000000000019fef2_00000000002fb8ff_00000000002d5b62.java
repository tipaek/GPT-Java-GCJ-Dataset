import java.util.*;
import java.io.*;

public class Solution {	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int nbTest;
		BruteForceGenerator bruteforce = new BruteForceGenerator(10);
		
		bruteforce.genererBruteForce("");
		nbTest = in.nextInt();
		
		for(int i = 0; i < nbTest; i++){
			int x;
			int y;
			String sol;
			
			x = in.nextInt();
			y = in.nextInt();
			sol = bruteforce.findSolution(new Couple(x, y));
			
			System.out.println("Case #" + (i + 1) + ": " + sol);
		}
	}
}

class BruteForceGenerator{
	int taille;
	ArrayList<String> listeBruteForce = new ArrayList<String>();
	
	public BruteForceGenerator(int taille){
		this.taille = taille;
	}
	
	public void genererBruteForce(String accu){
		if(accu.length() == this.taille){
			this.listeBruteForce.add(accu);
		} else {
			for(int i = 3; i >= 0; i--){
				this.genererBruteForce(accu + String.valueOf(i));
			}
		}
	}
	
	public String findSolution(Couple arrivee){
		int taille = -1;
		String finalSol = "";
		
		for(int i = 0; i < listeBruteForce.size(); i++){
			String sol = listeBruteForce.get(i);
			
			Couple depart = new Couple(0, 0);
			
			for(int j = 0; j < sol.length(); j++){
				int elem;
				
				elem = Integer.valueOf(String.valueOf(sol.charAt(j)));
				depart = calculateRes(depart, elem, j + 1);
				if(depart.getX() == arrivee.getX() && depart.getY() == arrivee.getY()){
					if(taille == -1 || j < taille){
						taille = j;
						finalSol = convertFinalSol(sol.substring(0, j + 1));
						j = sol.length();
					}
				}
			}
		}
		
		if(taille == -1){
			return "IMPOSSIBLE";
		} else {
			return finalSol;
		}
	}
	
	public static int calculateIthJump(int i){
		return (int) Math.pow(2, i - 1);
	}
	
	public static String convertFinalSol(String s){
		String res = "";
		
		for(int i = 0; i < s.length(); i++){
			int elem = Integer.valueOf(String.valueOf(s.charAt(i)));
			
			if(elem == 0){
				res += "N";
			} else if(elem == 1){
				res += "S";
			} else if(elem == 2){
				res += "E";
			} else {
				res += "W";
			}
		}
		
		return res;
	}
	
	public static Couple calculateRes(Couple depart, int s, int i){
		Couple res;
		
		res = new Couple(depart.getX(),  depart.getY());
		//Nord
		if(s == 0){
			res.setY(res.getY() + calculateIthJump(i));
		} else if(s == 1){
			res.setY(res.getY() - calculateIthJump(i));
		} else if(s == 2){
			res.setX(res.getX() + calculateIthJump(i));
		} else {
			res.setX(res.getX() - calculateIthJump(i));
		}
		
		return res;
	}
	
	public void printListe(){
		for(int i = 0; i < this.listeBruteForce.size(); i++){
			System.out.println(this.listeBruteForce.get(i));
		}
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public ArrayList<String> getListeBruteForce() {
		return listeBruteForce;
	}

	public void setListeBruteForce(ArrayList<String> listeBruteForce) {
		this.listeBruteForce = listeBruteForce;
	}
}

class Couple {
	private int x;
	private int y;
	
	public Couple(int x, int y){
		this.x = x;
		this.y = y;
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
}
