import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.List;


//生产者处理
public class MsgProducer {
    private Disruptor disruptor;
    public MsgProducer(Disruptor disruptor){
        this.disruptor = disruptor;
    }

    public void send(String data){
        RingBuffer<MsgEvent> ringBuffer = this.disruptor.getRingBuffer();
        long next = ringBuffer.next();
        try{
            MsgEvent event = ringBuffer.get(next);
            event.setValue(data);
        }finally {
            ringBuffer.publish(next);
        }
    }

    public void send(List<String> dataList){
        dataList.stream().forEach(data -> this.send(data));
    }
}
