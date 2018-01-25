/** Abhimanyu Talwar                                                         **/
/** https://github.com/talwarabhimanyu/                                      **/
/** Given an integer array of size N, this code counts the no. of inversions **/
/** in O(N lgN) time.                                                        **/

import edu.princeton.cs.algs4.StdIn; 
import edu.princeton.cs.algs4.In;

public class CountInversion {
    public static int countInv = 0;
    public static void main(String[] args){
        In in = new In(args[0]);
        int n = in.readInt();
        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = in.readInt();
        }
        //Iterative Merge Sort routine which also counts the number of 
        //inversions during the Merge operation.
        
        //starting with subarrays of size 1, merge subarrays 2 at a time
        //at each step subarray doubles in size, until only two subarays are left.
        int countInv = 0;
        int lo = 0;
        for (int subArrSize = 1; subArrSize < 4; subArrSize *= 2) {
            while (true) {
                int mid = lo + subArrSize;
                int hi = Math.min(mid + subArrSize, n - 1);
                merge(inputArray, lo, mid, hi);
                lo = hi + 1;
            }
        }
    }
    private void merge(int[] a, int lo, int mid, int hi) {
        int[] aux = new int[a.length];
        //Copy input array to the auxiliary array
        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }
        //Merge sub-arrays
        int i = lo;
        int j = mid + 1;
        int k = 0;
        while (true) {
            
        }
    }
}