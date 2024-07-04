package com.google.codejam;

import java.io.*;
import java.util.*;

public class Vestigium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int cases=Integer.parseInt(br.readLine());
			StringBuilder output = new StringBuilder();
			for(int i=1; i<= cases; i++) {
				output = new StringBuilder();
				output.append("Case #").append(i).append(":").append(" ");
				int matrixSize = Integer.parseInt(br.readLine());
				Vestigium.Case c = new Vestigium().new Case(i, matrixSize);
				for(int j=0; j<matrixSize;j++) {
					String[] rowVals = br.readLine().split(" ");
					c.calculateAllValues(j, rowVals);
				}
				output.append(c.getTrace()).append(" ").append(c.getRepeatRowCount()).append(" ").append(c.getRepeatColCount());
				System.out.println(output);
			}
			br.close();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	class Case{
		int id;
		int size;
		int repeatRowCount;
		Set<Integer> rowSet = new HashSet<>();
		int repeatColCount;
		HashMap<Integer, Set<Integer>> colMap = new HashMap<>();
		int trace;
		
		Case(int id, int size){
			this.id = id;
			this.size = size;
		}
		
		public void calculateAllValues(int rowIndex, String[] vals) {
			rowSet.clear();
			Set<Integer> colSet;
			for(int colInd=0; colInd<this.size; colInd++) {
				int val = Integer.parseInt(vals[colInd]);
				if(!rowSet.contains(val)) {
					rowSet.add(val);
				}
				if(colMap.containsKey(colInd)) {
					colSet = colMap.get(colInd);
				} else {
					colSet = new HashSet<>();
				}
				colSet.add(val);
				colMap.putIfAbsent(colInd, colSet);
				if(colInd == rowIndex) trace += val;
			}
			if(rowSet.size() != this.size) this.repeatRowCount++;
			
		}

		public int getRepeatRowCount() {
			return repeatRowCount;
		}

		public int getRepeatColCount() {
			colMap.forEach((k,v) -> {
				if(v.size() != this.size) this.repeatColCount++;
			});
			return repeatColCount;
		}

		public int getTrace() {
			return trace;
		}
		
	}

}
