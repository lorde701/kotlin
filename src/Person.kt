package dsdf.sd

import java.io.File

class Person(
        val lastName: String,
        val name: String,
        var phoneNum: String
)

fun Person.printInfo() {
    println("Фамилия - ${this.lastName}, имя - ${this.name}, номер телефона - ${this.phoneNum}")
}

fun createPersonListFromFile(fileName: String): List<Person> {
    val persons: MutableList<Person> = mutableListOf()

    File(fileName).forEachLine {
        val data = it.split(";")
        persons.add(Person(data[0], data[1], data[2]))
    }
    return persons

}

fun findPersonByName(personsList: List<Person>, name: String): List<Person> {
    val findByName: (Person) -> Boolean = { it.name == name }
    return personsList.filter(findByName)
}

fun findPersonByLastName(personsList: List<Person>, lastName: String): List<Person> {
    val findByLastName: (Person) -> Boolean = { it.lastName == lastName }
    return personsList.filter(findByLastName)
}


fun main(args: Array<String>) {
    val persons = createPersonListFromFile("./resources/persons.txt")
    persons.forEach { it.printInfo() }

    println("\nПетров:")
    val lastName = "Петров"
    val petrovPersons = findPersonByLastName(persons, lastName)
    if (petrovPersons.isEmpty()) {
        println("$lastName не найден")
    } else {
        petrovPersons.forEach { it.printInfo() }
    }

    println("\nПетр:")
    val name = "Петр"
    val petrPersons = findPersonByName(persons, name)
    if (petrPersons.isEmpty()) {
        println("$name не найден")
    } else {
        petrPersons.forEach { it.printInfo() }
    }

    println("\nПетр Петров:")
    val petrPetrov = findPersonByName(findPersonByLastName(persons, lastName), name)
    petrPetrov.forEach { it.printInfo() }


}