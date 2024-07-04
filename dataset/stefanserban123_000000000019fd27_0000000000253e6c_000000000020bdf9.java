import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		List<String> abc = new ArrayList<>();
		abc.stream().filter(e->e.equals("abc")).collect(Collectors.toList());
	}
}