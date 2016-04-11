public class binarySearch {
    public static int binarySearchAlgorithm(int[] a, int key)
    {
        int low = 0, high = a.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (key < a[mid]) high = mid - 1;
            if (key > a[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] array = {1, 3, 5, 7, 8, 10, 25};
        int index = binarySearchAlgorithm(array, 5);
        System.out.println(index);
    }
}