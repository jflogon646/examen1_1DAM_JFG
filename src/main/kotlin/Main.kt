/**
 * TABLA DE MULTIPLICAR
 * El programa pide una edad y un mes, separado por comas, y devuelve las tablas de multiplicar asignadas a esos valores
 * La edad debe estar comprendida entre 6 y 12, o devolverá un error y terminará.
 * El mes debe estar comprendido entre 1 y 12, o devolverá un error y terminará.
 * Si no se introduce alguno de los valores o el formato no esta correcto, el programa devolverá error y terminará.
 * @param entrada es una variable en la estarán los valores introducidos por teclado como una cadena
 * @param ListaEntrada es la lista usada para separar los valores de entrada
 * @param edad es la edad introducida por teclado.
 * @param mes es el mes introducido por teclado.
 *
 *
 */

fun Tabla(num: Byte) {
    /**
     * Funcion encargada de devolver las tablas de multiplicar
     * Se introduce un numero y devuelve su tabla de multiplicar.
     * @param num es el numero del que mostraremos su tabla.
     */
    println("*".repeat(12))
    println(" TABLA DEL $num ")
    println("*".repeat(12))
    for (i in 1..10) {
        println(" $num x $i = ${num*i}")
    }


}

fun main() {
    print("Introduzca los valores deseados (en formato \"año,mes\"): ") //Introducimos el numero
    //Declaracion de variables, entrada de consola introducida en variable y separada mediante split
    var entrada: String = readLine() ?: ""
    var ListaEntrada = entrada.split(",")
    var edad: Byte = 0
    var mes: Byte = 0

    //Comenzamos el programa
    println("*".repeat(36) + " INICIO " + "*".repeat(36))
    println("PROGRAMA DE GENERACIÓN DE TABLAS: José Flor González")
    println("_".repeat(85))

    // Si no se han introducido dos valores, devuelve error y termina el programa
    if (ListaEntrada.size != 2) {
        println("La entrada de valores escogida no es correcta.")
        println("*".repeat(31) + " FIN DEL PROGRAMA " + "*".repeat(31))
    }
    // Si se han introducido dos valores, los incluimos en sus respectivas variables y continuamos la ejecucion
    else {
        edad = try {ListaEntrada[0].trim().toByte()} catch (_: Exception) {-1} //Handler para edad
        mes = try {ListaEntrada[1].trim().toByte()} catch (_: Exception) {-1} // Handler para mes

        if (edad <= 0 || mes <= 0) { // Si los valores son menores de 1 (debido al handler), devuelve error y finaliza el programa
            println("La entrada de valores escogida no es correcta.")
            println("*".repeat(31) + " FIN DEL PROGRAMA " + "*".repeat(31))
        }
        else if (mes !in 1..12) { //Si el mes introducido no esta en entre 1 y 12, devuelve un error y finaliza el programa
            println("El mes introducido no es válido.")
            println("Mes: Desde 1 (Enero) hasta 12 (Diciembre)") // Ayuda para ejecutar bien el programa, anunciando los limites en los valores
        }
        else { //Si supera las dos comprobaciones anteriores, continuamos la ejecucion
            when {
                // Si la edad esta comprendida entre 6 y 8 años, ambos incluidos, entraremos en la franja de 6 a 8 años.
                edad in 6..8 -> {
                    println("Edad: $edad. Franja de [6 a 8] años.")

                    //Si el mes es par, devuelve las tablas del 2 y 4.
                    if (mes % 2 == 0) {
                        println("Mes: $mes. Par, corresponden las tablas {2,4}.")
                        Tabla(2)
                        Tabla(4)
                        println("*".repeat(20))
                    }
                    //Si el mes es impar, devuelve las tablas del 1, 3 y 5.
                    else {
                        println("Mes: $mes. Impar, corresponden las tablas {1,3,5}.")
                        Tabla(1)
                        Tabla(3)
                        Tabla(5)
                        println("*".repeat(20))
                    }
                }
                //Si la franja de edad es superior a 8 y menor o igual que 10, entramos en la franja de 9 a 10 años.
                edad in 9..10 -> {
                    println("Edad: $edad. Franja de [9 a 10] años")
                    // Si el mes es par, mostraremos las tablas del 6,8 y 10.
                    if (mes % 2 == 0) {
                        println("Mes: $mes. Par, corresponden las tablas {6,8,10}.")
                        Tabla(6)
                        Tabla(8)
                        Tabla(10)
                        println("*".repeat(20))
                    } //Si el mes es impar, mostraremos las tablas del 7 y 9.
                    else {
                        println("Mes: $mes. Impar, corresponden las tablas {7,9}.")
                        Tabla(7)
                        Tabla(9)
                        println("*".repeat(20))
                    }
                }
                // Si la edad está comprendida entre 11 y 12 años, entramos en la franja de 11 a 12.
                edad in 11..12 -> {
                    //No hay comprobación de mes porque para esta franja se muestran las mismas tablas, sea par o no.
                    println("Edad: $edad. Franja de [11 a 12] años")
                    println("Mes: $mes. Corresponden las tablas {11,12,13}.")
                    Tabla(11)
                    Tabla(12)
                    Tabla(13)
                    println("*".repeat(20))
                }
                // Si la edad introducida no entra en ninguna de las condiciones anteriores,
                // se devolverá un error y se finalizará el programa.
                else -> {
                    println("La edad introducida no está dentro de los límites establecidos")
                    println("Edad: desde 6 años hasta los 12 años") //Muestra la franja de edad correcta para su funcionamiento
                }

            }
            println("*".repeat(31) + " FIN DEL PROGRAMA " + "*".repeat(31))
            // Fin del programa
        }
    }
}