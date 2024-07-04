package com.sabya.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Vestigium {
	public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        int testCases = inp.nextInt();
        //System.out.println(testCases);
        for(int k = 1;k<=testCases;k++){
            int matLen = inp.nextInt();
            //System.out.println(matLen);
            int[][] arr = new int[matLen][matLen];
            for(int i = 0;i<matLen;i++) {
            	for(int j = 0;j<matLen;j++) {
            		arr[i][j]= inp.nextInt();
            	}
            }
            int count = 0;
            for(int i = 0;i<matLen;i++) {
            	count+=arr[i][i];
            }
            int rowCount = 0;
            int colCount = 0;
            Map<Integer, HashMap<Integer, Integer>> rowMap = new HashMap<Integer, HashMap<Integer,Integer>>();
            for(int i = 0;i<matLen;i++) {
            	HashMap<Integer, Integer> row = new HashMap<Integer, Integer>();
            	HashMap<Integer, Integer> col = new HashMap<Integer, Integer>();
            	for(int j = 0;j<matLen;j++) {
            		if(row.containsKey(arr[i][j])) {
            			int newVal = row.get(arr[i][j])+1;
            			row.put(arr[i][j], newVal);
            		}
            		else {
            			row.put(arr[i][j], 1);
            		}
            		
            		if(col.containsKey(arr[j][i])) {
            			int newVal = col.get(arr[j][i])+1;
            			col.put(arr[j][i], newVal);
            		}
            		else {
            			col.put(arr[j][i], 1);
            		}
            		
            	}
            	for(Map.Entry mapEntry : row.entrySet()) {
            		if((int)(mapEntry.getValue())>1) {
            			rowCount++;
            			break;
            		}
            	}
            	for(Map.Entry mapEntry : col.entrySet()) {
            		if((int)(mapEntry.getValue())>1) {
            			colCount++;
            			break;
            		}
            	}
      
            }
            System.out.println("Case #"+k+": "+count+" "+rowCount+" "+colCount);
            
        }
    }

}
