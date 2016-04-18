public class QuickSelect
{
    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int[] a, int lo, int hi)
    {
        int i = lo, j = hi + 1;
        while(true)
        {
            while (a[++i] < a[lo])
                if (i == hi) break;

            while (a[lo] < a[--j])
                if (j == lo) break;

            if (i >= j) break;
            swap(a, i, j);
        }

        swap(a, lo, j);
        return j;
    }

    public static void sort(int[] a)
    {
        // StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    public static int select(int[] a, int k)
    {
        int lo = 0, hi = a.length - 1;
        while (hi > lo)
        {
            int j = partition(a, lo, hi);
            if (j < k) lo = j + 1;
            if (j > k) hi = j - 1;
            else return a[k];
        }
        return a[k];
    }

    public static void main(String[] argv)
    {
        int[] arr = {6, 7, 9, 0, 5, 1, 8, 12};
        sort(arr, 0, 7);

        for(int i: arr)
            System.out.println(i);

        System.out.println(select(arr, 5));
    }
}