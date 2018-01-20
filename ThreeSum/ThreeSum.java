/** Abhimanyu Talwar                                                         **/
/** https://github.com/talwarabhimanyu/                                      **/
/** Given an integer array of size N, and an integer k, finds three elements **/
/** of the array which sum to k (if such a trio exists, in O(N^2) time.      **/
/** Code can take two integer arguments, n (no. of elements to read from     **/
/** StdIn) and k (the Sum). It reads the input integer array from StdIn.     **/  

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.Arrays;

public class ThreeSum{
    public static void main(String args[]){
        int n = 3;
        int k = 0;
        if (args.length != 0) { 
            n = Integer.parseInt(args[0]);
            if (n < 3) {n = 3;}          // Need at least 3 numbers for 3Sum.
        }
        if (args.length == 2) {k = Integer.parseInt(args[1]); }
        int[] arr = new int[n];
        int i = 0;
        while ((!StdIn.isEmpty()) && (i < n)) {
            arr[i++] = Integer.parseInt(StdIn.readString());
        }
        StdOut.println("Read " + i + " numbers: " + Arrays.toString(arr) + "\n");
        Arrays.sort(arr);                    // Sort the array.
        int first = 0;
        int second;
        int third;
        boolean foundThreeSum = false;
        do{
            second = first + 1;
            third = i - 1;
            int twoSum = k - arr[first];
            while ((second != third) && !foundThreeSum) {
                if ((arr[second] + arr[third]) == twoSum) {
                    foundThreeSum = true;
                }
                else if ((arr[second] + arr[third]) < twoSum) {
                    second++;
                } else {
                    third--;
                }
            }
            if (!foundThreeSum) {first++;}
        } while ((first < (i - 2)) && !foundThreeSum);
        
        if (!foundThreeSum) {
            StdOut.println("No such trio exists.");
        } else {
            StdOut.println("The three numbers are: " + arr[first] + ", " + arr[second] + ", and " + arr[third]);
        }
    }
}