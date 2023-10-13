% vim:ft=prolog

% Base case: If the input list is empty, the result lists are also empty.
partir([], _, [], []).
% Recursive rule: Divide the list based on the threshold.
partir([X|Rest], Umbral, [X|Menores], Mayores) :-
    X =< Umbral,
    partir(Rest, Umbral, Menores, Mayores).
partir([X|Rest], Umbral, Menores, [X|Mayores]) :-
    X > Umbral,
    partir(Rest, Umbral, Menores, Mayores).
