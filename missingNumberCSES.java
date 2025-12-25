/*
Problem Link - https://cses.fi/problemset/task/1083/
Missing Number

You are given all numbers between 1,2,..,n except one. Your task is to find the missing number.

Input
The first input line contains an integer n.
The second line contains n-1 numbers. Each number is distinct and between 1 and n (inclusive).

Output
Print the missing number.
Constraints

2 <= n <= 2.10^5

Example
Input:
5
2 3 1 5

Output:
4
*/

//solution 1
import java.io.*;
import java.util.*;

public class missingNumberCSES {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int xor = 0;
        for(int i=0;i<n-1;i++)
        {
            xor ^= Integer.parseInt(st.nextToken());
            xor ^= (i+1);
        }
        xor ^= n;
        
        out.println(xor);
        out.flush();
        out.close();
    }
}

//Solution 2
import java.io.*;
import java.util.*;

public class missingNumberCSES {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        long n = Long.parseLong(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        long totSum = 0;
        for(int i=0;i<n-1;i++)
            totSum += Long.parseLong(st.nextToken());
        
        long numSum = n * (n + 1) / 2;

        out.println(numSum - totSum);
        out.flush();
        out.close();

    }
}
