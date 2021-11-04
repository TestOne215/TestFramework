package Day11;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapss {
    public static void main(String[] args) {
        Map<String, String> heap = new TreeMap<String, String>();
        heap.put("US","Washington");
        heap.put("China","Beijing");
        heap.put("Russia","Moscow");
        heap.put("India","Delhi");
        System.out.println(heap.get("Russia"));

        Iterator<String> iter = heap.keySet().iterator();
        while(iter.hasNext()){
            String key = iter.next();
            String value = heap.get(key);
            System.out.println("Key is: "+key+" and value is: "+value);

        }


    }
}
