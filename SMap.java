import java.util.Map;
import java.util.TreeMap;
import java.util.*;

public class SMap {

      public static void main(String[] args) {
           Map<Integer, String> uMap = new TreeMap();
           uMap.put(1, "Z");
           uMap.put(2, "A");
           //System.out.println(uMap);
           Map<Integer, String> sMap = new TreeMap<>((Comparator<Integer>)(a,b)->b.compareTo(a));
           sMap.putAll(uMap);
           //System.out.println(sMap);
           Map<Integer, String> newMap = new HashMap();
           newMap.put(1, "Z");
           newMap.put(2, "A");
            newMap.entrySet().stream().sorted(Map.Entry.<Integer,String>comparingByValue()).forEach(System.out::println);

      }

}
