import com.lmax.disruptor.WorkHandler;

/**
 * Created with H
 * Description:
 * Time: 2020/6/14
 */
public class MyWorkHandler implements WorkHandler<MsgEvent> {
    private String workName;
    public MyWorkHandler(String work) {
        workName=work;
    }

    @Override
    public void onEvent(MsgEvent event) throws Exception {
        Thread.sleep(1000L);
        System.out.println(workName+"接受到消息:" + event.getValue());

    }
}
