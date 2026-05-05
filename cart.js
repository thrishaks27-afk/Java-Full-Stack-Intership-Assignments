// Product Class
class Product {
    constructor(name, price) {
        this.name = name;
        this.price = price;
    }
}

// Cart Class
class Cart {
    constructor() {
        this.items = [];
    }

    addItem(product, quantity = 1) {
        this.items.push({ product, quantity });
    }

    removeItem(productName) {
        this.items = this.items.filter(item => item.product.name !== productName);
    }

    calculateTotal() {
        let total = 0;

        for (let item of this.items) {
            total += item.product.price * item.quantity;
        }

        return total;
    }

    applyDiscount(percent) {
        let total = this.calculateTotal();
        let discount = total * (percent / 100);
        return total - discount;
    }

    showCart() {
        console.log(this.items);
    }
}

// Test
let p1 = new Product("Phone", 20000);
let p2 = new Product("Shoes", 2000);

let cart = new Cart();

cart.addItem(p1, 1);
cart.addItem(p2, 2);

cart.showCart();

console.log("Total:", cart.calculateTotal());
console.log("After Discount:", cart.applyDiscount(10));

cart.removeItem("Shoes");
cart.showCart();