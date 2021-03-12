import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomPanel extends JPanel {
    public JButton jButton = new JButton("按钮");//实例化一个按钮
    public JLabel jlabel = new JLabel("标签：");//增加一个标签控件

    public CustomPanel() {

        setLayout(new GridLayout(2, 1, 0, 0));//设置布局控件，两行一列，间隔都为0
        add(jButton);
        add(jlabel);
        jButton.addActionListener(e -> {
            jButton.setText("新的内容");
            jlabel.setText("新的标签");
            if(this.iObj!=null){
                iObj.run("内部的值");
            }
        });//对按钮进行事件的监听
    }
    private IObj iObj;

    public  void addEvent(IObj iObj){
        this.iObj=iObj;

    }
}
