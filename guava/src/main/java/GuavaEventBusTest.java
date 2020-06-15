import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Created with H
 * Description:
 * Time: 2020/6/14
 */
public class GuavaEventBusTest {

    public static void main(String[] args) {
        // 定义一个EventBus对象，这里的Joker是该对象的id
        EventBus eventBus = new EventBus("Joker");
        // 向上述EventBus对象中注册一个监听对象
        eventBus.register(new EventAListener());
        eventBus.register(new EventBListener());

        // 使用EventBus发布一个事件，该事件会给通知到所有注册的监听者
        eventBus.post(new AEvent("Hello every listener, joke begins..."));
    }

    // 事件，监听者监听的事件的包装对象
    public static abstract class BaseEvent {
    }

    public static class AEvent extends BaseEvent{
        public String message;
        AEvent(String message) {
            this.message = message;
        }
    }

    public static class BEvent extends BaseEvent{
        public String message;
        BEvent(String message) {
            this.message = message;
        }
    }


    // A监听者 监听A事件
    public static class EventAListener {
        // 监听的方法，必须使用注解声明，且只能有一个参数，实际触发一个事件的时候会根据参数类型触发方法
        @Subscribe
        public void listen1(AEvent event) {
            System.out.println("Event listener A event.message = " + event.message);
        }
    }

    // B监听者 监听B事件
    public static class EventBListener {
        @Subscribe
        public void listen2(BEvent event) {
            System.out.println("Event listener B event.message = " + event.message);
        }
    }

}
