// ================= Q1: Inheritance =================
class Person {
    constructor(name) {
        this.name = name;
    }
}

class Student extends Person {
    constructor(name, marks) {
        super(name);
        this.marks = marks;
    }

    showDetails() {
        console.log("Name: " + this.name + ", Marks: " + this.marks);
    }
}

let s1 = new Student("John", 90);
s1.showDetails();


// ================= Q2: Method Overriding =================
class Animal {
    eat() {
        console.log("Animal eats food");
    }
}

class Dog extends Animal {
    eat() {
        super.eat();
        console.log("Dog eats bones");
    }
}

let d = new Dog();
d.eat();


// ================= Q3: Encapsulation =================
class User {
    #password;

    setPassword(pass) {
        if (pass.length >= 6) {
            this.#password = pass;
        } else {
            console.log("Password too short");
        }
    }

    getPassword() {
        return this.#password;
    }
}

let u = new User();
u.setPassword("123");       // invalid
u.setPassword("123456");    // valid

console.log("Password:", u.getPassword());


// ================= Q4: Abstraction =================
class Laptop {

    #bootSystem() {
        console.log("Booting system...");
    }

    start() {
        this.#bootSystem();
        console.log("Laptop started");
    }
}

let l = new Laptop();
l.start();