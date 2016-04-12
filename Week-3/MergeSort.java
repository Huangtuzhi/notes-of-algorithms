public class MergeSort
{
    private static void merge(int[] a, int[] aux, int low, int mid, int high) 
    {
        for(int index = low; index <= high; index++)
            aux[index] = a[index];

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++)
        {
            if (i > mid)              a[k] = aux[j++];
            else if (j > high)        a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else                      a[k] = aux[i++];
        }
    }

    private static void sort(int[] a, int[] aux, int low, int high)
    {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(a, aux, low, mid);
        sort(a, aux, mid + 1, high);
        merge(a, aux, low, mid, high);
    }

    public static void main(String[] argv)
    {
        int[] array = {3, 8, 1, 5, 2, 10, 5 ,5, 6, 1};
        int[] aux;
        aux = new int[10];
        sort(array, aux, 0, 9);

        for(int i: array)
            System.out.println(i);
    }
}