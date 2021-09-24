package preguntas;

import modelos.PostLoginSuccessful.Response.PostLoginSuccessfulResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PostLoginSuccessfulQuestion implements Question<PostLoginSuccessfulResponse> {
    @Override
    public PostLoginSuccessfulResponse answeredBy(Actor actor) {

        return SerenityRest.lastResponse().as(PostLoginSuccessfulResponse.class);

    }
}
