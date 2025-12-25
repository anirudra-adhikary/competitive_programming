import java.io.*;
import java.util.*;

public class weirdAlgorithm {
    public static void main(String[] args) throws IOException {
        // Step 1: Initialize Fast I/O
        // BufferedReader + StringTokenizer is much faster than Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // Step 2: Use PrintWriter for buffered output
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        // Use long to prevent overflow (3n + 1 can exceed 2*10^9)
        long n = Long.parseLong(st.nextToken());

        // Step 3: Use StringBuilder to accumulate the sequence
        // This prevents the overhead of many small I/O calls
        StringBuilder sb = new StringBuilder();
        sb.append(n);

        while (n != 1) {
            // Bitwise operations are faster than % and /
            if ((n & 1) == 0) {
                n >>= 1; // Equivalent to n / 2
            } else {
                n = n * 3 + 1;
            }
            sb.append(" ").append(n);
        }

        // Final output
        out.println(sb.toString());
        
        // Critical: You must close/flush the PrintWriter
        out.flush();
        out.close();
    }
}
