public class ShellSort 
{
    public static void insertionSort(int[] data, int start, int step)
    {
        for (int i = start; i < data.length; i += step)
        {
            for (int j = i; j > 0; j -= step)
            {
                if (data[j] < data[j-1])
                {
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }
                else break;
            }
        }
    }

    public static void sort(int[] data)
    {
        int len= data.length;
        for (int step = len / 2; step > 0; step /= 2)
        {
            for (int start = 0; start < step; start++)
            {
                //调用插入排序
                insertionSort(data, start, step);
            }
        }
    }

    public static void main(String[] argv)
    {
        int[] data = {5, 1, 2, 6, 8, 10, 3, 6, 12, 7};
        sort(data);

        for(int i: data)
            System.out.println(i);
    }
}