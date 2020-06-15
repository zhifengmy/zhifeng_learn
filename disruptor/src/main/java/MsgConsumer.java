import com.lmax.disruptor.EventHandler;




public class MsgConsumer implements EventHandler<MsgEvent> {
    private String name;

    public MsgConsumer(String name) {
        this.name = name;
    }

    @Override
    public void onEvent(MsgEvent msgEvent, long l, boolean b) throws Exception {
        System.out.println(this.name + " -> 接收到信息： " + msgEvent.getValue());
    }
}