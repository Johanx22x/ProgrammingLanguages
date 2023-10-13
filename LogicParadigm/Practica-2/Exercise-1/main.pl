% vim:ft=prolog

% Representation of the following unidirectional graph:
%
%   I --20--> B --35--> F  
%    \       ^ \       ^
%     50    /   40    / 
%      \  15     \   5
%       v /       v /
%        A --25--> C 
%
conected(I, B, 20).
conected(I, A, 50).
conected(B, F, 35).
conected(B, C, 40).
conected(A, C, 25).
conected(A, B, 15).
conected(C, F, 5).

path(I,F,R) :- path_aux(I,F,[],R).

path_aux(F,F,_,[F]).
path_aux(I,F,V,[I|R]) :- 
    conected(I,X,_), 
    not(member(X,V)), 
    path_aux(X,F,[I|V],R).

weight(X,Y,W) :- conected(X,Y,W).

sum([],0).
sum([H|T],R) :- sum(T,R1), R is R1 + H.

path_weight(I,F,R) :- path(I,F,P), path_weight_aux(P,R).

path_weight_aux([_],0).
path_weight_aux([H1,H2|T],R) :- 
    weight(H1,H2,W), 
    path_weight_aux([H2|T],R1), 
    R is R1 + W.

shortest_path(I,F,R) :- 
    findall((P,W), (path(I,F,P), path_weight_aux(P,W)), L), 
    sort(2, @=<, L, [(R,_)|_]).

% Usage: shortest_path(Start, End, Path).
% Example: shortest_path(a, f, R).
% R = [a, b, f] ;