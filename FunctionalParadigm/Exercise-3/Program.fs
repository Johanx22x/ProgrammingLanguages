let nthElement (n) (xs) : Option<'a> =
    let indexes = List.init (List.length xs) (fun x -> x)
    let mapped = List.map2 (fun x y -> if x = n then [y] else []) indexes xs
    let flattened = List.concat mapped
    flattened |> function
    | [] -> None
    | x :: xs -> Some x

[<EntryPoint>]
let main (args: string array): int =
    nthElement 2 [1;2;3;4;5] |> printfn "%A"
    nthElement 3 [1;2;3;4;5] |> printfn "%A"
    nthElement 6 [1;2;3;4;5] |> printfn "%A"

    0b0