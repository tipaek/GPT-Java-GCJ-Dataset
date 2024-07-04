import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution4 {
    static int queryCount = 1;
    static int query = 1;
    static Map<String, String> distortedResponse = new HashMap<>();
    static int MAX_QUERY = 150;
    static int B = -1;
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int caseNo = -1;
	int eachCase = 1;
	String num = null;
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
		makeRCOps(queryCount, result);
		result = "";
	    }
	    if (queryCount > MAX_QUERY) {
		System.out.println(getResult());
		boolean valid = validateOutput(sc);
		if (valid) {
		    eachCase++;
		    if (eachCase > caseNo)
			break;
		    result = "";
		    distortedResponse.clear();
		} else {
		    break;
		}
	    }
	}

	sc.close();
    }

    private static String getResult() {
	Map<String, Integer> resultMap = new HashMap<>();
	Integer cnt = 0;
	for (int i = 1; i <= MAX_QUERY; i = i + 10) {
	    cnt = resultMap.get(distortedResponse.get(i + "_ORG"));
	    cnt = (cnt == null) ? 0 : cnt;
	    resultMap.put(distortedResponse.get(i + "_ORG"), cnt + 1);
	    cnt = resultMap.get(distortedResponse.get(i + "_REV"));
	    cnt = (cnt == null) ? 0 : cnt;
	    resultMap.put(distortedResponse.get(i + "_REV"), cnt + 1);
	    cnt = resultMap.get(distortedResponse.get(i + "_COM"));
	    cnt = (cnt == null) ? 0 : cnt;
	    resultMap.put(distortedResponse.get(i + "_COM"), cnt + 1);
	    cnt = resultMap.get(distortedResponse.get(i + "_COM+REV"));
	    cnt = (cnt == null) ? 0 : cnt;
	    resultMap.put(distortedResponse.get(i + "_COM+REV"), cnt + 1);
	}
	String resultKey = null;
	for (String key : resultMap.keySet()) {
	    if (resultMap.get(key) >= cnt) {
		cnt = resultMap.get(key);
		resultKey = key;
	    }
	}
	return resultKey;
    }

    private static void makeRCOps(int queryCount2, String result) {
	queryCount2 = queryCount2 - 10;
	distortedResponse.put(queryCount2 + "_ORG", result);
	String reverse = new StringBuffer(result).reverse().toString();
	distortedResponse.put(queryCount2 + "_REV", reverse);
	String comp = "";
	for (int i = 0; i < result.length(); i++) {
	    comp += (result.charAt(i) == '0') ? '1' : '0';
	}
	distortedResponse.put(queryCount2 + "_COM", comp);
	distortedResponse.put(queryCount2 + "_COM+REV", new StringBuffer(comp).reverse().toString());
    }

    private static boolean validateOutput(Scanner sc) {
	sc.hasNext();
	String num = sc.nextLine();
	if (num.equals("N")) {
	    // System.out.println("OUTPUT DIDN'T MATCH");
	    return false;
	} else if (num.equals("Y")) {
	    queryCount = 1;
	    query = 1;
	    distortedResponse.clear();
	}
	return true;
    }

    static String getLast1CorrectResponse(Scanner sc) {
	System.out.println(query++);
	queryCount++;
	sc.hasNext();
	return sc.nextLine();
    }
}
