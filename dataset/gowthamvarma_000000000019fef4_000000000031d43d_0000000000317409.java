package com.codejam.year2020.round_1C;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private static final boolean DEBUG = false;
	
	public static void main(String[] args) throws FileNotFoundException {
		long beginTime = System.nanoTime();
		InputStream is = DEBUG ? new FileInputStream("C:\\Users\\Gowtham\\Downloads\\codejam-master\\codejam-master\\src\\main\\java\\com\\codejam\\year2020\\round_1C\\OverexcitedFan.txt") : System.in;
		try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
			int testCount = scanner.nextInt();
			//System.out.println("testCount :: " + testCount);
			for (int testNumber = 1; testNumber <= testCount; testNumber++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				String m = scanner.next();
				solve(testNumber, x, y, m);
			}
		}
		System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
	}

	private static void solve(int testNumber, int x1, int y1, String m) {
		boolean result = false;

		//System.out.println(x + " :: " + y + " :: " + m);

		String resStr = "IMPOSSIBLE";
		
		Point fac = new Point(0, 0);
		Point cat = new Point(x1, y1);
		
		if(fac.equals(cat)) {
			resStr = "0";
		} else {
			for (int i = 0; i  < m.length(); i++) {
				char c = m.charAt(i);
				cat.update(c);
				if(fac.equals(cat)) {
					resStr = "" + (i + 1);
					break;
				}
				/*
				System.out.println(cat);
				System.out.println("abs :: " + cat.abs());
				System.out.println("i :: " + i);
				*/
				if(cat.abs() <= i + 1) {
					resStr = "" + (i + 1);
					break;
				}
			}
		}

		System.out.println("Case #" + testNumber + ": " + resStr);

	}

}

class Point{
	
	int x;
	int y;
	
	public Point(int x,int y) {
		this.x = x;
		this.y = y;

	}
	
	public void update(char c) {
		switch (c) {
		case 'N':
			y++;
			break;
		case 'S':
			y--;
			break;
		case 'E':
			x++;
			break;
		case 'W':
			x--;
			break;
		default:
			break;
		}
	}
	
	public int abs() {
		return Math.abs(x) + Math.abs(y);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	
}
