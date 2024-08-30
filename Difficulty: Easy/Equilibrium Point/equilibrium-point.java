//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            long[] arr = new long[array.size()];
            int idx = 0;
            for (long i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.equilibriumPoint(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // arr: input array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[]) {
        // Your code here
        int len = arr.length;
        if(len == 1) return 1;
        if(len == 2 && (arr[0] == 0 || arr[1] == 0)) {
            if(arr[0] != 0) return 1;
            return 2;
        }
        
        for(int i = 1; i < len; i++){
            arr[i] += arr[i-1];
        }
        
        for(int i = len - 2; i >= 1; i--){
            long rsum = arr[len-1] - arr[i];
            long lsum = arr[i-1];
            if(rsum == lsum) return i + 1;
        }
        
        return -1;
    }
}
