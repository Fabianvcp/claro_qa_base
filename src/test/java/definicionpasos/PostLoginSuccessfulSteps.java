package definicionpasos;

import io.cucumber.java.es.*;
import modelos.PostLoginSuccessful.Response.PostLoginSuccessfulResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;
import preguntas.PostLoginSuccessfulQuestion;
import tareas.PostLoginSuccessfulTask;
import utiles.Constantes;

public class PostLoginSuccessfulSteps {
    private Actor actor;

    @Dado("el servicio login successful")
    public void el_servicio_login_successful() {
        this.actor = new Actor("Celeste");

        this.actor.whoCan(CallAnApi.at(Constantes.URl_API));
    }

    @Cuando("ingreso los valores {string} y {string}")
    public void ingreso_los_valores_y(String usuario, String password) {
        this.actor.attemptsTo(
                PostLoginSuccessfulTask.con(usuario, password)
        );

        this.actor.should(
                GivenWhenThen.seeThat("El status code es 200",
                        code -> SerenityRest.lastResponse().statusCode(),
                        IsEqual.equalTo(200)
                )
        );
    }

    @Entonces("visualiza mi token")
    public void visualiza_mi_token() {
        PostLoginSuccessfulResponse response = new PostLoginSuccessfulQuestion().answeredBy(this.actor);

        this.actor.should(
                GivenWhenThen.seeThat("El token no es nulo",
                        t -> response.getToken(),
                        IsNull.notNullValue()
                )
        );
    }
}
