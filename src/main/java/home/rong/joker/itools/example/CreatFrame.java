package home.rong.joker.itools.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author joker4lr
 * @date:2016-1-11 下午1:58:13
 * @company:
 * @description
 * @version:0.0.1
 */
public class CreatFrame {
	JLabel label1 = new JLabel("考试系统", JLabel.CENTER);
	JTextField textfield2 = new JTextField("请输入姓名");
	JTextField textfield1 = new JTextField("请输入密码");
	JButton button1 = new JButton("确定");

	public static void main(String[] args) {
		CreatFrame cf = new CreatFrame();
		cf.creatframe();
	}

	@SuppressWarnings("serial")
	private void creatframe() {
		final JFrame frame = new JFrame("登陆界面");
		JLabel label2 = new JLabel("姓名");
		JLabel label3 = new JLabel("密码");
		JButton button2 = new JButton("取消");
		JButton button3 = new JButton("考生必看");
		button1.setEnabled(false);
		// 方法一：
		// JPanel panel6 = new JPanel() {
		// public void paint(Graphics g) {
		// // 下面是取得你的背景图片,你根据你自己的要求来取得这个图片,不管什么方法，得到就OK
		// ImageIcon icon =
		// new
		// ImageIcon(ClassLoader.getSystemResource("2009517719856277802.jpg"));
		// icon.paintIcon(frame, g, 0, 0);
		// // 最后调用父方法，否则重画背景时会把label覆盖住
		// super.paint(g);
		// }
		// };
		// 方法二：
		JPanel panel6 = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("D:/data/icon/123.png");
				// 图片随窗体大小而变化
				g.drawImage(icon.getImage(), 0, 0, frame.getSize().width, frame.getSize().height, frame);
			}
		};
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		panel2.setLayout(new GridLayout(2, 1));
		panel1.add(label2);
		panel3.add(label3);
		panel3.add(textfield1);
		panel1.add(textfield2);
		panel6.setLayout(new BorderLayout());
		// panel必须设置成透明
		panel6.setOpaque(false);
		// 改变字体颜色
		label1.setForeground(Color.red);
		panel6.add(label1);
		panel4.add(button1);
		panel4.add(button2);
		panel4.add(button3);
		panel2.add(panel1);
		panel2.add(panel3);
		frame.add(panel6, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.CENTER);
		frame.add(panel4, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setSize(300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);
	}
}
