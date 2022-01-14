package com.example.Proyecto.First.Commit.security.service.login;
import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;

public class SendEmailImpl implements SendEmail {

    private final String sparkPostAPYKEY = System.getenv().get("SPARKPOST_API_KEY");

    @Override
    public void sendEmail(String code, String email) throws SparkPostException {


        String texto ="Por este medio se le solicita introduzca el siguiente código\n " +
        code +   "\npara poder restablecer su contraseña\n" +
                "Este correo no puede ser respondido";

        String API_KEY = sparkPostAPYKEY;
        Client client = new Client(API_KEY);
        client.sendMessage(
                "pfcverifypassword@pfc.betty-openbootcamp.fun",
                email,
                "Solicitud de Recuperación de Contraseña",
                "",
                texto);


    }

}
