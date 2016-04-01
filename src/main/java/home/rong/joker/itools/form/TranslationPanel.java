package home.rong.joker.itools.form;

import home.rong.joker.itools.util.YoudaoTransUtil;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Set;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import org.com.dms.sms.util.Htmltools;
import org.com.ronger.joker.robot.Core4Machine;

/**
 * @author rongjoker
 * @date:2016-1-13 下午6:04:58
 * @company:
 * @description
 * @version:0.0.1
 */
public class TranslationPanel extends JPanel {

	private static final long serialVersionUID = -708291416665726796L;

	public TranslationPanel() {

		// this.setOpaque(false);
		// this.setBackground(Color.GRAY);
		// this.setBackground(null);

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
				textArea2.setText(translation(word));
			}
		});

		button_json_pretty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String word = textArea.getText();
				textArea2.setText(Htmltools.gsonFormatter(word));
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
				try {
					textArea2.setText(URLDecoder.decode(word, "utf-8"));
				} catch (Exception e2) {
					e2.printStackTrace();
				}

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
		// translationPane.setBackground(Color.YELLOW);
		JPanel pane_right = new JPanel();
		// pane_right.setOpaque(false);
		// pane_right.setBackground(Color.BLUE);
		GroupLayout layout_right = new GroupLayout(pane_right);
		pane_right.setLayout(layout_right);

		button_url_encode.setLayout(new FlowLayout(FlowLayout.LEADING));

		int width = 100;
		// 按钮宽度90,水平排序
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

		// 垂直排序，间距15
		layout_right.setVerticalGroup(layout_right.createSequentialGroup().addGap(padding).addGroup(layout_right.createParallelGroup().addComponent(button_ze))
				.addGap(padding).addGroup(layout_right.createParallelGroup().addComponent(button_url_encode)).addGap(padding)
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
		hvseqGroup1.addGroup(layout.createParallelGroup().addComponent(translationPane, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE))
				.addGap(10).addGroup(layout.createParallelGroup().addComponent(pane_right));

		layout.setHorizontalGroup(hvseqGroup1);

		// layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)向上对齐，createParallelGroup构造方法可以设置对齐方式
		layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup().addComponent(translationPane).addComponent(pane_right)));

	}

	public String translation(String word) {

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

}
