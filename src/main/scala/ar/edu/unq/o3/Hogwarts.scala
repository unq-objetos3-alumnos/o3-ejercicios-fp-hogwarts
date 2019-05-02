package ar.edu.unq.o3

case class Niveles(val suerte: Int, val convencimiento: Int, val fuerza: Int)
case class Persona(val nombre: String, val niveles: Niveles)

// efectos

object Efecto {

  def duplicar: Niveles => Niveles = n => Niveles(n.suerte * 2, n.convencimiento * 2, n.fuerza * 2)

  def alMenos7: Niveles => Niveles = n => {
    val Niveles(suerte, convencimiento, fuerza) = n
    val max = List(suerte, convencimiento, fuerza).max.max(7)
    Niveles(max, max, max)
  }

}