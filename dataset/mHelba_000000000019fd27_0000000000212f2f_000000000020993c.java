import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int nbTest;
		int taille;
		int[][] tabInt;
		int trace;
		int repetRow;
		int repetCol;
		
		nbTest = in.nextInt();
		for(int i = 0; i < nbTest; i++){
			taille = in.nextInt();
			tabInt = new int[taille][taille];
			
			for(int j = 0; j < taille; j++){
				for(int k = 0; k < taille; k++){
					tabInt[j][k] = in.nextInt();
				}
			}
			
			trace = calcTrace(tabInt, taille);
			repetRow = nbRepetRows(tabInt, taille);
			repetCol = nbRepetCols(tabInt, taille);
			System.out.println("Case #" + (i + 1) + ": " + trace + " " + repetRow + " " + repetCol);
		}
	}
	
	public static int calcTrace(int[][] tab, int taille){
		int res = 0;
		
		for(int i = 0; i < taille; i++){
			for(int j = 0; j < taille; j++){
				if(i == j){
					res += tab[i][j];
				}
			}
		}
		
		return res;
	}
	
	public static int nbRepetRows(int[][] tab, int taille){
		int res = 0;
		
		for(int i = 0; i < taille; i++){
			if(hasRepetRow(tab, i, taille)){
				res++;
			}
		}
		
		return res;
	}
	
	public static int nbRepetCols(int[][] tab, int taille){
		int res = 0;
		
		for(int i = 0; i < taille; i++){
			if(hasRepetColumn(tab, i, taille)){
				res++;
			}
		}
		
		return res;
	}
	
	public static boolean hasRepetRow(int[][] tab, int row, int taille){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < taille; i++){
			int val = tab[row][i];
			
			if(!map.containsKey(val)){
				map.put(val, 1);
			} else {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean hasRepetColumn(int[][] tab, int col, int taille){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < taille; i++){
			int val = tab[i][col];
			
			if(!map.containsKey(val)){
				map.put(val, 1);
			} else {
				return true;
			}
		}
		
		return false;
	}
}