import com.lmax.disruptor.dsl.Disruptor;

import java.util.Arrays;
import java.util.concurrent.Executors;

/**
 * Created with H
 * Description:
 * Time: 2020/6/13
 */
public class DisruptorTest {


    public static void main(String[] args) {
        //多生产者、多消费者
        Disruptor<MsgEvent> disruptor = new Disruptor(MsgEvent::new, 1, Executors.defaultThreadFactory());
//        Disruptor<MsgEvent> disruptor = new Disruptor(MsgEvent::new, 1, Executors.newFixedThreadPool(2));
        disruptor.handleEventsWithWorkerPool(new MyWorkHandler("work1"),new MyWorkHandler("work2"));

        disruptor.start();

        MsgProducer msgProducer = new MsgProducer(disruptor);
        msgProducer.send(Arrays.asList("aaa","bbb","ccc","ddd"));

        System.out.println("111111");
        disruptor.shutdown();
    }




}
