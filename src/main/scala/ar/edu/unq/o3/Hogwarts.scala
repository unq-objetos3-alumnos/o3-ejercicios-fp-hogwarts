package ar.edu.unq.o3

object Pociones {
  type Niveles = (Int, Int, Int)
  type Efecto = Niveles => Niveles
  type EfectoSobreNivel = Int => Int

  type Persona = (String, Niveles)


  implicit class NivelesWrapper(n: Niveles) {
    def suerte = n._1
    def convencimiento = n._2
    def fuerza = n._3
  }

  implicit class PersonaWrapper(n: Persona) {
    def niveles = n._2
  }

}

// efectos

object Efecto {
  import Pociones.{ Efecto, Niveles, EfectoSobreNivel, NivelesWrapper }

  def mapNiveles(fn: EfectoSobreNivel)(n: Niveles) = (fn(n.suerte), fn(n.convencimiento), fn(n.fuerza))

  def duplicar: Efecto = mapNiveles(n => n * 2)
  def alMenos7: Efecto = mapNiveles(_.max(7))

}

object Consultas {
  import Pociones.{ Niveles, Persona }

  type Operacion = Niveles => Int

  def derivar(ops: Operacion*)(n: Niveles) : List[Int] = ops.toList.map(op => op(n))
  def substract: List[Int] => Int = values => values.reduceRight((b, a) => b - a)

  def toList: (Niveles) => List[Int] = n => n.productIterator.toList.asInstanceOf[List[Int]]

  def suma = toList.andThen(_.sum)
  def max = toList.andThen(_.max)
  def min = toList.andThen(_.min)

  def diff: Niveles => Int = substract.compose(derivar(max, min)(_))

  // sobre personas

  def niveles = (p: Persona) => p._2
  def sumaNiveles(p: Persona) = niveles.andThen(suma)
}