package main

import (
	"errors"
	"fmt"
	"math/rand"
	"time"
)

type Shoe struct {
    brand string
    price int 
    size int
}

func (s *Shoe) setBrand(brand string) {
    s.brand = brand
}

func (s *Shoe) setPrice(price int) error {
    if price < 0 {
        return errors.New("Price must be positive")
    }

    s.price = price

    return nil
}

func (s *Shoe) setSize(size int) error {
    if size < 34 || size > 44 {
        return errors.New("Size must be between 34 and 44")
    }

    s.size = size

    return nil
}

type Inventory struct {
    shoe Shoe
    stock int
}

func (i *Inventory) setShoe(shoe Shoe) {
    i.shoe = shoe
}

func (i *Inventory) setStock(stock int) error {
    if stock < 0 {
        return errors.New("Stock must be positive")
    }

    i.stock = stock

    return nil
}

type Store struct {
    inventory []Inventory
}

func (s *Store) addShoe(inventory Inventory) {
    s.inventory = append(s.inventory, inventory)
}

func (s *Store) sellShoe(brand string, size int) error {
    for i, inv := range s.inventory {
        if inv.shoe.brand == brand && inv.shoe.size == size {
            if inv.stock > 0 {
                s.inventory[i].stock--
                return nil
            } else {
                return errors.New("No stock")
            }
        }
    }
    return errors.New("Shoe not found")
}

func (s *Store) printInventory() {
    for _, inv := range s.inventory {
        fmt.Printf("Brand: %s\n", inv.shoe.brand)
        fmt.Printf("Price: $%d\n", inv.shoe.price)
        fmt.Printf("Size: %d\n", inv.shoe.size)
        fmt.Printf("Stock: %d\n", inv.stock)
        fmt.Println()
    }
}

func main() {
	// Create a new private random source with a custom seed
	random := rand.New(rand.NewSource(time.Now().UnixNano()))

    brands := []string{ "Nike", "Adidas", "Puma", "Reebok", "Converse", "Vans", "New Balance", "Fila", "Under Armour", "Skechers", "Asics", "Crocs", "Salomon", "Balenciaga", "Gucci", "Jordan", "Yeezy", "Timberland", "Dr. Martens"}

    store := Store{}

    for i := 0; i < len(brands); i++ {
        shoe := Shoe{}

        shoe.setBrand(brands[i])

        if i == 2 { // Puma will have a negative price to test the error
            err := shoe.setPrice(-10000)
            if err != nil {
                println(err.Error())
                continue
            }
        }

        err := shoe.setPrice(random.Intn(10000))
        if err != nil {
            println(err.Error())
            continue
        }

        if i == 3 { // Reebok will have a size outside the range to test the error
            err := shoe.setSize(100)
            if err != nil {
                println(err.Error())
                continue
            }
        }

        if i >= len(brands)-2 { // Dr. Martens will have a fixed size to test
            err := shoe.setSize(40)
            if err != nil {
                println(err.Error())
                continue
            }
        } else {
            err = shoe.setSize(random.Intn(10) + 34)
            if err != nil {
                println(err.Error())
                continue
            }
        }

        inventory := Inventory{}

        inventory.setShoe(shoe)

        if i == 4 { // Converse will have a negative stock to test the error 
            err := inventory.setStock(-100)
            if err != nil {
                println(err.Error())
                continue
            }
        }

        if i == len(brands)-1 { // Dr. Martens will have a fixed stock to test the error
            err := inventory.setStock(0)
            if err != nil {
                println(err.Error())
            }
        } else if i == len(brands)-2 { // Timberland will have a fixed stock to test
            err := inventory.setStock(100)
            if err != nil {
                println(err.Error())
                continue
            }
        } else {
            err = inventory.setStock(random.Intn(100))
            if err != nil {
                println(err.Error())
                continue
            }
        }

        store.addShoe(inventory)
    }

    store.printInventory()

    // Could not sell Dr. Martens because there is no stock
    err := store.sellShoe("Dr. Martens", 40)
    if err != nil {
        fmt.Println(err.Error())
    }

    fmt.Println()

    for i := 0; i < 100; i++ {
        // Timberland will be sold
        err = store.sellShoe("Timberland", 40)
        if err != nil {
            fmt.Println(err.Error())
        } else {
            fmt.Println("Sold!")
        }
    }

    fmt.Println()

    // Timberland is out of stock now
    store.printInventory()

    fmt.Println()

    // Validate
    // Timberland can't be sold because there is no stock
    err = store.sellShoe("Timberland", 40)
    if err != nil {
        fmt.Println(err.Error())
    } else {
        fmt.Println("Sold!")
    }
}
