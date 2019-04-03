package com.ludas.canal;


import com.alibaba.fastjson.JSON;
import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @Description:canal客户端测试
* @author KyLin
* @date 2019/4/1 14:15
*/
public class CanalClientTest {
    private static final Logger log = LoggerFactory.getLogger(CanalClientTest.class);

    private static String zkServer="bzk1.fengjr.inc:2181,bzk2.fengjr.inc:2181,bzk3.fengjr.inc:2181";
    private static String destination="kylin_test";


    public static void main(String[] args) throws Exception{
        CanalConnector canalConnector = CanalConnectors.newClusterConnector(zkServer, destination, "", "");
        int batchSize = 1;
        while(true){
            //获取连接并且订阅
            canalConnector.connect();
            canalConnector.subscribe();

            //获取一条记录
            Message message = canalConnector.getWithoutAck(batchSize);
            long batchId = message.getId();
            int size = message.getEntries().size();
            if (batchId == -1 || size == 0) {
                System.out.println("canal 服务器暂无数据....");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            } else {
                System.out.println("获取到的信息:"+size+"||"+message.toString());

                //对客户端接收的时间进行判断


            }
            canalConnector.ack(batchId);
            Thread.sleep(3000);
        }

    }

}
