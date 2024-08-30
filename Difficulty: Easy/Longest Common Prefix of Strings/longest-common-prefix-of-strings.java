//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        int len = arr.length;
        if(len == 1) return arr[0];
        String s = arr[0];
        for(int i = 1; i < len; i++) {
            String t = arr[i];
            while (t.indexOf(s) != 0 && s.length() > 0) {
                s = s.substring(0, s.length()-1);
            }
            if(s.length() == 0) return "-1";
        }
        return s;
    }
}