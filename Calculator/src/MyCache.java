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

    public boolean inCacheL1(Operation operation)
    {
        for(int i=0;i<CacheL1.size();i++)
        {
            if (CacheL1.get(i).hashCode()==operation.hashCode())
                return true;
        }
        return false;
    }

    public boolean inCacheL2(Operation operation)
    {
        for(int i=0;i<CacheL2.size();i++)
        {
            if (CacheL2.get(i).equals(operation))
                return true;
        }
        return false;
    }

    public double GetResult(Operation operation)
    {
        int index = -1;
        for(int i=0;i<CacheL1.size();i++)
        {
            if (CacheL1.get(i).hashCode()==operation.hashCode())
                index = CacheL1.indexOf(operation);
        }

        if (index>=0) {
            System.out.println("CONTAINS IN L1");
            return (CacheL1.get(index).result);
        }
        else
        {
            for(int i=0;i<CacheL2.size();i++)
            {
                if (CacheL2.get(i).equals(operation))
                    index = CacheL2.indexOf(operation);
            }

            if (index>=0) {
                System.out.println("CONTAINS IN L2");
                return (CacheL2.get(index).result);
            }
        }
        return -999;
    }
}
