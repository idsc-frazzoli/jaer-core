/*
 * MasterbiasPanel.java
 *
 * Created on September 24, 2005, 10:06 PM
 */
package net.sf.jaer.biasgen;

import java.awt.Toolkit;
import java.util.Observer;

import net.sf.jaer.util.EngineeringFormat;

/** A penel for displaying and controlling the masterbias.
 * @author tobi */
public class MasterbiasPanel extends javax.swing.JPanel implements Observer {
  EngineeringFormat f = new EngineeringFormat();
  public Masterbias masterbias;

  public MasterbiasPanel() {
    initComponents();
  }

  /** Creates new form MasterbiasPanel */
  public MasterbiasPanel(Masterbias masterbias) {
    initComponents();
    setMasterbias(masterbias);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor. */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    rintTextBox = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    rxTextBox = new javax.swing.JTextField();
    jPanel3 = new javax.swing.JPanel();
    jSeparator2 = new javax.swing.JSeparator();
    rIntEnabledCheckBox = new javax.swing.JCheckBox();
    rtotalLabel = new javax.swing.JLabel();
    jPanel4 = new javax.swing.JPanel();
    imEstimatedLabel = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    powerDownCheckBox = new javax.swing.JCheckBox();
    setBorder(javax.swing.BorderFactory.createTitledBorder("Masterbias"));
    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel1.setText("Rint");
    jLabel1.setToolTipText("On-chip resistance");
    jPanel1.add(jLabel1);
    rintTextBox.setColumns(7);
    rintTextBox.setText("value");
    rintTextBox.setToolTipText("On-chip masterbias resistance");
    rintTextBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        rintTextBoxActionPerformed(evt);
      }
    });
    jPanel1.add(rintTextBox);
    jLabel3.setText("Rx");
    jPanel1.add(jLabel3);
    rxTextBox.setColumns(8);
    rxTextBox.setText("value");
    rxTextBox.setToolTipText("Off-chip masterbias resistance");
    rxTextBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        rxTextBoxActionPerformed(evt);
      }
    });
    jPanel1.add(rxTextBox);
    jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel3.add(jSeparator2);
    rIntEnabledCheckBox.setText("Using Rint");
    rIntEnabledCheckBox.setToolTipText("Select if also using internal resistor");
    rIntEnabledCheckBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        rIntEnabledCheckBoxActionPerformed(evt);
      }
    });
    jPanel3.add(rIntEnabledCheckBox);
    rtotalLabel.setText("Rotal");
    rtotalLabel.setToolTipText("Total biasgen resistance");
    jPanel3.add(rtotalLabel);
    jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    imEstimatedLabel.setText("Estimated Im");
    imEstimatedLabel.setToolTipText("Estimated current");
    jPanel4.add(imEstimatedLabel);
    jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    powerDownCheckBox.setText("powerDown");
    powerDownCheckBox.setToolTipText("enable to power off masterbias");
    powerDownCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    powerDownCheckBox.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        powerDownCheckBoxActionPerformed(evt);
      }
    });
    jPanel2.add(powerDownCheckBox);
    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
            .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    layout.setVerticalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(layout.createSequentialGroup()
        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
            org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
        .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
            org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
        .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
            org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
            org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(19, Short.MAX_VALUE)));
  }// </editor-fold>//GEN-END:initComponents

  private void rIntEnabledCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rIntEnabledCheckBoxActionPerformed
    masterbias.setInternalResistorUsed(rIntEnabledCheckBox.isSelected());
  }// GEN-LAST:event_rIntEnabledCheckBoxActionPerformed

  private void rxTextBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rxTextBoxActionPerformed
    if (masterbias != null) {
      try {
        masterbias.setRExternal(f.parseFloat(rxTextBox.getText()));
      } catch (NumberFormatException e) {
        Toolkit.getDefaultToolkit().beep();
        rxTextBox.selectAll();
      }
    }
  }// GEN-LAST:event_rxTextBoxActionPerformed

  private void powerDownCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_powerDownCheckBoxActionPerformed
    masterbias.setPowerDownEnabled(powerDownCheckBox.isSelected());
  }// GEN-LAST:event_powerDownCheckBoxActionPerformed

  private void rintTextBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rintTextBoxActionPerformed
    if (masterbias != null) {
      try {
        masterbias.setRInternal(f.parseFloat(rintTextBox.getText()));
      } catch (NumberFormatException e) {
        Toolkit.getDefaultToolkit().beep();
        rintTextBox.selectAll();
      }
    }
  }// GEN-LAST:event_rintTextBoxActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel imEstimatedLabel;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JCheckBox powerDownCheckBox;
  private javax.swing.JCheckBox rIntEnabledCheckBox;
  private javax.swing.JTextField rintTextBox;
  private javax.swing.JLabel rtotalLabel;
  private javax.swing.JTextField rxTextBox;
  // End of variables declaration//GEN-END:variables

  public Masterbias getMasterbias() {
    return this.masterbias;
  }

  public void setMasterbias(final Masterbias masterbias) {
    this.masterbias = masterbias;
    masterbias.addObserver(this);
    updateAppearance();
  }

  private void updateAppearance() {
    rxTextBox.setText(f.format(masterbias.getRExternal()));
    rintTextBox.setText(f.format(masterbias.getRInternal()));
    rtotalLabel.setText("Rtotal=" + f.format(masterbias.getTotalResistance()));
    imEstimatedLabel.setText("Estimated Im=" + f.format(masterbias.getCurrent()));
    rIntEnabledCheckBox.setSelected(masterbias.isInternalResistorUsed());
  }

  public void update(java.util.Observable observable, Object obj) {
    // something in masterbias has changed
    // System.out.println("masterbias panel update");
    updateAppearance();
  }
}
