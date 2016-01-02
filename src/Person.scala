package net.misiorek.people;

import java.util.Random;

class Person(var _name: String, var _surname: String, var _age: Int, var _children: List[Person], 
              val _mother: Person, val _father: Person, val _sex: Boolean) 
              extends SimulatorObject {
  var _marriedPerson: Person;
  
  def name: String = this._name; 
  def surname: String = this._surname;
  def age: Int = this._age; 
  def children: List[Person] = this._children; 
  
  def mother: Person = this._mother; 
  def father: Person = this._father; 
  
  def marriedPerson: Person = this._marriedPerson; 
  def setMarriedPerson(p: Person) { this._marriedPerson = p; }
  
  def subSimulatorObjects: List[SimulatorObject] = List.empty[SimulatorObject];
  
  def nextRound(roundNumber: Int) { 
    
  }
}

object Person {
  val SEX_MALE: Boolean = true; 
  val SEX_FEMALE: Boolean = false;
  
  private val random = new Random();
  
  def createBaby(mother: Person, father: Person): Person = {
    val sex = random.nextBoolean(); 
    val name: String = this.chooseName(sex);
    
    new Person(name, father.surname, 0, List.empty[Person], mother, father, sex);
  }
  
  def newPerson: Person = {
    val sex = random.nextBoolean(); 
    val name: String = this.chooseName(sex); 
    val surname: String = this.createNewSurname(); 
    
    new Person(name, surname, 0, List.empty[Person], null, null, sex);
  }
  
  def chooseName(sex: Boolean): String = {
    var names: Array[String] = null; 
    if(sex == this.SEX_MALE) {
      names = Array("Andrzej", "Boleslaw", "Czeslaw", "Dariusz", "Edmund", "Franciszek", 
                      "Grzegorz", "Jerzy", "Jan", "Krzysztof", "Lucjusz", "Lukasz", "Marcin", "Mariusz", 
                      "Marek", "Marcel", "Aleksander", "Przemyslaw", "Robert", "Sebastian", "Tomek", 
                      "Zenon", "Walery");
    } else {
      names = Array("Anna", "Bozena", "Celina", "Daria", "Ewa", "Franciszka", "Genowefa", "Jolanta", 
                    "Krystyna", "Katarzyna", "Lucja", "Martyna", "Natalia", "Aleksandra", "Patrycja", 
                    "Rozalia", "Sara", "Tracja", "Zofia", "Waleria");
    } 
    
    this.randomElement(names);
  }
  
  def createNewSurname(): String = {
    val firstPartArr: Array[String] = Array("Mar", "Kar", "Jon", "Mi", "Mo", "Ar", "Jan", "Mol");
    val middlePartArr: Array[String] = Array("czaw", "sio", "kloro", "ion", "war", "tal"); 
    val lastPartArr: Array[String] = Array("ski", "cki", "rek", "ak", "wek", "sek", "tek");
    
    this.randomElement(firstPartArr)+this.randomElement(middlePartArr)+this.randomElement(lastPartArr);
  }
  
  def randomElement(arr: Array[String]): String = {
    arr(random.nextInt(arr.length)); 
  }
}