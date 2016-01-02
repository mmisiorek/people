package net.misiorek.people;

import java.util.Random;

class PlaceOfLiving(_name: String, _people: List[Person])
              extends SimulatorObject {
  def name: String = this._name; 
  def people: List[Person] = this._people; 
  
  def subSimulatorObjects: List[SimulatorObject] = {
    val list: List[SimulatorObject] = List.empty[SimulatorObject]; 
    var obj: SimulatorObject = null; 
    
    for(obj <- this._people) {
      list :+ obj; 
    }
    
    list
  }
  
  def nextRound(roundNumber: Int) {
    
  }
  
  def findWomanToMarry: Person = { 
    val list = List.empty[Person]; 
    
    people.foreach {
      if(_.sex == Person.SEX_FEMALE) {
        list :+ _; 
      }
    }
    
    var random = new Random(); 
  }
}

object PlaceOfLiving {
  def createNewVillage(name: String, howManyPeople: Int): PlaceOfLiving = {
    val people = List.empty[Person]; 
    val i = 0; 
    
    for(i <- 0 until howManyPeople) {
      people :+ Person.newPerson; 
    }
    
    val placeOfLiving = new PlaceOfLiving(name, people); 
    
    placeOfLiving.people.foreach {
      _.setParentFunc {
        return placeOfLiving;
      }
    }
    
    return placeOfLiving;
  }
}