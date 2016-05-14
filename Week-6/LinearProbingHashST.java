import java.util.*;

public class LinearProbingHashST<Key, Value>
{
    private int M = 30001;
    private Value[] vals = (Value[]) new Object[M];
    private Key[] keys = (Key[]) new Object[M];

    private int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value val)
    {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                break;
        keys[i] = key;
        vals[i] = val;
    }

    public Value get(Key key)
    {
        for (int i = hash(key); keys[i] !=null; i = (i + 1) % M)
            if (key.equals(keys[i]))
                return vals[i];
        return null;
    }

    public static String getRandomString(int length) 
    {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
        Random random = new Random();     
        StringBuffer sb = new StringBuffer();     
        for (int i = 0; i < length; i++) 
        {     
            int number = random.nextInt(base.length());     
            sb.append(base.charAt(number));     
        }     
        return sb.toString();    
    }   

    public static void main(String[] argv)
    {
        LinearProbingHashST<Integer, String> ST = new LinearProbingHashST<Integer, String>();
        for (int i = 1; i < 40; i++)
        {
            String temp = getRandomString(4);
            ST.put(i, temp);
            System.out.println(i + " | " + temp); 
        }

        System.out.println(ST.get(30));
        System.out.println(ST.get(28));

    }
}