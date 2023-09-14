module RutaCorta

open Recipientes

// Grafo de prueba
let grafo = [
    ("i", ["a"; "b"], ["2"; "3"]);
    ("a", ["i"; "c"; "d"], ["2"; "6"; "3"]);
    ("b", ["i"; "c"; "d"], ["3"; "4"; "7"]);
    ("c", ["a"; "b"; "x"], ["6"; "4"; "1"]);
    ("d", ["a"; "b"; "f"], ["3"; "7"; "5"]);
    ("f", ["d"], ["5"]);
    ("x", ["c"], ["1"])
]

// Función para generar vecinos
let rec vecinos nodo grafo =
    match grafo with
    | [] -> []
    | (head, neighbors, _)::rest ->
        if head = nodo then neighbors
        else vecinos nodo rest

// Función para extender una ruta
let extender (ruta) (grafo) = 
    List.filter
        (fun x -> x <> [])
        (List.map  (fun x -> if (miembro x ruta) then [] else x::ruta) (vecinos (List.head ruta) grafo)) 

// Función principal de búsqueda en profundidad
let rec prof2 (ini) (fin) (grafo) =
    let rec prof_aux (fin) (ruta) (grafo) =
        if List.isEmpty ruta then []
        elif (List.head (List.head ruta)) = fin then
            List.rev (List.head ruta) :: prof_aux fin ((extender (List.head ruta) grafo) @ (List.tail ruta)) grafo       
        else
            prof_aux fin ((List.tail ruta) @ (extender (List.head ruta) grafo)) grafo
    prof_aux fin [[ini]] grafo

let rec obtener_peso (from) (_to) (grafo) : int =
    match grafo with
    | [] -> 0
    | (head, items, weights)::_ ->
        if head = from then
            let index = List.findIndex (fun x -> x = _to) items
            if (List.item index weights) = "" then 0
            else int (List.item index weights)
        else obtener_peso from _to (List.tail grafo)

let calcular_pesos (rutas) (grafo) : int list =
    let rec calcular_peso (ruta) (grafo) (peso) : int =
        match ruta with
        | [] -> 0
        | [_] -> peso 
        | x::y::rest -> 
            let peso = peso + obtener_peso x y grafo
            calcular_peso (y::rest) grafo peso
    List.map (fun x -> calcular_peso x grafo 0) rutas

let ruta_corta (ini) (fin) (grafo) =
    let rutas = prof2 ini fin grafo
    let pesos = calcular_pesos rutas grafo
    let index = List.findIndex (fun x -> x = List.min pesos) pesos 
    List.item index rutas
