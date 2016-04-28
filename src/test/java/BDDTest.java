import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class BDDTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Word Puzzle");
  }

  @Test
  public void check_Replacement() {
  goTo("http://localhost:4567");
  fill("#sentence").with("hey");
  submit(".btn");
  assertThat(pageSource()).contains("h-y");
  }

  @Test
  public void check_Replacement_ToUpperCase() {
  goTo("http://localhost:4567");
  fill("#sentence").with("BILLY GOAT");
  submit(".btn");
  assertThat(pageSource()).contains("B-LLY G--T");
  }

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
  public void toUpperCase_Test() {
    BDD yourApp = new BDD();
    String expected = "awesome";
    assertEquals(expected,
    yourApp.setLowerCase("AWESOME"));
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
