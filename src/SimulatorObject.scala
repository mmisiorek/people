package net.misiorek.people;

trait SimulatorObject {
  var getParent: () => SimulatorObject;
  
  def nextRound(roundNumber: Int); 
  def subSimulatorObjects: List[SimulatorObject]; 
  
  def setParentFunc(func: () => SimulatorObject) {
    this.getParent = func;
  }
}