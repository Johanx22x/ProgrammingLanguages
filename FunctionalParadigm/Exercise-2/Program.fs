let rec sub_cadenas (subcadena: string) (lista: string list) = 
    lista |> List.filter (fun x -> x.Contains(subcadena))

[<EntryPoint>]
let main (args: string array): int =
    let data = ["la casa"; "el perro"; "pintando la cerca"]

    sub_cadenas "la" data |> printfn "%A"
    sub_cadenas "er" data |> printfn "%A"

    0b0