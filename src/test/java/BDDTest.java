import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class BDDTest {

  @Test
  public void replacement_TestForA() {
    BDD yourApp = new BDD();
    String expected = "-s";
    assertEquals(expected, yourApp.replaceLetter("as"));
  }

  @Test
  public void replacement_TestForI() {
    BDD yourApp = new BDD();
    String expected = "-s";
    assertEquals(expected, yourApp.replaceLetter("is"));
  }

  @Test
  public void replacement_TestForO() {
    BDD yourApp = new BDD();
    String expected = "-f";
    assertEquals(expected, yourApp.replaceLetter("of"));
  }

  @Test
  public void replacement_TestForU() {
    BDD yourApp = new BDD();
    String expected = "-pt-wn";
    assertEquals(expected, yourApp.replaceLetter("uptown"));
  }

  @Test
  public void replacement_TestForE() {
    BDD yourApp = new BDD();
    String expected = "-v-rb--rd";
    assertEquals(expected, yourApp.replaceLetter("overboard"));
  }

  @Test
  public void replacement_testForAllAndCaps() {
    BDD yourApp = new BDD();
    String expected = "-D---, B--G--, C--K--, L----, --S--S, J-SS-----N";
    assertEquals(expected, yourApp.replaceLetter("ADIEU, BOUGIE, COOKIE, LOUIE, EASIES, JUSSIEUEAN"));
  }

  @Test
  public void replacement_testFortesttrue() {
    BDD yourApp = new BDD();
    Boolean expected = true;
    assertEquals(expected, yourApp.testTrue("overboard", "Overboard"));
  }

}
