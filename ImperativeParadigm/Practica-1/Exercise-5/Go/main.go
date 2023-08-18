package main

import (
	"exercise-5/src"
	"fmt"
	"strings"
)

func main() {
    expr := "2 3 + 4 * 5 - 6 7 + 8 * 100 - ^"
    fmt.Println("Expression:", expr)

    stack := stack.NewStack()

    for _, c := range strings.Fields(expr) {
        if stack.IsLiteral(c) && stack.Size() < 2 {
            panic("Cannot perform operation on less than two operands")
        }

        if stack.IsLiteral(c) {
            a := stack.Pop().(int)
            b := stack.Pop().(int)

            switch c {
            case "+":
                stack.Push(b + a)
            case "-":
                stack.Push(b - a)
            case "*":
                stack.Push(b * a)
            case "/":
                stack.Push(b / a)
            case "^":
                base := b
                for i := 1; i < a; i++ {
                    b *= base 
                }
                stack.Push(b)
            }
            continue
        }

        err := stack.Push(c)
        if err != nil {
            panic(err)
        }
    }
    
    fmt.Println("Result:", stack.Pop())
}
