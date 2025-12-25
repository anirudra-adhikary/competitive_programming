/*
Problem link - https://cses.fi/problemset/task/1068

Weird Algorithm

Consider an algorithm that takes as input a positive integer n. If n is even, the algorithm divides it by two, and if n is odd, the algorithm multiplies it by three and adds one. The algorithm repeats this, until n is one. For example, the sequence for n=3 is as follows:
3->10->5->16->8->4->2->1
Your task is to simulate the execution of the algorithm for a given value of n.

Input
The only input line contains an integer n.

Output
Print a line that contains all values of n during the algorithm.
Constraints

1 <= n <= 10^6

Example
Input:
3

Output:
3 10 5 16 8 4 2 1
*/

//Solution
import java.io.*;
import java.util.*;

public class weirdAlgorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long n = Long.parseLong(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(n);

        while(n!=1) {
            if((n&1)==0)
                n >>= 1;
            else
                n = n*3+1;
            sb.append(" ").append(n);
        }
        out.println(sb.toString());

        out.flush();
        out.close();
    }
}