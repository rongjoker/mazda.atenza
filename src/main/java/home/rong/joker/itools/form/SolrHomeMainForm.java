package home.rong.joker.itools.form;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.DesertBluer;

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

		JTabbedPane tab = new JTabbedPane(JTabbedPane.LEFT);
		tab.setOpaque(false);
		// tab.setBackground(new Color(255, 255, 255, 100));

		tab.addTab("语言工具", new TranslationPanel());
		tab.addTab("文件工具", new SystemFilePanel());
		tab.addTab("链接工具", new LinkParserPanel());

		tab.setPreferredSize(new Dimension(1000, 700));// tab的宽度高度
		// tab.setBackground(null);

		// center.add(tab, BorderLayout.WEST);

		GroupLayout layout_center = new GroupLayout(center);
		center.setLayout(layout_center);

		int tab_width = 1000;
		int tab_hight = 700;

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
		this.setSize(1080, 800);
		this.setMinimumSize(new Dimension(1080, 800));// 设置最小窗口
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

	public static void main(String[] args) {
		
		PlasticLookAndFeel.setPlasticTheme(new DesertBluer());//设置主题

		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			 //设置观感
            UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
            //UIManager.setLookAndFeel("com.jgoodies.looks.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticLookAndFeel");
            //UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
            //UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
//            SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {

			e.printStackTrace();
		}

		SolrHomeMainForm form = new SolrHomeMainForm();
		form.setLocationRelativeTo(null);// 在main方法下设置才有居中效果

	}

}
