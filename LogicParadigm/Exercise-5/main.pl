% vim:ft=prolog

% Define the predicate `sub_cadenas` that returns all the lists that 
% contain a defined substring.
% EXAMPLE: sub_cadenas("la", ["la vaca", "el toro", "lavadora"], X).
% X = ["la vaca", "lavadora"].

% Base case: If the input list is empty, the filtered list is also empty.
sub_cadenas(_, [], []).
% Recursive rule: Check if the first string contains the substring, and include it in the filtered list if it does.
sub_cadenas(Subcadena, [String|Rest], Filtradas) :-
    sub_string(String, _, _, _, Subcadena), % Check if Subcadena is a substring of String.
    sub_cadenas(Subcadena, Rest, FiltradasRest), % Recursively filter the rest of the list.
    Filtradas = [String|FiltradasRest].
% Recursive rule: If the first string does not contain the substring, skip it.
sub_cadenas(Subcadena, [_|Rest], Filtradas) :-
    sub_cadenas(Subcadena, Rest, Filtradas).
% Ensure the input is a string (atom) before processing.
sub_cadenas(Subcadena, Lista, Filtradas) :-
    atom(Subcadena),
    is_list(Lista),
    sub_cadenas(Subcadena, Lista, Filtradas).
