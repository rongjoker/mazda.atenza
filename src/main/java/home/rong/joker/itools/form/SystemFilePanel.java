package home.rong.joker.itools.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * @author rongjoker
 * @date:2016-1-13 下午6:10:50
 * @company:
 * @description
 * @version:0.0.1
 */
public class SystemFilePanel extends JPanel {

	private static final long serialVersionUID = -3475503574253137734L;

	public SystemFilePanel() {
		this.setOpaque(false);

		JPanel pane_left = new JPanel();
		// pane_left.setBackground(Color.BLACK);
		pane_left.setOpaque(false);
		GroupLayout layout_left = new GroupLayout(pane_left);
		pane_left.setLayout(layout_left);

		JPanel pane_right = new JPanel();
		GroupLayout layout_right = new GroupLayout(pane_right);
		pane_right.setLayout(layout_right);

		JLabel label1 = new JLabel("xy.solr快捷登陆");
		JLabel label2 = new JLabel("账号：");
		JLabel label3 = new JLabel("密码：");

		JTextField tf = new JTextField();
		JPasswordField psf = new JPasswordField();
		JCheckBox jcb1 = new JCheckBox("记住密码");
		JCheckBox jcb2 = new JCheckBox("自动登录");

		// JButton jbn = new JButton("登录");

		final JProgressBar pb = new JProgressBar();

		pb.setPreferredSize(new Dimension(280, 20));
		Timer time = new Timer(1000, new ActionListener() {
			int counter = 0;

			public void actionPerformed(ActionEvent e) {
				counter++;
				pb.setValue(counter);
				Timer t = (Timer) e.getSource();
				if (counter == pb.getMaximum()) {
					t.stop();
					counter = 0;
					t.start();
				}
			}
		});
		time.start();
		pb.setStringPainted(true);
		pb.setMinimum(0);
		pb.setMaximum(1000);
		pb.setBackground(Color.white);
		pb.setForeground(Color.red);
		pb.disable();

		// 创建GroupLayout的水平连续组，，越先加入的ParallelGroup，优先级级别越高。
		GroupLayout.SequentialGroup hvseqGroup = layout_left.createSequentialGroup();
		hvseqGroup.addGap(5);

		ParallelGroup hpg1 = layout_left.createParallelGroup().addComponent(label2).addComponent(label3);// 并行1

		hvseqGroup.addGroup(hpg1);

		hvseqGroup.addGap(5);

		ParallelGroup hpg2 = layout_left.createParallelGroup().addComponent(label1).addComponent(tf).addComponent(psf).addComponent(jcb1).addComponent(jcb2)
				.addComponent(pb);// 并行2

		hvseqGroup.addGroup(hpg2);

		layout_left.setHorizontalGroup(hvseqGroup);// 左右两大块

		// 垂直
		GroupLayout.SequentialGroup vseqGroup = layout_left.createSequentialGroup();

		vseqGroup.addGroup(layout_left.createParallelGroup().addComponent(label1));

		vseqGroup.addGap(10);

		vseqGroup.addGroup(layout_left.createParallelGroup().addComponent(label2).addComponent(tf));

		vseqGroup.addGap(5);

		vseqGroup.addGroup(layout_left.createParallelGroup().addComponent(label3).addComponent(psf));

		vseqGroup.addGap(5);

		vseqGroup.addGroup(layout_left.createParallelGroup().addComponent(jcb1));

		vseqGroup.addGap(5);

		vseqGroup.addGroup(layout_left.createParallelGroup().addComponent(jcb2));

		vseqGroup.addGap(5);

		vseqGroup.addGroup(layout_left.createParallelGroup(Alignment.TRAILING).addComponent(pb));

		layout_left.setVerticalGroup(vseqGroup);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);

		GroupLayout.SequentialGroup hvseqGroup1 = layout.createSequentialGroup();

		// 水平左右，左边设置宽度为500
		hvseqGroup1.addGroup(layout.createParallelGroup().addComponent(pane_left, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)).addGap(10)
				.addGroup(layout.createParallelGroup().addComponent(pane_right));

		layout.setHorizontalGroup(hvseqGroup1);

		// layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)向上对齐，createParallelGroup构造方法可以设置对齐方式
		layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup().addComponent(pane_left).addComponent(pane_right)));

	}

}
