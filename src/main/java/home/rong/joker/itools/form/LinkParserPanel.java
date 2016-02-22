package home.rong.joker.itools.form;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.com.dms.sms.util.Htmltools;

/**
 * @author rongjoker
 * @date:2016年2月19日16:10:27
 * @company:
 * @description
 * @version:0.0.1
 */
public class LinkParserPanel extends JPanel {

	
	private static final long serialVersionUID = 982041324868703578L;
	
	private javax.swing.JButton jButton_delete;
	private javax.swing.JButton jButton_add;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel_original;
	private javax.swing.JLabel jLabel_current;
	private javax.swing.JLabel jLabel_home;
	private javax.swing.JLabel jLabel_follow;
	private javax.swing.JLabel jLabel_param;
	private javax.swing.JPanel jPanelx;
	private javax.swing.JScrollPane jScrollPane_console;
	private javax.swing.JScrollPane jScrollPane_original;
	private javax.swing.JScrollPane jScrollPane_current;
	private javax.swing.JScrollPane jScrollPane_table;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextArea jTextArea_console;
	private javax.swing.JTextArea jTextArea_original;
	private javax.swing.JTextArea jTextArea_current;
	private javax.swing.JTextField jTextField_home;
	private javax.swing.JTextField jTextField_follow;
	

	public LinkParserPanel() {
		JPanel pane_left = new JPanel();
		pane_left.setOpaque(false);
		GroupLayout layout_left = new GroupLayout(pane_left);
		pane_left.setLayout(layout_left);
		pane_left.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		
		int hight_space = 20;
		int width_space = 50;
		int width_text = 200;
		int hight_text = 30;
		int check_space = 20;

		javax.swing.GroupLayout jPanelxLayout = new javax.swing.GroupLayout(pane_left);
		pane_left.setLayout(jPanelxLayout);
		
		
		
		jPanelx = new javax.swing.JPanel();
		jScrollPane_console = new javax.swing.JScrollPane();
		jTextArea_console = new javax.swing.JTextArea();
		jLabel_original = new javax.swing.JLabel();
		jScrollPane_original = new javax.swing.JScrollPane();
		jTextArea_original = new javax.swing.JTextArea();
		jLabel_current = new javax.swing.JLabel();
		jScrollPane_current = new javax.swing.JScrollPane();
		jTextArea_current = new javax.swing.JTextArea();
		jLabel_home = new javax.swing.JLabel();
		jTextField_home = new javax.swing.JTextField();
		jLabel_follow = new javax.swing.JLabel();
		jTextField_follow = new javax.swing.JTextField();
		jLabel_param = new javax.swing.JLabel();
		jScrollPane_table = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jComboBox1 = new javax.swing.JComboBox();
		jButton_delete = new javax.swing.JButton();
		jButton_add = new javax.swing.JButton();
		

		jPanelx.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		
		jTextArea_console.setLineWrap(true);
		jTextArea_console.setWrapStyleWord(true);
		jTextArea_console.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		Font font=new Font("宋体",Font.PLAIN,12);
		jTextArea_console.setFont(font);

		jScrollPane_console.setViewportView(jTextArea_console);

		jLabel_original.setText("旧链：");

		jTextArea_original.setColumns(20);
		jTextArea_original.setRows(2);
		jTextArea_original.setText("http://42.62.58.80:8686/xy.solr/applist/query?q=%E5%85%A8%E6%B0%91%E5%A5%87%E8%BF%B9&fl=*&facet=true&facet.field=first_class_id&wt=json&defType=edismax&qf=title^3+yy_keyword^0.8+cus_keyword^0.2&bf=div%28downloadnum,100000%29&start=0&rows=20");
		jTextArea_original.setLineWrap(true);
		jTextArea_original.setWrapStyleWord(true);
		jTextArea_original.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		jScrollPane_original.setViewportView(jTextArea_original);

		jLabel_current.setText("新链：");

		jTextArea_current.setColumns(20);
		jTextArea_current.setRows(2);
		jTextArea_current.setText("");
		jTextArea_current.setLineWrap(true);
		jTextArea_current.setWrapStyleWord(true);
		jTextArea_current.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		jScrollPane_current.setViewportView(jTextArea_current);

		jLabel_home.setText("前缀：");

		jTextField_home.setText("http://42.62.58.80:8686/");

		jLabel_follow.setText("后缀：");

		jTextField_follow.setText("xy.solr/applist/query");

		jLabel_param.setText("参数：");
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		 tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
		jTable1.setDefaultRenderer(Object.class, tcr);
		
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) jTable1.getTableHeader()  
                .getDefaultRenderer();
		
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);//列名居中
		
		jTable1.setRowHeight(30);
		jTable1.getTableHeader().setReorderingAllowed(false);
		
		Vector<String>  vName = new Vector<String>();
		vName.add("name");
		vName.add("value");
		
		
		Vector<Vector<String>>  vData = new Vector<Vector<String>>();
		Vector<String> vRow = new Vector<String>();
		vRow.add("asd");
		vRow.add("asd2");
		vData.add(vRow);
		vData.add((Vector<String>)vRow.clone());
		
		
		DefaultTableModel model = new DefaultTableModel(vData, vName);
		jTable1.setModel(model);
		jScrollPane_table.setViewportView(jTable1);
		
//		jTable1.getTableHeader().getColumnModel().getColumn(0)
		
		
		jTable1.getTableHeader().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				 if (e.getClickCount() == 2) {
					 logth("双击!");
					 
//					 JTableHeader _table = (JTableHeader)e.getSource();
					 
					 
					 
					}
				
			}
		}
				
				
				);
		
		
		

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		jButton_delete.setText("删除");
		jButton_add.setText("增加");

		jPanelx.setLayout(jPanelxLayout);
		
		
		jPanelxLayout.setHorizontalGroup(jPanelxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanelxLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								jPanelxLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane_console, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400,
												Short.MAX_VALUE)
										.addGroup(
												jPanelxLayout
														.createSequentialGroup()
														.addComponent(jLabel_home)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 135,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(28, 28, 28)
														.addComponent(jButton_delete)
														.addGap(18, 18, 18)
														.addComponent(jTextField_home, javax.swing.GroupLayout.PREFERRED_SIZE, 97,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton_add))
										.addGroup(
												jPanelxLayout.createSequentialGroup().addComponent(jLabel_original)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jScrollPane_original, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
										.addGroup(
												jPanelxLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																jPanelxLayout.createSequentialGroup().addComponent(jLabel_follow)
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jTextField_follow))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																jPanelxLayout
																		.createSequentialGroup()
																		.addGroup(
																				jPanelxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(jLabel_current).addComponent(jLabel_param))
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanelxLayout
																						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(jScrollPane_current, javax.swing.GroupLayout.DEFAULT_SIZE, 600,
																								Short.MAX_VALUE)
																						.addComponent(jScrollPane_table, javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))).addContainerGap()));
		jPanelxLayout.setVerticalGroup(jPanelxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanelxLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								jPanelxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel_original)
										.addComponent(jScrollPane_original, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								jPanelxLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel_home)
										.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jButton_delete)
										.addComponent(jTextField_home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jButton_add))
						.addGap(18, 18, 18)
						.addGroup(
								jPanelxLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel_follow)
										.addComponent(jTextField_follow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(
								jPanelxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel_param)
										.addComponent(jScrollPane_table, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(
								jPanelxLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanelxLayout.createSequentialGroup().addGap(51, 51, 51).addComponent(jLabel_current))
										.addGroup(
												jPanelxLayout
														.createSequentialGroup()
														.addGap(40, 40, 40)
														.addComponent(jScrollPane_current, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
						.addComponent(jScrollPane_console, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));

		

		JPanel pane_right = new JPanel();
		GroupLayout layout_right = new GroupLayout(pane_right);
		pane_right.setLayout(layout_right);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);

		GroupLayout.SequentialGroup hvseqGroup1 = layout.createSequentialGroup();

		// 水平左右，左边设置宽度为500
		hvseqGroup1.addGroup(layout.createParallelGroup().addComponent(pane_left, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE)).addGap(10)
				.addGroup(layout.createParallelGroup().addComponent(pane_right));

		layout.setHorizontalGroup(hvseqGroup1);

		// layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)向上对齐，createParallelGroup构造方法可以设置对齐方式
		layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup().addComponent(pane_left).addComponent(pane_right)));

		JButton button_build = new JButton("组合");
		JButton button_debug = new JButton("调试");
		JButton button_clear = new JButton("清理");
		JButton button_export = new JButton("导出");
		
		
		button_debug.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				logth("测试");

			}
		});

		button_clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jTextArea_console.setText("");

			}
		});

		int width = 100;// 按钮宽度90

		layout_right.setHorizontalGroup(layout_right.createSequentialGroup().addGroup(
				layout_right.createParallelGroup().addComponent(button_build, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_debug, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_clear, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_export, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
				));

		int padding = 15;

		layout_right.setVerticalGroup(layout_right.createSequentialGroup().addGap(padding)
				.addGroup(layout_right.createParallelGroup().addComponent(button_build)).addGap(padding)
				.addGroup(layout_right.createParallelGroup().addComponent(button_debug)).addGap(padding)
				.addGroup(layout_right.createParallelGroup().addComponent(button_clear)).addGap(padding)
				.addGroup(layout_right.createParallelGroup().addComponent(button_export))
				);

	}

	public String logth(String text) {
		
		jTextArea_console.append(Htmltools.dateformatCurrent() + " " + text + "\n");
		
		return Htmltools.dateformatCurrent() + " " + text + "\n";

	}

}
