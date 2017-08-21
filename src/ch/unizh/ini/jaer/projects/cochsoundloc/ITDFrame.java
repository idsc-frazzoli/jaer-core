/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * ITDJFramePanel.java
 *
 * Created on 25.03.2009, 19:14:16
 */
package ch.unizh.ini.jaer.projects.cochsoundloc;

/** Shows the ITD histogram in a JFrame.
 * 
 * @author Holger */
public class ITDFrame extends javax.swing.JFrame {
  /** Creates new form ITDJFramePanel */
  public ITDFrame() {
    initComponents();
  }

  public void setITD(float itd) {
    itdTextField.setText(String.format("%.1f", itd));
    repaint();
  }

  public void setText(String text) {
    itdTextField.setText(text);
    repaint();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor. */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    binsPanel = new ch.unizh.ini.jaer.projects.cochsoundloc.ITDBinsPanel();
    bottomPanel = new javax.swing.JPanel();
    itdTextField = new javax.swing.JTextField();
    setTitle("ITD-Bins");
    setBackground(new java.awt.Color(0, 0, 0));
    setForeground(java.awt.Color.black);
    setName("ITDFrame"); // NOI18N
    binsPanel.setBorder(null);
    getContentPane().add(binsPanel, java.awt.BorderLayout.CENTER);
    binsPanel.getAccessibleContext().setAccessibleName("ITDs");
    bottomPanel.setLayout(new java.awt.BorderLayout());
    itdTextField.setColumns(6);
    itdTextField.setEditable(false);
    itdTextField.setFont(new java.awt.Font("Tahoma", 0, 18));
    itdTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    itdTextField.setBorder(null);
    itdTextField.setPreferredSize(new java.awt.Dimension(160, 22));
    itdTextField.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        itdTextFieldActionPerformed(evt);
      }
    });
    bottomPanel.add(itdTextField, java.awt.BorderLayout.CENTER);
    getContentPane().add(bottomPanel, java.awt.BorderLayout.PAGE_END);
    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void itdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_itdTextFieldActionPerformed
    // TODO add your handling code here:
  }// GEN-LAST:event_itdTextFieldActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  public ch.unizh.ini.jaer.projects.cochsoundloc.ITDBinsPanel binsPanel;
  private javax.swing.JPanel bottomPanel;
  private javax.swing.JTextField itdTextField;
  // End of variables declaration//GEN-END:variables
}
