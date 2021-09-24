@LoginSuccessful
Característica: Funcionalidad de Login correcto

Esquema del escenario: Login correcto
Dado el servicio login successful
Cuando ingreso los valores <mail> y <password>
Entonces visualiza mi token
Ejemplos:
| mail                 | password     |
| "eve.holt@reqres.in" | "cityslicka" |