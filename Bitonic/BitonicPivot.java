/** Abhimanyu Talwar                                                         **/
/** https://github.com/talwarabhimanyu/                                      **/
/** Given a bitonic array, this code finds the pivot element in O(lgN) time. **/
/** The code doesn't check for bitonicity; it expects bitonicity.            **/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class BitonicPivot{
    public static void main(String args[]) {
        int n = 1;                    // Number of items in the bitnoic array
        if (args.length != 0) {n = Integer.parseInt(args[0]);}
        int[] bitonic = new int[n];
        int i = 0;
        while ((!StdIn.isEmpty()) && (i <n)) {    // Discard numbers afer n elements
            bitonic[i++] = Integer.parseInt(StdIn.readString());
        }
        StdOut.println("Read " + i + " numbers.");
        int first = 0;
        int last = i-1;
        int pivot = -1;
        int mid;
        
        do {
            mid = (first + last) / 2;
            if ((mid == 0) || (bitonic[mid -1] < bitonic[mid])) {
                if ((mid == i-1) || (bitonic[mid + 1] < bitonic[mid])) {pivot = mid;}
                else {first = mid + 1;}
            } else {
                last = mid - 1;
            }
        } while ((pivot < 0));
        
        if (pivot >= 0) {StdOut.println("Pivot is: " + bitonic[pivot]);} 
    }
    
}