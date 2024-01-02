// https://www.hackerearth.com/submission/88708598/
Best Solution to problem Find Pairs from HackerEarth December circuits 2023.

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.io.InputStream;
 
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        FindPairs solver = new FindPairs();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class FindPairs {
        int N;
        int[] A;
 
        public void fillInputParams(FastReader in) {
            N = in.nextInt();
            A = in.getIntArray(N);
        }
 
        Object solveOptimised(FastReader in, StringBuilder sb) {
            HashMap<Integer, Integer> count = new HashMap<>();
            for (int i = 0; i < N; ++i) {
                count.put(A[i] - i, count.getOrDefault(A[i] - i, 0) + 1);
            }
            long pairCount = 0;
            for (int freq : count.values()) {
                pairCount += 1l * freq * (freq - 1);
            }
            return pairCount;
        }
 
        Object solveBrute(FastReader in, StringBuilder sb) {
            if (!Logger.isDevEnv) return null;
            return null;
        }
 
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            // out.print("Case #" + testNumber + ": ");
 
            fillInputParams(in);
            Object outOptimised = solveOptimised(in, new StringBuilder());
            Object outBrute = solveBrute(in, new StringBuilder());
            if (outBrute == null) {
                out.println(outOptimised);
            } else if (outBrute.toString().equals(outOptimised.toString())) {
                System.err.println(testNumber + ". OK Checked");
            } else {
                // print input params
                System.err.println("Actual = " + outOptimised);
                System.err.println("Expected = " + outBrute);
                System.err.println();
                throw new ArithmeticException();
            }
        }
 
    }
 
    static class FastReader {
        static final int BUFSIZE = 1 << 20;
        static byte[] buf;
        static int index;
        static int total;
        static InputStream in;
 
        public FastReader(InputStream is) {
            try {
                in = is;
                buf = new byte[BUFSIZE];
            } catch (Exception e) {
            }
        }
 
        private int scan() {
            try {
                if (index >= total) {
                    index = 0;
                    total = in.read(buf);
                    if (total <= 0)
                        return -1;
                }
                return buf[index++];
            } catch (Exception | Error e) {
                System.err.println(e.getMessage());
                return 13 / 0;
            }
        }
 
        public int nextInt() {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+')
                c = scan();
            for (; c >= '0' && c <= '9'; c = scan())
                val = (val << 3) + (val << 1) + (c & 15);
            return neg ? -val : val;
        }
 
        public int[] getIntArray(int size) {
            int[] ar = new int[size];
            for (int i = 0; i < size; ++i) ar[i] = nextInt();
            return ar;
        }
 
    }
 
    static class Logger {
        public static final boolean isDevEnv = System.getenv().get("USERDOMAIN") != null
                && System.getenv().get("USERDOMAIN").equals("LAPTOP-DSSUKMC1");
        public PrintStream stream;
 
        public Logger() {
            stream = System.err;
        }
 
        public Logger(PrintStream ps) {
            stream = ps;
        }
 
    }
}

// C++ Solution, Its a further better solution with better time complexity 
// https://www.hackerearth.com/submission/88978630/
#include <bits/stdc++.h>
using namespace std;
const int NMAX = 5e5, AMAX = 1e6, UMAX = NMAX+AMAX;
int A[NMAX], C[UMAX], N, M, offset;
int64_t ans;
inline auto next_int(){ int num; cin >> num; return num; }
inline auto nP2(int64_t n){ return n*(n-1); }
 
int main() {
    cin.tie(nullptr)->sync_with_stdio(false);
    cin >> N, M = N-1, offset = M-1, generate(A,A+N,next_int);
    for (int i = 0; i < N; ++i)
        ++C[offset+A[i]-i];
    for (int i = 0; i < UMAX; ++i)
        if (C[i] > 1)
            ans += nP2(C[i]);
    cout << ans; }
