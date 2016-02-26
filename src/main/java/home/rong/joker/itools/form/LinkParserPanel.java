package home.rong.joker.itools.form;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import org.com.dms.sms.bean.CrawlElement;
import org.com.dms.sms.read.PropertyReader;
import org.com.dms.sms.util.Htmltools;
import org.com.ronger.joker.robot.AbstractMachine;
import org.com.ronger.joker.robot.Core4Machine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

/**
 * @author rongjoker
 * @date:2016年2月19日16:10:27
 * @company:
 * @description
 * @version:0.0.1
 */
public class LinkParserPanel extends JPanel {
	
	private Logger LOG = LoggerFactory.getLogger(getClass());

	
	private static final long serialVersionUID = 982041324868703578L;
	
	private javax.swing.JButton jButton_delete;
	private javax.swing.JButton jButton_add;
	private javax.swing.JComboBox<String> jComboBox1;
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
	
	private javax.swing.JButton jButton_table_add;
	private javax.swing.JButton jButton_table_delete;
	private DefaultTableModel model;
	private final Vector<String>  homenames;
	String properties = null;
	
	
	public void rebuildTable(Vector<Vector<String>> vData,Vector<String> vName){
		
		model = new DefaultTableModel( vData,vName);
		jTable1.setModel(model);
		
		TableColumn firsetColumn = jTable1.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(150);
		firsetColumn.setMaxWidth(150);
		firsetColumn.setMinWidth(150);
		
		jTable1.repaint();
		jTable1.updateUI();
		
	}
	
	
	public void rebuildComboBox(){
		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<String>(homenames));
		jComboBox1.repaint();
		jComboBox1.updateUI();
		
		String value = Joiner.on(",").join(homenames);
		
		PropertyReader reader = new PropertyReader(properties);
		reader.writeValue("home.path", value);
	}
	

	public LinkParserPanel() {
		JPanel pane_left = new JPanel();
		pane_left.setOpaque(false);
		GroupLayout layout_left = new GroupLayout(pane_left);
		pane_left.setLayout(layout_left);
		pane_left.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		
		int width_text = 250;
		int width_home = 250;
		int width_table = 580;
		int width_button = 60;
		int width_original_jTextArea = 60;
		
		int width_spit = 10;
		
		int height_spit = 20;
		int height_original = 60;
		int height_text = 30;
		int height_table = 150;
		
		properties = this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile() + File.separator + "axela.properties";
		
		if(!new File(properties).exists()){
			properties = "axela.properties";
		}
		
		PropertyReader reader = new PropertyReader(properties);
		String home_path = reader.readValue("home.path","http://127.0.0.1:8686/");
		

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
		jComboBox1 = new javax.swing.JComboBox<String>();
		jButton_delete = new javax.swing.JButton();
		jButton_add = new javax.swing.JButton();
		jButton_table_add = new javax.swing.JButton();
		jButton_table_delete = new javax.swing.JButton();
		

		jPanelx.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		
		jTextArea_console.setLineWrap(true);
		jTextArea_console.setWrapStyleWord(true);
		jTextArea_console.setCursor(new Cursor(Cursor.TEXT_CURSOR));
		

		jScrollPane_console.setViewportView(jTextArea_console);

		jLabel_original.setText("旧链：");

		jTextArea_original.setColumns(20);
		jTextArea_original.setRows(3);
		Font font=new java.awt.Font("Monospaced", 0, 12);
		jTextArea_original.setFont(font);
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
		jTextArea_current.setEditable(false);

		jLabel_home.setText("前缀：");

		homenames = new Vector<String>();
		
		Iterable<String> _homenames = Splitter.on(",").split(home_path);
		for(String _homename:_homenames)
			homenames.add(_homename);
		
		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<String>(homenames));
		
		jButton_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				homenames.remove(jComboBox1.getSelectedIndex());
				rebuildComboBox();
//				jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<String>(homenames));
//				jComboBox1.repaint();
//				jComboBox1.updateUI();
				
			}
		});
		
		
		jButton_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String _home = jTextField_home.getText();
				homenames.add(0, _home);
				rebuildComboBox();
//				jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<String>(homenames));
//				jComboBox1.repaint();
//				jComboBox1.updateUI();
				
			}
		});
		
		
		

		jLabel_follow.setText("后缀：");
		jLabel_param.setText("参数：");
		
		jButton_table_add.setText("+");
		jButton_table_delete.setText("-");
		
		
		//jTable1
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		 tcr.setHorizontalAlignment(SwingConstants.CENTER);// 设置table内容居中
		jTable1.setDefaultRenderer(Object.class, tcr);
		
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) jTable1.getTableHeader()  
                .getDefaultRenderer();
		
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);//列名居中
		
		jTable1.setRowHeight(30);
		jTable1.getTableHeader().setReorderingAllowed(false);
		
		final Vector<String>  vName = new Vector<String>();
		vName.add("name");
		vName.add("value");
		
		final Vector<Vector<String>>  vData = new Vector<Vector<String>>();
		
//		model = new DefaultTableModel( tableVales,columnNames);
		model = new DefaultTableModel( vData,vName);
		jTable1.setModel(model);
		jTable1.setDefaultEditor(Object.class, new ColorEditor());
		jScrollPane_table.setViewportView(jTable1);
		
		
		jButton_table_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//防止编辑丢失
				if(jTable1.isEditing()){
					jTable1.getCellEditor().stopCellEditing();
				}
				
				Vector<String> rowData = new Vector<String>();
				rowData.add("");
				rowData.add("");
				
				vData.add(rowData);
				rebuildTable(vData, vName);
				
			}
		});
		
		jButton_table_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 int selectedRow = jTable1.getSelectedRow();//获得选中行的索引
	                if(selectedRow!=-1)  //存在选中行
	                {
	                	vData.remove(selectedRow);
	                	rebuildTable(vData, vName);
	                }
			}
		});

		jButton_delete.setText("删除");
		jButton_add.setText("增加");

		jPanelx.setLayout(jPanelxLayout);
		
		GroupLayout.SequentialGroup hGroup = jPanelxLayout.createSequentialGroup();
		
		GroupLayout.ParallelGroup left_pad = jPanelxLayout.createParallelGroup();
		left_pad.addComponent(jLabel_original).addComponent(jLabel_home).addComponent(jLabel_follow).addComponent(jLabel_param).addComponent(jLabel_current);

//		
		hGroup.addGap(width_spit);
//		
		GroupLayout.ParallelGroup right_pad = jPanelxLayout.createParallelGroup();
		right_pad.addComponent(jScrollPane_original);
		right_pad.addGroup(jPanelxLayout.createSequentialGroup()
				.addComponent(jComboBox1,javax.swing.GroupLayout.PREFERRED_SIZE, width_home, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(width_spit)
				.addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, width_button, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(width_spit)
				.addComponent(jTextField_home, javax.swing.GroupLayout.PREFERRED_SIZE, width_text, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(width_spit)
				.addComponent(jButton_add, javax.swing.GroupLayout.PREFERRED_SIZE, width_button, javax.swing.GroupLayout.PREFERRED_SIZE));
		
		right_pad.addComponent(jTextField_follow, javax.swing.GroupLayout.PREFERRED_SIZE, width_table, javax.swing.GroupLayout.PREFERRED_SIZE);
		right_pad.addGroup(jPanelxLayout.createSequentialGroup().addComponent(jScrollPane_table, javax.swing.GroupLayout.PREFERRED_SIZE, width_table, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(width_spit)
				.addGroup(jPanelxLayout.createParallelGroup().addComponent(jButton_table_add, javax.swing.GroupLayout.PREFERRED_SIZE, width_button, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jButton_table_delete, javax.swing.GroupLayout.PREFERRED_SIZE, width_button, javax.swing.GroupLayout.PREFERRED_SIZE)));
		right_pad.addComponent(jScrollPane_current);

		
		hGroup.addGroup(left_pad);
		hGroup.addGroup(right_pad);
		jPanelxLayout.setHorizontalGroup(
				jPanelxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						jPanelxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane_console).addGroup(hGroup))
				);
		
		
		GroupLayout.SequentialGroup vGroup = jPanelxLayout.createSequentialGroup();
//		
		GroupLayout.ParallelGroup original_pad = jPanelxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE);
		original_pad.addComponent(jLabel_original).addComponent(jScrollPane_original, javax.swing.GroupLayout.PREFERRED_SIZE, height_original,
				javax.swing.GroupLayout.PREFERRED_SIZE);
//		
		GroupLayout.ParallelGroup home_pad = jPanelxLayout.createParallelGroup();
		home_pad.addComponent(jLabel_home)
		.addGroup(jPanelxLayout.createParallelGroup().addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, height_text,
				javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(jButton_delete)
				.addComponent(jTextField_home, javax.swing.GroupLayout.PREFERRED_SIZE, height_text,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(jButton_add));
//		
//		
		GroupLayout.ParallelGroup follow_pad = jPanelxLayout.createParallelGroup();
		follow_pad.addComponent(jLabel_follow).addComponent(jTextField_follow, javax.swing.GroupLayout.PREFERRED_SIZE, height_text,
				javax.swing.GroupLayout.PREFERRED_SIZE);
//		
//		
		GroupLayout.ParallelGroup table_pad = jPanelxLayout.createParallelGroup();
		table_pad.addGroup(jPanelxLayout.createSequentialGroup().addGroup(jPanelxLayout.createParallelGroup().addComponent(jLabel_param)
				.addComponent(jScrollPane_table, javax.swing.GroupLayout.PREFERRED_SIZE, height_table,
						javax.swing.GroupLayout.PREFERRED_SIZE)));
		table_pad.addGroup(jPanelxLayout.createSequentialGroup().addGap(javax.swing.GroupLayout.PREFERRED_SIZE, height_spit, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jButton_table_add).
				addGap(javax.swing.GroupLayout.PREFERRED_SIZE, height_spit, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jButton_table_delete));
		
//		
		GroupLayout.ParallelGroup current_pad = jPanelxLayout.createParallelGroup();
		current_pad.addComponent(jLabel_current).addComponent(jScrollPane_current, javax.swing.GroupLayout.PREFERRED_SIZE, height_original,
				javax.swing.GroupLayout.PREFERRED_SIZE);
//		
		vGroup.addGroup(original_pad).addGap(height_spit);
		vGroup.addGroup(home_pad).addGap(height_spit);
		vGroup.addGroup(follow_pad).addGap(height_spit);
		vGroup.addGroup(table_pad).addGap(height_spit);
		vGroup.addGroup(current_pad).addGap(height_spit);
		vGroup.addComponent(jScrollPane_console);
//		
//		
		jPanelxLayout.setVerticalGroup(jPanelxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(vGroup));
		
		
		JPanel pane_right = new JPanel();
		GroupLayout layout_right = new GroupLayout(pane_right);
		pane_right.setLayout(layout_right);

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);

		GroupLayout.SequentialGroup hvseqGroup1 = layout.createSequentialGroup();

		// 水平左右，左边设置宽度为
		hvseqGroup1.addGroup(layout.createParallelGroup().addComponent(pane_left, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE)).addGap(10)
				.addGroup(layout.createParallelGroup().addComponent(pane_right));

		layout.setHorizontalGroup(hvseqGroup1);

		// layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)向上对齐，createParallelGroup构造方法可以设置对齐方式
		layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup().addComponent(pane_left).addComponent(pane_right)));

		JButton button_parser = new JButton("解析");
		JButton button_build = new JButton("组合");
		JButton button_debug = new JButton("执行");
		JButton button_clear = new JButton("清理");
		JButton button_export = new JButton("导出");
		
		
		button_parser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					URL original_url = new URL(jTextArea_original.getText());
					
					jTextField_home.setText(original_url.getProtocol()+"://"+original_url.getAuthority()+"/");
					jTextField_follow.setText(original_url.getPath());
					
					Map<String,String> param_map = Htmltools.getAttrs(original_url.getQuery());
					
					Iterator<Entry<String, String>> its = param_map.entrySet().iterator();
					vData.clear();
					while(its.hasNext()){
						Entry<String, String> entry = its.next();
						Vector<String> vRow = new Vector<String>();
						String rkey = entry.getKey();
						String rval = entry.getValue();
						String unival = Htmltools.URLDecoder(rval);
//						if(rkey.equals("q") || rkey.equals("fq")){
//							if(!Htmltools.processconChinese(rval) && Htmltools.processconChinese(unival) ){
//								rval = unival;
//							}
//							
//						}
						
						vRow.add(rkey);
						vRow.add(unival);
						vData.add(vRow);
					}
					
					rebuildTable(vData, vName);
					
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} 
				
				
				
				

			}
		});
		
		button_build.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				
				logth("组合！");

				try {
					
		
				//防止编辑丢失
				if(jTable1.isEditing()){
					jTable1.getCellEditor().stopCellEditing();
				}
				
				StringBuilder sbr = new StringBuilder();
				
				sbr.append(jComboBox1.getSelectedItem()).append(jTextField_follow.getText());
				LOG.info(sbr.toString());
				Map<String,String> param_map = new HashMap<String,String>();
				
				for(Vector<String> vRow:vData){
					param_map.put(vRow.get(0), vRow.get(1));
				}
				LOG.info("param_map:{}",param_map);
				try {
					logth(Htmltools.getAttrstring(param_map));
					sbr.append("?").append(Htmltools.getAttrstring(param_map));
				} catch (Exception e1) {
					LOG.error("error:{}",e1);
				}
				
				LOG.info(sbr.toString());
				
				jTextArea_current.setText(sbr.toString());
				logth(sbr.toString());
				LOG.info(jTextArea_current.getText());
				} catch (Exception e2) {
					LOG.error("error:{}",e2);
				}
			}
		});
		
		
		button_debug.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String url = jTextArea_current.getText();
				
				AbstractMachine core = new Core4Machine(url, 3, null);
				CrawlElement element = core.execute();
				jTextArea_console.setText(Htmltools.jsonFormatter(element.getHtmlCode()));


			}
		});

		button_clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jTextArea_console.setText("");

			}
		});

		int width = 100;// 按钮宽度90
		//button_parser
		layout_right.setHorizontalGroup(layout_right.createSequentialGroup().addGroup(
				layout_right.createParallelGroup().addComponent(button_parser, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_build, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_debug, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_clear, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_export, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
				));

		int padding = 15;

		layout_right.setVerticalGroup(layout_right.createSequentialGroup().addGap(padding)
				.addGroup(layout_right.createParallelGroup().addComponent(button_parser)).addGap(padding)
				.addGroup(layout_right.createParallelGroup().addComponent(button_build)).addGap(padding)
				.addGroup(layout_right.createParallelGroup().addComponent(button_debug)).addGap(padding)
				.addGroup(layout_right.createParallelGroup().addComponent(button_clear)).addGap(padding)
				.addGroup(layout_right.createParallelGroup().addComponent(button_export))
				);

	}
	
	class ColorEditor extends AbstractCellEditor implements TableCellEditor,  
    ActionListener{
		
		private Component currentEditorComp = null;
		private JTextField tf = new JTextField();

		@Override
		public Object getCellEditorValue() {
			return tf.getText();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			
			tf.setHorizontalAlignment(JTextField.CENTER);
			tf.setText(value == null ? "" : value.toString());
			
			currentEditorComp = tf;
			
			return currentEditorComp;
		}
		
		
		
		
	}
	
	

	public String logth(String text) {
		
		jTextArea_console.append(Htmltools.dateformatCurrent() + " " + text + "\n");
		
		return Htmltools.dateformatCurrent() + " " + text + "\n";

	}

}
