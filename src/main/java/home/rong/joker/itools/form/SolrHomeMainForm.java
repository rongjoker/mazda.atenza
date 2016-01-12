package home.rong.joker.itools.form;

import home.rong.joker.itools.util.YoudaoTransUtil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Set;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import org.com.dms.sms.util.Htmltools;
import org.com.ronger.joker.robot.Core4Machine;

/**
 * @author joker4lr
 * @date:2016-1-7 下午1:33:21
 * @company:kingnets
 * @description
 * @version:0.0.1
 */
public class SolrHomeMainForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6427764995137888042L;

	public JPanel initCenter() {

		JPanel center = new JPanel() {

			private static final long serialVersionUID = 511729269799251518L;

			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("234.jpg"));
				Image image2 = icon.getImage();
				g.drawImage(image2, 0, 0, this.getParent().getWidth(), this.getParent().getHeight(), icon.getImageObserver());

			}

		};

		return center;

	}

	public SolrHomeMainForm() {

		// 在此设置无效，居中显示
		// setLocationRelativeTo(null);

		// this.setIconImage(Toolkit.getDefaultToolkit().createImage("D:/data/icon/start-here.png"));

		this.setIconImage(Toolkit.getDefaultToolkit().createImage(this.getClass().getClassLoader().getResource("start-here.png")));

		setResizable(false);// 固定窗口大小

		SolrMenu menu = new SolrMenu();

		Container jframe = this.getContentPane();

		// JPanel center = new JPanel();

		JPanel center = initCenter();

		// JLabel center = new JLabel();
		// center.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("D:/data/icon/123.png")));

		// center.setOpaque(false);

		// JLabel jlpic = new JLabel();
		// ImageIcon icon = new ImageIcon("D:/data/icon/123.png");
		// icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT));
		// jlpic.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		// jlpic.setHorizontalAlignment(0);
		// jlpic.setIcon(icon);
		// this.add(jlpic);
		// this.pack();

		center.setBackground(Color.BLACK);
		// c.setBackground(Color.GRAY);

		JTabbedPane tab = new JTabbedPane(JTabbedPane.LEFT);

		tab.addTab("翻译工具", new OnePanel());
		// tab.addTab("转换工具", new TwoPanel());

		tab.setPreferredSize(new Dimension(700, 500));// tab的宽度高度
		// tab.setBackground(null);
		tab.setOpaque(false);

		// center.add(tab, BorderLayout.WEST);

		GroupLayout layout_center = new GroupLayout(center);
		center.setLayout(layout_center);

		int tab_width = 700;
		int tab_hight = 500;

		GroupLayout.Group h_group = layout_center.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout_center.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(tab, GroupLayout.PREFERRED_SIZE, tab_width,
						GroupLayout.PREFERRED_SIZE));

		GroupLayout.Group v_group = layout_center.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout_center.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(tab, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, tab_hight,
						GroupLayout.PREFERRED_SIZE));

		layout_center.setHorizontalGroup(h_group);
		layout_center.setVerticalGroup(v_group);
		center.setEnabled(true);

		jframe.add(center);

		this.setJMenuBar(menu);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);// 右上角关闭

		this.addWindowListener(new WindowAdapter() {
			public void WindowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		this.setSize(800, 600);
		this.setMinimumSize(new Dimension(800, 600));// 设置最小窗口
		setTitle("xy.solr编辑器");
		// setUndecorated(true);// 去掉原本的装饰，比如menu
		// setLocation(200, 150);// 设置居中后就无效
		pack();
		setVisible(true);
		show();

	}

	class SolrMenu extends JMenuBar {

		private static final long serialVersionUID = -3133573939793256797L;

		private JDialog aboutDialog;

		public SolrMenu() {

			JMenu fileMenu = new JMenu("文件");
			JMenuItem exitMenuItem = new JMenuItem("退出");
			exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));// ctrl+e退出

			JMenuItem aboutMenuItem = new JMenuItem("帮助");
			aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, KeyEvent.CTRL_MASK));// ctrl+i帮助

			aboutDialog = new JDialog();
			initAboutDialog();

			fileMenu.add(exitMenuItem);
			fileMenu.add(aboutMenuItem);

			this.add(fileMenu);

			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					System.exit(0);
				}
			});

			aboutMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					aboutDialog.show();
				}
			});

		}

		public void initAboutDialog() {
			aboutDialog.setIconImage(Toolkit.getDefaultToolkit().createImage(this.getClass().getClassLoader().getResource("start-here.png")));
			aboutDialog.setTitle("关于");
			Container con = aboutDialog.getContentPane();
			Icon icon = new ImageIcon(this.getClass().getClassLoader().getResource("jpm.gif"));
			JLabel aboutLabel = new JLabel("<html><b><font size=5>" + "<center>工欲善其事必先利其器" + "<br>--  by 邓总的小鹏<br>", icon, JLabel.CENTER);
			con.add(aboutLabel, BorderLayout.CENTER);
			aboutDialog.setSize(450, 225);
			aboutDialog.setLocationRelativeTo(null);
		}

	}

	class OnePanel extends JPanel {

		private static final long serialVersionUID = 1939564196227114527L;

		public OnePanel() {
			// this.setOpaque(false);
			// this.setBackground(Color.GRAY);
			this.setBackground(null);

			final JTextArea textArea = new JTextArea();
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			textArea.setEditable(true);
			textArea.setColumns(20);
			textArea.setRows(10);// 高度10个

			final JTextArea textArea2 = new JTextArea();
			textArea2.setLineWrap(true);
			textArea2.setWrapStyleWord(true);
			textArea2.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			textArea2.setEditable(false);
			textArea.setColumns(20);
			// textArea.setRows(5);

			JScrollPane scroll = new JScrollPane();
			// scroll.setOpaque(false);
			scroll.setViewportView(textArea);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

			JButton button_ze = new JButton("翻译");

			JButton button_url_encode = new JButton("url转码");

			JButton button_url_decode = new JButton("url回码");

			JButton button_uni_encode = new JButton("unicode转码");

			JButton button_uni_decode = new JButton("unicode回码");

			JButton button_json_pretty = new JButton("json格式化");

			// JButton button_out_print = new JButton("输出");

			JButton button_time = new JButton("时间");

			button_ze.setHorizontalAlignment(SwingConstants.CENTER);

			button_url_encode.setHorizontalAlignment(SwingConstants.CENTER);
			button_url_decode.setHorizontalAlignment(SwingConstants.CENTER);
			button_uni_encode.setHorizontalAlignment(SwingConstants.CENTER);
			button_uni_decode.setHorizontalAlignment(SwingConstants.CENTER);
			button_json_pretty.setHorizontalAlignment(SwingConstants.CENTER);
			// button_out_print.setHorizontalAlignment(SwingConstants.CENTER);
			button_time.setHorizontalAlignment(SwingConstants.CENTER);

			button_ze.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String word = textArea.getText();
					textArea2.setText(translationZ_E(word));
				}
			});

			button_json_pretty.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String word = textArea.getText();
					textArea2.setText(Htmltools.jsonFormatter(word));
				}
			});

			button_url_encode.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String word = textArea.getText();

					String result = URLencode(word);

					textArea2.setText(result);
				}
			});

			button_url_decode.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String word = textArea.getText();
					textArea2.setText(URLDecoder.decode(word));
				}
			});

			button_uni_encode.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String word = textArea.getText();
					try {
						textArea2.setText(Htmltools.unicodeFromString(word));
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
			});

			button_uni_decode.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String word = textArea.getText();
					textArea2.setText(Htmltools.unicodeToString(word));

				}
			});

			// button_out_print.addActionListener(new ActionListener() {
			//
			// @Override
			// public void actionPerformed(ActionEvent e) {
			// String word = textArea.getText();
			// System.out.println(1 + 1);
			// textArea2.setText(word);
			//
			// }
			// });

			button_time.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					textArea2.setText(System.currentTimeMillis() + "\n" + Htmltools.dateformatCurrent());
				}
			});

			JScrollPane scroll2 = new JScrollPane();
			scroll2.setViewportView(textArea2);
			scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

			JSplitPane translationPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scroll, scroll2);
			// translationPane.setOpaque(false);
			translationPane.setBackground(Color.YELLOW);
			JPanel pane_right = new JPanel();
			// pane_right.setOpaque(false);
			// pane_right.setBackground(Color.BLUE);
			GroupLayout layout_right = new GroupLayout(pane_right);
			pane_right.setLayout(layout_right);

			button_url_encode.setLayout(new FlowLayout(FlowLayout.LEADING));

			int width = 100;
			// 按钮宽度90
			layout_right.setHorizontalGroup(layout_right.createSequentialGroup().addGroup(
					layout_right.createParallelGroup().addComponent(button_ze, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)

					.addComponent(button_url_encode, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_url_decode, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_uni_encode, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_uni_decode, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_json_pretty, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
							// .addComponent(button_out_print, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_time, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)));

			int padding = 15;

			layout_right.setVerticalGroup(layout_right.createSequentialGroup().addGap(padding)
					.addGroup(layout_right.createParallelGroup().addComponent(button_ze)).addGap(padding)
					.addGroup(layout_right.createParallelGroup().addComponent(button_url_encode)).addGap(padding)
					.addGroup(layout_right.createParallelGroup().addComponent(button_url_decode)).addGap(padding)
					.addGroup(layout_right.createParallelGroup().addComponent(button_uni_encode)).addGap(padding)
					.addGroup(layout_right.createParallelGroup().addComponent(button_uni_decode)).addGap(padding)
					.addGroup(layout_right.createParallelGroup().addComponent(button_json_pretty)).addGap(padding)
					// .addGroup(layout_right.createParallelGroup().addComponent(button_out_print)).addGap(padding)
					.addGroup(layout_right.createParallelGroup().addComponent(button_time))

			);

			GroupLayout layout = new GroupLayout(this);
			this.setLayout(layout);

			GroupLayout.SequentialGroup hvseqGroup1 = layout.createSequentialGroup();

			// 水平左右，左边设置宽度为500
			hvseqGroup1.addGroup(layout.createParallelGroup().addComponent(translationPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
					.addGap(10).addGroup(layout.createParallelGroup().addComponent(pane_right));

			layout.setHorizontalGroup(hvseqGroup1);

			// layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)向上对齐，createParallelGroup构造方法可以设置对齐方式
			layout.setVerticalGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup().addComponent(translationPane).addComponent(pane_right)));

		}
	}

	class TwoPanel extends JPanel {

		private static final long serialVersionUID = -5615249630125650766L;

		public TwoPanel() {

			JLabel label1 = new JLabel("xy.solr快捷登陆");
			JLabel label2 = new JLabel("账号：");
			JLabel label3 = new JLabel("密码：");

			JTextField tf = new JTextField();
			JPasswordField psf = new JPasswordField();
			JCheckBox jcb1 = new JCheckBox("记住密码");
			JCheckBox jcb2 = new JCheckBox("自动登录");

			JButton jbn = new JButton("登录");

			GroupLayout urllayout = new GroupLayout(this);
			this.setLayout(urllayout);

			// 创建GroupLayout的水平连续组，，越先加入的ParallelGroup，优先级级别越高。
			GroupLayout.SequentialGroup hvseqGroup = urllayout.createSequentialGroup();
			hvseqGroup.addGap(5);

			ParallelGroup hpg1 = urllayout.createParallelGroup().addComponent(label2).addComponent(label3);// 并行1

			hvseqGroup.addGroup(hpg1);

			hvseqGroup.addGap(5);

			ParallelGroup hpg2 = urllayout.createParallelGroup().addComponent(label1).addComponent(tf).addComponent(psf).addComponent(jcb1).addComponent(jcb2)
					.addComponent(jbn);// 并行2

			hvseqGroup.addGroup(hpg2);

			urllayout.setHorizontalGroup(hvseqGroup);// 左右两大块

			// 垂直
			GroupLayout.SequentialGroup vseqGroup = urllayout.createSequentialGroup();

			vseqGroup.addGroup(urllayout.createParallelGroup().addComponent(label1));

			vseqGroup.addGap(10);

			vseqGroup.addGroup(urllayout.createParallelGroup().addComponent(label2).addComponent(tf));

			vseqGroup.addGap(5);

			vseqGroup.addGroup(urllayout.createParallelGroup().addComponent(label3).addComponent(psf));

			vseqGroup.addGap(5);

			vseqGroup.addGroup(urllayout.createParallelGroup().addComponent(jcb1));

			vseqGroup.addGap(5);

			vseqGroup.addGroup(urllayout.createParallelGroup().addComponent(jcb2));

			vseqGroup.addGap(5);

			vseqGroup.addGroup(urllayout.createParallelGroup(Alignment.TRAILING).addComponent(jbn));

			urllayout.setVerticalGroup(vseqGroup);

		}

	}

	public String translationZ_E(String word) {

		StringBuilder sb = new StringBuilder();

		Set<String> set = YoudaoTransUtil.translate(word);

		for (String s : set)
			sb.append(s).append("\n");

		return sb.toString();
	}

	public String translationE_Z(String word) {

		StringBuilder sb = new StringBuilder();

		Set<String> set = YoudaoTransUtil.translate(word);

		for (String s : set)
			sb.append(s).append("\n");

		return sb.toString();
	}

	public String URLencode(String url) {

		Core4Machine core = new Core4Machine(url, 3, null);

		return core.buildURL(url);

	}

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

			e.printStackTrace();
		}

		SolrHomeMainForm form = new SolrHomeMainForm();
		form.setLocationRelativeTo(null);// 在main方法下设置才有居中效果

	}

}
