public class DulplicateKeysQuickSort
{
    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void sort(int[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        int v = a[lo];
        int i = lo;
        while (i <= gt)
        {
            if (a[i] < v) swap(a, lt++, i++);
            else if (a[i] > v) swap(a, i, gt--);
            else i++;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void main(String[] argv)
    {
        int[] arr = {0, 3, 12, 6, 7, 9, 9, 9, 0, 5, 1, 8, 12};
        sort(arr, 0, 12);

        for(int i: arr)
            System.out.println(i);
    }
}