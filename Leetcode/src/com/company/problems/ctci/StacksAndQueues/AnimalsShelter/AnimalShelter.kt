package com.company.problems.ctci.StacksAndQueues.AnimalsShelter

import com.company.problems.ctci.StacksAndQueues.Queue
import com.company.problems.ctci.Utils.Node
import java.lang.Exception

open class Animal(var name: String)
class Cat(name: String) : Animal(name)
class Dog(name: String) : Animal(name)

enum class AnimalType {
    Cat,
    Dog,
    Animal
}

class AnimalShelter {

    var dogsQueue = AnimalQueue()
    var catsQueue = AnimalQueue()
    var age: Int = 0

    fun enqueueAnimal(animal: Animal) {
        if (animal is Cat) {
            enqueueCat(animal)
        } else if (animal is Dog) {
            enqueueDog(animal)
        }
    }

    fun dequeueAnimal(animalType: AnimalType): Animal? {
        var animal: Animal? = null
        if (animalType == AnimalType.Cat) {
            animal = dequeueCat()
        } else if (animalType == AnimalType.Dog) {
            animal = dequeueDog()
        } else {

            if (catsQueue.isEmpty() && dogsQueue.isEmpty()) {
                throw Exception("Animal Shelter is empty")
            }
            if (catsQueue.isEmpty()) {
                animal = dequeueDog()
            } else if (dogsQueue.isEmpty()) {
                animal = dequeueCat()
            } else {
                var cat = catsQueue.peek()
                var dog = dogsQueue.peek()
                animal = if (cat!!.age < dog!!.age) {
                    dequeueCat()
                } else {
                    dequeueDog()
                }
            }
        }

        return animal
    }

    private fun enqueueCat(cat: Cat) {
        catsQueue.add(cat, ++age)
    }

    private fun enqueueDog(dog: Dog) {
        dogsQueue.add(dog, ++age)
    }

    private fun dequeueDog(): Dog? {
        if (dogsQueue.isEmpty()) {
            throw Exception("No Dogs in Shelter!")
        }
        var peek = dogsQueue.peek()
        dogsQueue.remove()

        return if (peek != null) {
            peek.animal as Dog
        } else {
            null
        }
    }

    private fun dequeueCat(): Cat? {
        if (catsQueue.isEmpty()) {
            throw Exception("No Cats in Shelter!")
        }
        var peek = catsQueue.peek()

        catsQueue.remove()

        return if (peek != null) {
            peek.animal as Cat
        } else {
            null
        }
    }

}