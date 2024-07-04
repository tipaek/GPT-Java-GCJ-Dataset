import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			String str[];
			String m = in.next();
			str = groupByDigits(m);
			String result = process(str);
			System.out.println("Case #" + i + ": " + result);
		}
		System.exit(0);
	}

	static String[] groupByDigits(String str) {
		String[] out = str.split("(?<=(.))(?!\\1)");
		return out;
	}

	static String process(String[] str) {
		ArrayList<String[]> list = new ArrayList<>();
		ArrayList<DepthWrapper> wrapper = new ArrayList<>();
		int[] depths = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			int n = Integer.parseInt(str[i].substring(0, 1));
			depths[i] = n;
			DepthWrapper dw = new DepthWrapper(n, str[i], i);
			wrapper.add(dw);
		}

		Collections.sort(wrapper, new Comparator<DepthWrapper>() {
			@Override
			public int compare(DepthWrapper o1, DepthWrapper o2) {
				return o1.getPos() - o2.getPos();
			}
		});

//		System.out.println(wrapper);
		String finalResult = "";
		for (int i = 0; i < wrapper.size(); i++) {
			String s = "";
			DepthWrapper dw = wrapper.get(i);
			int n = dw.getDepth();
			String wStr = dw.getStr();
			s += addParenthesis(wStr, n);
			finalResult += s;
		}
//		System.out.println(finalResult);
		return finalResult;
	}

	static String addParenthesis(String str, int levels) {
		if (levels == 0) {
			return str;
		}
		String s = "";
		String prefix = "";
		String suffix = "";
		for (int i = 0; i < levels; i++) {
			prefix += "(";
			suffix += ")";
		}
		s = prefix + str + suffix;
		return s;
	}

	static class DepthWrapper {
		int depth;
		int pos;
		String str;

		public DepthWrapper(int d, String s, int pos) {
			this.depth = d;
			this.str = s;
			this.pos = pos;
		}

		public int getDepth() {
			return depth;
		}

		public void setDepth(int depth) {
			this.depth = depth;
		}

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}

		public int getPos() {
			return pos;
		}

		public void setPos(int pos) {
			this.pos = pos;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.getStr() + ":" + this.getDepth() + ":" + this.getPos();
		}
	}
}
