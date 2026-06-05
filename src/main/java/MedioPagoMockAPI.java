import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Random;
import java.util.UUID;

@Path("/pagos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MedioPagoMockAPI {

    private final Random random = new Random();

    @POST
    public Response autorizarPago(String jsonRequest) {
        int probabilidad = random.nextInt(4);

        if (probabilidad < 2) {
            String codigoAutorizacion = UUID.randomUUID().toString();
            return Response.status(Response.Status.OK)
                    .entity("{\"status\":\"APROBADO\", \"codigoAutorizacion\":\"" + codigoAutorizacion + "\"}")
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Fondos insuficientes o tarjeta denegada.")
                    .build();
        }
    }
}