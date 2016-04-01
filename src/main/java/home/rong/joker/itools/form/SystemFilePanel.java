package home.rong.joker.itools.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.com.dms.sms.util.DeleteUtils;
import org.com.dms.sms.util.Htmltools;

/**
 * @author rongjoker
 * @date:2016-1-13 下午6:10:50
 * @company:
 * @description
 * @version:0.0.1
 */
public class SystemFilePanel extends JPanel {

	private static final long serialVersionUID = -3475503574253137734L;
	
	
	JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
	JLabel jLabel_path = new javax.swing.JLabel();
	final JTextArea jTextArea1 = new javax.swing.JTextArea();
	final JTextField jTextField_path = new javax.swing.JTextField();
	JButton button_chooese = new javax.swing.JButton();
	JLabel jLabel_isinclude = new javax.swing.JLabel();
	
	final ButtonGroup bg = new ButtonGroup();
	final JRadioButton jRadioButton1 = new javax.swing.JRadioButton();
	final JRadioButton jRadioButton2 = new javax.swing.JRadioButton();
	final JCheckBox jCheckBox_deleteSelf = new javax.swing.JCheckBox();
	JLabel jLabel_prefix = new javax.swing.JLabel();
	final JTextField jTextField_prefix = new javax.swing.JTextField();
	JLabel jLabel_suffix = new javax.swing.JLabel();
	final JTextField jTextField_suffix = new javax.swing.JTextField();
	JLabel jLabel_name = new javax.swing.JLabel();
	final JTextField jTextField_name = new javax.swing.JTextField();
	
	final ButtonGroup bg_check = new ButtonGroup();
	final JCheckBox jCheckBox_prefix = new javax.swing.JCheckBox();
	final JCheckBox jCheckBox_suffix = new javax.swing.JCheckBox();
	final JCheckBox jCheckBox_name = new javax.swing.JCheckBox();
	

	public SystemFilePanel() {
		// this.setOpaque(false);

		JPanel pane_left = new JPanel();
		// pane_left.setBackground(Color.BLACK);
		pane_left.setOpaque(false);
		GroupLayout layout_left = new GroupLayout(pane_left);
		pane_left.setLayout(layout_left);
		pane_left.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		
		jLabel_path.setText("目录：");
		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);
		jTextField_path.setText("E:/test/tt2");
		button_chooese.setText("选择");

		jLabel_isinclude.setText("限制：");
		jRadioButton1.setText("包含条件");
		jRadioButton2.setText("排除条件");
		jRadioButton1.setSelected(true);
		bg.add(jRadioButton1);
		bg.add(jRadioButton2);
		
		jCheckBox_deleteSelf.setText("是否删除选中的文件夹本身");

		jLabel_prefix.setText("前缀：");
		jTextField_prefix.setText("");
		jLabel_suffix.setText("后缀：");
		jTextField_suffix.setText("");
		jLabel_name.setText("名称：");
		jTextField_name.setText("");
		
		jCheckBox_suffix.setSelected(true);
		bg_check.add(jCheckBox_prefix);
		bg_check.add(jCheckBox_suffix);
		bg_check.add(jCheckBox_name);

		int hight_space = 20;
		int width_space = 50;
		int width_text = 200;
		int hight_text = 30;
		int check_space = 20;

		javax.swing.GroupLayout jPanelxLayout = new javax.swing.GroupLayout(pane_left);
		pane_left.setLayout(jPanelxLayout);
		jPanelxLayout.setHorizontalGroup(jPanelxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanelxLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								jPanelxLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jCheckBox_deleteSelf)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
										.addGroup(
												jPanelxLayout
														.createSequentialGroup()
														.addComponent(jLabel_path)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jTextField_path, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
																javax.swing.GroupLayout.PREFERRED_SIZE).addGap(width_space).addComponent(button_chooese))
										.addGroup(
												jPanelxLayout.createSequentialGroup()
												.addComponent(jLabel_isinclude)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jRadioButton1).addGap(width_space)
														.addComponent(jRadioButton2))
										.addGroup(
												jPanelxLayout
														.createSequentialGroup()
														.addComponent(jLabel_prefix)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jTextField_prefix, javax.swing.GroupLayout.PREFERRED_SIZE, width_text,
																javax.swing.GroupLayout.PREFERRED_SIZE).addGap(check_space).addComponent(jCheckBox_prefix))
										.addGroup(
												jPanelxLayout
														.createSequentialGroup()
														.addComponent(jLabel_suffix)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jTextField_suffix, javax.swing.GroupLayout.PREFERRED_SIZE, width_text,
																javax.swing.GroupLayout.PREFERRED_SIZE).addGap(check_space).addComponent(jCheckBox_suffix))
										.addGroup(
												jPanelxLayout
														.createSequentialGroup()
														.addComponent(jLabel_name)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, width_text,
																javax.swing.GroupLayout.PREFERRED_SIZE).addGap(check_space).addComponent(jCheckBox_name))

						).addContainerGap()));

		jPanelxLayout.setVerticalGroup(jPanelxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanelxLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								jPanelxLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel_path)
										.addComponent(jTextField_path, javax.swing.GroupLayout.PREFERRED_SIZE, hight_text,
												javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(button_chooese))
						.addGap(hight_space)
						.addGroup(
								jPanelxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
											.addComponent(jLabel_isinclude)
											.addComponent(jRadioButton1)
											.addComponent(jRadioButton2))
						.addGap(hight_space)
						.addGroup(
								jPanelxLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jLabel_prefix)
										.addGroup(
												jPanelxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField_prefix,
														javax.swing.GroupLayout.PREFERRED_SIZE, hight_text, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jCheckBox_prefix)))
						.addGap(hight_space)
						.addGroup(
								jPanelxLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jLabel_suffix)
										.addGroup(
												jPanelxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField_suffix,
														javax.swing.GroupLayout.PREFERRED_SIZE, hight_text, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jCheckBox_suffix)))
						.addGap(hight_space)
						.addGroup(
								jPanelxLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jLabel_name)
										.addGroup(
												jPanelxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField_name,
														javax.swing.GroupLayout.PREFERRED_SIZE, hight_text, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jCheckBox_name)))
						.addGap(hight_space).addComponent(jCheckBox_deleteSelf).addGap(hight_space)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE).addContainerGap()));

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

		JButton button_delete = new JButton("删除");
		JButton button_test = new JButton("测试");
		JButton button_clear = new JButton("清理");
		JButton button_export = new JButton("导出");
		
		
		this.jTextField_prefix.addMouseListener(new MouseListener() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				jCheckBox_prefix.setSelected(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		this.jTextField_suffix.addMouseListener(new MouseListener() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				jCheckBox_suffix.setSelected(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		this.jTextField_name.addMouseListener(new MouseListener() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				jCheckBox_name.setSelected(true);
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		

		button_chooese.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//				try {
//					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//				} catch (Exception ex) {
//					ex.printStackTrace();
//				}
				
				String path = jTextField_path.getText();
				
				File $file = new File(path);
				
				if($file!=null && $file.exists()){
					chooser.setCurrentDirectory($file.getParentFile());
				}
					
				SwingUtilities.updateComponentTreeUI(chooser);

				int resule = chooser.showOpenDialog(new JPanel());
				if (resule == chooser.APPROVE_OPTION) {
					String fileName = chooser.getSelectedFile().getAbsolutePath();
					jTextField_path.setText(fileName);

				}

			}
		});

		button_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String path = jTextField_path.getText();
				
				String $include="包含条件";
				Enumeration<AbstractButton> radioBtns=bg.getElements();  
				while (radioBtns.hasMoreElements()) {  
				    AbstractButton btn = radioBtns.nextElement();  
				    if(btn.isSelected()){  
				    	$include=btn.getText();  
				        break;  
				    }  
				  } 
				
				boolean include = $include.equals("包含条件");
				
				String prefix = jTextField_prefix.getText();
				String suffix = jTextField_suffix.getText();
				String name = jTextField_name.getText();
				boolean isdeleteSelf = jCheckBox_deleteSelf.isSelected();
				
				logth(MessageFormat.format("prefix:{0};suffix:{1};name:{2};isdeleteSelf:{3}",prefix,suffix,name,isdeleteSelf));
				
				DeleteUtils dutils = new DeleteUtils();
				
				if(jCheckBox_suffix.isSelected()){
				if(include)
					dutils.removeChild(path, suffix);
				else
					dutils.removeChildExclude(path, suffix);
				}else if(jCheckBox_prefix.isSelected()){
					if(include)
						prefix = "^"+prefix+".*";
					else
						prefix = "^(?!"+prefix+").*";
						
						dutils.removeChildByRegex(path, prefix);
					}else if(jCheckBox_name.isSelected()){
						if(include)
							name = ".*"+name+".*";
						else
							name = "(?!.*"+name+").*$";
							
							
							dutils.removeChildByRegex(path, name);
						}
				
				List<String> delDirectorySuccesss =  dutils.getDelDirectorySuccesss();
				List<String> delFileSuccesss =dutils.getDelFileSuccesss();
				
				
				logth(MessageFormat.format("删除文件夹个数：{0}",delDirectorySuccesss.size()));
				for(String delDirectorySuccess:delDirectorySuccesss){
					logth(MessageFormat.format("删除文件夹：{0}",delDirectorySuccess));
				}
				
				logth(MessageFormat.format("删除文件个数：{0}",delFileSuccesss.size()));
				for(String file:delFileSuccesss){
					logth(MessageFormat.format("删除文件：{0}",file));
				}
				
				

			}
		});

		button_test.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				logth("测试");

			}
		});

		button_clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jTextArea1.setText("");

			}
		});

		int width = 100;// 按钮宽度90

		layout_right.setHorizontalGroup(layout_right.createSequentialGroup().addGroup(
				layout_right.createParallelGroup().addComponent(button_delete, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_test, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_clear, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_export, GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
				));

		int padding = 15;

		layout_right.setVerticalGroup(layout_right.createSequentialGroup().addGap(padding)
				.addGroup(layout_right.createParallelGroup().addComponent(button_delete)).addGap(padding)
				.addGroup(layout_right.createParallelGroup().addComponent(button_test)).addGap(padding)
				.addGroup(layout_right.createParallelGroup().addComponent(button_clear)).addGap(padding)
				.addGroup(layout_right.createParallelGroup().addComponent(button_export))
				);

	}

	public String logth(String text) {
		
		jTextArea1.append(Htmltools.dateformatCurrent() + " " + text + "\n");
		
		return Htmltools.dateformatCurrent() + " " + text + "\n";

	}

}
