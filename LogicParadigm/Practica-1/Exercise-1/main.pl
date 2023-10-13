% vim:ft=prolog

% Define a rule that takes a list of numbers and returns the sum of the numbers.
sumList([], 0).
sumList([H|T], Sum) :- sumList(T, Sum1), Sum is H + Sum1.

