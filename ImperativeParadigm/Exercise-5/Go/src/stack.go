package stack

import (
	"errors"
	"strconv"
)

type Stack struct {
	data     []interface{}
	literals []string
}

func (s *Stack) Push(x interface{}) error {
    var number int
    var err error

    // check if x is a string
    if _, isString := x.(string); isString {
        number, err = strconv.Atoi(x.(string))

        if err != nil {
            return errors.New("Invalid expression: " + x.(string))
        }
    } else {
        number = x.(int)
    }

	s.data = append(s.data, number)

	return nil
}

func (s *Stack) Pop() interface{} {
	x := s.data[len(s.data)-1]
	s.data = s.data[:len(s.data)-1]
	return x
}

func (s *Stack) Top() interface{} {
	return s.data[len(s.data)-1]
}

func (s *Stack) Empty() bool {
	return len(s.data) == 0
}

func (s *Stack) Size() int {
	return len(s.data)
}

func (s *Stack) Clear() {
	s.data = nil
}

func (s *Stack) IsLiteral(x string) bool {
	for _, literal := range s.literals {
		if literal == x {
			return true
		}
	}
	return false
}

func NewStack() *Stack {
	LITERALS := []string{"+", "-", "*", "/", "^"}
	return &Stack{nil, LITERALS}
}
