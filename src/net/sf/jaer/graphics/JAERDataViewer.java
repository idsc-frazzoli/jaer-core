/*
 * JAERDataViewer.java
 *
 * Created on June 29, 2007, 3:28 PM
 */
package net.sf.jaer.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.table.AbstractTableModel;

/** Allows for viewing various data, e.g. XY or YT plots, logging output, tabular data.
 *
 * @author malang */
public class JAERDataViewer extends javax.swing.JFrame {
  GraphPanel pnlGraph;
  private HashMap<String, CheckBox> dataSets = new HashMap<String, CheckBox>();
  private DataTable tabledata = new DataTable();

  private class CheckBox extends JCheckBox {
    public GraphData gd;
  }

  public enum DataType {
    XY, YScrolling, YScaling
  };

  public enum LineStyle {
    Point, Line, PointLine
  };

  /** Creates new form JAERDataViewer */
  public JAERDataViewer(String title) {
    initComponents();
    this.setTitle(title);
    pnlGraph = new GraphPanel();
    pnlGraph.setBackground(new java.awt.Color(255, 255, 255));
    pnlGraph.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    pnlGraphContainer.setLayout(new GridLayout(0, 1));
    pnlGraph.setUpdateEvent(new GraphPanelUpdateEvent() {
      @Override
      public void update() {
        updateAxeBoxes();
      }
    });
    pnlGraphContainer.add(pnlGraph);
    pnlGraphContainer.revalidate();
    pnlGraphContainer.repaint();
    pnlGraph.setResizeX(false);
    pnlGraph.setResizeY(true);
    updateAxeBoxes();
    periodicUpdate(true);
    tblData.setModel(tabledata);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor. */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    jTabbedPane1 = new javax.swing.JTabbedPane();
    tabGraph = new javax.swing.JPanel();
    pnlGraphContainer = new javax.swing.JPanel();
    btnIsAutosize = new javax.swing.JToggleButton();
    txtMinY = new javax.swing.JTextField();
    txtMaxY = new javax.swing.JTextField();
    txtMinX = new javax.swing.JTextField();
    txtMaxX = new javax.swing.JTextField();
    pnlGraphSelection = new javax.swing.JPanel();
    tabData = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblData = new javax.swing.JTable();
    btnStoreTable = new javax.swing.JButton();
    jbtnPeriodicUpdate = new javax.swing.JToggleButton();
    btnClose = new javax.swing.JButton();
    jTabbedPane1.setMinimumSize(new java.awt.Dimension(0, 0));
    pnlGraphContainer.setLayout(null);
    btnIsAutosize.setText("Autoscale");
    btnIsAutosize.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnIsAutosizeActionPerformed(evt);
      }
    });
    txtMinY.setText("jTextField1");
    txtMinY.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtMaxXActionPerformed(evt);
      }
    });
    txtMaxY.setText("jTextField1");
    txtMaxY.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtMaxXActionPerformed(evt);
      }
    });
    txtMinX.setText("jTextField1");
    txtMinX.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtMaxXActionPerformed(evt);
      }
    });
    txtMaxX.setText("jTextField1");
    txtMaxX.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtMaxXActionPerformed(evt);
      }
    });
    txtMaxX.addFocusListener(new java.awt.event.FocusAdapter() {
      @Override
      public void focusLost(java.awt.event.FocusEvent evt) {
        AxeBoxFocusLost(evt);
      }
    });
    pnlGraphSelection.setAutoscrolls(true);
    pnlGraphSelection.setFont(new java.awt.Font("Tahoma", 0, 8));
    pnlGraphSelection.setMaximumSize(new java.awt.Dimension(2680, 2680));
    pnlGraphSelection.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        pnlGraphSelectionMouseEntered(evt);
      }

      @Override
      public void mouseExited(java.awt.event.MouseEvent evt) {
        pnlGraphSelectionMouseExited(evt);
      }
    });
    javax.swing.GroupLayout tabGraphLayout = new javax.swing.GroupLayout(tabGraph);
    tabGraph.setLayout(tabGraphLayout);
    tabGraphLayout
        .setHorizontalGroup(tabGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
            tabGraphLayout.createSequentialGroup().addContainerGap()
                .addGroup(tabGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtMaxY, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE).addComponent(txtMinY, 0, 0, Short.MAX_VALUE)
                    .addComponent(pnlGraphSelection, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabGraphLayout.createSequentialGroup()
                        .addComponent(txtMinX, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(189, 189, 189)
                        .addComponent(btnIsAutosize, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE).addGap(133, 133, 133).addComponent(txtMaxX,
                            javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlGraphContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
                .addContainerGap()));
    tabGraphLayout.setVerticalGroup(tabGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        javax.swing.GroupLayout.Alignment.TRAILING,
        tabGraphLayout.createSequentialGroup().addContainerGap().addGroup(tabGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabGraphLayout.createSequentialGroup()
                .addComponent(txtMaxY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGraphSelection, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMinY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnlGraphContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(tabGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnIsAutosize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMinX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtMaxX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(26, 26, 26)));
    jTabbedPane1.addTab("Graph", tabGraph);
    tabData.setDoubleBuffered(false);
    tabData.setEnabled(false);
    tabData.setFocusable(false);
    tabData.setLayout(new java.awt.BorderLayout());
    tblData.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } },
        new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
    jScrollPane1.setViewportView(tblData);
    tabData.add(jScrollPane1, java.awt.BorderLayout.CENTER);
    btnStoreTable.setText("Store to file");
    btnStoreTable.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnStoreTableActionPerformed(evt);
      }
    });
    tabData.add(btnStoreTable, java.awt.BorderLayout.SOUTH);
    jTabbedPane1.addTab("Data", tabData);
    jbtnPeriodicUpdate.setSelected(true);
    jbtnPeriodicUpdate.setText("Periodic Update");
    jbtnPeriodicUpdate.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtnPeriodicUpdateActionPerformed(evt);
      }
    });
    btnClose.setText("Close");
    btnClose.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCloseActionPerformed(evt);
      }
    });
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup().addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jbtnPeriodicUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 429, Short.MAX_VALUE).addComponent(btnClose))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE))
            .addContainerGap()));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup().addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jbtnPeriodicUpdate).addComponent(btnClose))
            .addContainerGap()));
    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnStoreTableActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnStoreTableActionPerformed
    JFileChooser dlg = new JFileChooser();
    dlg.setAcceptAllFileFilterUsed(true);
    if (dlg.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
      try {
        Cursor hourglassCursor = new Cursor(Cursor.WAIT_CURSOR);
        setCursor(hourglassCursor);
        tabledata.storeToFile(dlg.getSelectedFile());
      } catch (Exception ex) {
        ex.printStackTrace();
      } finally {
        Cursor hourglassCursor = new Cursor(Cursor.DEFAULT_CURSOR);
        setCursor(hourglassCursor);
      }
    }
  }// GEN-LAST:event_btnStoreTableActionPerformed

  private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCloseActionPerformed
    this.setVisible(false);
  }// GEN-LAST:event_btnCloseActionPerformed

  private void jbtnPeriodicUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbtnPeriodicUpdateActionPerformed
    periodicUpdate(jbtnPeriodicUpdate.isSelected());
  }// GEN-LAST:event_jbtnPeriodicUpdateActionPerformed

  private int pnlGraphSelectionWide = 0;
  private boolean pnlGraphSelectioninside = false;
  private LayoutManager pnlGraphSelectionLayout;

  private void pnlGraphSelectionMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_pnlGraphSelectionMouseExited
    if (new Rectangle(pnlGraphSelection.getSize()).contains(evt.getPoint())) {
      return;
    }
    pnlGraphSelection.setSize(pnlGraphSelectionWide, pnlGraphSelection.getHeight());
    pnlGraphSelection.setBackground(this.getBackground());
    pnlGraphSelection.setBorder(null);
    pnlGraphSelection.getParent().setLayout(pnlGraphSelectionLayout);
    pnlGraphSelection.validate();
    pnlGraphSelectioninside = false;
    periodicUpdate(jbtnPeriodicUpdate.isSelected());
  }// GEN-LAST:event_pnlGraphSelectionMouseExited

  private void pnlGraphSelectionMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_pnlGraphSelectionMouseEntered
    if (pnlGraphSelectioninside == true) {
      return;
    }
    periodicUpdate(false);
    int min = pnlGraphSelectionWide = pnlGraphSelection.getWidth();
    min -= 20;
    for (int i = 0; i < pnlGraphSelection.getComponents().length; i++) {
      if (pnlGraphSelection.getComponents()[i].getWidth() > min) {
        min = pnlGraphSelection.getComponents()[i].getWidth();
      }
    }
    pnlGraphSelection.setSize(min + 20, pnlGraphSelection.getHeight());
    pnlGraphSelectionLayout = pnlGraphSelection.getParent().getLayout();
    pnlGraphSelection.getParent().setLayout(null);
    pnlGraphSelection.setBackground(Color.white);
    pnlGraphSelection.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    pnlGraphSelection.validate();
    pnlGraphSelectioninside = true;
  }// GEN-LAST:event_pnlGraphSelectionMouseEntered

  private void txtMaxXActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtMaxXActionPerformed
    try {
      btnIsAutosize.setSelected(false);
      pnlGraph.setResizeX(btnIsAutosize.isSelected());
      pnlGraph.setResizeY(btnIsAutosize.isSelected());
      pnlGraph.setMaxX(Double.parseDouble(txtMaxX.getText()));
      pnlGraph.setMaxY(Double.parseDouble(txtMaxY.getText()));
      pnlGraph.setMinX(Double.parseDouble(txtMinX.getText()));
      pnlGraph.setMinY(Double.parseDouble(txtMinY.getText()));
    } catch (Exception e) {
    }
  }// GEN-LAST:event_txtMaxXActionPerformed

  private void btnIsAutosizeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnIsAutosizeActionPerformed
    pnlGraph.setResizeX(btnIsAutosize.isSelected());
    pnlGraph.setResizeY(btnIsAutosize.isSelected());
    updateAxeBoxes();
  }// GEN-LAST:event_btnIsAutosizeActionPerformed

  private void AxeBoxFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_AxeBoxFocusLost
  }// GEN-LAST:event_AxeBoxFocusLost

  /** @param args the command line arguments */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JAERDataViewer dv = new JAERDataViewer("Test");
        List<Double> test = new ArrayList<>();
        List<Double> testx = new ArrayList<>();
        for (int n = 0; n < 100; n++) {
          testx.add(n, (double) n);
          test.add(n, Math.sin((double) n / 20));
        }
        dv.addDataSet("sinus", testx, test);
        dv.addDataSet("sinus3", test, 1., true);
        dv.addDataSet("sinus4", testx, test);
        dv.addDataSet("sinus5", test, 2., true);
        dv.addDataSet("sinus6", testx, test);
        dv.addDataSet("sinus7", test, 3., true);
        testx = new ArrayList<>();
        testx.add(5.0);
        testx.add(2.0);
        dv.addDataSet("short", testx, 4., true);
        dv.setVisible(true);
      }
    });
  }

  private void updateAxeBoxes() {
    txtMaxX.setText(String.format("%.2f", pnlGraph.getMaxX()));
    txtMaxY.setText(String.format("%.2f", pnlGraph.getMaxY()));
    txtMinX.setText(String.format("%.2f", pnlGraph.getMinX()));
    txtMinY.setText(String.format("%.2f", pnlGraph.getMinY()));
  }

  public void addDataSet(final String Name, final List<Double> x, final List<Double> y, final double samplingRate, final DataType dataType,
      final LineStyle style, final Color color) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        GraphData gd = new GraphData();
        gd.Color = color;
        gd.Style = style;
        gd.X = x;
        gd.Y = y;
        gd.DataType = dataType;
        gd.SamplingRate = samplingRate;
        CheckBox box;
        if (dataSets.containsKey(Name)) {
          box = dataSets.get(Name);
          box.doClick();
        } else {
          box = new CheckBox();
          pnlGraphSelection.add(box);
          box.setFont(new java.awt.Font("Tahoma", 0, 8));
          box.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              chkGraph(evt);
            }
          });
          box.setText(Name);
          box.setToolTipText(Name);
          box.setOpaque(false);
          dataSets.put(Name, box);
        }
        box.gd = gd;
        box.setForeground(color);
        box.doClick();
        pnlGraphSelection.validate();
        tabledata.setData(Name, gd);
        tblData.setModel(tabledata);
      }
    });
  }

  public void addDataSet(String name, List<Double> y, double samplingRate, Boolean scrolling) {
    addDataSet(name, null, y, samplingRate, scrolling ? DataType.YScrolling : DataType.YScaling, LineStyle.Line,
        new Color(Color.HSBtoRGB((float) Math.random(), 1.0f, 0.5f)));
  }

  public void addDataSet(String name, List<Double> x, List<Double> y) {
    addDataSet(name, x, y, 0, DataType.XY, LineStyle.PointLine, new Color(Color.HSBtoRGB((float) Math.random(), 1.0f, 0.5f)));
  }

  public void removeDataSet(final String name) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        if (dataSets.containsKey(name)) {
          pnlGraph.removeData(name);
          pnlGraphSelection.remove(dataSets.get(name));
          dataSets.remove(name);
          pnlGraphSelection.validate();
          tabledata.removeData(name);
        }
      }
    });
  }

  // Code for the Graph Tab
  public void chkGraph(java.awt.event.ActionEvent evt) {
    CheckBox box = (CheckBox) evt.getSource();
    if (box.isSelected()) {
      pnlGraph.setData(box.getText(), box.gd);
    } else {
      pnlGraph.removeData(box.getText());
    }
  }
  // public void addWarning(String Warning) {
  // String txt =
  // "\n----------- Warning ------------\n"
  // + Warning;
  //
  // //txtTextLog.setCaretColor(Color.blue);
  // txtTextLog.append(txt);
  // }
  //
  // public void addError(String Error) {
  // String txt =
  // "\n=========== Error ==============\n"
  // + Error;
  // //txtTextLog.setCaretColor(Color.red);
  // txtTextLog.append(txt);
  // }
  //
  // public void addInfo(String Info) {
  // String txt =
  // "\n Info: \n"
  // + Info;
  //
  // //txtTextLog.setCaretColor(Color.black);
  // txtTextLog.append(txt);
  // }
  //
  // public void redirectStreams() {
  // StreamSupport out = new StreamSupport(System.out, Color.black);
  // System.setOut(new PrintStream(out));
  //
  // StreamSupport err = new StreamSupport(System.err, Color.red);
  // System.setErr(new PrintStream(err));
  // }

  // private void showErrorLog() {
  // this.setVisible(true);
  // }
  private Timer UpdateTimer = new Timer();

  private void periodicUpdate(boolean b) {
    if (b) {
      RepaintTask UpdateTask = new RepaintTask(pnlGraph, tabledata);
      UpdateTimer.schedule(UpdateTask, 500, 500);
    } else {
      UpdateTimer.cancel();
      UpdateTimer = new Timer();
    }
  }

  private class RepaintTask extends TimerTask {
    final JComponent cmp;
    final DataTable tbl;

    public RepaintTask(JComponent cmp, DataTable tbl) {
      this.cmp = cmp;
      this.tbl = tbl;
    }

    @Override
    public void run() {
      cmp.repaint();
      tbl.update();
    }
  }
  // private class StreamSupport extends OutputStream {
  // final int MAX_CHARS=100000; // clears when this fills up, to avoid heap overflow
  // PrintStream oldOut; // the original printstream
  // Color color;
  //
  // public StreamSupport(PrintStream old, Color color) {
  // oldOut = old;
  // this.color = color;
  // }
  //
  // public void write(final int b) throws IOException {
  // if(oldOut != null) oldOut.write(b);
  // //txtTextLog.setCaretColor(color);
  // java.awt.EventQueue.invokeLater(new Runnable() {
  // public void run() {
  // txtTextLog.append(String.valueOf((char)b));
  // txtTextLog.setCaretPosition(txtTextLog.getDocument().getLength());
  // }
  // });
  // //showErrorLog();
  // }
  //
  // }

  // <editor-fold defaultstate="collapsed" desc=" Generated Code (Variables) ">
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnClose;
  private javax.swing.JToggleButton btnIsAutosize;
  private javax.swing.JButton btnStoreTable;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JToggleButton jbtnPeriodicUpdate;
  private javax.swing.JPanel pnlGraphContainer;
  private javax.swing.JPanel pnlGraphSelection;
  private javax.swing.JPanel tabData;
  private javax.swing.JPanel tabGraph;
  private javax.swing.JTable tblData;
  private javax.swing.JTextField txtMaxX;
  private javax.swing.JTextField txtMaxY;
  private javax.swing.JTextField txtMinX;
  private javax.swing.JTextField txtMinY;
  // End of variables declaration//GEN-END:variables
  // </editor-fold>

  public class GraphData {
    public List<Double> X;
    public List<Double> Y;
    public DataType DataType;
    public LineStyle Style;
    public Color Color;
    public double SamplingRate;
  }

  private interface GraphPanelUpdateEvent {
    void update();
  }

  public class DataTable extends AbstractTableModel {
    private HashMap<String, GraphData> currentGraphs = new HashMap<String, GraphData>();

    public boolean isAdded(String name) {
      return currentGraphs.get(name) != null;
    }

    public synchronized void setData(String name, GraphData graph) {
      if ((graph.DataType == DataType.XY) && (graph.X == null)) {
        return;
      }
      currentGraphs.put(name, graph);
      this.fireTableStructureChanged();
    }

    public synchronized void removeData(String name) {
      currentGraphs.remove(name);
      this.fireTableStructureChanged();
    }

    @Override
    public synchronized int getRowCount() {
      int max = 0;
      if (currentGraphs.size() == 0) {
        return 0;
      }
      for (GraphData dt : currentGraphs.values()) {
        synchronized (dt.Y) {
          if (dt.Y.size() > max) {
            max = dt.Y.size();
          }
        }
      }
      return max;
    }

    private int columncount_old = -1;

    @Override
    public synchronized int getColumnCount() {
      int count = 0;
      for (GraphData dt : currentGraphs.values()) {
        switch (dt.DataType) {
        case YScrolling:
        case YScaling:
          count += 1;
          break;
        case XY:
          count += 2;
          break;
        default:
          break;
        }
      }
      return count;
    }

    @Override
    public synchronized Object getValueAt(int row, int column) {
      int count = -1;
      for (GraphData dt : currentGraphs.values()) {
        synchronized (dt.Y) {
          switch (dt.DataType) {
          case YScrolling:
          case YScaling:
            count += 1;
            break;
          case XY:
            count += 1;
            // if it is the x coordinate
            if (count == column) {
              if (row < dt.X.size()) {
                return dt.X.get(row);
              } else {
                return null;
              }
            }
            count += 1;
            break;
          default:
            break;
          }
          // okay seems to be y data or nothing yet
          if (count == column) {
            if (row < dt.Y.size()) {
              return dt.Y.get(row);
            } else {
              return null;
            }
          }
        }
      }
      // never reach here
      assert ("That should never happen" == null);
      return null;
    }

    @Override
    public synchronized String getColumnName(int column) {
      String retValue;
      // todo
      retValue = super.getColumnName(column);
      return retValue;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
      return Double.class;
    }

    private void update() {
      // call row count to invoke recalculate
      // and my insert or delete rows
      int count = getRowCount();
      if (columncount_old > count) {
        this.fireTableRowsDeleted(count, columncount_old - 1);
        columncount_old = count;
      }
      if (columncount_old < count) {
        this.fireTableRowsInserted(columncount_old, count - 1);
        columncount_old = count;
      }
      // not goot method to find updates so just say
      this.fireTableRowsUpdated(0, count);
    }

    // very! poor algorithm, but not very time critical
    public synchronized void storeToFile(File file) throws Exception {
      int row_count = getRowCount();
      int col_count = getColumnCount();
      FileWriter fw = new FileWriter(file);
      for (int r = 0; r < row_count; r++) {
        for (int c = 0; c < col_count; c++) {
          Object obj = getValueAt(r, c);
          if (obj != null) {
            fw.write(obj.toString());
          }
          fw.write("\t");
        }
        fw.write("\n");
      }
      fw.close();
    }
  }

  public class GraphPanel extends javax.swing.JPanel {
    private double max_x = 10;
    private double max_y = 10;
    private double min_x = 0;
    private double min_y = 0;
    private boolean resize_x = true;
    private boolean resize_y = true;
    private HashMap<String, GraphData> currentGraphs = new HashMap<String, GraphData>();
    private GraphPanelUpdateEvent UpdateEvent;

    @Override
    public void paint(Graphics g) {
      super.paint(g);
      Graphics2D g2 = (Graphics2D) g;
      // GraphData gd = new GraphData();
      //
      // gd.Style = LineStyle.Line;
      // gd.X = new ArrayList(100);
      // gd.Y = new ArrayList(100);
      // gd.DataType = DataType.XY;
      // gd.Color = Color.blue;
      // for(int n=0; n < 100; n++) {
      // gd.X.add(n,(double)n);
      // gd.Y.add(n, Math.sin((double)n/20));
      // }
      // currentGraphs.put("test",gd);
      if (resize_x) {
        doResiseX();
      }
      if (resize_y) {
        doResiseY();
      }
      drawGrid(g2);
      // drawAxis(g2);
      drawData(g2);
    }

    private void drawAxis(Graphics2D g2) {
      g2.setStroke(new BasicStroke(1));
      // int step = this.getHeight() / 10;
      // for (int n = getHeight(); n > 0; n -= step) {
      // g2.drawString("0", 0, n + step/4);
      // }
      //
      // step = this.getWidth() / 20;
      // for (int n = 0; n < this.getWidth(); n += step) {
      // g2.drawString("0", n + step/4, this.getHeight()-10);
      // }
    }

    private void drawGrid(Graphics2D g2) {
      float[] dashPattern = { 3, 5 };
      g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dashPattern, 0));
      double step = this.getHeight() / 10.0;
      for (int n = 0; n < (this.getHeight() / 20); n++) {
        g2.drawLine(0, this.getHeight() - (int) (n * step), this.getWidth(), this.getHeight() - (int) (n * step));
      }
      step = this.getWidth() / 20.0;
      for (int n = 0; n < (this.getWidth() / 20); n++) {
        g2.drawLine((int) (n * step), 0, (int) (n * step), this.getHeight());
      }
    }

    private synchronized void drawData(Graphics2D g2) {
      int n;
      int[] x;
      int[] y;
      int length = 0;
      g2.setStroke(new BasicStroke());
      for (GraphData dt : currentGraphs.values()) {
        g2.setColor(dt.Color);
        synchronized (dt.Y) {
          switch (dt.DataType) {
          case YScrolling:
            length = Math.min(this.getWidth(), dt.Y.size());
            x = new int[length];
            y = new int[length];
            int l = dt.Y.size() - length;
            for (n = 0; n < length; n++) {
              x[n] = n;
              y[n] = (int) (this.getHeight() - (((dt.Y.get(l + n) - getMinY()) / (max_y - getMinY())) * this.getHeight()));
            }
            break;
          case YScaling:
            length = this.getWidth();
            x = new int[length];
            y = new int[length];
            double scale = ((double) dt.Y.size()) / (double) length;
            for (n = 0; n < length; n++) {
              x[n] = n;
              y[n] = (int) (this.getHeight() - (((dt.Y.get((int) (n * scale)) - getMinY()) / (max_y - getMinY())) * this.getHeight()));
            }
            break;
          case XY:
            assert (dt.X.size() == dt.Y.size());
            length = dt.X.size();
            x = new int[length];
            y = new int[length];
            for (n = 0; n < length; n++) {
              x[n] = (int) (((dt.X.get(n) - getMinX()) / (max_x - getMinX())) * this.getWidth());
              y[n] = (int) (this.getHeight() - (((dt.Y.get(n) - getMinY()) / (max_y - getMinY())) * this.getHeight()));
            }
            break;
          default:
            length = 0;
            x = new int[length];
            y = new int[length];
          }
          if ((dt.Style == LineStyle.Point) || (dt.Style == LineStyle.PointLine)) {
            for (n = 0; n < length; n++) {
              g2.setStroke(new BasicStroke(3.0f));
              g2.drawOval(x[n] - 2, y[n] - 2, 4, 4);
              g2.setStroke(new BasicStroke(1.0f));
            }
          }
          if ((dt.Style == LineStyle.Line) || (dt.Style == LineStyle.PointLine)) {
            g2.drawPolyline(x, y, length);
          }
        }
      }
    }

    public void setResizeX(boolean resize_x) {
      this.resize_x = resize_x;
      if (resize_x) {
        doResiseX();
      }
      this.repaint();
    }

    public boolean isResizeY() {
      return resize_y;
    }

    public void setResizeY(boolean resize_y) {
      this.resize_y = resize_y;
      if (resize_y) {
        doResiseY();
      }
      this.repaint();
    }

    public boolean isAdded(String name) {
      return currentGraphs.get(name) != null;
    }

    public synchronized void setData(String name, GraphData graph) {
      if ((graph.DataType == DataType.XY) && (graph.X == null)) {
        return;
      }
      currentGraphs.put(name, graph);
      this.repaint();
    }

    public synchronized void removeData(String name) {
      currentGraphs.remove(name);
      this.repaint();
    }

    private synchronized void doResiseY() {
      double min = Double.MAX_VALUE;
      double max = Double.MIN_VALUE;
      for (GraphData dt : currentGraphs.values()) {
        synchronized (dt.Y) {
          int l;
          if (dt.DataType == DataType.YScrolling) {
            l = dt.Y.size() - Math.min(this.getWidth(), dt.Y.size());
            min = getMinY();
            max = getMaxY();
          } else {
            l = 0;
          }
          for (int n = l; n < dt.Y.size(); n++) {
            if (dt.Y.get(n) > max) {
              max = dt.Y.get(n);
            }
            if (dt.Y.get(n) < min) {
              min = dt.Y.get(n);
            }
          }
        }
      }
      setMaxY((max == Double.MIN_VALUE) ? 10 : max);
      setMinY((min == Double.MAX_VALUE) ? 0 : min);
    }

    private synchronized void doResiseX() {
      double min = Double.MAX_VALUE;
      double max = Double.MIN_VALUE;
      double time = 10;
      for (GraphData dt : currentGraphs.values()) {
        if (dt.DataType == DataType.YScrolling) {
          time = dt.SamplingRate * this.getWidth();
          continue;
        }
        if (dt.DataType == DataType.YScaling) {
          synchronized (dt.Y) {
            time = dt.SamplingRate * dt.Y.size();
          }
          continue;
        }
        synchronized (dt.Y) {
          for (int n = 0; n < dt.X.size(); n++) {
            if (dt.X.get(n) > max) {
              max = dt.X.get(n);
            }
            if (dt.X.get(n) < min) {
              min = dt.X.get(n);
            }
          }
        }
      }
      setMaxX((max == Double.MIN_VALUE) ? time : max);
      setMinX((min == Double.MAX_VALUE) ? 0 : min);
    }

    public double getMinX() {
      return min_x;
    }

    public void setMinX(double min_x) {
      if (this.min_x != min_x) {
        this.min_x = min_x;
        if (getUpdateEvent() != null) {
          getUpdateEvent().update();
        }
      }
    }

    public double getMinY() {
      return min_y;
    }

    public void setMinY(double min_y) {
      if (this.min_y != min_y) {
        this.min_y = min_y;
        if (getUpdateEvent() != null) {
          getUpdateEvent().update();
        }
      }
    }

    public double getMaxX() {
      return max_x;
    }

    public void setMaxX(double max_x) {
      if (this.max_x != max_x) {
        this.max_x = max_x;
        if (getUpdateEvent() != null) {
          getUpdateEvent().update();
        }
      }
    }

    public double getMaxY() {
      return max_y;
    }

    public void setMaxY(double max_y) {
      if (this.max_y != max_y) {
        this.max_y = max_y;
        if (getUpdateEvent() != null) {
          getUpdateEvent().update();
        }
      }
    }

    public boolean isResizeX() {
      return resize_x;
    }

    public GraphPanelUpdateEvent getUpdateEvent() {
      return UpdateEvent;
    }

    public void setUpdateEvent(GraphPanelUpdateEvent UpdateEvent) {
      this.UpdateEvent = UpdateEvent;
    }
  }
}
