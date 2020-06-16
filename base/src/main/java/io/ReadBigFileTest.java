package io;

import java.io.*;

/**
 * Created with 栉风
 * Description:
 * Time: 2020/6/16
 */
public class ReadBigFileTest {


    public static void main(String[] args) {

    }

    /**
     * Java读取超大文件
     *
     * 文件5G,空格分隔
     * 格式：time            id url
     * 2019-09-01 09:00:00 123 http://www.kuaishou.com
     * id 范围 50亿，Long类型
     *
     * 要求：解析文件，统计并打印每个用户的总访问次数，最终打印出用户id和总访问次数
     *
     */
    public static void splitBigFile(){
        BufferedInputStream fis=null;
        BufferedReader reader=null;
        FileWriter fw = null;

        try {
            File file = new File("");
            fw = new FileWriter("");
            fis = new BufferedInputStream(new FileInputStream(file));
            reader = new BufferedReader(new InputStreamReader(fis,"utf-8"),1024*1024*1024);// 用1G的缓冲读取文本文件

            String line = "";
            while((line = reader.readLine()) != null){
                String[] split = line.split(" ");
                String time=split[0];
                String idStr=split[1];
                String url=split[2];

                Long id = Long.valueOf(idStr);
                if(id>0&&id <1000000000){
                    fw.append(line + " ");
                }else if(id>1000000000&&id <2000000000){
                    fw.append(line + " ");
                }



            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                reader.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }





}
