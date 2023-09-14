let rec shiftLeft (n: int) (xs: int list) =
    match n, xs with
    | 0, _ -> xs
    | _, [] -> []
    | _, x::xs -> shiftLeft (n-1) (xs @ [0])

let rec shiftRight (n: int) (xs: int list) =
    match n, xs with
    | 0, _ -> xs
    | _, [] -> []
    | _, xs -> shiftRight (n-1) ([0] @ (List.take (List.length xs - 1) xs))

let shift (dir: string) (n: int) (xs: int list) =
    match dir with
    | "izq" -> shiftLeft n xs
    | "der" -> shiftRight n xs
    | _ -> []

[<EntryPoint>]
let main (args: string array): int =
    shift "izq" 3 [1;2;3;4;5] |> printfn "%A"
    shift "der" 2 [1;2;3;4;5] |> printfn "%A"
    shift "izq" 6 [1;2;3;4;5] |> printfn "%A"

    0b0