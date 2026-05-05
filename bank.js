// Base Account Class
class Account {
    #balance = 0;
    #pin;
    transactions = [];

    constructor(pin) {
        this.#pin = pin;
    }

    verifyPin(pin) {
        return this.#pin === pin;
    }

    deposit(amount) {
        if (amount > 0) {
            this.#balance += amount;
            this.transactions.push("Deposited: " + amount);
        }
    }

    withdraw(amount) {
        if (amount > 0 && amount <= this.#balance) {
            this.#balance -= amount;
            this.transactions.push("Withdrawn: " + amount);
        } else {
            console.log("Invalid withdraw");
        }
    }

    getBalance() {
        return this.#balance;
    }

    showTransactions() {
        console.log(this.transactions);
    }
}

// Savings Account
class SavingsAccount extends Account {
    calculateInterest() {
        let interest = this.getBalance() * 0.05;
        console.log("Interest:", interest);
    }
}

// Current Account
class CurrentAccount extends Account {
    loanFeature() {
        console.log("Loan available");
    }
}

// Test
let acc = new SavingsAccount(1234);

if (acc.verifyPin(1234)) {
    acc.deposit(1000);
    acc.withdraw(200);
    console.log("Balance:", acc.getBalance());
    acc.showTransactions();
    acc.calculateInterest();
}