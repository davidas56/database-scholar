import java.io.IOException;

public class AuthorAPIController {
    private AuthorAPIModel model;

    public AuthorAPIController(AuthorAPIModel model) {
        this.model = model;
    }

    public String getAuthorData(String authorId) throws IOException {
        return model.getAuthorData(authorId);
    }
}
