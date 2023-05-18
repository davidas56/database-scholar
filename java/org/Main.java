// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
            AuthorAPIModel model = new AuthorAPIModel("209ecdda7b297c929375d5e62924dee71194016f9c5eff742ecfeed2df72b4c2");
            AuthorAPIController controller = new AuthorAPIController(model);
            AuthorAPIView view = new AuthorAPIView(controller);
            view.display();
        }
    }