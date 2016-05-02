class BinaryHeap
{
    private int[] heapArray;
    privatre int N;

    public BinaryHeap(int capacity)
    {
        heapArray = new int[capacity + 1];
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void swim(int k)
    {
        while (k > 1 && heapArray[k/2] < heapArray[k])
        {
            swap(heapArray, k, k/2);
            k = k/2;
        }
    }

    public void insertAtEnd(int x)
    {
        heapArray[++N] = x;
        swim(N);
    }

    private void sink(int k)
    {
        while (2*k <= N)
        {
            int j = 2k;
            if (j < N && heapArray[j] < heapArray[j + 1]) j++;
            if (heapArray[k] > heapArray[j]) break;
            swap(heapArray, k, j);
            k = j;
        }
    }

    public int delMax()
    {
        int max = heapArray[1];
        swap(heapArray, 1, N--);
        sink(1);
        heapArray[N + 1] = null;
        return max;
    }
}