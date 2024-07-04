import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

class Solution {
	public static void main(final String... args) {
		// this code is written in CJam - https://sourceforge.net/projects/cjam/
		final String code = "li{[l~]}*]_ee::=:+\\{_S\\{__|=!},,@z}2*;";

//		System.out.println(code);
//		System.out.println(code.length());
		CJam.jamCode(code);
	}

	// everything below these lines is the CJam interpreter as of 2017
	// with minimal changes for embedding into a single file

	static interface In {
		String readNext();
		String readLine();
		String readAll();
	}

	abstract static class Out {
		public abstract void print(Object o);

		public void println() {
			print('\n');
		}

		public void println(final Object o) {
			print(o);
			print('\n');
		}
	}

	static class ScannerIn implements In {
		private final Scanner sc;
		private boolean eof;

		public ScannerIn(final Scanner sc) {
			this.sc = sc;
		}

		@Override
		public String readNext() {
			if (eof) {
				throw new RuntimeException("EOF");
			}
			try {
				return sc.next();
			}
			catch (NoSuchElementException e) {
				eof = true;
				return "";
			}
		}

		@Override
		public String readLine() {
			if (eof) {
				throw new RuntimeException("EOF");
			}
			try {
				return sc.nextLine();
			}
			catch (NoSuchElementException e) {
				eof = true;
				return "\n";
			}
		}

		@Override
		public String readAll() {
			if (eof) {
				return "";
			}
			eof = true;
			try {
				return sc.useDelimiter("\\A").next();
			}
			catch (NoSuchElementException e) {
				return "";
			}
		}
	}

	static class SystemIn extends ScannerIn {
		public SystemIn() {
			super(new Scanner(System.in));
		}
	}

	static class PrintStreamOut extends Out {
		private final PrintStream ps;

		public PrintStreamOut(final PrintStream ps) {
			this.ps = ps;
		}

		@Override
		public void print(final Object o) {
			ps.print(o);
		}

		@Override
		public void println() {
			ps.println();
		}

		@Override
		public void println(final Object o) {
			ps.println(o);
		}
	}

	static class SystemErr extends PrintStreamOut {
		public SystemErr() {
			super(System.err);
		}
	}

	static class SystemOut extends PrintStreamOut {
		public SystemOut() {
			super(System.out);
		}
	}

	static class CStream {
		private final Reader r;
		private char[] buf = new char[10];
		private int k = 0;
		private int o = 0;

		public CStream(final Reader r) {
			this.r = r;
		}

		public char get() {
			if (k > 0) {
				o++;
				return buf[--k];
			}
			try {
				final int x = r.read();
				if (x < 0) {
					throw new NoSuchElementException();
				}
				o++;
				return (char) x;
			}
			catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public void put(final char c) {
			buf[k++] = c;
			o--;
		}

		public char peek() {
			final char c = get();
			put(c);
			return c;
		}

		public int getOffset() {
			return o;
		}
	}

	abstract static class Op {
		protected final String name;

		public Op(final String name) {
			this.name = name;
		}

		public abstract void run(CJam x);

		@Override
		public String toString() {
			return name;
		}

		protected RuntimeException fail(final Object a) {
			return new RuntimeException(a.getClass().getSimpleName() + ' ' + name + " not implemented");
		}

		protected RuntimeException fail(final Object a, final Object b) {
			return new RuntimeException(a.getClass().getSimpleName() + ' ' + b.getClass().getSimpleName()
					+  ' ' + name + " not implemented");
		}

		protected RuntimeException fail(final Object a, final Object b, final Object c) {
			return new RuntimeException(a.getClass().getSimpleName() + ' ' + b.getClass().getSimpleName()
					+ ' ' + c.getClass().getSimpleName() + ' ' + name + " not implemented");
		}
	}

	abstract static class Op1 extends Op {
		public Op1(final String name) {
			super(name);
		}

		@Override
		public void run(final CJam x) {
			Object a = x.pop();
			final Object t = calc(x, a);
			if (t != null) {
				x.push(t);
			}
		}

		protected abstract Object calc(final CJam x, final Object a);
	}

	abstract static class Op2 extends Op {
		public Op2(final String name) {
			super(name);
		}

		@Override
		public void run(final CJam x) {
			Object b = x.pop();
			Object a = x.pop();
			final Object t = calc(x, a, b);
			if (t != null) {
				x.push(t);
			}
		}

		protected abstract Object calc(final CJam x, final Object a, final Object b);
	}

	abstract static class Op3 extends Op {
		public Op3(final String name) {
			super(name);
		}

		@Override
		public void run(final CJam x) {
			Object c = x.pop();
			Object b = x.pop();
			Object a = x.pop();
			final Object t = calc(x, a, b, c);
			if (t != null) {
				x.push(t);
			}
		}

		protected abstract Object calc(final CJam x, final Object a, final Object b, final Object c);
	}

	static class Block extends Op {
		private final List<Op> l;
		private final List<Integer> o;

		private static List<Object> parseString(final CStream cs, final StringBuilder sb) {
			final List<Object> l = new ArrayList<>();
			try {
				while (true) {
					char c = cs.get();
					sb.append(c);
					if (c == '"') {
						return l;
					}
					if (c == '\\') {
						final char c1 = cs.get();
						if (c1 == '"' || c1 == '\\') {
							sb.append(c1);
							c = c1;
						}
						else {
							cs.put(c1);
						}
					}
					l.add(c);
				}
			}
			catch (NoSuchElementException e) {
				throw new RuntimeException("Unfinished string");
			}
		}

		private static Number parseNumber(final CStream cs, final StringBuilder s2) {
			final StringBuilder sb = new StringBuilder();
			try {
				while (true) {
					final char c = cs.get();
					if (c >= '0' && c <= '9' || c == '.') {
						sb.append(c);
					}
					else if (c == '-') {
						if (sb.length() == 0) {
							sb.append(c);
						}
						else {
							cs.put(c);
							break;
						}
					}
					else {
						cs.put(c);
						break;
					}
				}
			}
			catch (NoSuchElementException e) {
				// ignore
			}
			final String s = sb.toString();
			s2.append(s.substring(1));
			try {
				return Long.parseLong(s);
			}
			catch (Exception e) {
				// ignore
			}
			try {
				return new BigInteger(s);
			}
			catch (Exception e) {
				// ignore
			}
			try {
				return Double.parseDouble(s);
			}
			catch (Exception e) {
				// ignore
			}
			throw new RuntimeException("Invalid number: " + s);
		}

		public static Block parse(final Reader r, final boolean close) {
			return parse(new CStream(r), close);
		}

		protected Block(final List<Op> l, final List<Integer> o, final String repr) {
			super(repr);
			if (l.size() != o.size()) {
				throw new IllegalArgumentException("Size mismatch");
			}
			this.l = l;
			this.o = o;
		}

		public static Block parse(final CStream cs, final boolean close) {
			final List<Op> l = new ArrayList<>();
			final List<Integer> o = new ArrayList<>();
			final StringBuilder sb = new StringBuilder();
			int off = cs.getOffset();
			if (close) {
				sb.append('{');
				off--;
			}
			while (true) {
				final char c;
				try {
					c = cs.get();
				}
				catch (NoSuchElementException e) {
					if (close) {
						throw new RuntimeException("Unfinished block");
					}
					return new Block(l, o, sb.toString());
				}
				sb.append(c);
				switch(c) {
				case ' ':
				case '\t':
				case '\n':
				case '\r':
					// skip whitespace
					break;
				case '}':
					if (close) {
						return new Block(l, o, sb.toString());
					}
					throw new RuntimeException("Unexpected }");
				case 'e':
					char c1;
					try {
						c1 = cs.peek();
					}
					catch (NoSuchElementException e) {
						throw new RuntimeException("Unfinished operator: e");
					}
					if (c1 == '#') {
						// line comment
						try {
							do {
								// eat characters
								c1 = cs.get();
								sb.append(c1);
							} while (c1 != '\n');
						}
						catch (NoSuchElementException e) {
							// eof reached, stop here
						}
						break;
					}
					// fall through
				default:
					o.add(cs.getOffset() - off - 1);
					l.add(parseOp(cs, sb, c));
				}
			}
		}

		private static Op parseOp(final CStream cs, final StringBuilder sb, final char c) {
			char c1;
			Block b;
			String s;
			Op op;
			if (c >= '0' && c <= '9') {
				cs.put(c);
				return Ops.push(parseNumber(cs, sb));
			}
			if (c >= 'A' && c <= 'Z') {
				return Ops.pushVar(c);
			}
			switch(c) {
			case '"':
				return Ops.push(parseString(cs, sb));
			case '-':
				try {
					c1 = cs.peek();
					if (c1 >= '0' && c1 <= '9' || c1 == '.') {
						cs.put(c);
						return Ops.push(parseNumber(cs, sb));
					}
				}
				catch (NoSuchElementException e) {
					// ignore
				}
				return Ops.get('-');
			case '\'':
				c1 = cs.get();
				sb.append(c1);
				return Ops.push(c1);
			case '{':
				b = parse(cs, true);
				sb.append(b.toString().substring(1));
				return Ops.push(b);
			case '}':
				throw new RuntimeException("Expected operator but found }");
			case 'e':
				c1 = cs.get();
				sb.append(c1);
				if (c1 >= '0' && c1 <= '9' || c1 == '-' || c1 == '.') {
					cs.put(c1);
					return Ops.e10(parseNumber(cs, sb));
				}
				s = new String(new char[]{c, c1});
				op = Ops.get(s);
				if (op == null) {
					throw new RuntimeException(s + " not handled");
				}
				return op;
			case 'm':
				try {
					c1 = cs.get();
				}
				catch (NoSuchElementException e) {
					throw new RuntimeException("Unfinished operator: m");
				}
				if (c1 >= '0' && c1 <= '9' || c1 == '-' || c1 == '.') {
					cs.put(c1);
					return Ops.get('-');
				}
				sb.append(c1);
				s = new String(new char[]{c, c1});
				op = Ops.get(s);
				if (op == null) {
					throw new RuntimeException(s + " not handled");
				}
				return op;
			case 'f':
				try {
					c1 = cs.get();
				}
				catch (NoSuchElementException e) {
					throw new RuntimeException("Unfinished operator: f");
				}
				sb.append(c1);
				if (c1 >= 'A' && c1 <= 'Z') {
					return Ops.forLoop(c1);
				}
				if (c1 == '{') {
					b = parse(cs, true);
					sb.append(b.toString().substring(1));
					return Ops.quickMap2(b);
				}
				op = parseOp(cs, sb, c1);
				if (op instanceof Op2) {
					return Ops.quickMap2(op);
				}
				throw new RuntimeException("Unhandled operator after f: " + op);
			case ':':
				try {
					c1 = cs.get();
				}
				catch (NoSuchElementException e) {
					throw new RuntimeException("Unfinished operator: :");
				}
				sb.append(c1);
				if (c1 >= 'A' && c1 <= 'Z') {
					return Ops.setVar(c1);
				}
				op = parseOp(cs, sb, c1);
				if (op instanceof Op1) {
					return Ops.quickMap(op);
				}
				if (op instanceof Op2) {
					return Ops.quickFold(op);
				}
				throw new RuntimeException("Unhandled operator after ':': " + op);
			case '.':
				c1 = cs.get();
				if (c1 >= '0' && c1 <= '9') {
					cs.put(c1);
					cs.put(c);
					return Ops.push(parseNumber(cs, sb));
				}
				sb.append(c1);
				if (c1 == '{') {
					b = parse(cs, true);
					sb.append(b.toString().substring(1));
					return Ops.vector(b);
				}
				op = parseOp(cs, sb, c1);
				if (op instanceof Op2) {
					return Ops.vector(op);
				}
				throw new RuntimeException("Unhandled operator after '.': " + op);
			default:
				op = Ops.get(c);
				if (op == null) {
					throw new RuntimeException(c + " not handled");
				}
				return op;
			}
		}

		@Override
		public void run(final CJam x) {
			for (int i = 0; i < l.size(); ++i) {
				try {
					l.get(i).run(x);
				}
				catch (RuntimeException e) {
					x.errln();
					int off = o.get(i);
					final int a = name.lastIndexOf('\n', off) + 1;
					int b = name.indexOf('\n', off);
					if (b < 0) {
						b = name.length();
					}
					x.errln(name.substring(a, b));
					off -= a;
					for (int j = 0; j < off; ++j) {
						x.err(name.charAt(j + a) == '\t' ? '\t' : ' ');
					}
					x.errln('^');
					throw e;
				}
			}
		}

		public List<Op> getOps() {
			return l;
		}
	}

	static class Conv {
		public static boolean isList(final Object o) {
			return o instanceof ArrayList;
		}

		public static boolean anyList(final Object a, final Object b) {
			return isList(a) || isList(b);
		}

		public static boolean bothList(final Object a, final Object b) {
			return isList(a) && isList(b);
		}

		public static List<?> toList(final Object o) {
			if (isList(o)) {
				return (List<?>) o;
			}
			final List<Object> l = new ArrayList<>();
			l.add(o);
			return l;
		}

		public static List<Object> toNewList(final Object o) {
			if (isList(o)) {
				return new ArrayList<>((List<?>) o);
			}
			final List<Object> l = new ArrayList<>();
			l.add(o);
			return l;
		}

		public static boolean isNumber(final Object o) {
			return o instanceof Number;
		}

		public static boolean anyNumber(final Object a, final Object b) {
			return isNumber(a) || isNumber(b);
		}

		public static boolean bothNumber(final Object a, final Object b) {
			return isNumber(a) && isNumber(b);
		}

		public static Number toNumber(final Object o) {
			return (Number) o;
		}

		public static boolean isLong(final Object o) {
			return o instanceof Long;
		}

		public static boolean anyLong(final Object a, final Object b) {
			return isLong(a) || isLong(b);
		}

		public static boolean bothLong(final Object a, final Object b) {
			return isLong(a) && isLong(b);
		}

		private static int error(final Object o, final String type) {
			throw new RuntimeException("Can't convert " + o.getClass().getSimpleName() + " to " + type);
		}

		public static long toLong(final Object o) {
			return isLong(o) ? (Long) o : isNumber(o) ? ((Number) o).longValue() : isString(o) ? Long.parseLong(listToStr(o))
					: isChar(o) ? (long) (Character) o : error(o, "long");
		}

		public static int toInt(final Object o) {
			return (int) toLong(o);
		}

		public static boolean isDouble(final Object o) {
			return o instanceof Double;
		}

		public static boolean anyDouble(final Object a, final Object b) {
			return isDouble(a) || isDouble(b);
		}

		public static boolean bothDouble(final Object a, final Object b) {
			return isDouble(a) && isDouble(b);
		}

		public static double toDouble(final Object o) {
			return isNumber(o) ? ((Number) o).doubleValue() : isString(o) ? Double.parseDouble(listToStr(o))
					: isChar(o) ? (double) (Character) o : error(o, "double");
		}

		public static boolean isBigint(final Object o) {
			return o instanceof BigInteger;
		}

		public static boolean anyBigint(final Object a, final Object b) {
			return isBigint(a) || isBigint(b);
		}

		public static boolean bothBigint(final Object a, final Object b) {
			return isBigint(a) && isBigint(b);
		}

		public static BigInteger toBigint(final Object o) {
			return isBigint(o) ? (BigInteger) o : isString(o) ? new BigInteger(listToStr(o)) : BigInteger.valueOf(toLong(o));
		}

		public static boolean isChar(final Object o) {
			return o instanceof Character;
		}

		public static boolean anyChar(final Object a, final Object b) {
			return isChar(a) || isChar(b);
		}

		public static boolean bothChar(final Object a, final Object b) {
			return isChar(a) && isChar(b);
		}

		public static char toChar(final Object o) {
			return isChar(o) ? (Character) o : isString(o) ? (Character) toList(o).get(0) : (char) toLong(o);
		}

		public static boolean isString(final Object o) {
			if (!isList(o)) {
				return false;
			}
			for (Object x : toList(o)) {
				if (!isChar(x)) {
					return false;
				}
			}
			return true;
		}

		public static String listToStr(final Object o) {
			final StringBuilder sb = new StringBuilder();
			for (Object x : toList(o)) {
				sb.append(x);
			}
			return sb.toString();
		}

		public static String toStr(final Object o) {
			if (isList(o)) {
				final StringBuilder sb = new StringBuilder();
				for (Object x : toList(o)) {
					sb.append(toStr(x));
				}
				return sb.toString();
			}
			return o.toString();
		}

		public static String repr(final Object o) {
			if (isDouble(o)) {
				final double d = toDouble(o);
				if (d == Double.POSITIVE_INFINITY) {
					return "1d0/";
				}
				if (d == Double.NEGATIVE_INFINITY) {
					return "-1d0/";
				}
				if (d != d) {
					return "0d0/";
				}
				return Double.toString(d).toLowerCase();
			}
			if (isNumber(o) || isBlock(o)) {
				return o.toString();
			}
			if (isChar(o)) {
				return new String(new char[]{'\'', toChar(o)});
			}
			if (isString(o)) {
				final String s = listToStr(o);
				final int n = s.length();
				final StringBuilder sb = new StringBuilder(n * 4 / 3 + 2);
				sb.append('"');
				for (int i = 0; i < n; ++i) {
					final char c = s.charAt(i);
					if (c == '"') {
						sb.append("\\\"");
					}
					else if (c == '\\') {
						if (i == n - 1) {
							sb.append("\\\\");
						}
						else {
							final char c1 = s.charAt(i + 1);
							if (c1 == '"' || c1 == '\\') {
								sb.append("\\\\");
							}
							else {
								sb.append('\\');
							}
						}
					}
					else {
						sb.append(c);
					}
				}
				return sb.append('"').toString();
			}
			if (isList(o)) {
				final StringBuilder sb = new StringBuilder("[");
				for (Object x : toList(o)) {
					sb.append(repr(x)).append(' ');
				}
				sb.setCharAt(sb.length() - 1, ']');
				return sb.toString();
			}
			throw new RuntimeException(o.getClass().getSimpleName() + " not handled");
		}

		public static List<Object> strToList(final String s) {
			final int n = s.length();
			final List<Object> l = new ArrayList<>(n);
			for (int i = 0; i < n; ++i) {
				l.add(s.charAt(i));
			}
			return l;
		}

		public static boolean isBlock(final Object o) {
			return o instanceof Block;
		}

		public static boolean anyBlock(final Object a, final Object b) {
			return isBlock(a) || isBlock(b);
		}

		public static boolean bothBlock(final Object a, final Object b) {
			return isBlock(a) && isBlock(b);
		}

		public static Block toBlock(final Object o) {
			return (Block) o;
		}

		public static boolean toBool(final Object o) {
			if (isBigint(o)) {
				return !toBigint(o).equals(BigInteger.ZERO);
			}
			if (isNumber(o)) {
				return toDouble(o) != 0;
			}
			if (isList(o)) {
				return !toList(o).isEmpty();
			}
			if (isChar(o)) {
				return toChar(o) != 0;
			}
			throw new RuntimeException(o.getClass().getSimpleName());
		}

		public static long boolVal(final boolean b) {
			return b ? 1l : 0l;
		}
	}

	static class Memo {
		private final Map<Object, Object> m = new HashMap<>();
		private final Block b;
		private final int n;

		public Memo(final Object init, final Block b, final int n) {
			this.b = b;
			this.n = n;
			set(new ArrayList<>(), init, n);
		}

		private void set(final List<Object> l, final Object o, final int n) {
			if (n == 0) {
				if (this.n == 1) {
					m.put(l.get(0), o);
				}
				else {
					m.put(new ArrayList<>(l), o);
				}
				return;
			}
			final List<?> ol = Conv.toList(o);
			for (int i = 0; i < ol.size(); ++i) {
				l.add((long) i);
				set(l, ol.get(i), n - 1);
				l.remove(l.size() - 1);
			}
		}

		public void calc(final CJam x) {
			Object o;
			List<Object> l = null;
			if (n == 1) {
				o = x.pop();
			}
			else {
				l = new ArrayList<>(n);
				for (int i = 0; i < n; ++i) {
					l.add(x.pop());
				}
				Collections.reverse(l);
				o = l;
			}
			final Object t = m.get(o);
			if (t != null) {
				x.push(t);
				return;
			}
			if (n == 1) {
				x.push(o);
			}
			else {
				for (Object a : l) {
					x.push(a);
				}
			}
			b.run(x);
			m.put(o, x.peek());
		}
	}

	static class Ops {
		private static final Op[] TABLE = new Op[128];
		private static final Map<String, Op> MAP = new HashMap<>();

		private static void add(final Op op) {
			final String s = op.toString();
			if (s.length() != 1) {
				if (MAP.put(s, op) != null) {
					throw new RuntimeException("Duplicate operator: " + s);
				}
				return;
			}
			final int x = s.charAt(0);
			if (x > 127) {
				throw new IllegalArgumentException(s);
			}
			if (TABLE[x] != null) {
				throw new RuntimeException("Duplicate operator: " + s);
			}
			TABLE[x] = op;
		}

		public static Op get(final char c) {
			if (c > 127) {
				throw new IllegalArgumentException(String.valueOf(c));
			}
			return TABLE[c];
		}

		public static Op get(final String s) {
			return s.length() == 1 ? get(s.charAt(0)) : MAP.get(s);
		}

		public static Op push(final Object o) {
			return new Op(Conv.repr(o)) {
				@Override
				public void run(final CJam x) {
					x.push(o);
				}
			};
		}

		public static Op pushVar(final char c) {
			return new Op(String.valueOf(c)) {
				@Override
				public void run(final CJam x) {
					final Object o = x.getVar(c);
					if (Conv.isBlock(o)) {
						Conv.toBlock(o).run(x);
					}
					else {
						x.push(o);
					}
				}
			};
		}

		public static Op setVar(final char c) {
			return new Op(":" + c) {
				@Override
				public void run(final CJam x) {
					x.setVar(c, x.peek());
				}
			};
		}

		public static Op quickMap(final Op op) {
			return new Op1(":" + op) {
				@Override
				public Object calc(final CJam x, final Object a) {
					if (!Conv.isList(a)) {
						throw fail(a);
					}
					final List<?> al = Conv.toList(a);
					x.mark();
					for (Object o : al) {
						x.push(o);
						op.run(x);
					}
					x.popMark();
					return null;
				}
			};
		}

		public static Op quickFold(final Op op) {
			return new Op1(":" + op) {
				@Override
				public Object calc(final CJam x, final Object a) {
					if (!Conv.isList(a)) {
						throw fail(a);
					}
					final List<?> al = Conv.toList(a);
					final int n = al.size();
					x.push(al.get(0));
					for (int i = 1; i < n; ++i) {
						x.push(al.get(i));
						op.run(x);
					}
					return null;
				}
			};
		}

		public static Op quickMap2(final Op op) {
			return new Op2("f" + op) {
				@Override
				public Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.isList(a)) {
						final List<?> al = Conv.toList(a);
						x.mark();
						for (Object o : al) {
							x.push(o);
							x.push(b);
							op.run(x);
						}
						x.popMark();
						return null;
					}
					if (Conv.isList(b)) {
						final List<?> bl = Conv.toList(b);
						x.mark();
						for (Object o : bl) {
							x.push(a);
							x.push(o);
							op.run(x);
						}
						x.popMark();
						return null;
					}
					throw fail(a, b);
				}
			};
		}

		public static Op forLoop(final char c) {
			return new Op2("f" + c) {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.isBlock(b)) {
						final Block bb = Conv.toBlock(b);
						if (Conv.isNumber(a)) {
							final long al = Conv.toLong(a);
							for (long i = 0; i < al; ++i) {
								x.setVar(c, i);
								bb.run(x);
							}
							return null;
						}
						if (Conv.isList(a)) {
							final List<?> al = Conv.toList(a);
							for (Object i : al) {
								x.setVar(c, i);
								bb.run(x);
							}
							return null;
						}
					}
					else if (Conv.isBlock(a)) {
						return calc(x, b, a);
					}
					throw fail(a, b);
				}
			};
		}

		public static Op vector(final Op op) {
			return new Op2("." + op) {
				@Override
				public Object calc(final CJam x, final Object a, final Object b) {
					if (!Conv.bothList(a, b)) {
						throw fail(a, b);
					}
					final List<?> al = Conv.toList(a);
					final int an = al.size();
					final List<?> bl = Conv.toList(b);
					final int bn = bl.size();
					final int n = Math.max(an, bn);
					x.mark();
					for (int i = 0; i < n; ++i) {
						if (i < an) {
							x.push(al.get(i));
							if (i < bn) {
								x.push(bl.get(i));
								op.run(x);
							}
						}
						else {
							x.push(bl.get(i));
						}
					}
					x.popMark();
					return null;
				}
			};
		}

		public static Op e10(final Number exp) {
			return new Op1("e" + exp) {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isNumber(a)) {
						throw fail(a);
					}
					if (Conv.isDouble(exp)) {
						return Conv.toDouble(a) * Math.pow(10, exp.doubleValue());
					}
					if (!Conv.isLong(exp)) {
						throw fail(a);
					}
					final long bl = exp.longValue();
					if (Conv.isDouble(a) || bl < 0) {
						return Double.parseDouble(a + "e" + bl);
					}
					return adjustInt(Conv.toBigint(a).multiply(BigInteger.TEN.pow((int) bl)));
				}
			};
		}

		protected static Object adjustInt(final BigInteger x) {
			return x.bitLength() < 64 ? x.longValue() : x;
		}

		protected static final int compareLists(final List<?> a, final List<?> b) {
			final int an = a.size();
			final int bn = b.size();
			final int n = Math.min(an, bn);
			for (int i = 0; i < n; ++i) {
				final int x = compare(a.get(i), b.get(i));
				if (x != 0) {
					return x;
				}
			}
			return an - bn;
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		protected static final int compare(final Object a, final Object b) {
			if (Conv.bothList(a, b)) {
				return compareLists(Conv.toList(a), Conv.toList(b));
			}
			if (a.getClass() == b.getClass()) {
				return ((Comparable) a).compareTo(b);
			}
			if (Conv.bothNumber(a, b)) {
				if (Conv.anyDouble(a, b)) {
					return Double.compare(Conv.toDouble(a), Conv.toDouble(b));
				}
				return Conv.toBigint(a).compareTo(Conv.toBigint(b));
			}
			if (Conv.anyChar(a, b) && Conv.anyNumber(a, b)) {
				return ((Long) Conv.toLong(a)).compareTo(Conv.toLong(b));
			}
			throw new IllegalArgumentException("Can't compare " + a.getClass().getSimpleName()
					+ " with " + b.getClass().getSimpleName());
		}

		protected static final Comparator<Object> COMP = new Comparator<Object>() {
			@Override
			public int compare(final Object o1, final Object o2) {
				return Ops.compare(o1, o2);
			}
		};

		protected static final Comparator<Object[]> COMP2 = new Comparator<Object[]>() {
			@Override
			public int compare(final Object[] o1, final Object[] o2) {
				return Ops.compare(o1[1], o2[1]);
			}
		};

		private static List<Integer> preproc(final List<?> l) {
			final List<Integer> p = new ArrayList<>();
			final int subl = l.size();
			p.add(-1);
			for (int i = 1, n = 0; i < subl; i++, n++) {
				if (l.get(i).equals(l.get(n))) {
					p.add(p.get(n));
				}
				else {
					p.add(n);
					do {
						n = p.get(n);
					} while (n >= 0 && !l.get(i).equals(l.get(n)));
				}
			}
			return p;
		}

		protected static int find(final List<?> s, final List<?> sub) {
			final List<Integer> p = preproc(sub);
			final int sl = s.size();
			final int max = sub.size() - 1;

			for (int i = 0, m = 0; i < sl; i++, m++) {
				while (m >= 0 && !sub.get(m).equals(s.get(i))) {
					m = p.get(m);
				}
				if (m == max) {
					return i - m;
				}
			}
			return -1;
		}

		protected static List<?> split(final List<?> s, final List<?> sub, final boolean empty) {
			final List<Integer> p = preproc(sub);
			final int sl = s.size();
			final int max = sub.size() - 1;

			final List<Object> l = new ArrayList<>();
			int x = 0;
			for (int i = 0, m = 0; i < sl; i++, m++) {
				while (m >= 0 && !sub.get(m).equals(s.get(i))) {
					m = p.get(m);
				}
				if (m == max) {
					final List<?> t = s.subList(x, i - m);
					if (empty || !t.isEmpty()) {
						l.add(new ArrayList<Object>(t));
					}
					x = i + 1;
					m = -1;
				}
			}
			final List<?> t = s.subList(x, s.size());
			if (empty || !t.isEmpty()) {
				l.add(new ArrayList<Object>(t));
			}
			return l;
		}

		protected static List<Object> pair(final Object x, final Object y) {
			final List<Object> l = new ArrayList<>(2);
			l.add(x);
			l.add(y);
			return l;
		}

		protected static int adjustIndexMod(final Object x, final int n) {
			if (!(x instanceof Long)) {
				throw new IllegalArgumentException(x.getClass().getSimpleName() + " can't be an index");
			}
			int y = (int) ((Long) x % n);
			if (y < 0) {
				y += n;
			}
			return y;
		}

		protected static int adjustIndex(final Object x, final int n) {
			if (!(x instanceof Long)) {
				throw new IllegalArgumentException(x.getClass().getSimpleName() + " can't be an index");
			}
			int y = ((Long) x).intValue();
			if (y < 0) {
				y += n;
				if (y < 0) {
					y = 0;
				}
			}
			else if (y > n) {
				y = n;
			}
			return y;
		}

		static {
			add(new Op2("+") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.anyList(a, b) || Conv.bothChar(a, b)) {
						final List<Object> l = Conv.toNewList(a);
						l.addAll(Conv.toList(b));
						return l;
					}
					if (Conv.bothNumber(a, b)) {
						if (Conv.anyDouble(a, b)) {
							return Conv.toDouble(a) + Conv.toDouble(b);
						}
						if (Conv.bothLong(a, b)) {
							final long al = Conv.toLong(a);
							final long bl = Conv.toLong(b);
							final long r = al + bl;
							if ((al ^ bl) < 0 || (al ^ r) >= 0) {
								return r;
							}
						}
						return adjustInt(Conv.toBigint(a).add(Conv.toBigint(b)));
					}
					if (Conv.anyChar(a, b) && Conv.anyNumber(a, b)) {
						return (char) (Conv.toLong(a) + Conv.toLong(b));
					}
					throw fail(a, b);
				}
			});

			add(new Op2("-") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.bothChar(a, b)) {
						return Conv.toLong(a) - Conv.toLong(b);
					}
					if (Conv.bothNumber(a, b)) {
						if (Conv.anyDouble(a, b)) {
							return Conv.toDouble(a) - Conv.toDouble(b);
						}
						if (Conv.bothLong(a, b)) {
							final long al = Conv.toLong(a);
							final long bl = Conv.toLong(b);
							final long r = al - bl;
							if ((al ^ bl) >= 0 || (al ^ r) >= 0) {
								return r;
							}
						}
						return adjustInt(Conv.toBigint(a).subtract(Conv.toBigint(b)));
					}
					if (Conv.isChar(a) && Conv.isNumber(b)) {
						return (char) (Conv.toLong(a) - Conv.toLong(b));
					}
					if (Conv.anyList(a, b)) {
						if (Conv.anyBlock(a, b)) {
							throw fail(a, b); // maybe do something different with blocks later
						}
						final List<Object> l = Conv.toNewList(a);
						l.removeAll(Conv.toList(b));
						return l;
					}
					throw fail(a, b);
				}
			});

			add(new Op2("*") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.isNumber(a) && (Conv.isList(b) || Conv.isChar(b) || Conv.isBlock(b))) {
						return calc(x, b, a);
					}
					if ((Conv.isBlock(a) || Conv.isChar(a)) && Conv.isList(b)) {
						return calc(x, b, a);
					}
					if ((Conv.isList(a) || Conv.isChar(a)) && Conv.isNumber(b)) {
						final List<?> al = Conv.toList(a);
						final int n = Conv.toInt(b);
						final int m = al.size();
						final int t = n * m;
						if (t == 0) {
							return new ArrayList<>(0);
						}
						final Object[] a1 = al.toArray();
						final Object[] a2 = new Object[t];
						System.arraycopy(a1, 0, a2, 0, m);
						int i = m;
						while (i * 2 <= t) {
							System.arraycopy(a2, 0, a2, i, i);
							i *= 2;
						}
						if (i < t) {
							System.arraycopy(a2, 0, a2, i, t - i);
						}
						return new ArrayList<>(Arrays.asList(a2));
					}
					if (Conv.bothNumber(a, b)) {
						if (Conv.anyDouble(a, b)) {
							return Conv.toDouble(a) * Conv.toDouble(b);
						}
						if (Conv.bothLong(a, b)) {
							final long al = Conv.toLong(a);
							final long bl = Conv.toLong(b);
							if (al == 0 || bl == 0) {
								return 0l;
							}
							final long r = al * bl;
							if (r / al == bl && (al ^ bl ^ r) >= 0) {
								return r;
							}
						}
						return adjustInt(Conv.toBigint(a).multiply(Conv.toBigint(b)));
					}
					if (Conv.isBlock(a) && Conv.isNumber(b)) {
						final Block ab = Conv.toBlock(a);
						final int n = Conv.toInt(b);
						for (int i = 0; i < n; ++i) {
							ab.run(x);
						}
						return null;
					}
					if (Conv.isList(a)) {
						final List<?> al = Conv.toList(a);
						final int n = al.size();
						if (Conv.isBlock(b)) {
							final Block bb = Conv.toBlock(b);
							x.push(al.get(0));
							for (int i = 1; i < n; ++i) {
								x.push(al.get(i));
								bb.run(x);
							}
							return null;
						}
						if (Conv.isList(b) || Conv.isChar(b)) {
							final List<?> bl = Conv.toList(b);
							final List<Object> l = new ArrayList<>(n + (n == 0 ? 0 : (n - 1) * bl.size()));
							for (int i = 0; i < n; ++i) {
								if (i > 0) {
									l.addAll(bl);
								}
								final Object o = al.get(i);
								if (Conv.isList(o)) {
									l.addAll(Conv.toList(o));
								}
								else {
									l.add(o);
								}
							}
							return l;
						}
					}
					throw fail(a, b);
				}
			});

			add(new Op2("/") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.isBlock(a)) {
						if (Conv.isBlock(b)) {
							throw fail(a, b);
						}
						return calc(x, b, a);
					}
					if (Conv.isNumber(a)) {
						if (Conv.isList(b)) {
							return calc(x, b, a);
						}
						if (Conv.isNumber(b)) {
							if (Conv.anyDouble(a, b)) {
								return Conv.toDouble(a) / Conv.toDouble(b);
							}
							if (Conv.bothLong(a, b)) {
								final long al = Conv.toLong(a);
								final long bl = Conv.toLong(b);
								if (al != Long.MIN_VALUE || bl != -1) {
									return al / bl;
								}
							}
							return adjustInt(Conv.toBigint(a).divide(Conv.toBigint(b)));
						}
						if (Conv.isBlock(b)) {
							final Block bb = Conv.toBlock(b);
							final long al = Conv.toLong(a);
							for (long i = 0; i < al; ++i) {
								x.push(i);
								bb.run(x);
							}
							return null;
						}
					}
					if (Conv.isList(a)) {
						final List<?> al = Conv.toList(a);
						if (Conv.isBlock(b)) {
							final Block bb = Conv.toBlock(b);
							for (Object o : al) {
								x.push(o);
								bb.run(x);
							}
							return null;
						}
						if (Conv.isList(b) || Conv.isChar(b)) {
							return split(al, Conv.toList(b), true);
						}
						if (Conv.isNumber(b)) {
							final int n = Conv.toInt(b);
							if (n <= 0) {
								throw new RuntimeException("Invalid size for splitting");
							}
							final int m = al.size();
							final List<Object> l = new ArrayList<>((m + n - 1) / n);
							for (int i = 0; i < m; i += n) {
								l.add(new ArrayList<Object>(al.subList(i, Math.min(i + n, m))));
							}
							return l;
						}
					}
					throw fail(a, b);
				}
			});

			add(new Op2("%") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.isBlock(a)) {
						if (Conv.isBlock(b)) {
							throw fail(a, b);
						}
						return calc(x, b, a);
					}
					if (Conv.isNumber(a)) {
						if (Conv.isList(b)) {
							return calc(x, b, a);
						}
						if (Conv.isNumber(b)) {
							if (Conv.anyDouble(a, b)) {
								return Conv.toDouble(a) % Conv.toDouble(b);
							}
							if (Conv.bothLong(a, b)) {
								return Conv.toLong(a) % Conv.toLong(b);
							}
							return adjustInt(Conv.toBigint(a).mod(Conv.toBigint(b)));
						}
						if (Conv.isBlock(b)) {
							final Block bb = Conv.toBlock(b);
							final long al = Conv.toLong(a);
							x.mark();
							for (long i = 0; i < al; ++i) {
								x.push(i);
								bb.run(x);
							}
							x.popMark();
							return null;
						}
					}
					if (Conv.isList(a)) {
						final List<?> al = Conv.toList(a);
						if (Conv.isNumber(b)) {
							final int n = al.size();
							int bi = Conv.toInt(b);
							boolean rev = false;
							if (bi < 0) {
								rev = true;
								bi = -bi;
							}
							final List<Object> l = new ArrayList<>(n / bi + 1);
							for (int i = 0; i < n; i += bi) {
								l.add(al.get(rev ? n - 1 - i : i));
							}
							return l;
						}
						if (Conv.isBlock(b)) {
							final Block bb = Conv.toBlock(b);
							x.mark();
							for (Object o : al) {
								x.push(o);
								bb.run(x);
							}
							x.popMark();
							return null;
						}
						if (Conv.isList(b) || Conv.isChar(b)) {
							return split(al, Conv.toList(b), false);
						}
					}
					throw fail(a, b);
				}
			});

			add(new Op1("_") {
				@Override
				public void run(final CJam x) {
					x.push(x.peek());
				}

				@Override
				protected Object calc(final CJam x, final Object a) {
					// dummy, just needed to extend Op1
					return null;
				}
			});

			add(new Op1(";") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					return null;
				}
			});

			add(new Op2("\\") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					x.push(b);
					return a;
				}
			});

			add(new Op("@") {
				@Override
				public void run(final CJam x) {
					final Object a = x.pop();
					final Object b = x.pop();
					final Object c = x.pop();
					x.push(b);
					x.push(a);
					x.push(c);
				}
			});

			add(new Op1("i") {
				@Override
				public Object calc(final CJam x, final Object a) {
					if (Conv.isBigint(a)) {
						return adjustInt(Conv.toBigint(a));
					}
					if (Conv.isString(a)) {
						final String s = Conv.listToStr(a);
						return s.length() < 19 ? Long.parseLong(s) : adjustInt(new BigInteger(s));
					}
					if (Conv.isDouble(a)) {
						final double ad = Conv.toDouble(a);
						final double max = 9.223372e18;
						if (ad > max || ad < -max) {
							return adjustInt(BigDecimal.valueOf(ad).toBigInteger());
						}
					}
					return Conv.toLong(a);
				}
			});

			add(new Op1("d") {
				@Override
				public Object calc(final CJam x, final Object a) {
					return Conv.toDouble(a);
				}
			});

			add(new Op1("c") {
				@Override
				public Object calc(final CJam x, final Object a) {
					return Conv.toChar(a);
				}
			});

			add(new Op1("a") {
				@Override
				public Object calc(final CJam x, final Object a) {
					final List<Object> l = new ArrayList<>(1);
					l.add(a);
					return l;
				}
			});

			add(new Op1("s") {
				@Override
				public Object calc(final CJam x, final Object a) {
					return Conv.strToList(Conv.toStr(a));
				}
			});

			add(new Op2("=") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (a.getClass() == b.getClass()) {
						return Conv.boolVal(a.equals(b));
					}
					if (!Conv.isList(a) && Conv.isList(b)) {
						return calc(x, b, a);
					}
					if (Conv.isList(a)) {
						final List<?> al = Conv.toList(a);
						if (Conv.isNumber(b)) {
							final int bi = adjustIndexMod(b, al.size());
							return al.get(bi);
						}
						if (Conv.isBlock(b)) {
							final Block bb = Conv.toBlock(b);
							for (int i = 0; i < al.size(); ++i) {
								x.push(al.get(i));
								bb.run(x);
								if (Conv.toBool(x.pop())) {
									return al.get(i);
								}
							}
							return null;
						}
						throw fail(a, b);
					}
					if (Conv.bothNumber(a, b)) {
						if (Conv.anyDouble(a, b)) {
							return Conv.boolVal(Conv.toDouble(a) == Conv.toDouble(b));
						}
						return Conv.boolVal(Conv.toBigint(a).equals(Conv.toBigint(b)));
					}
					if (Conv.anyChar(a, b) && Conv.anyNumber(a, b)) {
						return Conv.boolVal(Conv.toLong(a) == Conv.toLong(b));
					}
					throw fail(a, b);
				}
			});

			add(new Op2("<") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.isNumber(a) && Conv.isList(b)) {
						return calc(x, b, a);
					}
					if (Conv.isList(a) && Conv.isNumber(b)) {
						final List<?> al = Conv.toList(a);
						final int bi = adjustIndex(b, al.size());
						return new ArrayList<Object>(al.subList(0, bi));
					}
					return Conv.boolVal(compare(a, b) < 0);
				}
			});

			add(new Op2(">") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.isNumber(a) && Conv.isList(b)) {
						return calc(x, b, a);
					}
					if (Conv.isList(a) && Conv.isNumber(b)) {
						final List<?> al = Conv.toList(a);
						final int n = al.size();
						final int bi = adjustIndex(b, n);
						return new ArrayList<Object>(al.subList(bi, n));
					}
					return Conv.boolVal(compare(a, b) > 0);
				}
			});

			add(new Op1("g") {
//				private final Pattern charsetPattern = Pattern.compile(";\\s*CHARSET\\s*=\\s*(\\S+)");
//				private final char[] buf = new char[4096];

				@Override
				protected Object calc(final CJam x, final Object a) {
					if (Conv.isBlock(a)) {
						final Block ab = Conv.toBlock(a);
						do {
							ab.run(x);
						} while (Conv.toBool(x.pop()));
						return null;
					}
					if (Conv.isNumber(a)) {
						if (Conv.isDouble(a)) {
							return (long) Math.signum(Conv.toDouble(a));
						}
						if (Conv.isLong(a)) {
							return (long) Long.signum(Conv.toLong(a));
						}
						return (long) Conv.toBigint(a).signum();
					}
					// disabling url get
//					if (!Conv.isString(a)) {
						throw fail(a);
//					}
//					String as = Conv.listToStr(a);
//					if (!as.contains("://")) {
//						as = "http://" + as;
//					}
//					try {
//						final URLConnection conn = new URL(as).openConnection();
//						final String ctype = conn.getContentType();
//						final String charset;
//						if (ctype == null) {
//							charset = "UTF-8";
//						}
//						else {
//							final Matcher m = charsetPattern.matcher(ctype.toUpperCase());
//							charset = m.find() ? m.group(1) : "UTF-8";
//						}
//						@SuppressWarnings("resource")
//						final Reader r = new InputStreamReader(conn.getInputStream(), charset);
//						final StringBuilder sb = new StringBuilder();
//						while (true) {
//							final int n = r.read(buf);
//							if (n < 0) {
//								break;
//							}
//							sb.append(buf, 0, n);
//						}
//						r.close();
//						return Conv.strToList(sb.toString());
//					}
//					catch (IOException e) {
//						throw new RuntimeException(e);
//					}
				}
			});

			add(new Op1("h") {
				@Override
				public Object calc(final CJam x, final Object a) {
					if (!Conv.isBlock(a)) {
						throw fail(a);
					}
					final Block ab = Conv.toBlock(a);
					do {
						ab.run(x);
					} while (Conv.toBool(x.peek()));
					return null;
				}
			});

			add(new Op2("w") {
				@Override
				public Object calc(final CJam x, final Object a, final Object b) {
					if (!Conv.bothBlock(a, b)) {
						throw fail(a, b);
					}
					final Block ab = Conv.toBlock(a);
					final Block bb = Conv.toBlock(b);
					while (true) {
						ab.run(x);
						if (!Conv.toBool(x.pop())) {
							break;
						}
						bb.run(x);
					}
					return null;
				}
			});

			add(new Op3("?") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b, final Object c) {
					final Object o = Conv.toBool(a) ? b : c;
					if (Conv.isBlock(o)) {
						Conv.toBlock(o).run(x);
						return null;
					}
					return o;
				}
			});

			add(new Op2("#") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.bothNumber(a, b)) {
						if (Conv.anyDouble(a, b) || Conv.toLong(b) < 0) {
							return Math.pow(Conv.toDouble(a), Conv.toDouble(b));
						}
						return adjustInt(Conv.toBigint(a).pow(Conv.toInt(b)));
					}
					if (Conv.isList(a)) {
						final List<?> al = Conv.toList(a);
						if (Conv.isBlock(b)) {
							final Block bb = Conv.toBlock(b);
							for (int i = 0; i < al.size(); ++i) {
								x.push(al.get(i));
								bb.run(x);
								if (Conv.toBool(x.pop())) {
									return (long) i;
								}
							}
							return -1l;
						}
						final int pos = Conv.isList(b) ? find(al, Conv.toList(b)) : al.indexOf(b);
						return (long) pos;
					}
					if (Conv.isList(b)) {
						if (Conv.isBlock(a)) {
							return calc(x, b, a);
						}
						return (long) Conv.toList(b).indexOf(a);
					}
					throw fail(a, b);
				}
			});

			add(new Op1(",") {
				@Override
				public Object calc(final CJam x, final Object a) {
					if (Conv.isNumber(a)) {
						final int n = Conv.toInt(a);
						final List<Object> l = new ArrayList<>(n);
						for (long i = 0; i < n; ++i) {
							l.add(i);
						}
						return l;
					}
					if (Conv.isChar(a)) {
						final char ac = Conv.toChar(a);
						final List<Object> l = new ArrayList<>(ac);
						for (char i = 0; i < ac; ++i) {
							l.add(i);
						}
						return l;
					}
					if (Conv.isList(a)) {
						return (long) Conv.toList(a).size();
					}
					if (Conv.isBlock(a)) {
						final Block ab = Conv.toBlock(a);
						final Object b = x.pop();
						if (Conv.isList(b)) {
							final List<?> bl = Conv.toList(b);
							final List<Object> l = new ArrayList<>();
							for (Object o : bl) {
								x.push(o);
								ab.run(x);
								if (Conv.toBool(x.pop())) {
									l.add(o);
								}
							}
							return l;
						}
						if (Conv.isNumber(b)) {
							final long bl = Conv.toLong(b);
							final List<Object> l = new ArrayList<>();
							for (long i = 0; i < bl; ++i) {
								x.push(i);
								ab.run(x);
								if (Conv.toBool(x.pop())) {
									l.add(i);
								}
							}
							return l;
						}
						throw fail(b, a);
					}
					throw fail(a);
				}
			});

			add(new Op1("!") {
				@Override
				public Object calc(final CJam x, final Object a) {
					return Conv.boolVal(!Conv.toBool(a));
				}
			});

			add(new Op1("(") {
				@Override
				public Object calc(final CJam x, final Object a) {
					if (Conv.isNumber(a)) {
						if (Conv.isDouble(a)) {
							return Conv.toDouble(a) - 1;
						}
						if (Conv.isLong(a)) {
							if (!a.equals(Long.MIN_VALUE)) {
								return Conv.toLong(a) - 1;
							}
						}
						return adjustInt(Conv.toBigint(a).subtract(BigInteger.ONE));
					}
					if (Conv.isChar(a)) {
						return (char) (Conv.toChar(a) - 1);
					}
					if (Conv.isList(a)) {
						final List<Object> l = Conv.toNewList(a);
						final Object o = l.remove(0);
						x.push(l);
						return o;
					}
					throw fail(a);
				}
			});

			add(new Op1(")") {
				@Override
				public Object calc(final CJam x, final Object a) {
					if (Conv.isNumber(a)) {
						if (Conv.isDouble(a)) {
							return Conv.toDouble(a) + 1;
						}
						if (Conv.isLong(a)) {
							if (!a.equals(Long.MAX_VALUE)) {
								return Conv.toLong(a) + 1;
							}
						}
						return adjustInt(Conv.toBigint(a).add(BigInteger.ONE));
					}
					if (Conv.isChar(a)) {
						return (char) (Conv.toChar(a) + 1);
					}
					if (Conv.isList(a)) {
						final List<Object> l = Conv.toNewList(a);
						final Object o = l.remove(l.size() - 1);
						x.push(l);
						return o;
					}
					throw fail(a);
				}
			});

			add(new Op1("$") {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				@Override
				public Object calc(final CJam x, final Object a) {
					if (Conv.isNumber(a)) {
						return x.get(Conv.toInt(a));
					}
					if (Conv.isList(a)) {
						final List l = Conv.toNewList(a);
						Collections.sort(l, COMP);
						return l;
					}
					if (Conv.isBlock(a)) {
						final Object b = x.pop();
						if (!Conv.isList(b)) {
							throw fail(b, a);
						}
						final Block ab = Conv.toBlock(a);
						final List<?> bl = Conv.toList(b);
						final List<Object[]> l = new ArrayList<>(bl.size());
						for (Object i : bl) {
							x.push(i);
							ab.run(x);
							final Object j = x.pop();
							l.add(new Object[]{i, j});
						}
						Collections.sort(l, COMP2);
						final List<Object> r = new ArrayList<>(l.size());
						for (Object[] t : l) {
							r.add(t[0]);
						}
						return r;
					}
					throw fail(a);
				}
			});

			add(new Op2("&") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.bothNumber(a, b)) {
						if (Conv.anyDouble(a, b)) {
							throw fail(a, b);
						}
						if (Conv.bothLong(a, b)) {
							return Conv.toLong(a) & Conv.toLong(b);
						}
						return adjustInt(Conv.toBigint(a).and(Conv.toBigint(b)));
					}
					if (Conv.isBlock(a)) {
						throw fail(a, b);
					}
					if (Conv.isBlock(b)) {
						if (Conv.toBool(a)) {
							Conv.toBlock(b).run(x);
						}
						return null;
					}
					if (Conv.anyList(a, b)) {
						final Set<Object> s = new LinkedHashSet<>(Conv.toList(a));
						s.retainAll(Conv.toList(b));
						return new ArrayList<>(s);
					}
					if (Conv.anyChar(a, b) && Conv.anyLong(a, b)) {
						return (char) (Conv.toLong(a) & Conv.toLong(b));
					}
					throw fail(a, b);
				}
			});

			add(new Op2("|") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.bothNumber(a, b)) {
						if (Conv.anyDouble(a, b)) {
							throw fail(a, b);
						}
						if (Conv.bothLong(a, b)) {
							return Conv.toLong(a) | Conv.toLong(b);
						}
						return adjustInt(Conv.toBigint(a).or(Conv.toBigint(b)));
					}
					if (Conv.isBlock(a)) {
						throw fail(a, b);
					}
					if (Conv.isBlock(b)) {
						if (!Conv.toBool(a)) {
							Conv.toBlock(b).run(x);
						}
						return null;
					}
					if (Conv.anyList(a, b)) {
						final Set<Object> s = new LinkedHashSet<>(Conv.toList(a));
						s.addAll(Conv.toList(b));
						return new ArrayList<>(s);
					}
					if (Conv.anyChar(a, b) && Conv.anyLong(a, b)) {
						return (char) (Conv.toLong(a) | Conv.toLong(b));
					}
					throw fail(a, b);
				}
			});

			add(new Op2("^") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.bothNumber(a, b)) {
						if (Conv.anyDouble(a, b)) {
							throw fail(a, b);
						}
						if (Conv.bothLong(a, b)) {
							return Conv.toLong(a) ^ Conv.toLong(b);
						}
						return adjustInt(Conv.toBigint(a).xor(Conv.toBigint(b)));
					}
					if (Conv.anyList(a, b)) {
						if (Conv.anyBlock(a, b)) {
							throw fail(a, b); // maybe do something different with blocks later
						}
						final Set<Object> s = new LinkedHashSet<>(Conv.toList(a));
						s.removeAll(Conv.toList(b));
						final Set<Object> s2 = new LinkedHashSet<>(Conv.toList(b));
						s2.removeAll(Conv.toList(a));
						s.addAll(s2);
						return new ArrayList<>(s);
					}
					if (Conv.bothChar(a, b)) {
						return Conv.toLong(a) ^ Conv.toLong(b);
					}
					if (Conv.anyChar(a, b) && Conv.anyLong(a, b)) {
						return (char) (Conv.toLong(a) ^ Conv.toLong(b));
					}
					throw fail(a, b);
				}
			});

			add(new Op("r") {
				@Override
				public void run(final CJam x) {
					x.push(Conv.strToList(x.readNext()));
				}
			});

			add(new Op("l") {
				@Override
				public void run(final CJam x) {
					x.push(Conv.strToList(x.readLine()));
				}
			});

			add(new Op("q") {
				@Override
				public void run(final CJam x) {
					x.push(Conv.strToList(x.readAll()));
				}
			});

			add(new Op1("~") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (Conv.isNumber(a)) {
						if (Conv.isDouble(a)) {
							throw fail(a);
						}
						if (Conv.isLong(a)) {
							return ~Conv.toLong(a);
						}
						return adjustInt(Conv.toBigint(a).not());
					}
					if (Conv.isBlock(a)) {
						Conv.toBlock(a).run(x);
						return null;
					}
					if (Conv.isString(a) || Conv.isChar(a)) {
						Block.parse(new StringReader(Conv.toStr(a)), false).run(x);
						return null;
					}
					if (Conv.isList(a)) {
						for (Object o : Conv.toList(a)) {
							x.push(o);
						}
						return null;
					}
					throw fail(a);
				}
			});

			add(new Op3("t") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b, final Object c) {
					if (Conv.isNumber(a) && Conv.isList(b)) {
						return calc(x, b, a, c);
					}
					if (Conv.isList(a) && Conv.isNumber(b)) {
						final List<Object> al = Conv.toNewList(a);
						final int bi = adjustIndexMod(b, al.size());
						al.set(bi, c);
						return al;
					}
					throw fail(a, b, c);
				}
			});

			add(new Op2("b") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.isNumber(a) && Conv.isList(b)) {
						return calc(x, b, a);
					}
					if (!Conv.isNumber(b) || Conv.anyDouble(a, b)) {
						throw fail(a, b);
					}
					if (Conv.isNumber(a)) {
						final List<Object> l = new ArrayList<>();
						if (Conv.anyBigint(a, b)) {
							BigInteger ab = Conv.toBigint(a).abs();
							final BigInteger bb = Conv.toBigint(b).abs();
							while (!ab.equals(BigInteger.ZERO)) {
								final BigInteger[] d = ab.divideAndRemainder(bb);
								l.add(adjustInt(d[1]));
								ab = d[0];
							}
						}
						else {
							long al = Math.abs(Conv.toLong(a));
							final long bl = Math.abs(Conv.toLong(b));
							if (bl == 1) {
								l.addAll(Collections.nCopies((int) al, 1l));
							}
							else {
								while (al != 0) {
									l.add(al % bl);
									al /= bl;
								}
							}
						}
						if (l.isEmpty()) {
							l.add(0l);
						}
						Collections.reverse(l);
						return l;
					}
					if (Conv.isList(a)) {
						final List<?> al = Conv.toList(a);
						final BigInteger bb = Conv.toBigint(b).abs();
						BigInteger t = BigInteger.ZERO;
						for (Object o : al) {
							t = t.multiply(bb).add(Conv.toBigint(o));
						}
						return adjustInt(t);
					}
					throw fail(a, b);
				}
			});

			add(new Op("[") {
				@Override
				public void run(final CJam x) {
					x.mark();
				}
			});

			add(new Op("]") {
				@Override
				public void run(final CJam x) {
					x.popMark();
				}
			});

			add(new Op1("`") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					return Conv.strToList(Conv.repr(a));
				}
			});

			add(new Op1("p") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					x.println(Conv.repr(a));
					return null;
				}
			});

			add(new Op1("o") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					x.print(Conv.toStr(a));
					return null;
				}
			});

			add(new Op1("n") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					x.println(Conv.toStr(a));
					return null;
				}
			});

			add(new Op("ed") {
				@Override
				public void run(final CJam x) {
					x.show();
				}
			});

			add(new Op2("e<") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					return compare(a, b) < 0 ? a : b;
				}
			});

			add(new Op2("e>") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					return compare(a, b) > 0 ? a : b;
				}
			});

			add(new Op1("eu") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (Conv.isChar(a)) {
						return Character.toUpperCase(Conv.toChar(a));
					}
					if (Conv.isString(a)) {
						return Conv.strToList(Conv.listToStr(a).toUpperCase());
					}
					throw fail(a);
				}
			});

			add(new Op1("el") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (Conv.isChar(a)) {
						return Character.toLowerCase(Conv.toChar(a));
					}
					if (Conv.isString(a)) {
						return Conv.strToList(Conv.listToStr(a).toLowerCase());
					}
					throw fail(a);
				}
			});

			add(new Op2("e&") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					final Object o = Conv.toBool(a) ? b : a;
					if (Conv.isBlock(o)) {
						Conv.toBlock(o).run(x);
						return null;
					}
					return o;
				}
			});

			add(new Op2("e|") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					final Object o = Conv.toBool(a) ? a : b;
					if (Conv.isBlock(o)) {
						Conv.toBlock(o).run(x);
						return null;
					}
					return o;
				}
			});

			add(new Op2("m<") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.isNumber(b)) {
						long bl = Conv.toLong(b);
						if (bl < 0) {
							return ((Op2) get("m>")).calc(x, a, -bl);
						}
						if (Conv.isNumber(a)) {
							if (Conv.isDouble(a)) {
								return Conv.toDouble(a) * (1 << bl);
							}
							return adjustInt(Conv.toBigint(a).shiftLeft((int) bl));
						}
						if (Conv.isList(a)) {
							final List<?> al = Conv.toList(a);
							final int n = al.size();
							if (n < 2) {
								return al;
							}
							final int k = (int) (bl % n);
							if (k == 0) {
								return al;
							}
							final List<Object> l = new ArrayList<>(n);
							l.addAll(al.subList(k, n));
							l.addAll(al.subList(0, k));
							return l;
						}
					}
					if (Conv.isNumber(a) && Conv.isList(b)) {
						return calc(x, b, a);
					}
					throw fail(a);
				}
			});

			add(new Op2("m>") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.isNumber(b)) {
						long bl = Conv.toLong(b);
						if (bl < 0) {
							return ((Op2) get("m<")).calc(x, a, -bl);
						}
						if (Conv.isNumber(a)) {
							if (Conv.isDouble(a)) {
								return Conv.toDouble(a) / (1 << bl);
							}
							return adjustInt(Conv.toBigint(a).shiftRight((int) bl));
						}
						if (Conv.isList(a)) {
							final List<?> al = Conv.toList(a);
							final int n = al.size();
							if (n < 2) {
								return al;
							}
							final int k = (int) (bl % n);
							if (k == 0) {
								return al;
							}
							final List<Object> l = new ArrayList<>(n);
							l.addAll(al.subList(n - k, n));
							l.addAll(al.subList(0, n - k));
							return l;
						}
					}
					if (Conv.isNumber(a) && Conv.isList(b)) {
						return calc(x, b, a);
					}
					throw fail(a);
				}
			});

			add(new Op1("mr") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					final Random r = x.getRandom();
					if (Conv.isNumber(a)) {
						if (Conv.isDouble(a)) {
							return r.nextDouble() * Conv.toDouble(a);
						}
						if (Conv.isLong(a)) {
							final long al = Conv.toLong(a);
							if (al <= 0) {
								throw new IllegalArgumentException("Parameter must be positive");
							}
							if (al <= Integer.MAX_VALUE) {
								return (long) r.nextInt((int) al);
							}
							long bits, val;
							do {
								bits = r.nextLong() & Long.MAX_VALUE;
								val = bits % al;
							} while (bits - val + (al - 1) < 0l);
							return val;
						}
						final BigInteger ab = Conv.toBigint(a);
						if (ab.signum() <= 0) {
							throw new IllegalArgumentException("Parameter must be positive");
						}
						final int n = ab.bitLength();
						BigInteger bits, val;
						do {
							bits = new BigInteger(n, r);
							val = bits.mod(ab);
						} while (bits.subtract(val).add(ab).subtract(BigInteger.ONE).bitLength() <= n);
						return val;
					}
					if (Conv.isList(a)) {
						final List<Object> l = Conv.toNewList(a);
						Collections.shuffle(l, r);
						return l;
					}
					throw fail(a);
				}
			});

			add(new Op1("mR") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isList(a)) {
						throw fail(a);
					}
					final List<?> al = Conv.toList(a);
					if (al.isEmpty()) {
						throw new IllegalArgumentException("Empty array");
					}
					return al.get(x.getRandom().nextInt(al.size()));
				}
			});

			add(new Op1("z") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (Conv.isNumber(a)) {
						if (Conv.isDouble(a)) {
							return Math.abs(Conv.toDouble(a));
						}
						if (Conv.isBigint(a)) {
							return Conv.toBigint(a).abs();
						}
						final long al = Conv.toLong(a);
						return al == Long.MIN_VALUE ? BigInteger.valueOf(al).abs() : Math.abs(al);
					}
					if (Conv.isList(a)) {
						final List<List<Object>> l = new ArrayList<>();
						for (Object o : Conv.toList(a)) {
							final List<?> l2 = Conv.toList(o);
							for (int j = 0; j < l2.size(); ++j) {
								final List<Object> lj;
								if (j == l.size()) {
									l.add(lj = new ArrayList<>());
								}
								else {
									lj = l.get(j);
								}
								lj.add(l2.get(j));
							}
						}
						return l;
					}
					throw fail(a);
				}
			});

			add(new Op2("md") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (!Conv.bothNumber(a, b)) {
						throw fail(a, b);
					}
					if (Conv.anyDouble(a, b)) {
						final double ad = Conv.toDouble(a);
						final double bd = Conv.toDouble(b);
						final double r = ad % bd;
						x.push(Math.round((ad - r) / bd));
						return ad % bd;
					}
					if (Conv.bothLong(a, b)) {
						final long al = Conv.toLong(a);
						final long bl = Conv.toLong(b);
						if (al != Long.MIN_VALUE || bl != -1) {
							x.push(al / bl);
							return al % bl;
						}
					}
					final BigInteger[] dr = Conv.toBigint(a).divideAndRemainder(Conv.toBigint(b));
					x.push(adjustInt(dr[0]));
					return adjustInt(dr[1]);
				}
			});

			add(new Op("j") {
				@Override
				public void run(final CJam x) {
					Memo m = x.getMemo();
					if (m != null) {
						m.calc(x);
						return;
					}
					final int n;
					final Block bl;
					final Object a = x.pop();
					if (Conv.isLong(a)) {
						n = Conv.toInt(a);
						bl = Conv.toBlock(x.pop());
					}
					else if (Conv.isBlock(a)) {
						n = 1;
						bl = Conv.toBlock(a);
					}
					else {
						throw fail(a);
					}
					final Object l = x.pop();
					m = new Memo(l, bl, n);
					x.setMemo(m);
					m.calc(x);
					x.setMemo(null);
				}
			});

			add(new Op("ea") {
				@Override
				public void run(final CJam x) {
					final List<Object> l = new ArrayList<>();
					for (String s : x.getArgs()) {
						l.add(Conv.strToList(s));
					}
					x.push(l);
				}
			});

			add(new Op2("m*") {
				private List<?> list;
				private List<Object> all;
				private Object[] comb;
				private int n;
				private int size;

				private void add(final int k) {
					if (k == size) {
						all.add(new ArrayList<>(Arrays.asList(comb)));
					}
					else {
						for (int i = 0; i < n; ++i) {
							comb[k] = list.get(i);
							add(k + 1);
						}
					}
				}

				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.bothList(a, b)) {
						final List<?> al = Conv.toList(a);
						final List<?> bl = Conv.toList(b);
						final List<Object> l = new ArrayList<>(al.size() * bl.size());
						for (Object i : al) {
							for (Object j : bl) {
								l.add(pair(i, j));
							}
						}
						return l;
					}
					if (Conv.isLong(a) && Conv.isList(b)) {
						return calc(x, b, a);
					}
					if (Conv.isList(a) && Conv.isLong(b)) {
						list = Conv.toList(a);
						n = list.size();
						size = Conv.toInt(b);
						comb = new Object[size];
						all = new ArrayList<>();
						add(0);
						list = null;
						comb = null;
						final List<Object> l = all;
						all = null;
						return l;
					}
					if (Conv.bothLong(a, b)) {
						final int ai = Conv.toInt(a);
						final List<Object> l = new ArrayList<>(ai);
						for (long i = 0; i < ai; ++i) {
							l.add(i);
						}
						return calc(x, l, b);
					}
					throw fail(a, b);
				}
			});

			add(new Op1("mp") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isLong(a)) {
						throw fail(a);
					}
					final long al = Conv.toLong(a);
					if (al == 2 || al == 3) {
						return 1l;
					}
					if (al < 5 || al % 2 == 0) {
						return 0l;
					}
					for (long i = 3; i * i <= al; i += 2) {
						if (al % i == 0) {
							return 0l;
						}
					}
					return 1l;
				}
			});

			add(new Op1("mf") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isLong(a)) {
						throw fail(a);
					}
					long al = Conv.toLong(a);
					final List<Object> l = new ArrayList<>();
					if (al < 4) {
						l.add(al);
						return l;
					}
					while (al % 2 == 0) {
						l.add(2l);
						al >>= 1;
					}
					for (long i = 3; i * i <= al; i += 2) {
						while (al % i == 0) {
							l.add(i);
							al /= i;
						}
					}
					if (al > 1) {
						l.add(al);
					}
					return l;
				}
			});

			add(new Op1("mF") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isLong(a)) {
						throw fail(a);
					}
					long al = Conv.toLong(a);
					final List<Object> l = new ArrayList<>();
					if (al < 4) {
						l.add(pair(al, 1l));
						return l;
					}
					long n = 0;
					while (al % 2 == 0) {
						n++;
						al >>= 1;
					}
					if (n > 0) {
						l.add(pair(2l, n));
					}
					for (long i = 3; i * i <= al; i += 2) {
						n = 0;
						while (al % i == 0) {
							n++;
							al /= i;
						}
						if (n > 0) {
							l.add(pair(i, n));
						}
					}
					if (al > 1) {
						l.add(pair(al, 1l));
					}
					return l;
				}
			});

			add(new Op("es") {
				@Override
				public void run(final CJam x) {
					x.push(System.currentTimeMillis());
				}
			});

			add(new Op("et") {
				@Override
				public void run(final CJam x) {
					final Calendar c = Calendar.getInstance();
					final List<Object> l = new ArrayList<>();
					l.add((long) c.get(Calendar.YEAR));
					l.add((long) (c.get(Calendar.MONTH) + 1));
					l.add((long) c.get(Calendar.DAY_OF_MONTH));
					l.add((long) c.get(Calendar.HOUR_OF_DAY));
					l.add((long) c.get(Calendar.MINUTE));
					l.add((long) c.get(Calendar.SECOND));
					l.add((long) c.get(Calendar.MILLISECOND));
					l.add((long) (c.get(Calendar.DAY_OF_WEEK) - 1));
					l.add((long) (c.get(Calendar.ZONE_OFFSET) + c.get(Calendar.DST_OFFSET)));
					x.push(l);
				}
			});

			add(new Op1("mo") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isNumber(a)) {
						throw fail(a);
					}
					if (Conv.isDouble(a)) {
						return Math.round(Conv.toDouble(a));
					}
					return a;
				}
			});

			add(new Op2("mO") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (!Conv.isNumber(a) || !Conv.isLong(b)) {
						throw fail(a, b);
					}
					final long bl = Conv.toLong(b);
					final double p = Math.pow(10, bl);
					final double d = Math.round(Conv.toDouble(a) * p) / p;
					if (Conv.isDouble(a) && bl > 0) {
						return d;
					}
					return Math.round(d);
				}
			});

			add(new Op3("er") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b, final Object c) {
					if (!Conv.isList(a)) {
						throw fail(a, b, c);
					}
					final List<?> al = Conv.toList(a);
					final List<?> bl = Conv.toList(b);
					final List<?> cl = Conv.toList(c);
					final int n = cl.size();
					final List<Object> l = new ArrayList<>(al.size());
					for (Object o : al) {
						final int t = bl.indexOf(o);
						if (t < 0) {
							l.add(o);
						}
						else if (t < n) {
							l.add(cl.get(t));
						}
						else {
							l.add(cl.get(n - 1));
						}
					}
					return l;
				}
			});

			add(new Op1("ms") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isNumber(a)) {
						throw fail(a);
					}
					return Math.sin(Conv.toDouble(a));
				}
			});

			add(new Op1("mc") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isNumber(a)) {
						throw fail(a);
					}
					return Math.cos(Conv.toDouble(a));
				}
			});

			add(new Op1("mt") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isNumber(a)) {
						throw fail(a);
					}
					return Math.tan(Conv.toDouble(a));
				}
			});

			add(new Op1("mS") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isNumber(a)) {
						throw fail(a);
					}
					return Math.asin(Conv.toDouble(a));
				}
			});

			add(new Op1("mC") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isNumber(a)) {
						throw fail(a);
					}
					return Math.acos(Conv.toDouble(a));
				}
			});

			add(new Op1("mT") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isNumber(a)) {
						throw fail(a);
					}
					return Math.atan(Conv.toDouble(a));
				}
			});

			add(new Op2("ma") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (!Conv.bothNumber(a, b)) {
						throw fail(a, b);
					}
					return Math.atan2(Conv.toDouble(a), Conv.toDouble(b));
				}
			});

			add(new Op2("mh") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (!Conv.bothNumber(a, b)) {
						throw fail(a, b);
					}
					return Math.hypot(Conv.toDouble(a), Conv.toDouble(b));
				}
			});

			add(new Op1("mq") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isNumber(a)) {
						throw fail(a);
					}
					return Math.sqrt(Conv.toDouble(a));
				}
			});

			add(new Op1("mQ") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isNumber(a)) {
						throw fail(a);
					}
					final Object a1 = Conv.isDouble(a) ? ((Op1) get('i')).calc(x, a) : a;
					if (Conv.isLong(a1)) {
						final long al = Conv.toLong(a1);
						if (al < 0) {
							throw new ArithmeticException("Square root of negative number");
						}
						long t = (long) Math.sqrt(al);
						if (t < 1 << 26) {
							return t;
						}
						while (true) {
							final long t1 = (t + al / t) / 2;
							if (t1 >= t && t1 <= t + 1) {
								break;
							}
							t = t1;
						}
						return t;

					}
					final BigInteger ab = Conv.toBigint(a1);
					if (ab.signum() == -1) {
						throw new ArithmeticException("Square root of negative number");
					}
					final int l = ab.bitLength();
					final long tl = (long) Math.sqrt(ab.shiftRight(l / 2 * 2 - 60).longValue());
					BigInteger t = BigInteger.valueOf(tl).shiftLeft(l / 2 - 30);
					while (true) {
						final BigInteger t1 = t.add(ab.divide(t)).shiftRight(1);
						final BigInteger d = t1.subtract(t);
						if (d.signum() == 0 || d.equals(BigInteger.ONE)) {
							break;
						}
						t = t1;
					}
					return t;
				}
			});

			add(new Op1("me") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isNumber(a)) {
						throw fail(a);
					}
					return Math.exp(Conv.toDouble(a));
				}
			});

			add(new Op1("ml") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isNumber(a)) {
						throw fail(a);
					}
					return Math.log(Conv.toDouble(a));
				}
			});

			add(new Op2("mL") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (!Conv.bothNumber(a, b)) {
						throw fail(a, b);
					}
					final double ad = Conv.toDouble(a);
					final double bd = Conv.toDouble(b);
					return bd == 10 ? Math.log10(ad) : (Math.log(ad) / Math.log(bd));
				}
			});

			add(new Op1("m[") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isNumber(a)) {
						throw fail(a);
					}
					return (long) Math.floor(Conv.toDouble(a));
				}
			});

			add(new Op1("m]") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isNumber(a)) {
						throw fail(a);
					}
					return (long) Math.ceil(Conv.toDouble(a));
				}
			});

			add(new Op2("e%") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.isString(a)) {
						final String fmt = Conv.toStr(a);
						final Object[] ba = Conv.toList(b).toArray();
						for (int i = 0; i < ba.length; ++i) {
							if (Conv.isString(ba[i])) {
								ba[i] = Conv.toStr(ba[i]);
							}
						}
						return Conv.strToList(String.format(fmt, ba));
					}
					if (Conv.isString(b)) {
						return calc(x, b, a);
					}
					throw fail(a, b);
				}
			});

			add(new Op2("e*") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.isNumber(a) && Conv.isList(b)) {
						return calc(x, b, a);
					}
					if (Conv.isList(a) && Conv.isNumber(b)) {
						final List<?> al = Conv.toList(a);
						final int n = Conv.toInt(b);
						final int m = al.size();
						final long t = n * (long) m;
						if (t == 0) {
							return new ArrayList<>(0);
						}
						if (t > Integer.MAX_VALUE) {
							throw new RuntimeException("Size limit exceeded");
						}
						if (n == 1) {
							return al;
						}
						final Object[] a2 = new Object[(int) t];
						for (int i = 0; i < m; ++i) {
							Arrays.fill(a2, i * n, (i + 1) * n, al.get(i));
						}
						return new ArrayList<>(Arrays.asList(a2));
					}
					throw fail(a, b);
				}
			});

			add(new Op3("e\\") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b, final Object c) {
					if (Conv.isList(a)) {
						if (!Conv.bothNumber(b, c)) {
							throw fail(a, b, c);
						}
						final List<Object> al = Conv.toNewList(a);
						final int n = al.size();
						final int bi = adjustIndexMod(b, n);
						final int ci = adjustIndexMod(c, n);
						Collections.swap(al, bi, ci);
						return al;
					}
					if (Conv.isList(b)) {
						return calc(x, b, a, c);
					}
					if (Conv.isList(c)) {
						return calc(x, c, a, b);
					}
					throw fail(a, b, c);
				}
			});

			add(new Op2("e=") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.isList(a)) {
						final List<?> al = Conv.toList(a);
						int n = 0;
						for (Object o : al) {
							if (o.equals(b)) {
								n++;
							}
						}
						return (long) n;
					}
					if (Conv.isList(b)) {
						return calc(x, b, a);
					}
					throw fail(a, b);
				}
			});

			add(new Op1("e!") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (Conv.isList(a)) {
						List<Object> al = Conv.toNewList(a);
						Collections.sort(al, COMP);
						final List<Object> l = new ArrayList<>();
						l.add(al);
						final int n = al.size();
						int k;
						while (true) {
							al = new ArrayList<>(al);
							for (k = n - 2; k >= 0; --k) {
								if (compare(al.get(k), al.get(k + 1)) < 0) {
									break;
								}
							}
							if (k < 0) {
								break;
							}
							int i = n - 1;
							final Object o = al.get(k);
							while (compare(o, al.get(i)) >= 0) {
								--i;
							}
							Collections.swap(al, i, k);
							++k;
							i = n - 1;
							while (k < i) {
								Collections.swap(al, i, k);
								++k;
								--i;
							}
							l.add(al);
						}
						return l;
					}
					if (Conv.isNumber(a)) {
						final int n = Conv.toInt(a);
						final List<Object> l = new ArrayList<>(n);
						for (long i = 0; i < n; ++i) {
							l.add(i);
						}
						return calc(x, l);
					}
					throw fail(a);
				}
			});

			add(new Op1("m!") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (Conv.isList(a)) {
						final List<?> al = Conv.toList(a);
						final int n = al.size();
						final List<?> p = Conv.toList(((Op1) get("e!")).calc(x, (long) n));
						for (Object o : p) {
							@SuppressWarnings("unchecked")
							final List<Object> ol = (List<Object>) Conv.toList(o);
							for (int i = 0; i < n; ++i) {
								final long j = (Long) ol.get(i);
								ol.set(i, al.get((int) j));
							}
						}
						return p;
					}
					if (Conv.isNumber(a)) {
						final int n = Conv.toInt(a);
						if (n <= 20) {
							long t = 1;
							for (int i = 2; i <= n; ++i) {
								t *= i;
							}
							return t;
						}
						BigInteger t = BigInteger.ONE;
						for (int i = 2; i <= n; ++i) {
							t = t.multiply(BigInteger.valueOf(i));
						}
						return t;
					}
					throw fail(a);
				}
			});

			add(new Op1("e_") {
				private void flatten(final List<Object> l, final List<?> al) {
					for (Object o : al) {
						if (Conv.isList(o)) {
							flatten(l, Conv.toList(o));
						}
						else {
							l.add(o);
						}
					}
				}

				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isList(a)) {
						return Conv.toList(a);
					}
					final List<Object> l = new ArrayList<>();
					flatten(l, Conv.toList(a));
					return l;
				}
			});

			add(new Op1("e`") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isList(a)) {
						throw fail(a);
					}
					final List<?> al = Conv.toList(a);
					if (al.isEmpty()) {
						return al;
					}
					final List<Object> l = new ArrayList<>();
					Object o = al.get(0);
					long n = 1;
					for (int i = 1; i < al.size(); ++i) {
						final Object o1 = al.get(i);
						if (o.equals(o1)) {
							n++;
						}
						else {
							l.add(pair(n, o));
							o = o1;
							n = 1;
						}
					}
					l.add(pair(n, o));
					return l;
				}
			});

			add(new Op1("e~") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isList(a)) {
						throw fail(a);
					}
					final List<?> al = Conv.toList(a);
					if (al.isEmpty()) {
						return al;
					}
					final List<Object> l = new ArrayList<>();
					for (Object o : al) {
						if (!Conv.isList(o)) {
							throw new RuntimeException("Expected an array of pairs");
						}
						final List<?> ol = Conv.toList(o);
						l.addAll(Collections.nCopies(Conv.toInt(ol.get(0)), ol.get(1)));
					}
					return l;
				}
			});

			add(new Op2("ew") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b) {
					if (Conv.isList(b) && Conv.isLong(a)) {
						return calc(x, b, a);
					}
					if (Conv.isList(a) && Conv.isLong(b)) {
						final List<?> al = Conv.toList(a);
						final int n = al.size();
						final int bi = Conv.toInt(b);
						if (bi > n) {
							return new ArrayList<>();
						}
						if (bi <= 0) {
							throw new RuntimeException("Invalid slice size");
						}
						final List<Object> l = new ArrayList<>(n - bi + 1);
						for (int i = 0; i < n - bi + 1; ++i) {
							l.add(new ArrayList<Object>(al.subList(i, i + bi)));
						}
						return l;
					}
					throw fail(a, b);
				}
			});

			add(new Op3("e[") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b, final Object c) {
					if (!Conv.isList(a) || !Conv.isLong(b)) {
						throw fail(a, b, c);
					}
					final List<?> al = Conv.toList(a);
					final int n = al.size();
					final int bi = Conv.toInt(b);
					if (bi < 0) {
						throw new RuntimeException("Invalid array size");
					}
					if (bi <= n) {
						return al;
					}
					final List<Object> l = new ArrayList<>(bi);
					for (int i = 0; i < bi - n; ++i) {
						l.add(c);
					}
					l.addAll(al);
					return l;
				}
			});

			add(new Op3("e]") {
				@Override
				protected Object calc(final CJam x, final Object a, final Object b, final Object c) {
					if (!Conv.isList(a) || !Conv.isLong(b)) {
						throw fail(a, b, c);
					}
					final List<?> al = Conv.toList(a);
					final int n = al.size();
					final int bi = Conv.toInt(b);
					if (bi < 0) {
						throw new RuntimeException("Invalid array size");
					}
					if (bi <= n) {
						return al;
					}
					final List<Object> l = new ArrayList<>(bi);
					l.addAll(al);
					for (int i = 0; i < bi - n; ++i) {
						l.add(c);
					}
					return l;
				}
			});

			add(new Op1("ee") {
				@Override
				protected Object calc(final CJam x, final Object a) {
					if (!Conv.isList(a)) {
						throw fail(a);
					}
					final List<?> al = Conv.toList(a);
					final List<Object> l = new ArrayList<>(al.size());
					for (int i = 0; i < al.size(); i++) {
						l.add(pair((long) i, al.get(i)));
					}
					return l;
				}
			});
		}
	}

	static class CJam {
		private static Set<Class<?>> TYPES = new HashSet<>(Arrays.<Class<?>>asList(ArrayList.class, Long.class, Double.class,
				BigInteger.class, Character.class, Block.class));

		private List<Object> stack;
		private Object[] var = new Object[26];
		private final In in;
		private final Out out;
		private final Out err;
		private final List<Integer> marks = new ArrayList<>();
		private final Random r = new Random();
		private Memo memo;
		private String[] args;

		public CJam() {
			this(new SystemIn(), new SystemOut(), new SystemErr());
		}

		public CJam(final In in, final Out out) {
			this(in, out, out);
		}

		public CJam(final In in, final Out out, final Out err) {
			this.in = in;
			this.out = out;
			this.err = err;
			stack = new ArrayList<>();
			setVars();
		}

		private void setVars() {
			Arrays.fill(var, new ArrayList<>());
			for (int i = 0; i < 11; ++i) { // A to K = 10 to 20
				var[i] = i + 10l;
			}
			setVar('N', Conv.strToList("\n"));
			setVar('P', Math.PI);
			setVar('S', Conv.strToList(" "));
			setVar('T', 0l);
			setVar('U', 0l);
			setVar('V', 0l);
			setVar('W', -1l);
			setVar('X', 1l);
			setVar('Y', 2l);
			setVar('Z', 3l);
		}

		public void checkType(final Object x) {
			if (!TYPES.contains(x.getClass())) {
				throw new IllegalArgumentException("Tried to push " + x.getClass());
			}
		}

		public void push(final Object x) {
//			checkType(x);
			stack.add(x);
		}

		public Object pop() {
			final int n = stack.size();
			if (n == 0) {
				throw new RuntimeException("The stack is empty");
			}
			for (int i = marks.size() - 1; i >= 0; --i) {
				final int m = marks.get(i);
				if (m < n) {
					break;
				}
				if (m == n) {
					marks.set(i, n - 1);
				}
			}
			return stack.remove(n - 1);
		}

		public Object peek() {
			return stack.get(stack.size() - 1);
		}

		public void mark() {
			marks.add(stack.size());
		}

		public void popMark() {
			final int start = marks.isEmpty() ? 0 : marks.remove(marks.size() - 1);
			final List<Object> l = stack.subList(start, stack.size());
			final List<Object> r = new ArrayList<>(l);
			l.clear();
			push(r);
		}

		public Object get(final int x) {
			final int y = x < 0 ? -1 - x : stack.size() - 1 - x;
			if (y < 0 || y >= stack.size()) {
				throw new IllegalArgumentException("Stack size " + stack.size() + ", x=" + x);
			}
			return stack.get(y);
		}

		public Object getVar(final char c) {
			return var[c - 'A'];
		}

		public void setVar(final char c, final Object x) {
//			checkType(x);
			if (c < 'A' || c > 'Z') {
				throw new IllegalArgumentException("Invalid variable name: " + c);
			}
			var[c - 'A'] = x;
		}

		public String readNext() {
			return in.readNext();
		}

		public String readLine() {
			return in.readLine();
		}

		public String readAll() {
			return in.readAll();
		}

		public void print(final Object o) {
			out.print(o);
		}

		public void println() {
			out.println();
		}

		public void println(final Object o) {
			out.println(o);
		}

		public void err(final Object o) {
			err.print(o);
		}

		public void errln() {
			err.println();
		}

		public void errln(final Object o) {
			err.println(o);
		}

		public Random getRandom() {
			return r;
		}

		public Memo getMemo() {
			return memo;
		}

		public void setMemo(final Memo memo) {
			this.memo = memo;
		}

		public String[] getArgs() {
			return args;
		}

		public void setArgs(final String[] args) {
			this.args = args;
		}

		private void dump(final Object o) {
			if (o instanceof List) {
				for (Object x : (List<?>) o) {
					dump(x);
				}
			}
			else {
				print(o);
			}
		}

		public void dump() {
			dump(stack);
		}

		public void show() {
			println();
			println("Stack: " + Conv.repr(stack));
		}

		public void clear() {
			stack.clear();
			marks.clear();
			setVars();
			memo = null;
		}

		public void runCode(final Block b) {
			try {
				b.run(this);
			}
			catch (Exception e) {
				final String s = e.getClass().getSimpleName();
		        final String msg = e.getMessage();
		        errln(msg == null ? s : (s + ": " + msg));
				System.err.println("Java exception:");
				e.printStackTrace();
			}
			dump();
		}

		public static void run(final String code) {
			final CJam x = new CJam();
			final Block b = Block.parse(new StringReader(code), false);
			x.runCode(b);
		}

		public static void jamCode(final String code) {
			final CJam x = new CJam();
			final Block b = Block.parse(new StringReader(code), false);
			final int n = Integer.parseInt(x.readNext());
			x.readLine();
			for (int i = 1; i <= n; ++i) {
				b.run(x);
				x.print("Case #" + i + ": ");
				x.dump();
				x.clear();
				x.println();
			}
		}
	}
}
