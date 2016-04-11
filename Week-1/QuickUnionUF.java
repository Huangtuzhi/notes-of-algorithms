public class QuickUnionUF 
{
    private int[] id;

    public QuickUnionUF(int N) 
    {
        id = new int[N];
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
        }
    }

    private int root(int i) 
    {
        while (i != id[i]) i = id[i];
        return 1;
    }

    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }

    public void union(int p, int q) 
    {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    public static void main(String[] args)
    {
        System.out.println("test-union"); 
        QuickUnionUF uf = new QuickUnionUF(10);
        System.out.println(uf.id.length);   
    }
}