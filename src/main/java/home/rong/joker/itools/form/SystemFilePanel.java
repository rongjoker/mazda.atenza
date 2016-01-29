package home.rong.joker.itools.form;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;

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
		// this.setOpaque(false);

		JPanel pane_left = new JPanel();
		// pane_left.setBackground(Color.BLACK);
		pane_left.setOpaque(false);
		GroupLayout layout_left = new GroupLayout(pane_left);
		pane_left.setLayout(layout_left);

		JPanel pane_right = new JPanel();
		GroupLayout layout_right = new GroupLayout(pane_right);
		pane_right.setLayout(layout_right);

		JLabel label1 = new JLabel("xy.solr快捷登陆");
		JLabel label2 = new JLabel("目录：");
		JLabel label3 = new JLabel("密码：");

		JPasswordField psf = new JPasswordField();
		JCheckBox jcb1 = new JCheckBox("记住密码");
		JCheckBox jcb2 = new JCheckBox("自动登录");

		JTextField jt = new JTextField("文本域，点击打开<文件按钮>可选择文件");
		JTextPane textPane = new JTextPane();
		textPane.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		textPane.setText("编辑器，试着点击文本区，试着拉动分隔条。");

		textPane.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				JTextPane textPane = (JTextPane) e.getSource();
				textPane.setText("编辑器点击命令成功");
			}
		});
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jt, textPane);

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
		// pb.setMaximum(1000);
		pb.setBackground(Color.white);
		pb.setForeground(Color.red);
		pb.disable();

		// 创建GroupLayout的水平连续组，，越先加入的ParallelGroup，优先级级别越高。
		GroupLayout.SequentialGroup hvseqGroup = layout_left.createSequentialGroup();
		hvseqGroup.addGap(5);

		ParallelGroup hpg1 = layout_left.createParallelGroup().addComponent(label2).addComponent(label3);// 并行1

		hvseqGroup.addGroup(hpg1);

		hvseqGroup.addGap(5);

		ParallelGroup hpg2 = layout_left.createParallelGroup().addComponent(label1).addComponent(jt).addComponent(psf).addComponent(jcb1).addComponent(jcb2)
				.addComponent(pb);// 并行2

		hvseqGroup.addGroup(hpg2);

		layout_left.setHorizontalGroup(hvseqGroup);// 左右两大块

		// 垂直
		GroupLayout.SequentialGroup vseqGroup = layout_left.createSequentialGroup();

		vseqGroup.addGroup(layout_left.createParallelGroup().addComponent(label1));

		vseqGroup.addGap(10);

		vseqGroup.addGroup(layout_left.createParallelGroup().addComponent(label2).addComponent(jt));

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

		JButton button_delete = new JButton("删除");
		JButton button_test = new JButton("测试");

		button_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(chooser);

				int resule = chooser.showOpenDialog(new JPanel());
				if (resule == chooser.APPROVE_OPTION) {
					String fileName = chooser.getSelectedFile().getName();
					// String dir = chooser.getSelectedFile().getName();
					System.out.println(fileName);
					// JOptionPane.showConfirmDialog(null, dir + "\\" + fileName, "选择的文件", JOptionPane.YES_OPTION);
				}

			}
		});

		int width = 100;// 按钮宽度90

		layout_right.setHorizontalGroup(layout_right.createSequentialGroup().addGroup(
				layout_right.createParallelGroup().addComponent(button_delete, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_test, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)));

		int padding = 15;

		layout_right.setVerticalGroup(layout_right.createSequentialGroup().addGap(padding)
				.addGroup(layout_right.createParallelGroup().addComponent(button_delete)).addGap(padding)
				.addGroup(layout_right.createParallelGroup().addComponent(button_test)));

	}

}
