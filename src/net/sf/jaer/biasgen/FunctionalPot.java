/*
 * FunctionalPot.java
 *
 * Created on January 21, 2006, 10:12 PM
 */
package net.sf.jaer.biasgen;

/** A symbolic pot that describes some kind of functionality with analog characteristics, e.g. neuron threshold. This component provides a user control.
 * <p>
 * Users will extend this so that controlling the functional bias actually controls physical bias currents in a desired manner.
 * <p>
 * For feedback controllers, this FunctionalPot will also be used.
 * @author tobi */
public class FunctionalPot extends javax.swing.JPanel {
  private String name;
  private float value;

  /** Creates new form FunctionalPot */
  public FunctionalPot() {
    initComponents();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getValue() {
    return value;
  }

  public void setValue(float value) {
    this.value = value;
  }

  boolean dontHandleStateChange = false; // a semaphore-like thing that the slider sets so that setting itself can avoid generating more state changes

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor. */
  // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
  private void initComponents() {
    label = new javax.swing.JLabel();
    slider = new javax.swing.JSlider();
    setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));
    label.setText("jLabel1");
    add(label);
    slider.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        sliderStateChanged(evt);
      }
    });
    add(slider);
  }// </editor-fold>//GEN-END:initComponents

  private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_sliderStateChanged
    // TODO add your handling code here:
  }// GEN-LAST:event_sliderStateChanged

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel label;
  private javax.swing.JSlider slider;
  // End of variables declaration//GEN-END:variables
}