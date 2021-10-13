/**
 * TABLA DE MULTIPLICAR
 * El programa pide una edad y un mes, separado por comas, y devuelve las tablas de multiplicar asignadas a esos valores
 * La edad debe estar comprendida entre 6 y 12, o devolverá un error y terminará.
 * El mes debe estar comprendido entre 1 y 12, o devolverá un error y terminará.
 * Si no se introduce alguno de los valores o el formato no está correcto, el programa devolverá error y terminará.
 * @param entrada es una variable en la que estarán los valores introducidos por teclado como una cadena
 * @param listaEntrada es la lista usada para separar los valores de entrada
 * @param edad es la edad introducida por teclado.
 * @param mes es el mes introducido por teclado.
 *
 *
 */

fun tabla(num: Byte) {
    /**
     * Funcion encargada de devolver las tablas de multiplicar
     * Se introduce un numero y devuelve su tabla de multiplicar.
     * @param num es el numero del que mostraremos su tabla.
     */
    println("TABLA DEL $num")
    println("*".repeat(12))
    for (i in 1..10) {
        println("$num x $i = ${num*i}")
    }
    println("")
}

fun main() {
    print("Introduzca la configuración del programa en este formato: <edadDelAlumno>, <mesActual> ") //Introducimos el numero
    //Declaración de variables, entrada de consola introducida en variable y separada mediante split
    var entrada: String = readLine() ?: ""
    var listaEntrada = entrada.split(",")
    var edad: Byte = 0
    var mes: Byte = 0

    //Comenzamos el programa, mostramos por pantalla el comienzo
    println("*".repeat(80))
    println("PROGRAMA DE GENERACIÓN DE TABLAS: José Flor González")
    println("_".repeat(80))

    // Si no se han introducido dos valores, devuelve error y termina el programa
    if (listaEntrada.size != 2) {
        println("La entrada no es correcta.")
        println("*".repeat(80))
    }
    // Si se han introducido dos valores, los incluimos en sus respectivas variables y continuamos la ejecucion
    else {
        edad = try {listaEntrada[0].trim().toByte()} catch (_: Exception) {-1} //Handler para edad
        mes = try {listaEntrada[1].trim().toByte()} catch (_: Exception) {-1} // Handler para mes

        if (edad <= 0 || mes <= 0) { // Si los valores son menores de 1 (debido al handler), devuelve error y finaliza el programa
            println("La entrada no es correcta.")
            println("_".repeat(80))
        }
        else if (mes !in 1..12) { //Si el mes introducido no esta en entre 1 y 12, devuelve un error y finaliza el programa
            println("Mes: $mes. El mes es erróneo.")
            println("_".repeat(80))
        }
        else { //Si supera las dos comprobaciones anteriores, continuamos la ejecucion
            when {
                // Si la edad esta comprendida entre 6 y 8 años, ambos incluidos, entraremos en la franja de 6 a 8 años.
                edad in 6..8 -> {
                    println("Edad: $edad. El alumno está dentro del rango [6-8]")

                    //Si el mes es par, devuelve las tablas del 2 y 4.
                    if (mes % 2 == 0) {
                        println("Mes: $mes. El mes es par, corresponden las tablas siguientes: {2,4}.")
                        println("_".repeat(80))
                        tabla(2)
                        tabla(4)
                    }
                    //Si el mes es impar, devuelve las tablas del 1, 3 y 5.
                    else {
                        println("Mes: $mes. El mes es impar, corresponden las tablas siguientes: {1,3,5}.")
                        println("_".repeat(80))
                        tabla(1)
                        tabla(3)
                        tabla(5)
                    }
                }
                //Si la franja de edad es superior a 8 y menor o igual que 10, entramos en la franja de 9 a 10 años.
                edad in 9..10 -> {
                    println("Edad: $edad. El alumno está dentro del rango [9-10]")
                    // Si el mes es par, mostraremos las tablas del 6,8 y 10.
                    if (mes % 2 == 0) {
                        println("Mes: $mes. El mes es par, corresponden las tablas siguientes: {6,8,10}.")
                        println("_".repeat(80))
                        tabla(6)
                        tabla(8)
                        tabla(10)
                    } //Si el mes es impar, mostraremos las tablas del 7 y 9.
                    else {
                        println("Mes: $mes. El mes es impar, corresponden las tablas siguientes: {7,9}.")
                        println("_".repeat(80))
                        tabla(7)
                        tabla(9)
                    }
                }
                // Si la edad está comprendida entre 11 y 12 años, entramos en la franja de 11 a 12.
                edad in 11..12 -> {
                    //No hay comprobación de mes porque para esta franja se muestran las mismas tablas, sea par o no.
                    println("Edad: $edad. El alumno está dentro del rango [11-12]")
                    println("Mes: $mes. El mes es par, corresponden las tablas siguientes: {11,12,13}.")
                    println("_".repeat(80))
                    tabla(11)
                    tabla(12)
                    tabla(13)
                }
                // Si la edad introducida no entra en ninguna de las condiciones anteriores,
                // se devolverá un error y se finalizará el programa.
                else -> {
                    println("Edad: $edad. No se contempla esta edad")
                    println("_".repeat(80))
                }

            }
            println("*".repeat(80))
            // Fin del programa
            /* Me habría gustado incluir un pequeño sleep para reducir la velocidad de muestra de las tablas,
                pero no estoy seguro de como es exactamente la función por lo que lo dejo así.
             */
        }
    }
}