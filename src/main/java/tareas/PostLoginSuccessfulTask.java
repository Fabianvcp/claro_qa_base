package tareas;

import io.restassured.http.ContentType;
import modelos.PostLoginSuccessful.Request.PostLoginSuccessfulRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostLoginSuccessfulTask implements Task {
   //se envia request
    private final PostLoginSuccessfulRequest request;
    //constructor
    public PostLoginSuccessfulTask( String usuario, String password) {
        this.request = new PostLoginSuccessfulRequest(usuario,password);
    }
    public static Performable con( String usuario, String password){
        return instrumented(PostLoginSuccessfulTask.class, usuario, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        //el actor que va hacer
        actor.attemptsTo(
                Post.to("/login").with(
                        requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                                .body(this.request)
                )
        );

    }
}
