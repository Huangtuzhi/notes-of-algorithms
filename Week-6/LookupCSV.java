public class LookupCSV
{
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        int keyField = Interger.parseInt(args[1]);
        int valField = Interger.parseInt(args[2]);

        ST<String, String> st = new ST<String, String>();
        while (!in.isEmpty()) 
        {
            String line = in.readLine();
            String[] tokens = line.split(',');
            String key = tokens[keyField];
            String val = tokens[valField];
            st.put(key, val);
        }

        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            if (!st.contains(s)) StdOut.println("Not Found");
            else StdOut.println(st.get(s));
        }
    }
}