/** Abhimanyu Talwar                                                         **/
/** https://github.com/talwarabhimanyu/                                      **/
/** Given an integer array of size N, this code counts the no. of inversions **/
/** in O(N lgN) time.                                                        **/

import edu.princeton.cs.algs4.StdIn; 
import edu.princeton.cs.algs4.StdOut; 
import edu.princeton.cs.algs4.In;

public class CountInversion {
    public static int countInv = 0;
    public static void main(String[] args){
        In in = new In(args[0]);
        int n = in.readInt();
        int[] inputArr = new int[n];
        for (int i = 0; i < n; i++) {
            inputArr[i] = in.readInt();
        }
        for (int subArrSize = 1; subArrSize < inputArr.length; subArrSize *= 2) {
            int lo = 0;
            while (lo < inputArr.length) {
                int mid = lo + subArrSize - 1;  //mid refers to last element of first sub-array
                int hi = Math.min(mid + subArrSize, n - 1);
                merge(inputArr, lo, mid, hi);
                lo = hi + 1;
            }
        }
        StdOut.println("No. of inversions: " + countInv);
        StdOut.println("Sorted Array:");
        for (int i = 0; i < inputArr.length; i++) {StdOut.println(inputArr[i]);}
    }
    private static void merge(int[] a, int lo, int mid, int hi) {
        int[] aux = new int[hi - lo + 1];
        //Copy input array to the auxiliary array
        for (int i = 0; i < aux.length; i++) {
            aux[i] = a[i + lo];
        }
        //Merge sub-arrays
        int i = 0;
        int auxmid = mid - lo;
        int j = auxmid + 1;
        int k = lo;
        while ((i < (auxmid + 1)) && (j < aux.length)) {
            if (aux[i] <= aux[j]) {
                a[k++] = aux[i++];
            } else {
                a[k++] = aux[j++];
                countInv += (auxmid - i +1);
            }
        }
        while (i < (auxmid + 1)) {a[k++] = aux[i++];}
        while (j < aux.length) {a[k++] = aux[j++];}
    }
}