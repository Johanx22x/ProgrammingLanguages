open RutaCorta

[<EntryPoint>]
let main _ =
    let ruta = solve con_paredes
    printfn "Ruta corta con paredes: %A" ruta

    // Using a one-path function
    let ruta = solve_one_path sin_paredes
    printfn "Primer camino sin paredes: %A" ruta

    // NOTE: This could take some minutes...
    printfn "Calculando la mejor ruta sin paredes... (puede tardar unos minutos)"
    let ruta = solve sin_paredes
    printfn "Ruta corta sin paredes: %A" ruta

    0b0
