import scala.reflect.runtime.universe._

class T[A](implicit val m:TypeTag[A])
class Foo
class Bar extends T[Foo]
object Test extends App {
  new Bar
}

object EvidenceTest {
  trait E[T]
  trait A[T] { implicit val e: E[T] = null }
  class B[T : E] extends A[T] { override val e = null }

  def f[T]: Unit = {
    implicit val e: E[T] = null
    new B[T]{}
  }
}