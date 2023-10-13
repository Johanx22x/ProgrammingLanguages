% vim:ft=prolog

% Define a rule that flattens a list of lists into a single list.
% For example, aplanar([[1,2],[[3],4]], L) should return L = [1,2,3,4].
aplanar([], []).
aplanar([H|T], L2) :-
    is_list(H),                 % Check if H is a list.
    aplanar(H, FlatH),          % Recursively flatten H.
    aplanar(T, Rest),           % Recursively flatten the rest of the list.
    append(FlatH, Rest, L2).    % Append the flattened H and the rest to get the result.
aplanar([H|T], [H|L2]) :-
    \+ is_list(H),              % Check if H is not a list.
    aplanar(T, L2).             % Recursively flatten the rest of the list.

% Helper predicate to check if an element is a list.
is_list(X) :- is_list(X, []).
is_list([], _).
is_list([_|_], _).

