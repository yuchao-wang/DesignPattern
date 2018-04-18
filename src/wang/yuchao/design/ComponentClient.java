package wang.yuchao.design;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * Created by wangyuchao on 2018/4/18.
 */
public class ComponentClient {
    //组件类
    public abstract class Component {
        public abstract void someOperation();

        public void addChild(Component child) {
            throw new UnsupportedOperationException("叶子类没有此功能");
        }

        public void removeChild(Component child) {
            throw new UnsupportedOperationException("叶子类没有此功能");
        }

        public Component getChildren(int index) {
            throw new UnsupportedOperationException("叶子类没有此功能");
        }
    }

    //组合对象
    public class Composite extends Component {

        private List<Component> childComponents = null;

        @Override
        public void someOperation() {
            System.out.println("一些示例方法,比如说循环遍历");
        }

        @Override
        public void addChild(Component child) {
            if (childComponents == null) {
                childComponents = new ArrayList<Component>();
            }
            childComponents.add(child);
        }

        @Override
        public void removeChild(Component child) {
            if (childComponents != null) {
                childComponents.remove(child);
            }
        }

        @Override
        public Component getChildren(int index) {
            if (childComponents != null) {
                if (index > 0 && index < childComponents.size()) {
                    return childComponents.get(index);
                }
            }
            return null;
        }
    }

    //叶子类
    public class Leaf extends Component {
        @Override
        public void someOperation() {
        }
    }

    public void test() {
        Component root = new Composite();
        Component c1 = new Composite();
        Component c2 = new Composite();
        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();
        Component leaf3 = new Leaf();
        //树状结构
        root.addChild(c1);
        root.addChild(c2);
        root.addChild(leaf1);
        c1.addChild(leaf2);
        c2.addChild(leaf3);
        //一些操作...
        root.getChildren(0);
    }

    public static void main(String[] args) {
        new ComponentClient().test();
    }
}
