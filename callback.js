// ================= Task 1: Greeting Callback =================
function greetUser(name, callback) {
    callback(name);
}

function sayHello(name) {
    console.log("Hello " + name);
}

greetUser("Trisha", sayHello);


// ================= Task 2: Calculator Callback =================
function calculate(a, b, operation, callback) {
    let result;

    if (operation === "add") {
        result = a + b;
    } else if (operation === "sub") {
        result = a - b;
    } else if (operation === "mul") {
        result = a * b;
    } else if (operation === "div") {
        result = a / b;
    }

    callback(result);
}

function showResult(result) {
    console.log("Result:", result);
}

calculate(10, 5, "add", showResult);


// ================= Task 3: Async Callback =================
function showMessage(message, callback) {
    setTimeout(function () {
        console.log(message);
        callback();
    }, 2000);
}

function done() {
    console.log("Message displayed after delay");
}

showMessage("Hello after 2 seconds!", done);