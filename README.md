# Prototype-LLD

This project was created to understand the <b>Prototype design pattern</b>.


## Prototype Pattern
The prototype design pattern is a creational design pattern that allows us to create new objects by cloning existing objects. Instead of creating objects from scratch, we can make copies of an existing object, called a prototype, and modify those copies as needed.

Let's understand more via an example later.

<b>Client</b> : Person that handles batches of students for an ed-tech company.
<br>
What does he want to do : To add new student details and assign a batch or modify existing details(like batch change).<br>
To understand more about Prototype pattern, we have two types of Students(classes) -> 1. Student(Regular) 2. Intelligent Student.<br>
Intelligent Student has an extra property -> IQ<br>
Rest all properties lie with the Student class -> Name, Age, BatchID, BatchName



### Classes Used
1. Student - This class has all the Student details.
2. IntelligentStudent - This class an extra 'IQ' attribute.
3. Prototype - This an interface that gets implemented by Student to make sure that Student and IntelligentStudent have a copy() function that will create a clone of the object passed.
4. StudentRegistry - We wouldn't want client to create the original objects again and again and the application might need those objects at other places as well. Therefore, we have registry(like a central repository) that will hold the original objects and the client or any class can directly fetch those objects from here.
5. Client - Here the client can fetch the original objects and make copies and modifications.

### Prototype design pattern example:
Let's imagine you are building a game that involves creating different types of monsters. Each monster has various attributes like health, attack power, and special abilities. Instead of defining each monster's attributes from scratch every time you want to create a new monster, you can use the prototype design pattern.

Here's how it works:

Create a prototype object, let's say a "Monster" object, with default attribute values. This object serves as a blueprint or template for creating other monsters.

When you want to create a new monster, instead of creating it from scratch, you clone the prototype object. This creates a new instance with the same initial attribute values.

You can then modify the cloned object to customize it as needed. For example, you can change the health, attack power, or assign unique special abilities to the new monster.

By using the prototype design pattern, you avoid the overhead of creating objects from scratch and gain flexibility in creating variations of objects.

Here's an example of the prototype design pattern in Java:

```java
import java.util.ArrayList;
import java.util.List;

class Monster implements Cloneable {
    private int health;
    private int attackPower;
    private List<String> abilities;

    public Monster(int health, int attackPower, List<String> abilities) {
        this.health = health;
        this.attackPower = attackPower;
        this.abilities = abilities;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void addAbility(String ability) {
        abilities.add(ability);
    }

    public Monster clone() throws CloneNotSupportedException {
        List<String> clonedAbilities = new ArrayList<>(abilities);
        return new Monster(health, attackPower, clonedAbilities);
    }

    public void printInfo() {
        System.out.println("Health: " + health);
        System.out.println("Attack Power: " + attackPower);
        System.out.println("Abilities: " + abilities);
    }
}

public class PrototypeExample {
    public static void main(String[] args) {
        // Create a prototype monster
        Monster prototypeMonster = new Monster(100, 10, new ArrayList<>());
        prototypeMonster.addAbility("Fireball");

        try {
            // Create a new monster by cloning the prototype
            Monster newMonster = prototypeMonster.clone();
            newMonster.setHealth(150);
            newMonster.addAbility("Ice Blast");

            // Create another monster
            Monster anotherMonster = prototypeMonster.clone();
            anotherMonster.setAttackPower(15);

            // Print the attributes of the monsters
            newMonster.printInfo();
            anotherMonster.printInfo();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
```