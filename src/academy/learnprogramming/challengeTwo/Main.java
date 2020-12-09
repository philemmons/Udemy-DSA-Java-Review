package academy.learnprogramming.challengeTwo;
//use recursion
/*
https://www.geeksforgeeks.org/recursive-insertion-sort/
How to implement it recursively?
Recursive Insertion Sort has no performance/implementation advantages,
but can be a good question to check one’s understanding of Insertion Sort and recursion.

If we take a closer look at Insertion Sort algorithm,
we keep processed elements sorted and insert new elements one by one in the inserted array.

Recursion Idea.
    Base Case: If array size is 1 or smaller, return.
    Recursively sort first n-1 elements.
    Insert last element at its correct position in sorted array.

 */
public class Main {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        recursiveInSo(intArray, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    //reduce the problem into the smallest partition
    public static void recursiveInSo( int[] arr, int arrSize ){
        //base case
        if( arrSize <= 1) return;

        //using the recursion to insert values from left to right
        recursiveInSo(arr, arrSize-1 );

        //insert the last element
        int newElement = arr[arrSize-1];

        int i;
        //shift the array elements from left to right
        //to insert newElement
        for (i = arrSize-1; i > 0 && arr[i - 1] > newElement; i--) {
            arr[i] = arr[i - 1];
        }
        //insert the element
        arr[i] = newElement;

    }

}
