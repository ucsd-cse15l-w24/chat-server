import static org.junit.Assert.*;
import org.junit.*;
import java.net.URI;

public class HandlerTests {
  @Test
  public void handleRequest1() throws Exception {
    ChatHandler h = new ChatHandler();
    String url = "http://localhost:4000/chat?user=joe&message=hi";
    URI input = new URI(url);
    String expected = "joe: hi\n\n";
    assertEquals(expected, h.handleRequest(input));
  }

  @Test
  public void handleRequestMulti() throws Exception {
    ChatHandler h = new ChatHandler();
    String url1 = "http://localhost:4000/chat?user=onat&message=good%20luck";
    String url2 = "http://localhost:4000/chat?user=edwin&message=with%20your%20demo!";
    URI input1 = new URI(url1);
    URI input2 = new URI(url2);
    String expected = "onat: good luck\n\nedwin: with your demo!\n\n";
    h.handleRequest(input1);
    assertEquals(expected, h.handleRequest(input2));
  }
}
