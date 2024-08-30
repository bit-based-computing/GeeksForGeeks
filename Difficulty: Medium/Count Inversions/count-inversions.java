//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];

            for (long i = 0; i < n; i++) arr[(int)i] = sc.nextLong();

            System.out.println(new Solution().inversionCount(arr, (int)n));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long arr[], int n) {
        // Your Code Here
        return divide(0, n-1, arr);
    }
    
     private static long divide(int left, int right, long[] nums) {
        if(left < right) {
            long globalInv = 0;
            int mid = left + (right-left)/2;
            globalInv += divide(left, mid, nums);
            globalInv += divide(mid+1, right, nums);
            
            long[] temp = new long[right - left + 1];
            int i = left;
            int j = mid + 1;
            int k = 0;
            while(i <= mid && j <= right) {
                if (nums[i] <= nums[j]) {
                    temp[k++] = nums[i++];
                } else {
                    globalInv += (mid - i + 1);
                    temp[k++] = nums[j++];
                }
            }
            while (i <= mid) {
                temp[k++] = nums[i++];
            }
            while (j <= right) {
                temp[k++] = nums[j++];
            }
            for(i = left; i <= right; i++) {
                nums[i] = temp[i-left];
            }
            return globalInv;
        }
        return 0;
    }
}