import org.scalatest.{FunSpec, Matchers}
import ar.edu.unq.o3.{ Persona, Efecto, Consultas }

class HogwartsSpec extends FunSpec with Matchers {

  describe("Efectos") {

     describe("duplicar()") {

       it("debe duplicar todos los niveles") {
         val p = new Persona("Hermione", (10, 12, 20))
         Efecto.duplicar(p.niveles) should equal ((20, 24, 40))
       }

     }

    describe("alMenos7") {

      it("crea un niveles con 7 si son valores menores") {
        val p = new Persona("Hermione", (4, 5, 6))
        Efecto.alMenos7(p.niveles) should equal ((7, 7, 7))
      }

    }

  }

  describe("Consultas") {

    describe("suma") {

      it("retorna la suma de los niveles") {
        val p = new Persona("Hermione", (4, 5, 6))
        Consultas.suma(p.niveles) should equal (15)
      }

    }

  }

}
