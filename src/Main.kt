class Coche(
    val marca: String,
    val modelo: String,
    val caballos: Int,
    val puertas: Int,
    val matricula: String,
    var color: String
) {
    init {
        require(marca.isNotBlank()) { "La marca no puede ser nula ni vacía" }
        require(modelo.isNotBlank()) { "El modelo no puede ser nulo ni vacío" }
        require(caballos in 70..700) { "El número de caballos debe estar entre 70 y 700" }
        require(puertas in 3..5) { "El número de puertas debe estar entre 3 y 5" }
        require(matricula.length == 7) { "La matrícula debe tener exactamente 7 caracteres" }
        require(color.isNotBlank()) { "El color no puede ser nulo ni vacío" }
    }

    val marcaCapitalizada: String
        get() = marca.replaceFirstChar { it.uppercase() }

    val modeloCapitalizado: String
        get() = modelo.replaceFirstChar { it.uppercase() }

    override fun toString(): String {
        return "Coche(marca='${marcaCapitalizada}', modelo='${modeloCapitalizado}', caballos=$caballos, puertas=$puertas, matricula='$matricula', color='$color')"
    }
}

fun main() {
    try {
        val coche1 = Coche("Toyota", "Corolla", 150, 4, "1234567", "Rojo")
        println(coche1)
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche1: ${e.message}")
    }

    try {
        val coche2 = Coche("", "Corolla", 150, 4, "1234567", "Azul")
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche2: ${e.message}")
    }

    try {
        val coche3 = Coche("Toyota", "", 150, 4, "1234567", "Negro")
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche3: ${e.message}")
    }

    try {
        val coche4 = Coche("Toyota", "Corolla", 50, 4, "1234567", "Verde")
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche4: ${e.message}")
    }

    try {
        val coche5 = Coche("Toyota", "Corolla", 150, 6, "1234567", "Blanco")
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche5: ${e.message}")
    }

    try {
        val coche6 = Coche("Toyota", "Corolla", 150, 4, "1234", "Gris")
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche6: ${e.message}")
    }

    try {
        val coche7 = Coche("Toyota", "Corolla", 150, 4, "1234567", "Negro")
        coche7.color = ""
    } catch (e: IllegalArgumentException) {
        println("Error al modificar el color de coche7: ${e.message}")
    }
}
