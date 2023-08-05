package main

import (
	"fmt"
	"strconv"
	"strings"
)

// checkWidth checks if the given width is valid
//
// Valid width must be greater than 0 and an odd number
func checkWidth(width int) error {
	if width < 1 {
		return fmt.Errorf("Width must be greater than 0")
	}

	if width%2 == 0 {
		return fmt.Errorf("Width must be an odd number")
	}

	return nil
}

// printDiamondFigure prints a diamond figure with the given width
//
// Example:
//
//	width = 5
//	Output:
//	    *
//	  * * *
//	* * * * *
//	  * * *
//	    *
func printDiamondFigure(width int) {
	middleIndex := width / 2

	// Print the upper and middle part of the figure
	for distanceFromMiddle := 0; distanceFromMiddle <= middleIndex; distanceFromMiddle++ {
		spaces := strings.Repeat("  ", middleIndex-distanceFromMiddle)
		asterisks := strings.Repeat("* ", distanceFromMiddle*2+1)
		fmt.Printf("%s%s\n", spaces, asterisks)
	}

	// Print the lower part of the figure
	for distanceFromMiddle := middleIndex - 1; distanceFromMiddle >= 0; distanceFromMiddle-- {
		spaces := strings.Repeat("  ", middleIndex-distanceFromMiddle)
		asterisks := strings.Repeat("* ", distanceFromMiddle*2+1)
		fmt.Printf("%s%s\n", spaces, asterisks)
	}
}

func main() {
	var inputWidth string
	fmt.Print("Enter width: ")
	fmt.Scanln(&inputWidth)

	width, err := strconv.Atoi(inputWidth)
	if err != nil {
		fmt.Println("Invalid input. Width must be an integer")
		return
	}

	if err := checkWidth(width); err != nil {
		fmt.Println(err)
		return
	}

	printDiamondFigure(width)
}
