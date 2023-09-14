module Recipientes

// Función para verificar si un elemento está en una lista
let miembro elem lista =
    List.exists (fun x -> x = elem) lista

// Función para eliminar elementos de una lista según un criterio
let remove_if func lista =
    List.filter (fun x -> not (func x)) lista

// Funciones para operar en los recipientes
let vaciar_aa recipiente =
    0 :: (List.tail recipiente)
let vaciar_bb recipiente =
    (List.head recipiente) :: [0]
let llenar_aa recipiente =
    3 :: (List.tail recipiente)
let llenar_bb recipiente =
    (List.head recipiente) :: [5]
let rec pasar_ab recipiente =
    if (List.head recipiente = 0 || (List.head (List.tail recipiente)) = 5) then recipiente
    else pasar_ab ((List.head recipiente - 1) :: [List.item 1 recipiente + 1])
let rec pasar_ba recipiente =
    if (List.item 1 recipiente = 0 || List.head recipiente = 3) then recipiente
    else pasar_ba ((List.head recipiente + 1) :: [List.item 1 recipiente - 1])

// Función para generar vecinos
let vecinos recipiente =
    [
        vaciar_aa recipiente;
        vaciar_bb recipiente;
        llenar_aa recipiente;
        llenar_bb recipiente;
        pasar_ab recipiente;
        pasar_ba recipiente
    ]

// Función para extender una ruta
let extender ruta = 
    List.filter
        (fun x -> x <> [])
        (List.map  (fun x -> if (miembro x ruta) then [] else x::ruta) (vecinos (List.head ruta))) 

// Función para verificar si se alcanza el objetivo
let solucion recipiente objetivo =
    recipiente = objetivo
    
// Función principal de búsqueda en profundidad
let prof recipiente objetivo =
    let rec prof_aux ruta objetivo =
        if List.isEmpty ruta then []
        elif solucion (List.head (List.head ruta)) objetivo then
            List.rev (List.head ruta) //:: prof_aux ((extender (List.head ruta)) @ (List.tail ruta)) objetivo       
        else
            prof_aux ((extender (List.head ruta)) @ (List.tail ruta)) objetivo
    prof_aux [[recipiente]] objetivo



        
    