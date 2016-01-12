package home.rong.joker.itools.example;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author joker4lr
 * @date:2016-1-11 下午2:01:05
 * @company:
 * @description
 * @version:0.0.1
 */
public class TestImageWindow extends JFrame {

	JLabel topLabel;
	JLabel userNameLabel, passwordLabel;
	JTextField userNameTextField;
	JPasswordField passwordField;
	JButton exitButton, loginButton;

	public TestImageWindow() {
		super("欢迎登录");
		topLabel = new JLabel();
		// topLabel.setIcon(new ImageIcon("/im/1.jpg"));
		topLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("D:/data/icon/123.png")));
		add(topLabel);
		topLabel.setLayout(null);
		userNameLabel = new JLabel("用户名:");
		userNameLabel.setForeground(Color.WHITE);
		passwordLabel = new JLabel("密 码:");
		userNameTextField = new JTextField(20);
		passwordField = new JPasswordField(20);
		exitButton = new JButton("退 出");
		loginButton = new JButton("登 录");
		ButtonListener bListener = new ButtonListener();
		// 按钮注册事件监听器
		exitButton.addActionListener(bListener);
		loginButton.addActionListener(bListener);
		userNameTextField.addActionListener(bListener);
		passwordField.addActionListener(bListener);
		MyKeyListener keylis = new MyKeyListener();
		userNameTextField.addKeyListener(keylis);
		passwordField.addKeyListener(keylis);
		userNameLabel.setSize(45, 20);
		userNameLabel.setLocation(40, 280);
		topLabel.add(userNameLabel);
		userNameTextField.setSize(50, 20);
		userNameTextField.setLocation(85, 280);
		topLabel.add(userNameTextField);
		passwordLabel.setSize(40, 20);
		passwordLabel.setLocation(140, 280);
		topLabel.add(passwordLabel);
		passwordField.setSize(50, 20);
		passwordField.setLocation(195, 280);
		topLabel.add(passwordField);
		exitButton.setSize(80, 20);
		exitButton.setLocation(260, 280);
		topLabel.add(exitButton);
		loginButton.setSize(80, 20);
		loginButton.setLocation(350, 280);
		topLabel.add(loginButton);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500, 350);
		setVisible(true);
	}

	private void checkNamePwd() {
		String userName = userNameTextField.getText().trim();
		String pw = passwordField.getText();
		if (userName.length() == 0) {
			JOptionPane.showMessageDialog(null, "用户名不能为空!");
		} else if (pw.length() == 0) {
			JOptionPane.showMessageDialog(null, "密码不能为空!");
		} else {
			JOptionPane.showMessageDialog(null, "恭喜你成功登录!");
		}
	}

	private void exitWindow() {
		System.exit(0);
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 获取事件源
			Object source = e.getSource();
			if (source == exitButton) {
				exitWindow();
			} else if (source == loginButton) {
				checkNamePwd();
			}
		}
	}

	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent ke) {
			int code = ke.getKeyCode();
			if (code == 10) {
				checkNamePwd();
			} else if (code == 27) {
				exitWindow();
			}
		}
	}

	public static void main(String[] kk) {
		TestImageWindow ww = new TestImageWindow();
		ww.show();
	}

}
