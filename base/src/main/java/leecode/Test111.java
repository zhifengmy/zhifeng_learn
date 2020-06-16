package leecode;

import java.util.*;

/**
 * Created with H
 * Description:
 * Time: 2020/6/16
 */
public class Test111 {


    public static void main(String[] args) {

    }


    public static Map cal(List<String> list){

        HashMap<Long,Long> hashMap=new HashMap<>();
        for (String str:list) {
            String[] split = str.split(" ");
            String uidStr = split[1];
            Long uid=Long.valueOf(uidStr);
            if(hashMap.containsKey(uid)){
                hashMap.put(uid,hashMap.get(uid)+1);
            }else{
                hashMap.put(uid,1L);
            }

        }
        Set<Map.Entry<Long, Long>> entries = hashMap.entrySet();
        for (Map.Entry<Long,Long> entry:entries) {
            Long key = entry.getKey();
            Long value = entry.getValue();

        }

        return hashMap;

    }


}
