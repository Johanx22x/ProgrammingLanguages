package main

import (
    "fmt"
    "sort"
)

const (
    Name = iota
    Amount
    Price
)

// product is a struct that represents a product in the store
// name: name of the product
// amount: amount of units of the product 
// price: price of the product
type product struct {
    name string
    amount int
    price int
}

type products []product

// MIN_PRODUCT_AMOUNT is the minimum amount of units that a product must have
const MIN_PRODUCT_AMOUNT = 10

// append appends a product to the list of products
// 
// If the product already exists in the list, it will sum the amount of the
// product and update the price
// 
// If the product doesn't exist in the list, it will append the product to the
// list
func (l *products) append(p product) {
    match, err := l.search(p.name)
    if err == nil {
        match.amount += p.amount 
        match.price = p.price
        return
    }

    *l = append(*l, p)
}

// appendMany appends many products to the list of products
//
// It calls append for each product
func (l *products) appendMany(ps ...product) {
    for _, p := range ps {
        l.append(p)
    }
}

// search searches a product in the list of products
//
// If the product is found, it returns the product and nil
//
// If the product is not found, it returns nil and an error
func (l *products) search(name string) (*product, error) {
    for index, p := range *l {
        if p.name == name {
            return &(*l)[index], nil
        }
    }
    return nil, fmt.Errorf("product %s not found", name)
}

// index returns the index of a product in the list of products
//
// If the product is found, it returns the index and nil
//
// If the product is not found, it returns -1 and an error
func (l *products) index(name string) (int, error) {
    for index, p := range *l {
        if p.name == name {
            return index, nil
        }
    }

    return -1, fmt.Errorf("product %s not found", name)
}

// remove removes a product from the list of products
//
// If the product is found, it removes the product and returns nil
//
// If the product is not found, it returns an error
func (l *products) remove(name string) error {
    _, err := l.search(name)
    if err != nil {
        return err
    }

    matchIndex, err := l.index(name)
    *l = append((*l)[:matchIndex], (*l)[matchIndex+1:]...)
    return nil
}

// sell sells a product 
//
// If the product is found, it subtracts the amount of the product and returns
// nil
//
// If the product is not found, it returns an error
func (l *products) sell(name string, amount int) error {
    match, err := l.search(name)
    if err != nil {
        return err
    }

    if match.amount < amount {
        return fmt.Errorf("product %s has only %d units", name, match.amount)
    }

    match.amount -= amount

    if match.amount == 0 {
        fmt.Println("product", name, "now is out of stock, removing from list...")
        return l.remove(name)
    }

    return nil
}

// getMinExistences returns a list of products that have less than 
// MIN_PRODUCT_AMOUNT units
// 
// If there are no products with less than MIN_PRODUCT_AMOUNT units, it returns
// an empty list
func (l *products) getMinExistences() products {
    var minExistences products
    for _, p := range *l {
        if p.amount <= MIN_PRODUCT_AMOUNT {
            minExistences.append(p)
        }
    }
    return minExistences
}

// fillMinExistences fills the list of products with the products that have less
// than MIN_PRODUCT_AMOUNT units
//
// It calls append for each product after subtracting the amount of the product
// to MIN_PRODUCT_AMOUNT
func (l *products) fillMinExistences(minExistences products) {
    for _, p := range minExistences {
        p.amount = MIN_PRODUCT_AMOUNT - p.amount
        l.append(p)
    }
}

// sortByKey sorts the list of products by a key 
//
// If the key is Name, it sorts the list by name 
// 
// If the key is Amount, it sorts the list by Amount
// 
// If the key is Price, it sorts the list by Price
func (l *products) sortByKey(key int, reverse bool) {
    switch key {
    case Name:
        sort.Slice(*l, func(i, j int) bool {
            if reverse {
                return (*l)[i].name > (*l)[j].name
            }
            return (*l)[i].name < (*l)[j].name
        })
    case Amount:
        sort.Slice(*l, func(i, j int) bool {
            if reverse {
                return (*l)[i].amount > (*l)[j].amount
            }
            return (*l)[i].amount < (*l)[j].amount
        })
    case Price:
        sort.Slice(*l, func(i, j int) bool {
            if reverse {
                return (*l)[i].price > (*l)[j].price
            }
            return (*l)[i].price < (*l)[j].price
        })
    }
}

func main() {
    var products products

	products.append(product{"arroz", 15, 2500})
	products.append(product{"frijoles", 4, 2000})
	products.append(product{"leche", 8, 1200})
	products.append(product{"leche", 2, 1300})
	products.append(product{"café", 12, 4500})
    
    products.appendMany(
        product{"arroz", 15, 3000},
        product{"maiz", 2, 4000},
        product{"mani", 8, 1200},
    )

    fmt.Println("Initial list...")
    fmt.Println(products)
    fmt.Println()

    fmt.Println("Selling products...")
    products.sell("arroz", 10)
    products.sell("leche", 10)
    products.sell("café", 10)
    fmt.Println(products)
    fmt.Println()

    fmt.Println("Min existences...")
    fmt.Println(products.getMinExistences())
    fmt.Println()

    fmt.Println("filling min existences...")
    products.fillMinExistences(products.getMinExistences())
    fmt.Println(products)
    fmt.Println()

    fmt.Println("Sorting by name... (reverse)")
    products.sortByKey(Name, true)
    fmt.Println(products)
    fmt.Println()

    fmt.Println("Sorting by amount...")
    products.sortByKey(Amount, false)
    fmt.Println(products)
    fmt.Println()

    fmt.Println("Sorting by price...")
    products.sortByKey(Price, false)
    fmt.Println(products)
    fmt.Println()
}
