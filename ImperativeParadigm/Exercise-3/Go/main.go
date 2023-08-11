package main

import (
	"fmt"
	"math/rand"
	"time"
)

const (
	LEFT = iota
	RIGHT
)

// areParamsValid checks if the parameters are valid
// and returns an error if not.
//
// elements must be a pointer to a slice,
// amount must be positive,
// direction must be LEFT (0) or RIGHT (1)
func areParamsValid(amount int, direction int) error {
	// Check if amount is positive
	if amount < 0 {
		return fmt.Errorf("amount must be positive")
	}

	// Check if direction is valid
	if direction != LEFT && direction != RIGHT {
		return fmt.Errorf("direction must be LEFT (0) or RIGHT (1)")
	}

	return nil
}

// rotateSlice rotates the elements of a slice by the given amount
// in the given direction.
//
// elements must be a pointer to a slice of any type.
// direction must be LEFT (0) or RIGHT (1)
// amount must be positive
//
// Example:
//
//	elements = [1, 2, 3, 4, 5]
//	direction = LEFT
//	amount = 2
//	result = [3, 4, 5, 1, 2]
func rotateSlice[T any](elements *[]T, direction int, amount int) error {
	// Check if parameters are valid
	if err := areParamsValid(amount, direction); err != nil {
		return err
	}

	rotation := amount % len(*elements)

	// Rotate the elements
	if direction == LEFT {
		*elements = append((*elements)[rotation:], (*elements)[:rotation]...)
	} else {
		*elements = append((*elements)[len(*elements)-rotation:], (*elements)[:len(*elements)-rotation]...)
	}

	return nil
}

func main() {
	// Create a new private random source with a custom seed
	random := rand.New(rand.NewSource(time.Now().UnixNano()))

	// Create a slice of 10 integers
	elements := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
	ptrToElements := &elements

	for i := 0; i < 10; i++ {
		// Rotate the elements by a random amount in a random direction
		amount := random.Intn(9) + 1 // To ignore 0
		direction := random.Intn(2)

		fmt.Printf("Slice: %v\n", elements)

		err := rotateSlice(ptrToElements, direction, amount)
		if err != nil {
			panic(err)
		}

		fmt.Printf("Has been rotated by %d", amount)
		if direction == LEFT {
			fmt.Printf(" to the left\n")
		} else {
			fmt.Printf(" to the right\n")
		}
		fmt.Printf("Result: %v\n\n", elements)
	}
}
