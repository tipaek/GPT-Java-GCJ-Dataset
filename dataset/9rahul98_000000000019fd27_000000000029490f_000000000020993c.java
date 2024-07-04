import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) {
		String output = "";
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int testCasesNum = in.nextInt();
		
		for(int i = 1;i <= testCasesNum; i++) {
			
			int matrixSize = in.nextInt();
			
			List<Integer> matrix = new ArrayList<>();
			String line = "";
			
			for(int j = 0;j <= matrixSize; j++) {
				line = line + " " + in.nextLine();
				line = line.trim();
			}
			matrix.addAll(Arrays.asList(line.split(" ")).stream().mapToInt(k -> Integer.parseInt(k)).boxed().collect(Collectors.toList()));
			System.out.println("Case #"+i+": "+calculateTrace(matrix, matrixSize)+" "+rowMaxCount(matrix, matrixSize)+" "+colMaxCount(matrix, matrixSize));
		}
	}
	
	public static int calculateTrace(List<Integer> matrix, int matrixSize)
	{
		int index = 0;
		int trace = 0;
		while(index < matrix.size())
		{
			trace = trace + matrix.get(index);
			index = index + matrixSize + 1;
		}
		return trace;
	}
	
	public static int rowMaxCount(List<Integer> matrix, int matrixSize)
	{
		Map<Integer, HashMap<Integer, Integer>> hm = new HashMap<Integer, HashMap<Integer, Integer>>(); 
		for (int i = 0; i < matrix.size(); i++) {
			if(hm.containsKey((i/matrixSize) +1))
			{
				HashMap<Integer, Integer> temp = hm.get((i/matrixSize) +1);
				Integer count = temp.get(matrix.get(i));
				temp.put(matrix.get(i), (count == null) ? 1 : count + 1);
			}
			else
			{
				HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
				temp.put(matrix.get(i), 1);
				hm.put((i/matrixSize) +1, temp);
			}
		}
		Map<Integer,Integer> colCount = new HashMap<Integer, Integer>();
		hm.forEach((k, v) -> colCount.put(k, v.values().size()));
		long elementCount = colCount.values().stream().filter(num -> num < matrixSize).count();
		return (int)elementCount;
	}

	public static int colMaxCount(List<Integer> matrix, int matrixSize)
	{
		Map<Integer, HashMap<Integer, Integer>> hm = new HashMap<Integer, HashMap<Integer, Integer>>(); 
		for (int i = 0; i < matrix.size(); i++) {
			if(hm.containsKey((i%matrixSize) +1))
			{
				HashMap<Integer, Integer> temp = hm.get((i%matrixSize) +1);
				Integer count = temp.get(matrix.get(i));
				temp.put(matrix.get(i), (count == null) ? 1 : count + 1);
			}
			else
			{
				HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
				temp.put(matrix.get(i), 1);
				hm.put((i%matrixSize) +1, temp);
			}
		}
		Map<Integer,Integer> colCount = new HashMap<Integer, Integer>();
		hm.forEach((k, v) -> colCount.put(k, v.values().size()));
		long elementCount = colCount.values().stream().filter(num -> num < matrixSize).count();
		return (int)elementCount;
	}
}
