import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int N = in.nextInt();
			String[] pStr = new String[N];
			for (int i = 0; i < N; i++) {
				pStr[i] = in.next();
			}
			if (Arrays.stream(pStr).allMatch(p -> p.matches("\\*[A-Z]*"))) {
				String rst = null; {
					int l = 0;
					for (String p : pStr) {
						if (p.length() > l) {
							l = p.length();
							rst = p.substring(1);
						}
					}
					for (String p : pStr) {
						if (!rst.endsWith(p.substring(1))) {
							rst = null;
							break;
						}
					}
				}
				if (null == rst) {
					System.out.println("CASE #" + (t + 1) + ": *");
				} else {
					System.out.println("CASE #" + (t + 1) + ": " + rst);
				}
			} else if (Arrays.stream(pStr).allMatch(p -> p.matches("[A-Z]*\\*[A-Z]*"))) {
				String suffix = null; {
					int l = 0;
					for (String p : pStr) {
						int i = p.indexOf("*");
						int ll = p.length() - (i + 1);
						if (l < ll) {
							l = ll;
							suffix = p.substring(i + 1);
						}
					}
					for (String p : pStr) {
						int i = p.indexOf("*");
						if (!suffix.endsWith(p.substring(i + 1))) {
							suffix = null;
							break;
						}
					}
				}
				String prefix = null; {
					int l = 0;
					for (String p : pStr) {
						int i = p.indexOf("*");
						int ll = i;
						if (l < ll) {
							l = ll;
							prefix = p.substring(0, i);
						}
					}
					for (String p : pStr) {
						int i = p.indexOf("*");
						if (!prefix.startsWith(p.substring(0, i))) {
							prefix = null;
							break;
						}
					}
				}
				if (null == prefix || null == suffix) {
					System.out.println("CASE #" + (t + 1) + ": *");
				} else {
					System.out.println("CASE #" + (t + 1) + ": " + prefix + suffix);
				}
			}
//			P[] ps = new P[N];
//			for (int i = 0; i < N; i++) {
//				ps[i] = new P(pStr[i]);
//			}
//			StringBuilder prefix = new StringBuilder();
//			StringBuilder suffix = new StringBuilder();
//			for (;;) {
//				String nextPrefix = null; {
//					for (P p : ps) {
//						if (null != p.parts.get(0)) {
//							ne
//							break;
//						}
//					}
//				}
//				P fixed = null; {
//					for (P p : ps) {
//						if (p.isFixed()) {
//							fixed = p;
//							break;
//						}
//					}
//				}
//				if (null != fixed) {
//					String fixedStr = fixed.getFixed();
//					if (Arrays.stream(ps).allMatch(p -> p.match(fixedStr))) {
//						prefix.append(fixed.getFixed());
//					} else {
//						prefix.delete(0, prefix.length());
//						suffix.delete(0, suffix.length());
//						prefix.append("*");
//					}
//					break;
//				}
//			}
//			System.out.println("CASE #" + (t + 1) + ": " + prefix + suffix);
		}
	}

//	private static class P {
//		private static Pattern patternP = Pattern.compile("(\\*+)|([^\\*]+)");
//		private List<String> parts = new ArrayList<>();
//		public P(String string) {
//			Matcher matcher = patternP.matcher(string);
//			while (matcher.find()) {
//				String str = matcher.group(2);
//				parts.add(str);
//			}
//		}
//		public boolean isFixed() {
//			return parts.size() == 1 && parts.get(0) != null;
//		}
//		public String getFixed() {
//			return parts.get(0);
//		}
//		public boolean match(String fixed) {
//			int indexEnd = fixed.length();
//			int index = 0;
//			for (String p : parts) {
//				if (null == p) {
//					continue;
//				}
//				if (!fixed.startsWith(p, index)) {
//					return false;
//				}
//				index += p.length();
//			}
//			return index == indexEnd;
//		}
//	}
}
