import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 *继承窗体
 */
public class Swing1 extends JFrame {
    public Swing1() throws HeadlessException {

        setLayout(new GridLayout(2,1,0,0));
        setSize(800, 600);//设置窗体的大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭模式，默认的退出关闭
        CustomPanel customPanel = new CustomPanel();
        JButton jButton = new JButton("新按钮");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customPanel.jButton.setText("新按钮的事件消息");
            }
        });
        customPanel.addEvent(jButton::setText);
        add(jButton);
        add(customPanel);
        setVisible(true);//设置视图
    }
}
