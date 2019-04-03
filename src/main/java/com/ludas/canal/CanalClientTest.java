package com.ludas.canal;


import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author KyLin
 * @Description:canal客户端测试
 * @date 2019/4/1 14:15
 */
public class CanalClientTest {

    private static String zkServer = "";
    private static String destination = "kylin_test";


    public static void main(String[] args) throws Exception {

        try {
            CanalConnector canalConnector = CanalConnectors.newClusterConnector(zkServer, destination, "", "");
            int batchSize = 1;
            while (true) {
                //获取连接并且订阅
                canalConnector.connect();
                canalConnector.subscribe();

                //获取一条记录
                Message message = canalConnector.getWithoutAck(batchSize);
                long batchId = message.getId();
                List<CanalEntry.Entry> entries = message.getEntries();
                int size = entries.size();
                if (batchId == -1 || size == 0) {
                    System.out.println("canal 服务器暂无数据....");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
                } else {
                    System.out.println("获取到的信息:" + size + "||" + message.toString());
                    /**
                     * message:结构
                     *
                     header {
                     version: 1
                     logfileName: "mysql-bin.000452"
                     logfileOffset: 223759515
                     serverId: 53157
                     serverenCode: "UTF-8"
                     executeTime: 1554276409000
                     sourceType: MYSQL
                     schemaName: "fengjr_user_access"
                     tableName: "active_user_active_time"
                     eventLength: 66
                     eventType: INSERT
                     }
                     entryType: ROWDATA
                     storeValue: "user_id \000(\0010\000B\00512333R\vvarchar(36)"
                     */
                    for (CanalEntry.Entry entry:entries) {
                        //跳过事物标志事件
                        if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
                            continue;
                        }
                        //处理数据
                        CanalEntry.RowChange rowChage =CanalEntry.RowChange.parseFrom(entry.getStoreValue());
                        CanalEntry.EventType eventType = rowChage.getEventType();
                        for (CanalEntry.RowData rowData : rowChage.getRowDatasList()) {
                            if (eventType == CanalEntry.EventType.DELETE) {
                                System.out.println("delete:"+rowData.getBeforeColumnsList());
                            } else if (eventType == CanalEntry.EventType.INSERT) {
                                System.out.println("insert:"+rowData.getAfterColumnsList());
                            } else if(eventType == CanalEntry.EventType.UPDATE){
                                System.out.println("---------before-------------");
                                System.out.println(rowData.getBeforeColumnsList());
                                System.out.println("---------after--------------");
                                System.out.println(rowData.getAfterColumnsList());
                            }
                        }
                    }
                }
                canalConnector.ack(batchId);
                Thread.sleep(10000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
