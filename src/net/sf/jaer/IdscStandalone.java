package net.sf.jaer;

import eu.seebetter.ini.chips.davis.DAVIS240C;
import net.sf.jaer.aemonitor.AEMonitorInterface;
import net.sf.jaer.aemonitor.AEPacketRaw;
import net.sf.jaer.biasgen.Biasgen;
import net.sf.jaer.chip.AEChip;
import net.sf.jaer.hardwareinterface.HardwareInterface;
import net.sf.jaer.hardwareinterface.HardwareInterfaceFactory;

/** DOES NOT WORK YET !!! */
enum IdscStandalone {
  ;
  public static void main(String[] args) throws Exception {
    int ninterfaces = HardwareInterfaceFactory.instance().getNumInterfacesAvailable();
    System.out.println(ninterfaces);
    HardwareInterface hw = HardwareInterfaceFactory.instance().getFirstAvailableInterface();
    System.out.println(hw);
    AEChip chip = new DAVIS240C(hw);
    hw.open();
    if (!hw.isOpen()) {
      throw new RuntimeException("not open");
    }
    Biasgen bg = chip.getBiasgen();
    System.out.println("BIASGEN " + bg);
    if ((bg != null) && !bg.isInitialized()) {
      System.out.println("biasgen not initialized");
    }
    AEMonitorInterface aemon = (AEMonitorInterface) hw;
    Thread.sleep(10);
    for (int count = 0; count < 1000; ++count) {
      boolean overrunOccurred = aemon.overrunOccurred();
      if (overrunOccurred) {
        System.out.println("overrun");
      }
      // long tickUs = aemon.getTimestampTickUs();
      // System.out.println(tickUs);
      AEPacketRaw aeRaw = aemon.acquireAvailableEventsFromDriver();
      if (0 < aeRaw.getNumEvents()) {
        System.out.println(aeRaw.getNumEvents());
      }
      Thread.sleep(2);
    }
    System.out.println("shutdown");
    aemon.close();
    System.exit(0);
  }
}
