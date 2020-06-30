package io;

import java.io.*;
import java.util.*;

/**
 * Created with 栉风
 * Description:
 * Time: 2020/6/16
 */
public class ReadBigFileTest {


    public static void main(String[] args) {
        //分隔大文件
        splitBigFile();
        File file = new File("/home");
        for (File f : file.listFiles()) {
            print(f);
        }

    }

    /**
     * Java读取超大文件
     * <p>
     * 文件5G,空格分隔
     * 格式：
     * time                  id       url
     * 2019-09-01 09:00:00   123      http://www.kuaishou.com
     * id 范围 50亿，Long类型
     * <p>
     * 要求：解析文件，统计并打印每个用户的总访问次数，最终打印出用户id和总访问次数
     * <p>
     * Linux awk '{print $1}' log.txt|sort|uniq -c | sort -nr
     */
    public static void splitBigFile() {
        BufferedInputStream fis = null;
        BufferedReader reader = null;
        FileWriter fw = null;
        try {
            File file = new File("/Users/hql/log.txt");
            fis = new BufferedInputStream(new FileInputStream(file));
            reader = new BufferedReader(new InputStreamReader(fis, "utf-8"), 1024);// 用1G的缓冲读取文本文件

            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(" ");
                String idStr = split[1];

                int i = idStr.hashCode() % 1000; //0-999
                fw = new FileWriter("/Users/hql/file_" + i + ".txt", true);
                fw.append(line + System.lineSeparator());
                fw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (fis != null) {
                    fis.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


    public static void print(File file) {

        if (file == null) {
            return;
        }

        BufferedInputStream fis = null;
        BufferedReader reader = null;
        FileWriter fw = null;
        try {
            fis = new BufferedInputStream(new FileInputStream(file));
            reader = new BufferedReader(new InputStreamReader(fis, "utf-8"), 1024);// 用1G的缓冲读取文本文件
            Map<String, Long> countMap = new TreeMap<>();

            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(" ");
                String id = split[1];
                if (countMap.containsKey(id)) {
                    countMap.put(id, countMap.get(id) + 1L);
                } else {
                    countMap.put(id, 1L);
                }
                //遍历
                for (Map.Entry<String, Long> entry : countMap.entrySet()) {
                    String key = entry.getKey();
                    Long value = entry.getValue();
                    System.out.println(key + ">>>>>>>" + value);
                }
            }
        } catch (Exception e) {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (fis != null) {
                    fis.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception se) {
                se.printStackTrace();
            }

        }


    }


}
