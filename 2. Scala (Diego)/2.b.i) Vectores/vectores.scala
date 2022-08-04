import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object vectores {

    def producto(x: Int, y: Int): Future[Int] = Future {
        x*y
    }

    def main() : Unit = {
        
        //Vector a = (1, 13 , 21)
        var a = Array(1, 13, 21)

        //Vector b = (5, 2, 12)
        var b = Array(5, 2, 12)
        
        for( i <- 0 to a.length-1){
            val f: Future[Int] = Future{
                producto(a(i),b(i))
            }
            for
            productos <- f
            producto <- productos
        }   suma = suma + producto

        println(suma)

        println(a.mkString(", "))
        println(b.mkString(", "))

    }
}