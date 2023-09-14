module RutaCorta

open Recipientes
// Grafo de prueba
let con_paredes = [
    ("I", ["2"]);
    ("1", ["7"]);
    ("2", ["3"; "8"; "I"]);
    ("3", ["2"; "4"; "9"]);
    ("4", ["3"; "10"]);
    ("5", ["6"; "11"]);
    ("6", ["5"]);
    ("7", ["1"; "13"]);
    ("8", ["9"; "2"]);
    ("9", ["3"; "8"]);
    ("10", ["4"; "16"]);
    ("11", ["5"; "17"]);
    ("12", ["18"]);
    ("13", ["7"; "14"]);
    ("14", ["13"; "15"; "20"]);
    ("15", ["14"; "21"]);
    ("16", ["10"; "22"]);
    ("17", ["11"; "23"]);
    ("18", ["12"; "24"]);
    ("19", ["25"]);
    ("20", ["14"; "26"]);
    ("21", ["15"; "22"]);
    ("22", ["16"; "21"]);
    ("23", ["17"; "23"]);
    ("24", ["18"; "30"]);
    ("25", ["19"; "31"]);
    ("26", ["20"; "27"]);
    ("27", ["26"; "28"]);
    ("28", ["27"; "29"; "34"]);
    ("29", ["28"; "23"]);
    ("30", ["24"; "36"]);
    ("31", ["25"; "32"]);
    ("32", ["31"; "33"; "F"]);
    ("33", ["32"; "34"]);
    ("34", ["33"; "28"; "35"]);
    ("35", ["34"; "36"]);
    ("36", ["35"; "30"]);
    ("F", ["32"])
]

let sin_paredes = [
    ("I", ["2"]);
    ("1", ["2"; "7"]);
    ("2", ["1"; "3"; "8"; "I"]);
    ("3", ["2"; "4"; "9"]);
    ("4", ["3"; "5"; "10"]);
    ("5", ["4"; "6"; "11"]);
    ("6", ["5"; "12"]);
    ("7", ["1"; "8"; "13"]);
    ("8", ["2"; "7"; "9"; "14"]);
    ("9", ["3"; "8"; "10"; "15"]);
    ("10", ["4"; "9"; "11"; "16"]);
    ("11", ["5"; "10"; "12"; "17"]);
    ("12", ["6"; "11"; "18"]);
    ("13", ["7"; "14"; "19"]);
    ("14", ["8"; "13"; "15"; "20"]);
    ("15", ["9"; "14"; "16"; "21"]);
    ("16", ["10"; "15"; "17"; "22"]);
    ("17", ["11"; "16"; "18"; "23"]);
    ("18", ["12"; "17"; "24"]);
    ("19", ["13"; "20"; "25"]);
    ("20", ["14"; "19"; "21"; "26"]);
    ("21", ["15"; "20"; "22"; "27"]);
    ("22", ["16"; "21"; "23"; "28"]);
    ("23", ["17"; "22"; "24"; "29"]);
    ("24", ["18"; "23"; "30"]);
    ("25", ["19"; "26"; "31"]);
    ("26", ["20"; "25"; "27"; "32"]);
    ("27", ["21"; "26"; "28"; "33"]);
    ("28", ["22"; "27"; "29"; "34"]);
    ("29", ["23"; "28"; "30"; "35"]);
    ("30", ["24"; "29"; "36"]);
    ("31", ["25"; "32"]);
    ("32", ["26"; "31"; "33"; "F"]);
    ("33", ["27"; "32"; "34"]);
    ("34", ["33"; "28"; "35"]);
    ("35", ["34"; "29"; "36"]);
    ("36", ["35"; "30"]);
    ("F", ["32"])
]

// Función para generar vecinos
let rec vecinos nodo grafo =
    match grafo with
    | [] -> []
    | (head, neighbors) :: rest ->
        if head = nodo then neighbors
        else vecinos nodo rest

// Función para extender una ruta
let extender ruta grafo = 
    List.filter
        (fun x -> x <> [])
        (List.map  (fun x -> if (miembro x ruta) then [] else x::ruta) (vecinos (List.head ruta) grafo)) 

// This function finds the shortest path
let rec solve grafo =
    let rec prof_aux fin ruta grafo =
        if List.isEmpty ruta then []
        elif (List.head (List.head ruta)) = fin then
            List.rev (List.head ruta) :: prof_aux fin ((extender (List.head ruta) grafo) @ (List.tail ruta)) grafo       
        else
            prof_aux fin ((List.tail ruta) @ (extender (List.head ruta) grafo)  ) grafo
    let rutas = prof_aux "F" [["I"]] grafo
    List.minBy (fun x -> List.length x) rutas

// NOTE: This function does not find the shortest path, only the first ocurrence
let rec solve_one_path grafo =
    let rec prof_aux fin ruta grafo =
        if List.isEmpty ruta then []
        elif (List.head (List.head ruta)) = fin then
            List.rev (List.head ruta) // :: prof_aux fin ((extender (List.head ruta) grafo) @ (List.tail ruta)) grafo       
        else
            prof_aux fin ((List.tail ruta) @ (extender (List.head ruta) grafo)  ) grafo
    prof_aux "F" [["I"]] grafo
