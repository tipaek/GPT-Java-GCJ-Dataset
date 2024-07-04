import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    static int queryCount = 1;
    static int query = 1;
    static Map<Integer, String> distortedResponse = new HashMap<>();
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int caseNo = -1;
	int eachCase = 1;
	String num = null;
	int B = -1;
	String result = "";
	while (true) {
	    if (caseNo == -1) {
		sc.hasNext();
		num = sc.nextLine().trim();
		caseNo = Integer.parseInt(num.split(" ")[0]);
		B = Integer.parseInt(num.split(" ")[1]);
	    }
	    if (queryCount % 10 == 1) {
		num = getLast1CorrectResponse(sc);
	    } else {
		System.out.println(query++);
		queryCount++;
		sc.hasNext();
		num = sc.nextLine();
	    }
	    result += num;
	    if (result.length() == B) {
		System.out.println(result);
		boolean valid = validateOutput(sc);
		if (valid) {
		    eachCase++;
		    if (eachCase > caseNo)
			break;
		    result = "";
		} else {
		    break;
		}
	    } else if (queryCount > 150) {
		System.out.println("QUERY EXCEEDED!");
		break;
	    }

	    /*if (queryCount < 150) {
		if (result.length() == B) {
		    System.out.println(result);
		} else {
		    if (queryCount % 10 == 1) {
			distortedResponse.put(query, num);
			System.out.println(query);
			queryCount++;
			continue;
		    } else {
			result += num; // one less query result value
		    }
		    System.out.println(query++);
		    queryCount++;
		}
	    } else {
		System.out.println("QUERY EXCEEDED!");
		break;
	    }*/
	}

	sc.close();
    }

    private static boolean validateOutput(Scanner sc) {
	sc.hasNext();
	String num = sc.nextLine();
	if (num.equals("N")) {
	    System.out.println("OUTPUT DIDN'T MATCH");
	    return false;
	} else if (num.equals("Y")) {
	    queryCount = 1;
	    query = 1;
	    distortedResponse.clear();
	}
	return true;
    }

    static String getLast1CorrectResponse(Scanner sc) {
	System.out.println(query);
	queryCount++;
	sc.hasNext();
	distortedResponse.put(query, sc.nextLine());
	System.out.println(query++);
	queryCount++;
	sc.hasNext();
	return sc.nextLine();
    }
}
