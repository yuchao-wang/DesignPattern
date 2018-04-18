package wang.yuchao.design;

/**
 * 命令模式
 * Created by wangyuchao on 2018/4/18.
 */
public class CommandClient {
    public interface Command {
        public void execute();
    }

    //接收者
    public class Receiver {
        public void action() {
            System.out.println("真正执行命令操作的代码");
        }
    }

    //具体命令实现对象
    public class ConcreteCommand implements Command {
        private Receiver receiver;

        public ConcreteCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void execute() {
            receiver.action();
        }
    }

    //调用者
    public class Invoker {
        private Command command = null;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void runCommand() {
            command.execute();
        }
    }

    public void test() {
        //创建命令，并设定接收者
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        //设置调用对象
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        //执行命令
        invoker.runCommand();
    }

    public static void main(String[] args) {
        new CommandClient().test();
    }
}
