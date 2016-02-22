package home.rong.joker.itools.example;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author rongjoker
 * @date:2016-2-15 下午4:35:24
 * @company:
 * @description:
 * @version:0.0.1
 */
public class TestHoldFrame extends JFrame {

	public static void main(String[] args) {

		new TestHoldFrame().setVisible(true);

	}

	public TestHoldFrame() {

		// initx();
		initComponents();

	}

	private void initx() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		JLabel jl3 = new JLabel();

		JLabel jl1 = new JLabel();

		JLabel jl2 = new JLabel();

		JPanel jp1 = new JPanel();

		jl1.setText("jLabel1");

		jl2.setText("jLabel2");

		jl3.setText("jLabel3");

		jp1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jp1);
		jp1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 139, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, Short.MAX_VALUE));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);

		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

		hGroup.addGap(5);

		GroupLayout.SequentialGroup hGroup1 = layout.createSequentialGroup();

		hGroup1.addGroup(layout.createParallelGroup().addComponent(jl1)).addGap(5)
				.addGroup(layout.createParallelGroup().addComponent(jl3).addGap(5).addComponent(jl2));

		hGroup.addGroup(layout.createParallelGroup().addComponent(jl3).addGap(5).addGroup(hGroup1).addGap(5).addComponent(jp1)).addContainerGap(576,
				Short.MAX_VALUE);

		layout.setHorizontalGroup(hGroup);

		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

		vGroup.addGap(5);
		vGroup.addGroup(layout.createParallelGroup().addComponent(jl3));
		vGroup.addGap(5);
		vGroup.addGroup(layout.createParallelGroup().addComponent(jl1).addGap(5).addComponent(jl2));
		vGroup.addGap(5);
		vGroup.addGroup(layout.createParallelGroup().addComponent(jp1)).addContainerGap(285, Short.MAX_VALUE);

		layout.setVerticalGroup(vGroup);

	}

	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		JLabel jLabel1 = new javax.swing.JLabel();
		JLabel jLabel2 = new javax.swing.JLabel();
		JLabel jLabel3 = new javax.swing.JLabel();
		JPanel jPanel1 = new javax.swing.JPanel();

		jLabel1.setText("jLabel1");

		jLabel2.setText("jLabel2");

		jLabel3.setText("jLabel3");

		jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 139, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addGap(62, 62, 62)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(
												layout.createSequentialGroup()
														.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(
																layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel3)
																		.addComponent(jLabel2)))
										.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(576, Short.MAX_VALUE)));

		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addGap(38, 38, 38)
						.addComponent(jLabel3)
						.addGap(36, 36, 36)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(jLabel2))
						.addGap(18, 18, 18)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(285, Short.MAX_VALUE)

		));

		pack();
	}

}
