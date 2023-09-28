// Arrays

// Dynamic Array
public class IntArray 
// IntArray implements the interface Iterable: allows an object to be the target of the enhanced for statement or the for each loop.
{
    // VARIABLES
    private static final int DEFAULT_CAP = 1 << 3; // 1 is right shifted to 3 places which makes it 8
    // and is private (only within this class)
    public int[] arr; // arr is an empty array of integer type.
    public int len = 0;
    private int capacity = 0;

    // CONSTRUCTURES
    // Initialize the arr with default capacity
    // Default constructor
    public IntArray()
    {
        this(DEFAULT_CAP); 
    }

    // Initialize the arr with given capacity
    // Parameterized constructor
    public IntArray( int capacity)
    {
        if (capacity < 0) { throw new IllegalArgumentException("Illegal Capacity: " + capacity); }
        this.capacity = capacity;
        arr = new int[capacity]; // creates new arr with given capacity
    }

    // if passed an array for this class object, make it a dynamic array!
    public IntArray( int[] array)
    {
        if (array == null) { throw new IllegalArgumentException("Illegal Null array!");}
        // copy the passed array into arr using in built copyOf method in Arrays class.
        arr = java.util.Arrays.copyOf(array, array.length);
        capacity = len = array.length;
    }

    // CLASS METHODS
    // get length of arr
    public int size()
    {
        return len;
    }

    // check if arr is empty
    public boolean isEmpty()
    {
        return len == 0;
    }

    // for given index, get value
    public int getValue(int index)
    {
        return arr[index];
    }

    // set the given value at given index
    public void setValue(int index, int value)
    {
        arr[index] = value;
    }

    // add an element at the end of arr
    public void addVal(int value)
    {
        // check if len (pointer) matches the capacity, then the arr is full, so, inc the size
        if (len + 1 >= capacity)
        {
            // if capacity is 0, make it 1
            if (capacity == 0) {capacity = 1;}
            // if capacity is not 0 but is lesser then the length of arr, 
            // double the capacity to dynamically increase the size of arr
            else {capacity *= 2;}

            // create a new arr by copying the previous elements and setting the new capacity
            arr = java.util.Arrays.copyOf(arr, capacity); // adds 0 or null elements
        }
        // inc the pointer len by 1 and set the value
        arr[len++] = value;
    }

    // Remove the element at the specified index in this list.
    // If possible, avoid calling this method as it take O(n) time
    // to remove an element (since you have to reconstruct the array!)
    public void removeAt(int rm_index)
    {
        // arraycopy(Object src, int srcPos, Object dest, int destPos, int length) : void 
        // Copies an array from the specified source array, beginning at the specified position, 
        // to the specified position of the destination array. 
        /*Parameters:
        src: the source array.
        srcPos: starting position in the source array.
        dest: the destination array.
        destPos: starting position in the destination data.
        length: the number of array elements to be copied. */
        System.arraycopy(arr, rm_index+1, arr, rm_index, len - rm_index);
        --len;
        --capacity;
    }

    // Remove the element specified
    // calls the removeAt method when found the index of element
    public boolean remove(int value)
    {
        for (int i=0; i < len; i++)
        {
            if (arr[i] == value)
            {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    // reverse the content of array
    public int[] reverse()
    {
        int[] rev_arr = new int[len];
        for (int i=0; i < len; i++)
        {
            rev_arr[len - i -1] = arr[i];
        }
        return rev_arr;
    }

    // Binary search for a given element
    // O(logn)
    public int binarySearch(int value)
    {
        int index = java.util.Arrays.binarySearch(arr, 0, len, value);
        return index;
    }

    // sort this arr
    public void sort()
    {
        java.util.Arrays.sort(arr, 0, len);
    }

    public void printArr() {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] ar = {1, 2, 3, 4, 5};
        IntArray a = new IntArray(ar);
        a.printArr();
        a.addVal(7);
        a.printArr(); // doubled size of arr
        System.out.println(a.getValue(4));
        System.out.println(a.isEmpty());
        System.out.println(a.binarySearch(3));
        int[] rev_arr = a.reverse();
        for (int num: rev_arr) {System.out.print(num + " ");}
        System.out.println();
        a.printArr();
        System.out.println(a.remove(2));
        a.printArr();
        System.out.println(a.remove(7));
        a.printArr();
        a.addVal(8);
        a.addVal(10);
        a.addVal(6);
        a.printArr();
        a.sort();
        a.printArr();
        a.setValue(9, 2);
        a.printArr();
        a.addVal(9);
        a.printArr();
        a.addVal(18);
        a.printArr();
        System.out.println(a.size());
        System.out.println("THE END");
    }
}


    

























