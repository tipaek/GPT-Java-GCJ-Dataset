import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner input = new Scanner(System.in);
        int numberT = input.nextInt();

        for (int caseNum = 1; caseNum <= numberT; caseNum++) {
            int numN = input.nextInt();
            int numD = input.nextInt();
            ArrayList<Long> numAList = new ArrayList<>();
            HashSet<Long> numASet = new HashSet<>();
            ArrayList<long[]> sameList = new ArrayList<>();
            for (int i = 0; i < numN; i++) {
            	long a = input.nextLong();
            	if (!numASet.add(a)) {
            		long n = 1;
            		int index = -1;
            		for (int j = 0; j < sameList.size(); j++) {
            			long[] nums = sameList.get(j);
            			if (nums[0] == a) {
            				n = nums[1];
            				index = j;
            			}
            		}
            		long[] nums = new long[2];
            		nums[0] = a;
            		nums[1] = n + 1;
            		if (index >= 0) {
            			sameList.set(index, nums);
            		} else {
            			sameList.add(nums);
            		}
            	} else {
                	numAList.add(a);
            	}

            }
            Collections.sort(numAList);
            int answer = solver(numN, numD, numAList, sameList);
            System.out.println("Case #"+caseNum+": " + answer);
        }
    }

    private static int solver(int numN, int numD, ArrayList<Long> numAList, ArrayList<long[]> sameList) {
    	if (numN == 1) {
    		return numD - 1;
    	}
    	if (numD == 1) {
    		return 0;
    	}
    	Data[] data = new Data[sameList.size()];
    	for (int i = 0; i < sameList.size(); i++) {
    		if (sameList.get(i)[1] >= numD) {
    			return 0;
    		}
    		data[i] = new Data(sameList.get(i)[0], (int)sameList.get(i)[1]);
    	}

    	Arrays.sort(data);

    	for (long i: numAList) {
    		for (Data d: data) {
    			if (i / d.a > 1) {
    				int n = (int)(i / d.a);
    				if (n + d.b > numD) {
    					return numD - d.b;
    				}
    			}
    		}
    	}
    	HashMap<Long, Integer> biMap = new HashMap<>();
    	for (long i: numAList) {
        	for (long j: numAList) {
        		if (i == j) {
        			continue;
        		}
        		if (biMap.containsKey(i)) {
        			int c = biMap.get(i);
        			int bi = (int)(j/i);
        			if (bi > c) {
        				biMap.put(i, bi);
        			}
        		} else {
        			int bi = (int)(j/i);
    				biMap.put(i, bi);
        		}
        	}
    	}
    	int max = 0;
    	for (int i: biMap.values()) {
    		if (i > max) {
    			max = i;
    		}
    	}
    	if (max > 0) {
    		if (max > numD) {
    			return numD - 1;
    		}
    		return max <= numD - 1?max - 1:numD - 1;
    	}

    	return numD - 1;
    }

    private static class Data implements Comparable<Data> {
        long a;
        int b;
        public Data(long a, int b) {
            this.a = a;
            this.b = b;
        }
        public int compareTo(Data other) {
            return other.b - this.b;
        }
    }
}
