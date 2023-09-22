% vim:ft=prolog

% NOTE: This program takes lists as sets, so duplicates elements are treated as 
% one element.
% EXAMPLE: [0,0,0,0,0] is subset of [0,1,2,3]

% Define a rule that takes two sets and checks if the first is a subset of the second.
subconj([], _).
subconj([H|T], Set) :-
    member(H, Set),
    subconj(T, Set).
