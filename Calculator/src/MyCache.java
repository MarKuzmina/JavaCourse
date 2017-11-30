import java.util.ArrayList;

public class MyCache {
    final int L1Size = 10;
    final int L2Size = 100;
    public ArrayList<Operation> CacheL1;
    public ArrayList<Operation> CacheL2;

    MyCache()
    {
        CacheL1 = new ArrayList<>();
        CacheL2 = new ArrayList<>();
    }

    public void Add(Operation operation)
    {
        System.out.print("ADD TO:");
        if (CacheL1.size()<L1Size) {
            CacheL1.add(operation);
            System.out.println("L1");
        }
        else
        {
            System.out.println("L2");
            CacheL2.add(operation);
        }
    }

    private int inCacheL1(Operation operation)
    {
        for(int i=0;i<CacheL1.size();i++)
        {
            if (CacheL1.get(i).hashCode()==operation.hashCode())
                return CacheL1.indexOf(operation);
        }
        return -1;
    }

    private int inCacheL2(Operation operation)
    {
        for(int i=0;i<CacheL2.size();i++)
        {
            if (CacheL2.get(i).equals(operation))
                return CacheL2.indexOf(operation);
        }
        return -1;
    }

    public double GetResult(Operation operation)
    {
        int index = inCacheL1(operation);
        if (index>=0) {
            System.out.println("CONTAINS IN L1");
            return (CacheL1.get(index).result);
        }
        else
        {
            index = inCacheL2(operation);
            if (index>=0) {
                System.out.println("CONTAINS IN L2");
                return (CacheL2.get(index).result);
            }
            else    //если не содержится ни в одном из уровней кэша:
            {
                System.out.println("Cache NOT contains this operation!");
                Add(operation);
                return operation.result;
            }
        }

    }
}
