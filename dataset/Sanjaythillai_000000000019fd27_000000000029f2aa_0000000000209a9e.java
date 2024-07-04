/**
 * 
 */
//package com.sanjay.google.code.jam.qual.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author s0t01cz
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String TB = br.readLine();
			String TBArr[] = TB.split(" ");
			Integer T = Integer.parseInt(TBArr[0]);
			Integer B = Integer.parseInt(TBArr[1]);
			Integer bitSize = 1;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < T; i++) {
				for (int j = 1; j <= 150; j++) {
					if (bitSize > B) {
						System.out.println(sb.toString());
						System.out.flush();
						String judgeRes = br.readLine();
						if (judgeRes.equalsIgnoreCase("Y")) {
							break;
						} else if (judgeRes.equalsIgnoreCase("N")) {
							System.exit(0);
						}
					}
//					if ((j % 40 >=32) || (j %40==0)) {
				if ((j % 40 >=32) || (j %40==0)) {
						System.out.println(bitSize);
						System.out.flush();
						Integer number = Integer.parseInt(br.readLine());
						sb.append(number);
						bitSize = bitSize + 1;
						
					} else {
						System.out.println(10);
						System.out.flush();
						Integer no = Integer.parseInt(br.readLine());
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
