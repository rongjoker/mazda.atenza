/*
 * JExample.java
 *
 * Created on __DATE__, __TIME__
 */

package home.rong.joker.itools.example;

/**
 * 
 * @author __USER__
 */
public class JExample extends javax.swing.JFrame {

	/** Creates new form JExample */
	public JExample() {
		initComponents();
	}

	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		center = new javax.swing.JPanel();
		jPanel1 = new javax.swing.JPanel();
		jSplitPane1 = new javax.swing.JSplitPane();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea2 = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		center.setBackground(new java.awt.Color(0, 0, 204));

		jPanel1.setBackground(new java.awt.Color(102, 102, 255));

		jSplitPane1.setDividerLocation(128);
		jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jSplitPane1.setBottomComponent(jScrollPane1);

		jTextArea2.setColumns(20);
		jTextArea2.setRows(5);
		jScrollPane2.setViewportView(jTextArea2);

		jSplitPane1.setLeftComponent(jScrollPane2);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 679, Short.MAX_VALUE)
				.addGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								jPanel1Layout.createSequentialGroup().addContainerGap()
										.addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 432, Short.MAX_VALUE)
				.addGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								jPanel1Layout.createSequentialGroup().addContainerGap()
										.addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

		javax.swing.GroupLayout centerLayout = new javax.swing.GroupLayout(center);
		center.setLayout(centerLayout);
		centerLayout.setHorizontalGroup(centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				centerLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(148, Short.MAX_VALUE)));
		centerLayout.setVerticalGroup(centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				centerLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(217, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(center,
				javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(center,
				javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
		// GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new JExample().setVisible(true);
			}
		});
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPanel center;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JSplitPane jSplitPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextArea jTextArea2;
	// End of variables declaration//GEN-END:variables

}