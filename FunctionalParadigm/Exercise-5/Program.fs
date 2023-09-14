open RutaCorta

[<EntryPoint>]
let main _ =
    let ruta = solve con_paredes
    printfn "Ruta corta con paredes: %A\n" ruta

    // Sin las paredes de 8|14 y 25|26
    let ruta = solve con_pocas_paredes
    printfn "Ruta corta sin las paredes de 8|14 y 25|26: %A\n" ruta

    // Using a one-path function
    let ruta = solve_one_path sin_paredes
    printfn "Primer camino sin paredes encontrado: %A" ruta

    // NOTE: This could take some minutes...
    printfn "Calculando la mejor ruta sin paredes de todas las posibles... (puede tardar unos minutos)"
    let ruta = solve sin_paredes
    printfn "Ruta corta sin paredes: %A" ruta

    0b0
