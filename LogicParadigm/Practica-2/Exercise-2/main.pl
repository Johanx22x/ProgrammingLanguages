% vim:ft=prolog

% Person follows the structure: Name, Lastname, Chromosome (Binary list of 10 elements)
person("Mike",      "Tyson",        [1,0,1,0,1,0,1,0,1,0]).
person("John",      "Doe",          [0,1,0,1,0,1,0,1,0,1]).
person("Mark",      "Zuckerberg",   [1,1,1,1,1,1,1,1,1,1]).
person("Steve",     "Jobs",         [0,0,0,0,0,0,0,0,0,0]).
person("Elena",     "Colors",       [1,1,0,0,1,1,0,0,1,1]).
person("Leonardo",  "Da Vinci",     [0,0,1,1,0,0,1,1,0,0]).
person("Albert",    "Einstein",     [1,0,0,1,0,0,1,0,0,1]).

similarity([], [], 0).
similarity([H1|T1], [H2|T2], R) :- 
    similarity(T1, T2, R1), 
    ((H1 =:= H2) -> R is R1 + 1; R is R1).

most_similar(Person, Chromosome) :- 
    person(Person, _, PersonChromosome),
    similarity(PersonChromosome, Chromosome, MaxSimilarity),
    \+ (person(_, _, OtherChromosome), similarity(OtherChromosome, Chromosome, OtherSimilarity), OtherSimilarity > MaxSimilarity), !.

% Usage: most_similar(Person, Chromosome).
% Example: most_similar(P, [1,0,1,0,1,0,1,0,1,1]).
% P = "Mike" ;