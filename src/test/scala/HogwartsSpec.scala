import org.scalatest.{FunSpec, Matchers}
import ar.edu.unq.o3.{ Efecto, Consultas, Pociones }
import ar.edu.unq.o3.Pociones.{ PersonaWrapper }
import ar.edu.unq.o3.Consultas.{ niveles }

class HogwartsSpec extends FunSpec with Matchers {

  describe("Efectos") {

     describe("duplicar()") {

       it("debe duplicar todos los niveles") {
         val p = ("Hermione", (10, 12, 20))
         Efecto.duplicar(niveles(p)) should equal ((20, 24, 40))
       }

     }

    describe("alMenos7") {

      it("crea un niveles con 7 si son valores menores") {
        val p = ("Hermione", (4, 5, 6))
        Efecto.alMenos7(niveles(p)) should equal ((7, 7, 7))
      }

    }

  }

  describe("Consultas") {

    describe("suma") {
      it("retorna la suma de los niveles") {
        val p = ("Hermione", (4, 5, 6))
        Consultas.suma(niveles(p)) should equal (15)
      }
    }

    describe("max") {
      it("retorna el nivel máximo") {
        val p = ("Hermione", (4, 5, 6))
        Consultas.max(p.niveles) should equal (6)
      }
    }

    describe("min") {
      it("retorna el nivel minimo") {
        val p = ("Hermione", (4, 5, 6))
        Consultas.min(p.niveles) should equal (4)
      }
    }

    describe("diff") {
      it("retorna la diferencia entre al nivel máximo y el mínimo") {
        val p = ("Hermione", (3, 5, 7))
        Consultas.diff(niveles(p)) should equal (7 - 3)
      }
    }

  }

}
